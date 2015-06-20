package dbmanager;

import java.util.GregorianCalendar; 
import converter.ConvertGregorianCalendar;
import dao.EmptyRoomListDAO;
import dto.EmptyRoomListDTO;
import model.EmptyRoomListInfoList;
import model.EmptyRoomListInfo;
/**
 * application 계층 매니저인 EmptyRoomReservationManager로부터 공실 간략 정보 관리 요청을 받아 처리후 전달하는 클래스
 * @author 화섭
 *
 */
public class EmptyRoomListDAOManager 
{
	private EmptyRoomListDAO emptyRoomListDAO;
	
	
	
	/**
	 * 공실정보관리 EmptyRoomListDAO클래스를 인스턴스화한다
	 */
	public EmptyRoomListDAOManager()
	{
		emptyRoomListDAO=new EmptyRoomListDAO();
	}
	
	/**
	 * 숙박업체 위치와 이용가능날짜에 해당하는 공실간략정보를 EmptyRoomListDAO에 요청하여 처리결과를 EmptyRoomResrvationManger로 전달한다
	 * @param hotelLocation 숙박업체위치
	 * @param availableDate 이용가능날짜
	 * @return 숙박업체위치와 이용가능날짜에 해당하는 공실간략정보를 전달한다
	 */
	public EmptyRoomListInfoList getEmptyRoomInfo(String hotelLocation, String availableDate)
	{
		EmptyRoomListInfoList list=new EmptyRoomListInfoList();
		EmptyRoomListInfo emptyRoomListInfo=null; 
		ConvertGregorianCalendar convertGregorianCalendar=new ConvertGregorianCalendar();
		
		for(EmptyRoomListDTO emptyDTO:emptyRoomListDAO.select(hotelLocation, availableDate))
		{
			
			String emptyRoomCode=emptyDTO.getRoomCode();
			String hotelName=emptyDTO.getHotelName();
			double oldPrice=emptyDTO.getOldPrice();
			double discountPrice=emptyDTO.getDiscountPrice();
			GregorianCalendar date=convertGregorianCalendar.convert(emptyDTO.getAvailableDate());
			int capacity=emptyDTO.getCapacity();
			String hotelLocation1=emptyDTO.getHotelLocation();
			
			emptyRoomListInfo=new EmptyRoomListInfo(emptyRoomCode, hotelName, oldPrice, discountPrice, date, capacity, hotelLocation1);
			list.addEmptyRoomListInfo(emptyRoomListInfo);
		}
		return list;		
	}
	
	/**
	 * 등록된 모든 공실간략정보를 EmptyRoomListDAO에 요청하여 처리결과를 EmptyRoomResrvationManger로 전달한다
	 * @return 등록된 모든 공실간략정보를 전달한다
	 */
	public EmptyRoomListInfoList getAll()
	{
		EmptyRoomListInfoList list=new EmptyRoomListInfoList();
		EmptyRoomListInfo emptyRoomListInfo=null; 
		ConvertGregorianCalendar convertGregorianCalendar=new ConvertGregorianCalendar();
		
		for(EmptyRoomListDTO emptyDTO:emptyRoomListDAO.selectAll())
		{
			
			String emptyRoomCode=emptyDTO.getRoomCode();
			String hotelName=emptyDTO.getHotelName();
			double oldPrice=emptyDTO.getOldPrice();
			double discountPrice=emptyDTO.getDiscountPrice();
			GregorianCalendar date=convertGregorianCalendar.convert(emptyDTO.getAvailableDate());
			int capacity=emptyDTO.getCapacity();
			String hotelLocation1=emptyDTO.getHotelLocation();
			
			emptyRoomListInfo=new EmptyRoomListInfo(emptyRoomCode, hotelName, oldPrice, discountPrice, date, capacity, hotelLocation1);
			list.addEmptyRoomListInfo(emptyRoomListInfo);
		}
		return list;	
	}
}
