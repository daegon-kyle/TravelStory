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
 * �湮��û������ �����ϴ� Ŭ�����̴�
 * @author ȭ��
 *
 */
public class VisitRequestDAO 
{
	private static final String INSERT_VISITREQUEST_SQL="INSERT INTO visit_request_tb VALUES(visit_request_code.NEXTVAL, ?, ?, ?)";
	private static final String DELETEALL_VISITREQUEST_SQL="DELETE FROM visit_request_tb";
	private static final String DELETE_VISITREQUEST_SQL1="DELETE FROM visit_request_tb WHERE house_owner_code=? AND tourist_code=?";
	private static final String DELETE_VISITREQUEST_SQL2="DELETE FROM visit_request_tb WHERE house_owner_code=?";
	private static final String DELETE_VISITREQUEST_SQL3="DELETE FROM visit_request_tb WHERE tourist_code=?";
	
	private static final String SELECTALL_VISITREQUEST_SQL="SELECT visit_request_code, house_owner_code, tourist_code, request_state FROM visit_request_tb";
	private static final String SELECT_VISITREQUEST_SQL1="SELECT visit_request_code, house_owner_code, tourist_code, request_state FROM visit_request_tb WHERE house_owner_code=?";
	private static final String SELECT_VISITREQUEST_SQL2="SELECT visit_request_code, house_owner_code, tourist_code, request_state FROM visit_request_tb WHERE tourist_code=?";
	private static final String SELECT_VISITREQUEST_SQL3="SELECT visit_request_code, house_owner_code, tourist_code, request_state FROM visit_request_tb WHERE house_owner_code=? AND tourist_code=?";
	private static final String UPDATE_VISITREQUEST_SQL="UPDATE visit_request_tb SET request_state=? WHERE house_owner_code=? AND tourist_code=?"; 
	private static final String GETTOURISTCODE_SQL="SELECT visit tourist_code FROM visit_request_tb WHERE house_owner_code=? AND member_code=?";
	
	public VisitRequestDAO()
	{
	}
	
	/**
	 * �湮��û������ ����Ѵ�
	 * @param houseOwnerCode ������ �����ĺ��ڵ�
	 * @param touristCode ���ఴ �����ĺ��ڵ�
	 * @param requestState �������
	 * @return ��� �������� �����Ѵ�
	 */
	public boolean insert(String houseOwnerCode, String touristCode, String requestState)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(INSERT_VISITREQUEST_SQL);
			pstmt.setString(1, houseOwnerCode); 
			pstmt.setString(2, touristCode);  
			pstmt.setString(3, requestState);  
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
	 * ��ϵ� ��� �湮��û ���¸� �����Ѵ�
	 * @return ���� �������θ� �����Ѵ�
	 */
	public boolean deleteAll()
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(DELETEALL_VISITREQUEST_SQL);
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
	 * �����ΰ� ���ఴ ������ ������¸� �����Ѵ�
	 * @param houseOwnerCode ������ �����ĺ��ڵ�
	 * @param touristCode ���ఴ�����ĺ��ڵ�
	 * @return ���� �������θ� �����Ѵ�
	 */
	public boolean delete(String houseOwnerCode, String touristCode) //�ϳ��� ��û�� ����
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(DELETE_VISITREQUEST_SQL1);
			pstmt.setString(1,  houseOwnerCode);
			pstmt.setString(2,  touristCode);
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
	 * �������ڵ忡 �ش��ϴ� �������� ������� �������� ��� �����Ѵ�
	 * @param houseOwnerCode ������ �����ĺ��ڵ�
	 * @return ���� �������θ� �����Ѵ�
	 */
	public boolean deleteHouseOwnerCode(String houseOwnerCode)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(DELETE_VISITREQUEST_SQL2);
			pstmt.setString(1,  houseOwnerCode);
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
	 * ���ఴ �ڵ忡 �ش��ϴ� ���ఴ�� ������µ��� ��� �����Ѵ�
	 * @param touristCode ���ఴ �����ĺ��ڵ�
	 * @return ���� �������θ� �����Ѵ�
	 */
	public boolean deleteTouristCode(String touristCode)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(DELETE_VISITREQUEST_SQL3);
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
	 * ��ϵ� ��� ������¸� �˻��Ѵ�
	 * @return ��ϵ� ��� ������¸� �����Ѵ�
	 */
	public List<VisitRequestDTO> selectAll()
	{
		List<VisitRequestDTO> list=new ArrayList<VisitRequestDTO>();
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECTALL_VISITREQUEST_SQL);
			
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				VisitRequestDTO visitRequestDTO=new VisitRequestDTO(resultSet.getString("visit_request_code"), resultSet.getString("house_owner_code"), resultSet.getString("tourist_code"), resultSet.getString("request_state"));
				list.add(visitRequestDTO);
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
	 * �������ڵ带 �̿��� ������ ���ο��� �湮��û�� ��� ���ఴ����� ������µ��� �˻��Ѵ�
	 * @param houseOwnerCode ������ �����ĺ��ڵ�
	 * @return �����ο��� �湮��û�� ��� ���ఴ����� ������¸� �����Ѵ�
	 */
	public List<VisitRequestDTO> selectHouseOwnerCode(String houseOwnerCode)//�������� �������� �湮 ��û�� ���ఴ ����Ʈ �˻��Ѵ�
	{
		List<VisitRequestDTO> list=new ArrayList<VisitRequestDTO>();
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECT_VISITREQUEST_SQL1);
			pstmt.setString(1, houseOwnerCode);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				VisitRequestDTO visitRequestDTO=new VisitRequestDTO(resultSet.getString("visit_request_code"), resultSet.getString("house_owner_code"), resultSet.getString("tourist_code"), resultSet.getString("request_state"));
				list.add(visitRequestDTO);
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
	 * ���ఴ�ڵ带 �̿��� ���ఴ ������ �湮��û�� �����ε���� ������¸� �˻��Ѵ�
	 * @param touristCode ���ఴ ���� �ĺ��ڵ�
	 * @return ���ఴ�ڵ忡 �ش��ϴ� �����ΰ��� ������¸� �����Ѵ�
	 */
	public List<VisitRequestDTO> selectTouristCode(String touristCode) //���ఴ�� ������ ��û�� �����θ���Ʈ�� �˻��Ѵ�. 
	{
		List<VisitRequestDTO> list=new ArrayList<VisitRequestDTO>();
	
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECT_VISITREQUEST_SQL2);
			pstmt.setString(1, touristCode);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				VisitRequestDTO visitRequestDTO=new VisitRequestDTO(resultSet.getString("visit_request_code"), resultSet.getString("house_owner_code"), resultSet.getString("tourist_code"), resultSet.getString("request_state"));
				list.add(visitRequestDTO);
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
	 * �����ΰ� ���ఴ ������ ������¸� �˻��Ѵ�
	 * @param houseOwnerCode �������� �����ĺ��ڵ�
	 * @param touristCode ���ఴ�� �����ĺ��ڵ�
	 * @return �����ΰ� ���ఴ������ ������¸� �����Ѵ�
	 */
	public VisitRequestDTO select(String houseOwnerCode, String touristCode) 
	{
		VisitRequestDTO visitRequestDTO=null;
	
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECT_VISITREQUEST_SQL3);
			pstmt.setString(1, houseOwnerCode);
			pstmt.setString(2, touristCode);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				visitRequestDTO=new VisitRequestDTO(resultSet.getString("visit_request_code"), resultSet.getString("house_owner_code"), resultSet.getString("tourist_code"), resultSet.getString("request_state"));
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
		return visitRequestDTO;
	}
	
	/**
	 * �������ڵ�� ���ఴ �ڵ忡 �ش��ϴ� ������������� ������¸� �����Ѵ�
	 * @param houseOwnerCode ������ �����ĺ��ڵ�
	 * @param touristCode ���ఴ �����ĺ��ε�
	 * @param requestState �������
	 * @return ���� �������θ� �����Ѵ�
	 */
	public boolean update(String houseOwnerCode, String touristCode, String requestState)  
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(UPDATE_VISITREQUEST_SQL);
			pstmt.setString(1, requestState);
			pstmt.setString(2, houseOwnerCode); 
			pstmt.setString(3, touristCode);
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
	
	public String getTouristCode(String houseOwnerCode, String memberCode)
	{
		String touristCode=null;
		
		VisitRequestDTO visitRequestDTO=null;
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(GETTOURISTCODE_SQL);
			pstmt.setString(1, houseOwnerCode);
			pstmt.setString(2, memberCode);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				touristCode=resultSet.getString("tourist_code");
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
		return touristCode;
	}
	 
}
