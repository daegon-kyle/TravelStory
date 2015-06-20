//�ۼ���¥ : 2014/7/19
//�ۼ��� : ��ȭ��

package dto;

/**
 * �������� ���̺� ������ ������ Ŭ����
 * @author ȭ��
 *
 */
public class UsedWidgetDTO 
{
	private String usedWidgetCode;
	private String widgetCode;
	private String blogCode;
	
	/**
	 * �⺻������
	 */
	public UsedWidgetDTO()
	{
		this("","","");
	}
	
	/**
	 * �������ڸ� �޴� ������
	 * @param usedWidgetCode ���������ڵ�
	 * @param widgetCode �����ڵ�
	 * @param blogCode ��α��ڵ�
	 */
	public UsedWidgetDTO(String usedWidgetCode, String widgetCode, String blogCode) 
	{ 
		this.usedWidgetCode = usedWidgetCode;
		this.widgetCode = widgetCode;
		this.blogCode = blogCode;
	}

	/**
	 * ���������ڵ带 �����Ѵ�
	 * @return
	 */
	public String getUsedWidgetCode() {
		return usedWidgetCode;
	}

	/**
	 * ���������ڵ带 �����Ѵ�
	 * @param usedWidgetCode
	 */
	public void setUsedWidgetCode(String usedWidgetCode) {
		this.usedWidgetCode = usedWidgetCode;
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
	 * ��α��ڵ带 �����Ѵ�
	 * @return
	 */
	public String getBlogCode() {
		return blogCode;
	}

	/**
	 * ��α��ڵ带 �����ϴ�
	 * @param blogCode
	 */
	public void setBlogCode(String blogCode) {
		this.blogCode = blogCode;
	}
	
	
	
}
