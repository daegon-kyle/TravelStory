//�ۼ���¥ : 2014/7/19
//�ۼ��� : ��ȭ��
package dto;

/**
 * �������������ε� ���̺� ������ ������ Ŭ����
 * @author ȭ��
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
	 * �λ�����
	 */
	public MapPhotoUploadDTO()
	{
		this("","","","","");
	}
	
	/**
	 * �������ڸ� �޴� ������
	 * @param mapPhotoUploadCode �����������ε��ڵ�
	 * @param memberCode ȸ���ڵ�
	 * @param photoCode �����ڵ�
	 * @param locationCode ��ġ���
	 * @param content ����
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
	 * �����������ε��ڵ带 �����Ѵ�
	 * @return
	 */
	public String getMapPhotoUploadCode() {
		return mapPhotoUploadCode;
	}
	/**
	 * �����������ε��ڵ带 �����Ѵ�
	 * @param mapPhotoUploadCode
	 */
	public void setMapPhotoUploadCode(String mapPhotoUploadCode) {
		this.mapPhotoUploadCode = mapPhotoUploadCode;
	}
	/**
	 * ȸ���ڵ带 �����Ѵ�
	 * @return
	 */
	public String getMemberCode() {
		return memberCode;
	}
	/**
	 * ȸ���ڵ带 �����Ѵ�
	 * @param memberCode
	 */
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	/**
	 * �����ڵ带 �����Ѵ�
	 * @return
	 */
	public String getPhotoCode() {
		return photoCode;
	}
	/**
	 * �����ڵ带 �����Ѵ�
	 * @param photoCode
	 */
	public void setPhotoCode(String photoCode) {
		this.photoCode = photoCode;
	}
	/**
	 * ��ġ�� �����Ѵ�
	 * @return
	 */
	public String getLocationCode() {
		return locationCode;
	}
	/**
	 * ��ġ�� �����Ѵ�
	 * @param locationCode
	 */
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	/**
	 * �ΰ������� �����Ѵ�
	 * @return
	 */
	public String getContent() {
		return content;
	}
	/**
	 * �ΰ������� �����Ѵ�
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	

}
