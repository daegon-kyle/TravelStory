package form;

/**
 * 
 * ����ڰ� �Է��� ��α� Ŀ���͸���¡ �� Ŭ����
 *
 */
public class BlogCustomizingForm {
	/**
	 * �������ڵ�
	 */
	private String bgColorCode;
	/**
	 * �������ϰ��
	 */
	private String photoPath;
	/**
	 * �������Ͽ뷮
	 */
	private String photoExtension;
	/**
	 * ���̾ƿ���
	 */
	private String layoutName;
	/**
	 * �۲ø�
	 */
	private String fontName;
	/**
	 * ����ϰ� �ִ� �����ڵ����
	 */
	private String[] widgetCode;
	/**
	 * ī�װ��ڵ� (��� or �θ� ī�װ�)
	 */
	private String categoryCode;
	/**
	 * ������ ī�װ� ��
	 */
	private String categoryName;
	
	/**
	 * �λ�����
	 */
	public BlogCustomizingForm() {
		this("","","","","",new String[2],"","");
	}

	/**
	 * ������
	 * @param bgColorCode �������ڵ�
	 * @param photoPath �������ϰ��
	 * @param photoExtension �������Ͽ뷮
	 * @param layoutName ���̾ƿ���
	 * @param fontName �۲ø�
	 * @param widgetCode ����ϰ� �ִ� �����ڵ� ���
	 * @param CategoryCode  ī�װ��ڵ�(��� or �θ�ī�װ�)
	 * @param categoryName ������ ī�װ� ��
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
