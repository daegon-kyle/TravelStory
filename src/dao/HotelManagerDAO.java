// 0720 문정현
package dao;

import java.util.*;
import java.sql.*;
import model.*;
import dto.HotelManagerDTO;
/**
 * 호텔  정보를 조작하기 위해 사용한다.
 * @author 문정현
 *
 */
public class HotelManagerDAO {
	/**
	 * 호텔  정보를 저장하기 위해 사용되는 쿼리문
	 */
	private static final String INSERT_HOTEL_MANAGER_SQL="insert into hotel_manager_tb values(hotel_manager_code.nextVal, ?, ?, ?, ?,?)";
	/**
	 * 저장된 모든 호텔  정보를 삭제하기 위해 사용되는 쿼리문
	 */
	private static final String DELETE_ALL_SQL="delete from hotel_manager_tb";
	/**
	 * 저장된 호텔  정보 중 특정 호텔  정보를 삭제하기 위해 사용되는 쿼리문
	 */
	private static final String DELETE_HOTEL_MANAGER_BY_MEMBER_CODE_SQL="delete from hotel_manager_tb where member_code=?";
	/**
	 * 저장된 모든 호텔  정보를 가져오기 위해 사용되는 쿼리문
	 */
	private static final String SELECT_ALL_SQL="select * from hotel_manager_tb";
	/**
	 * 저장된 호텔  정보 중 호텔 매니져 코드를 이용하여 특정 호텔  정보를 가져오기 위해 사용되는 쿼리문
	 */
	private static final String SELECT_HOTEL_MANAGER_BY_MANAGER_CODE_SQL="select * from hotel_manager_tb where hotel_manager_code=?";
	/**
	 * 저장된 호텔  정보 중 회원 코드를 이용하여 특정 호텔  정보를 가져오기 위해 사용되는 쿼리문
	 */
	private static final String SELECT_HOTEL_MANAGER_BY_MEMBER_CODE_SQL="select * from hotel_manager_tb where member_code=?";
	/**
	 * 저장된 호텔  정보 중 특정 지역에 위치한 호텔의 정보를 가져오기 위해 사용되는 쿼리문
	 */
	private static final String SELECT_HOTEL_MANAGER_BY_LOCATION_SQL="select * from hotel_manager_tb where hotel_location LIKE ?";
	/**
	 * 저장된 호텔 정보 중 회원 코드를 이용해 호텔 매니져의 코드를 가져오기 위해 사용되는 쿼리문
	 */
	private static final String SELECT_HOTEL_MANAGER_CODE_BY_MEMBER_CODE_SQL="select hotel_manager_code from hotel_manager_tb where member_code=?";
	/**
	 * 저장된 호텔 정보 중 특정 호텔의 정보를 수정하기 위해 사용되는 쿼리문
	 */
	private static final String UPDATE_HOTEL_MANAGER_SQL="update hotel_manager_tb set  hotel_name=?, hotel_location=?, hotel_introduction=?, reservation_page_path=? where hotel_manager_code=?";
	/**
	 * default constructor
	 */
	public HotelManagerDAO(){
		
	}
	/**
	 * 새로운 호텔 정보를 저장한다.
	 * @param memberCode 회원 코드
	 * @param hotelName 호텔 이름
	 * @param hotelLocation 호텔 주소
	 * @param hotelIntroduction 호텔 소개
	 * @param reservationPagePath 호텔 홈페이지 url
	 * @return true - 저장에 성공했을 경우 <br/> false - 저장에 실패했을 경우
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
	 * 저장된 모든 호텔 정보를 삭제한다.
	 * @return true - 삭제에 성공했을 경우 <br/> false - 삭제에 실패했을 경우
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
	 * 저장된 호텔 정보 중 특정 회원이 등록한 호텔 정보를 삭제한다.
	 * @param memberCode 회원 코드
	 * @return true - 삭제에 성공했을 경우 <br/> false - 삭제에 실패했을 경우
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
	 * 저장된 모든 호텔 정보를 가져온다.
	 * @return 모든 호텔 정보들
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
	 * 호텔 정보를 등록한 특정 회원의 호텔 매니져 코드를 가져온다.
	 * @param memberCode 회원 코드
	 * @return 호텔 매니져 코드
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
	 * 저장된 호텔 정보 중 특정 호텔 매니져가 등록한 호텔 정보를 가져온다.
	 * @param hotelManagerCode 호텔 매니져 코드
	 * @return 특정 호텔을 호텔 정보
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
	 * 저장된 호텔 정보 중 특정 회원이 등록한 호텔 정보를 가져온다.
	 * @param memberCode 회원 코드
	 * @return 특정 호텔 정보
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
	 * 저장된 호텔 정보 중 특정 지역에 위치한 호텔들의 정보를 가져온다.
	 * @param location 특정 지역
	 * @return 특정 지역을 호텔 정보들
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
	 * 저장된 호텔 정보 중 특정 호텔의 정보를 수정한다.
	 * @param hotelManagerCode 호텔 매니져 코드
	 * @param hotelName 새로운 호텔 이름
	 * @param hotelLocation 새로운 호텔 주소
	 * @param hotelIntroduction 새로운 호텔 소개
	 * @param reservationPagePath 새로운 호텔 홈페이지 url
	 * @return true - 수정에 성공했을 겨우 <br/> false - 수정에 실패했을 경우
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
