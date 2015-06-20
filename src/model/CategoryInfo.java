package model;

/**
 * 카테고리 정보를 저장하기 위한 클래스
 * <br>BlogCustomizingServlet에서 사용하는 클래스
 * @author 대곤
 *
 */
public class CategoryInfo implements  java.io.Serializable{
	private static final long serialVersionUID = -5780555357283306865L;
	/**
	 * 카테고리 코드(수정,추가에 따라 달라짐)
	 */
	private String categoryCode;
	/**
	 * 카테고리 명(수정,추가에 따라 달라짐)
	 */
	private String categoryName;
	/**
	 * 카테고리 깊이
	 */
	private int categoryDepth;
	/**
	 * 부모 카테고리 코드
	 */
	private String parentCategoryCode;
	/**
	 * 널생성자
	 */
	public CategoryInfo() {
		this("","",0,"");
	}
	public CategoryInfo(String categoryCode, String categoryName) {
		this.categoryCode = categoryCode;
		this.categoryName = categoryName;
	}
	/**
	 * 기본생성자
	 * @param categoryCode 카테고리 코드(수정,추가에 따라 달라짐)
	 * @param categoryName 카테고리 명(수정,추가에 따라 달라짐)
	 * @param categoryDepth 카테고리 깊이
	 * @param parentCategoryCode 부모 카테고리 코드
	 */
	public CategoryInfo(String categoryCode, String categoryName,
			int categoryDepth, String parentCategoryCode) {
		this.categoryCode = categoryCode;
		this.categoryName = categoryName;
		this.categoryDepth = categoryDepth;
		this.parentCategoryCode = parentCategoryCode;
	}
	/**
	 * 카테고리코드 반환
	 * @return 카테고리 코드(수정,추가에 따라 달라짐)
	 */
	public String getCategoryCode() {
		return categoryCode;
	}
	/**
	 * 카테고리 코드 설정
	 * @param categoryCode 카테고리 코드(수정,추가에 따라 달라짐)
	 */
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	/**
	 * 카테고리 명 반환
	 * @return 카테고리 명(수정,추가에 따라 달라짐)
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * 카테고리명 설정
	 * @param categoryName 카테고리 명(수정,추가에 따라 달라짐)
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	/**
	 * 카테고리 깊이 반환
	 * @return 카테고리 깊이
	 */
	public int getCategoryDepth() {
		return categoryDepth;
	}
	/**
	 * 카테고리 깊이 설정
	 * @param categoryDepth 카테고리 깊이
	 */
	public void setCategoryDepth(int categoryDepth) {
		this.categoryDepth = categoryDepth;
	}
	/**
	 * 부모카테고리코드 반환
	 * @return 부모카테고리
	 */
	public String getParentCategoryCode() {
		return parentCategoryCode;
	}
	/**
	 * 부모카테고리 설정
	 * @param parentCategoryCode 부모카테고리
	 */
	public void setParentCategoryCode(String parentCategoryCode) {
		this.parentCategoryCode = parentCategoryCode;
	}
	
	
}
