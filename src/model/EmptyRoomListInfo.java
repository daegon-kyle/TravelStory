package model;

import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 * 공실정보목록, 공실정보 목록으로 보여주기 위해 사용하는 클래스
 * <br>EmptyRoomInfoManagerServlet, EmptyRoomReservationServlet에서 사용하는 클래스
 * @author 대곤
 *
 */
public class EmptyRoomListInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7673800241487948078L;
	/**
	 * 공실코드
	 */
	private String emptyRoomCode;
	/**
	 * 공실이름
	 */
	private String hotelName;
	/**
	 * 할인 전 가격
	 */
	private double oldPrice;
	/**
	 * 할인 가격
	 */
	private double discountPrice;
	/**
	 * 이용가능 날짜
	 */
	private GregorianCalendar availableDate;
	/**
	 * 용량
	 */
	private int capacity;
	/**
	 * 호텔위치
	 */
	private String hotelLocation;
	
	/**
	 * 널생성자
	 */
	public EmptyRoomListInfo() {
		this("","",0,0,new GregorianCalendar(), 0, "");
		
	}
	/**
	 * 기본생성자
	 * @param emptyRoomCode 공실코드
	 * @param hotelName 숙박업체명
	 * @param oldPrice 기존가격
	 * @param discountPrice 할인가격
	 * @param availableDate 이용가능날짜
	 * @param capacity 수용인원
	 * @param hotelLoaction 호텔위치
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
