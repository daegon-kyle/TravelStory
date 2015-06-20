package model;
/**
 * ���������� ĸ��ȭ�ϰ� �ִ� Ŭ����
 * @author ����
 *
 */
public class PhotoInfo implements  java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1432861793308130511L;
	/**
	 * �����̸�
	 */
	private String photoName;
	/**
	 * �������
	 */
	private String photoPath;
	/**
	 * �������α��� 
	 */
	private int photoWidth;
	/**
	 * ���� ���α��� 
	 */
	private int photoHeight;
	/**
	 * �������� Ȯ���� 
	 */
	private String fileExtension;
	/**
	 * ���� �뷮(ũ��) 
	 */
	private int photoCapacity;
	/**
	 * 
	 */
	public PhotoInfo() {
		this("","",0,0,"",0);
	}
	/**
	 * �����ε� ������ 
	 * @param photoName �����̸� 
	 * @param photoPath ������� 
	 * @param photoWidth �������α��� 
	 * @param photoHeight �������α��� 
	 * @param fileExtension ����Ȯ����  
	 * @param photoCapacity �����뷮 
	 */
	public PhotoInfo(String photoName, String photoPath, int photoWidth,
			int photoHeight, String fileExtension, int photoCapacity) {
		this.photoName = photoName;
		this.photoPath = photoPath;
		this.photoWidth = photoWidth;
		this.photoHeight = photoHeight;
		this.fileExtension = fileExtension;
		this.photoCapacity = photoCapacity;
	}
	/**
	 * �����̸��� ��ȯ�Ѵ�. 
	 * @return �����̸� 
	 */
	public String getPhotoName() {
		return photoName;
	}
	/**
	 * �����̸��� �����Ѵ�. 
	 * @param photoName �����̸� 
	 */
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	/**
	 * ������θ� ��ȯ�Ѵ�. 
	 * @return ������� 
	 */
	public String getPhotoPath() {
		return photoPath;
	}
	/**
	 * ������θ� �����Ѵ�. 
	 * @param photoPath ������� 
	 */
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	/**
	 * �������α��̸� ��ȯ�Ѵ�. 
	 * @return ���α��� 
	 */
	public int getPhotoWidth() {
		return photoWidth;
	}
	/**
	 * �������α��̸� �����Ѵ�. 
	 * @param photoWidth �������α��� 
	 */
	public void setPhotoWidth(int photoWidth) {
		this.photoWidth = photoWidth;
	}
	/**
	 * �������α��̸� ��ȯ�Ѵ�. 
	 * @return ���α��� 
	 */
	public int getPhotoHeight() {
		return photoHeight;
	}
	/**
	 * �������α��̸� �����Ѵ�. 
	 * @param photoHeight ���α��� 
	 */
	public void setPhotoHeight(int photoHeight) {
		this.photoHeight = photoHeight;
	}
	/**
	 * ����Ȯ���ڸ� ��ȯ�Ѵ�. 
	 * @return ����Ȯ���� 
	 */
	public String getFileExtension() {
		return fileExtension;
	}
	/**
	 * ����Ȯ���ڸ� �����Ѵ�. 
	 * @param fileExtension ����Ȯ���� 
	 */
	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}
	/**
	 * �����뷮�� ��ȯ�Ѵ�. 
	 * @return �����뷮 
	 */
	public int getPhotoCapacity() {
		return photoCapacity;
	}
	/**
	 * �����뷮�� �����Ѵ�. 
	 * @param photoCapacity �����뷮 
	 */
	public void setPhotoCapacity(int photoCapacity) {
		this.photoCapacity = photoCapacity;
	}
	
	
	
}
