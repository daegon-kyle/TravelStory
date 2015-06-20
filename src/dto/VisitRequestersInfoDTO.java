//�ۼ���¥ : 2014/7/19
//�ۼ��� : ��ȭ��

package dto;

/**
 * �湮��û�� ���̺� ������ ������ Ŭ����
 * @author ȭ��
 *
 */
public class VisitRequestersInfoDTO 
{
	private String houseOwnerCode;
	private String touristCode;
	private String requestState;
	private String touristName;
	private String touristEmail;
	private String touristGender;
	private String touristJob;
	private String touristArrivalDate;
	private String touristDepartureDate;
	private String touristSelfIntroduction;
	private int touristCompanionNum;
	private String touristReliability;
	
	/**
	 * �⺻������
	 */
	public VisitRequestersInfoDTO()
	{
		this("", "", "", "", "", "", "", "", "", "", 0, "");
	}

	/**
	 * �������ڸ� �޴� ������
	 * @param houseOwnerCode �������ڵ�
	 * @param touristCode ���ఴ�ڵ�
	 * @param requestState �������
	 * @param touristName ���ఴ�̸�
	 * @param touristEmail ���ఴ�̸���
	 * @param touristGender ���ఴ ��
	 * @param touristJob ���ళ�줡��
	 * @param touristArrivalDate ���ఴ ����������
	 * @param touristDepartureDate ���ఴ ������¥
	 * @param touristSelfIntroduction ���ఴ �ڱ�Ұ�
	 * @param touristCompanionNum ���ఴ �����ڼ�
	 * @param touristReliability ���ఴ �ſ뵵
	 */
	public VisitRequestersInfoDTO(String houseOwnerCode, String touristCode, String requestState, String touristName, String touristEmail, String touristGender, String touristJob, String touristArrivalDate, String touristDepartureDate, String touristSelfIntroduction, int touristCompanionNum, String touristReliability) 
	{ 
		this.houseOwnerCode = houseOwnerCode;
		this.touristCode = touristCode;
		this.requestState = requestState;
		this.touristName = touristName;
		this.touristEmail = touristEmail;
		this.touristGender = touristGender;
		this.touristJob = touristJob;
		this.touristArrivalDate = touristArrivalDate;
		this.touristDepartureDate = touristDepartureDate;
		this.touristSelfIntroduction = touristSelfIntroduction;
		this.touristCompanionNum = touristCompanionNum;
		this.touristReliability = touristReliability;
	}

	/**
	 * ������ �ڵ� �����Ѵ�
	 * @return
	 */
	public String getHouseOwnerCode() {
		return houseOwnerCode;
	}

	/**
	 * ������ �ڵ带 �����Ѵ�
	 * @param houseOwnerCode
	 */
	public void setHouseOwnerCode(String houseOwnerCode) {
		this.houseOwnerCode = houseOwnerCode;
	}

	/**
	 * ���ఴ������ �����Ѵ�
	 * @return
	 */
	public String getTouristCode() {
		return touristCode;
	}

	/**
	 * ���ఴ������ �����Ѵ�
	 * @param touristCode
	 */
	public void setTouristCode(String touristCode) {
		this.touristCode = touristCode;
	}

	/**
	 * ������¸� �����Ѵ�
	 * @return
	 */
	public String getRequestState() {
		return requestState;
	}

	/**
	 * ������¸� �����Ѵ�
	 * @param requestState
	 */
	public void setRequestState(String requestState) {
		this.requestState = requestState;
	}

	/**
	 * ���ఴ �̸��� �����Ѵ�
	 * @return
	 */
	public String getTouristName() {
		return touristName;
	}

	/**
	 * ���ఴ �̸��� �����Ѵ�
	 * @param touristName
	 */
	public void setTouristName(String touristName) {
		this.touristName = touristName;
	}

	/**
	 * ���ఴ �̸����� �����Ѵ�
	 * @return
	 */
	public String getTouristEmail() {
		return touristEmail;
	}

	/**
	 * ���ఴ�̸����� �����Ѵ�
	 * @param touristEmail
	 */
	public void setTouristEmail(String touristEmail) {
		this.touristEmail = touristEmail;
	}

	/**
	 * ���ఴ ���� �����Ѵ�
	 * @return
	 */
	public String getTouristGender() {
		return touristGender;
	}

	/**
	 * ���ఴ ���� �����Ѵ�
	 * @param touristGender
	 */
	public void setTouristGender(String touristGender) {
		this.touristGender = touristGender;
	}

	/**
	 * ���ఴ ������ �����Ѵ�
	 * @return
	 */
	public String getTouristJob() {
		return touristJob;
	}

	/**
	 * ���ఴ ������ �����Ѵ�
	 * @param touristJob
	 */
	public void setTouristJob(String touristJob) {
		this.touristJob = touristJob;
	}

	/**
	 * ���ఴ ������������ �����Ѵ�
	 * @return
	 */
	public String getTouristArrivalDate() {
		return touristArrivalDate;
	}

	/**
	 * ���ఴ ������������ �����Ѵ�
	 * @param touristArrivalDate
	 */
	public void setTouristArrivalDate(String touristArrivalDate) {
		this.touristArrivalDate = touristArrivalDate;
	}

	/**
	 * ���ఴ ������ ���� ����ҿ������� �����Ѵ�
	 * @return
	 */
	public String getTouristDepartureDate() {
		return touristDepartureDate;
	}

	/**
	 * ���ఴ ������ �� ��߿������� �����Ѵ�
	 * @param touristDepartureDate
	 */
	public void setTouristDepartureDate(String touristDepartureDate) {
		this.touristDepartureDate = touristDepartureDate;
	}

	/**
	 * ���ఴ�ڱ�Ұ��� �����Ѵ�
	 * @return
	 */
	public String getTouristSelfIntroduction() {
		return touristSelfIntroduction;
	}

	/**
	 * ���ఴ�ڱ�Ұ��� �����Ѵ�
	 * @param touristSelfIntroduction
	 */
	public void setTouristSelfIntroduction(String touristSelfIntroduction) {
		this.touristSelfIntroduction = touristSelfIntroduction;
	}

	/**
	 * �����ڼ��� �����Ѵ�
	 * @return
	 */
	public int getTouristCompanionNum() {
		return touristCompanionNum;
	}

	/**
	 * �����ڼ��� �����Ѵ�
	 * @param touristCompanionNum
	 */
	public void setTouristCompanionNum(int touristCompanionNum) {
		this.touristCompanionNum = touristCompanionNum;
	}

	/**
	 * ���ఴ �ŷڵ��� �����Ѵ�
	 * @return
	 */
	public String getTouristReliability() {
		return touristReliability;
	}

	/** 
	 * ���ఴ�ŷڵ��� �����Ѵ�
	 * @param touristReliability
	 */
	public void setTouristReliability(String touristReliability) {
		this.touristReliability = touristReliability;
	}
	
	

	
}
