//작성날짜 : 2014/7/19
//작성자 : 이화섭

package dto;

/**
 * 블로그 테이블 모델 클래스
 * @author 화섭
 *
 */
public class BlogDTO 
{
	private String blogCode;
	private String memberCode;
	private String layoutCode;
	private String fontName;
	private String bgColorCode;
	
	/**
	 * 블로그 기본 생성자
	 */
	public BlogDTO() {
		this("","","","","");
	}
	
	/**
	 * 전달인자를 받는 블로그 생성자
	 * @param blogCode 블로그 고유 식별코드
	 * @param memberCode 회원 고유 식별코드
	 * @param layoutCode 레이아웃 고유 식별코드
	 * @param fontName 폰트명
	 * @param bgColorCode 배경색상
	 */
	public BlogDTO(String blogCode, String memberCode, String layoutCode, String fontName, String bgColorCode) 
	{ 
		this.blogCode = blogCode;
		this.memberCode = memberCode;
		this.layoutCode = layoutCode;
		this.fontName = fontName;
		this.bgColorCode = bgColorCode;
	}
	
	/**
	 * 블로그 코드를 리턴받는다
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
	 * 회원코드를 리턴한다
	 * @return
	 */
	public String getMemberCode() {
		return memberCode;
	}
	/**
	 * 회원코드를 설정한다
	 * @param memberCode
	 */
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	/**
	 * 레이아웃코드를 리턴한다
	 * @return
	 */
	public String getLayoutCode() {
		return layoutCode;
	}
	/**
	 * 레이아웃코드를 설정한다
	 * @param layoutCode
	 */
	public void setLayoutCode(String layoutCode) {
		this.layoutCode = layoutCode;
	}
	/**
	 * 폰트명을 리턴한다
	 * @return
	 */
	public String getFontName() {
		return fontName;
	}
	/**
	 * 폰트명을 설정한다
	 * @param fontName
	 */
	public void setFontName(String fontName) {
		this.fontName = fontName;
	}
	/**
	 * 배경색을 리턴한다
	 * @return
	 */
	public String getBgColorCode() {
		return bgColorCode;
	}
	/**
	 * 배경색을 설정한다
	 * @param bgColorCode
	 */
	public void setBgColorCode(String bgColorCode) {
		this.bgColorCode = bgColorCode;
	}

}
