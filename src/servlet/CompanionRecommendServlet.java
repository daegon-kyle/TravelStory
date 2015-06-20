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
 * ������ ��õ���񽺸� ��û�� ���, ����ڿ��� ��õ���񽺸� �����ϴ� ����
 * Servlet implementation class CompanionRecommendServlet
 */
@WebServlet(name="CompanionRecommend", urlPatterns = {"/page/CompanionRecommend"})
public class CompanionRecommendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * ������ ��õ�������� ����
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
			String postingCode = request.getParameter("postingCode");
			System.out.println("������ ã�⿡�� ������ �ڵ� : "+postingCode);
			CompanionRecommendInfoManager manager = new CompanionRecommendInfoManager();
			CompanionRecommendInfo model =  (CompanionRecommendInfo)manager.check(postingCode);  // ���� �޾ƿ�
			CompanionRecommendGson gsonModel = new CompanionRecommendGson(model.getWritingDate(), model.getWriterName(), model.getContent(), model.getPostingCode(), model.getPostingPurposeCode(), model.getLikeNum(), model.getTitle(), model.getCategoryCode(), model.getReliability(), model.getOtherGender(), model.getOtherAge(), model.getDestination1(), model.getDestination2(), model.getStartDate(), model.getEndDate());
			Gson gson = new Gson();
			response.setContentType("text/plain;charset=UTF-8");
			PrintWriter out = response.getWriter();
			String str = gson.toJson(gsonModel);
			System.out.println("���� ������ gson "+str);
			out.println(str);
	}

	/**
	 * ������ ��õ��� ���� �� �󼼺��� ���� ����<br>
	 * ��õ��� : CompanionRecommendManager�� check �޼ҵ带 ȣ���Ͽ� ��� �����޴´�.<br>
	 * �󼼺��� ���� : PostingManager�� check�޼ҵ� ȣ��
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
		System.out.println("��������..."+destination1+", "+destination2+", "+startDate+", "+endDate+", "+gender+", "+age);
		CompanionRecommendInfoForm form = new CompanionRecommendInfoForm(gender, destination1, destination2, startDate, endDate, age);
		// ��ȿ�� �˻� ����
		CompanionRecommendInfoValidator validator = new CompanionRecommendInfoValidator(form);
		List<String> error = validator.validate();
		if(error.size()!=0){//���� ����
			System.out.println("�Է°� Ȯ���ϼ�");
		}
		else{
			ConvertGregorianCalendar convert = new ConvertGregorianCalendar();
			CompanionRecommendInfo condition = new CompanionRecommendInfo(destination1, destination2, gender, Integer.parseInt(age), convert.convert(startDate), convert.convert(endDate));
			// �Ŵ��� ����
			CompanionRecommendInfoManager manager = new CompanionRecommendInfoManager();
			List<PostingInfo> info = manager.check(condition);
			List<PostingInfoGson> gsonInfo = new ArrayList<PostingInfoGson>();
			for(PostingInfo temp : info){
				gsonInfo.add(new PostingInfoGson(temp.getWritingDate(), temp.getWriterName(), temp.getContent(), temp.getPostingCode(), temp.getPostingPurposeCode(), temp.getLikeNum(), temp.getTitle(), temp.getCategoryCode()));
			}
			
			System.out.println("�������� ��� ���� �� : "+info);
			response.setContentType("text/plain;charset=UTF-8");
			PrintWriter out = response.getWriter();
			Gson gson = new Gson();
			String str = gson.toJson(gsonInfo);
			System.out.println(str);
			out.println(str);
		}
	}

}
