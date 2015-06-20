//작성날짜 : 2014/7/27
//작성자 : 이화섭

package model;

import java.io.Serializable;
import java.util.GregorianCalendar;
/**
 * 집주인 필수입력사항을 캡슐화한 클래스
 * <br>HouseOwnerInfoManagerServlet에서 사용하는 클래스
 * @author 대곤
 *
 */
public class HouseOwnerEssentialInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9115531177216429860L;
	/**
	 * 집주인 코드
	 */
	private String houseOwnerCode;
	/**
	 * 주소
	 */
	private String address;
	/**
	 * 방문시작날짜
	 */
	private GregorianCalendar visitStartDate;
	/**
	 * 방문 끝 날짜
	 */
	private GregorianCalendar visitEndDate;
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
	 * 기타정보
	 */
	private String etc;
	/**
	 * 이름
	 */
	private String name;
	/**
	 * 이메일
	 */
	private String email;
	
	/**
	 * 널생성자
	 */
	public HouseOwnerEssentialInfo() {
		this("","",new GregorianCalendar(), new GregorianCalendar(), "", "", "","","","");
	}
	/**
	 * 기본생성자(사용자가 입력한)
	 * @param address 주소
	 * @param visitStartDate 방문시작날짜
	 * @param visitEndDate 방문끝날짜
	 */
	
	
	public HouseOwnerEssentialInfo(String address, GregorianCalendar visitStartDate, GregorianCalendar visitEndDate){
		this("",address,visitStartDate,visitEndDate,"","","","","","");
	}
	/**
	 * 기본생성자(사용자가 입력한 정보 외에 DB에서 불러온 정보도 저장) 
	 * @param address 주소 
	 * @param visitStartDate  방문시작날짜
	 * @param visitEndDate 방문끝날짜
	 * @param job 직업
	 * @param marriedState 결혼상태
	 * @param selfIntroduction 자기소개
	 * @param etc 기타정보
	 * @param name 이름
	 * @param email 이메일
	 */
	public HouseOwnerEssentialInfo(String address,
			GregorianCalendar visitStartDate, GregorianCalendar visitEndDate,
			String job, String marriedState, String selfIntroduction,
			String etc) 
	{
		this("", address,visitStartDate,visitEndDate,job,marriedState,selfIntroduction,etc,"","");;
	}
	/**
	 * 기본생성자(사용자가 입력한 정보 외에 DB에서 불러온 정보도 저장)
	 * @param houseOwnerCode 집주인코드
	 * @param address 주소 
	 * @param visitStartDate  방문시작날짜
	 * @param visitEndDate 방문끝날짜
	 * @param job 직업
	 * @param marriedState 결혼상태
	 * @param selfIntroduction 자기소개
	 * @param etc 기타정보
	 * @param name 이름
	 * @param email 이메일
	 */
	public HouseOwnerEssentialInfo(String houseOwnerCode, String address,
			GregorianCalendar visitStartDate, GregorianCalendar visitEndDate,
			String job, String marriedState, String selfIntroduction,
			String etc, String name, String email) {
		this.houseOwnerCode = houseOwnerCode;
		this.address = address;
		this.visitStartDate = visitStartDate;
		this.visitEndDate = visitEndDate;
		this.job = job;
		this.marriedState = marriedState;
		this.selfIntroduction = selfIntroduction;
		this.etc = etc;
		this.name = name;
		this.email = email;
	}
	/**
	 * 주소 반환
	 * @return 주소
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 주소 설정
	 * @param address 주소
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 방문시작날짜 반환
	 * @return 방문시작날짜
	 */
	public GregorianCalendar getVisitStartDate() {
		return visitStartDate;
	}
	/**
	 * 방문 시작날짜 설정
	 * @param visitStartDate 방문시작날짜
	 */
	public void setVisitStartDate(GregorianCalendar visitStartDate) {
		this.visitStartDate = visitStartDate;
	}
	/**
	 * 방문끝날짜
	 * @return 방문끝날짜
	 */
	public GregorianCalendar getVisitEndDate() {
		return visitEndDate;
	}
	/**
	 * 방문끝날짜 설정
	 * @param visitEndDate 방문끝날짜
	 */
	public void setVisitEndDate(GregorianCalendar visitEndDate) {
		this.visitEndDate = visitEndDate;
	}
	/**
	 * 직업 반환
	 * @return 직업
	 */
	public String getJob() {
		return job;
	}
	/**
	 * 직업 설정
	 * @param job 직업
	 */
	public void setJob(String job) {
		this.job = job;
	}
	/**
	 * 결혼상태체크
	 * @return 결혼상태
	 */
	public String getMarriedState() {
		return marriedState;
	}
	/**
	 * 결혼상태설정
	 * @param marriedState 결혼상태
	 */
	public void setMarriedState(String marriedState) {
		this.marriedState = marriedState;
	}
	/**
	 * 자기소개 반환
	 * @return 자기소개
	 */
	public String getSelfIntroduction() {
		return selfIntroduction;
	}
	/**
	 * 자기소개 설정
	 * @param selfIntroduction 자기소개
	 */
	public void setSelfIntroduction(String selfIntroduction) {
		this.selfIntroduction = selfIntroduction;
	}
	/**
	 * 기타정보 반환
	 * @return 기타
	 */
	public String getEtc() {
		return etc;
	}
	/**
	 * 기타정보 설정
	 * @param etc 기타정보
	 */
	public void setEtc(String etc) {
		this.etc = etc;
	}
	/**
	 * 이름 반환
	 * @return 이름
	 */
	public String getName() {
		return name;
	}
	/**
	 * 이름 설정
	 * @param name 이름
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 이메일 반환
	 * @return 이메일
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 이메일 설정
	 * @param email 이메일
	 */
	public void setEmail(String email) {
		this.email = email;
	}
/**
 * 집주인코드 반환
 * @return 집주인코드
 */
	public String getHouseOwnerCode() {
		return houseOwnerCode;
	}
/**
 * 집주인 코드 설정
 * @param houseOwnerCode 집주인코드
 */
	public void setHouseOwnerCode(String houseOwnerCode) {
		this.houseOwnerCode = houseOwnerCode;
	}
	
	
	
	
}
