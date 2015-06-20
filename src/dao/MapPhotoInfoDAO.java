package dao;
import java.util.List;
import java.util.ArrayList;
import dto.MapPhotoInfoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 업로드한 사진에 대한 정보를 가져오기 위한 클래스.
 * <br/>MapPhotoUploadServlet에서 사용된다.
 * @author 문정현
 *
 */
public class MapPhotoInfoDAO {
	/**
	 * 전체 회원이 지도에 업로드한 사진에 대한 정보 및 메모를 모두 가져오기 위한 쿼리문
	 */
	private static final String SELECT_ALL_SQL="select * from map_photo_info_view";
	/**
	 * 전체 회원이 지도에 업로드한 사진에 대한 정보 및 메모 중 특정 회원이 업로드한 정보들을 가져오기 위한 쿼리문
	 */
	private static final String SELECT_MAP_PHOTO_INFOS_BY_MEMBER_CODE_SQL="select * from map_photo_info_view where member_code=?";
	/**
	 * 전체 회원이 지도에 업로드한 사진에 대한 정보 및 메모 중 특정 회원이 특정 위치에 업로드한 정보들을 가져오기 위한 쿼리문
	 */
	private static final String SELECT_MAP_PHOTO_INFOS_BY_MEMBER_CODE_AND_LOCATION="select * from map_photo_info_view where member_code=? and latitude=? and longitude=?";
	/**
	 * default construction
	 */
	public MapPhotoInfoDAO(){
		
	}
	/**
	 * 전체 회원이 지도에 업로드한 사진에 대한 정보 및 메모를 모두 가져온다 <br/>MapPhotoUploadServlet에서 호출된다.
	 * @return 전체 회원이 지도에 업로드한 사진에 대한 정보 및 메모들
	 */
	public List<MapPhotoInfoDTO> selectAll(){
		List<MapPhotoInfoDTO> list = new ArrayList<MapPhotoInfoDTO>();
		Connection conn = null;
		PreparedStatement pre= null;
		ResultSet re = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_ALL_SQL);
			re = pre.executeQuery();
			while(re.next()){
				String memCode = re.getString("member_code");
				String photoCode= re.getString("photo_code");
				String photoName = re.getString("photo_name");
				String photoPath=re.getString("photo_path");
				double latitude=re.getDouble("latitude");
				double longitude = re.getDouble("longitude");
				String content = re.getString("content");
				list.add(new MapPhotoInfoDTO(memCode, photoCode, photoName, photoPath, latitude, longitude, content));
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally{
			try{
				re.close();
				pre.close();
				conn.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		return list;
	}
	/**
	 * 전체 회원이 지도에 업로드한 사진에 대한 정보 및 메모 중 특정 회원이 업로드한 정보들을 가져온다<br/>MapPhotoUploadServlet에서 호출된다.
	 * @param memberCode 특정 회원 코드
	 * @return 특정 회원이 업로드한 사진 정보 및 메모들
	 */
	public List<MapPhotoInfoDTO> selectMapPhotoInfos(String memberCode){
		List<MapPhotoInfoDTO> list = new ArrayList<MapPhotoInfoDTO>();
		Connection conn = null;
		PreparedStatement pre= null;
		ResultSet re = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_MAP_PHOTO_INFOS_BY_MEMBER_CODE_SQL);
			pre.setString(1, memberCode);
			re = pre.executeQuery();
			while(re.next()){
				String memCode = re.getString("member_code");
				String photoCode= re.getString("photo_code");
				String photoName = re.getString("photo_name");
				String photoPath=re.getString("photo_path");
				double latitude=re.getDouble("latitude");
				double longitude = re.getDouble("longitude");
				String content = re.getString("content");
				list.add(new MapPhotoInfoDTO(memCode, photoCode, photoName, photoPath, latitude, longitude, content));
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally{
			try{
				re.close();
				pre.close();
				conn.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		return list;
	}
	/**
	 * 전체 회원이 지도에 업로드한 사진에 대한 정보 및 메모 중 특정 회원이 특정 위치에 업로드한 정보들을 가져온다.<br/>사용안함
	 * @param memberCode 특정 회원 코드
	 * @param latitude  찾고 싶은 사진의 위도
	 * @param longitude 찾고 싶은 사진의 경도
	 * @return 특정 회원이 특정 위치에 업로드한 사진 정보 및 메모들
	 */
	public List<MapPhotoInfoDTO> selectMapPhotoInfos(String memberCode, double latitude, double longitude){
		List<MapPhotoInfoDTO> list = new ArrayList<MapPhotoInfoDTO>();
		Connection conn = null;
		PreparedStatement pre= null;
		ResultSet re = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_MAP_PHOTO_INFOS_BY_MEMBER_CODE_AND_LOCATION);
			pre.setString(1, memberCode);
			pre.setDouble(2, latitude);
			pre.setDouble(3, longitude);
			re = pre.executeQuery();
			while(re.next()){
				String memCode = re.getString("member_code");
				String photoCode= re.getString("photo_code");
				String photoName = re.getString("photo_name");
				String photoPath=re.getString("photo_path");
				double latitude1=re.getDouble("latitude");
				double longitude1 = re.getDouble("longitude");
				String content = re.getString("content");
				list.add(new MapPhotoInfoDTO(memCode, photoCode, photoName, photoPath, latitude1, longitude1, content));
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally{
			try{
				re.close();
				pre.close();
				conn.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		return list;
	}
}
