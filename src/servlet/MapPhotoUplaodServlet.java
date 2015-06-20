package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 지도에 사진업로드 서비스를 요청한 경우 DB에 저장하기 위해 사용하는 클래스
 * Servlet implementation class MapPhotoUplaodServlet
 */
@WebServlet("/MapPhotoUplaodServlet")
public class MapPhotoUplaodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 위도,경도와 사진을 서버로 업로드한다. <br>
	 * MapPhotoUploadInfoManager 클래스의 saveLcoation, savePhoto, saveMapPhotoUpload 메소드를 이용하여 DB에 저장
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
