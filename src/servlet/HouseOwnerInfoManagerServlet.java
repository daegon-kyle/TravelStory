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
		 
		
		if(action.equals("houseRegistration"))//��ũ�� ���������� ��û
		{
			houseOwnerCheck(request, response); //��ϵ� ȸ������ Ȯ���Ѵ�
		}
		else if(action.equals("houseAdd"))//ù������(���ȭ��) hotelfirstPage���� ��û ���ھ�ü����� ��û�ϴ�
		{
			RequestDispatcher rd=request.getRequestDispatcher("/page/houseRegistration.jsp"); //������������� �̵�
			rd.forward(request, response);
		}
		else if(action.equals("houseDelete"))//���������� ��û
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
		 
		
		if(action.equals("houseModify"))//������ ���� ��û
		{
			houseOwnerModify(request, response);
		}
		else if(action.equals("houseFormAdd"))//��������� ��������� ��� �ۼ� �� ���� ��û
		{
			houseOwnerAdd(request, response); //(houseRegistration���������� ��û)����� ���� ����� ��û�Ѵ�
		}		
	}
	
	private void houseOwnerCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String dispatchUrl=null;
		
		
		
		HttpSession session=request.getSession();
		String houseOwnerCode=null;
		
		houseOwnerCode=(String)session.getAttribute("houseOwnerCode");
		  
		System.out.println("hosueOwnerCode"+houseOwnerCode);
		
		
		if(houseOwnerCode!=null) // ��ϵ� ���
		{ 
			setModifyForm(request, response);
		}
		else //��ϵ��� �������
		{
			if(session.getAttribute("memberCode")==null)
				dispatchUrl="/page/memberJoin";
			else
			{
				dispatchUrl="/page/housefirstPage.jsp"; //��������� ù������
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
		
		if(checkList.size()!=0) //��ȿ���˻��� ������ ������
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
			
			if(houseOwnerInfoManager.addHouseOwnerInfo(memberCode)) //�����ε���� ������ ���
			{
				String houseOwnerCode=loginManager.getHouseOwnerCode(memberCode);
				
				request.setAttribute("HouseSaveResult", "������ ��� ����!");
				
				session.setAttribute("houseOwnerCode", houseOwnerCode); //�������ڵ带 ���ǿ� ����
			 
				setModifyForm(request, response);//�����ΰ��������� �ּҷ� �̵�
			}
			else//������ ��� ������ ���
			{
				request.setAttribute("HouseSaveResult", "������ ��Ͽ� �����Ͽ����ϴ�. �ٽ� �õ��� �ֽʽÿ�");
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
		
		if(houseOwnerInfoManager.deleteHouseOwnerInfo(houseOwnerCode))//���� ������
		{
			request.setAttribute("deleteResult", "������ ������ �����Ͽ����ϴ�!");
			session.removeAttribute("houseOwnerCode");
			dispatchUrl="/page/housefirstPage.jsp";
		}
		else//���� ���н�
		{
			request.setAttribute("deleteResult", "������ ���� �����Ͽ����ϴ�. �ٽ� �õ��Ͻʽÿ�");
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
		
		if(checkList.size()!=0) //��ȿ���˻��� ������ ������
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
			
			if(houseOwnerInfoManager.modifyHouseOwnerInfo(houseOwnerCode)) //�����μ����� ������ ���
			{				
				request.setAttribute("HouseSaveResult", "������ ���� ����!");
 
				setModifyForm(request, response);
			}
			else//������ ���� ������ ���
			{
				request.setAttribute("HouseSaveResult", "������ ������ �����Ͽ����ϴ�. �ٽ� �õ��� �ֽʽÿ�");
 
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
		houseOwnerEssentialInfo=houseOwnerInfoManager.getHouseOwnerInfo(houseOwnerCode); //������ ������������
		
		
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
		rd.forward(request, response);//������������ũ
	}
}
