//�ۼ���¥ : 2014/7/19
//�ۼ��� : ��ȭ��

package dto;

/**
 * ������ ���̺� ������ ������ Ŭ����
 * @author ȭ��
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
	 * �⺻������
	 */
	public HouseOwnerDTO()
	{
		this("","","","","","","","","");
	}
	
	/**
	 * �������ڸ� �޴� ������
	 * @param houseOwnerCode �������ڵ�
	 * @param memberCode ȸ���ڵ�
	 * @param job  ����
	 * @param visitStartDate �ʴ������
	 * @param visitEndDate �ʴ�������
	 * @param selfIntroduction �ڱ�Ұ�
	 * @param marriedState ��ȥ����
	 * @param address ���ּ�
	 * @param etc ���Ұ�
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
	 * �������ڵ带 �����Ѵ�
	 * @return
	 */
	public String getHouseOwnerCode() {
		return houseOwnerCode;
	}
	/**
	 * �������ڵ带 �����Ѵ�
	 * @param houseOwnerCode
	 */
	public void setHouseOwnerCode(String houseOwnerCode) {
		this.houseOwnerCode = houseOwnerCode;
	}
	/**
	 * ȸ���ڵ带 �����Ѵ�
	 * @return
	 */
	public String getMemberCode() {
		return memberCode;
	}
	/**
	 * ȸ���ڵ带 �����Ѵ�
	 * @param memberCode
	 */
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	/**
	 * ������ �����Ѵ�
	 * @return
	 */
	public String getJob() {
		return job;
	}
	/**
	 * ������ �����Ѵ�
	 * @param job
	 */
	public void setJob(String job) {
		this.job = job;
	}
	/**
	 * �ʴ�������� �����Ѵ�
	 * @return
	 */
	public String getVisitStartDate() {
		return visitStartDate;
	}
	/**
	 * �ʴ�������� �����Ѵ�
	 * @param visitStartDate
	 */
	public void setVisitStartDate(String visitStartDate) {
		this.visitStartDate = visitStartDate;
	}
	/**
	 * �ʴ��������� �����Ѵ�
	 * @return
	 */
	public String getVisitEndDate() {
		return visitEndDate;
	}
	/**
	 * �ʴ��������� �����Ѵ�
	 * @param visitEndDate
	 */
	public void setVisitEndDate(String visitEndDate) {
		this.visitEndDate = visitEndDate;
	}
	/**
	 * �ڱ�Ұ��� �����Ѵ�
	 * @return
	 */
	public String getSelfIntroduction() {
		return selfIntroduction;
	}
	/**
	 * �ڱ�Ұ��� �����Ѵ�
	 * @param selfIntroduction
	 */
	public void setSelfIntroduction(String selfIntroduction) {
		this.selfIntroduction = selfIntroduction;
	}
	/**
	 * ��ȥ���¸� �����Ѵ�
	 * @return
	 */
	public String getMarriedState() {
		return marriedState;
	}
	/**
	 * ��ȥ���¸� �����Ѵ�
	 * @param marriedState
	 */
	public void setMarriedState(String marriedState) {
		this.marriedState = marriedState;
	}
	/**
	 * ���ּҸ� �����Ѵ�
	 * @return
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * ���ּҸ� �����Ѵ�
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * �������� �����Ѵ�
	 * @return
	 */
	public String getEtc() {
		return etc;
	}
	/**
	 * �������� �����Ѵ�
	 * @param etc
	 */
	public void setEtc(String etc) {
		this.etc = etc;
	}
	
	
}
