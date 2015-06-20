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
 * 방문관리 서비스(수락, 거잘)를 제공하는 서블릿 
 * Servlet implementation class VisitRequestManagerServlet
 */
@WebServlet(urlPatterns={"/page/VisitRequestManager"})
public class VisitRequestManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 관리페이지 제공
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
	 * 방문신청에 대한 수락, 거절에 따라 분기처리 
		<br>방문을 수락한 경우 : VisitAcceptManager의 accept() 호출
		<br>방문을 거절한 경우 : VisitAcceptManager의 refuse() 호출
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
		
		visitAcceptManager.setVisitRequestInfoForOwnerList(houseOwnerCode); // 집주인에게 방문신청한 리스트를 세팅한다.
		request.setAttribute("visitRequestInfoForOwnerList", visitAcceptManager.getVisitRequestInfoForOwnerList().getVisitRequestInfoForOwner());
		RequestDispatcher rd = request.getRequestDispatcher("/page/visitRequestManage.jsp");
		rd.forward(request, response);
	}

}
