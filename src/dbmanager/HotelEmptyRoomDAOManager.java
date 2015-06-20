package dbmanager;

import java.util.List;

import converter.ConvertGregorianCalendar;

import dao.EmptyRoomDAO;
import dto.EmptyRoomDTO;
import model.EmptyRoomInfoList;
import model.EmptyRoomInfo;

/**
 * application���� �Ŵ����� EmptyRoomInfoManager���� �������� ������ ���� ��û�� �޾� ó���� �����Ѵ�
 * @author ȭ��
 *
 */
public class HotelEmptyRoomDAOManager 
{
	private EmptyRoomDAO emptyRoomDAO;
	
	/**
	 * �������� ���̺� ���� Ŭ���� EmptyRoomDAO�� �ν��Ͻ�ȭ �Ѵ�
	 */
	public HotelEmptyRoomDAOManager()
	{
		emptyRoomDAO=new EmptyRoomDAO();
	}
	
	/**
	 * ȭ���ڵ忡 �ش��ϴ� ���ھ�ü�ڵ带 EmptyRoomDAO�� ��û�Ͽ� ����� application���� �Ŵ����� EmptyRoomInfoManager�� �����Ѵ�
	 * @param memberCode ȸ���ڵ�
	 * @return ȸ���ڵ忡 �ش��ϴ� ���ھ�ü �ڵ�
	 */
	public String getHotelCode(String memberCode)
	{
		return null;
	}
	
	/**
	 * ���ھ�ü�ڵ忡 �ش��ϴ� ������������ EmptyRoomDAO�� ��û�Ͽ� ����� application���� �Ŵ����� EmptyRoomInfoManager�� �����Ѵ�
	 * @param hotelManagerCode
	 * @return
	 */
	public EmptyRoomInfoList getEmptyRoomInfos(String hotelManagerCode)
	{
		System.out.println("HotelEmptyRoomDAO : "+ hotelManagerCode);
		EmptyRoomInfoList emptyRoomInfoList = new EmptyRoomInfoList();
		List<EmptyRoomDTO> list = emptyRoomDAO.selectEmptyRooms(hotelManagerCode);
		for(EmptyRoomDTO room : list){
			String[] facilityList = room.getFacilityList().split(",");
			EmptyRoomInfo emptyRoomInfo = new EmptyRoomInfo(room.getEmptyRoomCode(),room.getRoomName(), room.getOldPrice(), room.getDiscountPrice(), room.getSpace(),new ConvertGregorianCalendar().convert( room.getAvailableDate()),room.getHotelManagerCode(), room.getCheckInTime(), room.getCheckOutTime(), room.getCapacity(), facilityList, room.getEtc());
			emptyRoomInfoList.addEmptyRoomInfo(emptyRoomInfo);
		}
		return emptyRoomInfoList;
	}
	
	/**
	 * �������� ������ EmptyRoomDAO�� ��û�Ͽ� application���� �Ŵ����� EmptyRoomInfoManager�� ó������� �����Ѵ�
	 * @param emptyRoomInfo ��������
	 * @return �������� �����Ѵ�
	 */
	public boolean saveEmptyRoom(EmptyRoomInfo emptyRoomInfo)
	{
		String facilityList="";
		for(String str :emptyRoomInfo.getFacilityList() ){
			facilityList+=str;
			facilityList+=",";
		}
		return emptyRoomDAO.insert(emptyRoomInfo.getHotelCode(), emptyRoomInfo.getEmptyRoomName(), emptyRoomInfo.getDiscountPrice(), 
				emptyRoomInfo.getOldPrice(), emptyRoomInfo.getCapacity(), emptyRoomInfo.getSpace(), emptyRoomInfo.getCheckInTime(),
				emptyRoomInfo.getCheckOutTime(),facilityList , emptyRoomInfo.getEtc());
	}
	
	/**
	 * ��ϵ� ��� �������� ������ EmptyRoomDAO�� ��û�Ͽ� application���� �Ŵ����� EmptyRoomInfoManager�� ��������� �����Ѵ�
	 * @return �������
	 */
	public boolean deleteAllEmptyRoom()
	{
		return true;
	}
	
	/**
	 * �������� �ڵ忡 �ش��ϴ� �������� ������ EmptyRoomDAO�� ��û�Ͽ� application���� �Ŵ����� EmptyRoomInfoManager�� ��������� �����Ѵ�
	 * @param emptyRoomCode
	 * @return �������
	 */
	public boolean deleteEmptyRoom(String emptyRoomCode)
	{
		EmptyRoomDAO emptyRoomDAO = new EmptyRoomDAO();
		return emptyRoomDAO.deleteEmptyRoom(emptyRoomCode);
	}
	
	/**
	 * ���ھ�ü�ڵ忡 �ش��ϴ� �������� ������ EmptyRoomDAO�� ��û�Ͽ� application���� �Ŵ����� EmptyRoomInfoManager�� ��������� �����Ѵ�
	 * @param hotelManagerCode
	 * @return �������
	 */
	public boolean deleteEmptyRooms(String hotelManagerCode)
	{
		return true;
	}
	
	/**
	 * �������� ������ EmptyROomDAO�� ��û�Ͽ� application���� ������ EmptyRoomInfoManager�� ��������� �����Ѵ�
	 * @param emptyRoomCode ���������ڵ�
	 * @param modifyInfo ������ ��������
	 * @return �������
	 */
	public boolean update(String emptyRoomCode, EmptyRoomInfo modifyInfo)
	{
		System.out.println("HotelEmptyRoomDAOManager: "+emptyRoomCode);
		String facilityList="";
		for(String str :modifyInfo.getFacilityList() ){
			facilityList+=str;
			facilityList+=",";
		}System.out.println("HotelEmptyRoomDAOManager update�޼ҵ� : "+facilityList);
		return emptyRoomDAO.update(emptyRoomCode, modifyInfo.getEmptyRoomName(), modifyInfo.getDiscountPrice(), modifyInfo.getOldPrice(), modifyInfo.getCapacity(), 
				modifyInfo.getSpace(), modifyInfo.getCheckInTime(), modifyInfo.getCheckOutTime(), facilityList, modifyInfo.getEtc());
	}
}
