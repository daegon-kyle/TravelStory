// 0719 ������
package dao;
import java.util.*;
import java.sql.*;

import dto.PhotoDTO;
/**
 * ������ ������ ������ ���� ������ �����ϱ� ���� ����Ѵ�. <br/> MapPhotoUploadDAOManager���� ����Ѵ�
 * @author ������
 *
 */
public class PhotoDAO {
	/**
	 * ���ο� ���� ������ �����ϱ� ���� ���Ǵ� ������
	 */
	private final static String INSERT_PHOTO_SQL="insert into photo_tb values(photo_code.nextVal, ?, ?)";
	/**
	 * ����� ��� ���� ������ �����ϱ� ���� ���Ǵ� ������
	 */
	private final static String DELETE_ALL_SQL="delete from photo_tb";
	/**
	 * ����� ���� ���� �� Ư�� ������ ������ �����ϱ� ���� ���Ǵ� ������
	 */
	private final static String DELETE_PHOTO_SQL="delete from photo_tb where photo_code=?";
	/**
	 * ����� ��� ���� ������ �������� ���� ���Ǵ� ������
	 */
	private final static String SELECT_ALL_SQL="select * from photo_tb";
	/**
	 * ����� ���� ���� �� Ư�� ������ ���� ������ �������� ���� ���Ǵ� ������
	 */
	private final static String SELECT_PHOTO_SQL="select * from photo_tb where photo_code=?";
	/**
	 * ����� ���� ���� �� Ư�� ������ ������ �����ϱ� ���� ���Ǵ� ������
	 */
	private final static String UPDATE_PHOTO_SQL="update photo_tb set photo_name=?, photo_path=? where photo_code=?";
	/**
	 * default constructor
	 */
	public PhotoDAO(){
		
	}
	/**
	 * ���ο� ���� ������ �����Ѵ�.<br/> MapPhotoUploadDAOManager���� ȣ��ȴ�
	 * @param photoName ������
	 * @param photoPath ���� ���
	 * @return true - ���忡 �������� ��� <br/> false - ���忡 �������� ���
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
	 * ����� ��� ���� ������ �����Ѵ�.<br/> ��� ����
	 * @return true - ������ �������� ��� <br/> false - ������ �������� ���
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
	 * ����� ���� ���� �� Ư�� ���� ������ �����Ѵ�. <br/>������
	 * @param photoCode ���� �ڵ�
	 * @return true - ������ �������� �Ͽ� <br/> false - ������ �������� ���
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
	 * ����� ��� ���� ������ �����´� <br/>������
	 * @return ��� ���� ������
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
	 * ����� ���� ���� �� Ư�� ������ ������ �����´�. <br/>������
	 * @param photoCode ���� �ڵ�
	 * @return Ư�� ���� ����
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
	 * ����� ���� ���� �� Ư�� ���� ������ �����Ѵ�. <br/>������
	 * @param photoCode ���� �ڵ�
	 * @param photoName ���ο� ������
	 * @param photoPath ���ο� ���� ���
	 * @return true - ������ �������� ���  <br/> false - ������ �������� ���
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
