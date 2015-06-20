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
 *  공실의 주요 정보(상세정보 중 고객에게 간략하게 보여줄 기본정보)를 관리
 * @author 화섭
 *
 */
public class EmptyRoomListDAO
{ 
	
	private static final String SELECT_EMPTYROOMLIST_SQL1="SELECT room_code, hotel_name, old_price, discount_price, room_capacity, hotel_location, available_date FROM empty_room_list_view WHERE hotel_location LIKE ? AND available_date=? ORDER BY available_date DESC, discount_price";
	private static final String SELECT_EMPTYROOMLIST_SQL2="SELECT room_code, hotel_name, old_price, discount_price, room_capacity, hotel_location, available_date FROM empty_room_list_view WHERE hotel_location LIKE ? ORDER BY available_date DESC, discount_price";
	private static final String SELECT_EMPTYROOMLIST_SQL3="SELECT room_code, hotel_name, old_price, discount_price, room_capacity, hotel_location, available_date FROM empty_room_list_view WHERE discount_price<=? ORDER BY available_date DESC, discount_price";
	private static final String SELECT_EMPTYROOMLIST_SQL4="SELECT room_code, hotel_name, old_price, discount_price, room_capacity, hotel_location, available_date FROM empty_room_list_view WHERE hotel_location LIKE ? AND discount_price<=? ORDER BY available_date DESC, discount_price";
	private static final String SELECT_EMPTYROOMLIST_SQL5="SELECT room_code, hotel_name, old_price, discount_price, room_capacity, hotel_location, available_date FROM empty_room_list_view WHERE hotel_location LIKE ? AND discount_price<=? AND available_date=? ORDER BY available_date DESC, discount_price";
	private static final String SELECT_EMPTYROOMLIST_SQL6="SELECT room_code, hotel_name, old_price, discount_price, room_capacity, hotel_location, available_date FROM empty_room_list_view WHERE hotel_name=?	ORDER BY available_date DESC, discount_price";
	private static final String SELECTALL_EMPTYROOMLIST_SQL="SELECT room_code, hotel_name, old_price, discount_price, room_capacity, hotel_location, available_date FROM empty_room_list_view ORDER BY available_date DESC, discount_price";
	
	public EmptyRoomListDAO()
	{
	}
  
	/**
	 * 해당 위치(지역)와 이용희망날짜에 해당하는 공실의 정보를 검색한다
	 * @param hotelLocation 찾고자하는 공실의 위치(지역)
	 * @param availableDate 공실 이용희망날짜
	 * @return 해당 위치(지역)와 이용희망날짜에 해당하는 공실정보
	 */
	public List<EmptyRoomListDTO> select(String hotelLocation, String availableDate)
	{
		List<EmptyRoomListDTO> list=new ArrayList<EmptyRoomListDTO>();
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection(); 
			pstmt=connection.prepareStatement(SELECT_EMPTYROOMLIST_SQL1);
			pstmt.setString(1, "%"+hotelLocation+"%");  
			pstmt.setString(2, availableDate);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{ 
				EmptyRoomListDTO emptyRoomListDTO=new EmptyRoomListDTO(resultSet.getString("room_code"), resultSet.getString("hotel_name"), resultSet.getDouble("old_price"), resultSet.getDouble("discount_price"), resultSet.getInt("room_capacity"), resultSet.getString("hotel_location"), resultSet.getString("available_date"));
				list.add(emptyRoomListDTO);
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
	 * 해당 위치(지역)에 해당하는 공실의 정보를 검색한다
	 * @param hotelLocation 찾고자하는 공실의 위치(지역)
	 * @return 해당 위치(지역)에 해당하는 공실정보들
	 */
	public List<EmptyRoomListDTO> select(String hotelLocation)
	{
		List<EmptyRoomListDTO> list=new ArrayList<EmptyRoomListDTO>();
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection(); 
			pstmt=connection.prepareStatement(SELECT_EMPTYROOMLIST_SQL2);
			pstmt.setString(1, "%"+hotelLocation+"%");
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				EmptyRoomListDTO emptyRoomListDTO=new EmptyRoomListDTO(resultSet.getString("room_code"), resultSet.getString("hotel_name"), resultSet.getDouble("old_price"), resultSet.getDouble("discount_price"), resultSet.getInt("room_capacity"), resultSet.getString("hotel_location"), resultSet.getString("available_date"));
				list.add(emptyRoomListDTO);
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
	 * 본인이 허용가능한 금액 이하 가격의 공실들을 검색한다
	 * @param discountPrice 본인이 수용 가능한 최대금액
	 * @return 본인이 수용 가능한 최대금액 이하의 공실정보들
	 */
	public List<EmptyRoomListDTO> select(double discountPrice)
	{
		List<EmptyRoomListDTO> list=new ArrayList<EmptyRoomListDTO>();
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection(); 
			pstmt=connection.prepareStatement(SELECT_EMPTYROOMLIST_SQL3);
			pstmt.setDouble(1, discountPrice);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				EmptyRoomListDTO emptyRoomListDTO=new EmptyRoomListDTO(resultSet.getString("room_code"), resultSet.getString("hotel_name"), resultSet.getDouble("old_price"), resultSet.getDouble("discount_price"), resultSet.getInt("room_capacity"), resultSet.getString("hotel_location"), resultSet.getString("available_date"));
				list.add(emptyRoomListDTO);
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
	 * 해당 위치(지역)과 본인이 허용가능한 금액 이하 가격의 공실들을 검색한다
	 * @param hotelLocation 찾고자하는 공실의 위치(지역)
	 * @param discountPrice 본인이 수용 가능한 최대금액
	 * @return 해당 위치(지역)과 본인이 허용가능한 금액 이하 가격의 공실정보들
	 */
	public List<EmptyRoomListDTO> select(String hotelLocation, double discountPrice)
	{
		List<EmptyRoomListDTO> list=new ArrayList<EmptyRoomListDTO>();
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection(); 
			pstmt=connection.prepareStatement(SELECT_EMPTYROOMLIST_SQL4);
			pstmt.setString(1, "%"+hotelLocation+"%");
			pstmt.setDouble(2, discountPrice);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				EmptyRoomListDTO emptyRoomListDTO=new EmptyRoomListDTO(resultSet.getString("room_code"), resultSet.getString("hotel_name"), resultSet.getDouble("old_price"), resultSet.getDouble("discount_price"), resultSet.getInt("room_capacity"), resultSet.getString("hotel_location"), resultSet.getString("available_date"));
				list.add(emptyRoomListDTO);
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
	 * 해당 위치(지역)과, 수용가능 최대금액, 이용희망날짜 조건에 적합한 공실들을 검색한다
	 * @param hotelLocation 찾고자하는 공실의 위치(지역)
	 * @param discountPrice 본인이 수용 가능한 최대금액
	 * @param availableDate 이용희망날짜
	 * @return 해당 위치(지역)과 수용가능 최대금액, 이용희망날짜 조건에 적합한 공실정보들
	 */
	public List<EmptyRoomListDTO> select(String hotelLocation, double discountPrice, String availableDate)
	{
		List<EmptyRoomListDTO> list=new ArrayList<EmptyRoomListDTO>();
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection(); 
			pstmt=connection.prepareStatement(SELECT_EMPTYROOMLIST_SQL5);
			pstmt.setString(1, "%"+hotelLocation+"%");
			pstmt.setDouble(2, discountPrice);
			pstmt.setString(3,  availableDate);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				EmptyRoomListDTO emptyRoomListDTO=new EmptyRoomListDTO(resultSet.getString("room_code"), resultSet.getString("hotel_name"), resultSet.getDouble("old_price"), resultSet.getDouble("discount_price"), resultSet.getInt("room_capacity"), resultSet.getString("hotel_location"), resultSet.getString("available_date"));
				list.add(emptyRoomListDTO);
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
	 * 호텔이름에 해당하는 공실들을 검색한다
	 * @param hotelName 찾고자 하는 호텔의 이름
	 * @return 호텔이름에 해당하는 공실정보들
	 */
	public List<EmptyRoomListDTO> selectByHotelName(String hotelName)
	{
		List<EmptyRoomListDTO> list=new ArrayList<EmptyRoomListDTO>();
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection(); 
			pstmt=connection.prepareStatement(SELECT_EMPTYROOMLIST_SQL6);
			pstmt.setString(1, hotelName); 
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				EmptyRoomListDTO emptyRoomListDTO=new EmptyRoomListDTO(resultSet.getString("room_code"), resultSet.getString("hotel_name"), resultSet.getDouble("old_price"), resultSet.getDouble("discount_price"), resultSet.getInt("room_capacity"), resultSet.getString("hotel_location"), resultSet.getString("available_date"));
				list.add(emptyRoomListDTO);
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
	 * 모든 공실 리스트를 검색한다.
	 * @return 등록된 모든 공실 주요정보들
	 */
	public List<EmptyRoomListDTO> selectAll()
	{
		List<EmptyRoomListDTO> list=new ArrayList<EmptyRoomListDTO>();
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection(); 
			pstmt=connection.prepareStatement(SELECTALL_EMPTYROOMLIST_SQL);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				EmptyRoomListDTO emptyRoomListDTO=new EmptyRoomListDTO(resultSet.getString("room_code"), resultSet.getString("hotel_name"), resultSet.getDouble("old_price"), resultSet.getDouble("discount_price"), resultSet.getInt("room_capacity"), resultSet.getString("hotel_location"), resultSet.getString("available_date"));
				list.add(emptyRoomListDTO);
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
