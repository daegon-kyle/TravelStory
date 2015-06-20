package model;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ArrayList;
// 공실등록시 사용
/**
 * 공실등록시 입력해야하는 공실정보클래스<br>EmptyRoomInfoManagerServlet과 EmptyRoomReservationServet에서 사용하는 클래스
 * @author 대곤
 *
 */
public class EmptyRoomInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8535579190114388996L;
	/**
	 * 공실코드
	 */
	private String emptyRoomCode;
	/**
	 * 공실이름
	 */
	private String emptyRoomName;
	/**
	 * 할인전 가격
	 */
	private double oldPrice;
	
	/**
	 * 할인 가격
	 */
	private double discountPrice;
	/**
	 * 평수
	 */
	private int space;
	/**
	 * 이용가능 날짜
	 */
	private GregorianCalendar date;
	/**
	 * 호텔코드
	 */
	private String hotelCode;
	/**
	 * 체크인 시간
	 */
	private String checkInTime;
	/**
	 * 체크아웃시간
	 */
	private String checkOutTime;
	/**
	 * 평수
	 */
	private int capacity;
	/**
	 * 이용가능시설목록
	 */
	private String[] facilityList;
	/**
	 * 기타
	 */
	private String etc;
	
	/**
	 * 널생성자
	 */
	public EmptyRoomInfo() {
		this("","",0.0,0.0,0, new GregorianCalendar(), "", "","",0,new String[0], "");
	}
	/**
	 * 기본생성자
	 * @param emptyRoomCode 공실코드
	 * @param emptyRoomName 공실이름
	 * @param oldPrice 할인전 가격
	 * @param discountPrice 할인 가격
	 * @param space 평수
	 * @param date 이용가능 날짜
	 * @param hotelCode 호텔코드
	 * @param checkInTime 체크인 시간
	 * @param checkOutTime 체크아웃시간
	 * @param capacity 평수
	 * @param facilityList 이용가능시설목록
	 * @param etc 기타
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
	 * 공실코드를 제외한 모든 멤버를 최기화하는 생성자 
	 * <br> 공실코드는 자동부여된다.
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
	 * 공실 코드 반환
	 * @return 공실코드
	 */
	public String getEmptyRoomCode() {
		return emptyRoomCode;
	}
	/**
	 * 공실코드 설정
	 * @param emptyRoomCode 공실코드
	 */
	public void setEmptyRoomCode(String emptyRoomCode) {
		this.emptyRoomCode = emptyRoomCode;
	}
	/**
	 * 공실이름 반환
	 * @return 공실이름
	 */
	public String getEmptyRoomName() {
		return emptyRoomName;
	}
	/**
	 * 공실이름 설정
	 * @param emptyRoomName 공실이름
	 */
	public void setEmptyRoomName(String emptyRoomName) {
		this.emptyRoomName = emptyRoomName;
	}
	/**
	 * 기존가격 반환
	 * @return 기존가격 
	 */
	public double getOldPrice() {
		return oldPrice;
	}
	/**
	 * 기존 가격 설정
	 * @param oldPrice 기존가격
	 */
	public void setOldPrice(double oldPrice) {
		this.oldPrice = oldPrice;
	}
	/**
	 * 할인가격 반환
	 * @return 할인가격
	 */
	public double getDiscountPrice() {
		return discountPrice;
	}
	/**
	 * 할인가격 설정
	 * @param discountPrice 할인가격
	 */
	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}
	/**
	 * 평수 반환
	 * @return 평수
	 */
	public int getSpace() {
		return space;
	}
	/**
	 * 평수 설정
	 * @param space 평수
	 */
	public void setSpace(int space) {
		this.space = space;
	}
	/**
	 * 이용가능날짜 반환
	 * @return 이용가능날짜
	 */
	public GregorianCalendar getDate() {
		return date;
	}
	/**|
	 * 이용가능날짜 설정
	 * @param date 이용가능날짜
	 */
	public void setDate(GregorianCalendar date) {
		this.date = date;
	}
	/**
	 * 호텔코드 반환
	 * @return 호텔코드
	 */
	public String getHotelCode() {
		return hotelCode;
	}
	/**
	 * 호텔코드 설정
	 * @param hotelCode
	 */
	public void setHotelCode(String hotelCode) {
		this.hotelCode = hotelCode;
	}
	/**
	 * 체크인시간 반환
	 * @return 체크인시간
	 */
	public String getCheckInTime() {
		return checkInTime;
	}
	/**
	 * 체크인시간 설정
	 * @param checkInTime 체크인시간
	 */
	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}
	/**
	 * 체크아웃 시간 반환
	 * @return 체크아웃시간
	 */
	public String getCheckOutTime() {
		return checkOutTime;
	}
	/**
	 * 체크아웃 시간 설정
	 * @param checkOutTime 체크아웃시간
	 */
	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
	}
	/**
	 * 평수 반환
	 * @return 평수
	 */
	public int getCapacity() {
		return capacity;
	}
	/**
	 * 평수 설정
	 * @param capacity 평수
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	/**
	 * 이용가능시설목록 반환
	 * @return 이용가능시설목록
	 */
	public String[] getFacilityList() {
		return facilityList;
	}
	/**
	 * 이용가능시설목록 설정
	 * @param facilityList 이용가능시설목록
	 */
	public void setFacilityList(String[] facilityList) {
		this.facilityList = facilityList;
	}
	/**
	 * 기타정보 반환
	 * @return 기타정보
	 */
	public String getEtc() {
		return etc;
	}
	/**
	 * 기타 정보 설정
	 * @param etc 기타정보 설정
	 */
	public void setEtc(String etc) {
		this.etc = etc;
	}
}
