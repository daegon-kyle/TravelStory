package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.VisitRequestDAO;

import manager.VisitRequestForTouristManager;

/**
 * Servlet implementation class VisitRequestCheckServlet
 */
@WebServlet("/page/VisitRequestHistory")
public class VisitRequestHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String memberCode = (String)session.getAttribute("memberCode");
		
		VisitRequestForTouristManager visitRequestForTouristManager = new VisitRequestForTouristManager();
		visitRequestForTouristManager.setVisitRequestInfoForTouristList("1");// memberCode전달
		request.setAttribute("visitRequestInfoForTouristList", visitRequestForTouristManager.getVisitRequestInfoForTouristList().getVisitRequestForTourist());
		
		RequestDispatcher rd = request.getRequestDispatcher("touristHistory.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 구현 중 houseEssentialInfo 만 가지고 신청정보를 삭제할 수 없어서 중간 포기 ...
		VisitRequestDAO visitRequestDAO = new VisitRequestDAO();
		visitRequestDAO.deleteTouristCode(request.getParameter("touristCode"));
		
		RequestDispatcher rd = request.getRequestDispatcher("touristHistory.jsp");
		rd.forward(request, response);
		
	}

}
