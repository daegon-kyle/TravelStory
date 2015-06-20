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
 * ����ڿ��� ���� ������ ��õ�� �ְ�, �󼼺��⸦ �����ϱ� ���� Ŭ����
 * @author ������
 *
 */
public class TourPlanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Ư�� �������� �������� �������ų� ���ƿ� ���� �÷� �ش�.
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
			String code=request.getParameter("postingCode");  // ������ �ڵ�
			System.out.println(code);
			if(code!=null){  // ������ �󼼺��� �� ���� ���
				System.out.println("�ѹ��� ���;���");
				manager = new TourPlanManager();
				info = (TourPlanInfo)manager.check(code);
				System.out.println(info);
				TourPlanGson tour = new TourPlanGson(info.getWritingDate(), info.getWriterName(), info.getContent(), info.getPostingCode(), info.getPostingPurposeCode(), info.getLikeNum(), info.getTitle(), info.getCategoryCode(), info.getLikingInfo().getRestaurantPreference(), info.getLikingInfo().getHealingPreference(), info.getLikingInfo().getAttractionPreference(), info.getLikingInfo().getShoppingPreference(), info.getLikingInfo().getEtcPreference(), info.getDestination1(), info.getDestination2());
				Gson gson = new Gson();
				response.setContentType("text/plain;charset=UTF-8");
				PrintWriter out = response.getWriter();
				String str = gson.toJson(tour);
				System.out.println("json�� : "+str);
				out.println(str);
				//request.setAttribute("postingInfo", info);
				//dispatcherUrl="page/TourPlanDetail.jsp";
			}
		}
		else if(action.equals("likeUp")){
			String up = request.getParameter("likeAdd"); //���ƿ並 �ø� �������� �ڵ�
			System.out.println("TourPlanServlet�� 8���� ���Ͽ�"+up);
			if(up!=null){ // ���ƿ� ���� �ø� ���
				System.out.println("���� ���ƿ� ���� �ø���");
				manager = new TourPlanManager();
				info = (TourPlanInfo)manager.addLikeNum(up);
				System.out.println("���� ����");
				Gson gson = new Gson();
				response.setContentType("text/plain;charset=UTF-8");
				PrintWriter out = response.getWriter();
				// ���⼭ �׳� PostingInfo�� ���� ���� jsp�ʿ��� GregorianCalendar�� ������� �ʱ� �����̴�.
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
	 * ����ڰ� �Է��� ���ǿ� �´� ������ ����� �����´�
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
		if(list.size()!=0) { // ������ ����
			System.out.println("�ٽ� �ѹ� ����");
		}
		else{
			LikingInfo liking = new LikingInfo(Integer.parseInt(reNum), Integer.parseInt(hlNum), Integer.parseInt(atrtNum), Integer.parseInt(shpNum), Integer.parseInt(etcNum));
			TourPlanInfo plan = new TourPlanInfo(location1, location2, liking);
			TourPlanManager manager = new TourPlanManager();
			List<PostingInfo> recommend = manager.check(plan);
			System.out.println("���� ���� : "+recommend);
			List<PostingInfoGson> gsonList = new ArrayList<PostingInfoGson>();
			for(PostingInfo temp : recommend){
				gsonList.add(new PostingInfoGson(temp.getWritingDate(), temp.getWriterName(), temp.getContent(), temp.getPostingCode(), temp.getPostingPurposeCode(), temp.getLikeNum(), temp.getTitle(), temp.getCategoryCode()));
			}
			response.setContentType("text/plain;charset=utf-8");
			PrintWriter out = response.getWriter();
			Gson gson = new Gson();
			String str = gson.toJson(gsonList);
			System.out.println("json�� : "+str);
			out.println(str);
		}

	}


}
