package servlet;

import java.io.IOException;
import form.LoginForm;
import validator.LoginValidator;
import java.util.List; 
import manager.LoginManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbmanager.MemberDAOManager;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name="LoginServlet", urlPatterns={"/page/login", "/page/logout", "/page/modifyMemberInfo"})

public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		
		
		request.setCharacterEncoding("utf-8");
				
		String uri=request.getRequestURI();
		
		int lastIndex=uri.lastIndexOf("/");
		String action=uri.substring(lastIndex+1);
		 
		if(action.equals("login"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("/page/mainpage.jsp");
			rd.forward(request, response);
		}
		else if(action.equals("logout"))//�α׾ƿ�
		{
			logout(request, response);
		}
		else if(action.equals("modifyMemberInfo"))//ȸ����������
		{
		}
		else if(action.equals("findId"))//���̵� ã��
		{
		}
		else if(action.equals("findPassword"))//��й�ȣ ã��
		{
			
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("utf-8");
		
		String uri=request.getRequestURI();
		
		int lastIndex=uri.lastIndexOf("/");
		String action=uri.substring(lastIndex+1);
		 
		if(action.equals("login"))//�α���
		{
			login(request, response);
		} 
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String dispatchUrl=null;
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");

		String memberCode=null; //ȸ���ڵ�
		String houseOwnerCode=null; //�������ڵ�
		String hotelManagerCode=null; //���ھ�ü�ڵ�
		
		LoginForm loginForm=new LoginForm(email, password);
		
		LoginValidator loginValidator=new LoginValidator(loginForm);
		
		List<String> checkList=loginValidator.validate();
		
		if(checkList.size()!=0) //��ȿ���˻� ��� ������ ������
		{
			request.setAttribute("problems", checkList);
			dispatchUrl="/page/mainpage.jsp";
		}
		else
		{			
			LoginManager loginManager=new LoginManager();
			
			String tPassword=null;
			tPassword=loginManager.getPassword(email);
			
			if(tPassword==null) //��ϵ��� ���� �̸����ּ�
			{
				request.setAttribute("noEmail", "��ϵ��� ���� �̸����ּ��Դϴ�");
				
				dispatchUrl="/page/mainpage.jsp";
			}
			else //��ϵ� �̸���
			{
				if(password.equals(tPassword)) //��й�ȣ�� ��ġ�ϴ� ���
				{ 
					
					memberCode=loginManager.login(email, password); //�α��ο�û�Ͽ� ȸ���ڵ带 �޾ƿ´�
					
					HttpSession session=request.getSession();
					session.setAttribute("memberCode", memberCode); //���ǿ� ȸ���ڵ� ����
					
					MemberDAOManager memberDAOManager=new MemberDAOManager();
					String name=memberDAOManager.getMemberInfo(memberCode).getName();
					session.setAttribute("name", name);
					
					houseOwnerCode=loginManager.getHouseOwnerCode(memberCode);
					
					if(houseOwnerCode!=null)
					{ 
						session.setAttribute("houseOwnerCode", houseOwnerCode);//���ǿ� ���������� ����
					}
					
					hotelManagerCode=loginManager.getHotelManagerCode(memberCode);
					
					if(hotelManagerCode!=null)
					{ 
						session.setAttribute("hotelManagerCode", hotelManagerCode);//���ǿ� ���ھ�ü���� ����
					}
					dispatchUrl="/page/mainBlog.jsp";
				}
				else //��й�ȣ�� �߸� �Է��Ѱ��
				{ 
					request.setAttribute("wrongPassword", "��й�ȣ�� �߸� �Է��Ͽ����ϴ�");
					
					dispatchUrl="/page/mainpage.jsp";
				}
			}
		}
		
		if(dispatchUrl != null)
		{
			RequestDispatcher rd=request.getRequestDispatcher(dispatchUrl);
			rd.forward(request, response);
		}
		
	}
	
	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session=request.getSession();
		session.removeAttribute("memberCode");
		
		if(session.getAttribute("houseOwnerCode")!=null)
			session.removeAttribute("houseOwnerCode");
		if(session.getAttribute("hotelManagerCode")!=null)
			session.removeAttribute("hotelManagerCode");
		
		request.setAttribute("noEmail", "�α׾ƿ��Ǿ����ϴ�");
		
		RequestDispatcher rd=request.getRequestDispatcher("/page/mainpage.jsp");
		rd.forward(request, response);
	}
	

}
