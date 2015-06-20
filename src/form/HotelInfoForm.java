package form;

/**
 * 숙박업체 등록을 하기 위해 사용하는 폼 클래스
 * 
 *
 */
public class HotelInfoForm {
	/**
	 * 호텔명
	 */
	private String hotelName;
	/**
	 * 호텔 위치
	 */
	private String hotelLocation;
	/**
	 * 호텔 소개
	 */
	private String hotelIntroduction;
	/**
	 * 호텔 예약페이지 경로
	 */
	private String hotelReservationPagePath;
	
	/**
	 * 널생성자
	 */
	public HotelInfoForm() {
		this("","","","");
	}
	/**
	 * 생성자
	 * @param hotelName 호텔이름
	 * @param hotelLocation 호텔위치
	 * @param hotelIntroduction 호텔소개
	 * @param hotelReservationPagePath 호텔예약페이지
	 */
	public HotelInfoForm(String hotelName, String hotelLocation,
			String hotelIntroduction, String hotelReservationPagePath) {
		this.hotelName = hotelName;
		this.hotelLocation = hotelLocation;
		this.hotelIntroduction = hotelIntroduction;
		this.hotelReservationPagePath = hotelReservationPagePath;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelLocation() {
		return hotelLocation;
	}

	public void setHotelLocation(String hotelLocation) {
		this.hotelLocation = hotelLocation;
	}

	public String getHotelIntroduction() {
		return hotelIntroduction;
	}

	public void setHotelIntroduction(String hotelIntroduction) {
		this.hotelIntroduction = hotelIntroduction;
	}

	public String getHotelReservationPagePath() {
		return hotelReservationPagePath;
	}

	public void setHotelReservationPagePath(String hotelReservationPagePath) {
		this.hotelReservationPagePath = hotelReservationPagePath;
	}
	
	
}
