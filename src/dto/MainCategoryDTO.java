//�ۼ���¥ : 2014/7/19
//�ۼ��� : ��ȭ��

package dto;

/**
 * ��ī�װ� ���̺� ������ ������ Ŭ����
 * @author ȭ��
 *
 */
public class MainCategoryDTO 
{
	private String mainCategoryCode;
	private String blogCode;
	private String mainCategoryName;
	
	/**
	 * �⺻������
	 */
	public MainCategoryDTO()
	{
		this("","","");
	}
	
	/**
	 * �������ڸ� �޴� ������
	 * @param mainCategoryCode ��ī�װ��ڵ�
	 * @param blogCode ��α��ڵ�
	 * @param mainCategoryName ��ī�װ���
	 */
	public MainCategoryDTO(String mainCategoryCode, String blogCode,
			String mainCategoryName) { 
		this.mainCategoryCode = mainCategoryCode;
		this.blogCode = blogCode;
		this.mainCategoryName = mainCategoryName;
	}
	/**
	 * ��ī�װ��ڵ带 �����Ѵ�
	 * @return
	 */
	public String getMainCategoryCode() {
		return mainCategoryCode;
	}
	/**
	 * ��ī�װ��ڵ带 �����Ѵ�
	 * @param mainCategoryCode
	 */
	public void setMainCategoryCode(String mainCategoryCode) {
		this.mainCategoryCode = mainCategoryCode;
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
	 * ��ī�װ����� �����Ѵ�
	 * @return
	 */
	public String getMainCategoryName() {
		return mainCategoryName;
	}
	/**
	 * ��ī�װ����� �����Ѵ�
	 * @param mainCategoryName
	 */
	public void setMainCategoryName(String mainCategoryName) {
		this.mainCategoryName = mainCategoryName;
	}
	
	

}
