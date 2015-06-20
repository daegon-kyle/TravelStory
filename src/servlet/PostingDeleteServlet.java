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
 * �������� �����ϱ� ���� ����ϴ� Ŭ����
 * Servlet implementation class PostingDeleteServlet
 */
@WebServlet(name="PostingDeleteServlet", urlPatterns ={"/page/postingDelete"})
public class PostingDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**�������ڵ�� �����ø����ڵ带 �̿��Ͽ� PostingDeleteManager�� �޼ҵ� ȣ��
	<br>�������� : delteTourPlanPosting() 
	<br>�����غ� : deleteTourPreparationPosting()
	<Br>�����ڱ��ϱ� : deleteCompanionPosting()
	<br>�Ϲݱ� : deletePosting()
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
	
		//session���� ����ڵ� �޾ƿ;� �Ѵ�.
		HttpSession session=request.getSession();
		String memberCode=(String)session.getAttribute("memberCode");

		String postingCode=request.getParameter("postingCode");
		System.out.println("������ �ڵ�:"+postingCode);
		
		PostingInfo postingInfo=new PostingInfo();
		postingInfo.setPostingCode(postingCode);
		
		PostingDeleteManager postingDeleteManager=new PostingDeleteManager(postingInfo);
		if(postingDeleteManager.deletePosting(memberCode)!= null)	//21�� memberCode
			System.out.println("��������");
		else
			System.out.println("�����Ұ�");
		
		RequestDispatcher view=request.getRequestDispatcher("mem_mange_posting_fake.jsp");
		view.forward(request, response);
	}
}
