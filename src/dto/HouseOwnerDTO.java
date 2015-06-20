//작성날짜 : 2014/7/19
//작성자 : 이화섭

package dto;

/**
 * 집주인 테이블 정보를 저장할 클래스
 * @author 화섭
 *
 */
public class HouseOwnerDTO 
{
	private String houseOwnerCode;
	private String memberCode;
	private String job;
	private String visitStartDate;
	private String visitEndDate;
	private String selfIntroduction;
	private String marriedState;
	private String address;
	private String etc;
	
	/**
	 * 기본생성자
	 */
	public HouseOwnerDTO()
	{
		this("","","","","","","","","");
	}
	
	/**
	 * 전달인자를 받는 생성자
	 * @param houseOwnerCode 집주인코드
	 * @param memberCode 회원코드
	 * @param job  직업
	 * @param visitStartDate 초대시작일
	 * @param visitEndDate 초대종요일
	 * @param selfIntroduction 자기소개
	 * @param marriedState 결혼상태
	 * @param address 집주소
	 * @param etc 집소개
	 */
	public HouseOwnerDTO(String houseOwnerCode, String memberCode, String job, String visitStartDate, String visitEndDate, String selfIntroduction, String marriedState, String address, String etc) 
	{
		super();
		this.houseOwnerCode = houseOwnerCode;
		this.memberCode = memberCode;
		this.job = job;
		this.visitStartDate = visitStartDate;
		this.visitEndDate = visitEndDate;
		this.selfIntroduction = selfIntroduction;
		this.marriedState = marriedState;
		this.address = address;
		this.etc = etc;
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
	 * 초대시작일을 리턴한다
	 * @return
	 */
	public String getVisitStartDate() {
		return visitStartDate;
	}
	/**
	 * 초대시작일을 설정한다
	 * @param visitStartDate
	 */
	public void setVisitStartDate(String visitStartDate) {
		this.visitStartDate = visitStartDate;
	}
	/**
	 * 초대종료일을 리턴한다
	 * @return
	 */
	public String getVisitEndDate() {
		return visitEndDate;
	}
	/**
	 * 초대종료일을 설정한다
	 * @param visitEndDate
	 */
	public void setVisitEndDate(String visitEndDate) {
		this.visitEndDate = visitEndDate;
	}
	/**
	 * 자기소개를 리턴한다
	 * @return
	 */
	public String getSelfIntroduction() {
		return selfIntroduction;
	}
	/**
	 * 자기소개를 설정한다
	 * @param selfIntroduction
	 */
	public void setSelfIntroduction(String selfIntroduction) {
		this.selfIntroduction = selfIntroduction;
	}
	/**
	 * 결혼상태를 리턴한다
	 * @return
	 */
	public String getMarriedState() {
		return marriedState;
	}
	/**
	 * 결혼상태를 설정한다
	 * @param marriedState
	 */
	public void setMarriedState(String marriedState) {
		this.marriedState = marriedState;
	}
	/**
	 * 집주소를 리턴한다
	 * @return
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 집주소를 설정한다
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 집정보를 리턴한다
	 * @return
	 */
	public String getEtc() {
		return etc;
	}
	/**
	 * 집정보를 설정한다
	 * @param etc
	 */
	public void setEtc(String etc) {
		this.etc = etc;
	}
	
	
}
