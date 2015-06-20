package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manager.PostingDeleteManager;
import model.PostingInfo;

/**
 * 포스팅을 삭제하기 위해 사용하는 클래스
 * Servlet implementation class PostingDeleteServlet
 */
@WebServlet(name="PostingDeleteServlet", urlPatterns ={"/page/postingDelete"})
public class PostingDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**포스팅코드와 포스팅목적코드를 이용하여 PostingDeleteManager의 메소드 호출
	<br>여행일정 : delteTourPlanPosting() 
	<br>여행준비물 : deleteTourPreparationPosting()
	<Br>동행자구하기 : deleteCompanionPosting()
	<br>일반글 : deletePosting()
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
	
		//session에서 멤버코드 받아와야 한다.
		HttpSession session=request.getSession();
		String memberCode=(String)session.getAttribute("memberCode");

		String postingCode=request.getParameter("postingCode");
		System.out.println("포스팅 코드:"+postingCode);
		
		PostingInfo postingInfo=new PostingInfo();
		postingInfo.setPostingCode(postingCode);
		
		PostingDeleteManager postingDeleteManager=new PostingDeleteManager(postingInfo);
		if(postingDeleteManager.deletePosting(memberCode)!= null)	//21은 memberCode
			System.out.println("삭제성공");
		else
			System.out.println("삭제불가");
		
		RequestDispatcher view=request.getRequestDispatcher("mem_mange_posting_fake.jsp");
		view.forward(request, response);
	}
}
