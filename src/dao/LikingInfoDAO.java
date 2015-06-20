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
 * ��ȣ�� ������ �����ϴ� Ŭ�����̴�
 * @author ȭ��
 *
 */
public class LikingInfoDAO 
{
	private static final String INSERT_LIKINGINFO_SQL="INSERT INTO liking_info_tb VALUES(liking_info_code.NEXTVAL, ?, ?, ?, ?, ?)"; 
	private static final String DELETEALL_LIKINGINFO_SQL="DELETE FROM liking_info_tb";
	private static final String DELETE_LIKINGINFO_SQL="DELETE FROM liking_info_tb WHERE liking_info_code=?";
	private static final String SELECTALL_LIKINGINFO_SQL="SELECT liking_info_code, restaurant_preference, healing_preference, attraction_preference, shopping_preference, etc_preference FROM liking_info_tb";
	private static final String SELECT_LIKINGINFO_SQL="SELECT liking_info_code, restaurant_preference, healing_preference, attraction_preference, shopping_preference, etc_preference FROM liking_info_tb WHERE liking_info_code=?";
	private static final String SELECTCODE_LIKINGINFO_SQL="SELECT liking_info_code FROM liking_info_tb WHERE restaurant_preference=? AND healing_preference=? AND attraction_preference=? AND shopping_preference=? AND etc_preference=?";
	private static final String UPDATE_LIKINGINFO_SQL="UPDATE liking_info_tb SET restaurant_preference=?, healing_preference=?, attraction_preference=?, shopping_preference=?,  etc_preference=? WHERE liking_info_code=?";
 	
	
	public LikingInfoDAO()
	{
	}
	
	/**
	 * ��ȣ�� ������ ����Ѵ�
	 * @param restaurant ���� ��ȣ��
	 * @param healing ���� ��ȣ��
	 * @param attraction ������� ��ȣ��
	 * @param shopping ���� ��ȣ��
	 * @param etc ��Ÿ
	 * @return ��ϼ������θ� �����Ѵ�
	 */
	public boolean insert(int restaurant, int healing, int attraction, int shopping, int etc)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(INSERT_LIKINGINFO_SQL);
			pstmt.setInt(1, restaurant); 
			pstmt.setInt(2, healing); 
			pstmt.setInt(3, attraction); 
			pstmt.setInt(4, shopping); 
			pstmt.setInt(5, etc); 
			result=pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
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
		
		if(result!=0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * ��ϵ� ��� ��ȣ�� ������ �����Ѵ�
	 * @return �����������θ� �����Ѵ�
	 */
	public boolean deleteAll()
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(DELETEALL_LIKINGINFO_SQL);
			result=pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
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
		
		if(result!=0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * ��ȣ���ڵ忡 �ش��ϴ� ��ȣ�� ������ �����Ѵ�
	 * @param likingInfoCode ��ȣ�� �����ĺ��ڵ�
	 * @return ���� �������θ� �����Ѵ�
	 */
	public boolean delete(String likingInfoCode)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(DELETE_LIKINGINFO_SQL);
			pstmt.setString(1,  likingInfoCode);
			result=pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
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
		
		if(result!=0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * ��ϵ� ��� ��ȣ�� ������ �˻��Ѵ�
	 * @return ��ϵ� ��� ��ȣ�� ������ �����Ѵ�
	 */
	public List<LikingInfoDTO> selectAll()
	{
		List<LikingInfoDTO> list=new ArrayList<LikingInfoDTO>();
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECTALL_LIKINGINFO_SQL);
			
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				LikingInfoDTO likingInfoDTO=new LikingInfoDTO(resultSet.getString("liking_info_code"), resultSet.getInt("restaurant_preference"), resultSet.getInt("healing_preference"), resultSet.getInt("attraction_preference"), resultSet.getInt("shopping_preference"), resultSet.getInt("etc_preference"));
				list.add(likingInfoDTO);
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
	 * ��ȣ�� �ڵ忡 �ش��ϴ� ��ȣ�� ������ �˻��Ѵ�
	 * @param likingInfoCode ��ȣ�� �����ĺ��ڵ�
	 * @return ��ȣ�� �ڵ忡 �ش��ϴ� ��ȣ�� ������ �����Ѵ�
	 */
	public LikingInfoDTO select(String likingInfoCode) //likingInfoCode�� �ش�Ǵ� ������ ã�´�
	{
		LikingInfoDTO likingInfoDTO=null;
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECT_LIKINGINFO_SQL);
			pstmt.setString(1, likingInfoCode);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				likingInfoDTO=new LikingInfoDTO(resultSet.getString("liking_info_code"), resultSet.getInt("restaurant_preference"), resultSet.getInt("healing_preference"), resultSet.getInt("attraction_preference"), resultSet.getInt("shopping_preference"), resultSet.getInt("etc_preference"));
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
		return likingInfoDTO;
	}
	
	/**
	 * ��ȣ�� ������ �ش��ϴ� ��ȣ�� �ڵ带 ã�´�
	 * @param restaurant ���� ��ȣ��
	 * @param healing ���� ��ȣ��
	 * @param attraction ������� ��ȣ��
	 * @param shopping ���� ��ȣ��
	 * @param etc ��Ÿ ��ȣ��
	 * @return ��ȣ�� ������ �ش��ϴ� ��ȣ�� �ڵ带 �����Ѵ�
	 */
	public String select(int restaurant, int healing, int attraction, int shopping, int etc) //�ش�Ǵ� �ڵ带 ã�´�
	{
		String likingInfoCode=null;

		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECTCODE_LIKINGINFO_SQL);
			pstmt.setInt(1, restaurant);
			pstmt.setInt(2, healing);
			pstmt.setInt(3, attraction);
			pstmt.setInt(4, shopping);
			pstmt.setInt(5, etc);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				likingInfoCode=resultSet.getString("liking_info_code");
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
		return likingInfoCode;
	}
	
	public boolean update(String likingInfoCode, int restaurant, int healing, int attraction, int shopping, int etc) //������ �����Ѵ�.
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(UPDATE_LIKINGINFO_SQL);
			pstmt.setInt(1, restaurant);
			pstmt.setInt(2, healing);
			pstmt.setInt(3, attraction);
			pstmt.setInt(4, shopping);
			pstmt.setInt(5, etc);
			pstmt.setString(6,  likingInfoCode);
			result=pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
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
		
		if(result!=0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
