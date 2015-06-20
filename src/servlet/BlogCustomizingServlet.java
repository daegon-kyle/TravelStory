package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import validator.BlankValidator;

import model.BlogInfo;
import model.CategoryInfo;
import model.WidgetInfo;
import manager.BlogCustomizingManager;
import manager.CategoryManager;
import dao.*;


/**
 * 블로그 커스터마이지 서비스를 관할하는 서블릿
 * Servlet implementation class BlogCustomizingServlet
 */
@WebServlet(name="BlogCustomizingServlet", urlPatterns = {"/page/mem_mange_category_fake.jsp","/page/categoryModify","/page/category_modify_fake.jsp", "/page/categoryDelete", "/mem_mange_customizing.jsp", "/page/saveBackgroundColor", "/page/fontColor", "/mem_mange_category.jsp", "/page/layout", "/page/widget", "/page/category_add_fake.jsp","/page/categoryAdd","/page/category_delete_fake.jsp"})

public class BlogCustomizingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 배경색상, 글꼴명, 레이아웃명, 사용하고 있는 위젯목록, (카테고리코드, 명) 전달
	 * <br>수정할 내용에 따라 BlogCustomizingManager의 메소드가 호출된다.
	 * <br>배경색 변경 : reviseBgColor() 
		<br>폰트 변경 : reviseFont()
		<br>레이아웃 변경 : reviseLayout()
		<br>위젯 변경 : reviseWidget()
		<br>카테고리 변경 : reviseCategory()

	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		//session에서 멤버코드 받아와야 한다.
		HttpSession session=request.getSession();
		String memberCode=(String)session.getAttribute("memberCode");
		System.out.println("회원코드:"+memberCode);
		
		String uri=request.getRequestURI();
		System.out.println(uri);
		int lastIndex=uri.lastIndexOf("/");
		String action=uri.substring(lastIndex+1);
		String dispatchUrl=null;
		
		BlogInfo blogInfo=new BlogInfo();
		
		if(action.equals("mem_mange_category_fake.jsp")){
			System.out.println("카테고리 관리 메인화면 들어가기 전, 목록들 세팅 하기!");
			
			CategoryManager categoryManager=new CategoryManager();
			ArrayList<CategoryInfo> categoryList=(ArrayList<CategoryInfo>)categoryManager.selectCategorys(memberCode);	//전체 카테고리 목록
			
			ArrayList<CategoryInfo> mainCategoryList=new ArrayList<CategoryInfo>();
			ArrayList<CategoryInfo> subCategoryList=new ArrayList<CategoryInfo>();
			
			for(CategoryInfo tmp:categoryList){
				if(tmp.getCategoryDepth()==0){
					mainCategoryList.add(tmp);
					System.out.println("부모입장에서 자기코드:"+tmp.getCategoryCode());
				}
				else{
					subCategoryList.add(tmp);
					System.out.println("자식입장에서 부모코드:"+tmp.getParentCategoryCode());
				}
			}
			
			request.setAttribute("mainCategoryList", mainCategoryList);
			request.setAttribute("subCategoryList", subCategoryList);
			
			dispatchUrl="mem_mange_category.jsp";
		}
		else if(action.equals("saveBackgroundColor")){
			String bgColor=request.getParameter("bgColor");
			System.out.println("배경색"+bgColor);
			blogInfo.setBgColorCode(bgColor);
			
			BlogCustomizingManager blogCustomizingManager=new BlogCustomizingManager(blogInfo);
			blogCustomizingManager.reviseBgColor(memberCode); //memberCode
			System.out.println("배경화면색깔");
			Cookie cookie=new Cookie("bgColor", bgColor);
			response.addCookie(cookie);
			dispatchUrl="mem_mange_customizing.jsp";
		}
		else if(action.equals("fontColor")){
			String font=request.getParameter("font");
			System.out.println("글꼴"+font);
			blogInfo.setFontName(font);
			
			BlogCustomizingManager blogCustomizingManager=new BlogCustomizingManager(blogInfo);
			blogCustomizingManager.reviseFont(memberCode);	//memberCode
			System.out.println("글꼴명 변경^^");
			
			Cookie cookie=new Cookie("font", font);
			response.addCookie(cookie);
			dispatchUrl="mem_mange_customizing.jsp";
		}
		else if(action.equals("layout")){
			String layout=request.getParameter("layout");
			if(layout==null)
				System.out.println("null 임!");
			else{
				System.out.println("레이아웃"+layout);
				blogInfo.setLayoutName(layout);
				
				BlogCustomizingManager blogCustomizingManager=new BlogCustomizingManager(blogInfo);
				blogCustomizingManager.reviseLayout(memberCode);	//memberCode
				System.out.println("레이아웃변경!");
				Cookie cookie=new Cookie("layout", layout);
				response.addCookie(cookie);
				dispatchUrl="mem_mange_customizing.jsp";
			}
		}
		else if(action.equals("widget")){
			String[] widget=request.getParameterValues("widget");
			int length=widget.length;
			
			ArrayList<WidgetInfo> widgetList=new ArrayList<WidgetInfo>(); 
			for(String temp:widget){
				System.out.println("선택한위젯"+temp);
				WidgetInfo widgetInfo=new WidgetInfo();
				widgetInfo.setWidgetCode(temp);
				widgetList.add(widgetInfo);
			}
			
			blogInfo.setWidgetInfoList(widgetList);
			BlogCustomizingManager blogCustomizingManager=new BlogCustomizingManager(blogInfo);
			blogCustomizingManager.reviseWidget(memberCode);	//memberCode
			System.out.println("위젯 변경!");
			
			for(int i=0; i<length; i++){
				Cookie cookie=new Cookie(widget[i], widget[i]);
				response.addCookie(cookie);
			}
			dispatchUrl="mem_mange_customizing.jsp";
		}
		else if(action.equals("category_add_fake.jsp")){
			System.out.println("카테고리 저장, DB 가기 전");
			
			CategoryManager categoryManager=new CategoryManager();
			ArrayList<CategoryInfo> categoryList=(ArrayList<CategoryInfo>)categoryManager.selectMainCategorys(memberCode);
		
			request.setAttribute("categoryList", categoryList);
			
			dispatchUrl="category_add.jsp";
		}
		else if(action.equals("category_delete_fake.jsp")){
			System.out.println("카테고리 삭제, DB 가기 전");
			
			CategoryManager categoryManager=new CategoryManager();
			ArrayList<CategoryInfo> mainCategoryList=(ArrayList<CategoryInfo>)categoryManager.selectMainCategorys(memberCode);
			ArrayList<CategoryInfo> subCategoryList=(ArrayList<CategoryInfo>)categoryManager.selectSubCategorys(memberCode);
			
			request.setAttribute("mainCategoryList", mainCategoryList);
			request.setAttribute("subCategoryList", subCategoryList);
			
			dispatchUrl="category_delete.jsp";
		}
		else if(action.equals("category_modify_fake.jsp")){
			System.out.println("카테고리 수정, DB가기전");
			
			CategoryManager categoryManager=new CategoryManager();
			ArrayList<CategoryInfo> mainCategoryList=(ArrayList<CategoryInfo>)categoryManager.selectMainCategorys(memberCode);
			ArrayList<CategoryInfo> subCategoryList=(ArrayList<CategoryInfo>)categoryManager.selectSubCategorys(memberCode);
			
			request.setAttribute("mainCategoryList", mainCategoryList);
			request.setAttribute("subCategoryList", subCategoryList);
			
			dispatchUrl="category_modify.jsp";
		}
		
		RequestDispatcher view=request.getRequestDispatcher(dispatchUrl);
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//session에서 멤버코드 받아와야 한다.
		HttpSession session=request.getSession();
		String memberCode=(String)session.getAttribute("memberCode");

		String uri=request.getRequestURI();
		System.out.println(uri);
		int lastIndex=uri.lastIndexOf("/");
		String action=uri.substring(lastIndex+1);
		String dispatchUrl=null;
		
		if(action.equals("categoryAdd")){
			System.out.println("카테고리 저장, DB 갔다옴");
			String categoryAddName=request.getParameter("categoryAddName");
			String mainCategoryCode=request.getParameter("mainCategoryCode");
			String divide=request.getParameter("divide");
			
			System.out.println(mainCategoryCode);
			
			BlankValidator blankValidator=new BlankValidator();
			if(blankValidator.validateBlank(mainCategoryCode))
				System.out.println("추가할 카테고리명을 입력하세요");
			if(blankValidator.validateBlank(divide))
				System.out.println("항목을 선택해주세요");
			
			CategoryManager categoryManager=null;
			
			if(divide.equals("child")){
				categoryManager=new CategoryManager(new CategoryInfo(mainCategoryCode, categoryAddName));
				categoryManager.insert(memberCode, mainCategoryCode);	//21는 memberCode
			}
			else{
				categoryManager=new CategoryManager();
				CategoryInfo categoryInfo=new CategoryInfo();
				categoryInfo.setCategoryName(categoryAddName);
				categoryManager.setCategoryInfo(categoryInfo);
				
				categoryManager.insert(memberCode);
			}
						
			dispatchUrl="mem_mange_category.jsp";
		}
		else if(action.equals("categoryDelete")){
			String divide=request.getParameter("divide");
			CategoryManager categoryManager=new CategoryManager();
			CategoryInfo categoryInfo=new CategoryInfo();
			
			if(divide.equals("parent")){
				String mainCategoryCode=request.getParameter("mainCategoryCode");
				
				categoryInfo.setCategoryCode(mainCategoryCode);
				categoryManager.setCategoryInfo(categoryInfo);
				if(categoryManager.deleteMainCategory(memberCode)){ //21는 memberCode
					System.out.println("main카테고리 삭제성공");
				}
			}
			else{
				String subCategoryCode=request.getParameter("subCategoryCode");
				
				categoryInfo.setCategoryCode(subCategoryCode);
				categoryManager.setCategoryInfo(categoryInfo);
				if(categoryManager.deleteSubCategory(memberCode)){ //21는 memberCode
					System.out.println("sub카테고리 삭제성공");
				}
			}
			
			dispatchUrl="mem_mange_category.jsp";
		}
		else if(action.equals("categoryModify")){
			String divide=request.getParameter("divide");
			CategoryManager categoryManager=new CategoryManager();
			CategoryInfo categoryInfo=new CategoryInfo();
			System.out.println(uri+"하하하하하");
			
			if(divide.equals("parent")){
				String mainCategoryCode=request.getParameter("mainCategoryCode");
				String mainCategoryName=request.getParameter("mainCategoryName");
				
				categoryInfo.setCategoryCode(mainCategoryCode);
				categoryInfo.setCategoryName(mainCategoryName);
				categoryManager.setCategoryInfo(categoryInfo);
				
				if(categoryManager.reviseMainCategory(memberCode)){ //21는 memberCode
					System.out.println("main카테고리 수정성공");
				}
				System.out.println("-------main카테고리 안--------");
			}
			else{
				String subCategoryCode=request.getParameter("subCategoryCode");
				String subCategoryName=request.getParameter("subCategoryName");
				
				categoryInfo.setCategoryCode(subCategoryCode);
				categoryInfo.setCategoryName(subCategoryName);
				categoryManager.setCategoryInfo(categoryInfo);
				
				if(categoryManager.reviseSubCategory(memberCode)){ //21는 memberCode
					System.out.println("--------sub카테고리 수정성공------");
				}
				System.out.println("sub카테고리 안");
			}
			dispatchUrl="mem_mange_category.jsp";
		}
		
		RequestDispatcher view=request.getRequestDispatcher(dispatchUrl);
		view.forward(request, response);
	}
}
