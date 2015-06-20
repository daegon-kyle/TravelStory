package servlet;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import converter.ConvertGregorianCalendar;

import manager.VisitRequestCheckForTouristManager;
import manager.VisitRequestForTouristManager;
import model.HouseOwnerEssentialInfo;
import model.TouristEssentialInfo;
import validator.HouseOwnerSearchValidator;
import validator.TouristEssentialInfoValidator;
import form.HouseOwnerEssentialInfoForm;
import form.TouristEssentialInfoForm;


/**
 * 방문신청페이지를 관리하는 서블릿(여행객이)
 * Servlet implementation class VisitRequestServlet
 */
@WebServlet(urlPatterns={"/page/VisitRequest"})
public class VisitRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 방문신청 페이지를 제공(블로그화면에서 링크) 
	 * <br>mainBlog.html, 방문신청페이지애서 호출
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*String houseOwnerCode = request.getParameter("houseOwnerCode");*/
		String checkedCode = request.getParameter("checkedCode");
		System.out.println("doget !!!!!! "+ checkedCode);
		request.setAttribute("checkedCode", checkedCode);
		
		RequestDispatcher rd = request.getRequestDispatcher("/page/touristRequest.jsp");
		rd.forward(request, response);

	}

	/**
	 * CompanionRecommendInfoManager의 check()메소드호출 - 허용하는 집주인 정보 체크
	 * <br>VisitRequestForTouristManager의 addVistRequest() 호출 - 집주인에게 신청
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("utf-8");
		String formType = request.getParameter("formType");
		System.out.println(formType);
		
		if(formType.equals("search")){
			HouseOwnerEssentialInfoForm houseOwnerEssentialInfoForm = new HouseOwnerEssentialInfoForm(request.getParameter("address"),
					request.getParameter("visitStartDate"),request.getParameter("visitEndDate"));

			HouseOwnerSearchValidator houseOwnerSearchValidator = new HouseOwnerSearchValidator(houseOwnerEssentialInfoForm);
			List<String> errors = houseOwnerSearchValidator.validate();
			System.out.println("here!");
			System.out.println(errors.isEmpty());
			for(String error : errors){
				System.out.println(error);
			}
			if(errors.isEmpty()){
				String start = houseOwnerEssentialInfoForm.getVisitStartDate();
				GregorianCalendar visitStart = new GregorianCalendar(Integer.parseInt(start.substring(0, 4)), Integer.parseInt(start.substring(5, 7))-1, Integer.parseInt(start.substring(8, 10)));
				System.out.println(visitStart);
				String end = houseOwnerEssentialInfoForm.getVisitEndDate();
				GregorianCalendar visitEnd = new GregorianCalendar(Integer.parseInt(end.substring(0, 4)), Integer.parseInt(end.substring(5, 7))-1, Integer.parseInt(end.substring(8, 10)));
				HouseOwnerEssentialInfo houseOwnerEssentialInfo = new HouseOwnerEssentialInfo(houseOwnerEssentialInfoForm.getAddress(),visitStart,visitEnd);
				VisitRequestCheckForTouristManager visitRequestCheckForTouristManager = new VisitRequestCheckForTouristManager(houseOwnerEssentialInfo);
				request.setAttribute("houseOwnerList",visitRequestCheckForTouristManager.getSearchResult().getHouseOwnerEssentialInfoList());
				RequestDispatcher rd = request.getRequestDispatcher("visitRequestCheck.jsp");
				rd.forward(request, response);
			}
		}else if(formType.equals("visitRequest")){
			//	TouristEssentialInfoForm touristEssentialInfoForm = new TouristEssentialInfoForm(request.getParameter("selfIntroduction"));
			TouristEssentialInfoForm touristEssentialInfoForm = new TouristEssentialInfoForm(request.getParameter("selfIntroduction"),request.getParameter("startDate"),request.getParameter("endDate"),
					request.getParameter("companionNum"),request.getParameter("job"));
			
			TouristEssentialInfoValidator touristEssentialInfoValidator = new TouristEssentialInfoValidator(touristEssentialInfoForm);
			List<String> errors = touristEssentialInfoValidator.validate();
			
			if(errors.isEmpty()){
				ConvertGregorianCalendar converter = new ConvertGregorianCalendar();
				GregorianCalendar arrivalDate = converter.convert(touristEssentialInfoForm.getVisitStartDate());
				GregorianCalendar departureDate =  converter.convert(touristEssentialInfoForm.getVisitEndDate());
				TouristEssentialInfo touristEssentialInfo = new TouristEssentialInfo(touristEssentialInfoForm.getSelfIntroduction(), arrivalDate, departureDate,
						Integer.parseInt(touristEssentialInfoForm.getCompanionNum()), touristEssentialInfoForm.getJob());
				
				
				 //receive memberCode from session
				 HttpSession session = request.getSession();
				 String memberCode = (String)session.getAttribute("memberCode");

				String result = "저장에 실패하였습니다.";
				VisitRequestForTouristManager visitRequestForTouristManager = new VisitRequestForTouristManager();
				if(visitRequestForTouristManager.addVisitRequest(memberCode,request.getParameter("houseOwnerCode"),touristEssentialInfo)){
					result= "성공적으로 저장되었습니다.";
				}else{
					System.out.println("false");
				}
				
				request.setAttribute("result", result);
				RequestDispatcher rd = request.getRequestDispatcher("visitRequestResult.jsp");
				rd.forward(request, response);
			}else{
				System.out.println("no empty");
			}
			
		}




	}

}
