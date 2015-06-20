package dbmanager;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer; 
import converter.ConvertGregorianCalendar; 

import dao.EmptyRoomDetailInfoDAO;
import dto.EmptyRoomDetailInfoDTO;
import model.EmptyRoomDetailInfo;

/**
 * 공실 상세정보를 application계층인 EmptyRoomReservationManager로부터 요청받아 처리 후  전달하는 클래스
 * @author 화섭
 *
 */
public class EmptyRoomDetailInfoDAOManager 
{
	private EmptyRoomDetailInfoDAO emptyRoomDetailInfoDAO;
	
	/**
	 * 공실관리 클래스를 인스턴스화한다
	 */
	public EmptyRoomDetailInfoDAOManager()
	{
		emptyRoomDetailInfoDAO=new EmptyRoomDetailInfoDAO();
	}
	
	/**
	 * 공실상세코드에 해당하는 공실상세정보를 EmptyRoomDetailDAO로부터 찾아 EmptyRoomReservationManager를에 처리결과를 전달한다
	 * @param emptyRoomCode 공실상세코드
	 * @return 공실상세코드에 해당하는 공실상세정보를 전달한다
	 */
	public EmptyRoomDetailInfo getEmptyDetailInfo(String emptyRoomCode)
	{
		
		ConvertGregorianCalendar convertCalendar=new ConvertGregorianCalendar();
		
		EmptyRoomDetailInfoDTO emptyRoomDetailInfoDTO=emptyRoomDetailInfoDAO.selectEmptyRoomInfo(emptyRoomCode);
		
		String emptyRoomName=emptyRoomDetailInfoDTO.getRoomName();
		double oldPrice=emptyRoomDetailInfoDTO.getOldPrice();
		double discountPrice=emptyRoomDetailInfoDTO.getDiscountPrice();
		int space=emptyRoomDetailInfoDTO.getRoomSpace();
		GregorianCalendar date=convertCalendar.convert(emptyRoomDetailInfoDTO.getAvailableDate());
		String checkInTime= emptyRoomDetailInfoDTO.getCheckInTime() ;
		String checkOutTime= emptyRoomDetailInfoDTO.getCheckOutTime();
		int capacity=emptyRoomDetailInfoDTO.getRoomCapacity();
		String facilityList=emptyRoomDetailInfoDTO.getHotelFacilityList();
		String etc=emptyRoomDetailInfoDTO.getRoomEtc();
		String hotelName=emptyRoomDetailInfoDTO.getHotelName();
		String hotelLocation=emptyRoomDetailInfoDTO.getHotelLocation();
		String hotelIntroduction=emptyRoomDetailInfoDTO.getHotelIntroduction();
		String hotelPagePath=emptyRoomDetailInfoDTO.getHotelPagePath();
		
		EmptyRoomDetailInfo emptyRoomDetailInfo=new EmptyRoomDetailInfo(emptyRoomCode, emptyRoomName, oldPrice, discountPrice, space,	date, checkInTime,	checkOutTime, capacity, facilityList, etc, hotelName,  hotelLocation, hotelIntroduction, hotelPagePath);
		
		return emptyRoomDetailInfo;
	}

}
