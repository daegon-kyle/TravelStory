package model;

import java.io.Serializable; 
import java.util.GregorianCalendar; 
/**
 * ���� ������
 * <br>EmptyRoomReservationServlet���� ����ϴ� Ŭ����
 * @author ���
 *
 */
public class EmptyRoomDetailInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2019535131607127135L;
	/**
	 * �����ڵ�
	 */
	private String emptyRoomCode;
	/**
	 * �����̸�
	 */
	private String emptyRoomName;
	/**
	 * ������ ����
	 */
	private double oldPrice;
	/**
	 * ���ΰ���
	 */
	private double discountPrice;
	/**
	 * ���
	 */
	private int space;
	/**
	 * �̿밡���� ��¥
	 */
	private GregorianCalendar date;
	/**
	 * üũ�νð�
	 */
	private String checkInTime;
	/**
	 * üũ�ƿ��ð�
	 */
	private String checkOutTime;
	/**
	 * ���
	 */
	private int capacity;
	/**
	 * �̿밡�� �ü����
	 */
	private String facilityList;
	/**
	 * ��Ÿ
	 */
	private String etc;
	/**
	 * ȣ���̸�
	 */
	private String hotelName;
	/**
	 * ȣ����ġ
	 */
	private String hotelLocation;
	/**
	 * ȣ�� �Ұ�
	 */
	private String hotelIntroduction;
	/**
	 * ȣ�������� ���
	 */
	private String hotelPagePath;
	/**
	 * �λ�����
	 */
	public EmptyRoomDetailInfo() {
		this("","",0,0,0,new GregorianCalendar(),"","",0,"","","","","","");
	}
/**
 * �⺻ ������
 * @param emptyRoomCode �����ڵ�
 * @param emptyRoomName �����̸�
 * @param oldPrice ������ ����
 * @param discountPrice ���ΰ���
 * @param space ���
 * @param date �̿밡���� ��¥
 * @param checkInTime üũ�νð�
 * @param checkOutTime üũ�ƿ��ð�
 * @param capacity �����ο�
 * @param facilityList �̿밡�� �ü����
 * @param etc ��Ÿ
 * @param hotelName ȣ���̸�
 * @param hotelLocation ȣ����ġ
 * @param hotelIntroduction ȣ�� �Ұ�
 * @param hotelPagePath ȣ�������� ���
 */
	public EmptyRoomDetailInfo(String emptyRoomCode, String emptyRoomName,
			double oldPrice, double discountPrice, int space,
			GregorianCalendar date, String checkInTime,
			String checkOutTime, int capacity,
			String facilityList, String etc, String hotelName,
			String hotelLocation, String hotelIntroduction, String hotelPagePath) {
		this.emptyRoomCode = emptyRoomCode;
		this.emptyRoomName = emptyRoomName;
		this.oldPrice = oldPrice;
		this.discountPrice = discountPrice;
		this.space = space; 
		this.date = date;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.capacity = capacity;
		this.facilityList = facilityList;
		this.etc = etc;
		this.hotelName = hotelName;
		this.hotelLocation = hotelLocation;
		this.hotelIntroduction = hotelIntroduction;
		this.hotelPagePath = hotelPagePath;
	}
	/**
	 * �����ڵ� ��ȯ
	 * @return �����ڵ�
	 */
	public String getEmptyRoomCode() {
		return emptyRoomCode;
	}
/**
 * �����ڵ� ����
 * @param emptyRoomCode �����ڵ�
 */
	public void setEmptyRoomCode(String emptyRoomCode) {
		this.emptyRoomCode = emptyRoomCode;
	}
/**
 * �����̸� ��ȯ
 * @return �����̸�
 */
	public String getEmptyRoomName() {
		return emptyRoomName;
	}
/**
 * �����̸� ����
 * @param emptyRoomName �����̸�
 */
	public void setEmptyRoomName(String emptyRoomName) {
		this.emptyRoomName = emptyRoomName;
	}
/**
 * ������ ���� ��ȯ
 * @return ������ ����
 */
	public double getOldPrice() {
		return oldPrice;
	}
/**
 * ������ ���� ����
 * @param oldPrice ����������
 */
	public void setOldPrice(double oldPrice) {
		this.oldPrice = oldPrice;
	}
/**
 * ���ΰ��� ��ȯ
 * @return ���ΰ���
 */
	public double getDiscountPrice() {
		return discountPrice;
	}

	/**
	 * ���ΰ��� ����
	 * @param discountPrice ���ΰ���
	 */
	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}
/**
 * ��� ��ȯ
 * @return ���
 */
	public int getSpace() {
		return space;
	}
/**
 * ��� ����
 * @param space ���
 */
	public void setSpace(int space) {
		this.space = space;
	}
/**
 * �̿밡�ɳ�¥ ��ȯ
 * @return �̿밡�ɳ�¥
 */
	public GregorianCalendar getDate() {
		return date;
	}
/**
 * �̿밡�ɳ�¥ ����
 * @param date �̿밡�ɳ�¥
 */
	public void setDate(GregorianCalendar date) {
		this.date = date;
	}
/**
 * üũ�νð� ��ȯ
 * @return üũ�νð�
 */
	public String getCheckInTime() {
		return checkInTime;
	}
/**
 * üũ�νð� ����
 * @param checkInTime üũ�νð�
 */
	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}
/**
 * üũ�ƿ��ð� ��ȯ
 * @return üũ�ƿ��ð�
 */
	public String getCheckOutTime() {
		return checkOutTime;
	}
/**
 * üũ�ƿ� �ð� ����
 * @param checkOutTime üũ�ƿ��ð�
 */
	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
	}
/**
 * ��� ��ȯ
 * @return ���
 */
	public int getCapacity() {
		return capacity;
	}
/**
 * ��� ����
 * @param capacity ���
 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
/**
 * �̿밡�ɽü���� ��ȯ
 * @return �̿밡�ɽü����
 */
	public String getFacilityList() {
		return facilityList;
	}
/**
 * �̿밡�ɽü���� ����
 * @param facilityList �̿밡�ɽü����
 */
	public void setFacilityList(String facilityList) {
		this.facilityList = facilityList;
	}
/**
 * ��Ÿ���� ��ȯ
 * @return ��Ÿ����
 */
	public String getEtc() {
		return etc;
	}
/**
 * ��Ÿ���� ����
 * @param etc ��Ÿ����
 */
	public void setEtc(String etc) {
		this.etc = etc;
	}
/**
 * ȣ�ڸ� ��ȯ
 * @return ȣ�ڸ�
 */
	public String getHotelName() {
		return hotelName;
	}
/**
 * ȣ�ڸ� ����
 * @param hotelName ȣ�ڸ�
 */
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	/**
	 * ȣ����ġ ��ȯ
	 * @return ȣ����ġ
	 */
	public String getHotelLocation() {
		return hotelLocation;
	}
/**
 * ȣ����ġ ����
 * @param hotelLocation ȣ����ġ
 */
	public void setHotelLocation(String hotelLocation) {
		this.hotelLocation = hotelLocation;
	}
/**
 * ȣ�ڼҰ� ��ȯ
 * @return ȣ�ڼҰ�
 */
	public String getHotelIntroduction() {
		return hotelIntroduction;
	}
/**
 * ȣ�ڼҰ� ����
 * @param hotelIntroduction ȣ�ڼҰ�
 */
	public void setHotelIntroduction(String hotelIntroduction) {
		this.hotelIntroduction = hotelIntroduction;
	}
/**
 * ȣ�ڿ��������� ��ȯ
 * @return ȣ�ڿ���������
 */
	public String getHotelPagePath() {
		return hotelPagePath;
	}
/**
 * ȣ�ڿ��������� ����
 * @param hotelPagePath ȣ�ڿ���������
 */
	public void setHotelPagePath(String hotelPagePath) {
		this.hotelPagePath = hotelPagePath;
	}
	
	
}
