package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manager.VisitAcceptManager;
import model.VisitRequestInfoForOwner;
import model.VisitRequestInfoForOwnerList;

/**
 * �湮���� ����(����, ����)�� �����ϴ� ���� 
 * Servlet implementation class VisitRequestManagerServlet
 */
@WebServlet(urlPatterns={"/page/VisitRequestManager"})
public class VisitRequestManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * ���������� ����
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String houseOwnerCode = (String)session.getAttribute("houseOwnerCode");
		String dispatchUrl = null;
		if(houseOwnerCode == null){
			dispatchUrl = "housefirstPage.jsp";
		}else{
			VisitAcceptManager visitAcceptManager = new VisitAcceptManager();
			visitAcceptManager.setVisitRequestInfoForOwnerList(houseOwnerCode);
			
			request.setAttribute("visitRequestInfoForOwnerList",visitAcceptManager.getVisitRequestInfoForOwnerList().getVisitRequestInfoForOwner());
			dispatchUrl = "/page/visitRequestManage.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
		rd.forward(request, response);
	}

	/**
	 * �湮��û�� ���� ����, ������ ���� �б�ó�� 
		<br>�湮�� ������ ��� : VisitAcceptManager�� accept() ȣ��
		<br>�湮�� ������ ��� : VisitAcceptManager�� refuse() ȣ��
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String formType = request.getParameter("formType");
		
		HttpSession session = request.getSession();
		String houseOwnerCode = (String)session.getAttribute("houseOwnerCode");
		String touristCode = request.getParameter("touristCode");
	
		VisitAcceptManager visitAcceptManager = new VisitAcceptManager();

		if(formType.equals("accept")){	
			visitAcceptManager.accept(houseOwnerCode, touristCode);
		}else if(formType.equals("refuse")){
			visitAcceptManager.refuse(houseOwnerCode, touristCode);
		}
		
		visitAcceptManager.setVisitRequestInfoForOwnerList(houseOwnerCode); // �����ο��� �湮��û�� ����Ʈ�� �����Ѵ�.
		request.setAttribute("visitRequestInfoForOwnerList", visitAcceptManager.getVisitRequestInfoForOwnerList().getVisitRequestInfoForOwner());
		RequestDispatcher rd = request.getRequestDispatcher("/page/visitRequestManage.jsp");
		rd.forward(request, response);
	}

}
