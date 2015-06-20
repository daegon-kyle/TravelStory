// 0719 문정현
package dao;
import java.util.*;
import java.sql.*;

import dto.PhotoDTO;
/**
 * 서버에 저장한 사진에 대한 정보를 조작하기 위해 사용한다. <br/> MapPhotoUploadDAOManager에서 사용한다
 * @author 문정현
 *
 */
public class PhotoDAO {
	/**
	 * 새로운 사진 정보를 저장하기 위해 사용되는 쿼리문
	 */
	private final static String INSERT_PHOTO_SQL="insert into photo_tb values(photo_code.nextVal, ?, ?)";
	/**
	 * 저장된 모든 사진 정보를 삭제하기 위해 사용되는 쿼리문
	 */
	private final static String DELETE_ALL_SQL="delete from photo_tb";
	/**
	 * 저장된 사진 정보 중 특정 사진의 정보를 삭제하기 위해 사용되는 쿼리문
	 */
	private final static String DELETE_PHOTO_SQL="delete from photo_tb where photo_code=?";
	/**
	 * 저장된 모든 사진 정보를 가져오기 위해 사용되는 쿼리문
	 */
	private final static String SELECT_ALL_SQL="select * from photo_tb";
	/**
	 * 저장된 사진 정보 중 특정 사진에 대한 정보를 가져오기 위해 사용되는 쿼리문
	 */
	private final static String SELECT_PHOTO_SQL="select * from photo_tb where photo_code=?";
	/**
	 * 저장된 사진 정보 중 특정 사진의 정보를 수정하기 위해 사용되는 쿼리문
	 */
	private final static String UPDATE_PHOTO_SQL="update photo_tb set photo_name=?, photo_path=? where photo_code=?";
	/**
	 * default constructor
	 */
	public PhotoDAO(){
		
	}
	/**
	 * 새로운 사진 정보를 저장한다.<br/> MapPhotoUploadDAOManager에서 호출된다
	 * @param photoName 사진명
	 * @param photoPath 사진 경로
	 * @return true - 저장에 성공했을 경우 <br/> false - 저장에 실패했을 경우
	 */
	public boolean insert(String photoName, String photoPath){
		int rowNum = 0;
		PreparedStatement pre = null;
		Connection conn = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(INSERT_PHOTO_SQL);
			pre.setString(1, photoName);
			pre.setString(2, photoPath);
			rowNum = pre.executeUpdate();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally{
			try{
				conn.close();
				pre.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		if(rowNum==1)
			return true;
		return false;
	}
	/**
	 * 저장된 모든 사진 정보를 삭제한다.<br/> 사용 안함
	 * @return true - 삭제에 성공했을 경우 <br/> false - 삭제에 실패했을 경우
	 */
	public boolean deleteAll() {
		PreparedStatement pre = null;
		int rowNum =0;
		Connection conn = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(DELETE_ALL_SQL);
			rowNum = pre.executeUpdate();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally{
			try{
				conn.close();
				pre.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		if(rowNum>0)
			return true;
		return false;
	}
	/**
	 * 저장된 사진 정보 중 특정 사진 정보를 삭제한다. <br/>사용안함
	 * @param photoCode 사진 코드
	 * @return true - 삭제에 성공했을 겅우 <br/> false - 삭제에 실패했을 경우
	 */
	public boolean delete(String photoCode){
		PreparedStatement pre = null;
		int rowNum = 0;
		Connection conn = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(DELETE_PHOTO_SQL);
			pre.setString(1, photoCode);
			rowNum = pre.executeUpdate();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally{
			try{
				conn.close();
				pre.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		if(rowNum == 1)
			return true;
		return false;
	}
	/**
	 * 저장된 모든 사진 정보를 가져온다 <br/>사용안함
	 * @return 모든 사진 정보들
	 */
	public List<PhotoDTO> selectAll(){
		List<PhotoDTO> list = new ArrayList<PhotoDTO>();
		PreparedStatement pre = null;
		ResultSet re = null;
		Connection conn = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_ALL_SQL);
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("photo_code");
				String name = re.getString("photo_name");
				String path = re.getString("photo_path");
				list.add(new PhotoDTO(code, name, path));
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally{
			try{
				conn.close();
				pre.close();
				re.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		return list;
	}
	/**
	 * 저장된 사진 정보 중 특정 사진의 정보를 가져온다. <br/>사용안함
	 * @param photoCode 사진 코드
	 * @return 특정 사진 정보
	 */
	public PhotoDTO select(String photoCode){
		PreparedStatement pre = null;
		ResultSet re = null;
		PhotoDTO dto = null;
		Connection conn = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_PHOTO_SQL);
			pre.setString(1, photoCode);
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("photo_code");
				String name = re.getString("photo_name");
				String path = re.getString("photo_path");
				dto = new PhotoDTO(code, name, path);
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally{
			try{
				conn.close();
				pre.close();
				re.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		return dto;
	}
	/**
	 * 저장된 사진 정보 중 특정 사진 정보를 수정한다. <br/>사용안함
	 * @param photoCode 사진 코드
	 * @param photoName 새로운 사진명
	 * @param photoPath 새로운 사진 경로
	 * @return true - 수정에 성공했을 경우  <br/> false - 수정에 실패했을 경우
	 */
	public boolean update(String photoCode, String photoName, String photoPath){
		PreparedStatement pre = null;
		int rowNum = 0;
		Connection conn = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(UPDATE_PHOTO_SQL);
			pre.setString(1, photoName);
			pre.setString(2, photoPath);
			rowNum = pre.executeUpdate();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally{
			try{
				pre.close();
				conn.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		if(rowNum==1)
			return true;
		return false;
	}
}
