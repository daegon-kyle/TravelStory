// 0720 ������
package dao;

import java.util.*;
import java.sql.*;
import model.*;
import dto.HotelManagerDTO;
/**
 * ȣ��  ������ �����ϱ� ���� ����Ѵ�.
 * @author ������
 *
 */
public class HotelManagerDAO {
	/**
	 * ȣ��  ������ �����ϱ� ���� ���Ǵ� ������
	 */
	private static final String INSERT_HOTEL_MANAGER_SQL="insert into hotel_manager_tb values(hotel_manager_code.nextVal, ?, ?, ?, ?,?)";
	/**
	 * ����� ��� ȣ��  ������ �����ϱ� ���� ���Ǵ� ������
	 */
	private static final String DELETE_ALL_SQL="delete from hotel_manager_tb";
	/**
	 * ����� ȣ��  ���� �� Ư�� ȣ��  ������ �����ϱ� ���� ���Ǵ� ������
	 */
	private static final String DELETE_HOTEL_MANAGER_BY_MEMBER_CODE_SQL="delete from hotel_manager_tb where member_code=?";
	/**
	 * ����� ��� ȣ��  ������ �������� ���� ���Ǵ� ������
	 */
	private static final String SELECT_ALL_SQL="select * from hotel_manager_tb";
	/**
	 * ����� ȣ��  ���� �� ȣ�� �Ŵ��� �ڵ带 �̿��Ͽ� Ư�� ȣ��  ������ �������� ���� ���Ǵ� ������
	 */
	private static final String SELECT_HOTEL_MANAGER_BY_MANAGER_CODE_SQL="select * from hotel_manager_tb where hotel_manager_code=?";
	/**
	 * ����� ȣ��  ���� �� ȸ�� �ڵ带 �̿��Ͽ� Ư�� ȣ��  ������ �������� ���� ���Ǵ� ������
	 */
	private static final String SELECT_HOTEL_MANAGER_BY_MEMBER_CODE_SQL="select * from hotel_manager_tb where member_code=?";
	/**
	 * ����� ȣ��  ���� �� Ư�� ������ ��ġ�� ȣ���� ������ �������� ���� ���Ǵ� ������
	 */
	private static final String SELECT_HOTEL_MANAGER_BY_LOCATION_SQL="select * from hotel_manager_tb where hotel_location LIKE ?";
	/**
	 * ����� ȣ�� ���� �� ȸ�� �ڵ带 �̿��� ȣ�� �Ŵ����� �ڵ带 �������� ���� ���Ǵ� ������
	 */
	private static final String SELECT_HOTEL_MANAGER_CODE_BY_MEMBER_CODE_SQL="select hotel_manager_code from hotel_manager_tb where member_code=?";
	/**
	 * ����� ȣ�� ���� �� Ư�� ȣ���� ������ �����ϱ� ���� ���Ǵ� ������
	 */
	private static final String UPDATE_HOTEL_MANAGER_SQL="update hotel_manager_tb set  hotel_name=?, hotel_location=?, hotel_introduction=?, reservation_page_path=? where hotel_manager_code=?";
	/**
	 * default constructor
	 */
	public HotelManagerDAO(){
		
	}
	/**
	 * ���ο� ȣ�� ������ �����Ѵ�.
	 * @param memberCode ȸ�� �ڵ�
	 * @param hotelName ȣ�� �̸�
	 * @param hotelLocation ȣ�� �ּ�
	 * @param hotelIntroduction ȣ�� �Ұ�
	 * @param reservationPagePath ȣ�� Ȩ������ url
	 * @return true - ���忡 �������� ��� <br/> false - ���忡 �������� ���
	 */
	public boolean insert(String memberCode, String hotelName, String hotelLocation, String hotelIntroduction, String reservationPagePath){
		int rowNum = 0;
		Connection conn = null;
		PreparedStatement pre =null;
		try{
			conn=DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(INSERT_HOTEL_MANAGER_SQL);
			pre.setString(1, memberCode);
			pre.setString(2, hotelName);
			pre.setString(3, hotelLocation);
			pre.setString(4, hotelIntroduction);
			pre.setString(5, reservationPagePath);
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
	/**
	 * ����� ��� ȣ�� ������ �����Ѵ�.
	 * @return true - ������ �������� ��� <br/> false - ������ �������� ���
	 */
	public boolean deleteAll(){
		int rowNum=0;
		Connection conn = null;
		PreparedStatement pre = null;
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
				pre.close();
				conn.close();
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
	 * ����� ȣ�� ���� �� Ư�� ȸ���� ����� ȣ�� ������ �����Ѵ�.
	 * @param memberCode ȸ�� �ڵ�
	 * @return true - ������ �������� ��� <br/> false - ������ �������� ���
	 */
	public boolean delete(String memberCode){
		Connection conn = null;
		PreparedStatement pre = null;
		int rowNum = 0;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(DELETE_HOTEL_MANAGER_BY_MEMBER_CODE_SQL);
			pre.setString(1, memberCode);
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
		if(rowNum ==1)
			return true;
		return false;
	}
	/**
	 * ����� ��� ȣ�� ������ �����´�.
	 * @return ��� ȣ�� ������
	 */
	public List<HotelManagerDTO> selectAll(){
		List<HotelManagerDTO> list = new ArrayList<HotelManagerDTO>();
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_ALL_SQL);
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("hotel_manager_code");
				String memberCode = re.getString("member_code");
				String name = re.getString("hotel_name");
				String location=re.getString("hotel_location");
				String introduction=re.getString("hotel_introduction");
				String homePage = re.getString("reservation_page_path");
				list.add(new HotelManagerDTO(code, memberCode, name, location, introduction, homePage));
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
	 * ȣ�� ������ ����� Ư�� ȸ���� ȣ�� �Ŵ��� �ڵ带 �����´�.
	 * @param memberCode ȸ�� �ڵ�
	 * @return ȣ�� �Ŵ��� �ڵ�
	 */
	public String selectHotelManagerCode(String memberCode){
		Connection conn = null;
		String code = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_HOTEL_MANAGER_CODE_BY_MEMBER_CODE_SQL);
			pre.setString(1, memberCode);
			re = pre.executeQuery();
			while(re.next()){
				code = re.getString("hotel_manager_code");
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
		return code;
	}
	/**
	 * ����� ȣ�� ���� �� Ư�� ȣ�� �Ŵ����� ����� ȣ�� ������ �����´�.
	 * @param hotelManagerCode ȣ�� �Ŵ��� �ڵ�
	 * @return Ư�� ȣ���� ȣ�� ����
	 */
	public HotelManagerDTO selectByHotelManagerCode(String hotelManagerCode){
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		HotelManagerDTO dto = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_HOTEL_MANAGER_BY_MANAGER_CODE_SQL);
			pre.setString(1, hotelManagerCode);
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("hotel_manager_code");
				String memberCode = re.getString("member_code");
				String name = re.getString("hotel_name");
				String location = re.getString("hotel_location");
				String introduction = re.getString("hotel_introduction");
				String homePage=re.getString("reservation_page_path");
				dto = new HotelManagerDTO(code, memberCode, name, location, introduction,homePage);
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
		return dto;
	}
	/**
	 * ����� ȣ�� ���� �� Ư�� ȸ���� ����� ȣ�� ������ �����´�.
	 * @param memberCode ȸ�� �ڵ�
	 * @return Ư�� ȣ�� ����
	 */
	public HotelManagerDTO selectByMemberCode(String memberCode){
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		HotelManagerDTO dto = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_HOTEL_MANAGER_BY_MEMBER_CODE_SQL);
			pre.setString(1, memberCode);
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("hotel_manager_code");
				String memberCode1 = re.getString("member_code");
				String name = re.getString("hotel_name");
				String location = re.getString("hotel_location");
				String introduction = re.getString("hotel_introduction");
				String homePage=re.getString("reservation_page_path");
				dto = new HotelManagerDTO(code, memberCode1, name, location, introduction,homePage);
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
		return dto;
	}
	/**
	 * ����� ȣ�� ���� �� Ư�� ������ ��ġ�� ȣ�ڵ��� ������ �����´�.
	 * @param location Ư�� ����
	 * @return Ư�� ������ ȣ�� ������
	 */
	public List<HotelManagerDTO> selectByLocation(String location){
		List<HotelManagerDTO> list = new ArrayList<HotelManagerDTO>();
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_HOTEL_MANAGER_BY_LOCATION_SQL);
			pre.setString(1, "%"+location+"%");
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("hotel_manager_code");
				String memberCode = re.getString("member_code");
				String name = re.getString("hotel_name");
				String location1=re.getString("hotel_location");
				String introduction=re.getString("hotel_introduction");
				String homePage = re.getString("reservation_page_path");
				list.add(new HotelManagerDTO(code, memberCode, name, location1, introduction, homePage));
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
	 * ����� ȣ�� ���� �� Ư�� ȣ���� ������ �����Ѵ�.
	 * @param hotelManagerCode ȣ�� �Ŵ��� �ڵ�
	 * @param hotelName ���ο� ȣ�� �̸�
	 * @param hotelLocation ���ο� ȣ�� �ּ�
	 * @param hotelIntroduction ���ο� ȣ�� �Ұ�
	 * @param reservationPagePath ���ο� ȣ�� Ȩ������ url
	 * @return true - ������ �������� �ܿ� <br/> false - ������ �������� ���
	 */
	public boolean update(String hotelManagerCode, String hotelName, String hotelLocation, String hotelIntroduction, String reservationPagePath){
		Connection conn = null;
		PreparedStatement pre = null;
		int rowNum = 0;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(UPDATE_HOTEL_MANAGER_SQL);
			pre.setString(1, hotelName);
			pre.setString(2, hotelLocation);
			pre.setString(3, hotelIntroduction);
			pre.setString(4, reservationPagePath);
			pre.setString(5, hotelManagerCode);
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
