//작성날짜 : 2014/7/19
//작성자 : 이화섭

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.*;
import model.*;

/**
 *  공실 상세 정보에 접근하여 관리하는 클래스
 * @author 화섭
 *
 */
public class EmptyRoomDetailInfoDAO
{ 
	private static final String SELECT_EMPTYROOMDETAIL_SQL1="SELECT room_code, room_name, hotel_name, available_date, hotel_location, old_price, discount_price, check_in_time, check_out_time, room_space, room_capacity, hotel_facility_list, room_explanation, hotel_page_path, hotel_introduction FROM empty_room_detail_info_view	WHERE hotel_location LIKE ? ORDER BY available_date DESC, discount_price";	
	private static final String SELECT_EMPTYROOMDETAIL_SQL2="SELECT room_code, room_name, hotel_name, available_date, hotel_location, old_price, discount_price, check_in_time, check_out_time, room_space, room_capacity, hotel_facility_list, room_explanation, hotel_page_path, hotel_introduction FROM empty_room_detail_info_view	WHERE hotel_location LIKE ? AND available_date=?	ORDER BY available_date DESC, discount_price";
	private static final String SELECT_EMPTYROOMDETAIL_SQL3="SELECT room_code, room_name, hotel_name, available_date, hotel_location, old_price, discount_price, check_in_time, check_out_time, room_space, room_capacity, hotel_facility_list, room_explanation, hotel_page_path, hotel_introduction FROM empty_room_detail_info_view	WHERE room_code=?	ORDER BY available_date DESC, discount_price";
	private static final String SELECTALL_EMPTYROOMDETAIL_SQL="SELECT room_code, room_name, hotel_name, available_date, hotel_location, old_price, discount_price, check_in_time, check_out_time, room_space, room_capacity, hotel_facility_list, room_explanation, hotel_page_path, hotel_introduction FROM empty_room_detail_info_view ORDER BY available_date DESC, discount_price";
	
	public EmptyRoomDetailInfoDAO()
	{
	}
 
	/**
	 * 해당 위치(지역)에 해당하는 공실의 정보를 검색한다
	 * @param hotelLocation 찾고자하는 공실의 위치(지역)
	 * @return 해당 위치(지역)에 해당하는 공실의 정보들
	 */
	public List<EmptyRoomDetailInfoDTO> selectEmptyRoomInfos(String hotelLocation)
	{
		List<EmptyRoomDetailInfoDTO> list=new ArrayList<EmptyRoomDetailInfoDTO>();
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection(); 
			pstmt=connection.prepareStatement(SELECT_EMPTYROOMDETAIL_SQL1);
			pstmt.setString(1, "%"+hotelLocation+"%");  
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				EmptyRoomDetailInfoDTO emptyRoomDetailInfoDTO=new EmptyRoomDetailInfoDTO(resultSet.getString("room_code"), resultSet.getString("hotel_name"), resultSet.getString("room_name"), resultSet.getString("available_date"), resultSet.getString("hotel_location"), resultSet.getDouble("old_price"), resultSet.getDouble("discount_price"), resultSet.getString("check_in_time"), resultSet.getString("check_out_time"), resultSet.getInt("room_space"), resultSet.getInt("room_capacity"),resultSet.getString("hotel_facility_list"), resultSet.getString("room_explanation"), resultSet.getString("hotel_page_path"), resultSet.getString("hotel_introduction"));
				list.add(emptyRoomDetailInfoDTO);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(resultSet!=null)
			{
				try
				{
					resultSet.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			if(pstmt!=null)
			{
				try
				{
					pstmt.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			if(connection!=null)
			{
				try
				{
					connection.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	/**
	 * 이용희망 날짜와 위치(지역)에 해당하는 공실의 정보를 검색한ㄷ아
	 * @param availableDate 이용희망 날짜
	 * @param hotelLocation 찾고자하는 공실의 위치(지역)
	 * @return 이용희망 날짜와 위치(지역)에 해당하는 공실의 정보들
	 */
	public List<EmptyRoomDetailInfoDTO> selectEmptyRoomInfos(String availableDate, String hotelLocation)
	{
		List<EmptyRoomDetailInfoDTO> list=new ArrayList<EmptyRoomDetailInfoDTO>();
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection(); 
			pstmt=connection.prepareStatement(SELECT_EMPTYROOMDETAIL_SQL2); 
			pstmt.setString(1, "%"+hotelLocation+"%");  
			pstmt.setString(2, availableDate);  
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				EmptyRoomDetailInfoDTO emptyRoomDetailInfoDTO=new EmptyRoomDetailInfoDTO(resultSet.getString("room_code"), resultSet.getString("hotel_name"), resultSet.getString("room_name"), resultSet.getString("available_date"), resultSet.getString("hotel_location"), resultSet.getDouble("old_price"), resultSet.getDouble("discount_price"), resultSet.getString("check_in_time"), resultSet.getString("check_out_time"), resultSet.getInt("room_space"), resultSet.getInt("room_capacity"),resultSet.getString("hotel_facility_list"), resultSet.getString("room_explanation"), resultSet.getString("hotel_page_path"), resultSet.getString("hotel_introduction"));
				list.add(emptyRoomDetailInfoDTO);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(resultSet!=null)
			{
				try
				{
					resultSet.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			if(pstmt!=null)
			{
				try
				{
					pstmt.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			if(connection!=null)
			{
				try
				{
					connection.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	/**
	 * 공실 고유 식별코드에 해당하는 공실의 정보를 검색한다
	 * @param roomCode 공실 고유 식별코드
	 * @return 공실 고유 식별코드에 해당하는 공실의 정보
	 */
	public EmptyRoomDetailInfoDTO selectEmptyRoomInfo(String roomCode)
	{
		EmptyRoomDetailInfoDTO emptyRoomDetailInfoDTO=new EmptyRoomDetailInfoDTO();
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection(); 
			pstmt=connection.prepareStatement(SELECT_EMPTYROOMDETAIL_SQL3);
			pstmt.setString(1, roomCode);    
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				emptyRoomDetailInfoDTO=new EmptyRoomDetailInfoDTO(resultSet.getString("room_code"), resultSet.getString("hotel_name"), resultSet.getString("room_name"), resultSet.getString("available_date"), resultSet.getString("hotel_location"), resultSet.getDouble("old_price"), resultSet.getDouble("discount_price"), resultSet.getString("check_in_time"), resultSet.getString("check_out_time"), resultSet.getInt("room_space"), resultSet.getInt("room_capacity"),resultSet.getString("hotel_facility_list"), resultSet.getString("room_explanation"), resultSet.getString("hotel_page_path"), resultSet.getString("hotel_introduction"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(resultSet!=null)
			{
				try
				{
					resultSet.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			if(pstmt!=null)
			{
				try
				{
					pstmt.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			if(connection!=null)
			{
				try
				{
					connection.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		return emptyRoomDetailInfoDTO;
	}
	
	/**
	 * 모든 공실의 정보를 검색한다
	 * @return 등록된 모든 공실의 정보들
	 */
	public List<EmptyRoomDetailInfoDTO> selectAllEmptyRoomInfo()
	{
		List<EmptyRoomDetailInfoDTO> list=new ArrayList<EmptyRoomDetailInfoDTO>();
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection(); 
			pstmt=connection.prepareStatement(SELECTALL_EMPTYROOMDETAIL_SQL); 
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				EmptyRoomDetailInfoDTO emptyRoomDetailInfoDTO=new EmptyRoomDetailInfoDTO(resultSet.getString("room_code"), resultSet.getString("hotel_name"), resultSet.getString("room_name"), resultSet.getString("available_date"), resultSet.getString("hotel_location"), resultSet.getDouble("old_price"), resultSet.getDouble("discount_price"), resultSet.getString("check_in_time"), resultSet.getString("check_out_time"), resultSet.getInt("room_space"), resultSet.getInt("room_capacity"),resultSet.getString("hotel_facility_list"), resultSet.getString("room_explanation"), resultSet.getString("hotel_page_path"), resultSet.getString("hotel_introduction"));
				list.add(emptyRoomDetailInfoDTO);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(resultSet!=null)
			{
				try
				{
					resultSet.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			if(pstmt!=null)
			{
				try
				{
					pstmt.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			if(connection!=null)
			{
				try
				{
					connection.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
}
