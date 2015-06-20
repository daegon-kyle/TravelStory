package model;

import java.io.Serializable;
/**
 * 지도에 사진올리기 위해 위치정보를 캡슐화한 클래스
 * <br>MapUploadInfoServlet에서 사용하기 위한 클래스
 * @author 대곤
 *
 */
public class LocationInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4126341057004684209L;
	/**
	 * 위도
	 */
	private double latitude;
	/**
	 * 경도
	 */
	private double longitude;
	/**
	 * 널 생성자
	 */
	public LocationInfo() {
		this(0,0);
	}
	/**
	 * 기본 생성자
	 * @param latitude 위도
	 * @param longitude 경도
	 */
	public LocationInfo(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	/**
	 * 위도 반환
	 * @return 위도
	 */
	public double getLatitude() {
		return latitude;
	}
	/**
	 * 위도 설정
	 * @param latitude 위도
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	/**
	 * 경도 반환
	 * @return 경도
	 */
	public double getLongitude() {
		return longitude;
	}
	/**
	 * 경도 설정
	 * @param longitude 경도
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	
	
	
}
