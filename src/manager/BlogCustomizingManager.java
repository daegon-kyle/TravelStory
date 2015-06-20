package manager;

import java.util.*;
import model.BlogInfo;
import model.WidgetInfo;
import dao.*;
/**
 * DB�� ����ڰ� ������ ��α� ������ �����ϱ� ���� ����ϴ� �Ŵ���
 * @author ���
 *
 */
public class BlogCustomizingManager {
	/**
	 * ��α� ����
	 */
	private BlogInfo blogInfo;

	/**
	 * �λ�����
	 */
	public BlogCustomizingManager() {
		this(new BlogInfo());
	}

/**
 * �⺻������
 * @param blogInfo ��α� ����
 */
	public BlogCustomizingManager(BlogInfo blogInfo) {
		this.blogInfo = blogInfo;
	}

/**
 * ��α� ���� ��ȯ
 */
	public BlogInfo getBlogInfo() {
		return blogInfo;
	}

/**
 * ��α� ���� ����
 * @param blogInfo ��α� ����
 */
	public void setBlogInfo(BlogInfo blogInfo) {
		this.blogInfo = blogInfo;
	}
	/**
	 * ������ �����ϱ� ���� ����ϴ� �޼ҵ�, BlogDAO�� updateBgColor�޼ҵ带 ȣ��
	 * @param memberCode ȸ����ȣ
	 * @return ��α� ����
	 */
	public BlogInfo reviseBgColor(String memberCode){
		BlogDAO blogDAO=new BlogDAO();
		String blogCode=blogDAO.selectBlogCode(memberCode);
		blogDAO.updateBgColor(blogCode, blogInfo.getBgColorCode());
		System.out.println(blogCode);
		return blogInfo;
	}
	/**
	 * �۲ø� �����ϱ� ���� ����ϴ� �޼ҵ�, BlogDAO�� updateFont�޼ҵ带 ȣ��
	 * @param memberCode ȸ����ȣ
	 * @return ��α� ����
	 */
	public BlogInfo reviseFont(String memberCode){
		BlogDAO blogDAO=new BlogDAO();
		String blogCode=blogDAO.selectBlogCode(memberCode);
		blogDAO.updateFont(blogCode, blogInfo.getFontName());
		System.out.println(blogCode);
		return blogInfo;
	}
	/**
	 * ���̾ƿ��� �����ϱ� ���� ����ϴ� �޼ҵ�,BlogDAO�� updateLyout�޼ҵ带 ȣ��
	 * @param memberCode ȸ����ȣ
	 * @return ��α� ����
	 */
	public BlogInfo reviseLayout(String memberCode){
		BlogDAO blogDAO=new BlogDAO();
		String blogCode=blogDAO.selectBlogCode(memberCode);
		
		blogDAO.updateLayout(blogCode, blogInfo.getLayoutName());
		System.out.println(blogCode);
		return blogInfo;
	}
	/**
	 * ���������� �����ϱ� ���� ����ϴ� �޼ҵ�, BlogDAO�� updateWidget�޼ҵ带 ȣ��
	 *@param memberCode ȸ����ȣ
	 * @return ��α� ����
	 */
	public BlogInfo reviseWidget(String memberCode){
		BlogDAO blogDAO=new BlogDAO();
		String blogCode=blogDAO.selectBlogCode(memberCode);
		
		UsedWidgetDAO usedWidgetDAO=new UsedWidgetDAO();
		usedWidgetDAO.deleteUsedWidgets(blogCode);
		ArrayList<WidgetInfo> widgetList=(ArrayList<WidgetInfo>)blogInfo.getWidgetInfoList();
		for(WidgetInfo widgetInfo : widgetList){
			usedWidgetDAO.insert(widgetInfo.getWidgetCode(), blogCode);
		}
		return blogInfo;
	}
	/**
	 * ī�װ��� �����ϱ� ���� ����ϴ� �޼ҵ�, BlogDAO�� updateCategory�޼ҵ带 ȣ��
	 * @param memberCode ȸ����ȣ
	 * @return ��α� ����
	 */

}
