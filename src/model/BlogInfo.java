package model;

import java.util.ArrayList;
import java.util.List;

/**
 * ���� ��α� ������ �����ϴ� Ŭ����
 * <br>BlogCustomizingServlet�� memberJoinServlet���� ����ϴ� Ŭ����
 * @author ���
 *
 */
public class BlogInfo implements  java.io.Serializable{
	private static final long serialVersionUID = 4544041003292718883L;
	/**
	 * ��α� �ڵ�
	 */
	private String blogCode;
	/**
	 * ���̾ƿ� ��
	 */
	private String layoutName;
	/**
	 * ���ȭ���ڵ�
	 */
	private String bgColorCode;
	/**
	 * �۲ø�
	 */
	private String fontName;
	/**
	 * ī�װ��������
	 */
	private List<CategoryInfo> categoryInfoList;
	/**
	 * �����������
	 */
	private List<WidgetInfo> widgetInfoList;
	
	/**
	 * �� ������
	 */
	public BlogInfo() {
		this("","","","",new ArrayList<CategoryInfo>(),new ArrayList<WidgetInfo>());
	}
	/**
	 * �⺻ ������
	 * @param blogCode ��α� �ڵ�
	 * @param layoutName ���̾ƿ���
	 * @param bgColorCode �������ڵ�
	 * @param fontName �۲ø�
	 * @param categoryInfoList ī�װ��������
	 * @param widgetInfoList �����������
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
	 * ���̾ƿ��� ��ȯ
	 * @return ���̾ƿ���
	 */
	public String getLayoutName() {
		return layoutName;
	}
/**
 * ���̾ƿ��� ����
 * @param layoutName ���̾ƿ���
 */
	public void setLayoutName(String layoutName) {
		this.layoutName = layoutName;
	}
/**
 * �������ڵ� ��ȯ
 * @return �������ڵ�
 */
	public String getBgColorCode() {
		return bgColorCode;
	}
/**
 * �������ڵ� ����
 * @param bgColorCode �������ڵ�
 */
	public void setBgColorCode(String bgColorCode) {
		this.bgColorCode = bgColorCode;
	}
/**
 * �۲ø� ��ȯ
 * @return �۲ø�
 */
	public String getFontName() {
		return fontName;
	}
/**
 * �۲ø� ����
 * @param fontName �۲ø�
 */
	public void setFontName(String fontName) {
		this.fontName = fontName;
	}
/**
 * ī�װ���� ��ȯ
 * @returnī�װ����
 */
	public List<CategoryInfo> getCategoryInfoList() {
		return categoryInfoList;
	}
/**
 * ī�װ���� ����
 * @param categoryInfoList ī�װ����
 */
	public void setCategoryInfoList(List<CategoryInfo> categoryInfoList) {
		this.categoryInfoList = categoryInfoList;
	}
/**
 * ����������Ϲ�ȯ
 * @return �����������
 */
	public List<WidgetInfo> getWidgetInfoList() {
		return widgetInfoList;
	}
/**
 * ����������� ����
 * @param widgetInfoList �����������
 */
	public void setWidgetInfoList(List<WidgetInfo> widgetInfoList) {
		this.widgetInfoList = widgetInfoList;
	}
	
}
