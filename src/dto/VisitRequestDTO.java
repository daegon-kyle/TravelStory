//�ۼ���¥ : 2014/7/20
//�ۼ��� : ��ȭ��

package dto;

/**
 * �湮��û ���̺� ������ ������ Ŭ����
 * @author ȭ��
 *
 */
public class VisitRequestDTO 
{
	private String visitRequestCode;
	private String houseOwnerCode;
	private String touristCode;
	private String requestState;
	
	/**
	 * �λ�����
	 */
	public VisitRequestDTO()
	{
		this("","","","");
	}
	
	/**
	 * �������ڸ� �޴� ������
	 * @param visitRequestCode �湮��û�ڵ�
	 * @param houseOwnerCode �������ڵ�
	 * @param touristCode ���ఴ�ڵ�
	 * @param requestState �������
	 */
	public VisitRequestDTO(String visitRequestCode, String houseOwnerCode,
			String touristCode, String requestState) {
		this.visitRequestCode = visitRequestCode;
		this.houseOwnerCode = houseOwnerCode;
		this.touristCode = touristCode;
		this.requestState = requestState;
	}
	public String getVisitRequestCode() {
		return visitRequestCode;
	}
	/**
	 * �湮��û�ڵ带 �����Ѵ�
	 * @param visitRequestCode
	 */
	public void setVisitRequestCode(String visitRequestCode) {
		this.visitRequestCode = visitRequestCode;
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
	
	
}
