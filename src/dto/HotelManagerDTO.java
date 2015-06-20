// 0720 ¹®Á¤Çö
package dto;

public class HotelManagerDTO {
	private String hotelManagerCode;
	private String memberCode;
	private String hotelName;
	private String hotelLocation;
	private String hotelIntroduction;
	private String reservationPagePath;
	
	public HotelManagerDTO(String hotelManagerCode, String memberCode, String hotelName, String hotelLocation, String hotelIntroduction, String reservationPagePath) {
		this.hotelManagerCode = hotelManagerCode;
		this.memberCode = memberCode;
		this.hotelName = hotelName;
		this.hotelLocation = hotelLocation;
		this.hotelIntroduction = hotelIntroduction;
		this.reservationPagePath = reservationPagePath;
	}
	public HotelManagerDTO() {
	}
	public String getHotelManagerCode() {
		return hotelManagerCode;
	}
	public void setHotelManagerCode(String hotelManagerCode) {
		this.hotelManagerCode = hotelManagerCode;
	}
	public String getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
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
	public String getReservationPagePath() {
		return reservationPagePath;
	}
	public void setReservationPagePath(String reservationPagePath) {
		this.reservationPagePath = reservationPagePath;
	}
	@Override
	public String toString() {
		return "HotelManagerDTO [hotelManagerCode=" + hotelManagerCode
				+ ", memberCode=" + memberCode + ", hotelName=" + hotelName
				+ ", hotelLocation=" + hotelLocation + ", hotelIntroduction="
				+ hotelIntroduction + ", reservationPagePath="
				+ reservationPagePath + "]";
	}
	
}
