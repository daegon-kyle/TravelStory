package model;

import java.io.Serializable;
/**
 * �������� ���� �湮��û������ ���� Ŭ���� 
 * @author ����
 *
 */
public class VisitRequestInfoForOwner implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7249173868283201734L;
	/**
	 * ���ఴ �ʼ� �Է»������� 
	 */
	private TouristEssentialInfo toruistEssentialInfo;
	/**
	 * ��û���� 
	 * ���� , ����, ��� 
	 */
	private String requestState;
	/**
	 *  null ������ 
	 */
	public VisitRequestInfoForOwner() {
		this(new TouristEssentialInfo(), "");
	}
	/**
	 * �����ε� ������ 
	 * @param toruistEssentialInfo
	 * @param requestState
	 */
	public VisitRequestInfoForOwner(TouristEssentialInfo toruistEssentialInfo,
			String requestState) {
		super();
		this.toruistEssentialInfo = toruistEssentialInfo;
		this.requestState = requestState;
	}
	/**
	 * ���ఴ �ʼ� �Է������� ��ȯ�Ѵ�.
	 * @return ���ఴ �ʼ� �Է�����
	 */
	public TouristEssentialInfo getToruistEssentialInfo() {
		return toruistEssentialInfo;
	}
	/**
	 * ���ఴ �ʼ��Է� ������ �����Ѵ�. 
	 * @param toruistEssentialInfo ���ఴ �ʼ��Է� ���� 
	 */
	public void setToruistEssentialInfo(TouristEssentialInfo toruistEssentialInfo) {
		this.toruistEssentialInfo = toruistEssentialInfo;
	}
	/**
	 * ��û���¸� ��ȯ�Ѵ�. 
	 * @return ��û���� 
	 */
	public String getRequestState() {
		return requestState;
	}
	/**
	 * ��û���¸� �����Ѵ�. 
	 * @param requestState ��û���� 
	 */
	public void setRequestState(String requestState) {
		this.requestState = requestState;
	}
	
	
}
