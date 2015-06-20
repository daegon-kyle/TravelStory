//�ۼ���¥ : 2014/7/19
//�ۼ��� : ��ȭ��

package dto;

/**
 * ���̾ƿ� ���̺� ������ ������ Ŭ����
 * @author ȭ��
 *
 */
public class LayoutDTO 
{
	private String layoutCode;
	private String layoutName;
	
	/**
	 * �⺻ ������
	 */
	public LayoutDTO()
	{
		this("","");
	}

	/**
	 * �������ڸ� �޴� ������
	 * @param layoutCode
	 * @param layoutName
	 */
	public LayoutDTO(String layoutCode, String layoutName) { 
		this.layoutCode = layoutCode;
		this.layoutName = layoutName;
	}

	/**
	 * ���̾ƿ��ڵ带 �����Ѵ�
	 * @return
	 */
	public String getLayoutCode() {
		return layoutCode;
	}

	/**
	 * ���̾ƿ��ڵ带 �����Ѵ�
	 * @param layoutCode
	 */
	public void setLayoutCode(String layoutCode) {
		this.layoutCode = layoutCode;
	}

	/**
	 * ���̾ƿ����� �����Ѵ�
	 * @return
	 */
	public String getLayoutName() {
		return layoutName;
	}

	/**
	 * ���̾ƿ����� �����Ѵ�
	 * @param layoutName
	 */
	public void setLayoutName(String layoutName) {
		this.layoutName = layoutName;
	}
	
	

}
