package servlet;

import java.io.IOException;
import java.util.List;
import model.HotelInfo;
import manager.HotelInfoRegistrationManager;
import manager.LoginManager;
import form.HotelInfoForm;
import validator.HotelInfoValidator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class HotelInfoRegistrationServlet
 */
@WebServlet(name="HotelInfoRegistrationServlet", urlPatterns={"/page/hotelRegistration", "/page/hotelFormAdd", "/page/hotelAdd"})
public class HotelInfoRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("utf-8");
		
		String uri=request.getRequestURI();
		
		int lastIndex=uri.lastIndexOf("/");
		String action=uri.substring(lastIndex+1);
		 
		
		if(action.equals("hotelAdd"))//(hotelfirstPage에서 요청 숙박업체등록을 요청하다
		{
			hotelManagerCheck(request, response); //등록된 회원인지 확인한다
		}
		else if(action.equals("hotelRegistration"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("/page/hotelfirstPage.jsp");
			rd.forward(request, response);
		}	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("utf-8");
		hotelManagerAdd(request, response);//(hotelRegistration 페이지에서 요창)양식을 적고 등록을 요청한다
	}
	private void hotelManagerCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String dispatchUrl=null;

		 
		HttpSession session=request.getSession();
		String memberCode=(String)session.getAttribute("memberCode");
		String hotelManagerCode=(String)session.getAttribute("hotelManagerCode");
		
		if(hotelManagerCode!=null) //등록된 경우
		{
			request.setAttribute("HotelSaveFail", "이미 숙박업체 등록하였습니다. 공실관리페이지를 이용하십시오");
			dispatchUrl="/page/EmptyRoomInfoManager"; //공실관리페이지링크
			System.out.println("이미등록회원 공실관리페이지로이동");
		}
		else //신규등록
		{
			if(memberCode==null) 
				dispatchUrl="/page/memberJoin";
			else
			{
				dispatchUrl="/page/hotelRegistration.jsp";//숙박업체등록 양식페이지
				System.out.println("신규등록");
			}
		}
		
		if(dispatchUrl!=null)
		{
			RequestDispatcher rd=request.getRequestDispatcher(dispatchUrl);
			rd.forward(request, response);
		}
	}
	
	private void hotelManagerAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String dispatchUrl=null;
		
		String hotelName=request.getParameter("hotelName");
		String hotelLocation=request.getParameter("hotelLocation");
		String hotelIntroduction=request.getParameter("hotelIntrodution");
		String hotelReservationPagePath=request.getParameter("hotelReservationPagePath");
		
		HotelInfoForm hotelInfoForm=new HotelInfoForm(hotelName, hotelLocation, hotelIntroduction, hotelReservationPagePath);
		
		HotelInfoValidator hotelInfoValidator=new HotelInfoValidator(hotelInfoForm);
		
		List<String> checkList=hotelInfoValidator.validate();
		
		if(checkList.size()!=0) //유효성검사 결과 문제가 있을시
		{
			request.setAttribute("problems", checkList);
			dispatchUrl="/page/mainpage.jsp";
		}
		else
		{
			HotelInfo hotelInfo=new HotelInfo(hotelName, hotelLocation, hotelIntroduction, hotelReservationPagePath);
			
			HotelInfoRegistrationManager hotelInfoRegistrationManager=new HotelInfoRegistrationManager(hotelInfo);
			LoginManager loginManager=new LoginManager();
			
			HttpSession session=request.getSession();
			String memberCode=(String)session.getAttribute("memberCode");
			
			
			if(hotelInfoRegistrationManager.registerHotelInfo(memberCode))//숙박업체 등록이 성공한 경우
			{
				String hotelManagerCode=loginManager.getHotelManagerCode(memberCode); 
				request.setAttribute("HotelSaveSuccess", "숙박업체 등록 성공!"); 
				
				session.setAttribute("hotelManagerCode", hotelManagerCode);//숙박업체코드를 세션에 저장
			
				dispatchUrl="/page/EmptyRoomInfoManager";//숙박업체 관리페이지 주소로 이동시킴
				
				
				System.out.println("숙박등록성공");
			}
			else //숙박업체등록 실패한 경우
			{
				request.setAttribute("HotelSaveFail", "숙박업체 등록에 실패하였습니다. 다시 시도해 주십시오");
				dispatchUrl="/page/hotelfirstPage.jsp";
			}
			
		
			if(dispatchUrl!=null)
			{
				RequestDispatcher rd=request.getRequestDispatcher(dispatchUrl);
				rd.forward(request, response);
			}
		}
	}
}
