package model;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ArrayList;
// ���ǵ�Ͻ� ���
/**
 * ���ǵ�Ͻ� �Է��ؾ��ϴ� ��������Ŭ����<br>EmptyRoomInfoManagerServlet�� EmptyRoomReservationServet���� ����ϴ� Ŭ����
 * @author ���
 *
 */
public class EmptyRoomInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8535579190114388996L;
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
	 * ���� ����
	 */
	private double discountPrice;
	/**
	 * ���
	 */
	private int space;
	/**
	 * �̿밡�� ��¥
	 */
	private GregorianCalendar date;
	/**
	 * ȣ���ڵ�
	 */
	private String hotelCode;
	/**
	 * üũ�� �ð�
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
	 * �̿밡�ɽü����
	 */
	private String[] facilityList;
	/**
	 * ��Ÿ
	 */
	private String etc;
	
	/**
	 * �λ�����
	 */
	public EmptyRoomInfo() {
		this("","",0.0,0.0,0, new GregorianCalendar(), "", "","",0,new String[0], "");
	}
	/**
	 * �⺻������
	 * @param emptyRoomCode �����ڵ�
	 * @param emptyRoomName �����̸�
	 * @param oldPrice ������ ����
	 * @param discountPrice ���� ����
	 * @param space ���
	 * @param date �̿밡�� ��¥
	 * @param hotelCode ȣ���ڵ�
	 * @param checkInTime üũ�� �ð�
	 * @param checkOutTime üũ�ƿ��ð�
	 * @param capacity ���
	 * @param facilityList �̿밡�ɽü����
	 * @param etc ��Ÿ
	 */
	public EmptyRoomInfo(String emptyRoomCode, String emptyRoomName,
			double oldPrice, double discountPrice, int space,
			GregorianCalendar date, String hotelCode,
			String checkInTime, String checkOutTime,
			int capacity, String[] facilityList, String etc) {
		this.emptyRoomCode = emptyRoomCode;
		this.emptyRoomName = emptyRoomName;
		this.oldPrice = oldPrice;
		this.discountPrice = discountPrice;
		this.space = space;
		this.date = date;
		this.hotelCode = hotelCode;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.capacity = capacity;
		this.facilityList = facilityList;
		this.etc = etc;
	}
	
	/**
	 * �����ڵ带 ������ ��� ����� �ֱ�ȭ�ϴ� ������ 
	 * <br> �����ڵ�� �ڵ��ο��ȴ�.
	 * @param emptyRoomName
	 * @param oldPrice
	 * @param discountPrice
	 * @param space
	 * @param date
	 * @param hotelCode
	 * @param checkInTime
	 * @param checkOutTime
	 * @param capacity
	 * @param facilityList
	 * @param etc
	 */
	public EmptyRoomInfo(String hotelCode,String emptyRoomName,	double oldPrice, double discountPrice, int space,String checkInTime, String checkOutTime,
			int capacity, String[] facilityList, String etc) {
		this(hotelCode,emptyRoomName,oldPrice,discountPrice,space,new GregorianCalendar(),hotelCode,checkInTime,checkOutTime,capacity,facilityList,etc);
	}
	public EmptyRoomInfo(String emptyRoomCode, String emptyRoomName,
			double oldPrice, double discountPrice, int space,
			 String hotelCode,
			String checkInTime, String checkOutTime,
			int capacity, String[] facilityList, String etc) {
		this.emptyRoomCode = emptyRoomCode;
		this.emptyRoomName = emptyRoomName;
		this.oldPrice = oldPrice;
		this.discountPrice = discountPrice;
		this.space = space;
		this.date = new GregorianCalendar();
		this.hotelCode = hotelCode;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.capacity = capacity;
		this.facilityList = facilityList;
		this.etc = etc;
	}
	/**
	 * ���� �ڵ� ��ȯ
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
	 * �������� ��ȯ
	 * @return �������� 
	 */
	public double getOldPrice() {
		return oldPrice;
	}
	/**
	 * ���� ���� ����
	 * @param oldPrice ��������
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
	/**|
	 * �̿밡�ɳ�¥ ����
	 * @param date �̿밡�ɳ�¥
	 */
	public void setDate(GregorianCalendar date) {
		this.date = date;
	}
	/**
	 * ȣ���ڵ� ��ȯ
	 * @return ȣ���ڵ�
	 */
	public String getHotelCode() {
		return hotelCode;
	}
	/**
	 * ȣ���ڵ� ����
	 * @param hotelCode
	 */
	public void setHotelCode(String hotelCode) {
		this.hotelCode = hotelCode;
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
	 * üũ�ƿ� �ð� ��ȯ
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
	public String[] getFacilityList() {
		return facilityList;
	}
	/**
	 * �̿밡�ɽü���� ����
	 * @param facilityList �̿밡�ɽü����
	 */
	public void setFacilityList(String[] facilityList) {
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
	 * ��Ÿ ���� ����
	 * @param etc ��Ÿ���� ����
	 */
	public void setEtc(String etc) {
		this.etc = etc;
	}
}
