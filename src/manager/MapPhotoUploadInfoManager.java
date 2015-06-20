package manager;

import model.MapPhotoUploadInfo;
/**
 * 지도에 사진을 업로드 하기위해 사용하는 클래스
 * @author 대곤
 *
 */
public class MapPhotoUploadInfoManager {
	/**
	 * 지도에 사진 업로드정보
	 */
	private MapPhotoUploadInfo mapPhotoUploadInfo;
	/**
	 * 널생성자
	 */
	public MapPhotoUploadInfoManager() {
		this(new MapPhotoUploadInfo());
	}
/**
 * 기본생성자
 * @param mapPhotoUploadInfo 지도에 사진 업로드할 정보
 */
	public MapPhotoUploadInfoManager(MapPhotoUploadInfo mapPhotoUploadInfo) {
		this.mapPhotoUploadInfo = mapPhotoUploadInfo;
	}
/**
 * 지도에 사진 업로드정보 반환
 * @return 지도에 사진 업로드정보
 */
	public MapPhotoUploadInfo getMapPhotoUploadInfo() {
		return mapPhotoUploadInfo;
	}
/**
 * 지도에 사진 업로드정보 설정
 * @param mapPhotoUploadInfo 지도에 사진 업로드정보
 */
	public void setMapPhotoUploadInfo(MapPhotoUploadInfo mapPhotoUploadInfo) {
		this.mapPhotoUploadInfo = mapPhotoUploadInfo;
	}
	/**
	 * 지도에 사진 업로드, MapPhotoUploadDAOManager의 saveLocation, savePhoto, saveMapPhotoUpload메소드 호출하여 저장
	 * @param memberCode 회원코드
	 * @return 추가된 지도에 사진업로드 정보
	 */
	public MapPhotoUploadInfo uploadMapPhoto(String memberCode){
		
		return null;
	}
	
}
