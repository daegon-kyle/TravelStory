package form;

/**
 * 지도에 사지을 업로드하기위해 입력하는 폼 클래스
 * 
 */
public class MapPhotoUploadInfoForm {
	/**
	 * 위도
	 */
	private String latitude;
	/**
	 * 경도
	 */
	private String longtitude;
	/**
	 * 사진이름
	 */
	private String photoName;
	/**
	 * 사진파일경로
	 */
	private String photoPath;
/**
 * 널생성자
 */
	public MapPhotoUploadInfoForm() {
		this("","","","");
	}
	/**
	 * 생성자
	 * @param latitude 위도
	 * @param longtitude 경도
	 * @param photoName 사진파일이름
	 * @param photoPath 사진파일경로
	 */
	public MapPhotoUploadInfoForm(String latitude, String longtitude,
			String photoName, String photoPath) {
		super();
		this.latitude = latitude;
		this.longtitude = longtitude;
		this.photoName = photoName;
		this.photoPath = photoPath;
		
	}
	
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongtitude() {
		return longtitude;
	}
	public void setLongtitude(String longtitude) {
		this.longtitude = longtitude;
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
}
