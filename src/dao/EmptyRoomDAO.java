// 0720 문정현
package dao;
import java.util.*;
import java.sql.*;

import dto.EmptyRoomDTO;
/**
 * 공실 정보를 조작하기 위해 사용한다.<br/>HotelEmptyRoomDAOManager에서 사용한다.
 * @author 문정현
 *
 */
public class EmptyRoomDAO {
	/**
	 * 공실정보를 저장하기 위해 사용되는 쿼리문(이용가능한 날짜는 자동 저장)
	 */
	private final static String INSERT_EMPTY_ROOM_WITHOUT_DATE_SQL="insert into empty_room_tb values(empty_room_code.nextVal, ?, sysdate+1, ?, ?, ?,?,?,?,?,?,?)";
	/**
	 * 공실 정보를 저장하기 위해 사용되는 쿼리문
	 */
	private static final String INSERT_EMPTY_ROOM_SQL="insert into empty_room_tb values(empty_room_code.nextVal, ?, ?, ?, ?, ?,?,?,?,?,?,?)";
	/**
	 * 저장된 공실 정보를 모두 삭제하기 위해 사용되는 쿼리문
	 */
	private static final String DELETE_ALL_SQL="delete from empty_room_tb";
	/**
	 * 저장된 공실 정보 중 특정한 공실 정보를 삭제하기 위해 사용되는 쿼리문
	 */
	private static final String DELETE_EMPTY_ROOM_SQL="delete from empty_room_tb where empty_room_code=?";
	/**
	 * 저장된 공실 정보 중 특정한 호텔 매니져가 올린 공실 정보들을 삭제하기 위해 사용되는 쿼리문
	 */
	private static final String DELETE_EMPTY_ROOMS_SQL="delete from empty_room_tb where hotel_manager_code=?";
	/**
	 * 저장된 공실 정보들을 모두 가져오기 사용되는 쿼리문
	 */
	private static final String SELECT_ALL_SQL="select empty_room_code, hotel_manager_code, TO_CHAR(available_date, 'YYYY/MM/DD') available_date, empty_room_name, discount_price, old_price, capacity, space, check_out_time, check_in_time, facility_list, etc from empty_room_tb";
	/**
	 * 저장된 공실 정보들 중 특정한 호텔 매니져가 올린 공실의 코드를 모두 가져오기 위해 사용되는 쿼리문
	 */
	private static final String SELECT_EMPTY_ROOM_CODES_SQL="select empty_room_code from empty_room_tb where hotel_manager_code=?";
	/**
	 * 저장된 공실 정보들 중 특정한 공실 정보를 가져오기 위해 사용되는 쿼리문
	 */
	private static final String SELECT_EMPTY_ROOM_SQL="select empty_room_code, hotel_manager_code, TO_CHAR(available_date, 'YYYY/MM/DD') available_date, empty_room_name, discount_price, old_price, capacity, space, check_out_time, check_in_time, facility_list, etc from empty_room_tb where empty_room_code=?";
	/**
	 * 저장된 공실 정보들 중 특정한 호텔 매니져가 올린 공실 정보들을 모두 가져오기 위해 사용되는 쿼리문
	 */
	private static final String SELECT_EMPTY_ROOMS_SQL="select empty_room_code, hotel_manager_code, TO_CHAR(available_date, 'YYYY/MM/DD') available_date, empty_room_name, discount_price, old_price, capacity, space, check_out_time, check_in_time, facility_list, etc from empty_room_tb where hotel_manager_code=?";
	/**
	 * 저장된 공실 정보들 중 특정 날짜에 이용할 수 있는 공실 정보들을 모두 가져오기 위해 사용되는 쿼리문
	 */
	private static final String SELECT_EMPTY_ROOMS_BY_DATE_SQL="select empty_room_code, hotel_manager_code, TO_CHAR(available_date, 'YYYY/MM/DD') available_date, empty_room_name, discount_price, old_price, capacity, space, check_out_time, check_in_time, facility_list, etc from empty_room_tb where available_date=?";
	/**
	 * 저장된 공실 정보들 중 특정한 공실 정보를 모두 수정하기 위해 사용되는 쿼리문
	 */
	private static final String UPDATE_EMPTY_ROOM_SQL="update empty_room_tb set available_date=?, empty_room_name=?, discount_price=?, old_price=?, capacity=?, space=?, check_in_time=?, check_out_time=?, facility_list=?, etc=? where empty_room_code=?";
	/**
	 * 공실코드를 이용하여 이용날짜를 제외한 모든정보를 수정한다. 
	 */
	private static final String UPDATE_EMPTY_ROOM_SQL2="update empty_room_tb set empty_room_name=?, discount_price=?, old_price=?, capacity=?, space=?, check_in_time=?, check_out_time=?, facility_list=?, etc=? where empty_room_code=?";
	/**
	 * 저장된 공실 정보들 중 특정한 공실 정보 중 이용가능한 날짜만 수정하기 위해 사용되는 쿼리문
	 */
	private static final String UPDATE_AVAILABLE_DATE_SQL="update empty_room_tb set available_date=? where empty_room_code=?";
	/**
	 * 저장된 공실 정보들 중 특정한 공실 정보 중 이용가능한 날짜와 할인가격을 수정하기 위해 사용되는 쿼리문 
	 */
	private static final String UPDATE_DATE_AND_PRICE_SQL="update empty_room_tb set available_date=?, discount_price=? where empty_room_code=?";
	/**
	 * 저장된 공실 정보들 중 특정한 공실 정보 중 할인가격을 수정하기 위해 사용되는 쿼리문
	 */
	private static final String UPDATE_PRICE_SQL="update empty_room_tb set discount_price=? where empty_room_code=?";
	/**
	 * default constructor
	 */
	public EmptyRoomDAO(){
		
	}
	/**
	 * 공실 정보를 저장한다. <br/>HotelEmptyRoomDAOManager에서 호출된다.
	 * @param hotelManagerCode 호텔 매니져의 코드
	 * @param availableDate 이용가능한 날짜
	 * @param roomName 방 이름
	 * @param discountPrice 할인 가격
	 * @param oldPrice 기존 가격
	 * @param capacity 수용인원
	 * @param space 평수
	 * @param checkInTime 체크인 시간
	 * @param checkOutTime 체크아웃 날짜
	 * @param facilityList 이용가능한 시설 목록
	 * @param etc 기타사항
	 * @return true - 저장에 성공했을 경우 <br/> false - 저장에 실패했을 경우 
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
	 * 공실 정보를 저장한다.<br/>HotelEmptyRoomDAOManager에서 호출된다.
	 * @param hotelManagerCode 호텔 매니져의 코드
	 * @param roonName 방 이름
	 * @param discountPrice 할인 가격
	 * @param oldPrice 기존 가격
	 * @param capacity 수용인원
	 * @param space 평수
	 * @param checkInTime 체크인 시간
	 * @param checkOutTime 체크아웃 시간
	 * @param facilityList 이용시설 목록
	 * @param etc 기타사항
	 * @return true - 저장에 성공했을 경우 <br/> false - 저장에 실패했을 경우 
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
	 * 저장된 모든 공실 정보를 삭제한다.<br/>사용안함
	 * @return true - 삭제에 성공했을 경우 <br/> false - 삭제에 실패했을 경우 
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
	 * 저장된 공실 정보 중 특정 공실 정보를 삭제한다. <br/>HotelEmptyRoomDAOManager에서 호출된다.
	 * @param emptyRoomCode 공실 코드
	 * @return true - 삭제에 성공했을 경우 <br/> false - 삭제에 실패했을 경우
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
	 * 저장된 공실 정보 중 특정 호텔 매니져가 올린 공실정보를 모두 삭제한다.<br/>HotelEmptyRoomDAOManager에서 호출된다.
	 * @param hotelManagerCode 호텔 매니져의 코드
	 * @return true - 삭제에 성공했을 경우 <br/> false - 삭제에 실패했을 경우
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
	 * 저장된 모든 공실 정보를 가져온다.<br/>사용안함
	 * @return 모든 공실 정보들
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
	 * 저장된 공실 정보 중 특정 호텔 매니져가 올린 공실 코드들을 가져온다.<br/>사용안함
	 * @param hotelManagerCode 호텔 매니져의 코드
	 * @return 특정 매니져가 올린 공실 코드들
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
	 * 저장된 공실 정보 중 특정 공실 정보를 가져온다. <br/>사용안함
	 * @param emptyRoomCode 공실 코드
	 * @return 특정 공실 정보
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
	 * 저장된 공실 정보 중 특정 호텔 매니져가 올린 공실 정보들을 가져온다. <br/>사용안함
	 * @param hotelManagerCode 호텔 매니져 코드
	 * @return 특정 호텔 매니져가 올린 공실 정보들
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
	 * 저장된 공실 정보 중 특정 날짜에 이용 가능한 공실 정보를 가져온다.<br/>사용안함
	 * @param availableDate 이용가능한 날짜
	 * @return 공실 정보들
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
	 * 저장된 공실 정보 들 중 특정 공실 정보를 모두 수정한다.<br/>HotelEmptyRoomDAOManager에서 호출된다.
	 * @param emptyRoomCode 공실 코드
	 * @param availableDate 새로운 이용가능한 날짜
	 * @param roomName 새로운 방 이름
	 * @param discountPrice 새로운 할인 가격
	 * @param oldPrice 새로운 기존 가격
	 * @param capacity 새로운 수용인원
	 * @param space 새로운 평수
	 * @param checkInTime 새로운 체크인 시간
	 * @param checkOutTime 새로운 체크아웃 시간
	 * @param facilityList 새로운 이용가능한 시설들 
	 * @param etc 새로운 기타사항
	 * @return true - 수정에 성공했을 경우 <br/> false - 수정에 실패했을 경우
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
	 * 저장된 공실 정보 중 특정 공실의 이용 가능한 날짜를 수정한다.<br/>HotelEmptyRoomDAOManager에서 호출된다.
	 * @param emptyRoomCode 공실 코드
	 * @param availableDate 새로운 이용가능한 날짜
	 * @return true - 수정에 성공했을 경우 <br/> false - 수정에 실패했을 경우
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
	 * 저장된 공실 정보 중 특정 공실의 이용가능한 날짜와 할인가격을 수정한다.<br/>HotelEmptyRoomDAOManager에서 호출된다.
	 * @param emptyRoomCode 공실 코드
	 * @param availableDate 새로운 이용가능할 날짜
	 * @param discountPrice 새로운 할인 가격
	 * @return true - 수정에 성공했을 경우 <br/> false - 수정에 실패했을 경우
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
	 * 저장된 공실 정보 중 특정 공실의 할인 가격을 수정한다.<br/>HotelEmptyRoomDAOManager에서 호출된다.
	 * @param emptyRoomCode 공실코드
	 * @param discountPrice 새로운 할인가격
	 * @return  true - 수정에 성공했을 경우 <br/> false - 수정에 실패했을 경우
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
