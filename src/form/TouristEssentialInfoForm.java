package form;
/**
 * 집주인에게 방문신청하기 위해 필수적으로 입력해야하는 폼 클래스
 * VisitRequestServlet에서 호출 
 * @author 영한
 *
 */
public class TouristEssentialInfoForm {
	/**
	 * 자기소개
	 */
	private String selfIntroduction;
	/**
	 * 방문 시작날짜
	 */
	private String visitStartDate;
	/**
	 * 방문 끝날짜
	 */
	private String visitEndDate;
	/**
	 * 동행자수
	 */
	private String companionNum;
	/**
	 * 직업
	 */
	private String job;
	/**
	 * null생성자 
	 */
	public TouristEssentialInfoForm() {
		this("","","","","");
	}
	/**
	 * 자기소개, 방문시작일, 방문종료일, 동행자수, 직업을 초기화하는 생성자 
	 * @param selfIntroduction
	 * @param visitStartDate
	 * @param visitEndDate
	 * @param companionNum
	 * @param job
	 */
	public TouristEssentialInfoForm(String selfIntroduction,
			String visitStartDate, String visitEndDate, String companionNum,
			String job) {
		this.selfIntroduction = selfIntroduction;
		this.visitStartDate = visitStartDate;
		this.visitEndDate = visitEndDate;
		this.companionNum = companionNum;
		this.job = job;
	}

	/**
	 * 자기소개를 반환한다.
	 * @return 자기소개 
	 */
	public String getSelfIntroduction() {
		return selfIntroduction;
	}
/**
 * 자기소개를 세팅한다.
 * @param selfIntroduction 자기소개 
 */
	public void setSelfIntroduction(String selfIntroduction) {
		this.selfIntroduction = selfIntroduction;
	}
/**
 * 방문시작일을 반환한다.
 * @return 방문시작일 
 */
	public String getVisitStartDate() {
		return visitStartDate;
	}
/**
 * 방문시작일을 세팅한다. 
 * @param visitStartDate 방문시작일
 */
	public void setVisitStartDate(String visitStartDate) {
		this.visitStartDate = visitStartDate;
	}
/**
 * 방문종료일을 반환한다.
 * @return 방문종료일
 */
	public String getVisitEndDate() {
		return visitEndDate;
	}
/**
 * 방문종료일을 세팅한다.
 * @param visitEndDate 방문종료일
 */
	public void setVisitEndDate(String visitEndDate) {
		this.visitEndDate = visitEndDate;
	}
/**
 * 동행자수를 반환한다.
 * @return 동행자수 
 */
	public String getCompanionNum() {
		return companionNum;
	}
/**
 * 동행자수를 세팅한다. 
 * @param companionNum 동행자수 
 */
	public void setCompanionNum(String companionNum) {
		this.companionNum = companionNum;
	}
/**
 * 직업을 반환한다.
 * @return 직업
 */
	public String getJob() {
		return job;
	}
/**
 * 직업을 세팅한다.
 * @param job 직업
 */
	public void setJob(String job) {
		this.job = job;
	}
	
	
	
}
