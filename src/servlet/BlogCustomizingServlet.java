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
 * ��α� Ŀ���͸����� ���񽺸� �����ϴ� ����
 * Servlet implementation class BlogCustomizingServlet
 */
@WebServlet(name="BlogCustomizingServlet", urlPatterns = {"/page/mem_mange_category_fake.jsp","/page/categoryModify","/page/category_modify_fake.jsp", "/page/categoryDelete", "/mem_mange_customizing.jsp", "/page/saveBackgroundColor", "/page/fontColor", "/mem_mange_category.jsp", "/page/layout", "/page/widget", "/page/category_add_fake.jsp","/page/categoryAdd","/page/category_delete_fake.jsp"})

public class BlogCustomizingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * ������, �۲ø�, ���̾ƿ���, ����ϰ� �ִ� �������, (ī�װ��ڵ�, ��) ����
	 * <br>������ ���뿡 ���� BlogCustomizingManager�� �޼ҵ尡 ȣ��ȴ�.
	 * <br>���� ���� : reviseBgColor() 
		<br>��Ʈ ���� : reviseFont()
		<br>���̾ƿ� ���� : reviseLayout()
		<br>���� ���� : reviseWidget()
		<br>ī�װ� ���� : reviseCategory()

	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		//session���� ����ڵ� �޾ƿ;� �Ѵ�.
		HttpSession session=request.getSession();
		String memberCode=(String)session.getAttribute("memberCode");
		System.out.println("ȸ���ڵ�:"+memberCode);
		
		String uri=request.getRequestURI();
		System.out.println(uri);
		int lastIndex=uri.lastIndexOf("/");
		String action=uri.substring(lastIndex+1);
		String dispatchUrl=null;
		
		BlogInfo blogInfo=new BlogInfo();
		
		if(action.equals("mem_mange_category_fake.jsp")){
			System.out.println("ī�װ� ���� ����ȭ�� ���� ��, ��ϵ� ���� �ϱ�!");
			
			CategoryManager categoryManager=new CategoryManager();
			ArrayList<CategoryInfo> categoryList=(ArrayList<CategoryInfo>)categoryManager.selectCategorys(memberCode);	//��ü ī�װ� ���
			
			ArrayList<CategoryInfo> mainCategoryList=new ArrayList<CategoryInfo>();
			ArrayList<CategoryInfo> subCategoryList=new ArrayList<CategoryInfo>();
			
			for(CategoryInfo tmp:categoryList){
				if(tmp.getCategoryDepth()==0){
					mainCategoryList.add(tmp);
					System.out.println("�θ����忡�� �ڱ��ڵ�:"+tmp.getCategoryCode());
				}
				else{
					subCategoryList.add(tmp);
					System.out.println("�ڽ����忡�� �θ��ڵ�:"+tmp.getParentCategoryCode());
				}
			}
			
			request.setAttribute("mainCategoryList", mainCategoryList);
			request.setAttribute("subCategoryList", subCategoryList);
			
			dispatchUrl="mem_mange_category.jsp";
		}
		else if(action.equals("saveBackgroundColor")){
			String bgColor=request.getParameter("bgColor");
			System.out.println("����"+bgColor);
			blogInfo.setBgColorCode(bgColor);
			
			BlogCustomizingManager blogCustomizingManager=new BlogCustomizingManager(blogInfo);
			blogCustomizingManager.reviseBgColor(memberCode); //memberCode
			System.out.println("���ȭ�����");
			Cookie cookie=new Cookie("bgColor", bgColor);
			response.addCookie(cookie);
			dispatchUrl="mem_mange_customizing.jsp";
		}
		else if(action.equals("fontColor")){
			String font=request.getParameter("font");
			System.out.println("�۲�"+font);
			blogInfo.setFontName(font);
			
			BlogCustomizingManager blogCustomizingManager=new BlogCustomizingManager(blogInfo);
			blogCustomizingManager.reviseFont(memberCode);	//memberCode
			System.out.println("�۲ø� ����^^");
			
			Cookie cookie=new Cookie("font", font);
			response.addCookie(cookie);
			dispatchUrl="mem_mange_customizing.jsp";
		}
		else if(action.equals("layout")){
			String layout=request.getParameter("layout");
			if(layout==null)
				System.out.println("null ��!");
			else{
				System.out.println("���̾ƿ�"+layout);
				blogInfo.setLayoutName(layout);
				
				BlogCustomizingManager blogCustomizingManager=new BlogCustomizingManager(blogInfo);
				blogCustomizingManager.reviseLayout(memberCode);	//memberCode
				System.out.println("���̾ƿ�����!");
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
				System.out.println("����������"+temp);
				WidgetInfo widgetInfo=new WidgetInfo();
				widgetInfo.setWidgetCode(temp);
				widgetList.add(widgetInfo);
			}
			
			blogInfo.setWidgetInfoList(widgetList);
			BlogCustomizingManager blogCustomizingManager=new BlogCustomizingManager(blogInfo);
			blogCustomizingManager.reviseWidget(memberCode);	//memberCode
			System.out.println("���� ����!");
			
			for(int i=0; i<length; i++){
				Cookie cookie=new Cookie(widget[i], widget[i]);
				response.addCookie(cookie);
			}
			dispatchUrl="mem_mange_customizing.jsp";
		}
		else if(action.equals("category_add_fake.jsp")){
			System.out.println("ī�װ� ����, DB ���� ��");
			
			CategoryManager categoryManager=new CategoryManager();
			ArrayList<CategoryInfo> categoryList=(ArrayList<CategoryInfo>)categoryManager.selectMainCategorys(memberCode);
		
			request.setAttribute("categoryList", categoryList);
			
			dispatchUrl="category_add.jsp";
		}
		else if(action.equals("category_delete_fake.jsp")){
			System.out.println("ī�װ� ����, DB ���� ��");
			
			CategoryManager categoryManager=new CategoryManager();
			ArrayList<CategoryInfo> mainCategoryList=(ArrayList<CategoryInfo>)categoryManager.selectMainCategorys(memberCode);
			ArrayList<CategoryInfo> subCategoryList=(ArrayList<CategoryInfo>)categoryManager.selectSubCategorys(memberCode);
			
			request.setAttribute("mainCategoryList", mainCategoryList);
			request.setAttribute("subCategoryList", subCategoryList);
			
			dispatchUrl="category_delete.jsp";
		}
		else if(action.equals("category_modify_fake.jsp")){
			System.out.println("ī�װ� ����, DB������");
			
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
		
		//session���� ����ڵ� �޾ƿ;� �Ѵ�.
		HttpSession session=request.getSession();
		String memberCode=(String)session.getAttribute("memberCode");

		String uri=request.getRequestURI();
		System.out.println(uri);
		int lastIndex=uri.lastIndexOf("/");
		String action=uri.substring(lastIndex+1);
		String dispatchUrl=null;
		
		if(action.equals("categoryAdd")){
			System.out.println("ī�װ� ����, DB ���ٿ�");
			String categoryAddName=request.getParameter("categoryAddName");
			String mainCategoryCode=request.getParameter("mainCategoryCode");
			String divide=request.getParameter("divide");
			
			System.out.println(mainCategoryCode);
			
			BlankValidator blankValidator=new BlankValidator();
			if(blankValidator.validateBlank(mainCategoryCode))
				System.out.println("�߰��� ī�װ����� �Է��ϼ���");
			if(blankValidator.validateBlank(divide))
				System.out.println("�׸��� �������ּ���");
			
			CategoryManager categoryManager=null;
			
			if(divide.equals("child")){
				categoryManager=new CategoryManager(new CategoryInfo(mainCategoryCode, categoryAddName));
				categoryManager.insert(memberCode, mainCategoryCode);	//21�� memberCode
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
				if(categoryManager.deleteMainCategory(memberCode)){ //21�� memberCode
					System.out.println("mainī�װ� ��������");
				}
			}
			else{
				String subCategoryCode=request.getParameter("subCategoryCode");
				
				categoryInfo.setCategoryCode(subCategoryCode);
				categoryManager.setCategoryInfo(categoryInfo);
				if(categoryManager.deleteSubCategory(memberCode)){ //21�� memberCode
					System.out.println("subī�װ� ��������");
				}
			}
			
			dispatchUrl="mem_mange_category.jsp";
		}
		else if(action.equals("categoryModify")){
			String divide=request.getParameter("divide");
			CategoryManager categoryManager=new CategoryManager();
			CategoryInfo categoryInfo=new CategoryInfo();
			System.out.println(uri+"����������");
			
			if(divide.equals("parent")){
				String mainCategoryCode=request.getParameter("mainCategoryCode");
				String mainCategoryName=request.getParameter("mainCategoryName");
				
				categoryInfo.setCategoryCode(mainCategoryCode);
				categoryInfo.setCategoryName(mainCategoryName);
				categoryManager.setCategoryInfo(categoryInfo);
				
				if(categoryManager.reviseMainCategory(memberCode)){ //21�� memberCode
					System.out.println("mainī�װ� ��������");
				}
				System.out.println("-------mainī�װ� ��--------");
			}
			else{
				String subCategoryCode=request.getParameter("subCategoryCode");
				String subCategoryName=request.getParameter("subCategoryName");
				
				categoryInfo.setCategoryCode(subCategoryCode);
				categoryInfo.setCategoryName(subCategoryName);
				categoryManager.setCategoryInfo(categoryInfo);
				
				if(categoryManager.reviseSubCategory(memberCode)){ //21�� memberCode
					System.out.println("--------subī�װ� ��������------");
				}
				System.out.println("subī�װ� ��");
			}
			dispatchUrl="mem_mange_category.jsp";
		}
		
		RequestDispatcher view=request.getRequestDispatcher(dispatchUrl);
		view.forward(request, response);
	}
}
