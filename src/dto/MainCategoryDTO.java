//작성날짜 : 2014/7/19
//작성자 : 이화섭

package dto;

/**
 * 대카테고리 테이블 정보를 저장할 클래스
 * @author 화섭
 *
 */
public class MainCategoryDTO 
{
	private String mainCategoryCode;
	private String blogCode;
	private String mainCategoryName;
	
	/**
	 * 기본생성자
	 */
	public MainCategoryDTO()
	{
		this("","","");
	}
	
	/**
	 * 전달인자를 받는 생성자
	 * @param mainCategoryCode 대카테고리코드
	 * @param blogCode 블로그코드
	 * @param mainCategoryName 대카테고리명
	 */
	public MainCategoryDTO(String mainCategoryCode, String blogCode,
			String mainCategoryName) { 
		this.mainCategoryCode = mainCategoryCode;
		this.blogCode = blogCode;
		this.mainCategoryName = mainCategoryName;
	}
	/**
	 * 대카테고리코드를 리턴한다
	 * @return
	 */
	public String getMainCategoryCode() {
		return mainCategoryCode;
	}
	/**
	 * 대카테고리코드를 설정한다
	 * @param mainCategoryCode
	 */
	public void setMainCategoryCode(String mainCategoryCode) {
		this.mainCategoryCode = mainCategoryCode;
	}
	/**
	 * 블로그코드를 리턴한다
	 * @return
	 */
	public String getBlogCode() {
		return blogCode;
	}
	/**
	 * 블로그코드를 설정한다
	 * @param blogCode
	 */
	public void setBlogCode(String blogCode) {
		this.blogCode = blogCode;
	}
	/**
	 * 대카테고리명을 리턴한다
	 * @return
	 */
	public String getMainCategoryName() {
		return mainCategoryName;
	}
	/**
	 * 대카테고리명을 설정한다
	 * @param mainCategoryName
	 */
	public void setMainCategoryName(String mainCategoryName) {
		this.mainCategoryName = mainCategoryName;
	}
	
	

}
