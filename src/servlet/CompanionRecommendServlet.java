package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import form.CompanionRecommendInfoForm;
import model.CompanionRecommendInfo;
import model.PostingInfo;
import validator.CompanionRecommendInfoValidator;
import converter.ConvertGregorianCalendar;
import manager.CompanionRecommendInfoManager;
import com.google.gson.Gson;
import java.io.PrintWriter;
import gsonmodel.PostingInfoGson;
import gsonmodel.CompanionRecommendGson;
/**
 * 동행자 추천서비스를 요청한 경우, 사용자에게 추천서비스를 제공하는 서블릿
 * Servlet implementation class CompanionRecommendServlet
 */
@WebServlet(name="CompanionRecommend", urlPatterns = {"/page/CompanionRecommend"})
public class CompanionRecommendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 동행자 추천페이지를 제공
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
			String postingCode = request.getParameter("postingCode");
			System.out.println("동행자 찾기에서 포스팅 코드 : "+postingCode);
			CompanionRecommendInfoManager manager = new CompanionRecommendInfoManager();
			CompanionRecommendInfo model =  (CompanionRecommendInfo)manager.check(postingCode);  // 정보 받아옴
			CompanionRecommendGson gsonModel = new CompanionRecommendGson(model.getWritingDate(), model.getWriterName(), model.getContent(), model.getPostingCode(), model.getPostingPurposeCode(), model.getLikeNum(), model.getTitle(), model.getCategoryCode(), model.getReliability(), model.getOtherGender(), model.getOtherAge(), model.getDestination1(), model.getDestination2(), model.getStartDate(), model.getEndDate());
			Gson gson = new Gson();
			response.setContentType("text/plain;charset=UTF-8");
			PrintWriter out = response.getWriter();
			String str = gson.toJson(gsonModel);
			System.out.println("서블릿 에서의 gson "+str);
			out.println(str);
	}

	/**
	 * 동행자 추천목록 제공 및 상세보기 정보 제공<br>
	 * 추천목록 : CompanionRecommendManager의 check 메소드를 호출하여 목록 제공받는다.<br>
	 * 상세보기 제공 : PostingManager의 check메소드 호출
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String destination1 = request.getParameter("destination1");
		String destination2 = request.getParameter("destination2");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String gender = request.getParameter("otherGender");
		String age = request.getParameter("otherAge");
		System.out.println("서블릿에서..."+destination1+", "+destination2+", "+startDate+", "+endDate+", "+gender+", "+age);
		CompanionRecommendInfoForm form = new CompanionRecommendInfoForm(gender, destination1, destination2, startDate, endDate, age);
		// 유효성 검사 시작
		CompanionRecommendInfoValidator validator = new CompanionRecommendInfoValidator(form);
		List<String> error = validator.validate();
		if(error.size()!=0){//에러 있음
			System.out.println("입력값 확인하셈");
		}
		else{
			ConvertGregorianCalendar convert = new ConvertGregorianCalendar();
			CompanionRecommendInfo condition = new CompanionRecommendInfo(destination1, destination2, gender, Integer.parseInt(age), convert.convert(startDate), convert.convert(endDate));
			// 매니져 생성
			CompanionRecommendInfoManager manager = new CompanionRecommendInfoManager();
			List<PostingInfo> info = manager.check(condition);
			List<PostingInfoGson> gsonInfo = new ArrayList<PostingInfoGson>();
			for(PostingInfo temp : info){
				gsonInfo.add(new PostingInfoGson(temp.getWritingDate(), temp.getWriterName(), temp.getContent(), temp.getPostingCode(), temp.getPostingPurposeCode(), temp.getLikeNum(), temp.getTitle(), temp.getCategoryCode()));
			}
			
			System.out.println("서블릿에서 결과 받은 것 : "+info);
			response.setContentType("text/plain;charset=UTF-8");
			PrintWriter out = response.getWriter();
			Gson gson = new Gson();
			String str = gson.toJson(gsonInfo);
			System.out.println(str);
			out.println(str);
		}
	}

}
