//작성날짜 : 2014/7/20
//작성자 : 이화섭

package dto;

/**
 * 집주인과 여행객의 예약 진행상황 저장한 테이블 클래스
 * @author 화섭
 *
 */
public class CheckRequestStateDTO 
{
	private String memberCode;
	private String touristCode;
	private String houseOwnerCode;
	private String requestState;
	private String houseOwnerName;
	private String houseOwnerEmail;
	private String houseOwnerGender;
	private String houseOwnerJob;
	private String houseOwnerVisitStartDate;
	private String houseOwnerVisitEndDate;
	private String houseOwnerSelfIntroduction;
	private String houseOwnerMarriedState;
	private String houseOwnerAddress;
	private String houseOwnerEtc;
	private String houseOwnerReliability;
	
	/**
	 * 기본생성자
	 */
	public CheckRequestStateDTO()
	{
		this("","","","","","","","","","","","","","","");
	}

	/**
	 * 전달인자를 받는 생성자
	 * @param memberCode 회원코드
	 * @param touristCode 여행객코드
	 * @param houseOwnerCode 집주인코드
	 * @param requestState 진행상황
	 * @param houseOwnerName 집주인이름
	 * @param houseOwnerEmail 집주인이메일주소
	 * @param houseOwnerGender 집주인성
	 * @param houseOwnerJob 집주인직업
	 * @param houseOwnerVisitStartDate 집주인 허락 가능한 방문 시작일
	 * @param houseOwnerVisitEndDate 집주인이 허락 가능한 방문 종료일
	 * @param houseOwnerSelfIntroduction 집주인소개
	 * @param houseOwnerMarriedState 집주인 결혼여부
	 * @param houseOwnerAddress 집주인 주소
	 * @param houseOwnerEtc 집주인 집에 대한 소개
	 * @param houseOwnerReliability 집주인의 신뢰도
	 */
	public CheckRequestStateDTO(String memberCode, String touristCode,
			String houseOwnerCode, String requestState, String houseOwnerName,
			String houseOwnerEmail, String houseOwnerGender,
			String houseOwnerJob, String houseOwnerVisitStartDate,
			String houseOwnerVisitEndDate, String houseOwnerSelfIntroduction,
			String houseOwnerMarriedState, String houseOwnerAddress,
			String houseOwnerEtc, String houseOwnerReliability) { 
		this.memberCode = memberCode;
		this.touristCode = touristCode;
		this.houseOwnerCode = houseOwnerCode;
		this.requestState = requestState;
		this.houseOwnerName = houseOwnerName;
		this.houseOwnerEmail = houseOwnerEmail;
		this.houseOwnerGender = houseOwnerGender;
		this.houseOwnerJob = houseOwnerJob;
		this.houseOwnerVisitStartDate = houseOwnerVisitStartDate;
		this.houseOwnerVisitEndDate = houseOwnerVisitEndDate;
		this.houseOwnerSelfIntroduction = houseOwnerSelfIntroduction;
		this.houseOwnerMarriedState = houseOwnerMarriedState;
		this.houseOwnerAddress = houseOwnerAddress;
		this.houseOwnerEtc = houseOwnerEtc;
		this.houseOwnerReliability = houseOwnerReliability;
	}

	/**
	 * 회원코드를 리턴한다
	 * @return
	 */
	public String getMemberCode() {
		return memberCode;
	}
	/**
	 * 회원코드를 설정한다
	 * @param memberCode
	 */
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
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
	 * 요청상태를 리턴한다
	 * @return
	 */
	public String getRequestState() {
		return requestState;
	}

	/**
	 * 요청상태를 설정한다
	 * @param requestState
	 */
	public void setRequestState(String requestState) {
		this.requestState = requestState;
	}

	/**
	 * 집주인의 이름을 리턴한다
	 * @return
	 */
	public String getHouseOwnerName() {
		return houseOwnerName;
	}

	/**
	 * 집주인의이름을 설정한다
	 * @param houseOwnerName
	 */
	public void setHouseOwnerName(String houseOwnerName) {
		this.houseOwnerName = houseOwnerName;
	}

	/**
	 * 집주인이메일주소를 리턴한다
	 * @return
	 */
	public String getHouseOwnerEmail() {
		return houseOwnerEmail;
	}

	/**
	 * 집주인이메일주소를 설정한다
	 * @param houseOwnerEmail
	 */
	public void setHouseOwnerEmail(String houseOwnerEmail) {
		this.houseOwnerEmail = houseOwnerEmail;
	}

	/**
	 * 집주인 성을 리턴한다
	 * @return
	 */
	public String getHouseOwnerGender() {
		return houseOwnerGender;
	}

	/**
	 * 집주인 성을 설정한다
	 * @param houseOwnerGender
	 */
	public void setHouseOwnerGender(String houseOwnerGender) {
		this.houseOwnerGender = houseOwnerGender;
	}

	/**
	 * 집주인의 직업을 리턴한다
	 * @return
	 */
	public String getHouseOwnerJob() {
		return houseOwnerJob;
	}

	/**
	 * 집주인의 직업을 설정한다
	 * @param houseOwnerJob
	 */
	public void setHouseOwnerJob(String houseOwnerJob) {
		this.houseOwnerJob = houseOwnerJob;
	}

	/**
	 * 집주인의 초대가능시작일을 리턴한다
	 * @return
	 */
	public String getHouseOwnerVisitStartDate() {
		return houseOwnerVisitStartDate;
	}

	/**
	 * 집주인의 초대가능시작일을 설정한다
	 * @param houseOwnerVisitStartDate
	 */
	public void setHouseOwnerVisitStartDate(String houseOwnerVisitStartDate) {
		this.houseOwnerVisitStartDate = houseOwnerVisitStartDate;
	}

	/**
	 * 집주인의 초대가능종료일을 리턴한다
	 * @return
	 */
	public String getHouseOwnerVisitEndDate() {
		return houseOwnerVisitEndDate;
	}

	/**
	 * 집주인의 초대가능종료일을 설정한다
	 * @param houseOwnerVisitEndDate
	 */
	public void setHouseOwnerVisitEndDate(String houseOwnerVisitEndDate) {
		this.houseOwnerVisitEndDate = houseOwnerVisitEndDate;
	}

	/**
	 * 집주인의 소개를 리턴한다
	 * @return
	 */
	public String getHouseOwnerSelfIntroduction() {
		return houseOwnerSelfIntroduction;
	}

	/**
	 * 집주인의 소개를 설정한다
	 * @param houseOwnerSelfIntroduction
	 */
	public void setHouseOwnerSelfIntroduction(String houseOwnerSelfIntroduction) {
		this.houseOwnerSelfIntroduction = houseOwnerSelfIntroduction;
	}

	/**
	 * 집주인의 결혼상태를 리턴한다
	 * @return
	 */
	public String getHouseOwnerMarriedState() {
		return houseOwnerMarriedState;
	}

	/**
	 * 집주인의 결혼상태를 설정한다
	 * @param houseOwnerMarriedState
	 */
	public void setHouseOwnerMarriedState(String houseOwnerMarriedState) {
		this.houseOwnerMarriedState = houseOwnerMarriedState;
	}

	/**
	 * 집주인의 주소를 리턴한다
	 * @return
	 */
	public String getHouseOwnerAddress() {
		return houseOwnerAddress;
	}
	
	/**
	 * 집주인의 주소를 설정한다
	 * @param houseOwnerAddress
	 */
	public void setHouseOwnerAddress(String houseOwnerAddress) {
		this.houseOwnerAddress = houseOwnerAddress;
	}

	/**
	 * 집주인의 집소개를 리턴한다
	 * @return
	 */
	public String getHouseOwnerEtc() {
		return houseOwnerEtc;
	}

	/**
	 * 집주인의 집소개를 설정한다
	 * @param houseOwnerEtc
	 */
	public void setHouseOwnerEtc(String houseOwnerEtc) {
		this.houseOwnerEtc = houseOwnerEtc;
	}

	/**
	 * 집주인의 신뢰도를 리턴한다
	 * @return
	 */
	public String getHouseOwnerReliability() {
		return houseOwnerReliability;
	}

	/**
	 * 집주인의 신뢰도를 설정한다
	 * @param houseOwnerReliability
	 */
	public void setHouseOwnerReliability(String houseOwnerReliability) {
		this.houseOwnerReliability = houseOwnerReliability;
	}

	
	
}
