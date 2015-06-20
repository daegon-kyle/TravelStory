package dto;

public class LocationDTO {
	private String locationCode;
	private double latitude;
	private double longitude;
	public LocationDTO() {
	}
	public LocationDTO(String locationCode, double latitude, double longitude) {
		this.locationCode = locationCode;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public String getLocationCode() {
		return locationCode;
	}
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	@Override
	public String toString() {
		return "LocationDTO [locationCode=" + locationCode + ", latitude="
				+ latitude + ", longitude=" + longitude + "]";
	}
	
}
