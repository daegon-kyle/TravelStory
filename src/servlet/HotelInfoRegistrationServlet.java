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
		 
		
		if(action.equals("hotelAdd"))//(hotelfirstPage���� ��û ���ھ�ü����� ��û�ϴ�
		{
			hotelManagerCheck(request, response); //��ϵ� ȸ������ Ȯ���Ѵ�
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
		hotelManagerAdd(request, response);//(hotelRegistration ���������� ��â)����� ���� ����� ��û�Ѵ�
	}
	private void hotelManagerCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String dispatchUrl=null;

		 
		HttpSession session=request.getSession();
		String memberCode=(String)session.getAttribute("memberCode");
		String hotelManagerCode=(String)session.getAttribute("hotelManagerCode");
		
		if(hotelManagerCode!=null) //��ϵ� ���
		{
			request.setAttribute("HotelSaveFail", "�̹� ���ھ�ü ����Ͽ����ϴ�. ���ǰ����������� �̿��Ͻʽÿ�");
			dispatchUrl="/page/EmptyRoomInfoManager"; //���ǰ�����������ũ
			System.out.println("�̵̹��ȸ�� ���ǰ������������̵�");
		}
		else //�űԵ��
		{
			if(memberCode==null) 
				dispatchUrl="/page/memberJoin";
			else
			{
				dispatchUrl="/page/hotelRegistration.jsp";//���ھ�ü��� ���������
				System.out.println("�űԵ��");
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
		
		if(checkList.size()!=0) //��ȿ���˻� ��� ������ ������
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
			
			
			if(hotelInfoRegistrationManager.registerHotelInfo(memberCode))//���ھ�ü ����� ������ ���
			{
				String hotelManagerCode=loginManager.getHotelManagerCode(memberCode); 
				request.setAttribute("HotelSaveSuccess", "���ھ�ü ��� ����!"); 
				
				session.setAttribute("hotelManagerCode", hotelManagerCode);//���ھ�ü�ڵ带 ���ǿ� ����
			
				dispatchUrl="/page/EmptyRoomInfoManager";//���ھ�ü ���������� �ּҷ� �̵���Ŵ
				
				
				System.out.println("���ڵ�ϼ���");
			}
			else //���ھ�ü��� ������ ���
			{
				request.setAttribute("HotelSaveFail", "���ھ�ü ��Ͽ� �����Ͽ����ϴ�. �ٽ� �õ��� �ֽʽÿ�");
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
