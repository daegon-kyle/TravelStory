package dbmanager;

import java.util.GregorianCalendar; 
import converter.ConvertGregorianCalendar;
import dao.EmptyRoomListDAO;
import dto.EmptyRoomListDTO;
import model.EmptyRoomListInfoList;
import model.EmptyRoomListInfo;
/**
 * application ���� �Ŵ����� EmptyRoomReservationManager�κ��� ���� ���� ���� ���� ��û�� �޾� ó���� �����ϴ� Ŭ����
 * @author ȭ��
 *
 */
public class EmptyRoomListDAOManager 
{
	private EmptyRoomListDAO emptyRoomListDAO;
	
	
	
	/**
	 * ������������ EmptyRoomListDAOŬ������ �ν��Ͻ�ȭ�Ѵ�
	 */
	public EmptyRoomListDAOManager()
	{
		emptyRoomListDAO=new EmptyRoomListDAO();
	}
	
	/**
	 * ���ھ�ü ��ġ�� �̿밡�ɳ�¥�� �ش��ϴ� ���ǰ��������� EmptyRoomListDAO�� ��û�Ͽ� ó������� EmptyRoomResrvationManger�� �����Ѵ�
	 * @param hotelLocation ���ھ�ü��ġ
	 * @param availableDate �̿밡�ɳ�¥
	 * @return ���ھ�ü��ġ�� �̿밡�ɳ�¥�� �ش��ϴ� ���ǰ��������� �����Ѵ�
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
	 * ��ϵ� ��� ���ǰ��������� EmptyRoomListDAO�� ��û�Ͽ� ó������� EmptyRoomResrvationManger�� �����Ѵ�
	 * @return ��ϵ� ��� ���ǰ��������� �����Ѵ�
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
