package model;

import java.io.Serializable;
/**
 * ������ �����ø��� ���� ��ġ������ ĸ��ȭ�� Ŭ����
 * <br>MapUploadInfoServlet���� ����ϱ� ���� Ŭ����
 * @author ���
 *
 */
public class LocationInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4126341057004684209L;
	/**
	 * ����
	 */
	private double latitude;
	/**
	 * �浵
	 */
	private double longitude;
	/**
	 * �� ������
	 */
	public LocationInfo() {
		this(0,0);
	}
	/**
	 * �⺻ ������
	 * @param latitude ����
	 * @param longitude �浵
	 */
	public LocationInfo(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	/**
	 * ���� ��ȯ
	 * @return ����
	 */
	public double getLatitude() {
		return latitude;
	}
	/**
	 * ���� ����
	 * @param latitude ����
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	/**
	 * �浵 ��ȯ
	 * @return �浵
	 */
	public double getLongitude() {
		return longitude;
	}
	/**
	 * �浵 ����
	 * @param longitude �浵
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	
	
	
}
