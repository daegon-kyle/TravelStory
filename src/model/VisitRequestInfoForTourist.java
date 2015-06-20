package model;

import java.io.Serializable;
/**
 * ���ఴ�� ���� �湮��û ������ ĸ��ȭ �ϰ� �ִ� Ŭ���� 
 * @author ����
 *
 */
public class VisitRequestInfoForTourist implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5512965215554130433L;
	/**
	 * ������ �ʼ� �Է»����� ĸ��ȭ�ϰ� �ִ� ��ü 
	 */
	private HouseOwnerEssentialInfo houseOwnerEssentialInfo;
	/**
	 * �湮��û ���� 
	 * ����, ���, ����
	 */
	private String requestState;
	/**
	 * null������ 
	 */
	public VisitRequestInfoForTourist() {
		this(new HouseOwnerEssentialInfo(), "");
	}
	/**
	 * �����ε� ������ 
	 * @param houseOwnerEssentialInfo
	 * @param requestState
	 */
	public VisitRequestInfoForTourist(
			HouseOwnerEssentialInfo houseOwnerEssentialInfo, String requestState) {
		this.houseOwnerEssentialInfo = houseOwnerEssentialInfo;
		this.requestState = requestState;
	}
	/**
	 * �������ʼ��Է������� ��ȯ�Ѵ�.
	 * @return �������ʼ��Է�����
	 */
	public HouseOwnerEssentialInfo getHouseOwnerEssentialInfo() {
		return houseOwnerEssentialInfo;
	}
	/**
	 * �������ʼ��Է������� �����Ѵ�.
	 * @param houseOwnerEssentialInfo �������ʼ��Է�����
	 */
	public void setHouseOwnerEssentialInfo(
			HouseOwnerEssentialInfo houseOwnerEssentialInfo) {
		this.houseOwnerEssentialInfo = houseOwnerEssentialInfo;
	}
	/**
	 * �湮��û���¸� ��ȯ�Ѵ�. 
	 * @return �湮��û���� 
	 */
	public String getRequestState() {
		return requestState;
	}
	/**
	 * �湮��û ���¸� �����Ѵ�. 
	 * @param requestState �湮��û ���� 
	 */
	public void setRequestState(String requestState) {
		this.requestState = requestState;
	}
	
	
}
