package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manager.CategoryManager;
import manager.PostingSearchManager;
import model.CategoryInfo;
import model.PostingInfo;

/**
 * 사용자가 입력한 키워드와 조건이 일치하는 포스팅을 검색하기 위해 사용하는 클래스
 * Servlet implementation class PostingSearchServlet
 */
@WebServlet(name="PostingSearchServlet", urlPatterns ={"/page/selfSearchPostingInManage", "/page/selfSearchPostingInBlog", "/page/totalSearchPosting"})

public class PostingSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 사용자가 입력한 키워드와 조건이 일치하는 포스팅을 검색하기 위해 사용하는 클래스
	 *  <br>PostingSearchManager의 검색메소드 호출 
	 * <br>메인페이지에서 검색 or 전체블로그에서 통합검색=본인의 회원코드와 검색키워드를 이용하여 searchPosting()호출 
	 * <br>제목 또는 내용으로 검색=검색키워드를 이용하여 searchPosting() 호출
	 *
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		//session에서 멤버코드 받아와야 한다.
		HttpSession session=request.getSession();
		String memberCode=(String)session.getAttribute("memberCode");
		
		String uri=request.getRequestURI();
		System.out.println(uri);
		int lastIndex=uri.lastIndexOf("/");
		String action=uri.substring(lastIndex+1);
		String dispatchUrl=null;
		if(action.equals("selfSearchPostingInManage")){	//포스팅 관리 화면에서 자기 포스팅 검색
			String keyword=request.getParameter("keyword");
			
			//포스팅 관리 화면 들어가기!
			//-------------------------------------------------------------------------------------------------------------------------------
			CategoryManager categoryManager=new CategoryManager();
			ArrayList<CategoryInfo> categoryList=(ArrayList<CategoryInfo>)categoryManager.selectCategorys(memberCode);	//전체 카테고리 목록
			
			ArrayList<CategoryInfo> subCategoryList=new ArrayList<CategoryInfo>();
			
			for(CategoryInfo tmp:categoryList){
				if(tmp.getCategoryDepth()==1)
					subCategoryList.add(tmp);
			}
			//-------------------------------------------------------------------------------------------------------------------------------
			
			PostingSearchManager postingSearchManager=new PostingSearchManager(keyword);
			ArrayList<PostingInfo> postingList=(ArrayList<PostingInfo>)postingSearchManager.searchPosting(memberCode);//memberCode세션에서 받아오기
			
			
			request.setAttribute("subCategoryList", subCategoryList);
			request.setAttribute("postingList", postingList);
			
			dispatchUrl="mem_mange_posting.jsp";
		}
		else if(action.equals("selfSearchPostingInBlog")){	//블로그 첫 화면에서 자기 포스팅 검색
			String keyword=request.getParameter("keyword");
			
			//포스팅 관리 화면 들어가기!
			//-------------------------------------------------------------------------------------------------------------------------------
			CategoryManager categoryManager=new CategoryManager();
			ArrayList<CategoryInfo> categoryList=(ArrayList<CategoryInfo>)categoryManager.selectCategorys(memberCode);	//전체 카테고리 목록
			
			ArrayList<CategoryInfo> subCategoryList=new ArrayList<CategoryInfo>();
			
			for(CategoryInfo tmp:categoryList){
				if(tmp.getCategoryDepth()==1)
					subCategoryList.add(tmp);
			}
			//-------------------------------------------------------------------------------------------------------------------------------
			
			PostingSearchManager postingSearchManager=new PostingSearchManager(keyword);
			ArrayList<PostingInfo> postingList=(ArrayList<PostingInfo>)postingSearchManager.searchPosting(memberCode);//memberCode세션에서 받아오기
			
			
			request.setAttribute("subCategoryList", subCategoryList);
			request.setAttribute("postingList", postingList);
			
			dispatchUrl="mainBlog.jsp";
		}
		else if(action.equals("totalSearchPosting")){
			String totalKeyword=request.getParameter("totalKeyword");
			
			dispatchUrl="mem_mange_posting.jsp";
		}
		RequestDispatcher view=request.getRequestDispatcher(dispatchUrl);
		view.forward(request, response);
	}

}
