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
 * ���������� �����ϴ� ����
 * Servlet implementation class EmptyRoomInfoManagerServlet
 */
@WebServlet(urlPatterns ={"/page/EmptyRoomInfoManager","/page/EmptyRoomAddPopUp","/page/EmptyRoomRevisePopUp"})
public class EmptyRoomInfoManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * �������� ������������ ����, ����,����,���� �б�ó���Ѵ�.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		// ���ǿ� ����� hotelManageCode�� �����´�. 
		
		String hotelManagerCode = (String) request.getSession().getAttribute("hotelManagerCode");
		String dispatchURL = null;
		
		if(hotelManagerCode == null){
			dispatchURL = "/page/hotelRegistration.jsp";
		}
		else{
			// hotelManageCode�� EmptyRoomInfo�� �����Ѵ�. 
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
	 * ����, ����, ���� �Է»����� �̿��Ͽ� �������� ���� 
	<br>EmptyRoomInfoManager�� �޼ҵ� ȣ��
	<br>�߰�:addEmptyRoomInfo()
	<br>����:deleteEmptyRoomInfo()
	<br>����:reviseEmptyRoomInfo() 

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
						emptyRoomInfoForm.getCheckOutTime(), Integer.parseInt(emptyRoomInfoForm.getCapacity()),facilityList, emptyRoomInfoForm.getEtc()); // hotelManageCode�� �Է��ؾ��� test��
				EmptyRoomInfoManager emptyRoomInfoManager = new EmptyRoomInfoManager(emptyRoomInfo);
				
				String result;
				if(emptyRoomInfoManager.addEmptyRoomInfo()){
					result = "���忡 �����Ͽ����ϴ�.";
				}else{
					result ="���忡 �����Ͽ����ϴ�.";
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
						emptyRoomInfoForm.getCheckOutTime(), Integer.parseInt(emptyRoomInfoForm.getCapacity()),facilityList, emptyRoomInfoForm.getEtc()); // hotelManageCode�� �Է��ؾ��� test��
				emptyRoomInfo.setEmptyRoomCode(emptyRoomCode);
				
				System.out.println("�׷������");
				EmptyRoomInfoManager emptyRoomInfoManager = new EmptyRoomInfoManager(emptyRoomInfo);
				
				String result="";
				System.out.println("servlet if �� ");
				if(emptyRoomInfoManager.reviseEmptyRoomInfo()!=null){
					result = "���忡 �����Ͽ����ϴ�.";
				}else{
					result ="���忡 �����Ͽ����ϴ�.";
				}
				request.setAttribute("result", result);
			}
			
		}
		
	}

}
