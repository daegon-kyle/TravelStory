//작성날짜 : 2014/7/19
//작성자 : 이화섭

package dto;

/**
 * 공실정보 테이블 정보를 저장할 클래스
 * @author 화섭
 *
 */
public class EmptyRoomDetailInfoDTO 
{
	private String roomCode;
	private String hotelName;
	private String roomName;
	private String availableDate;
	private String hotelLocation;
	private double oldPrice;
	private double discountPrice;
	private String checkInTime;
	private String checkOutTime;
	private int roomSpace;
	private int roomCapacity;
	private String hotelFacilityList;
	private String roomEtc;
	private String hotelPagePath;
	private String hotelIntroduction;
	
	/**
	 * 기본생성자
	 */
	public EmptyRoomDetailInfoDTO()
	{
		this("","","","","",0,0,"","",0,0,"","","","");
	}
	
	/**
	 * 전달인자를 받는 생성자
	 * @param roomCode 방코드
	 * @param hotelName 호텔명
	 * @param roomName 공실명
	 * @param availableDate 이용가능일
	 * @param hotelLocation 호텔위치
	 * @param oldPrice 이전가격
	 * @param discountPrice 할인가
	 * @param checkInTime 체크인시간
	 * @param checkOutTime 체크아웃시간
	 * @param roomSpace 방공간
	 * @param roomCapacity 수용인원
	 * @param hotelFacilityList 주변시설
	 * @param roomEtc 공실소개
	 * @param hotelPagePath 홈페이지 주소
	 * @param hotelIntroduction 호텔소개
	 */
	public EmptyRoomDetailInfoDTO(String roomCode, String hotelName, String roomName, String availableDate, String hotelLocation, double oldPrice, double discountPrice, String checkInTime, String checkOutTime, int roomSpace, int roomCapacity, String hotelFacilityList, String roomEtc, String hotelPagePath, String hotelIntroduction) 
	{ 
		this.roomCode = roomCode;
		this.hotelName = hotelName;
		this.roomName = roomName;
		this.availableDate = availableDate;
		this.hotelLocation = hotelLocation;
		this.oldPrice = oldPrice;
		this.discountPrice = discountPrice;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.roomSpace = roomSpace;
		this.roomCapacity = roomCapacity;
		this.hotelFacilityList = hotelFacilityList;
		this.roomEtc = roomEtc;
		this.hotelPagePath = hotelPagePath;
		this.hotelIntroduction=hotelIntroduction;
	}
	
	/**
	 * 공실코드를 리턴한다
	 * @return
	 */
	public String getRoomCode() {
		return roomCode;
	}
	/**
	 * 공실코드를 설정한다
	 * @param roomCode
	 */
	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}
	/**
	 * 호텔이름을 리턴한다
	 * @return
	 */
	public String getHotelName() {
		return hotelName;
	}
	/**
	 * 호텔이름을 설정한다
	 */
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	/**
	 * 공실이름을 리턴한다
	 * @return
	 */
	public String getRoomName() {
		return roomName;
	}
	/**
	 * 공실이름을 설정한다
	 * @param roomName
	 */
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	/**
	 * 이용가능날짜를 리턴한다
	 * @return
	 */
	public String getAvailableDate() {
		return availableDate;
	}
	/**
	 * 이용가능날짜를 설정한다
	 * @param availableDate
	 */
	public void setAvailableDate(String availableDate) {
		this.availableDate = availableDate;
	}
	/**
	 * 호텔위치를 리턴한다
	 * @return
	 */
	public String getHotelLocation() {
		return hotelLocation;
	}
	/**
	 * 호텔위치를 설정한다
	 * @param hotelLocation
	 */
	public void setHotelLocation(String hotelLocation) {
		this.hotelLocation = hotelLocation;
	}
	/**
	 * 기존가격을 리턴한다
	 * @return
	 */
	public double getOldPrice() {
		return oldPrice;
	}
	/**
	 * 기존가격을 설정한다
	 * @param oldPrice
	 */
	public void setOldPrice(double oldPrice) {
		this.oldPrice = oldPrice;
	}
	/**
	 * 할인가격을 리턴한다
	 * @return
	 */
	public double getDiscountPrice() {
		return discountPrice;
	}
	/**
	 * 할인가격을 설정한다
	 */
	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}
	/**
	 * 체크인시간을 리턴한다
	 * @return
	 */
	public String getCheckInTime() {
		return checkInTime;
	}
	/**
	 * 체크인시간을 설정한다
	 * @param checkInTime
	 */
	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}
	/**
	 * 체크아웃시간을 리턴한다
	 * @return
	 */
	public String getCheckOutTime() {
		return checkOutTime;
	}
	/**
	 * 체크아웃시간을 설정한다
	 * @param checkOutTime
	 */
	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
	}
	/**
	 * 방크기를 리턴한다
	 * @return
	 */
	public int getRoomSpace() {
		return roomSpace;
	}
	/**
	 * 방킈기를 설정한다
	 * @param roomSpace
	 */
	public void setRoomSpace(int roomSpace) {
		this.roomSpace = roomSpace;
	}
	/**
	 * 방수용인원을 리턴한다
	 * @return
	 */
	public int getRoomCapacity() {
		return roomCapacity;
	}
	/**
	 * 방수용인원을 설정한다
	 * @param roomCapacity
	 */
	public void setRoomCapacity(int roomCapacity) {
		this.roomCapacity = roomCapacity;
	}
	/**
	 * 주별시설을 리턴한다
	 * @return
	 */
	public String getHotelFacilityList() {
		return hotelFacilityList;
	}
	/**
	 * 주변시설을 설정한다
	 * @param hotelFacilityList
	 */
	public void setHotelFacilityList(String hotelFacilityList) {
		this.hotelFacilityList = hotelFacilityList;
	}
	/**
	 * 공실소개를 리턴한다
	 * @return
	 */
	public String getRoomEtc() {
		return roomEtc;
	}
	/**
	 * 공실소개를 설정한다
	 * @param roomEtc
	 */
	public void setRoomEtc(String roomEtc) {
		this.roomEtc = roomEtc;
	}
	/**
	 * 호텔홈페이지주소를 리턴한다
	 * @return
	 */
	public String getHotelPagePath() {
		return hotelPagePath;
	}
	/**
	 * 호텔주소를 설정한다
	 * @param hotelPagePath
	 */
	public void setHotelPagePath(String hotelPagePath) {
		this.hotelPagePath = hotelPagePath;
	}
	/**
	 * 호텔소개를 리턴한다
	 * @return
	 */
	public String getHotelIntroduction()
	{
		return hotelIntroduction;
	}
	
	/**
	 * 호텔소개를 설정한다
	 * @param hotelIntroduction 호텔소개
	 */
	public void setHotelIntroduction(String hotelIntroduction)
	{
		this.hotelIntroduction=hotelIntroduction;
	}
}
