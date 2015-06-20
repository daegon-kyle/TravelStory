//�ۼ���¥ : 2014/7/19
//�ۼ��� : ��ȭ��

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
 *  ���� �� ������ �����Ͽ� �����ϴ� Ŭ����
 * @author ȭ��
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
	 * �ش� ��ġ(����)�� �ش��ϴ� ������ ������ �˻��Ѵ�
	 * @param hotelLocation ã�����ϴ� ������ ��ġ(����)
	 * @return �ش� ��ġ(����)�� �ش��ϴ� ������ ������
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
	 * �̿���� ��¥�� ��ġ(����)�� �ش��ϴ� ������ ������ �˻��Ѥ���
	 * @param availableDate �̿���� ��¥
	 * @param hotelLocation ã�����ϴ� ������ ��ġ(����)
	 * @return �̿���� ��¥�� ��ġ(����)�� �ش��ϴ� ������ ������
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
	 * ���� ���� �ĺ��ڵ忡 �ش��ϴ� ������ ������ �˻��Ѵ�
	 * @param roomCode ���� ���� �ĺ��ڵ�
	 * @return ���� ���� �ĺ��ڵ忡 �ش��ϴ� ������ ����
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
	 * ��� ������ ������ �˻��Ѵ�
	 * @return ��ϵ� ��� ������ ������
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
