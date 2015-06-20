package model;

import java.io.Serializable;
/**
 * 위젯정보를 캡슐화하는 클래스 
 * @author 영한
 *
 */
public class WidgetInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3599512782489194111L;
	/**
	 * 위젯에 부여되는 위젯코드 
	 */
	private String widgetCode;
	/**
	 * 위젯이름 
	 */
	private String widgetName;
	/**
	 * 위젯의 포스팅목적코드 
	 */
	private String postingPurposeCode;
	/**
	 * null생성자 
	 */
	public WidgetInfo() {
		this("","","");
	}
	/**
	 * 오버로딩 생성자 
	 * @param widgetCode
	 * @param widgetName
	 * @param postingPurposeCode
	 */
	public WidgetInfo(String widgetCode, String widgetName,
			String postingPurposeCode) {
		this.widgetCode = widgetCode;
		this.widgetName = widgetName;
		this.postingPurposeCode = postingPurposeCode;
	}
	/**
	 * 위젯코드를 반환한다. 
	 * @return 위젯코드 
	 */
	public String getWidgetCode() {
		return widgetCode;
	}
	/**
	 * 위젯코드를 세팅한다. 
	 * @param widgetCode 위젯코드 
	 */
	public void setWidgetCode(String widgetCode) {
		this.widgetCode = widgetCode;
	}
	/**
	 * 위젯이름을 반환한다. 
	 * @return 위젯이름 
	 */
	public String getWidgetName() {
		return widgetName;
	}
	/**
	 * 위젯이름을 세팅한다. 
	 * @param widgetName 위젯이름 
	 */
	public void setWidgetName(String widgetName) {
		this.widgetName = widgetName;
	}
	/**
	 * 포스팅목적코드를 반환한다. 
	 * @return 포스팅목적코드
	 */
	public String getPostingPurposeCode() {
		return postingPurposeCode;
	}
	/**
	 * 포스팅목적코드를 세팅한다. 
	 * @param postingPurposeCode 포스팅목적코드
	 */
	public void setPostingPurposeCode(String postingPurposeCode) {
		this.postingPurposeCode = postingPurposeCode;
	}
	
	
	
}
