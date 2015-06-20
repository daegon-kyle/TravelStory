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
 * ����ڰ� �Է��� Ű����� ������ ��ġ�ϴ� �������� �˻��ϱ� ���� ����ϴ� Ŭ����
 * Servlet implementation class PostingSearchServlet
 */
@WebServlet(name="PostingSearchServlet", urlPatterns ={"/page/selfSearchPostingInManage", "/page/selfSearchPostingInBlog", "/page/totalSearchPosting"})

public class PostingSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * ����ڰ� �Է��� Ű����� ������ ��ġ�ϴ� �������� �˻��ϱ� ���� ����ϴ� Ŭ����
	 *  <br>PostingSearchManager�� �˻��޼ҵ� ȣ�� 
	 * <br>�������������� �˻� or ��ü��α׿��� ���հ˻�=������ ȸ���ڵ�� �˻�Ű���带 �̿��Ͽ� searchPosting()ȣ�� 
	 * <br>���� �Ǵ� �������� �˻�=�˻�Ű���带 �̿��Ͽ� searchPosting() ȣ��
	 *
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		//session���� ����ڵ� �޾ƿ;� �Ѵ�.
		HttpSession session=request.getSession();
		String memberCode=(String)session.getAttribute("memberCode");
		
		String uri=request.getRequestURI();
		System.out.println(uri);
		int lastIndex=uri.lastIndexOf("/");
		String action=uri.substring(lastIndex+1);
		String dispatchUrl=null;
		if(action.equals("selfSearchPostingInManage")){	//������ ���� ȭ�鿡�� �ڱ� ������ �˻�
			String keyword=request.getParameter("keyword");
			
			//������ ���� ȭ�� ����!
			//-------------------------------------------------------------------------------------------------------------------------------
			CategoryManager categoryManager=new CategoryManager();
			ArrayList<CategoryInfo> categoryList=(ArrayList<CategoryInfo>)categoryManager.selectCategorys(memberCode);	//��ü ī�װ� ���
			
			ArrayList<CategoryInfo> subCategoryList=new ArrayList<CategoryInfo>();
			
			for(CategoryInfo tmp:categoryList){
				if(tmp.getCategoryDepth()==1)
					subCategoryList.add(tmp);
			}
			//-------------------------------------------------------------------------------------------------------------------------------
			
			PostingSearchManager postingSearchManager=new PostingSearchManager(keyword);
			ArrayList<PostingInfo> postingList=(ArrayList<PostingInfo>)postingSearchManager.searchPosting(memberCode);//memberCode���ǿ��� �޾ƿ���
			
			
			request.setAttribute("subCategoryList", subCategoryList);
			request.setAttribute("postingList", postingList);
			
			dispatchUrl="mem_mange_posting.jsp";
		}
		else if(action.equals("selfSearchPostingInBlog")){	//��α� ù ȭ�鿡�� �ڱ� ������ �˻�
			String keyword=request.getParameter("keyword");
			
			//������ ���� ȭ�� ����!
			//-------------------------------------------------------------------------------------------------------------------------------
			CategoryManager categoryManager=new CategoryManager();
			ArrayList<CategoryInfo> categoryList=(ArrayList<CategoryInfo>)categoryManager.selectCategorys(memberCode);	//��ü ī�װ� ���
			
			ArrayList<CategoryInfo> subCategoryList=new ArrayList<CategoryInfo>();
			
			for(CategoryInfo tmp:categoryList){
				if(tmp.getCategoryDepth()==1)
					subCategoryList.add(tmp);
			}
			//-------------------------------------------------------------------------------------------------------------------------------
			
			PostingSearchManager postingSearchManager=new PostingSearchManager(keyword);
			ArrayList<PostingInfo> postingList=(ArrayList<PostingInfo>)postingSearchManager.searchPosting(memberCode);//memberCode���ǿ��� �޾ƿ���
			
			
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
