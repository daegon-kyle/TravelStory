package model;
/**
 * ���������� ĸ��ȭ �ϰ� �ִ� Ŭ����
 * MapPhotoUploadServlet���� ����Ѵ�. 
 * @author ����
 *
 */
public class MapInfo implements  java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7127794130458996860L;
	/**
	 * ��ġ����(����,�浵)��ĸ��ȭ �ִ� ��ü 
	 */
	private LocationInfo locationInfo;
	/**
	 * null ������ 
	 */
	public MapInfo() {
		this(new LocationInfo());
	}
	/**
	 * ��ġ������ �ʱ�ȭ�ϴ� ������ 
	 * @param locationInfo
	 */
	public MapInfo(LocationInfo locationInfo) {
		this.locationInfo = locationInfo;
	}
/**
 * ��ġ������ ��ȯ�Ѵ�. 
 * @return ��ġ���� 
 */
	public LocationInfo getLocationInfo() {
		return locationInfo;
	}
/**
 * ��ġ������ �����Ѵ�. 
 * @param locationInfo ��ġ���� 
 */
	public void setLocationInfo(LocationInfo locationInfo) {
		this.locationInfo = locationInfo;
	}
}
