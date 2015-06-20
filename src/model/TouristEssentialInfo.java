package model;

import java.io.Serializable;
import java.util.GregorianCalendar;
/**
 * 여행객필수 사항 정보 클래스 
 * @author 영한
 * 
 */
public class TouristEssentialInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5688838595127973948L;
	/**
	 * 여행객 코드 
	 */
	private String touristCode;
	/**
	 * 자기소개 
	 */
	private String selfIntroduction;
	/**
	 * 출발날짜
	 */
	private GregorianCalendar arrivalDate;
	/**
	 * 도착날짜 
	 */
	private GregorianCalendar departureDate;
	/**
	 * 동행자 수 
	 */
	private int companionNum;
	/**
	 * 직업
	 */
	private String job;
	/**
	 * 여행객 이름 
	 */
	private String name;
	/** 
	 * 여행객 이메일
	 */
	private String email;
	/**
	 * 여행객 전화번호 
	 */
	private String phone;
	/**
	 * null 생성자 
	 */
	public TouristEssentialInfo() {
		this("","",new GregorianCalendar(), new GregorianCalendar(), 0, "","","","");
	}
	
	/**
	 * 오버로딩생성자 
	 * @param selfIntroduction
	 * @param arrivalDate
	 * @param departureDate
	 * @param companionNum
	 * @param job
	 */
	public TouristEssentialInfo(String selfIntroduction,
			GregorianCalendar arrivalDate, GregorianCalendar departureDate,
			int companionNum, String job) {
		this.selfIntroduction = selfIntroduction;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
		this.companionNum = companionNum;
		this.job = job;
	}
	
	

/**
 * 오버로딩 생성자 
 * @param selfIntroduction
 * @param arrivalDate
 * @param departureDate
 * @param companionNum
 * @param job
 * @param name
 * @param email
 * @param phone
 */
	public TouristEssentialInfo(String selfIntroduction,
			GregorianCalendar arrivalDate, GregorianCalendar departureDate,
			int companionNum, String job, String name, String email,
			String phone) {
		this.selfIntroduction = selfIntroduction;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
		this.companionNum = companionNum;
		this.job = job;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

/**
 * 오버로딩 생성자 
 * @param touristCode
 * @param selfIntroduction
 * @param arrivalDate
 * @param departureDate
 * @param companionNum
 * @param job
 * @param name
 * @param email
 * @param phone
 */
	public TouristEssentialInfo(String touristCode,String selfIntroduction,
			GregorianCalendar arrivalDate, GregorianCalendar departureDate,
			int companionNum, String job, String name, String email,
			String phone) {
		this.touristCode = touristCode;
		this.selfIntroduction = selfIntroduction;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
		this.companionNum = companionNum;
		this.job = job;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	/**
	 * 여행자코드를 반환한다. 
	 * @return 여행자코드 
	 */
	public String getTouristCode() {
		return touristCode;
	}

/**
 * 여행자코드를  세팅한다. 
 * @param touristCode 여행자코드 
 */
	public void setTouristCode(String touristCode) {
		this.touristCode = touristCode;
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
	 * 도착일을 반환한다. 
	 * @return 도착일 
	 */
	public GregorianCalendar getArrivalDate() {
		return arrivalDate;
	}
	/**
	 * 도착일을 세팅한다. 
	 * @param arrivalDate 도착일 
	 */
	public void setArrivalDate(GregorianCalendar arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	/**
	 * 생년월일을 반환한다. 
	 * @return 생년월일 
	 */
	public GregorianCalendar getDepartureDate() {
		return departureDate;
	}
	/**
	 * 생년월일을 세팅한다. 
	 * @param departureDate 생년월일
	 */
	public void setDepartureDate(GregorianCalendar departureDate) {
		this.departureDate = departureDate;
	}

	/**
	 * 동행자수를 반환한다. 
	 * @return 동행자수 
	 */
	public int getCompanionNum() {
		return companionNum;
	}
	/**
	 * 동행자수를 세팅한다. 
	 * @param companionNum 동행자수 
	 */
	public void setCompanionNum(int companionNum) {
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
	/**
	 * 이름을 반환한다. 
	 * @return 이름
	 */
	public String getName() {
		return name;
	}
	/**
	 * 이름을 세팅한다. 
	 * @param name 이름
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 이메일을 반환한다. 
	 * @return 이메일
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 이메이을 세팅한다. 
	 * @param email 이메일 
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 연락처를 반환한다.
	 * @return 연락처 
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 연락처를 세팅한다. 
	 * @param phone 연락처 
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
