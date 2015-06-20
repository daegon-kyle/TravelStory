// 0722 ¹®Á¤Çö
package dto;

public class MapPhotoInfoDTO {
	private String memberCode;
	private String photoCode;
	private String photoName;
	private String photoPath;
	private double latitude;
	private double longitude;
	private String content;
	public MapPhotoInfoDTO(String memberCode, String photoCode,
			String photoName, String photoPath, double latitude,
			double longitude, String content) {
		this.memberCode = memberCode;
		this.photoCode = photoCode;
		this.photoName = photoName;
		this.photoPath = photoPath;
		this.latitude = latitude;
		this.longitude = longitude;
		this.content = content;
	}
	public MapPhotoInfoDTO() {
		this("","","","",0,0,"");
	}
	public String getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	public String getPhotoCode() {
		return photoCode;
	}
	public void setPhotoCode(String photoCode) {
		this.photoCode = photoCode;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	public String getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "MapPhotoInfoDTO [memberCode=" + memberCode + ", photoCode="
				+ photoCode + ", photoName=" + photoName + ", photoPath="
				+ photoPath + ", latitude=" + latitude + ", longitude="
				+ longitude + ", content=" + content + "]";
	}
	
}
