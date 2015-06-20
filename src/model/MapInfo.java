package model;
/**
 * 지도정보를 캡슐화 하고 있는 클래스
 * MapPhotoUploadServlet에서 사용한다. 
 * @author 영한
 *
 */
public class MapInfo implements  java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7127794130458996860L;
	/**
	 * 위치정보(위도,경도)를캡슐화 있는 객체 
	 */
	private LocationInfo locationInfo;
	/**
	 * null 생성자 
	 */
	public MapInfo() {
		this(new LocationInfo());
	}
	/**
	 * 위치정보를 초기화하는 생성자 
	 * @param locationInfo
	 */
	public MapInfo(LocationInfo locationInfo) {
		this.locationInfo = locationInfo;
	}
/**
 * 위치정보를 반환한다. 
 * @return 위치정보 
 */
	public LocationInfo getLocationInfo() {
		return locationInfo;
	}
/**
 * 위치정보를 세팅한다. 
 * @param locationInfo 위치정보 
 */
	public void setLocationInfo(LocationInfo locationInfo) {
		this.locationInfo = locationInfo;
	}
}
