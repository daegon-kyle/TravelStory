package model;

import java.util.ArrayList;
import java.util.List;

/**
 * 개인 블로그 정보를 저장하는 클래스
 * <br>BlogCustomizingServlet과 memberJoinServlet에서 사용하는 클래스
 * @author 대곤
 *
 */
public class BlogInfo implements  java.io.Serializable{
	private static final long serialVersionUID = 4544041003292718883L;
	/**
	 * 블로그 코드
	 */
	private String blogCode;
	/**
	 * 레이아웃 명
	 */
	private String layoutName;
	/**
	 * 배경화면코드
	 */
	private String bgColorCode;
	/**
	 * 글꼴명
	 */
	private String fontName;
	/**
	 * 카테고리정보목록
	 */
	private List<CategoryInfo> categoryInfoList;
	/**
	 * 위젯정보목록
	 */
	private List<WidgetInfo> widgetInfoList;
	
	/**
	 * 널 생성자
	 */
	public BlogInfo() {
		this("","","","",new ArrayList<CategoryInfo>(),new ArrayList<WidgetInfo>());
	}
	/**
	 * 기본 생성자
	 * @param blogCode 블로그 코드
	 * @param layoutName 레이아웃명
	 * @param bgColorCode 배경색상코드
	 * @param fontName 글꼴명
	 * @param categoryInfoList 카테고리정보목록
	 * @param widgetInfoList 위젯정보목록
	 */
	public BlogInfo(String blogCode, String layoutName, String bgColorCode, String fontName,
			List<CategoryInfo> categoryInfoList, List<WidgetInfo> widgetInfoList) {
		this.blogCode=blogCode;
		this.layoutName = layoutName;
		this.bgColorCode = bgColorCode;
		this.fontName = fontName;
		this.categoryInfoList = categoryInfoList;
		this.widgetInfoList = widgetInfoList;
	}
	/**
	 * 레이아웃명 반환
	 * @return 레이아웃명
	 */
	public String getLayoutName() {
		return layoutName;
	}
/**
 * 레이아웃명 설정
 * @param layoutName 레이아웃명
 */
	public void setLayoutName(String layoutName) {
		this.layoutName = layoutName;
	}
/**
 * 배경색상코드 반환
 * @return 배경색상코드
 */
	public String getBgColorCode() {
		return bgColorCode;
	}
/**
 * 배경색상코드 설정
 * @param bgColorCode 배경색상코드
 */
	public void setBgColorCode(String bgColorCode) {
		this.bgColorCode = bgColorCode;
	}
/**
 * 글꼴명 반환
 * @return 글꼴명
 */
	public String getFontName() {
		return fontName;
	}
/**
 * 글꼴명 설정
 * @param fontName 글꼴명
 */
	public void setFontName(String fontName) {
		this.fontName = fontName;
	}
/**
 * 카테고리목록 반환
 * @return카테고리목록
 */
	public List<CategoryInfo> getCategoryInfoList() {
		return categoryInfoList;
	}
/**
 * 카테고리목록 설정
 * @param categoryInfoList 카테고리목록
 */
	public void setCategoryInfoList(List<CategoryInfo> categoryInfoList) {
		this.categoryInfoList = categoryInfoList;
	}
/**
 * 위젯정보목록반환
 * @return 위젯정보목록
 */
	public List<WidgetInfo> getWidgetInfoList() {
		return widgetInfoList;
	}
/**
 * 위젯정보목록 설정
 * @param widgetInfoList 위젯정보목록
 */
	public void setWidgetInfoList(List<WidgetInfo> widgetInfoList) {
		this.widgetInfoList = widgetInfoList;
	}
	
}
