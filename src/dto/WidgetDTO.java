//작성날짜 : 2014/7/19
//작성자 : 이화섭

package dto;

/**
 * 위젯 테이블 정보를 저장할 클래스
 * @author 화섭
 *
 */
public class WidgetDTO 
{
	private String widgetCode;
	private String widgetName;
	
	/**
	 * 기본생성자
	 */
	public WidgetDTO()
	{
		this("","");
	}
	/**
	 * 전달인자를 받는 생성자
	 * @param widgetCode 위젯코드
	 * @param widgetName 위젯명
	 */
	public WidgetDTO(String widgetCode, String widgetName) { 
		this.widgetCode = widgetCode;
		this.widgetName = widgetName;
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
	 * 위젯명을 리턴한다
	 * @return
	 */
	public String getWidgetName() {
		return widgetName;
	}

	/**
	 * 위젯명을 설정한다
	 * @param widgetName
	 */
	public void setWidgetName(String widgetName) {
		this.widgetName = widgetName;
	}
	
	

}
