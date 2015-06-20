//작성날짜 : 2014/7/19
//작성자 : 이화섭

package dto;

/**
 * 레이아웃 테이블 정보를 저장할 클래스
 * @author 화섭
 *
 */
public class LayoutDTO 
{
	private String layoutCode;
	private String layoutName;
	
	/**
	 * 기본 생성자
	 */
	public LayoutDTO()
	{
		this("","");
	}

	/**
	 * 전달인자를 받는 생성자
	 * @param layoutCode
	 * @param layoutName
	 */
	public LayoutDTO(String layoutCode, String layoutName) { 
		this.layoutCode = layoutCode;
		this.layoutName = layoutName;
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
	 * 레이아웃명을 리턴한다
	 * @return
	 */
	public String getLayoutName() {
		return layoutName;
	}

	/**
	 * 레이아웃명을 설정한다
	 * @param layoutName
	 */
	public void setLayoutName(String layoutName) {
		this.layoutName = layoutName;
	}
	
	

}
