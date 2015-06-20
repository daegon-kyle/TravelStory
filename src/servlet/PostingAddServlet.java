package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import converter.ConvertGregorianCalendar;

import manager.CategoryManager;
import manager.PostingAddManager;
import manager.PostingSearchManager;
import model.CategoryInfo;
import model.CompanionRecommendInfo;
import model.LikingInfo;
import model.PostingInfo;
import model.TourPlanInfo;
import model.TourPreparationInfo;

/**
 * ������ �߰��ϱ� ���� ����ϴ� ����
 * Servlet implementation class PostingAddServlet
 */
@WebServlet(name="PostingAddServlet", urlPatterns = {"/page/mem_mange_posting_fake.jsp","/page/postingAdd", "/page/posting_add_fake.jsp"})
public class PostingAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * ������ ���� �߰��ϱ� ���� ���
	 * <Br>������ ������ ���� PostingAddManager�� �޼ҵ�ȣ�� 
		<Br>�������� : addTourPlanPosting() 
		<Br>�����غ� : addTourPreparationPosting()
		<Br>�����ڱ��ϱ� : addCompanionPosting()
		<Br>�Ϲݱ� : addPosting()

	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		if(action.equals("mem_mange_posting_fake.jsp")){
			System.out.println("������ ���� ���� ��, �����صα�");
			
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
			
			PostingSearchManager postingSearchManager=new PostingSearchManager("");
			ArrayList<PostingInfo> postingList=(ArrayList<PostingInfo>)postingSearchManager.searchPosting(memberCode);//memberCode���ǿ��� �޾ƿ���
			
			request.setAttribute("subCategoryList", subCategoryList);
			request.setAttribute("postingList", postingList);
			
			for(PostingInfo tmp : postingList){
				System.out.println(tmp.getTitle());
			}
			dispatchUrl="mem_mange_posting.jsp";
		}
		else if(action.equals("posting_add_fake.jsp")){
			System.out.println("������ �߰� �ϱ� ��, ������ ���� �����صα�!");
			
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
			
			request.setAttribute("subCategoryList", subCategoryList);
			
			dispatchUrl="posting_add.jsp";
		}
		RequestDispatcher view=request.getRequestDispatcher(dispatchUrl);
		view.forward(request, response);
	}
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
		
		if(action.equals("postingAdd")){
			String postingPurposeCode=request.getParameter("categoryPurposeCode");
			System.out.println("�����ڵ� : "+postingPurposeCode);
			
			String title="";
			String content="";
			String categoryCode=request.getParameter("subCategoryCode");
			
			if(postingPurposeCode.equals("1")){//��������
				//���������� �´� �Ķ���� ���� ��ȯ�ؿ���
				title=request.getParameter("tourPlanTitle");
				content=request.getParameter("tourPlanContent");
				String destination1=request.getParameter("widget1");
				String destination2=request.getParameter("widget3");
				int rstrNum=Integer.parseInt(request.getParameter("rstrNum"));
				int hlNum=Integer.parseInt(request.getParameter("hlNum"));
				int atrtNum=Integer.parseInt(request.getParameter("atrtNum"));
				int shpNum=Integer.parseInt(request.getParameter("shpNum"));
				int etcNum=Integer.parseInt(request.getParameter("etcNum"));
				
				System.out.println("������ ��ȣ���� :"+rstrNum+hlNum+atrtNum+shpNum+etcNum);
				
				LikingInfo likingInfo=new LikingInfo(rstrNum, hlNum, atrtNum, shpNum, etcNum);
				TourPlanInfo tourPlanInfo=new TourPlanInfo(title, content, postingPurposeCode, categoryCode, destination1, destination2, likingInfo);
				
				PostingAddManager postingAddManager=new PostingAddManager();
				postingAddManager.setTourPlan(tourPlanInfo);	
				if( postingAddManager.addTourPlanPosting(memberCode) != null )//21�� ����ڵ�
					System.out.println("�������� ����^^");
				
				dispatchUrl="mem_mange_posting.jsp";
			}
			else if(postingPurposeCode.equals("2")){//�����غ�
				title=request.getParameter("tourPreparationTitle");
				content=request.getParameter("tourPreparationContent");
				String destination1=request.getParameter("widget1");
				String destination2=request.getParameter("widget3");
				String start=request.getParameter("start");
				String end=request.getParameter("end");
				System.out.println(start);	//2014-07-02
				
				//string���� ��ȯ�����ִ� �޼ҵ�! ���߿� �߾��� ^^
				//ConvertGregorianCalendar convert=new ConvertGregorianCalendar();
				//String startDate=convert.convert(new GregorianCalendar(Integer.parseInt(start.substring(0, 4)), Integer.parseInt(start.substring(5,7))-1, Integer.parseInt(start.substring(8,10))));
				//String endDate=convert.convert(new GregorianCalendar(Integer.parseInt(end.substring(0, 4)), Integer.parseInt(end.substring(5,7))-1, Integer.parseInt(end.substring(8,10))));

				TourPreparationInfo tourPreparationInfo=new TourPreparationInfo(content, postingPurposeCode, title, categoryCode, new GregorianCalendar(Integer.parseInt(start.substring(0, 4)), Integer.parseInt(start.substring(5,7))-1, Integer.parseInt(start.substring(8,10))), new GregorianCalendar(Integer.parseInt(end.substring(0, 4)), Integer.parseInt(end.substring(5,7))-1, Integer.parseInt(end.substring(8,10))), destination1, destination2);
				PostingAddManager postingAddManager=new PostingAddManager();
				postingAddManager.setTourPreparationInfo(tourPreparationInfo);	
				
				if( postingAddManager.addTourPreparationPosting(memberCode) != null )//21�� ����ڵ�
					System.out.println("���� �غ� ����^^");
				
				dispatchUrl="mem_mange_posting.jsp";
			}
			else if(postingPurposeCode.equals("3")){//������ ��õ
				title=request.getParameter("companionTitle");
				content=request.getParameter("companionContent");
				String destination1=request.getParameter("widget1");
				String destination2=request.getParameter("widget3");
				String start=request.getParameter("start2");
				String end=request.getParameter("end2");
				String gender=request.getParameter("gender");
				if(gender.equals("female"))
					gender="��";
				else
					gender="��";
				System.out.println(gender);
				int age=Integer.parseInt(request.getParameter("age"));
				
				CompanionRecommendInfo companionRecommendInfo=new CompanionRecommendInfo(content, postingPurposeCode, title, categoryCode, gender, age, destination1, destination2, new GregorianCalendar(Integer.parseInt(start.substring(0, 4)), Integer.parseInt(start.substring(5,7))-1, Integer.parseInt(start.substring(8,10))), new GregorianCalendar(Integer.parseInt(end.substring(0, 4)), Integer.parseInt(end.substring(5,7))-1, Integer.parseInt(end.substring(8,10)) ));
				
				PostingAddManager postingAddManager=new PostingAddManager();
				postingAddManager.setCompanionRecommendInfo(companionRecommendInfo);
				
				if(postingAddManager.addCompanionPosting(memberCode) != null)//21�� ����ڵ�
					System.out.println("��õ�� ������ ����^^");
				
				dispatchUrl="mem_mange_posting.jsp";
			}
			else if(postingPurposeCode.equals("4")){//�Ϲݱ�
				title=request.getParameter("etcTitle");
				content=request.getParameter("etcContent");
				
				PostingInfo postingInfo=new PostingInfo(content, postingPurposeCode, title, categoryCode);
				
				PostingAddManager postingAddManager=new PostingAddManager();
				postingAddManager.setPostingInfo(postingInfo);
				
				if(postingAddManager.addPosting(memberCode) != null)//21�� ����ڵ�
					System.out.println("�Ϲݱ� ������ ����^^");
				dispatchUrl="mem_mange_posting.jsp";
			}
			
			dispatchUrl="mem_mange_posting.jsp";
		}
		RequestDispatcher view=request.getRequestDispatcher(dispatchUrl);
		view.forward(request, response);
	}

}
