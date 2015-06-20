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
 * ����ڿ��� �����غ� ��õ���񽺸� �����ϴ� Ŭ����
 * @author ������
 *
 */
public class TourPreparationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * ��õ��� ����� ��������, ���ƿ� ���� �ø���.
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
			System.out.println("json�� : "+outString);
			out.println(outString);
		}
		else if(action.equals("TourPreparationLike")){
			String code = request.getParameter("likeAdd");
			PostingInfo info = manager.addLikeNum(code);
			Gson gson = new Gson();
			response.setContentType("text/plain;charset=UTF-8");
			PrintWriter out = response.getWriter();
			String outString="";
			// ���⼭ �׳� PostingInfo�� ���� ���� jsp�ʿ��� GregorianCalendar�� ������� �ʱ� �����̴�.
			outString=gson.toJson(info);
			out.println(outString);
		}
		//request.setAttribute("info", info);
		//dispatchUrl = "travelMaterialDetail.jsp";
		//request.getRequestDispatcher(dispatchUrl).forward(request, response);
	}

	/**
	 * TourPreparationInfo�� �����ϰ� TourPreparationInfoManager�� check()�� �����ϰ� ȣ���Ѵ�. 
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
			System.out.println("�ٽ� �ѹ� ����- ���� �غ� ��õ");
		}
		else{
			StringTokenizer token1 = new StringTokenizer(startDate, "-");
			StringTokenizer token2 = new StringTokenizer(endDate, "-");
			GregorianCalendar start = new GregorianCalendar(Integer.parseInt((String)token1.nextElement()), Integer.parseInt((String)token1.nextElement())-1,Integer.parseInt((String)token1.nextElement()));
			GregorianCalendar end = new GregorianCalendar(Integer.parseInt((String)token2.nextElement()), Integer.parseInt((String)token2.nextElement())-1, Integer.parseInt((String)token2.nextElement()));
			TourPreparationInfo pre = new TourPreparationInfo(start, end, destination1, destination2);
			// �Ŵ��� ����
			TourPreparationInfoManager manager = new TourPreparationInfoManager();
			List<PostingInfo> result = manager.check(pre);
			List<PostingInfoGson> gsonList = new ArrayList<PostingInfoGson>();
			if(result.size()!=0){// ��õ ��� ����
				for(PostingInfo temp : result){
					gsonList.add(new PostingInfoGson(temp.getWritingDate(), temp.getWriterName(), temp.getContent(), temp.getPostingCode(), temp.getPostingPurposeCode(), temp.getLikeNum(), temp.getTitle(), temp.getCategoryCode()));
				}
			}
			response.setContentType("text/plain;charset=utf-8");
			PrintWriter out = response.getWriter();
			Gson gson = new Gson();
			String str = gson.toJson(gsonList);
			System.out.println("gson�� : "+str);
			out.println(str);
		}
	}
}
