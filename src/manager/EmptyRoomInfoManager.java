package manager;

import dbmanager.HotelEmptyRoomDAOManager;
import model.EmptyRoomInfo;
import model.EmptyRoomInfoList;
/**
 * ���������� �����ϱ� ���� ����ϴ� �Ŵ���
 * @author ���
 *
 */
public class EmptyRoomInfoManager {
	/**
	 * ��������
	 */
	private EmptyRoomInfo emptyRoomInfo;
	
	/**
	 * �λ�����
	 */
	public EmptyRoomInfoManager() {
		this(new EmptyRoomInfo());
	}
/**
 * �⺻������
 * @param emptyRoomInfo ��������
 */
	public EmptyRoomInfoManager(EmptyRoomInfo emptyRoomInfo) {
		this.emptyRoomInfo = emptyRoomInfo;
	}
/**
 * �������� ��ȯ
 * @return ��������
 */
	public EmptyRoomInfo getEmptyRoomInfo() {
		return emptyRoomInfo;
	}
/**
 * �������� ����
 * @param emptyRoomInfo ��������
 */
	public void setEmptyRoomInfo(EmptyRoomInfo emptyRoomInfo) {
		this.emptyRoomInfo = emptyRoomInfo;
	}
	/**
	 * �������� �߰�, HotelEmptyRoomDAOManager�� save�޼ҵ� ȣ��
	 * @return �߰��� ��������
	 */
	public boolean addEmptyRoomInfo(){
		HotelEmptyRoomDAOManager hotelEmptyRoomDAOManager = new HotelEmptyRoomDAOManager();		
		return hotelEmptyRoomDAOManager.saveEmptyRoom(emptyRoomInfo);
	}
	/**
	 * �������� ����, HotelEmptyRoomDAOManager�� deleteEmptyRoom�޼ҵ� ȣ��
	 * @return ������ ��������
	 */
	public EmptyRoomInfo deleteEmptyRoomInfo(){
		return null;
	}
	/**
	 * �����ڵ带 �̿��Ͽ� ���������� �����Ѵ�. 
	 * @param emptyRoomCode
	 * @return ���������� true ��ȯ , �ƴϸ� false
	 */
	public boolean deleteEmptyRoomInfo(String emptyRoomCode){
		HotelEmptyRoomDAOManager hotelEmptyRoomDAOManager  = new HotelEmptyRoomDAOManager();
		return hotelEmptyRoomDAOManager.deleteEmptyRoom(emptyRoomCode);
	}
	/**
	 * �������� ����, HotelEmptyRoomDAOManager�� modify�޼ҵ� ȣ��
	 * @return ������ ��������
	 */
	public EmptyRoomInfo reviseEmptyRoomInfo(){
		System.out.println("EmptyRoomInfoManager: ����");
		HotelEmptyRoomDAOManager hotelEmptyRoomDAOManager  = new HotelEmptyRoomDAOManager();
		if(hotelEmptyRoomDAOManager.update(emptyRoomInfo.getEmptyRoomCode(), emptyRoomInfo)){
			return emptyRoomInfo;
		}
		return null;
	}
	
	public EmptyRoomInfoList searchEmptyRoomInfo(){
		HotelEmptyRoomDAOManager hotelEmptyRoomDAOManager = new HotelEmptyRoomDAOManager();
		return hotelEmptyRoomDAOManager.getEmptyRoomInfos(emptyRoomInfo.getHotelCode());		
	}
	
}
