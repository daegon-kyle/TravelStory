package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ������ �������ε� ���񽺸� ��û�� ��� DB�� �����ϱ� ���� ����ϴ� Ŭ����
 * Servlet implementation class MapPhotoUplaodServlet
 */
@WebServlet("/MapPhotoUplaodServlet")
public class MapPhotoUplaodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * ����,�浵�� ������ ������ ���ε��Ѵ�. <br>
	 * MapPhotoUploadInfoManager Ŭ������ saveLcoation, savePhoto, saveMapPhotoUpload �޼ҵ带 �̿��Ͽ� DB�� ����
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
