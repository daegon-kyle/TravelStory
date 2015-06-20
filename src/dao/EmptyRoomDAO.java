// 0720 ������
package dao;
import java.util.*;
import java.sql.*;

import dto.EmptyRoomDTO;
/**
 * ���� ������ �����ϱ� ���� ����Ѵ�.<br/>HotelEmptyRoomDAOManager���� ����Ѵ�.
 * @author ������
 *
 */
public class EmptyRoomDAO {
	/**
	 * ���������� �����ϱ� ���� ���Ǵ� ������(�̿밡���� ��¥�� �ڵ� ����)
	 */
	private final static String INSERT_EMPTY_ROOM_WITHOUT_DATE_SQL="insert into empty_room_tb values(empty_room_code.nextVal, ?, sysdate+1, ?, ?, ?,?,?,?,?,?,?)";
	/**
	 * ���� ������ �����ϱ� ���� ���Ǵ� ������
	 */
	private static final String INSERT_EMPTY_ROOM_SQL="insert into empty_room_tb values(empty_room_code.nextVal, ?, ?, ?, ?, ?,?,?,?,?,?,?)";
	/**
	 * ����� ���� ������ ��� �����ϱ� ���� ���Ǵ� ������
	 */
	private static final String DELETE_ALL_SQL="delete from empty_room_tb";
	/**
	 * ����� ���� ���� �� Ư���� ���� ������ �����ϱ� ���� ���Ǵ� ������
	 */
	private static final String DELETE_EMPTY_ROOM_SQL="delete from empty_room_tb where empty_room_code=?";
	/**
	 * ����� ���� ���� �� Ư���� ȣ�� �Ŵ����� �ø� ���� �������� �����ϱ� ���� ���Ǵ� ������
	 */
	private static final String DELETE_EMPTY_ROOMS_SQL="delete from empty_room_tb where hotel_manager_code=?";
	/**
	 * ����� ���� �������� ��� �������� ���Ǵ� ������
	 */
	private static final String SELECT_ALL_SQL="select empty_room_code, hotel_manager_code, TO_CHAR(available_date, 'YYYY/MM/DD') available_date, empty_room_name, discount_price, old_price, capacity, space, check_out_time, check_in_time, facility_list, etc from empty_room_tb";
	/**
	 * ����� ���� ������ �� Ư���� ȣ�� �Ŵ����� �ø� ������ �ڵ带 ��� �������� ���� ���Ǵ� ������
	 */
	private static final String SELECT_EMPTY_ROOM_CODES_SQL="select empty_room_code from empty_room_tb where hotel_manager_code=?";
	/**
	 * ����� ���� ������ �� Ư���� ���� ������ �������� ���� ���Ǵ� ������
	 */
	private static final String SELECT_EMPTY_ROOM_SQL="select empty_room_code, hotel_manager_code, TO_CHAR(available_date, 'YYYY/MM/DD') available_date, empty_room_name, discount_price, old_price, capacity, space, check_out_time, check_in_time, facility_list, etc from empty_room_tb where empty_room_code=?";
	/**
	 * ����� ���� ������ �� Ư���� ȣ�� �Ŵ����� �ø� ���� �������� ��� �������� ���� ���Ǵ� ������
	 */
	private static final String SELECT_EMPTY_ROOMS_SQL="select empty_room_code, hotel_manager_code, TO_CHAR(available_date, 'YYYY/MM/DD') available_date, empty_room_name, discount_price, old_price, capacity, space, check_out_time, check_in_time, facility_list, etc from empty_room_tb where hotel_manager_code=?";
	/**
	 * ����� ���� ������ �� Ư�� ��¥�� �̿��� �� �ִ� ���� �������� ��� �������� ���� ���Ǵ� ������
	 */
	private static final String SELECT_EMPTY_ROOMS_BY_DATE_SQL="select empty_room_code, hotel_manager_code, TO_CHAR(available_date, 'YYYY/MM/DD') available_date, empty_room_name, discount_price, old_price, capacity, space, check_out_time, check_in_time, facility_list, etc from empty_room_tb where available_date=?";
	/**
	 * ����� ���� ������ �� Ư���� ���� ������ ��� �����ϱ� ���� ���Ǵ� ������
	 */
	private static final String UPDATE_EMPTY_ROOM_SQL="update empty_room_tb set available_date=?, empty_room_name=?, discount_price=?, old_price=?, capacity=?, space=?, check_in_time=?, check_out_time=?, facility_list=?, etc=? where empty_room_code=?";
	/**
	 * �����ڵ带 �̿��Ͽ� �̿볯¥�� ������ ��������� �����Ѵ�. 
	 */
	private static final String UPDATE_EMPTY_ROOM_SQL2="update empty_room_tb set empty_room_name=?, discount_price=?, old_price=?, capacity=?, space=?, check_in_time=?, check_out_time=?, facility_list=?, etc=? where empty_room_code=?";
	/**
	 * ����� ���� ������ �� Ư���� ���� ���� �� �̿밡���� ��¥�� �����ϱ� ���� ���Ǵ� ������
	 */
	private static final String UPDATE_AVAILABLE_DATE_SQL="update empty_room_tb set available_date=? where empty_room_code=?";
	/**
	 * ����� ���� ������ �� Ư���� ���� ���� �� �̿밡���� ��¥�� ���ΰ����� �����ϱ� ���� ���Ǵ� ������ 
	 */
	private static final String UPDATE_DATE_AND_PRICE_SQL="update empty_room_tb set available_date=?, discount_price=? where empty_room_code=?";
	/**
	 * ����� ���� ������ �� Ư���� ���� ���� �� ���ΰ����� �����ϱ� ���� ���Ǵ� ������
	 */
	private static final String UPDATE_PRICE_SQL="update empty_room_tb set discount_price=? where empty_room_code=?";
	/**
	 * default constructor
	 */
	public EmptyRoomDAO(){
		
	}
	/**
	 * ���� ������ �����Ѵ�. <br/>HotelEmptyRoomDAOManager���� ȣ��ȴ�.
	 * @param hotelManagerCode ȣ�� �Ŵ����� �ڵ�
	 * @param availableDate �̿밡���� ��¥
	 * @param roomName �� �̸�
	 * @param discountPrice ���� ����
	 * @param oldPrice ���� ����
	 * @param capacity �����ο�
	 * @param space ���
	 * @param checkInTime üũ�� �ð�
	 * @param checkOutTime üũ�ƿ� ��¥
	 * @param facilityList �̿밡���� �ü� ���
	 * @param etc ��Ÿ����
	 * @return true - ���忡 �������� ��� <br/> false - ���忡 �������� ��� 
	 */
	public boolean insert(String hotelManagerCode, String availableDate, String roomName, double discountPrice, double oldPrice, int capacity, int space, String checkInTime, String checkOutTime, String facilityList, String etc){
		Connection conn = null;
		PreparedStatement pre = null;
		int rowNum=0;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(INSERT_EMPTY_ROOM_SQL);
			pre.setString(1, hotelManagerCode);
			pre.setString(2, availableDate);
			pre.setString(3, roomName);
			pre.setDouble(4, discountPrice);
			pre.setDouble(5, oldPrice);
			pre.setInt(6, capacity);
			pre.setInt(7, space);
			pre.setString(8, checkInTime);
			pre.setString(9, checkOutTime);
			pre.setString(10, facilityList);
			pre.setString(11, etc);
			rowNum=pre.executeUpdate();
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
	 * ���� ������ �����Ѵ�.<br/>HotelEmptyRoomDAOManager���� ȣ��ȴ�.
	 * @param hotelManagerCode ȣ�� �Ŵ����� �ڵ�
	 * @param roonName �� �̸�
	 * @param discountPrice ���� ����
	 * @param oldPrice ���� ����
	 * @param capacity �����ο�
	 * @param space ���
	 * @param checkInTime üũ�� �ð�
	 * @param checkOutTime üũ�ƿ� �ð�
	 * @param facilityList �̿�ü� ���
	 * @param etc ��Ÿ����
	 * @return true - ���忡 �������� ��� <br/> false - ���忡 �������� ��� 
	 */
	public boolean insert(String hotelManagerCode, String roonName, double discountPrice, double oldPrice, int capacity, int space, String checkInTime, String checkOutTime, String facilityList, String etc ){
		Connection conn = null;
		PreparedStatement pre = null;
		int rowNum=0;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(INSERT_EMPTY_ROOM_WITHOUT_DATE_SQL);
			pre.setString(1, hotelManagerCode);
			pre.setString(2, roonName);
			pre.setDouble(3, discountPrice);
			pre.setDouble(4, oldPrice);
			pre.setInt(5, capacity);
			pre.setInt(6, space);
			pre.setString(7, checkInTime);
			pre.setString(8, checkOutTime);
			pre.setString(9, facilityList);
			pre.setString(10, etc);
			rowNum=pre.executeUpdate();
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
	 * ����� ��� ���� ������ �����Ѵ�.<br/>������
	 * @return true - ������ �������� ��� <br/> false - ������ �������� ��� 
	 */
	public boolean deleteAll(){
		Connection conn = null;
		PreparedStatement pre = null;
		int rowNum = 0;
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
	 * ����� ���� ���� �� Ư�� ���� ������ �����Ѵ�. <br/>HotelEmptyRoomDAOManager���� ȣ��ȴ�.
	 * @param emptyRoomCode ���� �ڵ�
	 * @return true - ������ �������� ��� <br/> false - ������ �������� ���
	 */
	public boolean deleteEmptyRoom(String emptyRoomCode){
		Connection conn = null;
		PreparedStatement pre = null;
		int rowNum = 0;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(DELETE_EMPTY_ROOM_SQL);
			pre.setString(1, emptyRoomCode);
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
	 * ����� ���� ���� �� Ư�� ȣ�� �Ŵ����� �ø� ���������� ��� �����Ѵ�.<br/>HotelEmptyRoomDAOManager���� ȣ��ȴ�.
	 * @param hotelManagerCode ȣ�� �Ŵ����� �ڵ�
	 * @return true - ������ �������� ��� <br/> false - ������ �������� ���
	 */
	public boolean deleteEmptyRooms(String hotelManagerCode){
		Connection conn = null;
		PreparedStatement pre = null;
		int rowNum = 0;
		try{
			conn =DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(DELETE_EMPTY_ROOMS_SQL);
			pre.setString(1, hotelManagerCode);
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
	 * ����� ��� ���� ������ �����´�.<br/>������
	 * @return ��� ���� ������
	 */
	public List<EmptyRoomDTO> selectAll(){
		List<EmptyRoomDTO> list = new ArrayList<EmptyRoomDTO>();
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_ALL_SQL);
			re=pre.executeQuery();
			while(re.next()){
				String roomCode = re.getString("empty_room_code");
				String hotelManagerCode = re.getString("hotel_manager_code");
				String date = re.getString("available_date");
				String name = re.getString("empty_room_name");
				double discountPrice = re.getDouble("discount_price");
				double oldPrice = re.getDouble("old_price");
				int capacity = re.getInt("capacity");
				int space = re.getInt("space");
				String checkIn = re.getString("check_in_time");
				String checkOut = re.getString("check_out_time");
				String facilityList = re.getString("facility_list");
				String etc = re.getString("etc");
				list.add(new EmptyRoomDTO(roomCode, hotelManagerCode, date, name,discountPrice, oldPrice, capacity, space, checkIn, checkOut, facilityList, etc));
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
	 * ����� ���� ���� �� Ư�� ȣ�� �Ŵ����� �ø� ���� �ڵ���� �����´�.<br/>������
	 * @param hotelManagerCode ȣ�� �Ŵ����� �ڵ�
	 * @return Ư�� �Ŵ����� �ø� ���� �ڵ��
	 */
	public List<String> selectEmptyRoomCodes(String hotelManagerCode){
		List<String> list = new ArrayList<String>();
		Connection conn = null;
		PreparedStatement pre =null;
		ResultSet re = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_EMPTY_ROOM_CODES_SQL);
			pre.setString(1, hotelManagerCode);
			re = pre.executeQuery();
			while(re.next()){
				list.add(re.getString("empty_room_code"));
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
	 * ����� ���� ���� �� Ư�� ���� ������ �����´�. <br/>������
	 * @param emptyRoomCode ���� �ڵ�
	 * @return Ư�� ���� ����
	 */
	public EmptyRoomDTO selectEmptyRoom(String emptyRoomCode){
		EmptyRoomDTO dto = null;
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_EMPTY_ROOM_SQL);
			pre.setString(1, emptyRoomCode);
			re=pre.executeQuery();
			while(re.next()){
				String roomCode = re.getString("empty_room_code");
				String hotelManagerCode = re.getString("hotel_manager_code");
				String date = re.getString("available_date");
				String name = re.getString("empty_room_name");
				double discountPrice = re.getDouble("discount_price");
				double oldPrice = re.getDouble("old_price");
				int capacity = re.getInt("capacity");
				int space = re.getInt("space");
				String checkIn = re.getString("check_in_time");
				String checkOut = re.getString("check_out_time");
				String facilityList = re.getString("facility_list");
				String etc = re.getString("etc");
				dto = new EmptyRoomDTO(roomCode, hotelManagerCode, date, name,discountPrice, oldPrice, capacity, space, checkIn, checkOut, facilityList, etc);
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
	 * ����� ���� ���� �� Ư�� ȣ�� �Ŵ����� �ø� ���� �������� �����´�. <br/>������
	 * @param hotelManagerCode ȣ�� �Ŵ��� �ڵ�
	 * @return Ư�� ȣ�� �Ŵ����� �ø� ���� ������
	 */
	public List<EmptyRoomDTO> selectEmptyRooms(String hotelManagerCode){
		System.out.println("hotelManagerCode : " +hotelManagerCode);
		List<EmptyRoomDTO> list = new ArrayList<EmptyRoomDTO>();
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_EMPTY_ROOMS_SQL);
			pre.setString(1, hotelManagerCode);
			re=pre.executeQuery();
			while(re.next()){
				String roomCode = re.getString("empty_room_code");
				String hotelManagerCode1 = re.getString("hotel_manager_code");
				String date = re.getString("available_date");
				String name = re.getString("empty_room_name");
				double discountPrice = re.getDouble("discount_price");
				double oldPrice = re.getDouble("old_price");
				int capacity = re.getInt("capacity");
				int space = re.getInt("space");
				String checkIn = re.getString("check_in_time");
				String checkOut = re.getString("check_out_time");
				String facilityList = re.getString("facility_list");
				String etc = re.getString("etc");
				System.out.println(roomCode);
				list.add(new EmptyRoomDTO(roomCode, hotelManagerCode1, date, name,discountPrice, oldPrice, capacity, space, checkIn, checkOut, facilityList, etc));
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
	 * ����� ���� ���� �� Ư�� ��¥�� �̿� ������ ���� ������ �����´�.<br/>������
	 * @param availableDate �̿밡���� ��¥
	 * @return ���� ������
	 */
	public List<EmptyRoomDTO> selectEmptyRoomsByDate(String availableDate){
		List<EmptyRoomDTO> list = new ArrayList<EmptyRoomDTO>();
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_EMPTY_ROOMS_BY_DATE_SQL);
			pre.setString(1, availableDate);
			re=pre.executeQuery();
			while(re.next()){
				String roomCode = re.getString("empty_room_code");
				System.out.println("emptyRoomDAO :" + roomCode);
				String hotelManagerCode = re.getString("hotel_manager_code");
				String date = re.getString("available_date");
				String name = re.getString("empty_room_name");
				double discountPrice = re.getDouble("discount_price");
				double oldPrice = re.getDouble("old_price");
				int capacity = re.getInt("capacity");
				int space = re.getInt("space");
				String checkIn = re.getString("check_in_time");
				String checkOut = re.getString("check_out_time");
				String facilityList = re.getString("facility_list");
				String etc = re.getString("etc");
				list.add(new EmptyRoomDTO(roomCode, hotelManagerCode, date, name,discountPrice, oldPrice, capacity, space, checkIn, checkOut, facilityList, etc));
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
	 * ����� ���� ���� �� �� Ư�� ���� ������ ��� �����Ѵ�.<br/>HotelEmptyRoomDAOManager���� ȣ��ȴ�.
	 * @param emptyRoomCode ���� �ڵ�
	 * @param availableDate ���ο� �̿밡���� ��¥
	 * @param roomName ���ο� �� �̸�
	 * @param discountPrice ���ο� ���� ����
	 * @param oldPrice ���ο� ���� ����
	 * @param capacity ���ο� �����ο�
	 * @param space ���ο� ���
	 * @param checkInTime ���ο� üũ�� �ð�
	 * @param checkOutTime ���ο� üũ�ƿ� �ð�
	 * @param facilityList ���ο� �̿밡���� �ü��� 
	 * @param etc ���ο� ��Ÿ����
	 * @return true - ������ �������� ��� <br/> false - ������ �������� ���
	 */
	public boolean update(String emptyRoomCode,String availableDate, String roomName, double discountPrice, double oldPrice, int capacity, int space, String checkInTime, String checkOutTime, String facilityList, String etc){
		Connection conn = null;
		PreparedStatement pre = null;
		int rowNum = 0;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(UPDATE_EMPTY_ROOM_SQL);
			pre.setString(1, availableDate);
			pre.setString(2, roomName);
			pre.setDouble(3, discountPrice);
			pre.setDouble(4, oldPrice);
			pre.setInt(5, capacity);
			pre.setInt(6, space);
			pre.setString(7, checkInTime);
			pre.setString(8, checkOutTime);
			pre.setString(9, facilityList);
			pre.setString(10, etc);
			pre.setString(11, emptyRoomCode);
			rowNum=pre.executeUpdate();
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
	public boolean update(String emptyRoomCode,String roomName, double discountPrice, double oldPrice, int capacity, int space, String checkInTime, String checkOutTime, String facilityList, String etc){
		System.out.println("EmptyRoomDAO update :"+emptyRoomCode);
		Connection conn = null;
		PreparedStatement pre = null;
		int rowNum = 0;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(UPDATE_EMPTY_ROOM_SQL2);
			pre.setString(1, roomName);
			pre.setDouble(2, discountPrice);
			pre.setDouble(3, oldPrice);
			pre.setInt(4, capacity);
			pre.setInt(5, space);
			pre.setString(6, checkInTime);
			pre.setString(7, checkOutTime);
			pre.setString(8, facilityList);
			pre.setString(9, etc);
			pre.setString(10, emptyRoomCode);
			rowNum=pre.executeUpdate();
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
	 * ����� ���� ���� �� Ư�� ������ �̿� ������ ��¥�� �����Ѵ�.<br/>HotelEmptyRoomDAOManager���� ȣ��ȴ�.
	 * @param emptyRoomCode ���� �ڵ�
	 * @param availableDate ���ο� �̿밡���� ��¥
	 * @return true - ������ �������� ��� <br/> false - ������ �������� ���
	 */
	public boolean update(String emptyRoomCode, String availableDate){
		Connection conn = null;
		PreparedStatement pre = null;
		int rowNum = 0;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(UPDATE_AVAILABLE_DATE_SQL);
			pre.setString(1, availableDate);
			pre.setString(2, emptyRoomCode);
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
		if(rowNum == 1)
			return true;
		return false;
	}
	/**
	 * ����� ���� ���� �� Ư�� ������ �̿밡���� ��¥�� ���ΰ����� �����Ѵ�.<br/>HotelEmptyRoomDAOManager���� ȣ��ȴ�.
	 * @param emptyRoomCode ���� �ڵ�
	 * @param availableDate ���ο� �̿밡���� ��¥
	 * @param discountPrice ���ο� ���� ����
	 * @return true - ������ �������� ��� <br/> false - ������ �������� ���
	 */
	public boolean update(String emptyRoomCode, String availableDate, double discountPrice){
		Connection conn = null;
		PreparedStatement pre = null;
		int rowNum = 0;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(UPDATE_DATE_AND_PRICE_SQL);
			pre.setString(1, availableDate);
			pre.setDouble(2, discountPrice);
			pre.setString(3, emptyRoomCode);
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
		if(rowNum == 1)
			return true;
		return false;
	}
	/**
	 * ����� ���� ���� �� Ư�� ������ ���� ������ �����Ѵ�.<br/>HotelEmptyRoomDAOManager���� ȣ��ȴ�.
	 * @param emptyRoomCode �����ڵ�
	 * @param discountPrice ���ο� ���ΰ���
	 * @return  true - ������ �������� ��� <br/> false - ������ �������� ���
	 */
	public boolean update(String emptyRoomCode, double discountPrice){
		Connection conn = null;
		PreparedStatement pre = null;
		int rowNum = 0;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(UPDATE_PRICE_SQL);
			pre.setDouble(1, discountPrice);
			pre.setString(2, emptyRoomCode);
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
		if(rowNum == 1)
			return true;
		return false;
	}
}
