//작성날짜 : 2014/7/19
//작성자 : 이화섭

package dto;

/**
 * 방문신청자 테이블 정보를 저장할 클래스
 * @author 화섭
 *
 */
public class VisitRequestersInfoDTO 
{
	private String houseOwnerCode;
	private String touristCode;
	private String requestState;
	private String touristName;
	private String touristEmail;
	private String touristGender;
	private String touristJob;
	private String touristArrivalDate;
	private String touristDepartureDate;
	private String touristSelfIntroduction;
	private int touristCompanionNum;
	private String touristReliability;
	
	/**
	 * 기본생성자
	 */
	public VisitRequestersInfoDTO()
	{
		this("", "", "", "", "", "", "", "", "", "", 0, "");
	}

	/**
	 * 전달이자를 받는 생성자
	 * @param houseOwnerCode 집주인코드
	 * @param touristCode 여행객코드
	 * @param requestState 진행상태
	 * @param touristName 여행객이름
	 * @param touristEmail 여행객이메일
	 * @param touristGender 여행객 성
	 * @param touristJob 여행개깆ㄱ업
	 * @param touristArrivalDate 여행객 도착예정일
	 * @param touristDepartureDate 여행객 떠날날짜
	 * @param touristSelfIntroduction 여행객 자기소개
	 * @param touristCompanionNum 여행객 동해자수
	 * @param touristReliability 여행객 신용도
	 */
	public VisitRequestersInfoDTO(String houseOwnerCode, String touristCode, String requestState, String touristName, String touristEmail, String touristGender, String touristJob, String touristArrivalDate, String touristDepartureDate, String touristSelfIntroduction, int touristCompanionNum, String touristReliability) 
	{ 
		this.houseOwnerCode = houseOwnerCode;
		this.touristCode = touristCode;
		this.requestState = requestState;
		this.touristName = touristName;
		this.touristEmail = touristEmail;
		this.touristGender = touristGender;
		this.touristJob = touristJob;
		this.touristArrivalDate = touristArrivalDate;
		this.touristDepartureDate = touristDepartureDate;
		this.touristSelfIntroduction = touristSelfIntroduction;
		this.touristCompanionNum = touristCompanionNum;
		this.touristReliability = touristReliability;
	}

	/**
	 * 집주인 코드 리턴한다
	 * @return
	 */
	public String getHouseOwnerCode() {
		return houseOwnerCode;
	}

	/**
	 * 집주인 코드를 설정한다
	 * @param houseOwnerCode
	 */
	public void setHouseOwnerCode(String houseOwnerCode) {
		this.houseOwnerCode = houseOwnerCode;
	}

	/**
	 * 여행객정보를 리턴한다
	 * @return
	 */
	public String getTouristCode() {
		return touristCode;
	}

	/**
	 * 여행객정보를 설정한다
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

	/**
	 * 여행객 이름을 리턴한다
	 * @return
	 */
	public String getTouristName() {
		return touristName;
	}

	/**
	 * 여행객 이름을 설정한다
	 * @param touristName
	 */
	public void setTouristName(String touristName) {
		this.touristName = touristName;
	}

	/**
	 * 여행객 이메일을 리턴한다
	 * @return
	 */
	public String getTouristEmail() {
		return touristEmail;
	}

	/**
	 * 여행객이메일을 설정한다
	 * @param touristEmail
	 */
	public void setTouristEmail(String touristEmail) {
		this.touristEmail = touristEmail;
	}

	/**
	 * 여행객 성을 리턴한다
	 * @return
	 */
	public String getTouristGender() {
		return touristGender;
	}

	/**
	 * 여행객 성을 설정한다
	 * @param touristGender
	 */
	public void setTouristGender(String touristGender) {
		this.touristGender = touristGender;
	}

	/**
	 * 여행객 직업을 리턴한다
	 * @return
	 */
	public String getTouristJob() {
		return touristJob;
	}

	/**
	 * 여행객 직업을 설정한다
	 * @param touristJob
	 */
	public void setTouristJob(String touristJob) {
		this.touristJob = touristJob;
	}

	/**
	 * 여행객 도착예정일을 리턴한다
	 * @return
	 */
	public String getTouristArrivalDate() {
		return touristArrivalDate;
	}

	/**
	 * 여행객 도착예쩡일을 설정한다
	 * @param touristArrivalDate
	 */
	public void setTouristArrivalDate(String touristArrivalDate) {
		this.touristArrivalDate = touristArrivalDate;
	}

	/**
	 * 여행객 집주인 집을 출발할예정일을 리턴한다
	 * @return
	 */
	public String getTouristDepartureDate() {
		return touristDepartureDate;
	}

	/**
	 * 여행객 집주인 집 출발예정일을 설정한다
	 * @param touristDepartureDate
	 */
	public void setTouristDepartureDate(String touristDepartureDate) {
		this.touristDepartureDate = touristDepartureDate;
	}

	/**
	 * 여행객자기소개를 리턴한다
	 * @return
	 */
	public String getTouristSelfIntroduction() {
		return touristSelfIntroduction;
	}

	/**
	 * 여행객자기소개를 설정한다
	 * @param touristSelfIntroduction
	 */
	public void setTouristSelfIntroduction(String touristSelfIntroduction) {
		this.touristSelfIntroduction = touristSelfIntroduction;
	}

	/**
	 * 동행자수를 리턴한다
	 * @return
	 */
	public int getTouristCompanionNum() {
		return touristCompanionNum;
	}

	/**
	 * 동행자수를 설정한다
	 * @param touristCompanionNum
	 */
	public void setTouristCompanionNum(int touristCompanionNum) {
		this.touristCompanionNum = touristCompanionNum;
	}

	/**
	 * 여행객 신뢰도를 리턴한다
	 * @return
	 */
	public String getTouristReliability() {
		return touristReliability;
	}

	/** 
	 * 여행객신뢰도를 설정한다
	 * @param touristReliability
	 */
	public void setTouristReliability(String touristReliability) {
		this.touristReliability = touristReliability;
	}
	
	

	
}
