package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import form.TourPlanRecommendInfoForm;

import java.util.ArrayList;
import java.util.List;
import validator.TourPlanRecommendInfoValidator;
import manager.TourPlanManager;
import manager.PostingManager;
import model.LikingInfo;
import model.TourPlanInfo;
import model.PostingInfo;
import gsonmodel.PostingInfoGson;
import gsonmodel.TourPlanGson;
import com.google.gson.Gson;
/**
 * Servlet implementation class TourPlanServlet
 */
@WebServlet(name="TourPlan", urlPatterns = {"/page/TourPlan", "/page/likeUp"})
/**
 * 사용자에게 여행 일정을 추천해 주고, 상세보기를 제공하기 위한 클래스
 * @author 문정현
 *
 */
public class TourPlanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 특정 포스팅의 상세정보를 가져오거나 좋아요 수를 올려 준다.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		System.out.println(uri);
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);
		PostingManager manager = null;
		TourPlanInfo info =null;
		if(action.equals("TourPlan")){
			String code=request.getParameter("postingCode");  // 선택한 코드
			System.out.println(code);
			if(code!=null){  // 포스팅 상세보기 를 했을 경우
				System.out.println("한번만 나와야함");
				manager = new TourPlanManager();
				info = (TourPlanInfo)manager.check(code);
				System.out.println(info);
				TourPlanGson tour = new TourPlanGson(info.getWritingDate(), info.getWriterName(), info.getContent(), info.getPostingCode(), info.getPostingPurposeCode(), info.getLikeNum(), info.getTitle(), info.getCategoryCode(), info.getLikingInfo().getRestaurantPreference(), info.getLikingInfo().getHealingPreference(), info.getLikingInfo().getAttractionPreference(), info.getLikingInfo().getShoppingPreference(), info.getLikingInfo().getEtcPreference(), info.getDestination1(), info.getDestination2());
				Gson gson = new Gson();
				response.setContentType("text/plain;charset=UTF-8");
				PrintWriter out = response.getWriter();
				String str = gson.toJson(tour);
				System.out.println("json임 : "+str);
				out.println(str);
				//request.setAttribute("postingInfo", info);
				//dispatcherUrl="page/TourPlanDetail.jsp";
			}
		}
		else if(action.equals("likeUp")){
			String up = request.getParameter("likeAdd"); //좋아요를 올릴 포스팅의 코드
			System.out.println("TourPlanServlet의 8라인 종하용"+up);
			if(up!=null){ // 좋아요 수를 올릴 경우
				System.out.println("이제 좋아요 수를 올리자");
				manager = new TourPlanManager();
				info = (TourPlanInfo)manager.addLikeNum(up);
				System.out.println("갔다 왔음");
				Gson gson = new Gson();
				response.setContentType("text/plain;charset=UTF-8");
				PrintWriter out = response.getWriter();
				// 여기서 그냥 PostingInfo를 넣은 것은 jsp쪽에서 GregorianCalendar를 사용하지 않기 때문이다.
				String str = gson.toJson(info);
				out.println(str);
				//request.setAttribute("postingInfo", info);
				//dispatcherUrl="page/TourPlanDetail.jsp";
			}
		}
		//RequestDispatcher view=request.getRequestDispatcher(dispatcherUrl);
		//view.forward(request, response);
	}

	/**
	 * 사용자가 입력한 조건에 맞는 포스팅 목록을 가져온다
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String reNum =request.getParameter("restaurant");
		String hlNum = request.getParameter("healing");
		String atrtNum = request.getParameter("attraction");
		String shpNum = request.getParameter("shopping");
		String etcNum = request.getParameter("etcNum");
		String location1 = request.getParameter("destination1");
		String location2 =request.getParameter("destination2");
		
		System.out.println(reNum);
		System.out.println(hlNum);
		System.out.println(atrtNum);
		System.out.println(shpNum);
		System.out.println(etcNum);
		System.out.println(location1);
		System.out.println(location2);
		
		TourPlanRecommendInfoForm form = new TourPlanRecommendInfoForm(location1, location2, reNum, hlNum, atrtNum, shpNum, etcNum);
		
		TourPlanRecommendInfoValidator validator = new TourPlanRecommendInfoValidator(form);
		List<String> list = validator.validate();
		if(list.size()!=0) { // 오류가 나면
			System.out.println("다시 한번 보셈");
		}
		else{
			LikingInfo liking = new LikingInfo(Integer.parseInt(reNum), Integer.parseInt(hlNum), Integer.parseInt(atrtNum), Integer.parseInt(shpNum), Integer.parseInt(etcNum));
			TourPlanInfo plan = new TourPlanInfo(location1, location2, liking);
			TourPlanManager manager = new TourPlanManager();
			List<PostingInfo> recommend = manager.check(plan);
			System.out.println("서블릿 에서 : "+recommend);
			List<PostingInfoGson> gsonList = new ArrayList<PostingInfoGson>();
			for(PostingInfo temp : recommend){
				gsonList.add(new PostingInfoGson(temp.getWritingDate(), temp.getWriterName(), temp.getContent(), temp.getPostingCode(), temp.getPostingPurposeCode(), temp.getLikeNum(), temp.getTitle(), temp.getCategoryCode()));
			}
			response.setContentType("text/plain;charset=utf-8");
			PrintWriter out = response.getWriter();
			Gson gson = new Gson();
			String str = gson.toJson(gsonList);
			System.out.println("json임 : "+str);
			out.println(str);
		}

	}


}
