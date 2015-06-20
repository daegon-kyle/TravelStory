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
 * ���� �������� application������ EmptyRoomReservationManager�κ��� ��û�޾� ó�� ��  �����ϴ� Ŭ����
 * @author ȭ��
 *
 */
public class EmptyRoomDetailInfoDAOManager 
{
	private EmptyRoomDetailInfoDAO emptyRoomDetailInfoDAO;
	
	/**
	 * ���ǰ��� Ŭ������ �ν��Ͻ�ȭ�Ѵ�
	 */
	public EmptyRoomDetailInfoDAOManager()
	{
		emptyRoomDetailInfoDAO=new EmptyRoomDetailInfoDAO();
	}
	
	/**
	 * ���ǻ��ڵ忡 �ش��ϴ� ���ǻ������� EmptyRoomDetailDAO�κ��� ã�� EmptyRoomReservationManager���� ó������� �����Ѵ�
	 * @param emptyRoomCode ���ǻ��ڵ�
	 * @return ���ǻ��ڵ忡 �ش��ϴ� ���ǻ������� �����Ѵ�
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
