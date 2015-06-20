package model;

import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 * �����������, �������� ������� �����ֱ� ���� ����ϴ� Ŭ����
 * <br>EmptyRoomInfoManagerServlet, EmptyRoomReservationServlet���� ����ϴ� Ŭ����
 * @author ���
 *
 */
public class EmptyRoomListInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7673800241487948078L;
	/**
	 * �����ڵ�
	 */
	private String emptyRoomCode;
	/**
	 * �����̸�
	 */
	private String hotelName;
	/**
	 * ���� �� ����
	 */
	private double oldPrice;
	/**
	 * ���� ����
	 */
	private double discountPrice;
	/**
	 * �̿밡�� ��¥
	 */
	private GregorianCalendar availableDate;
	/**
	 * �뷮
	 */
	private int capacity;
	/**
	 * ȣ����ġ
	 */
	private String hotelLocation;
	
	/**
	 * �λ�����
	 */
	public EmptyRoomListInfo() {
		this("","",0,0,new GregorianCalendar(), 0, "");
		
	}
	/**
	 * �⺻������
	 * @param emptyRoomCode �����ڵ�
	 * @param hotelName ���ھ�ü��
	 * @param oldPrice ��������
	 * @param discountPrice ���ΰ���
	 * @param availableDate �̿밡�ɳ�¥
	 * @param capacity �����ο�
	 * @param hotelLoaction ȣ����ġ
	 */

	public EmptyRoomListInfo(String emptyRoomCode, String hotelName,
			double oldPrice, double discountPrice, GregorianCalendar availableDate,
			int capacity, String hotelLocation) {
		super();
		this.emptyRoomCode = emptyRoomCode;
		this.hotelName = hotelName;
		this.oldPrice = oldPrice;
		this.discountPrice = discountPrice;
		this.availableDate = availableDate;
		this.capacity = capacity;
		this.hotelLocation = hotelLocation;
	}
	public String getEmptyRoomCode() {
		return emptyRoomCode;
	}
	public void setEmptyRoomCode(String emptyRoomCode) {
		this.emptyRoomCode = emptyRoomCode;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public double getOldPrice() {
		return oldPrice;
	}
	public void setOldPrice(double oldPrice) {
		this.oldPrice = oldPrice;
	}
	public double getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}
	public GregorianCalendar getAvailableDate() {
		return availableDate;
	}
	public void setDate(GregorianCalendar availableDate) {
		this.availableDate = availableDate;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getHotelLocation() {
		return hotelLocation;
	}
	public void setHotelLocation(String hotelLocation) {
		this.hotelLocation = hotelLocation;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "EmptyRoomListInfo [emptyRoomCode=" + emptyRoomCode
				+ ", hotelName=" + hotelName + ", oldPrice=" + oldPrice
				+ ", discountPrice=" + discountPrice + ", availableDate="
				+ availableDate + ", capacity=" + capacity + ", hotelLocation="
				+ hotelLocation + "]";
	}
	
	
	
	
}
