//�ۼ���¥ : 2014/7/19
//�ۼ��� : ��ȭ��

package dto;

/**
 * ���� ���̺� ������ ������ Ŭ����
 * @author ȭ��
 *
 */
public class WidgetDTO 
{
	private String widgetCode;
	private String widgetName;
	
	/**
	 * �⺻������
	 */
	public WidgetDTO()
	{
		this("","");
	}
	/**
	 * �������ڸ� �޴� ������
	 * @param widgetCode �����ڵ�
	 * @param widgetName ������
	 */
	public WidgetDTO(String widgetCode, String widgetName) { 
		this.widgetCode = widgetCode;
		this.widgetName = widgetName;
	}
	/**
	 * �����ڵ带 �����Ѵ�
	 * @return
	 */
	public String getWidgetCode() {
		return widgetCode;
	}

	/**
	 * �����ڵ带 �����Ѵ�
	 * @param widgetCode
	 */
	public void setWidgetCode(String widgetCode) {
		this.widgetCode = widgetCode;
	}

	/**
	 * �������� �����Ѵ�
	 * @return
	 */
	public String getWidgetName() {
		return widgetName;
	}

	/**
	 * �������� �����Ѵ�
	 * @param widgetName
	 */
	public void setWidgetName(String widgetName) {
		this.widgetName = widgetName;
	}
	
	

}
