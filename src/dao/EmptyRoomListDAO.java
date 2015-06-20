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
 *  ������ �ֿ� ����(������ �� ������ �����ϰ� ������ �⺻����)�� ����
 * @author ȭ��
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
	 * �ش� ��ġ(����)�� �̿������¥�� �ش��ϴ� ������ ������ �˻��Ѵ�
	 * @param hotelLocation ã�����ϴ� ������ ��ġ(����)
	 * @param availableDate ���� �̿������¥
	 * @return �ش� ��ġ(����)�� �̿������¥�� �ش��ϴ� ��������
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
	 * �ش� ��ġ(����)�� �ش��ϴ� ������ ������ �˻��Ѵ�
	 * @param hotelLocation ã�����ϴ� ������ ��ġ(����)
	 * @return �ش� ��ġ(����)�� �ش��ϴ� ����������
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
	 * ������ ��밡���� �ݾ� ���� ������ ���ǵ��� �˻��Ѵ�
	 * @param discountPrice ������ ���� ������ �ִ�ݾ�
	 * @return ������ ���� ������ �ִ�ݾ� ������ ����������
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
	 * �ش� ��ġ(����)�� ������ ��밡���� �ݾ� ���� ������ ���ǵ��� �˻��Ѵ�
	 * @param hotelLocation ã�����ϴ� ������ ��ġ(����)
	 * @param discountPrice ������ ���� ������ �ִ�ݾ�
	 * @return �ش� ��ġ(����)�� ������ ��밡���� �ݾ� ���� ������ ����������
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
	 * �ش� ��ġ(����)��, ���밡�� �ִ�ݾ�, �̿������¥ ���ǿ� ������ ���ǵ��� �˻��Ѵ�
	 * @param hotelLocation ã�����ϴ� ������ ��ġ(����)
	 * @param discountPrice ������ ���� ������ �ִ�ݾ�
	 * @param availableDate �̿������¥
	 * @return �ش� ��ġ(����)�� ���밡�� �ִ�ݾ�, �̿������¥ ���ǿ� ������ ����������
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
	 * ȣ���̸��� �ش��ϴ� ���ǵ��� �˻��Ѵ�
	 * @param hotelName ã���� �ϴ� ȣ���� �̸�
	 * @return ȣ���̸��� �ش��ϴ� ����������
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
	 * ��� ���� ����Ʈ�� �˻��Ѵ�.
	 * @return ��ϵ� ��� ���� �ֿ�������
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
