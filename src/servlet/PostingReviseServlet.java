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

import manager.CategoryManager;
import manager.PostingAddManager;
import manager.PostingManager;
import manager.PostingReviseManager;
import model.CategoryInfo;
import model.CompanionRecommendInfo;
import model.LikingInfo;
import model.PostingInfo;
import model.TourPlanInfo;
import model.TourPreparationInfo;

/**
 * ������ �����ϱ� ���� ����ϴ� Ŭ����
 * Servlet implementation class PostingReviseServlet
 */
@WebServlet(name="PostingReviseServlet", urlPatterns ={"/page/postingRevise", "/page/posting_revise_fake.jsp"})
public class PostingReviseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * �������� �������� �� ������ �����ڵ�� ������ �ڵ带 ������ ���������� ��û
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
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
		
		if(action.equals("posting_revise_fake.jsp")){
			System.out.println("������ ���� �ϱ� ��, ������ ���� �����صα�!");
			
			//������ �ڵ� �Ӽ� �߰�
			//-------------------------------------------------------------------------------------------------------------------------------
			String postingCode=request.getParameter("postingCode");
			System.out.println("������ �ڵ�:"+postingCode);
			
			request.setAttribute("postingCode", postingCode);
			//������ ���� �ڵ� �Ӽ����� ����!
			//-------------------------------------------------------------------------------------------------------------------------------
			PostingManager postingManager=new PostingManager();
			PostingInfo postingInfo=postingManager.check(postingCode);
			String postingPurposeCode=postingInfo.getPostingPurposeCode();
			System.out.println("�����ڵ�:"+postingPurposeCode);
			
			request.setAttribute("postingPurposeCode", postingPurposeCode);
			//������ ���� ȭ�� ����!
			//-------------------------------------------------------------------------------------------------------------------------------
			CategoryManager categoryManager=new CategoryManager();
			ArrayList<CategoryInfo> categoryList=(ArrayList<CategoryInfo>)categoryManager.selectCategorys(memberCode);	//��ü ī�װ� ���
			
			ArrayList<CategoryInfo> subCategoryList=new ArrayList<CategoryInfo>();
			
			for(CategoryInfo tmp:categoryList){
				if(tmp.getCategoryDepth()==1){
					subCategoryList.add(tmp);
				}
			}
			request.setAttribute("subCategoryList", subCategoryList);
			//-------------------------------------------------------------------------------------------------------------------------------
			dispatchUrl="posting_revise.jsp";
		}
		
		RequestDispatcher view=request.getRequestDispatcher(dispatchUrl);
		view.forward(request, response);
	}

	/**
	 * �������ڵ�, �����ø����ڵ�, ���������� DB�� ����
	 * <br>������ ������ ���� PostingReviseManager�� �޼ҵ� ȣ�� 
		<br>�������� : reviseTourPlanPosting() 
		<br>�����غ� : reviseTourPreparationPosting()
		<br>�����ڱ��ϱ� : reviseCompanionPosting()
		<br>�Ϲݱ� : revisePosting()

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
		
		if(action.equals("postingRevise")){
			String postingPurposeCode=request.getParameter("categoryPurposeCode");
			String postingCode=request.getParameter("postingCode");
			System.out.println("�����ø����ڵ� : "+postingPurposeCode);
			System.out.println("�������ڵ� : "+postingCode);
			
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
				
				LikingInfo likingInfo=new LikingInfo(rstrNum, hlNum, atrtNum, shpNum, etcNum);
				TourPlanInfo tourPlanInfo=new TourPlanInfo(title, content, postingPurposeCode, categoryCode, destination1, destination2, likingInfo);
				tourPlanInfo.setPostingCode(postingCode);
				
				PostingReviseManager postingReviseManager=new PostingReviseManager();
				postingReviseManager.setTourPlan(tourPlanInfo);
				
				if(postingReviseManager.reviseTourPlanPosting(memberCode)!=null)	//memberCode����ֱ�
					System.out.println("�������� ���� ����");
				else
					System.out.println("�������� ���� ����");
				
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
				tourPreparationInfo.setPostingCode(postingCode);
				PostingReviseManager postingReviseManager=new PostingReviseManager();
				postingReviseManager.setTourPreparationInfo(tourPreparationInfo);
				if( postingReviseManager.reviseTourPreparationPosting(memberCode) != null)	//memberCode�� ������!
					System.out.println("�����غ� ���� ����");
				else
					System.out.println("�����غ� ���� ����");
				
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
				companionRecommendInfo.setPostingCode(postingCode);
				PostingReviseManager postingReviseManager=new PostingReviseManager();
				postingReviseManager.setCompanionRecommendInfo(companionRecommendInfo);
				
				if(postingReviseManager.reviseCompanionPosting(memberCode)!=null)	//21�� ����ڵ�
					System.out.println("������ ��õ ����");
				else
					System.out.println("������ ��õ ����");
				
				dispatchUrl="mem_mange_posting.jsp";
			}
			else if(postingPurposeCode.equals("4")){//�Ϲݱ�
				title=request.getParameter("etcTitle");
				content=request.getParameter("etcContent");
				
				PostingInfo postingInfo=new PostingInfo(content, postingPurposeCode, title, categoryCode);
				postingInfo.setPostingCode(postingCode);
				
				PostingReviseManager postingReviseManager=new PostingReviseManager();
				postingReviseManager.setPostingInfo(postingInfo);
								
				if(postingReviseManager.revisePosting(memberCode) != null)//21�� ����ڵ�
					System.out.println("�Ϲݱ� ������ ����^^");
				dispatchUrl="mem_mange_posting.jsp";
			}
		}
	RequestDispatcher view=request.getRequestDispatcher(dispatchUrl);
	view.forward(request, response);
	}

}
