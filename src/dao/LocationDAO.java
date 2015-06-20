// 0719 ������
package dao;

import java.sql.*;
import java.util.*;

import dto.LocationDTO;
/**
 * ��ġ ������ �����ϱ� ���� ����Ѵ�. <br/> MapPhotoUploadDAOManager��������Ѵ�
 * @author ������
 *
 */
public class LocationDAO {
	/**
	 * ���ο� ��ġ ������ �����ϱ� ���� ���Ǵ� ������
	 */
	private static final String INSERT_LOCATION_SQL="insert into location_tb values(location_code.nextVal, ?, ?)";
	/**
	 * ����� ��� ��ġ ������ �����ϱ� ���� ���Ǵ� ������
	 */
	private static final String DELETE_ALL_SQL="delete from location_tb";
	/**
	 * ����� ��ġ ���� �� Ư�� ������ �����ϱ� ���� ���Ǵ� ������
	 */
	private static final String DELETE_LOCATION_SQL="delete from location_tb where location_code=?";
	/**
	 * ����� ��� ��ġ ������ �������� ���� ���Ǵ� ������
	 */
	private static final String SELECT_LOCATION_ALL_SQL="select * from location_tb";
	/**
	 * ����� ��ġ ���� �� Ư�� ��ġ�� ������ �������� ���� ���Ǵ� ������
	 */
	private static final String SELECT_LOCATION_SQL="select * from location_tb where location_code=?";
	/**
	 * Ư�� ����, �浵�� �� ��ġ ���� �ڵ带 �������� ���� ���Ǵ� ������
	 */
	private static final String SELECT_LOCATION_CODE_SQL="select location_code from location_tb where longitude=? and latitude=?";
	/**
	 * Ư�� ��ġ ������ �����ϱ� ���� ���Ǵ� ������
	 */
	private static final String UPDATE_LOCATION_SQL="update location_tb set latitude=?, longitude=? where location_code=?";
	/**
	 * default constructor
	 */
	public LocationDAO() {
	
	}
	/**
	 * ���ο� ��ġ ������ �����Ѵ�. <br/> MapPhotoUploadDAOManager���� ȣ��ȴ�
	 * @param latitude ����
	 * @param longitude �浵
	 * @return true - ���忡 �������� ��� <br/> false - ���忡 �����g�� ���
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
	 * ����� ��� ��ġ ������ �����Ѵ�. <br/>������
	 * @return true - ������ �������� ��� <br/> false - ������ �������� ���
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
	 * ����� ��ġ ���� �� Ư�� ��ġ ������ �����Ѵ�.<br/>������
	 * @param locationCode ��ġ ���� �ڵ�
	 * @return true - ������ �������� ��� <br/> false - ������ �������� ���
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
	 * ����� ��� ��ġ ������ �����´�. <br/>������
	 * @return ��� ��ġ ������
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
	 * ����� ��ġ ���� �� Ư�� ��ġ ������ �����´�. <br/>������
	 * @param locationCode ��ġ ���� �ڵ�
	 * @return ��ġ ����
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
	 * ����� ��ġ ���� �� Ư�� ������ �浵�� ��ġ �ڵ带 �����´�.<br/> MapPhotoUploadDAOManager���� ȣ��ȴ�
	 * @param latitude ����
	 * @param longitude �浵
	 * @return ��ġ �ڵ�
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
	 * ����� ��ġ ���� �� Ư�� ��ġ ������ �����Ѵ�. <br/>������
	 * @param locationCode ��ġ ���� �ڵ�
	 * @param latitude ���ο� ����
	 * @param longitude ���ο� �浵
	 * @return true - ������ �������� ��� <br/> false - ������ �������� ���
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
