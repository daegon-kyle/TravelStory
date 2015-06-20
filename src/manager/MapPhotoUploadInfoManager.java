package manager;

import model.MapPhotoUploadInfo;
/**
 * ������ ������ ���ε� �ϱ����� ����ϴ� Ŭ����
 * @author ���
 *
 */
public class MapPhotoUploadInfoManager {
	/**
	 * ������ ���� ���ε�����
	 */
	private MapPhotoUploadInfo mapPhotoUploadInfo;
	/**
	 * �λ�����
	 */
	public MapPhotoUploadInfoManager() {
		this(new MapPhotoUploadInfo());
	}
/**
 * �⺻������
 * @param mapPhotoUploadInfo ������ ���� ���ε��� ����
 */
	public MapPhotoUploadInfoManager(MapPhotoUploadInfo mapPhotoUploadInfo) {
		this.mapPhotoUploadInfo = mapPhotoUploadInfo;
	}
/**
 * ������ ���� ���ε����� ��ȯ
 * @return ������ ���� ���ε�����
 */
	public MapPhotoUploadInfo getMapPhotoUploadInfo() {
		return mapPhotoUploadInfo;
	}
/**
 * ������ ���� ���ε����� ����
 * @param mapPhotoUploadInfo ������ ���� ���ε�����
 */
	public void setMapPhotoUploadInfo(MapPhotoUploadInfo mapPhotoUploadInfo) {
		this.mapPhotoUploadInfo = mapPhotoUploadInfo;
	}
	/**
	 * ������ ���� ���ε�, MapPhotoUploadDAOManager�� saveLocation, savePhoto, saveMapPhotoUpload�޼ҵ� ȣ���Ͽ� ����
	 * @param memberCode ȸ���ڵ�
	 * @return �߰��� ������ �������ε� ����
	 */
	public MapPhotoUploadInfo uploadMapPhoto(String memberCode){
		
		return null;
	}
	
}
