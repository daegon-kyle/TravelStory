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
 * 포스팅 수정하기 위해 사용하는 클래스
 * Servlet implementation class PostingReviseServlet
 */
@WebServlet(name="PostingReviseServlet", urlPatterns ={"/page/postingRevise", "/page/posting_revise_fake.jsp"})
public class PostingReviseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 포스팅을 선택했을 때 포스팅 목적코드와 포스팅 코드를 가지고 수정페이지 요청
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		if(action.equals("posting_revise_fake.jsp")){
			System.out.println("포스팅 수정 하기 전, 포스팅 정보 세팅해두기!");
			
			//포스팅 코드 속성 추가
			//-------------------------------------------------------------------------------------------------------------------------------
			String postingCode=request.getParameter("postingCode");
			System.out.println("포스팅 코드:"+postingCode);
			
			request.setAttribute("postingCode", postingCode);
			//포스팅 목적 코드 속성으로 지정!
			//-------------------------------------------------------------------------------------------------------------------------------
			PostingManager postingManager=new PostingManager();
			PostingInfo postingInfo=postingManager.check(postingCode);
			String postingPurposeCode=postingInfo.getPostingPurposeCode();
			System.out.println("목적코드:"+postingPurposeCode);
			
			request.setAttribute("postingPurposeCode", postingPurposeCode);
			//포스팅 관리 화면 들어가기!
			//-------------------------------------------------------------------------------------------------------------------------------
			CategoryManager categoryManager=new CategoryManager();
			ArrayList<CategoryInfo> categoryList=(ArrayList<CategoryInfo>)categoryManager.selectCategorys(memberCode);	//전체 카테고리 목록
			
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
	 * 포스팅코드, 포스팅목적코드, 수정내용을 DB에 저장
	 * <br>포스팅 목적에 따라 PostingReviseManager의 메소드 호출 
		<br>여행일정 : reviseTourPlanPosting() 
		<br>여행준비물 : reviseTourPreparationPosting()
		<br>동행자구하기 : reviseCompanionPosting()
		<br>일반글 : revisePosting()

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
		
		if(action.equals("postingRevise")){
			String postingPurposeCode=request.getParameter("categoryPurposeCode");
			String postingCode=request.getParameter("postingCode");
			System.out.println("포스팅목적코드 : "+postingPurposeCode);
			System.out.println("포스팅코드 : "+postingCode);
			
			String title="";
			String content="";
			String categoryCode=request.getParameter("subCategoryCode");
			
			if(postingPurposeCode.equals("1")){//여행일정
				//여행일정에 맞는 파라미터 값들 반환해오기
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
				
				if(postingReviseManager.reviseTourPlanPosting(memberCode)!=null)	//memberCode집어넣기
					System.out.println("여행일정 수정 성공");
				else
					System.out.println("여행일정 수정 실패");
				
				dispatchUrl="mem_mange_posting.jsp";
			}
			else if(postingPurposeCode.equals("2")){//여행준비물
				title=request.getParameter("tourPreparationTitle");
				content=request.getParameter("tourPreparationContent");
				String destination1=request.getParameter("widget1");
				String destination2=request.getParameter("widget3");
				String start=request.getParameter("start");
				String end=request.getParameter("end");
				System.out.println(start);	//2014-07-02
				
				//string으로 변환시켜주는 메소드! 나중에 잘쓴다 ^^
				//ConvertGregorianCalendar convert=new ConvertGregorianCalendar();
				//String startDate=convert.convert(new GregorianCalendar(Integer.parseInt(start.substring(0, 4)), Integer.parseInt(start.substring(5,7))-1, Integer.parseInt(start.substring(8,10))));
				//String endDate=convert.convert(new GregorianCalendar(Integer.parseInt(end.substring(0, 4)), Integer.parseInt(end.substring(5,7))-1, Integer.parseInt(end.substring(8,10))));

				TourPreparationInfo tourPreparationInfo=new TourPreparationInfo(content, postingPurposeCode, title, categoryCode, new GregorianCalendar(Integer.parseInt(start.substring(0, 4)), Integer.parseInt(start.substring(5,7))-1, Integer.parseInt(start.substring(8,10))), new GregorianCalendar(Integer.parseInt(end.substring(0, 4)), Integer.parseInt(end.substring(5,7))-1, Integer.parseInt(end.substring(8,10))), destination1, destination2);
				tourPreparationInfo.setPostingCode(postingCode);
				PostingReviseManager postingReviseManager=new PostingReviseManager();
				postingReviseManager.setTourPreparationInfo(tourPreparationInfo);
				if( postingReviseManager.reviseTourPreparationPosting(memberCode) != null)	//memberCode를 넣을것!
					System.out.println("여행준비물 수정 성공");
				else
					System.out.println("여행준비물 수정 실패");
				
				dispatchUrl="mem_mange_posting.jsp";
			}
			else if(postingPurposeCode.equals("3")){//동행자 추천
				title=request.getParameter("companionTitle");
				content=request.getParameter("companionContent");
				String destination1=request.getParameter("widget1");
				String destination2=request.getParameter("widget3");
				String start=request.getParameter("start2");
				String end=request.getParameter("end2");
				String gender=request.getParameter("gender");
				if(gender.equals("female"))
					gender="여";
				else
					gender="남";
				System.out.println(gender);
				int age=Integer.parseInt(request.getParameter("age"));
				
				CompanionRecommendInfo companionRecommendInfo=new CompanionRecommendInfo(content, postingPurposeCode, title, categoryCode, gender, age, destination1, destination2, new GregorianCalendar(Integer.parseInt(start.substring(0, 4)), Integer.parseInt(start.substring(5,7))-1, Integer.parseInt(start.substring(8,10))), new GregorianCalendar(Integer.parseInt(end.substring(0, 4)), Integer.parseInt(end.substring(5,7))-1, Integer.parseInt(end.substring(8,10)) ));
				companionRecommendInfo.setPostingCode(postingCode);
				PostingReviseManager postingReviseManager=new PostingReviseManager();
				postingReviseManager.setCompanionRecommendInfo(companionRecommendInfo);
				
				if(postingReviseManager.reviseCompanionPosting(memberCode)!=null)	//21은 멤버코드
					System.out.println("동행자 추천 성공");
				else
					System.out.println("동행자 추천 실패");
				
				dispatchUrl="mem_mange_posting.jsp";
			}
			else if(postingPurposeCode.equals("4")){//일반글
				title=request.getParameter("etcTitle");
				content=request.getParameter("etcContent");
				
				PostingInfo postingInfo=new PostingInfo(content, postingPurposeCode, title, categoryCode);
				postingInfo.setPostingCode(postingCode);
				
				PostingReviseManager postingReviseManager=new PostingReviseManager();
				postingReviseManager.setPostingInfo(postingInfo);
								
				if(postingReviseManager.revisePosting(memberCode) != null)//21은 멤버코드
					System.out.println("일반글 포스팅 성공^^");
				dispatchUrl="mem_mange_posting.jsp";
			}
		}
	RequestDispatcher view=request.getRequestDispatcher(dispatchUrl);
	view.forward(request, response);
	}

}
