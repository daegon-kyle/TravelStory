package dao;
import java.util.List;
import java.util.ArrayList;
import dto.MapPhotoInfoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * ���ε��� ������ ���� ������ �������� ���� Ŭ����.
 * <br/>MapPhotoUploadServlet���� ���ȴ�.
 * @author ������
 *
 */
public class MapPhotoInfoDAO {
	/**
	 * ��ü ȸ���� ������ ���ε��� ������ ���� ���� �� �޸� ��� �������� ���� ������
	 */
	private static final String SELECT_ALL_SQL="select * from map_photo_info_view";
	/**
	 * ��ü ȸ���� ������ ���ε��� ������ ���� ���� �� �޸� �� Ư�� ȸ���� ���ε��� �������� �������� ���� ������
	 */
	private static final String SELECT_MAP_PHOTO_INFOS_BY_MEMBER_CODE_SQL="select * from map_photo_info_view where member_code=?";
	/**
	 * ��ü ȸ���� ������ ���ε��� ������ ���� ���� �� �޸� �� Ư�� ȸ���� Ư�� ��ġ�� ���ε��� �������� �������� ���� ������
	 */
	private static final String SELECT_MAP_PHOTO_INFOS_BY_MEMBER_CODE_AND_LOCATION="select * from map_photo_info_view where member_code=? and latitude=? and longitude=?";
	/**
	 * default construction
	 */
	public MapPhotoInfoDAO(){
		
	}
	/**
	 * ��ü ȸ���� ������ ���ε��� ������ ���� ���� �� �޸� ��� �����´� <br/>MapPhotoUploadServlet���� ȣ��ȴ�.
	 * @return ��ü ȸ���� ������ ���ε��� ������ ���� ���� �� �޸��
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
	 * ��ü ȸ���� ������ ���ε��� ������ ���� ���� �� �޸� �� Ư�� ȸ���� ���ε��� �������� �����´�<br/>MapPhotoUploadServlet���� ȣ��ȴ�.
	 * @param memberCode Ư�� ȸ�� �ڵ�
	 * @return Ư�� ȸ���� ���ε��� ���� ���� �� �޸��
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
	 * ��ü ȸ���� ������ ���ε��� ������ ���� ���� �� �޸� �� Ư�� ȸ���� Ư�� ��ġ�� ���ε��� �������� �����´�.<br/>������
	 * @param memberCode Ư�� ȸ�� �ڵ�
	 * @param latitude  ã�� ���� ������ ����
	 * @param longitude ã�� ���� ������ �浵
	 * @return Ư�� ȸ���� Ư�� ��ġ�� ���ε��� ���� ���� �� �޸��
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
