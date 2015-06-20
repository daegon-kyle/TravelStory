// 0719 문정현
package dao;

import java.sql.*;
import java.util.*;

import dto.LocationDTO;
/**
 * 위치 정보를 조작하기 위해 사용한다. <br/> MapPhotoUploadDAOManager에서사용한다
 * @author 문정현
 *
 */
public class LocationDAO {
	/**
	 * 새로운 위치 정보를 저장하기 위해 사용되는 쿼리문
	 */
	private static final String INSERT_LOCATION_SQL="insert into location_tb values(location_code.nextVal, ?, ?)";
	/**
	 * 저장된 모든 위치 정보를 삭제하기 위해 사용되는 쿼리문
	 */
	private static final String DELETE_ALL_SQL="delete from location_tb";
	/**
	 * 저장된 위치 정보 중 특정 정보를 삭제하기 위해 사용되는 쿼리문
	 */
	private static final String DELETE_LOCATION_SQL="delete from location_tb where location_code=?";
	/**
	 * 저장된 모든 위치 정보를 가져오기 위해 사용되는 쿼리문
	 */
	private static final String SELECT_LOCATION_ALL_SQL="select * from location_tb";
	/**
	 * 저장된 위치 정보 중 특정 위치의 정보를 가져오기 위해 사용되는 쿼리문
	 */
	private static final String SELECT_LOCATION_SQL="select * from location_tb where location_code=?";
	/**
	 * 특정 위도, 경도에 의 위치 정보 코드를 가져오기 위해 사용되는 쿼리문
	 */
	private static final String SELECT_LOCATION_CODE_SQL="select location_code from location_tb where longitude=? and latitude=?";
	/**
	 * 특정 위치 정보를 수정하기 위해 사용되는 쿼리문
	 */
	private static final String UPDATE_LOCATION_SQL="update location_tb set latitude=?, longitude=? where location_code=?";
	/**
	 * default constructor
	 */
	public LocationDAO() {
	
	}
	/**
	 * 새로운 위치 정보를 저장한다. <br/> MapPhotoUploadDAOManager에서 호출된다
	 * @param latitude 위도
	 * @param longitude 경도
	 * @return true - 저장에 성공했을 경우 <br/> false - 저장에 실패헸을 경우
	 */
	public boolean insert(double latitude, double longitude){
		int rowNum=0;
		PreparedStatement pre = null;
		Connection conn = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre=conn.prepareStatement(INSERT_LOCATION_SQL);
			pre.setDouble(1, latitude);
			pre.setDouble(2, longitude);
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
			catch(SQLException sql){
				sql.printStackTrace();
			}
		}
		if(rowNum!=1)
			return false;
		return true;
	}
	/**
	 * 저장된 모든 위치 정보를 삭제한다. <br/>사용안함
	 * @return true - 삭제에 성공했을 경우 <br/> false - 삭제에 실패했을 경우
	 */
	public boolean deleteAll(){
		PreparedStatement pre = null;
		int rowNum = 0;
		Connection conn = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre=  conn.prepareStatement(DELETE_ALL_SQL);
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
		if(rowNum>0)
			return true;
		else
			return false;
	}
	/**
	 * 저장된 위치 정보 중 특정 위치 정보를 삭제한다.<br/>사용안함
	 * @param locationCode 위치 정보 코드
	 * @return true - 삭제에 성공했을 경우 <br/> false - 삭제에 실패했을 경우
	 */
	public boolean delete(String locationCode){
		PreparedStatement pre = null;
		int rowNum = 0;
		Connection conn = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre=conn.prepareStatement(DELETE_LOCATION_SQL);
			pre.setString(1, locationCode);
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
	 * 저장된 모든 위치 정보를 가져온다. <br/>사용안함
	 * @return 모든 위치 정보들
	 */
	public List<LocationDTO> selectAll(){
		PreparedStatement pre = null;
		ResultSet re = null;
		Connection conn = null;
		List<LocationDTO> list = new ArrayList<LocationDTO>();
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_LOCATION_ALL_SQL);
			re = pre.executeQuery();
			while(re.next()){
				String locationCode = re.getString("location_code");
				double latitude = re.getDouble("latitude");
				double longitude = re.getDouble("longitude");
				list.add(new LocationDTO(locationCode, latitude, longitude));
			}
		}catch(SQLException sqle){
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
	 * 저장된 위치 정보 중 특정 위치 정보를 가져온다. <br/>사용안함
	 * @param locationCode 위치 정보 코드
	 * @return 위치 정보
	 */
	public LocationDTO select(String locationCode){
		LocationDTO dto = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		Connection conn = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_LOCATION_SQL);
			pre.setString(1, locationCode);
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("location_code");
				double latitude = re.getDouble("latitude");
				double longitude = re.getDouble("longitude");
				dto = new LocationDTO(code, latitude, longitude);
			}
		}catch(SQLException sqle){
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
	 * 저장된 위치 정보 중 특정 위도와 경도의 위치 코드를 가져온다.<br/> MapPhotoUploadDAOManager에서 호출된다
	 * @param latitude 위도
	 * @param longitude 경도
	 * @return 위치 코드
	 */
	public String select(double latitude, double longitude){
		String code = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		Connection conn = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_LOCATION_CODE_SQL);
			pre.setDouble(1, longitude);
			pre.setDouble(2, latitude);
			
			re = pre.executeQuery();
			while(re.next()){
				code = re.getString("location_code");
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
			catch(SQLException  sqle){
				sqle.printStackTrace();
			}
		}
		return code;
	}
	/**
	 * 저장된 위치 정보 중 특정 위치 정보를 수정한다. <br/>사용안함
	 * @param locationCode 위치 정보 코드
	 * @param latitude 새로운 위도
	 * @param longitude 새로운 경도
	 * @return true - 수정에 성공했을 경우 <br/> false - 수정에 실패했을 경우
	 */
	public boolean update(String locationCode, double latitude, double longitude){
		int rowNum = 0;
		PreparedStatement pre = null;
		Connection conn = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(UPDATE_LOCATION_SQL);
			pre.setDouble(1, latitude);
			pre.setDouble(2, longitude);
			pre.setString(3, locationCode);
			rowNum = pre.executeUpdate();
		}
		catch(SQLException sql){
			sql.printStackTrace();
		}
		finally{
			try{
				conn.close();
				pre.close();
			}
			catch(SQLException sql){
				sql.printStackTrace();
			}
		}
		if(rowNum==1)
			return true;
		return false;
	}
}
