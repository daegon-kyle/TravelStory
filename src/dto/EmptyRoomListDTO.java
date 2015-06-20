//작성날짜 : 2014/7/19
//작성자 : 이화섭

package dto;

/**
 * 공실리스트 테이블 정보를저장할 클래스
 * @author 화섭
 *
 */
public class EmptyRoomListDTO 
{
	private String roomCode;
	private String hotelName;
	private double oldPrice;
	private double discountPrice;
	private int capacity;
	private String hotelLocation;
	private String availableDate;
	
	/**
	 * 기본생성자
	 */
	public EmptyRoomListDTO()
	{
		this("","",0,0,0,"","");
	}

	/**
	 * 전달인자를 받는 생성자
	 * @param roomCode 공실코드
	 * @param hotelName 호텔명
	 * @param oldPrice 기존가
	 * @param discountPrice 할인가
	 * @param capacity 방크기
	 * @param hotelLocation 숙박업체위치
	 * @param availableDate 사용가능일
	 */
	public EmptyRoomListDTO(String roomCode, String hotelName, double oldPrice, double discountPrice, int capacity, String hotelLocation, String availableDate) 
	{
		this.roomCode = roomCode;
		this.hotelName = hotelName;
		this.oldPrice = oldPrice;
		this.discountPrice = discountPrice;
		this.capacity = capacity;
		this.hotelLocation = hotelLocation;
		this.availableDate = availableDate;
	}

	/**
	 * 방코드를 리턴한다
	 * @return
	 */
	public String getRoomCode() {
		return roomCode;
	}

	/**
	 * 방코드를 설정한다
	 * @param roomCode
	 */
	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	/**
	 * 호테령을 리턴한다
	 * @return
	 */
	public String getHotelName() {
		return hotelName;
	}

	/**
	 * 호텔명을 설정한다
	 * @param hotelName
	 */
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	/**
	 * 기존가를 리턴한다
	 * @return
	 */
	public double getOldPrice() {
		return oldPrice;
	}
	
	/**
	 * 기존가를 설정한다
	 * @param oldPrice
	 */
	public void setOldPrice(double oldPrice) {
		this.oldPrice = oldPrice;
	}

	/**
	 * 할인가를 리턴한다
	 * @return
	 */
	public double getDiscountPrice() {
		return discountPrice;
	}

	/**
	 * 할인가를 설정한다
	 * @param discountPrice
	 */
	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}

	/**
	 * 방크기를 리턴한다
	 * @return
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * 방크기를 설정한다
	 * @param capacity
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
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
	 * 사용가능일을 리턴한다
	 * @return
	 */
	public String getAvailableDate() {
		return availableDate;
	}

	/**
	 * 사용가능일을 설정한다
	 * @param availableDate
	 */
	public void setAvailableDate(String availableDate) {
		this.availableDate = availableDate;
	}
	
	

}
