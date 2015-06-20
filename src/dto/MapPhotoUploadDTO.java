//작성날짜 : 2014/7/19
//작성자 : 이화섭
package dto;

/**
 * 지도에사진업로드 테이블 정보를 저장할 클래스
 * @author 화섭
 *
 */
public class MapPhotoUploadDTO 
{
	private String mapPhotoUploadCode;
	private String memberCode;
	private String photoCode;
	private String locationCode;
	private String content;
	
	/**
	 * 널생성자
	 */
	public MapPhotoUploadDTO()
	{
		this("","","","","");
	}
	
	/**
	 * 전달인자를 받는 생성자
	 * @param mapPhotoUploadCode 지도사진업로드코드
	 * @param memberCode 회원코드
	 * @param photoCode 사진코드
	 * @param locationCode 위치고드
	 * @param content 내용
	 */
	public MapPhotoUploadDTO(String mapPhotoUploadCode, String memberCode, String photoCode, String locationCode, String content) 
	{ 
		this.mapPhotoUploadCode = mapPhotoUploadCode;
		this.memberCode = memberCode;
		this.photoCode = photoCode;
		this.locationCode = locationCode;
		this.content = content;
	}
	/**
	 * 지도사진업로드코드를 리턴한다
	 * @return
	 */
	public String getMapPhotoUploadCode() {
		return mapPhotoUploadCode;
	}
	/**
	 * 지도사진업로드코드를 수정한다
	 * @param mapPhotoUploadCode
	 */
	public void setMapPhotoUploadCode(String mapPhotoUploadCode) {
		this.mapPhotoUploadCode = mapPhotoUploadCode;
	}
	/**
	 * 회원코드를 리턴한다
	 * @return
	 */
	public String getMemberCode() {
		return memberCode;
	}
	/**
	 * 회원코드를 설정한다
	 * @param memberCode
	 */
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	/**
	 * 사진코드를 리턴한다
	 * @return
	 */
	public String getPhotoCode() {
		return photoCode;
	}
	/**
	 * 사진코드를 설정한다
	 * @param photoCode
	 */
	public void setPhotoCode(String photoCode) {
		this.photoCode = photoCode;
	}
	/**
	 * 위치를 리턴한다
	 * @return
	 */
	public String getLocationCode() {
		return locationCode;
	}
	/**
	 * 위치를 설정한다
	 * @param locationCode
	 */
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	/**
	 * 부가설명을 리턴한다
	 * @return
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 부가설명을 설정한다
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	

}
