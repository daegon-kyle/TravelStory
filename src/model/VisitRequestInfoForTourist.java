package model;

import java.io.Serializable;
/**
 * 여행객을 위한 방문신청 정보를 캡슐화 하고 있는 클래스 
 * @author 영한
 *
 */
public class VisitRequestInfoForTourist implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5512965215554130433L;
	/**
	 * 집주인 필수 입력사항을 캡슐화하고 있는 객체 
	 */
	private HouseOwnerEssentialInfo houseOwnerEssentialInfo;
	/**
	 * 방문신청 상태 
	 * 수락, 대기, 거절
	 */
	private String requestState;
	/**
	 * null생성자 
	 */
	public VisitRequestInfoForTourist() {
		this(new HouseOwnerEssentialInfo(), "");
	}
	/**
	 * 오버로딩 생성자 
	 * @param houseOwnerEssentialInfo
	 * @param requestState
	 */
	public VisitRequestInfoForTourist(
			HouseOwnerEssentialInfo houseOwnerEssentialInfo, String requestState) {
		this.houseOwnerEssentialInfo = houseOwnerEssentialInfo;
		this.requestState = requestState;
	}
	/**
	 * 집주인필수입력정보를 반환한다.
	 * @return 집주인필수입력정보
	 */
	public HouseOwnerEssentialInfo getHouseOwnerEssentialInfo() {
		return houseOwnerEssentialInfo;
	}
	/**
	 * 집주인필수입력정보를 세팅한다.
	 * @param houseOwnerEssentialInfo 집주인필수입력정보
	 */
	public void setHouseOwnerEssentialInfo(
			HouseOwnerEssentialInfo houseOwnerEssentialInfo) {
		this.houseOwnerEssentialInfo = houseOwnerEssentialInfo;
	}
	/**
	 * 방문신청상태를 반환한다. 
	 * @return 방문신청상태 
	 */
	public String getRequestState() {
		return requestState;
	}
	/**
	 * 방문신청 상태를 세팅한다. 
	 * @param requestState 방문신청 상태 
	 */
	public void setRequestState(String requestState) {
		this.requestState = requestState;
	}
	
	
}
