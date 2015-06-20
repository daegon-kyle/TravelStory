package model;
/**
 * �������ε带 ���� ������ ĸ��ȭ �ϰ� �ִ� Ŭ���� 
 * MapPhotoUploadServlet���� ���
 * @author ����
 *
 */
public class MapPhotoUploadInfo implements  java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7001049473032734209L;
	/**
	 * ���� ������ ĸ��ȭ �ϰ� �ִ� ��ü
	 */
	private MapInfo mapInfo;
	/**
	 * ���� ������ ����ȭ �ϰ� �ִ� ��ü 
	 */
	private PhotoInfo photoInfo;
	/**
	 * null ������ 
	 */
	public MapPhotoUploadInfo() {
		this(new MapInfo(),new PhotoInfo());
	}
	/**
	 * ��������, ���������� �ʱ�ȭ�ϴ� ������ 
	 * @param mapInfo
	 * @param photoInfo
	 */
	public MapPhotoUploadInfo(MapInfo mapInfo, PhotoInfo photoInfo) {
		this.mapInfo = mapInfo;
		this.photoInfo = photoInfo;
	}
	/**
	 * ���������� ��ȯ�Ѵ�. 
	 * @return
	 */
	public MapInfo getMapInfo() {
		return mapInfo;
	}
	/**
	 * ���������� �����Ѵ�. 
	 * @param mapInfo �������� 
	 */
	public void setMapInfo(MapInfo mapInfo) {
		this.mapInfo = mapInfo;
	}
	/**
	 * ���������� ��ȯ�Ѵ�. 
	 * @return �������� 
	 */
	public PhotoInfo getPhotoInfo() {
		return photoInfo;
	}
	/**
	 * ���������� �����Ѵ�. 
	 * @param photoInfo �������� 
	 */
	public void setPhotoInfo(PhotoInfo photoInfo) {
		this.photoInfo = photoInfo;
	}

}
