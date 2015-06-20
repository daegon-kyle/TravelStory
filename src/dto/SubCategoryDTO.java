//작성날짜 : 2014/7/19
//작성자 : 이화섭

package dto;

/**
 * 소카테고리 테이블 정보를 저장할 클래스
 * @author 화섭
 *
 */
public class SubCategoryDTO 
{
	private String subCategoryCode;
	private String mainCategoryCode;
	private String subCategoryName;
	
	/**
	 * 널생성자
	 */
	public SubCategoryDTO()
	{
		this("","","");
	}
	
	/**
	 * 전달인자를 받는 생성자
	 * @param subCategoryCode 소카테고리코드
	 * @param mainCategoryCode 대카테고리코드
	 * @param subCategoryName 소카테고리명
	 */
	public SubCategoryDTO(String subCategoryCode, String mainCategoryCode,
			String subCategoryName) { 
		this.subCategoryCode = subCategoryCode;
		this.mainCategoryCode = mainCategoryCode;
		this.subCategoryName = subCategoryName;
	}
	/**
	 * 소카테고리코드를 리턴한다
	 * @return
	 */
	public String getSubCategoryCode() {
		return subCategoryCode;
	}
	/**
	 * 소카테고리코드을 설정한다
	 * @param subCategoryCode
	 */
	public void setSubCategoryCode(String subCategoryCode) {
		this.subCategoryCode = subCategoryCode;
	}
	/**
	 * 대카테고리명을 리턴한다
	 * @return
	 */
	public String getMainCategoryCode() {
		return mainCategoryCode;
	}
	/**
	 * 대카테고리명을 설정한다
	 * @param mainCategoryCode
	 */
	public void setMainCategoryCode(String mainCategoryCode) {
		this.mainCategoryCode = mainCategoryCode;
	}
	/**
	 * 소카테고리명을 리턴한다
	 * @return
	 */
	public String getSubCategoryName() {
		return subCategoryName;
	}
	/**
	 * 소카테고리명을 설정한다
	 * @param subCategoryName
	 */
	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}
	
	
}
