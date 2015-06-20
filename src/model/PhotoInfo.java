package model;
/**
 * 사진정보를 캡슐화하고 있는 클래스
 * @author 영한
 *
 */
public class PhotoInfo implements  java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1432861793308130511L;
	/**
	 * 사진이름
	 */
	private String photoName;
	/**
	 * 사진경로
	 */
	private String photoPath;
	/**
	 * 사진가로길이 
	 */
	private int photoWidth;
	/**
	 * 사진 세로길이 
	 */
	private int photoHeight;
	/**
	 * 사진파일 확장자 
	 */
	private String fileExtension;
	/**
	 * 사진 용량(크기) 
	 */
	private int photoCapacity;
	/**
	 * 
	 */
	public PhotoInfo() {
		this("","",0,0,"",0);
	}
	/**
	 * 오버로딩 생성자 
	 * @param photoName 사진이름 
	 * @param photoPath 사진경로 
	 * @param photoWidth 사진가로길이 
	 * @param photoHeight 사진세로길이 
	 * @param fileExtension 사진확장자  
	 * @param photoCapacity 사진용량 
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
	 * 사진이름을 반환한다. 
	 * @return 사진이름 
	 */
	public String getPhotoName() {
		return photoName;
	}
	/**
	 * 사진이름을 세팅한다. 
	 * @param photoName 사진이름 
	 */
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	/**
	 * 사진경로를 반환한다. 
	 * @return 사진경로 
	 */
	public String getPhotoPath() {
		return photoPath;
	}
	/**
	 * 사진경로를 세팅한다. 
	 * @param photoPath 사진경로 
	 */
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	/**
	 * 사진가로길이를 반환한다. 
	 * @return 가로길이 
	 */
	public int getPhotoWidth() {
		return photoWidth;
	}
	/**
	 * 사진가로길이를 세팅한다. 
	 * @param photoWidth 사진가로길이 
	 */
	public void setPhotoWidth(int photoWidth) {
		this.photoWidth = photoWidth;
	}
	/**
	 * 사진세로길이를 반환한다. 
	 * @return 세로길이 
	 */
	public int getPhotoHeight() {
		return photoHeight;
	}
	/**
	 * 사진세로길이를 세팅한다. 
	 * @param photoHeight 세로길이 
	 */
	public void setPhotoHeight(int photoHeight) {
		this.photoHeight = photoHeight;
	}
	/**
	 * 사진확장자를 반환한다. 
	 * @return 사진확장자 
	 */
	public String getFileExtension() {
		return fileExtension;
	}
	/**
	 * 사진확장자를 세팅한다. 
	 * @param fileExtension 사진확장자 
	 */
	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}
	/**
	 * 사진용량을 반환한다. 
	 * @return 사진용량 
	 */
	public int getPhotoCapacity() {
		return photoCapacity;
	}
	/**
	 * 사진용량을 세팅한다. 
	 * @param photoCapacity 사진용량 
	 */
	public void setPhotoCapacity(int photoCapacity) {
		this.photoCapacity = photoCapacity;
	}
	
	
	
}
