package form;

/**
 * 
 * 사용자가 입력한 블로그 커스터마이징 폼 클래스
 *
 */
public class BlogCustomizingForm {
	/**
	 * 배경색상코드
	 */
	private String bgColorCode;
	/**
	 * 사진파일경로
	 */
	private String photoPath;
	/**
	 * 사진파일용량
	 */
	private String photoExtension;
	/**
	 * 레이아웃명
	 */
	private String layoutName;
	/**
	 * 글꼴명
	 */
	private String fontName;
	/**
	 * 사용하고 있는 위젯코드모음
	 */
	private String[] widgetCode;
	/**
	 * 카테고리코드 (대상 or 부모 카테고리)
	 */
	private String categoryCode;
	/**
	 * 변경할 카테고리 명
	 */
	private String categoryName;
	
	/**
	 * 널생성자
	 */
	public BlogCustomizingForm() {
		this("","","","","",new String[2],"","");
	}

	/**
	 * 생성자
	 * @param bgColorCode 배경색상코드
	 * @param photoPath 사진파일경로
	 * @param photoExtension 사진파일용량
	 * @param layoutName 레이아웃명
	 * @param fontName 글꼴명
	 * @param widgetCode 사용하고 있는 위젯코드 목록
	 * @param CategoryCode  카테고리코드(대상 or 부모카테고리)
	 * @param categoryName 변경할 카테고리 명
	 */
	public BlogCustomizingForm(String bgColorCode, String photoPath,
			String photoExtension, String layoutName, String fontName,
			String[] widgetCode, String CategoryCode, String categoryName) {
		this.bgColorCode = bgColorCode;
		this.photoPath = photoPath;
		this.photoExtension = photoExtension;
		this.layoutName = layoutName;
		this.fontName = fontName;
		this.widgetCode = widgetCode;
		this.categoryCode=CategoryCode;
		this.categoryName = categoryName;
	}
	
	public String getBgColorCode() {
		return bgColorCode;
	}
	public void setBgColorCode(String bgColorCode) {
		this.bgColorCode = bgColorCode;
	}
	public String getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	public String getPhotoExtension() {
		return photoExtension;
	}
	public void setPhotoExtension(String photoExtension) {
		this.photoExtension = photoExtension;
	}
	public String getLayoutName() {
		return layoutName;
	}
	public void setLayoutName(String layoutName) {
		this.layoutName = layoutName;
	}
	public String getFontName() {
		return fontName;
	}
	public void setFontName(String fontName) {
		this.fontName = fontName;
	}
	public String[] getWidgetCode() {
		return widgetCode;
	}
	public void setWidgetCode(String[] widgetCode) {
		this.widgetCode = widgetCode;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
