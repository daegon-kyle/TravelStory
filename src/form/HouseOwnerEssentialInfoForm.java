//�ۼ���¥ : 2014/7/27
//�ۼ��� : ��ȭ��

package form;

/**
 * ������ �Ǳ� ���� �Է��ؾ� �ϴ� ������ �ʼ��Է»��� ��Ŭ����
 * 
 *
 */
public class HouseOwnerEssentialInfoForm {
	/**
	 * �ּ�
	 */
	private String address;
	/**
	 * �湮 ���۳�¥
	 */
	private String visitStartDate;
	/**
	 * �湮 ����¥
	 */
	private String visitEndDate;
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
	 * ��Ÿ
	 */
	private String etc;
	
	/**
	 * �λ�����
	 */
	public HouseOwnerEssentialInfoForm() {
		this("","","","","","", "");
	}

	/**
	 * ������
	 * @param address �ּ�
	 * @param visitStartDate �湮 ���۳�¥
	 * @param visitEndDate �湮 ����¥
	 * @param job ����
	 * @param marriedState ��ȥ����
	 * @param selfIntroduction �ڱ�Ұ�
	 * @param etc ��Ÿ
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
