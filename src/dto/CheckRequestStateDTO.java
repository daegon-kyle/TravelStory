//�ۼ���¥ : 2014/7/20
//�ۼ��� : ��ȭ��

package dto;

/**
 * �����ΰ� ���ఴ�� ���� �����Ȳ ������ ���̺� Ŭ����
 * @author ȭ��
 *
 */
public class CheckRequestStateDTO 
{
	private String memberCode;
	private String touristCode;
	private String houseOwnerCode;
	private String requestState;
	private String houseOwnerName;
	private String houseOwnerEmail;
	private String houseOwnerGender;
	private String houseOwnerJob;
	private String houseOwnerVisitStartDate;
	private String houseOwnerVisitEndDate;
	private String houseOwnerSelfIntroduction;
	private String houseOwnerMarriedState;
	private String houseOwnerAddress;
	private String houseOwnerEtc;
	private String houseOwnerReliability;
	
	/**
	 * �⺻������
	 */
	public CheckRequestStateDTO()
	{
		this("","","","","","","","","","","","","","","");
	}

	/**
	 * �������ڸ� �޴� ������
	 * @param memberCode ȸ���ڵ�
	 * @param touristCode ���ఴ�ڵ�
	 * @param houseOwnerCode �������ڵ�
	 * @param requestState �����Ȳ
	 * @param houseOwnerName �������̸�
	 * @param houseOwnerEmail �������̸����ּ�
	 * @param houseOwnerGender �����μ�
	 * @param houseOwnerJob ����������
	 * @param houseOwnerVisitStartDate ������ ��� ������ �湮 ������
	 * @param houseOwnerVisitEndDate �������� ��� ������ �湮 ������
	 * @param houseOwnerSelfIntroduction �����μҰ�
	 * @param houseOwnerMarriedState ������ ��ȥ����
	 * @param houseOwnerAddress ������ �ּ�
	 * @param houseOwnerEtc ������ ���� ���� �Ұ�
	 * @param houseOwnerReliability �������� �ŷڵ�
	 */
	public CheckRequestStateDTO(String memberCode, String touristCode,
			String houseOwnerCode, String requestState, String houseOwnerName,
			String houseOwnerEmail, String houseOwnerGender,
			String houseOwnerJob, String houseOwnerVisitStartDate,
			String houseOwnerVisitEndDate, String houseOwnerSelfIntroduction,
			String houseOwnerMarriedState, String houseOwnerAddress,
			String houseOwnerEtc, String houseOwnerReliability) { 
		this.memberCode = memberCode;
		this.touristCode = touristCode;
		this.houseOwnerCode = houseOwnerCode;
		this.requestState = requestState;
		this.houseOwnerName = houseOwnerName;
		this.houseOwnerEmail = houseOwnerEmail;
		this.houseOwnerGender = houseOwnerGender;
		this.houseOwnerJob = houseOwnerJob;
		this.houseOwnerVisitStartDate = houseOwnerVisitStartDate;
		this.houseOwnerVisitEndDate = houseOwnerVisitEndDate;
		this.houseOwnerSelfIntroduction = houseOwnerSelfIntroduction;
		this.houseOwnerMarriedState = houseOwnerMarriedState;
		this.houseOwnerAddress = houseOwnerAddress;
		this.houseOwnerEtc = houseOwnerEtc;
		this.houseOwnerReliability = houseOwnerReliability;
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
	 * ��û���¸� �����Ѵ�
	 * @return
	 */
	public String getRequestState() {
		return requestState;
	}

	/**
	 * ��û���¸� �����Ѵ�
	 * @param requestState
	 */
	public void setRequestState(String requestState) {
		this.requestState = requestState;
	}

	/**
	 * �������� �̸��� �����Ѵ�
	 * @return
	 */
	public String getHouseOwnerName() {
		return houseOwnerName;
	}

	/**
	 * ���������̸��� �����Ѵ�
	 * @param houseOwnerName
	 */
	public void setHouseOwnerName(String houseOwnerName) {
		this.houseOwnerName = houseOwnerName;
	}

	/**
	 * �������̸����ּҸ� �����Ѵ�
	 * @return
	 */
	public String getHouseOwnerEmail() {
		return houseOwnerEmail;
	}

	/**
	 * �������̸����ּҸ� �����Ѵ�
	 * @param houseOwnerEmail
	 */
	public void setHouseOwnerEmail(String houseOwnerEmail) {
		this.houseOwnerEmail = houseOwnerEmail;
	}

	/**
	 * ������ ���� �����Ѵ�
	 * @return
	 */
	public String getHouseOwnerGender() {
		return houseOwnerGender;
	}

	/**
	 * ������ ���� �����Ѵ�
	 * @param houseOwnerGender
	 */
	public void setHouseOwnerGender(String houseOwnerGender) {
		this.houseOwnerGender = houseOwnerGender;
	}

	/**
	 * �������� ������ �����Ѵ�
	 * @return
	 */
	public String getHouseOwnerJob() {
		return houseOwnerJob;
	}

	/**
	 * �������� ������ �����Ѵ�
	 * @param houseOwnerJob
	 */
	public void setHouseOwnerJob(String houseOwnerJob) {
		this.houseOwnerJob = houseOwnerJob;
	}

	/**
	 * �������� �ʴ밡�ɽ������� �����Ѵ�
	 * @return
	 */
	public String getHouseOwnerVisitStartDate() {
		return houseOwnerVisitStartDate;
	}

	/**
	 * �������� �ʴ밡�ɽ������� �����Ѵ�
	 * @param houseOwnerVisitStartDate
	 */
	public void setHouseOwnerVisitStartDate(String houseOwnerVisitStartDate) {
		this.houseOwnerVisitStartDate = houseOwnerVisitStartDate;
	}

	/**
	 * �������� �ʴ밡���������� �����Ѵ�
	 * @return
	 */
	public String getHouseOwnerVisitEndDate() {
		return houseOwnerVisitEndDate;
	}

	/**
	 * �������� �ʴ밡���������� �����Ѵ�
	 * @param houseOwnerVisitEndDate
	 */
	public void setHouseOwnerVisitEndDate(String houseOwnerVisitEndDate) {
		this.houseOwnerVisitEndDate = houseOwnerVisitEndDate;
	}

	/**
	 * �������� �Ұ��� �����Ѵ�
	 * @return
	 */
	public String getHouseOwnerSelfIntroduction() {
		return houseOwnerSelfIntroduction;
	}

	/**
	 * �������� �Ұ��� �����Ѵ�
	 * @param houseOwnerSelfIntroduction
	 */
	public void setHouseOwnerSelfIntroduction(String houseOwnerSelfIntroduction) {
		this.houseOwnerSelfIntroduction = houseOwnerSelfIntroduction;
	}

	/**
	 * �������� ��ȥ���¸� �����Ѵ�
	 * @return
	 */
	public String getHouseOwnerMarriedState() {
		return houseOwnerMarriedState;
	}

	/**
	 * �������� ��ȥ���¸� �����Ѵ�
	 * @param houseOwnerMarriedState
	 */
	public void setHouseOwnerMarriedState(String houseOwnerMarriedState) {
		this.houseOwnerMarriedState = houseOwnerMarriedState;
	}

	/**
	 * �������� �ּҸ� �����Ѵ�
	 * @return
	 */
	public String getHouseOwnerAddress() {
		return houseOwnerAddress;
	}
	
	/**
	 * �������� �ּҸ� �����Ѵ�
	 * @param houseOwnerAddress
	 */
	public void setHouseOwnerAddress(String houseOwnerAddress) {
		this.houseOwnerAddress = houseOwnerAddress;
	}

	/**
	 * �������� ���Ұ��� �����Ѵ�
	 * @return
	 */
	public String getHouseOwnerEtc() {
		return houseOwnerEtc;
	}

	/**
	 * �������� ���Ұ��� �����Ѵ�
	 * @param houseOwnerEtc
	 */
	public void setHouseOwnerEtc(String houseOwnerEtc) {
		this.houseOwnerEtc = houseOwnerEtc;
	}

	/**
	 * �������� �ŷڵ��� �����Ѵ�
	 * @return
	 */
	public String getHouseOwnerReliability() {
		return houseOwnerReliability;
	}

	/**
	 * �������� �ŷڵ��� �����Ѵ�
	 * @param houseOwnerReliability
	 */
	public void setHouseOwnerReliability(String houseOwnerReliability) {
		this.houseOwnerReliability = houseOwnerReliability;
	}

	
	
}
