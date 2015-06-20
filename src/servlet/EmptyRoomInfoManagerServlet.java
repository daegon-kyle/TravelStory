package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbmanager.EmptyRoomDetailInfoDAOManager;

import validator.EmptyRoomInfoValidator;

import form.EmptyRoomInfoForm;

import manager.EmptyRoomInfoManager;
import model.EmptyRoomDetailInfo;
import model.EmptyRoomInfo;

/**
 * 
 * 공실정보를 관리하는 서블릿
 * Servlet implementation class EmptyRoomInfoManagerServlet
 */
@WebServlet(urlPatterns ={"/page/EmptyRoomInfoManager","/page/EmptyRoomAddPopUp","/page/EmptyRoomRevisePopUp"})
public class EmptyRoomInfoManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 공실정보 관리페이지를 제공, 삽입,삭제,수정 분기처리한다.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		// 세션에 저장된 hotelManageCode를 가져온다. 
		
		String hotelManagerCode = (String) request.getSession().getAttribute("hotelManagerCode");
		String dispatchURL = null;
		
		if(hotelManagerCode == null){
			dispatchURL = "/page/hotelRegistration.jsp";
		}
		else{
			// hotelManageCode를 EmptyRoomInfo에 저장한다. 
			EmptyRoomInfo emptyRoomInfo = new EmptyRoomInfo();
			emptyRoomInfo.setHotelCode(hotelManagerCode);
			//
			EmptyRoomInfoManager emptyRoomInfoManager = new EmptyRoomInfoManager(emptyRoomInfo);	
			request.setAttribute("emptyRoomInfoList", emptyRoomInfoManager.searchEmptyRoomInfo().getEmptyRoomList());
			dispatchURL = "/page/emptyRoomManage.jsp";
			
			String emptyRoomCode = request.getParameter("emptyRoomCode");
			System.out.println("emptyRoomCode : " + emptyRoomCode);
			if(emptyRoomCode!= null)
			{
				EmptyRoomDetailInfoDAOManager emptyRoomDetailInfoDAOManager = new EmptyRoomDetailInfoDAOManager();
				EmptyRoomDetailInfo emptyRoomDetailInfo = emptyRoomDetailInfoDAOManager.getEmptyDetailInfo(emptyRoomCode);
				System.out.println(emptyRoomDetailInfo.getEmptyRoomName());
				request.setAttribute("emptyRoomDetailInfo", emptyRoomDetailInfo);
				dispatchURL="EmptyRoomRevisePopUp.jsp";
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(dispatchURL);
		rd.forward(request, response);
	}
		

	/**
	 * 삽입, 삭제, 수정 입력사항을 이용하여 공실정보 수정 
	<br>EmptyRoomInfoManager의 메소드 호출
	<br>추가:addEmptyRoomInfo()
	<br>삭제:deleteEmptyRoomInfo()
	<br>수정:reviseEmptyRoomInfo() 

	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String formType= request.getParameter("formType");
		
		if(formType.equals("addEmptyRoom")){
			EmptyRoomInfoForm emptyRoomInfoForm = new EmptyRoomInfoForm(request.getParameter("emptyRoomName"), request.getParameter("oldPrice"),  request.getParameter("discountPrice"),  request.getParameter("space"),  request.getParameter("checkInTime"),  request.getParameter("checkOutTime"), request.getParameter("capacity"),  request.getParameter("facilityList"),  request.getParameter("etc"));
			EmptyRoomInfoValidator  emptyRoomInfoValidator = new EmptyRoomInfoValidator(emptyRoomInfoForm);
			List<String> errors = emptyRoomInfoValidator.validate();
			if(errors.isEmpty()){
				HttpSession session = request.getSession();
				String hotelManagerCode = (String) session.getAttribute("hotelManagerCode");
				String[] facilityList = emptyRoomInfoForm.getFacilityList().split(",");
				System.out.println(emptyRoomInfoForm.getCapacity());
				EmptyRoomInfo emptyRoomInfo = new EmptyRoomInfo(hotelManagerCode,emptyRoomInfoForm.getEmptyRoomName(), Double.parseDouble(emptyRoomInfoForm.getOldPrice()), 
						Double.parseDouble(emptyRoomInfoForm.getDiscountPrice()), Integer.parseInt(emptyRoomInfoForm.getSpace()), emptyRoomInfoForm.getCheckInTime(), 
						emptyRoomInfoForm.getCheckOutTime(), Integer.parseInt(emptyRoomInfoForm.getCapacity()),facilityList, emptyRoomInfoForm.getEtc()); // hotelManageCode는 입력해야함 test중
				EmptyRoomInfoManager emptyRoomInfoManager = new EmptyRoomInfoManager(emptyRoomInfo);
				
				String result;
				if(emptyRoomInfoManager.addEmptyRoomInfo()){
					result = "저장에 성공하였습니다.";
				}else{
					result ="저장에 실패하였습니다.";
				}
				request.setAttribute("result", result);
				
				/*RequestDispatcher rd = request.getRequestDispatcher("/page/EmptyRoomAddResult.jsp");
				rd.forward(request, response);*/
			}
		}else if(formType.equals("deleteEmptyRoom")){
			String emptyRoomCode = request.getParameter("emptyRoomCode");
			EmptyRoomInfoManager emptyRoomInfoManager = new EmptyRoomInfoManager(); 
			if(emptyRoomInfoManager.deleteEmptyRoomInfo(emptyRoomCode)){
				response.sendRedirect("EmptyRoomInfoManager");
			}
				
				
		}else if(formType.equals("reviseEmptyRoom")){
			System.out.println("servlet !!! reviseEmptyRoom ");
			String emptyRoomCode = request.getParameter("emptyRoomCode");
			System.out.println("emptyRoomCode : " + emptyRoomCode);
			System.out.println(request.getParameter("emptyRoomName")+request.getParameter("oldPrice")+request.getParameter("discountPrice")+
					request.getParameter("space")+request.getParameter("checkInTime")+request.getParameter("checkOutTime")+request.getParameter("capacity")+request.getParameter("facilityList")+request.getParameter("etc"));
			
			EmptyRoomInfoForm emptyRoomInfoForm = new EmptyRoomInfoForm(request.getParameter("emptyRoomName"),request.getParameter("oldPrice"),request.getParameter("discountPrice"),
					request.getParameter("space"),request.getParameter("checkInTime"), request.getParameter("checkOutTime"),request.getParameter("capacity"),request.getParameter("facilityList"),request.getParameter("etc"));
			
			EmptyRoomInfoValidator emptyRoomInfoValidator = new EmptyRoomInfoValidator(emptyRoomInfoForm);
			List<String> list = emptyRoomInfoValidator.validate();
			if(list.isEmpty()){
				HttpSession session = request.getSession();
				String hotelManagerCode = (String) session.getAttribute("hotelManagerCode");
				String[] facilityList = emptyRoomInfoForm.getFacilityList().split(",");
				System.out.println("capacity : "+emptyRoomInfoForm.getCapacity());
				
				EmptyRoomInfo emptyRoomInfo = new EmptyRoomInfo(emptyRoomCode,emptyRoomInfoForm.getEmptyRoomName(), Double.parseDouble(emptyRoomInfoForm.getOldPrice()), 
						Double.parseDouble(emptyRoomInfoForm.getDiscountPrice()), Integer.parseInt(emptyRoomInfoForm.getSpace()),hotelManagerCode, emptyRoomInfoForm.getCheckInTime(), 
						emptyRoomInfoForm.getCheckOutTime(), Integer.parseInt(emptyRoomInfoForm.getCapacity()),facilityList, emptyRoomInfoForm.getEtc()); // hotelManageCode는 입력해야함 test중
				emptyRoomInfo.setEmptyRoomCode(emptyRoomCode);
				
				System.out.println("그럼여기는");
				EmptyRoomInfoManager emptyRoomInfoManager = new EmptyRoomInfoManager(emptyRoomInfo);
				
				String result="";
				System.out.println("servlet if 전 ");
				if(emptyRoomInfoManager.reviseEmptyRoomInfo()!=null){
					result = "저장에 성공하였습니다.";
				}else{
					result ="저장에 실패하였습니다.";
				}
				request.setAttribute("result", result);
			}
			
		}
		
	}

}
