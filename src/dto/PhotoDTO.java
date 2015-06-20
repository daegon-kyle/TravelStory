package dto;

public class PhotoDTO {
	private String photoCode;
	private String photoName;
	private String photoPath;
	public PhotoDTO(String photoCode, String photoName, String photoPath) {
		this.photoCode = photoCode;
		this.photoName = photoName;
		this.photoPath = photoPath;
	}
	public PhotoDTO() {
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
	@Override
	public String toString() {
		return "PhotoDTO [photoCode=" + photoCode + ", photoName=" + photoName
				+ ", photoPath=" + photoPath + "]";
	}
	
}
