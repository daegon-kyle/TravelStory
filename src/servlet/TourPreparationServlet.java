package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import form.TourPreparationRecommendInfoForm;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.GregorianCalendar;
import model.TourPreparationInfo;
import validator.TourPreparationRecommendInfoValidator;
import manager.TourPreparationInfoManager;
import model.PostingInfo;
import java.util.List;
import manager.PostingManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import gsonmodel.PostingInfoGson;
import gsonmodel.TourPreparationGson;
/**
 * Servlet implementation class TourPreparationSerlvet
 */
@WebServlet(name = "TourPreparation", urlPatterns = { "/page/TourPreparation", "/page/TourPreparationLike"})
/**
 * 사용자에게 여행준비물 추천서비스를 제공하는 클래스
 * @author 문정현
 *
 */
public class TourPreparationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 추천결과 목록을 가져오고, 좋아요 수를 올린다.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String uri=request.getRequestURI();
		System.out.println(uri);
		int lastIndex=uri.lastIndexOf("/");
		String action=uri.substring(lastIndex+1);
		PostingManager manager = new TourPreparationInfoManager();
		if(action.equals("TourPreparation")){
			String code = request.getParameter("postingCode");
			System.out.println(code);
		
			TourPreparationInfo info= (TourPreparationInfo)manager.check(code);
			TourPreparationGson gsonInfo = new TourPreparationGson(info.getWritingDate(), info.getWriterName(), info.getContent(), info.getPostingCode(), info.getPostingPurposeCode(), info.getLikeNum(), info.getTitle(), info.getCategoryCode(), info.getStartDate(), info.getEndDate(), info.getDestination1(), info.getDestination2());
			//Gson gson = new GsonBuilder().setPrettyPrinting().create();
			Gson gson = new Gson();
			response.setContentType("text/plain;charset=UTF-8");
			PrintWriter out = response.getWriter();
			String outString="";
			outString=gson.toJson(gsonInfo);
			System.out.println("json임 : "+outString);
			out.println(outString);
		}
		else if(action.equals("TourPreparationLike")){
			String code = request.getParameter("likeAdd");
			PostingInfo info = manager.addLikeNum(code);
			Gson gson = new Gson();
			response.setContentType("text/plain;charset=UTF-8");
			PrintWriter out = response.getWriter();
			String outString="";
			// 여기서 그냥 PostingInfo를 넣은 것은 jsp쪽에서 GregorianCalendar를 사용하지 않기 때문이다.
			outString=gson.toJson(info);
			out.println(outString);
		}
		//request.setAttribute("info", info);
		//dispatchUrl = "travelMaterialDetail.jsp";
		//request.getRequestDispatcher(dispatchUrl).forward(request, response);
	}

	/**
	 * TourPreparationInfo를 생성하고 TourPreparationInfoManager의 check()에 전달하고 호출한다. 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String destination1 = request.getParameter("destination1");
		String destination2 = request.getParameter("destination2");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		System.out.println(destination1+", "+destination2+", "+startDate+", "+endDate+", ");
		TourPreparationRecommendInfoForm info = new TourPreparationRecommendInfoForm(startDate, endDate, destination1, destination2);
		TourPreparationRecommendInfoValidator validator = new TourPreparationRecommendInfoValidator(info);
		List<String> error = validator.validate();
		if(error.size()!=0){
			System.out.println("다시 한번 보셈- 여행 준비물 추천");
		}
		else{
			StringTokenizer token1 = new StringTokenizer(startDate, "-");
			StringTokenizer token2 = new StringTokenizer(endDate, "-");
			GregorianCalendar start = new GregorianCalendar(Integer.parseInt((String)token1.nextElement()), Integer.parseInt((String)token1.nextElement())-1,Integer.parseInt((String)token1.nextElement()));
			GregorianCalendar end = new GregorianCalendar(Integer.parseInt((String)token2.nextElement()), Integer.parseInt((String)token2.nextElement())-1, Integer.parseInt((String)token2.nextElement()));
			TourPreparationInfo pre = new TourPreparationInfo(start, end, destination1, destination2);
			// 매니져 생성
			TourPreparationInfoManager manager = new TourPreparationInfoManager();
			List<PostingInfo> result = manager.check(pre);
			List<PostingInfoGson> gsonList = new ArrayList<PostingInfoGson>();
			if(result.size()!=0){// 추천 결과 있음
				for(PostingInfo temp : result){
					gsonList.add(new PostingInfoGson(temp.getWritingDate(), temp.getWriterName(), temp.getContent(), temp.getPostingCode(), temp.getPostingPurposeCode(), temp.getLikeNum(), temp.getTitle(), temp.getCategoryCode()));
				}
			}
			response.setContentType("text/plain;charset=utf-8");
			PrintWriter out = response.getWriter();
			Gson gson = new Gson();
			String str = gson.toJson(gsonList);
			System.out.println("gson임 : "+str);
			out.println(str);
		}
	}
}
