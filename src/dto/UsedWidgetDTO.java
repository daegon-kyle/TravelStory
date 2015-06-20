//작성날짜 : 2014/7/19
//작성자 : 이화섭

package dto;

/**
 * 사용된위젯 테이블 정보를 저장할 클래스
 * @author 화섭
 *
 */
public class UsedWidgetDTO 
{
	private String usedWidgetCode;
	private String widgetCode;
	private String blogCode;
	
	/**
	 * 기본생성자
	 */
	public UsedWidgetDTO()
	{
		this("","","");
	}
	
	/**
	 * 전달인자를 받는 생성자
	 * @param usedWidgetCode 사용된위젯코드
	 * @param widgetCode 위젯코드
	 * @param blogCode 블로그코드
	 */
	public UsedWidgetDTO(String usedWidgetCode, String widgetCode, String blogCode) 
	{ 
		this.usedWidgetCode = usedWidgetCode;
		this.widgetCode = widgetCode;
		this.blogCode = blogCode;
	}

	/**
	 * 사용된위젯코드를 리턴한다
	 * @return
	 */
	public String getUsedWidgetCode() {
		return usedWidgetCode;
	}

	/**
	 * 사용된위젯코드를 설정한다
	 * @param usedWidgetCode
	 */
	public void setUsedWidgetCode(String usedWidgetCode) {
		this.usedWidgetCode = usedWidgetCode;
	}

	/**
	 * 위젯코드를 리턴한다
	 * @return
	 */
	public String getWidgetCode() {
		return widgetCode;
	}

	/**
	 * 위젯코드를 설정한다
	 * @param widgetCode
	 */
	public void setWidgetCode(String widgetCode) {
		this.widgetCode = widgetCode;
	}

	/**
	 * 블로그코드를 리턴한다
	 * @return
	 */
	public String getBlogCode() {
		return blogCode;
	}

	/**
	 * 블로그코드를 설정하다
	 * @param blogCode
	 */
	public void setBlogCode(String blogCode) {
		this.blogCode = blogCode;
	}
	
	
	
}
