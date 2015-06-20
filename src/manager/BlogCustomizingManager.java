package manager;

import java.util.*;
import model.BlogInfo;
import model.WidgetInfo;
import dao.*;
/**
 * DB에 사용자가 변경한 블로그 정보를 저장하기 위해 사용하는 매니저
 * @author 대곤
 *
 */
public class BlogCustomizingManager {
	/**
	 * 블로그 정보
	 */
	private BlogInfo blogInfo;

	/**
	 * 널생성자
	 */
	public BlogCustomizingManager() {
		this(new BlogInfo());
	}

/**
 * 기본생성자
 * @param blogInfo 블로그 정보
 */
	public BlogCustomizingManager(BlogInfo blogInfo) {
		this.blogInfo = blogInfo;
	}

/**
 * 블로그 정보 반환
 */
	public BlogInfo getBlogInfo() {
		return blogInfo;
	}

/**
 * 블로그 정보 설정
 * @param blogInfo 블로그 정보
 */
	public void setBlogInfo(BlogInfo blogInfo) {
		this.blogInfo = blogInfo;
	}
	/**
	 * 배경색상 갱신하기 위해 사용하는 메소드, BlogDAO의 updateBgColor메소드를 호출
	 * @param memberCode 회원번호
	 * @return 블로그 정보
	 */
	public BlogInfo reviseBgColor(String memberCode){
		BlogDAO blogDAO=new BlogDAO();
		String blogCode=blogDAO.selectBlogCode(memberCode);
		blogDAO.updateBgColor(blogCode, blogInfo.getBgColorCode());
		System.out.println(blogCode);
		return blogInfo;
	}
	/**
	 * 글꼴명 갱신하기 위해 사용하는 메소드, BlogDAO의 updateFont메소드를 호출
	 * @param memberCode 회원번호
	 * @return 블로그 정보
	 */
	public BlogInfo reviseFont(String memberCode){
		BlogDAO blogDAO=new BlogDAO();
		String blogCode=blogDAO.selectBlogCode(memberCode);
		blogDAO.updateFont(blogCode, blogInfo.getFontName());
		System.out.println(blogCode);
		return blogInfo;
	}
	/**
	 * 레이아웃을 갱신하기 위해 사용하는 메소드,BlogDAO의 updateLyout메소드를 호출
	 * @param memberCode 회원번호
	 * @return 블로그 정보
	 */
	public BlogInfo reviseLayout(String memberCode){
		BlogDAO blogDAO=new BlogDAO();
		String blogCode=blogDAO.selectBlogCode(memberCode);
		
		blogDAO.updateLayout(blogCode, blogInfo.getLayoutName());
		System.out.println(blogCode);
		return blogInfo;
	}
	/**
	 * 위젯정보를 갱신하기 위해 사용하는 메소드, BlogDAO의 updateWidget메소드를 호출
	 *@param memberCode 회원번호
	 * @return 블로그 정보
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
	 * 카테고리를 갱신하기 위해 사용하는 메소드, BlogDAO의 updateCategory메소드를 호출
	 * @param memberCode 회원번호
	 * @return 블로그 정보
	 */

}
