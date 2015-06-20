//작성날짜 : 2014/7/27
//작성자 : 이화섭

package form;

/**
 * 집주인 되기 위해 입력해야 하는 집주인 필수입력사항 폼클래스
 * 
 *
 */
public class HouseOwnerEssentialInfoForm {
	/**
	 * 주소
	 */
	private String address;
	/**
	 * 방문 시작날짜
	 */
	private String visitStartDate;
	/**
	 * 방문 끝날짜
	 */
	private String visitEndDate;
	/**
	 * 직업
	 */
	private String job;
	/**
	 * 결혼유무
	 */
	private String marriedState;
	/**
	 * 자기소개
	 */
	private String selfIntroduction;
	/**
	 * 기타
	 */
	private String etc;
	
	/**
	 * 널생성자
	 */
	public HouseOwnerEssentialInfoForm() {
		this("","","","","","", "");
	}

	/**
	 * 생성자
	 * @param address 주소
	 * @param visitStartDate 방문 시작날짜
	 * @param visitEndDate 방문 끝날짜
	 * @param job 직업
	 * @param marriedState 결혼유무
	 * @param selfIntroduction 자기소개
	 * @param etc 기타
	 */
	public HouseOwnerEssentialInfoForm(String address, String visitStartDate,
			String visitEndDate, String job, String marriedState,
			String selfIntroduction, String etc) {
		this.address = address;
		this.visitStartDate = visitStartDate;
		this.visitEndDate = visitEndDate;
		this.job = job;
		this.marriedState = marriedState;
		this.selfIntroduction = selfIntroduction;
		this.etc=etc;
	}
	public HouseOwnerEssentialInfoForm(String address,String visitStartDate,String visitEndDate ){
		this(address,visitStartDate,visitEndDate,"","","","");
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getVisitStartDate() {
		return visitStartDate;
	}
	public void setVisitStartDate(String visitStartDate) {
		this.visitStartDate = visitStartDate;
	}
	public String getVisitEndDate() {
		return visitEndDate;
	}
	public void setVisitEndDate(String visitEndDate) {
		this.visitEndDate = visitEndDate;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getMarriedState() {
		return marriedState;
	}
	public void setMarriedState(String marriedState) {
		this.marriedState = marriedState;
	}
	public String getSelfIntroduction() {
		return selfIntroduction;
	}
	public void setSelfIntroduction(String selfIntroduction) {
		this.selfIntroduction = selfIntroduction;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}
}
