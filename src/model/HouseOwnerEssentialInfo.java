//�ۼ���¥ : 2014/7/27
//�ۼ��� : ��ȭ��

package model;

import java.io.Serializable;
import java.util.GregorianCalendar;
/**
 * ������ �ʼ��Է»����� ĸ��ȭ�� Ŭ����
 * <br>HouseOwnerInfoManagerServlet���� ����ϴ� Ŭ����
 * @author ���
 *
 */
public class HouseOwnerEssentialInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9115531177216429860L;
	/**
	 * ������ �ڵ�
	 */
	private String houseOwnerCode;
	/**
	 * �ּ�
	 */
	private String address;
	/**
	 * �湮���۳�¥
	 */
	private GregorianCalendar visitStartDate;
	/**
	 * �湮 �� ��¥
	 */
	private GregorianCalendar visitEndDate;
	/**
	 * ����
	 */
	private String job;
	/**
	 * ��ȥ����
	 */
	private String marriedState;
	/**
	 * �ڱ�Ұ�
	 */
	private String selfIntroduction;
	/**
	 * ��Ÿ����
	 */
	private String etc;
	/**
	 * �̸�
	 */
	private String name;
	/**
	 * �̸���
	 */
	private String email;
	
	/**
	 * �λ�����
	 */
	public HouseOwnerEssentialInfo() {
		this("","",new GregorianCalendar(), new GregorianCalendar(), "", "", "","","","");
	}
	/**
	 * �⺻������(����ڰ� �Է���)
	 * @param address �ּ�
	 * @param visitStartDate �湮���۳�¥
	 * @param visitEndDate �湮����¥
	 */
	
	
	public HouseOwnerEssentialInfo(String address, GregorianCalendar visitStartDate, GregorianCalendar visitEndDate){
		this("",address,visitStartDate,visitEndDate,"","","","","","");
	}
	/**
	 * �⺻������(����ڰ� �Է��� ���� �ܿ� DB���� �ҷ��� ������ ����) 
	 * @param address �ּ� 
	 * @param visitStartDate  �湮���۳�¥
	 * @param visitEndDate �湮����¥
	 * @param job ����
	 * @param marriedState ��ȥ����
	 * @param selfIntroduction �ڱ�Ұ�
	 * @param etc ��Ÿ����
	 * @param name �̸�
	 * @param email �̸���
	 */
	public HouseOwnerEssentialInfo(String address,
			GregorianCalendar visitStartDate, GregorianCalendar visitEndDate,
			String job, String marriedState, String selfIntroduction,
			String etc) 
	{
		this("", address,visitStartDate,visitEndDate,job,marriedState,selfIntroduction,etc,"","");;
	}
	/**
	 * �⺻������(����ڰ� �Է��� ���� �ܿ� DB���� �ҷ��� ������ ����)
	 * @param houseOwnerCode �������ڵ�
	 * @param address �ּ� 
	 * @param visitStartDate  �湮���۳�¥
	 * @param visitEndDate �湮����¥
	 * @param job ����
	 * @param marriedState ��ȥ����
	 * @param selfIntroduction �ڱ�Ұ�
	 * @param etc ��Ÿ����
	 * @param name �̸�
	 * @param email �̸���
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
	 * �ּ� ��ȯ
	 * @return �ּ�
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * �ּ� ����
	 * @param address �ּ�
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * �湮���۳�¥ ��ȯ
	 * @return �湮���۳�¥
	 */
	public GregorianCalendar getVisitStartDate() {
		return visitStartDate;
	}
	/**
	 * �湮 ���۳�¥ ����
	 * @param visitStartDate �湮���۳�¥
	 */
	public void setVisitStartDate(GregorianCalendar visitStartDate) {
		this.visitStartDate = visitStartDate;
	}
	/**
	 * �湮����¥
	 * @return �湮����¥
	 */
	public GregorianCalendar getVisitEndDate() {
		return visitEndDate;
	}
	/**
	 * �湮����¥ ����
	 * @param visitEndDate �湮����¥
	 */
	public void setVisitEndDate(GregorianCalendar visitEndDate) {
		this.visitEndDate = visitEndDate;
	}
	/**
	 * ���� ��ȯ
	 * @return ����
	 */
	public String getJob() {
		return job;
	}
	/**
	 * ���� ����
	 * @param job ����
	 */
	public void setJob(String job) {
		this.job = job;
	}
	/**
	 * ��ȥ����üũ
	 * @return ��ȥ����
	 */
	public String getMarriedState() {
		return marriedState;
	}
	/**
	 * ��ȥ���¼���
	 * @param marriedState ��ȥ����
	 */
	public void setMarriedState(String marriedState) {
		this.marriedState = marriedState;
	}
	/**
	 * �ڱ�Ұ� ��ȯ
	 * @return �ڱ�Ұ�
	 */
	public String getSelfIntroduction() {
		return selfIntroduction;
	}
	/**
	 * �ڱ�Ұ� ����
	 * @param selfIntroduction �ڱ�Ұ�
	 */
	public void setSelfIntroduction(String selfIntroduction) {
		this.selfIntroduction = selfIntroduction;
	}
	/**
	 * ��Ÿ���� ��ȯ
	 * @return ��Ÿ
	 */
	public String getEtc() {
		return etc;
	}
	/**
	 * ��Ÿ���� ����
	 * @param etc ��Ÿ����
	 */
	public void setEtc(String etc) {
		this.etc = etc;
	}
	/**
	 * �̸� ��ȯ
	 * @return �̸�
	 */
	public String getName() {
		return name;
	}
	/**
	 * �̸� ����
	 * @param name �̸�
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * �̸��� ��ȯ
	 * @return �̸���
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * �̸��� ����
	 * @param email �̸���
	 */
	public void setEmail(String email) {
		this.email = email;
	}
/**
 * �������ڵ� ��ȯ
 * @return �������ڵ�
 */
	public String getHouseOwnerCode() {
		return houseOwnerCode;
	}
/**
 * ������ �ڵ� ����
 * @param houseOwnerCode �������ڵ�
 */
	public void setHouseOwnerCode(String houseOwnerCode) {
		this.houseOwnerCode = houseOwnerCode;
	}
	
	
	
	
}
