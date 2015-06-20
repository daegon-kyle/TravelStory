package servlet;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import form.MemberInfoForm;
import model.MemberInfo;
import manager.MemberJoinManager;
import validator.MemberInfoValidator;
import java.util.List;
import converter.ConvertGregorianCalendar;
import java.util.StringTokenizer;
/**
 * Servlet implementation class MemberJoinServlet
 */
@WebServlet(name="MemberJoinServlet", urlPatterns = {"/page/memberJoin"})
public class MemberJoinServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		
		 
		RequestDispatcher view=request.getRequestDispatcher("/page/memberJoin.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String email=request.getParameter("email");
		String name=request.getParameter("name");
		String password=request.getParameter("password");  
		String passwordCheck=request.getParameter("passwordCheck"); 
		String birthDate=request.getParameter("birthDate");
		String contactNumber=request.getParameter("contactNumber");
		String gender=request.getParameter("radio");
	 
		
		
		
		//formBean�� ����ֱ�
		MemberInfoForm memberInfoForm=new MemberInfoForm(email, name, password, passwordCheck, birthDate, gender, contactNumber);
		
		//validator ȣ�� �� ��ȿ�� ����
		MemberInfoValidator memberValidator=new MemberInfoValidator(memberInfoForm);
		List<String> checkList=memberValidator.validate();

		System.out.println(checkList.size());
		
		if(checkList.size()!=0) //��ȿ���˻� ��� ������ ������
		{
			
			
			System.out.println("�����ִ�");
			 
			request.setAttribute("problems", checkList);
			RequestDispatcher view=request.getRequestDispatcher("/page/memberJoin.jsp");
			view.forward(request, response);
			
			
		}
		else
		{ 
			StringTokenizer stok=new StringTokenizer(birthDate, "-");
			int year=Integer.parseInt(stok.nextToken());
			int month=Integer.parseInt(stok.nextToken());
			int date=Integer.parseInt(stok.nextToken());

			birthDate=year+"/"+month+"/"+date;
			
			
			ConvertGregorianCalendar convertCalendar=new ConvertGregorianCalendar();//�޷� ��ȯ
		
			
			MemberInfo memberInfo=new MemberInfo(name, email, password, convertCalendar.convert(birthDate), gender, contactNumber, "","",0);
		
			//������ �Ŵ��� ȣ��
			//ȸ���ڵ尪 �ο�, memberCode
			MemberJoinManager memberJoinManager=new MemberJoinManager(memberInfo);
			
			if(memberJoinManager.join())
			{ 
				request.setAttribute("success", "Travel Story�� ������ �ǽŰ� ȯ���մϴ�!");
				RequestDispatcher view=request.getRequestDispatcher("/page/mainpage.jsp");
				view.forward(request, response);
			}
			else
			{ 
				//��ȿ������ ������� ���ϸ� ���� �������� �����ϰ� ���ΰ�ħ
				//�˾� �� �� ������ �����Բ� �ϰ�
				request.setAttribute("emailProblem", "�̹� ��ϵ� �̸����ּ��Դϴ�");
				RequestDispatcher view=request.getRequestDispatcher("/page/memberJoin.jsp");
				view.forward(request, response);
			}
		}
		//ȭ�� ������������ �̵�, ���������Ƿ�!
		
	}

}
