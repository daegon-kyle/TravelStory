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
		else if(action.equals("logout"))//로그아웃
		{
			logout(request, response);
		}
		else if(action.equals("modifyMemberInfo"))//회원정보수정
		{
		}
		else if(action.equals("findId"))//아이디 찾기
		{
		}
		else if(action.equals("findPassword"))//비밀번호 찾기
		{
			
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("utf-8");
		
		String uri=request.getRequestURI();
		
		int lastIndex=uri.lastIndexOf("/");
		String action=uri.substring(lastIndex+1);
		 
		if(action.equals("login"))//로그인
		{
			login(request, response);
		} 
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String dispatchUrl=null;
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");

		String memberCode=null; //회원코드
		String houseOwnerCode=null; //집주인코드
		String hotelManagerCode=null; //숙박업체코드
		
		LoginForm loginForm=new LoginForm(email, password);
		
		LoginValidator loginValidator=new LoginValidator(loginForm);
		
		List<String> checkList=loginValidator.validate();
		
		if(checkList.size()!=0) //유효성검사 결과 문제가 있을시
		{
			request.setAttribute("problems", checkList);
			dispatchUrl="/page/mainpage.jsp";
		}
		else
		{			
			LoginManager loginManager=new LoginManager();
			
			String tPassword=null;
			tPassword=loginManager.getPassword(email);
			
			if(tPassword==null) //등록되지 않은 이메일주소
			{
				request.setAttribute("noEmail", "등록되지 않은 이메일주소입니다");
				
				dispatchUrl="/page/mainpage.jsp";
			}
			else //등록된 이메일
			{
				if(password.equals(tPassword)) //비밀번호가 일치하는 경우
				{ 
					
					memberCode=loginManager.login(email, password); //로그인요청하여 회원코드를 받아온다
					
					HttpSession session=request.getSession();
					session.setAttribute("memberCode", memberCode); //세션에 회원코드 저장
					
					MemberDAOManager memberDAOManager=new MemberDAOManager();
					String name=memberDAOManager.getMemberInfo(memberCode).getName();
					session.setAttribute("name", name);
					
					houseOwnerCode=loginManager.getHouseOwnerCode(memberCode);
					
					if(houseOwnerCode!=null)
					{ 
						session.setAttribute("houseOwnerCode", houseOwnerCode);//세션에 집주인정보 저장
					}
					
					hotelManagerCode=loginManager.getHotelManagerCode(memberCode);
					
					if(hotelManagerCode!=null)
					{ 
						session.setAttribute("hotelManagerCode", hotelManagerCode);//세션에 숙박업체정보 저장
					}
					dispatchUrl="/page/mainBlog.jsp";
				}
				else //비밀번호를 잘못 입력한경우
				{ 
					request.setAttribute("wrongPassword", "비밀번호를 잘못 입력하였습니다");
					
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
		
		request.setAttribute("noEmail", "로그아웃되었습니다");
		
		RequestDispatcher rd=request.getRequestDispatcher("/page/mainpage.jsp");
		rd.forward(request, response);
	}
	

}
