package model;

import java.io.Serializable;
/**
 * ���������� ĸ��ȭ�ϴ� Ŭ���� 
 * @author ����
 *
 */
public class WidgetInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3599512782489194111L;
	/**
	 * ������ �ο��Ǵ� �����ڵ� 
	 */
	private String widgetCode;
	/**
	 * �����̸� 
	 */
	private String widgetName;
	/**
	 * ������ �����ø����ڵ� 
	 */
	private String postingPurposeCode;
	/**
	 * null������ 
	 */
	public WidgetInfo() {
		this("","","");
	}
	/**
	 * �����ε� ������ 
	 * @param widgetCode
	 * @param widgetName
	 * @param postingPurposeCode
	 */
	public WidgetInfo(String widgetCode, String widgetName,
			String postingPurposeCode) {
		this.widgetCode = widgetCode;
		this.widgetName = widgetName;
		this.postingPurposeCode = postingPurposeCode;
	}
	/**
	 * �����ڵ带 ��ȯ�Ѵ�. 
	 * @return �����ڵ� 
	 */
	public String getWidgetCode() {
		return widgetCode;
	}
	/**
	 * �����ڵ带 �����Ѵ�. 
	 * @param widgetCode �����ڵ� 
	 */
	public void setWidgetCode(String widgetCode) {
		this.widgetCode = widgetCode;
	}
	/**
	 * �����̸��� ��ȯ�Ѵ�. 
	 * @return �����̸� 
	 */
	public String getWidgetName() {
		return widgetName;
	}
	/**
	 * �����̸��� �����Ѵ�. 
	 * @param widgetName �����̸� 
	 */
	public void setWidgetName(String widgetName) {
		this.widgetName = widgetName;
	}
	/**
	 * �����ø����ڵ带 ��ȯ�Ѵ�. 
	 * @return �����ø����ڵ�
	 */
	public String getPostingPurposeCode() {
		return postingPurposeCode;
	}
	/**
	 * �����ø����ڵ带 �����Ѵ�. 
	 * @param postingPurposeCode �����ø����ڵ�
	 */
	public void setPostingPurposeCode(String postingPurposeCode) {
		this.postingPurposeCode = postingPurposeCode;
	}
	
	
	
}
