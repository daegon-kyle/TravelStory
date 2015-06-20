//작성날짜 : 2014/7/20
//작성자 : 이화섭

package dto;

/**
 * 방문요청 테이블 정보를 저장할 클래스
 * @author 화섭
 *
 */
public class VisitRequestDTO 
{
	private String visitRequestCode;
	private String houseOwnerCode;
	private String touristCode;
	private String requestState;
	
	/**
	 * 널생성자
	 */
	public VisitRequestDTO()
	{
		this("","","","");
	}
	
	/**
	 * 전달인자를 받는 생성자
	 * @param visitRequestCode 방문신청코드
	 * @param houseOwnerCode 집주인코드
	 * @param touristCode 여행객코드
	 * @param requestState 진행상태
	 */
	public VisitRequestDTO(String visitRequestCode, String houseOwnerCode,
			String touristCode, String requestState) {
		this.visitRequestCode = visitRequestCode;
		this.houseOwnerCode = houseOwnerCode;
		this.touristCode = touristCode;
		this.requestState = requestState;
	}
	public String getVisitRequestCode() {
		return visitRequestCode;
	}
	/**
	 * 방문요청코드를 설정한다
	 * @param visitRequestCode
	 */
	public void setVisitRequestCode(String visitRequestCode) {
		this.visitRequestCode = visitRequestCode;
	}
	/**
	 * 집주인코드를 리턴한다
	 * @return
	 */
	public String getHouseOwnerCode() {
		return houseOwnerCode;
	}
	/**
	 * 집주인코드를 설정한다
	 * @param houseOwnerCode
	 */
	public void setHouseOwnerCode(String houseOwnerCode) {
		this.houseOwnerCode = houseOwnerCode;
	}
	/**
	 * 여행객코드를 리턴한다
	 * @return
	 */
	public String getTouristCode() {
		return touristCode;
	}
	/**
	 * 여행객코드를 설정한다
	 * @param touristCode
	 */
	public void setTouristCode(String touristCode) {
		this.touristCode = touristCode;
	}
	/**
	 * 진행상태를 리턴한다
	 * @return
	 */
	public String getRequestState() {
		return requestState;
	}
	/**
	 * 진행상태를 설정한다
	 * @param requestState
	 */
	public void setRequestState(String requestState) {
		this.requestState = requestState;
	}
	
	
}
