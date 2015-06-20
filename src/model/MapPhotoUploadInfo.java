package model;
/**
 * 사진업로드를 위한 정보를 캡슐화 하고 있는 클래스 
 * MapPhotoUploadServlet에서 사용
 * @author 영한
 *
 */
public class MapPhotoUploadInfo implements  java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7001049473032734209L;
	/**
	 * 지도 정보를 캡슐화 하고 있는 객체
	 */
	private MapInfo mapInfo;
	/**
	 * 사진 정보를 갭슐화 하고 있는 객체 
	 */
	private PhotoInfo photoInfo;
	/**
	 * null 생성자 
	 */
	public MapPhotoUploadInfo() {
		this(new MapInfo(),new PhotoInfo());
	}
	/**
	 * 지도정보, 사진정보를 초기화하는 생성자 
	 * @param mapInfo
	 * @param photoInfo
	 */
	public MapPhotoUploadInfo(MapInfo mapInfo, PhotoInfo photoInfo) {
		this.mapInfo = mapInfo;
		this.photoInfo = photoInfo;
	}
	/**
	 * 지도정보를 반환한다. 
	 * @return
	 */
	public MapInfo getMapInfo() {
		return mapInfo;
	}
	/**
	 * 지도정보를 세팅한다. 
	 * @param mapInfo 지도정보 
	 */
	public void setMapInfo(MapInfo mapInfo) {
		this.mapInfo = mapInfo;
	}
	/**
	 * 사진정보를 반환한다. 
	 * @return 사진정보 
	 */
	public PhotoInfo getPhotoInfo() {
		return photoInfo;
	}
	/**
	 * 사진정보를 세팅한다. 
	 * @param photoInfo 사진정보 
	 */
	public void setPhotoInfo(PhotoInfo photoInfo) {
		this.photoInfo = photoInfo;
	}

}
