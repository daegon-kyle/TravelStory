//�ۼ���¥ : 2014/7/19
//�ۼ��� : ��ȭ��

package dto;

/**
 * ��ī�װ� ���̺� ������ ������ Ŭ����
 * @author ȭ��
 *
 */
public class SubCategoryDTO 
{
	private String subCategoryCode;
	private String mainCategoryCode;
	private String subCategoryName;
	
	/**
	 * �λ�����
	 */
	public SubCategoryDTO()
	{
		this("","","");
	}
	
	/**
	 * �������ڸ� �޴� ������
	 * @param subCategoryCode ��ī�װ��ڵ�
	 * @param mainCategoryCode ��ī�װ��ڵ�
	 * @param subCategoryName ��ī�װ���
	 */
	public SubCategoryDTO(String subCategoryCode, String mainCategoryCode,
			String subCategoryName) { 
		this.subCategoryCode = subCategoryCode;
		this.mainCategoryCode = mainCategoryCode;
		this.subCategoryName = subCategoryName;
	}
	/**
	 * ��ī�װ��ڵ带 �����Ѵ�
	 * @return
	 */
	public String getSubCategoryCode() {
		return subCategoryCode;
	}
	/**
	 * ��ī�װ��ڵ��� �����Ѵ�
	 * @param subCategoryCode
	 */
	public void setSubCategoryCode(String subCategoryCode) {
		this.subCategoryCode = subCategoryCode;
	}
	/**
	 * ��ī�װ����� �����Ѵ�
	 * @return
	 */
	public String getMainCategoryCode() {
		return mainCategoryCode;
	}
	/**
	 * ��ī�װ����� �����Ѵ�
	 * @param mainCategoryCode
	 */
	public void setMainCategoryCode(String mainCategoryCode) {
		this.mainCategoryCode = mainCategoryCode;
	}
	/**
	 * ��ī�װ����� �����Ѵ�
	 * @return
	 */
	public String getSubCategoryName() {
		return subCategoryName;
	}
	/**
	 * ��ī�װ����� �����Ѵ�
	 * @param subCategoryName
	 */
	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}
	
	
}
