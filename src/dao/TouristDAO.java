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
 * ���ఴ ������ �����ϴ� Ŭ�����̴�
 * @author ȭ��
 *
 */
public class TouristDAO 
{
	private static final String INSERT_TOURIST_SQL="INSERT INTO tourist_tb VALUES(tourist_code.NEXTVAL, ?, ?, ?, ?, ?, ?)";
	private static final String DELETEALL_TOURIST_SQL="DELETE FROM tourist_tb";
	private static final String DELETE_TOURIST_SQL1="DELETE FROM tourist_tb WHERE tourist_code=?";
	private static final String DELETE_TOURIST_SQL2="DELETE FROM tourist_tb WHERE member_code=?";
	private static final String SELECTALL_TOURIST_SQL="SELECT tourist_code, member_code, job, companion_num, TO_CHAR(arrival_date, 'YYYY/MM/DD') arrival_date, TO_CHAR(departure_date, 'YYYY/MM/DD') departure_date, self_introduction FROM tourist_tb";
	private static final String SELECT_TOURIST_SQL1="SELECT member_code FROM tourist_tb WHERE tourist_code=?";
	private static final String SELECT_TOURIST_SQL2="SELECT tourist_code FROM tourist_tb WHERE member_code=?";
	private static final String SELECT_TOURIST_SQL3="SELECT tourist_code, member_code, job, companion_num, TO_CHAR(arrival_date, 'YYYY/MM/DD') arrival_date, TO_CHAR(departure_date, 'YYYY/MM/DD') departure_date, self_introduction FROM tourist_tb WHERE tourist_code=?";
	private static final String UPDATE_TOURIST_SQL="UPDATE tourist_tb SET job=?, companion_num=?, arrival_date=?, departure_date=?, self_introduction=? WHERE tourist_code=?";
	private static final String GET_TOURIST_SQL="SELECT max(tourist_code) maxcode FROM tourist_tb";
 
	   
	public TouristDAO()
	{
	}
	
	/**
	 * ���ఴ�� ������ ����ϴ� Ŭ�����̴�
	 * @param memberCode ȸ�� �����ĺ��ڵ�
	 * @param job ����
	 * @param companionNum �����ڼ�
	 * @param arrivalDate �湮��
	 * @param departureDate �湮������
	 * @param selfIntroduction �ڱ�Ұ�
	 * @return ��� �������θ� �����Ѵ�
	 */
	public boolean insert(String memberCode, String job, int companionNum, String arrivalDate, String departureDate, String selfIntroduction)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(INSERT_TOURIST_SQL);
			pstmt.setString(1, memberCode); 
			pstmt.setString(2, job); 
			pstmt.setInt(3, companionNum);  
			pstmt.setString(4, arrivalDate);  
			pstmt.setString(5, departureDate);  
			pstmt.setString(6, selfIntroduction);  
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
	 * ��ϵ� ��� ���ఴ�� ������ �����Ѵ�
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
			pstmt=connection.prepareStatement(DELETEALL_TOURIST_SQL);
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
	 * ���ఴ�ڵ忡 �ش��ϴ� ���ఴ�������� �����Ѵ�
	 * @param touristCode ���ఴ�� �����ĺ��ڵ�
	 * @return ���� �������θ� �˻��Ѵ�
	 */
	public boolean deleteTouristCode(String touristCode)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(DELETE_TOURIST_SQL1);
			pstmt.setString(1,  touristCode);
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
	 * ȸ���ڵ忡 �ش��ϴ� ���ఴ�������� �����Ѵ�
	 * @param memberCode ȸ�������ĺ��ڵ�
	 * @return ���� �������θ� �����Ѵ�
	 */
	public boolean deleteMemberCode(String memberCode)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(DELETE_TOURIST_SQL2);
			pstmt.setString(1,  memberCode);
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
	 * ��ϵ� ��� ���ఴ���� ������ �˻��Ѵ�
	 * @return ��ϵ� ��� ���ఴ���� ������ �����Ѵ�
	 */
	public List<TouristDTO> selectAll()
	{
		List<TouristDTO> list=new ArrayList<TouristDTO>();
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECTALL_TOURIST_SQL);
			
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				TouristDTO touristDTO=new TouristDTO(resultSet.getString("tourist_code"), resultSet.getString("member_code"), resultSet.getString("job"), resultSet.getInt("companion_num"), resultSet.getString("arrival_date"), resultSet.getString("departure_date"), resultSet.getString("self_introduction"));
				list.add(touristDTO);
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
	 * ���ఴ�ڵ忡 �ش��ϴ� ȸ���� �ڵ带 �˻��Ѵ�
	 * @param touristCode ���ఴ �����ĺ��ڵ�
	 * @return ���ఴ�ڵ忡 �ش��ϴ� ȸ���� �ڵ带 �����Ѵ�
	 */
	public String selectMemberCode(String touristCode) //���ఴ�ڵ�� ȸ���ڵ带 ã�´�
	{
		String memberCode=null;
	
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECT_TOURIST_SQL1);
			pstmt.setString(1, touristCode);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				memberCode=resultSet.getString("member_code"); 
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
		return memberCode;
	}
	
	/**
	 * ȸ���ڵ忡 �ش��ϴ� ���ఴ �ڵ�(ȸ���� ���ఴ������ �Է��Ͽ� ����ҋ����� ������, ��ȸ���� �������� ���ఴ�ڵ� ���� ����)���� �˻��Ѵ�
	 * @param memberCode ȸ�� �����ĺ��ڵ�
	 * @return ȸ���ڵ忡 �ش��ϴ� ���ఴ�ڵ���� �����Ѵ�
	 */
	public List<String> selectTouristCode(String memberCode) //ȸ���ڵ�� ���ఴ�ڵ���� ã�ƿ´�(�� ȸ���� ������ �����ο��� ��û�� ���)
	{
		List<String> list=new ArrayList<String>();
	
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECT_TOURIST_SQL2);
			pstmt.setString(1, memberCode);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				String touristCode=resultSet.getString("tourist_code");
				list.add(touristCode);
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
	 * ���ఴ�ڵ忡 �ش��ϴ� ���ఴ�� ������ �˻��Ѵ�
	 * @param touristCode ���ఴ �����ĺ��ڵ�
	 * @return ���ఴ�ڵ忡 �ش��ϴ� ���ఴ�� ������ �����Ѵ�
	 */
	public TouristDTO select(String touristCode)
	{
		TouristDTO touristDTO=null;
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECT_TOURIST_SQL3);
			pstmt.setString(1, touristCode);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				touristDTO=new TouristDTO(resultSet.getString("tourist_code"), resultSet.getString("member_code"), resultSet.getString("job"), resultSet.getInt("companion_num"), resultSet.getString("arrival_date"), resultSet.getString("departure_date"), resultSet.getString("self_introduction"));
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
		return touristDTO;
	}
	
	/**
	 * ���ఴ�ڵ忡 �ش��ش� ���ఴ ������ ����, �����ڼ�, �湮��, �湮������, �ڱ�Ұ��� �����Ѵ�
	 * @param touristCode ���ఴ �����ĺ��ڵ�
	 * @param job ���ఴ ����
	 * @param companionNum ���ఴ �����ڼ�
	 * @param arrivalDate ���ఴ �湮��
	 * @param departureDate ���ఴ �湮������
	 * @param selfIntroduction ���ఴ �ڱ�Ұ�
	 * @return �����������θ� �����Ѵ�
	 */
	public boolean update(String touristCode, String job, int companionNum, String arrivalDate, String departureDate, String selfIntroduction)  
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(UPDATE_TOURIST_SQL);
			pstmt.setString(1, job);
			pstmt.setInt(2, companionNum); 
			pstmt.setString(3, arrivalDate);
			pstmt.setString(4, departureDate); 
			pstmt.setString(5, selfIntroduction);
			pstmt.setString(6, touristCode); 
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
	
	public String getTouristMaxCode()
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		String maxCode=null;
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(GET_TOURIST_SQL);
			 
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				maxCode=resultSet.getString("maxcode");
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
		return maxCode;
	}
	 
}
