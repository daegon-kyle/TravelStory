//작성날짜 : 2014/7/19
//작성자 : 이화섭

package dto;

/**
 * 여행객 테이블 정보를 저장할 클래스
 * @author 화섭
 *
 */
public class TouristDTO 
{
	private String touristCode;
	private String memberCode;
	private String job;
	private int companionNum;
	private String arrivalDate;
	private String departureDate;
	private String selfIntroduction;
	
	/**
	 * 기본생성자
	 */
	public TouristDTO()
	{
		this("","","",0,"","","");
	}
	
	/**
	 * 전달인자를 받는 생성자
	 * @param touristCode 여행객코드 
	 * @param memberCode 회원코드
	 * @param job 직업
	 * @param companionNum 동행자수
	 * @param arrivalDate 도착날짜
	 * @param departureDate 출발날짜
	 * @param selfIntroduction 자기소개
	 */
	public TouristDTO(String touristCode, String memberCode, String job, int companionNum, String arrivalDate, String departureDate, String selfIntroduction) 
	{ 
		this.touristCode = touristCode;
		this.memberCode = memberCode;
		this.job = job;
		this.companionNum = companionNum;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
		this.selfIntroduction = selfIntroduction;
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
	 * 직업을 리턴한다
	 * @return
	 */
	public String getJob() {
		return job;
	}
	/**
	 * 직업을 설정한다
	 * @param job
	 */
	public void setJob(String job) {
		this.job = job;
	}
	/**
	 * 동행자수를 리턴한다
	 * @return
	 */
	public int getCompanionNum() {
		return companionNum;
	}
	/**
	 * 동행자수를 설정한다
	 * @param companionNum
	 */
	public void setCompanionNum(int companionNum) {
		this.companionNum = companionNum;
	}
	/**
	 * 도착날짜를 리턴한다
	 * @return
	 */
	public String getArrivalDate() {
		return arrivalDate;
	}
	/**
	 * 도착날짜를 설정한다
	 * @param arrivalDate
	 */
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	/**
	 * 출발날짜를 리턴한다
	 * @return
	 */
	public String getDepartureDate() {
		return departureDate;
	}
	/**
	 * 출발날짜를 설정한다
	 * @param departureDate
	 */
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	/**
	 * 자기소개를 리턴한다
	 * @return
	 */
	public String getSelfIntroduction() {
		return selfIntroduction;
	}
	/**
	 * 자기소개를 설정하다
	 * @param selfIntroduction
	 */
	public void setSelfIntroduction(String selfIntroduction) {
		this.selfIntroduction = selfIntroduction;
	}
	
	
}
