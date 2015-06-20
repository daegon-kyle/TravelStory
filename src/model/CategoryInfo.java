package model;

/**
 * ī�װ� ������ �����ϱ� ���� Ŭ����
 * <br>BlogCustomizingServlet���� ����ϴ� Ŭ����
 * @author ���
 *
 */
public class CategoryInfo implements  java.io.Serializable{
	private static final long serialVersionUID = -5780555357283306865L;
	/**
	 * ī�װ� �ڵ�(����,�߰��� ���� �޶���)
	 */
	private String categoryCode;
	/**
	 * ī�װ� ��(����,�߰��� ���� �޶���)
	 */
	private String categoryName;
	/**
	 * ī�װ� ����
	 */
	private int categoryDepth;
	/**
	 * �θ� ī�װ� �ڵ�
	 */
	private String parentCategoryCode;
	/**
	 * �λ�����
	 */
	public CategoryInfo() {
		this("","",0,"");
	}
	public CategoryInfo(String categoryCode, String categoryName) {
		this.categoryCode = categoryCode;
		this.categoryName = categoryName;
	}
	/**
	 * �⺻������
	 * @param categoryCode ī�װ� �ڵ�(����,�߰��� ���� �޶���)
	 * @param categoryName ī�װ� ��(����,�߰��� ���� �޶���)
	 * @param categoryDepth ī�װ� ����
	 * @param parentCategoryCode �θ� ī�װ� �ڵ�
	 */
	public CategoryInfo(String categoryCode, String categoryName,
			int categoryDepth, String parentCategoryCode) {
		this.categoryCode = categoryCode;
		this.categoryName = categoryName;
		this.categoryDepth = categoryDepth;
		this.parentCategoryCode = parentCategoryCode;
	}
	/**
	 * ī�װ��ڵ� ��ȯ
	 * @return ī�װ� �ڵ�(����,�߰��� ���� �޶���)
	 */
	public String getCategoryCode() {
		return categoryCode;
	}
	/**
	 * ī�װ� �ڵ� ����
	 * @param categoryCode ī�װ� �ڵ�(����,�߰��� ���� �޶���)
	 */
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	/**
	 * ī�װ� �� ��ȯ
	 * @return ī�װ� ��(����,�߰��� ���� �޶���)
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * ī�װ��� ����
	 * @param categoryName ī�װ� ��(����,�߰��� ���� �޶���)
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	/**
	 * ī�װ� ���� ��ȯ
	 * @return ī�װ� ����
	 */
	public int getCategoryDepth() {
		return categoryDepth;
	}
	/**
	 * ī�װ� ���� ����
	 * @param categoryDepth ī�װ� ����
	 */
	public void setCategoryDepth(int categoryDepth) {
		this.categoryDepth = categoryDepth;
	}
	/**
	 * �θ�ī�װ��ڵ� ��ȯ
	 * @return �θ�ī�װ�
	 */
	public String getParentCategoryCode() {
		return parentCategoryCode;
	}
	/**
	 * �θ�ī�װ� ����
	 * @param parentCategoryCode �θ�ī�װ�
	 */
	public void setParentCategoryCode(String parentCategoryCode) {
		this.parentCategoryCode = parentCategoryCode;
	}
	
	
}
