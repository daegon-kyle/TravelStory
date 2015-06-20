//0720 ¹®Á¤Çö
package dto;

public class EmptyRoomDTO {
	private String emptyRoomCode;
	private String hotelManagerCode;
	private String availableDate;
	private String roomName;
	private double discountPrice;
	private double oldPrice;
	private int capacity;
	private int space;
	private String checkInTime;
	private String checkOutTime;
	private String facilityList;
	private String etc;
	public EmptyRoomDTO(String emptyRoomCode, String hotelManagerCode,
			String writingDate, String roomName, double discountPrice,
			double oldPrice, int capacity, int space, String checkInTime,
			String checkOutTime, String facilityList, String etc) {
		this.emptyRoomCode = emptyRoomCode;
		this.hotelManagerCode = hotelManagerCode;
		this.availableDate = writingDate;
		this.roomName = roomName;
		this.discountPrice = discountPrice;
		this.oldPrice = oldPrice;
		this.capacity = capacity;
		this.space = space;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.facilityList = facilityList;
		this.etc = etc;
	}
	public EmptyRoomDTO() {
	}
	public String getEmptyRoomCode() {
		return emptyRoomCode;
	}
	public void setEmptyRoomCode(String emptyRoomCode) {
		this.emptyRoomCode = emptyRoomCode;
	}
	public String getHotelManagerCode() {
		return hotelManagerCode;
	}
	public void setHotelManagerCode(String hotelManagerCode) {
		this.hotelManagerCode = hotelManagerCode;
	}
	public String getAvailableDate() {
		return availableDate;
	}
	public void setAvailableDate(String availableDate) {
		this.availableDate = availableDate;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public double getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}
	public double getOldPrice() {
		return oldPrice;
	}
	public void setOldPrice(double oldPrice) {
		this.oldPrice = oldPrice;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getSpace() {
		return space;
	}
	public void setSpace(int space) {
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
	@Override
	public String toString() {
		return "EmptyRoomDTO [emptyRoomCode=" + emptyRoomCode
				+ ", hotelManagerCode=" + hotelManagerCode + ", availableDate="
				+ availableDate + ", roomName=" + roomName + ", discountPrice="
				+ discountPrice + ", oldPrice=" + oldPrice + ", capacity="
				+ capacity + ", space=" + space + ", checkInTime="
				+ checkInTime + ", checkOutTime=" + checkOutTime
				+ ", facilityList=" + facilityList + ", etc=" + etc + "]";
	}
	
}
