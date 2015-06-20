package servlet;

import java.io.IOException;

import model.EmptyRoomDetailInfo;
import java.util.List;
import java.util.StringTokenizer;

import converter.ConvertGregorianCalendar;
import model.EmptyRoomListInfo;
import model.EmptyRoomListInfoList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import manager.EmptyRoomReservationManager;
import javax.servlet.RequestDispatcher;
import form.EmptyRoomSearchForm;
import validator.EmptyRoomSearchValidator;
@WebServlet(name="/EmptyRoomReservationServlet", urlPatterns={"/page/emptyRoomSearch", "/page/emptyRoomDetail", "/page/emptyRoomSearchButton"})

public class EmptyRoomReservationServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("utf-8");
		 
		String uri=request.getRequestURI();
		
		int lastIndex=uri.lastIndexOf("/");
		String action=uri.substring(lastIndex+1);
		 
		if(action.equals("emptyRoomDetail"))
		{
			doConfirmEmptyRoomInfo(request, response);
		}
		else if(action.equals("emptyRoomSearchButton"))
		{ 
			doSearchEmptyRoom(request, response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("/page/test.jsp");
			rd.forward(request, response);
		}
	}
	
	private void doConfirmEmptyRoomInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String emptyRoomCode=request.getParameter("emptyRoomCode");

		EmptyRoomReservationManager emptyRoomReservationManager=new EmptyRoomReservationManager(); 
		EmptyRoomDetailInfo info=emptyRoomReservationManager.getEmptyRoomDetail(emptyRoomCode);
		
		request.setAttribute("info", info);
		
		RequestDispatcher rd=request.getRequestDispatcher("/page/emptyRoomReserveDetail.jsp");
		rd.forward(request,  response);
	}
	
	private void doSearchEmptyRoom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String hotelLocation=request.getParameter("hotelLocation");
		String availableDate=request.getParameter("availableDate");
		 System.out.println("���� ; "+hotelLocation);
		 System.out.println(availableDate);
		EmptyRoomSearchForm emptyRoomSearchForm=new EmptyRoomSearchForm(hotelLocation, availableDate);
		EmptyRoomSearchValidator emptyRoomSearchValidator=new EmptyRoomSearchValidator(emptyRoomSearchForm);
		
		List<String> checkList=emptyRoomSearchValidator.validate();
		
		if(checkList.size()==0)//����������
		{
			ConvertGregorianCalendar convertGregorianCalendar=new ConvertGregorianCalendar();
			EmptyRoomReservationManager emptyRoomReservationManager=new EmptyRoomReservationManager();
			EmptyRoomListInfoList list=null;
			
			StringTokenizer stok=new StringTokenizer(availableDate, "-");
			int year=Integer.parseInt(stok.nextToken());
			int month=Integer.parseInt(stok.nextToken());
			int date2=Integer.parseInt(stok.nextToken());
 
			availableDate=year+"/"+month+"/"+date2;
 
			list=emptyRoomReservationManager.search(hotelLocation, convertGregorianCalendar.convert(availableDate));//�˻������ �޾ƿ�
			System.out.println("list = "+list);
			String noresult=null;
			
			if(list.getEmptyRoomListInfoList().size()==0)//����� ������
			{
				noresult="�˻� ����� �����ϴ�. ��,�� Ȥ�� ������ �Է��Ͻø� �� ���� ����� ���� �� �ֽ��ϴ�";
				request.setAttribute("noresult", noresult);
			}
			else
			{
				request.setAttribute("result", list.getEmptyRoomListInfoList());//List<EmptyRoomListInfo>�ѿ���
			}
			RequestDispatcher rd=request.getRequestDispatcher("/page/emptyRoomReserveResult.jsp");
			rd.forward(request, response);
		}
	}
}
