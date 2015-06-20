package form;

/**
 * ������ ������ ���ε��ϱ����� �Է��ϴ� �� Ŭ����
 * 
 */
public class MapPhotoUploadInfoForm {
	/**
	 * ����
	 */
	private String latitude;
	/**
	 * �浵
	 */
	private String longtitude;
	/**
	 * �����̸�
	 */
	private String photoName;
	/**
	 * �������ϰ��
	 */
	private String photoPath;
/**
 * �λ�����
 */
	public MapPhotoUploadInfoForm() {
		this("","","","");
	}
	/**
	 * ������
	 * @param latitude ����
	 * @param longtitude �浵
	 * @param photoName ���������̸�
	 * @param photoPath �������ϰ��
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
