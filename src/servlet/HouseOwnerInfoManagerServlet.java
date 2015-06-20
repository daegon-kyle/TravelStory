package servlet;

import java.io.IOException; 
import java.util.StringTokenizer;
import java.util.List;
import manager.HouseOwnerInfoManager;
import javax.servlet.http.HttpSession;
import converter.ConvertGregorianCalendar;
import validator.HouseOwnerEssentialInfoValidator;
import model.HouseOwnerEssentialInfo;
import form.HouseOwnerEssentialInfoForm;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 
import java.text.SimpleDateFormat;
import manager.LoginManager;

@WebServlet(name="/HouseOwnerInfoManagerServlet", urlPatterns={"/page/houseRegistration", "/page/houseFormAdd", "/page/houseAdd", "/page/houseManage", "/page/houseDelete", "/page/houseModify"})

public class HouseOwnerInfoManagerServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("utf-8");
		
		String uri=request.getRequestURI();
		
		int lastIndex=uri.lastIndexOf("/");
		String action=uri.substring(lastIndex+1);
		 
		
		if(action.equals("houseRegistration"))//링크로 집정보관리 요청
		{
			houseOwnerCheck(request, response); //등록된 회원인지 확인한다
		}
		else if(action.equals("houseAdd"))//첫페이지(등록화면) hotelfirstPage에서 요청 숙박업체등록을 요청하다
		{
			RequestDispatcher rd=request.getRequestDispatcher("/page/houseRegistration.jsp"); //집등록페이지로 이동
			rd.forward(request, response);
		}
		else if(action.equals("houseDelete"))//집정보삭제 요청
		{
			houseOwnerDelete(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("utf-8");
		
		String uri=request.getRequestURI();
		
		int lastIndex=uri.lastIndexOf("/");
		String action=uri.substring(lastIndex+1);
		 
		
		if(action.equals("houseModify"))//집정보 수정 요청
		{
			houseOwnerModify(request, response);
		}
		else if(action.equals("houseFormAdd"))//집정보등록 양식폼에서 양식 작성 후 저장 요청
		{
			houseOwnerAdd(request, response); //(houseRegistration페이지에서 요청)양식을 적고 등록을 요청한다
		}		
	}
	
	private void houseOwnerCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String dispatchUrl=null;
		
		
		
		HttpSession session=request.getSession();
		String houseOwnerCode=null;
		
		houseOwnerCode=(String)session.getAttribute("houseOwnerCode");
		  
		System.out.println("hosueOwnerCode"+houseOwnerCode);
		
		
		if(houseOwnerCode!=null) // 등록된 경우
		{ 
			setModifyForm(request, response);
		}
		else //등록되지 않은경우
		{
			if(session.getAttribute("memberCode")==null)
				dispatchUrl="/page/memberJoin";
			else
			{
				dispatchUrl="/page/housefirstPage.jsp"; //집정보등록 첫페이지
			}
			
		}
		
		if(dispatchUrl!=null)
		{
			RequestDispatcher rd=request.getRequestDispatcher(dispatchUrl);
			rd.forward(request, response);
		}
	}
	
	private void houseOwnerAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String dispatchUrl=null;
		
		String address=request.getParameter("address");
		String visitStartDate=request.getParameter("visitStartDate");
		String visitEndDate=request.getParameter("visitEndDate");
		String job=request.getParameter("job");
		String marriedState=request.getParameter("marriedState");
		String selfIntroduction=request.getParameter("selfIntroduction");
		String etc=request.getParameter("etc");
		
		StringTokenizer stok=new StringTokenizer(visitStartDate, "-");
		visitStartDate=Integer.parseInt(stok.nextToken())+"/"+Integer.parseInt(stok.nextToken())+"/"+Integer.parseInt(stok.nextToken());
		
		stok=new StringTokenizer(visitEndDate, "-");
		visitEndDate=Integer.parseInt(stok.nextToken())+"/"+Integer.parseInt(stok.nextToken())+"/"+Integer.parseInt(stok.nextToken());
		
		HouseOwnerEssentialInfoForm houseOwnerEssentialInfoForm=new HouseOwnerEssentialInfoForm(address, visitStartDate, visitEndDate, job, marriedState, selfIntroduction, etc);
		HouseOwnerEssentialInfoValidator houseOwnerEssentialInfoValidator=new HouseOwnerEssentialInfoValidator(houseOwnerEssentialInfoForm);
		
		List<String> checkList=houseOwnerEssentialInfoValidator.validate();
		
		if(checkList.size()!=0) //유효성검사결과 문제가 있을시
		{
			request.setAttribute("problems", checkList);
			dispatchUrl="/page/houseRegistration.jsp";
		}
		else
		{
			ConvertGregorianCalendar convertCalendar=new ConvertGregorianCalendar();
			HouseOwnerEssentialInfo houseOwnerEssentialInfo=new HouseOwnerEssentialInfo(address, convertCalendar.convert(visitStartDate), convertCalendar.convert(visitEndDate), job, marriedState, selfIntroduction, etc);
			
			HouseOwnerInfoManager houseOwnerInfoManager=new HouseOwnerInfoManager(houseOwnerEssentialInfo);
			LoginManager loginManager=new LoginManager();
			HttpSession session=request.getSession();
			String memberCode=(String)session.getAttribute("memberCode");
			
			if(houseOwnerInfoManager.addHouseOwnerInfo(memberCode)) //집주인등록이 성공한 경우
			{
				String houseOwnerCode=loginManager.getHouseOwnerCode(memberCode);
				
				request.setAttribute("HouseSaveResult", "집정보 등록 성공!");
				
				session.setAttribute("houseOwnerCode", houseOwnerCode); //집주인코드를 세션에 저장
			 
				setModifyForm(request, response);//집주인관리페이지 주소로 이동
			}
			else//집정보 등록 실패한 경우
			{
				request.setAttribute("HouseSaveResult", "집정보 등록에 실패하였습니다. 다시 시도해 주십시오");
				dispatchUrl="/page/housefirstPage.jsp";
			}	
		}
		
		if(dispatchUrl!=null)
		{
			RequestDispatcher rd=request.getRequestDispatcher(dispatchUrl);
			rd.forward(request, response);
		}
	}
	
	private void houseOwnerDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String dispatchUrl=null;
		
		HttpSession session=request.getSession();
		String houseOwnerCode=(String)session.getAttribute("houseOwnerCode");
		 
		
		HouseOwnerInfoManager houseOwnerInfoManager=new HouseOwnerInfoManager();
		
		if(houseOwnerInfoManager.deleteHouseOwnerInfo(houseOwnerCode))//삭제 성공시
		{
			request.setAttribute("deleteResult", "집정보 삭제에 성공하였습니다!");
			session.removeAttribute("houseOwnerCode");
			dispatchUrl="/page/housefirstPage.jsp";
		}
		else//삭제 실패시
		{
			request.setAttribute("deleteResult", "집정보 삭제 실패하였습니다. 다시 시도하십시오");
			dispatchUrl="/page/houseManage.jsp";
		}
		
		if(dispatchUrl!=null)
		{
			RequestDispatcher rd=request.getRequestDispatcher(dispatchUrl);
			rd.forward(request, response);
		}
	}
	
	private void houseOwnerModify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String dispatchUrl=null;
		
		String address=request.getParameter("address");
		String visitStartDate=request.getParameter("visitStartDate");
		String visitEndDate=request.getParameter("visitEndDate");
		String job=request.getParameter("job");
		String marriedState=request.getParameter("marriedState");
		String selfIntroduction=request.getParameter("selfIntroduction");
		String etc=request.getParameter("etc");
		
		StringTokenizer stok=new StringTokenizer(visitStartDate, "-");
		visitStartDate=Integer.parseInt(stok.nextToken())+"/"+Integer.parseInt(stok.nextToken())+"/"+Integer.parseInt(stok.nextToken());
		
		stok=new StringTokenizer(visitEndDate, "-");
		visitEndDate=Integer.parseInt(stok.nextToken())+"/"+Integer.parseInt(stok.nextToken())+"/"+Integer.parseInt(stok.nextToken());
		
		HouseOwnerEssentialInfoForm houseOwnerEssentialInfoForm=new HouseOwnerEssentialInfoForm(address, visitStartDate, visitEndDate, job, marriedState, selfIntroduction, etc);
		HouseOwnerEssentialInfoValidator houseOwnerEssentialInfoValidator=new HouseOwnerEssentialInfoValidator(houseOwnerEssentialInfoForm);
		
		List<String> checkList=houseOwnerEssentialInfoValidator.validate();
		
		if(checkList.size()!=0) //유효성검사결과 문제가 있을시
		{
			request.setAttribute("problems", checkList); 
			setModifyForm(request, response);
		}
		else
		{ 
			ConvertGregorianCalendar convertCalendar=new ConvertGregorianCalendar();
			HouseOwnerEssentialInfo houseOwnerEssentialInfo=new HouseOwnerEssentialInfo(address, convertCalendar.convert(visitStartDate), convertCalendar.convert(visitEndDate), job, marriedState, selfIntroduction, etc);
			
			HouseOwnerInfoManager houseOwnerInfoManager=new HouseOwnerInfoManager(houseOwnerEssentialInfo);
			LoginManager loginManager=new LoginManager();
			HttpSession session=request.getSession();
			String houseOwnerCode=(String)session.getAttribute("houseOwnerCode");
			
			if(houseOwnerInfoManager.modifyHouseOwnerInfo(houseOwnerCode)) //집주인수정이 성공한 경우
			{				
				request.setAttribute("HouseSaveResult", "집정보 수정 성공!");
 
				setModifyForm(request, response);
			}
			else//집정보 수정 실패한 경우
			{
				request.setAttribute("HouseSaveResult", "집정보 수정에 실패하였습니다. 다시 시도해 주십시오");
 
				setModifyForm(request, response);
			}	
		}
		
 
	}
	
	private void setModifyForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session=request.getSession();
		String houseOwnerCode=null;
		
		houseOwnerCode=(String)session.getAttribute("houseOwnerCode");
		 
		HouseOwnerInfoManager houseOwnerInfoManager=new HouseOwnerInfoManager();
		
		HouseOwnerEssentialInfo houseOwnerEssentialInfo=new HouseOwnerEssentialInfo();
		houseOwnerEssentialInfo=houseOwnerInfoManager.getHouseOwnerInfo(houseOwnerCode); //본인의 집정보가져옴
		
		
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
 
		String address=houseOwnerEssentialInfo.getAddress();
		String visitStartDate=simple.format(houseOwnerEssentialInfo.getVisitStartDate().getTime());
		String visitEndDate=simple.format(houseOwnerEssentialInfo.getVisitEndDate().getTime());
		String job=houseOwnerEssentialInfo.getJob();
		String marriedState=houseOwnerEssentialInfo.getMarriedState();
		String selfIntroduction=houseOwnerEssentialInfo.getSelfIntroduction();
		String etc=houseOwnerEssentialInfo.getEtc();
 
		
		request.setAttribute("address", address);
		request.setAttribute("visitStartDate", visitStartDate);
		request.setAttribute("visitEndDate", visitEndDate);
		request.setAttribute("job", job);
		request.setAttribute("marriedState", marriedState);
		request.setAttribute("selfIntroduction", selfIntroduction);
		request.setAttribute("etc", etc);
		
		RequestDispatcher rd=request.getRequestDispatcher("/page/houseManage.jsp");
		rd.forward(request, response);//관리페이지링크
	}
}
