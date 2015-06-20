package model;

import java.io.Serializable; 
import java.util.GregorianCalendar; 
/**
 * 공실 상세정보
 * <br>EmptyRoomReservationServlet에서 사용하는 클래스
 * @author 대곤
 *
 */
public class EmptyRoomDetailInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2019535131607127135L;
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
	 * 할인가격
	 */
	private double discountPrice;
	/**
	 * 평수
	 */
	private int space;
	/**
	 * 이용가능한 날짜
	 */
	private GregorianCalendar date;
	/**
	 * 체크인시간
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
	 * 이용가능 시설목록
	 */
	private String facilityList;
	/**
	 * 기타
	 */
	private String etc;
	/**
	 * 호텔이름
	 */
	private String hotelName;
	/**
	 * 호텔위치
	 */
	private String hotelLocation;
	/**
	 * 호텔 소개
	 */
	private String hotelIntroduction;
	/**
	 * 호텔페이지 경로
	 */
	private String hotelPagePath;
	/**
	 * 널생성자
	 */
	public EmptyRoomDetailInfo() {
		this("","",0,0,0,new GregorianCalendar(),"","",0,"","","","","","");
	}
/**
 * 기본 생성자
 * @param emptyRoomCode 공실코드
 * @param emptyRoomName 공실이름
 * @param oldPrice 할인전 가격
 * @param discountPrice 할인가격
 * @param space 평수
 * @param date 이용가능한 날짜
 * @param checkInTime 체크인시간
 * @param checkOutTime 체크아웃시간
 * @param capacity 수용인원
 * @param facilityList 이용가능 시설목록
 * @param etc 기타
 * @param hotelName 호텔이름
 * @param hotelLocation 호텔위치
 * @param hotelIntroduction 호텔 소개
 * @param hotelPagePath 호텔페이지 경로
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
	 * 공실코드 반환
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
 * 할인전 가격 반환
 * @return 할인전 가격
 */
	public double getOldPrice() {
		return oldPrice;
	}
/**
 * 할인전 가격 설정
 * @param oldPrice 할인전가격
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
/**
 * 이용가능날짜 설정
 * @param date 이용가능날짜
 */
	public void setDate(GregorianCalendar date) {
		this.date = date;
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
 * 체크아웃시간 반환
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
	public String getFacilityList() {
		return facilityList;
	}
/**
 * 이용가능시설목록 설정
 * @param facilityList 이용가능시설목록
 */
	public void setFacilityList(String facilityList) {
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
 * 기타정보 설정
 * @param etc 기타정보
 */
	public void setEtc(String etc) {
		this.etc = etc;
	}
/**
 * 호텔명 반환
 * @return 호텔명
 */
	public String getHotelName() {
		return hotelName;
	}
/**
 * 호텔명 설정
 * @param hotelName 호텔명
 */
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	/**
	 * 호텔위치 반환
	 * @return 호텔위치
	 */
	public String getHotelLocation() {
		return hotelLocation;
	}
/**
 * 호텔위치 설정
 * @param hotelLocation 호텔위치
 */
	public void setHotelLocation(String hotelLocation) {
		this.hotelLocation = hotelLocation;
	}
/**
 * 호텔소개 반환
 * @return 호텔소개
 */
	public String getHotelIntroduction() {
		return hotelIntroduction;
	}
/**
 * 호텔소개 설정
 * @param hotelIntroduction 호텔소개
 */
	public void setHotelIntroduction(String hotelIntroduction) {
		this.hotelIntroduction = hotelIntroduction;
	}
/**
 * 호텔예약페이지 반환
 * @return 호텔예약페이지
 */
	public String getHotelPagePath() {
		return hotelPagePath;
	}
/**
 * 호텔예약페이지 설정
 * @param hotelPagePath 호텔예약페이지
 */
	public void setHotelPagePath(String hotelPagePath) {
		this.hotelPagePath = hotelPagePath;
	}
	
	
}
