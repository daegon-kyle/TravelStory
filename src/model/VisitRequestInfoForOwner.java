package model;

import java.io.Serializable;
/**
 * 집주인을 위한 방문신청정보를 갖는 클래스 
 * @author 영한
 *
 */
public class VisitRequestInfoForOwner implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7249173868283201734L;
	/**
	 * 여행객 필수 입력사항정보 
	 */
	private TouristEssentialInfo toruistEssentialInfo;
	/**
	 * 신청상태 
	 * 수락 , 거절, 대기 
	 */
	private String requestState;
	/**
	 *  null 생성자 
	 */
	public VisitRequestInfoForOwner() {
		this(new TouristEssentialInfo(), "");
	}
	/**
	 * 오버로딩 생성자 
	 * @param toruistEssentialInfo
	 * @param requestState
	 */
	public VisitRequestInfoForOwner(TouristEssentialInfo toruistEssentialInfo,
			String requestState) {
		super();
		this.toruistEssentialInfo = toruistEssentialInfo;
		this.requestState = requestState;
	}
	/**
	 * 여행객 필수 입력정보를 반환한다.
	 * @return 여행객 필수 입력정보
	 */
	public TouristEssentialInfo getToruistEssentialInfo() {
		return toruistEssentialInfo;
	}
	/**
	 * 여행객 필수입력 정보를 세팅한다. 
	 * @param toruistEssentialInfo 여행객 필수입력 정보 
	 */
	public void setToruistEssentialInfo(TouristEssentialInfo toruistEssentialInfo) {
		this.toruistEssentialInfo = toruistEssentialInfo;
	}
	/**
	 * 요청상태를 반환한다. 
	 * @return 요청상태 
	 */
	public String getRequestState() {
		return requestState;
	}
	/**
	 * 요청상태를 세팅한다. 
	 * @param requestState 요청상태 
	 */
	public void setRequestState(String requestState) {
		this.requestState = requestState;
	}
	
	
}
