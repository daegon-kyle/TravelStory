//�ۼ���¥ : 2014/7/20
//�ۼ��� : ��ȭ��


package dto;

/**
 * ����α׿� ����� ���� ���̺� ������ ������ Ŭ����
 * @author ȭ��
 *
 */
public class MyWidgetDTO 
{
	private String memberCode;
	private String blogCode;
	private String usedWidgetCode;
	private String myWidgetCode;
	private String myWidetName;
	
	/**
	 * �⺻������
	 */
	public MyWidgetDTO()
	{
		this("","","","","");
	}

	/**
	 * �������ڸ� �޴� ������
	 * @param memberCode ȸ���ڵ�
	 * @param blogCode ��α��ڵ�
	 * @param usedWidgetCode ���������ڵ�
	 * @param myWidgetCode ������� �����ڵ�
	 * @param myWidetName ������� ������
	 */
	public MyWidgetDTO(String memberCode, String blogCode,
			String usedWidgetCode, String myWidgetCode, String myWidetName) { 
		this.memberCode = memberCode;
		this.blogCode = blogCode;
		this.usedWidgetCode = usedWidgetCode;
		this.myWidgetCode = myWidgetCode;
		this.myWidetName = myWidetName;
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
	 * ��α��ڵ带 �����Ѵ�
	 * @return
	 */
	public String getBlogCode() {
		return blogCode;
	}

	/**
	 * ��α��ڵ带 �����Ѵ�
	 * @param blogCode
	 */
	public void setBlogCode(String blogCode) {
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
	 * ����� �����ڵ带 ���ä����Ѵ�
	 * @return
	 */
	public String getMyWidgetCode() {
		return myWidgetCode;
	}

	/**
	 * ����� �����ڵ带 �����Ѵ�
	 * @param myWidgetCode
	 */
	public void setMyWidgetCode(String myWidgetCode) {
		this.myWidgetCode = myWidgetCode;
	}

	/**
	 * ������������� �����Ѵ�
	 * @return
	 */
	public String getMyWidetName() {
		return myWidetName;
	}

	/**
	 * ������������� �����Ѵ�
	 * @param myWidetName
	 */
	public void setMyWidetName(String myWidetName) {
		this.myWidetName = myWidetName;
	}

	@Override
	public String toString() {
		return "MyWidgetDTO [memberCode=" + memberCode + ", blogCode="
				+ blogCode + ", usedWidgetCode=" + usedWidgetCode
				+ ", myWidgetCode=" + myWidgetCode + ", myWidetName="
				+ myWidetName + "]";
	}
	
	

}
