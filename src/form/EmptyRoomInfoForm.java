package form;
/**
 * 
 * 숙박업체가 공실정보 정보를 등록하기 위한 클래스
 *
 */
public class EmptyRoomInfoForm {
	/**
	 * 공실정보명
	 */
	private String emptyRoomName;
	/**
	 * 할인 전 가격
	 */
	private String oldPrice;
	/**
	 * 할인가격
	 */
	private String discountPrice;
	/**
	 * 평수
	 */
	private String space;
	/**
	 * 체크인 시간
	 */
	private String checkInTime;
	/**
	 * 체크아웃시간
	 */
	private String checkOutTime;
	/**
	 * 수용인원
	 */
	private String capacity;
	/**
	 * 이용가능시설목록
	 */
	private String facilityList;
	
	/**
	 * 기타 정보
	 */
	private String etc;
	
	/**
	 * 널 생성자
	 */
	public EmptyRoomInfoForm() {
		this("","","","","","","","","");
	}

	/**
	 * 생성자
	 * @param emptyRoomName 공실정보이름
	 * @param oldPrice 할인전 가격
	 * @param discountPrice 할인가격
	 * @param space 평수
	 * @param checkInTime 체크인 시간
	 * @param checkOutTime 체크아웃 시간
	 * @param facility1 이용가능시설1
	 * @param facility2 이용가능시설2
	 * @param facility3 이용가능시설3
	 * @param etc 기타
	 */
	public EmptyRoomInfoForm(String emptyRoomName, String oldPrice,
			String discountPrice, String space, String checkInTime,
			String checkOutTime,String capacity, String facilityList, String etc) {
		this.emptyRoomName = emptyRoomName;
		this.oldPrice = oldPrice;
		this.discountPrice = discountPrice;
		this.space = space;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.capacity = capacity;
		this.facilityList = facilityList;
		this.etc = etc;
	}


	public String getEmptyRoomName() {
		return emptyRoomName;
	}


	public void setEmptyRoomName(String emptyRoomName) {
		this.emptyRoomName = emptyRoomName;
	}


	public String getOldPrice() {
		return oldPrice;
	}


	public void setOldPrice(String oldPrice) {
		this.oldPrice = oldPrice;
	}


	public String getDiscountPrice() {
		return discountPrice;
	}


	public void setDiscountPrice(String discountPrice) {
		this.discountPrice = discountPrice;
	}


	public String getSpace() {
		return space;
	}


	public void setSpace(String space) {
		this.space = space;
	}


	public String getCheckInTime() {
		return checkInTime;
	}


	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}


	public String getCheckOutTime() {
		return checkOutTime;
	}


	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
	}



	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getFacilityList() {
		return facilityList;
	}

	public void setFacilityList(String facilityList) {
		this.facilityList = facilityList;
	}

	public String getEtc() {
		return etc;
	}


	public void setEtc(String etc) {
		this.etc = etc;
	}
	
	
}
