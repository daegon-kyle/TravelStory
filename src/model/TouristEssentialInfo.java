package model;

import java.io.Serializable;
import java.util.GregorianCalendar;
/**
 * ���ఴ�ʼ� ���� ���� Ŭ���� 
 * @author ����
 * 
 */
public class TouristEssentialInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5688838595127973948L;
	/**
	 * ���ఴ �ڵ� 
	 */
	private String touristCode;
	/**
	 * �ڱ�Ұ� 
	 */
	private String selfIntroduction;
	/**
	 * ��߳�¥
	 */
	private GregorianCalendar arrivalDate;
	/**
	 * ������¥ 
	 */
	private GregorianCalendar departureDate;
	/**
	 * ������ �� 
	 */
	private int companionNum;
	/**
	 * ����
	 */
	private String job;
	/**
	 * ���ఴ �̸� 
	 */
	private String name;
	/** 
	 * ���ఴ �̸���
	 */
	private String email;
	/**
	 * ���ఴ ��ȭ��ȣ 
	 */
	private String phone;
	/**
	 * null ������ 
	 */
	public TouristEssentialInfo() {
		this("","",new GregorianCalendar(), new GregorianCalendar(), 0, "","","","");
	}
	
	/**
	 * �����ε������� 
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
 * �����ε� ������ 
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
 * �����ε� ������ 
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
	 * �������ڵ带 ��ȯ�Ѵ�. 
	 * @return �������ڵ� 
	 */
	public String getTouristCode() {
		return touristCode;
	}

/**
 * �������ڵ带  �����Ѵ�. 
 * @param touristCode �������ڵ� 
 */
	public void setTouristCode(String touristCode) {
		this.touristCode = touristCode;
	}

/**
 * �ڱ�Ұ��� ��ȯ�Ѵ�. 
 * @return �ڱ�Ұ� 
 */
	public String getSelfIntroduction() {
		return selfIntroduction;
	}
	/**
	 * �ڱ�Ұ��� �����Ѵ�. 
	 * @param selfIntroduction �ڱ�Ұ� 
	 */
	public void setSelfIntroduction(String selfIntroduction) {
		this.selfIntroduction = selfIntroduction;
	}
	/**
	 * �������� ��ȯ�Ѵ�. 
	 * @return ������ 
	 */
	public GregorianCalendar getArrivalDate() {
		return arrivalDate;
	}
	/**
	 * �������� �����Ѵ�. 
	 * @param arrivalDate ������ 
	 */
	public void setArrivalDate(GregorianCalendar arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	/**
	 * ��������� ��ȯ�Ѵ�. 
	 * @return ������� 
	 */
	public GregorianCalendar getDepartureDate() {
		return departureDate;
	}
	/**
	 * ��������� �����Ѵ�. 
	 * @param departureDate �������
	 */
	public void setDepartureDate(GregorianCalendar departureDate) {
		this.departureDate = departureDate;
	}

	/**
	 * �����ڼ��� ��ȯ�Ѵ�. 
	 * @return �����ڼ� 
	 */
	public int getCompanionNum() {
		return companionNum;
	}
	/**
	 * �����ڼ��� �����Ѵ�. 
	 * @param companionNum �����ڼ� 
	 */
	public void setCompanionNum(int companionNum) {
		this.companionNum = companionNum;
	}
	/**
	 * ������ ��ȯ�Ѵ�. 
	 * @return ����
	 */
	public String getJob() {
		return job;
	}
	/**
	 * ������ �����Ѵ�. 
	 * @param job ����
	 */
	public void setJob(String job) {
		this.job = job;
	}
	/**
	 * �̸��� ��ȯ�Ѵ�. 
	 * @return �̸�
	 */
	public String getName() {
		return name;
	}
	/**
	 * �̸��� �����Ѵ�. 
	 * @param name �̸�
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * �̸����� ��ȯ�Ѵ�. 
	 * @return �̸���
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * �̸����� �����Ѵ�. 
	 * @param email �̸��� 
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * ����ó�� ��ȯ�Ѵ�.
	 * @return ����ó 
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * ����ó�� �����Ѵ�. 
	 * @param phone ����ó 
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
