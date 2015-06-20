//�ۼ���¥ : 2014/7/19
//�ۼ��� : ��ȭ��

package dto;

/**
 * ���ఴ ���̺� ������ ������ Ŭ����
 * @author ȭ��
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
	 * �⺻������
	 */
	public TouristDTO()
	{
		this("","","",0,"","","");
	}
	
	/**
	 * �������ڸ� �޴� ������
	 * @param touristCode ���ఴ�ڵ� 
	 * @param memberCode ȸ���ڵ�
	 * @param job ����
	 * @param companionNum �����ڼ�
	 * @param arrivalDate ������¥
	 * @param departureDate ��߳�¥
	 * @param selfIntroduction �ڱ�Ұ�
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
	 * ���ఴ�ڵ带 �����Ѵ�
	 * @return
	 */
	public String getTouristCode() {
		return touristCode;
	}
	/**
	 * ���ఴ�ڵ带 �����Ѵ�
	 * @param touristCode
	 */
	public void setTouristCode(String touristCode) {
		this.touristCode = touristCode;
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
	 * �����ڼ��� �����Ѵ�
	 * @return
	 */
	public int getCompanionNum() {
		return companionNum;
	}
	/**
	 * �����ڼ��� �����Ѵ�
	 * @param companionNum
	 */
	public void setCompanionNum(int companionNum) {
		this.companionNum = companionNum;
	}
	/**
	 * ������¥�� �����Ѵ�
	 * @return
	 */
	public String getArrivalDate() {
		return arrivalDate;
	}
	/**
	 * ������¥�� �����Ѵ�
	 * @param arrivalDate
	 */
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	/**
	 * ��߳�¥�� �����Ѵ�
	 * @return
	 */
	public String getDepartureDate() {
		return departureDate;
	}
	/**
	 * ��߳�¥�� �����Ѵ�
	 * @param departureDate
	 */
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	/**
	 * �ڱ�Ұ��� �����Ѵ�
	 * @return
	 */
	public String getSelfIntroduction() {
		return selfIntroduction;
	}
	/**
	 * �ڱ�Ұ��� �����ϴ�
	 * @param selfIntroduction
	 */
	public void setSelfIntroduction(String selfIntroduction) {
		this.selfIntroduction = selfIntroduction;
	}
	
	
}
