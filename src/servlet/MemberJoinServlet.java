package servlet;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import form.MemberInfoForm;
import model.MemberInfo;
import manager.MemberJoinManager;
import validator.MemberInfoValidator;
import java.util.List;
import converter.ConvertGregorianCalendar;
import java.util.StringTokenizer;
/**
 * Servlet implementation class MemberJoinServlet
 */
@WebServlet(name="MemberJoinServlet", urlPatterns = {"/page/memberJoin"})
public class MemberJoinServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		
		 
		RequestDispatcher view=request.getRequestDispatcher("/page/memberJoin.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String email=request.getParameter("email");
		String name=request.getParameter("name");
		String password=request.getParameter("password");  
		String passwordCheck=request.getParameter("passwordCheck"); 
		String birthDate=request.getParameter("birthDate");
		String contactNumber=request.getParameter("contactNumber");
		String gender=request.getParameter("radio");
	 
		
		
		
		//formBean에 집어넣기
		MemberInfoForm memberInfoForm=new MemberInfoForm(email, name, password, passwordCheck, birthDate, gender, contactNumber);
		
		//validator 호출 후 유효성 검증
		MemberInfoValidator memberValidator=new MemberInfoValidator(memberInfoForm);
		List<String> checkList=memberValidator.validate();

		System.out.println(checkList.size());
		
		if(checkList.size()!=0) //유효성검사 결과 문제가 있을시
		{
			
			
			System.out.println("문제있다");
			 
			request.setAttribute("problems", checkList);
			RequestDispatcher view=request.getRequestDispatcher("/page/memberJoin.jsp");
			view.forward(request, response);
			
			
		}
		else
		{ 
			StringTokenizer stok=new StringTokenizer(birthDate, "-");
			int year=Integer.parseInt(stok.nextToken());
			int month=Integer.parseInt(stok.nextToken());
			int date=Integer.parseInt(stok.nextToken());

			birthDate=year+"/"+month+"/"+date;
			
			
			ConvertGregorianCalendar convertCalendar=new ConvertGregorianCalendar();//달력 변환
		
			
			MemberInfo memberInfo=new MemberInfo(name, email, password, convertCalendar.convert(birthDate), gender, contactNumber, "","",0);
		
			//별도의 매니저 호출
			//회원코드값 부여, memberCode
			MemberJoinManager memberJoinManager=new MemberJoinManager(memberInfo);
			
			if(memberJoinManager.join())
			{ 
				request.setAttribute("success", "Travel Story의 가족이 되신걸 환영합니다!");
				RequestDispatcher view=request.getRequestDispatcher("/page/mainpage.jsp");
				view.forward(request, response);
			}
			else
			{ 
				//유효성검증 통과하지 못하면 기존 페이지로 동일하게 새로고침
				//팝업 뜰 수 있으면 나오게끔 하고
				request.setAttribute("emailProblem", "이미 등록된 이메일주소입니다");
				RequestDispatcher view=request.getRequestDispatcher("/page/memberJoin.jsp");
				view.forward(request, response);
			}
		}
		//화면 메인페이지로 이동, 성공했으므로!
		
	}

}
