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
 * �������� ������ �����ϴ� Ŭ�����̴�
 * @author ȭ��
 *
 */
public class HouseOwnerDAO 
{
	private static final String INSERT_HOUSEOWNER_SQL="INSERT INTO house_owner_tb VALUES(house_owner_code.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String DELETEALL_HOUSEOWNER_SQL="DELETE FROM house_owner_tb";
	private static final String DELETE_HOUSEOWNER_SQL1="DELETE FROM house_owner_tb WHERE house_owner_code=?";
	private static final String DELETE_HOUSEOWNER_SQL2="DELETE FROM house_owner_tb WHERE member_code=?";
	private static final String SELECTALL_HOUSEOWNER_SQL="SELECT house_owner_code, member_code, job,TO_CHAR(visit_start_date, 'YYYY/MM/DD') visit_start_date, TO_CHAR(visit_end_date, 'YYYY/MM/DD') visit_end_date, self_introduction, married_state, address, etc FROM house_owner_tb";
	private static final String SELECT_HOUSEOWNER_SQL1="SELECT house_owner_code, member_code, job, TO_CHAR(visit_start_date, 'YYYY/MM/DD') visit_start_date, TO_CHAR(visit_end_date, 'YYYY/MM/DD') visit_end_date, self_introduction, married_state, address, etc FROM house_owner_tb WHERE house_owner_code=?";
	private static final String SELECT_HOUSEOWNER_SQL2="SELECT house_owner_code FROM house_owner_tb WHERE member_code=?";
	private static final String SELECT_HOUSEOWNER_SQL3="SELECT house_owner_code, member_code, job, TO_CHAR(visit_start_date, 'YYYY/MM/DD') visit_start_date, TO_CHAR(visit_end_date, 'YYYY/MM/DD') visit_end_date, self_introduction, married_state, address, etc FROM house_owner_tb WHERE member_code=?";
	private static final String SELECT_HOUSEOWNER_SQL4="SELECT house_owner_code, member_code, job, TO_CHAR(visit_start_date, 'YYYY/MM/DD') visit_start_date, TO_CHAR(visit_end_date, 'YYYY/MM/DD') visit_end_date, self_introduction, married_state, address, etc FROM house_owner_tb WHERE address like ? AND visit_start_date<=? AND ?<=visit_end_date";
	private static final String UPDATE_HOUSEOWNER_SQL="UPDATE house_owner_tb SET job=?, visit_start_date=?, visit_end_date=?, self_introduction=?, married_state=?, address=?, etc=?  WHERE house_owner_code=?";
	
	public HouseOwnerDAO()
	{
	}
	
	/**
	 * �������� ������ ����Ѵ�
	 * @param memberCode ȸ�� �����ĺ��ڵ�
	 * @param job  ����
	 * @param visitStartDate �湮���ɽ�����
	 * @param visitEndDate �湮���ɸ�����
	 * @param selfIntroduction �ڱ�Ұ�
	 * @param marriedState ��ȥ����
	 * @param address �ּ�
	 * @param etc ������ ���� ���� ������ �Ұ�
	 * @return ��� �������θ� �����Ѵ�
	 */
	public boolean insert(String memberCode, String job, String visitStartDate, String visitEndDate, String selfIntroduction, String marriedState, String address, String etc)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(INSERT_HOUSEOWNER_SQL);
			pstmt.setString(1, memberCode); 
			pstmt.setString(2, job);
			pstmt.setString(3, visitStartDate);  
			pstmt.setString(4, visitEndDate);  
			pstmt.setString(5, selfIntroduction);  
			pstmt.setString(6, marriedState);  
			pstmt.setString(7, address);  
			pstmt.setString(8, etc);  
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
				{e.printStackTrace();
				}
			}
			if(connection!=null)
			{
				try
				{
					connection.close();
				}
				catch(Exception e)
				{e.printStackTrace();}
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
	 * ��ϵ� ��� �������������� �����Ѵ�
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
			pstmt=connection.prepareStatement(DELETEALL_HOUSEOWNER_SQL);
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
				{e.printStackTrace();
				}
			}
			if(connection!=null)
			{
				try
				{
					connection.close();
				}
				catch(Exception e){e.printStackTrace();}
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
	 * �������ڵ忡 �ش��ϴ� ������������ �����Ѵ�
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
			pstmt=connection.prepareStatement(DELETE_HOUSEOWNER_SQL1);
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
	 * ȸ���ڵ忡 �ش��ϴ� �������� ������ �����Ѵ�
	 * @param memberCode ȸ�� �����ĺ��ڵ�
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
			pstmt=connection.prepareStatement(DELETE_HOUSEOWNER_SQL2);
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
	 * ��ϵ� ��� �������� ������ �˻��Ѵ�
	 * @return ��ϵ� ��� �������� ������ �����Ѵ�
	 */
	public List<HouseOwnerDTO> selectAll()
	{
		List<HouseOwnerDTO> list=new ArrayList<HouseOwnerDTO>();
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECTALL_HOUSEOWNER_SQL);
			
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				HouseOwnerDTO houseOwnerDTO=new HouseOwnerDTO(resultSet.getString("house_owner_code"), resultSet.getString("member_code"), resultSet.getString("job"), resultSet.getString("visit_start_date"), resultSet.getString("visit_end_date"), resultSet.getString("self_introduction"), resultSet.getString("married_state"), resultSet.getString("address"), resultSet.getString("etc"));
				list.add(houseOwnerDTO);
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
	 * ������ �ڵ忡 �ش��ϴ� �������� ������ �˻��Ѵ�
	 * @param houseOwnerCode ������ �����ĺ��ڵ�
	 * @return �������ڵ忡 �ش��ϴ� �������� ������ �����Ѵ�
	 */
	public HouseOwnerDTO selectHouseOwner(String houseOwnerCode) 
	{
		HouseOwnerDTO houseOwnerDTO=null;
	
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECT_HOUSEOWNER_SQL1);
			pstmt.setString(1, houseOwnerCode);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				houseOwnerDTO=new HouseOwnerDTO(resultSet.getString("house_owner_code"), resultSet.getString("member_code"), resultSet.getString("job"), resultSet.getString("visit_start_date"), resultSet.getString("visit_end_date"), resultSet.getString("self_introduction"), resultSet.getString("married_state"), resultSet.getString("address"), resultSet.getString("etc"));
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
		return houseOwnerDTO;
	}
	
	/**
	 * ȸ���ڵ忡 �ش��ϴ� �������� �ڵ带 �˻��Ѵ�
	 * @param memberCode ȸ�� �����ĺ��ڵ�
	 * @return ȸ���ڵ忡 �ش��ϴ� �������� ������ �����Ѵ�
	 */
	public String selectHouseOwnerCode(String memberCode) //ȸ���ڵ�� �������ڵ带 ã���ش� 
	{
		String houseOwnerCode=null;
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECT_HOUSEOWNER_SQL2);
			pstmt.setString(1, memberCode);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				houseOwnerCode=resultSet.getString("house_owner_code");
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
		return houseOwnerCode;
	}
	
	/**
	 * ȸ���ڵ忡 �ش��ϴ� �������� ������ �˻��Ѵ�
	 * @param memberCode ȸ�� �����ĺ��ڵ�
	 * @return ȸ���ڵ忡 �ش��ϴ� �������� ������ �����Ѵ�
	 */
	public HouseOwnerDTO selectMemberCode(String memberCode) //ȸ���ڵ�� �������� ������ ã���ش� 
	{
		HouseOwnerDTO houseOwnerDTO=null;
	
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECT_HOUSEOWNER_SQL3);
			pstmt.setString(1, memberCode);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				houseOwnerDTO=new HouseOwnerDTO(resultSet.getString("house_owner_code"), resultSet.getString("member_code"), resultSet.getString("job"), resultSet.getString("visit_start_date"), resultSet.getString("visit_end_date"), resultSet.getString("self_introduction"), resultSet.getString("married_state"), resultSet.getString("address"), resultSet.getString("etc"));
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
		return houseOwnerDTO;
	}


	/**
	 * ���ּҿ� �湮 ���� �����ϰ� �������� ��ġ�ϴ� �������� ������ �˻��Ѵ� 
	 * @param address �������� �ּ�
	 * @param visitStartDate �湮 ���� ������
	 * @param visitEndDate �湮 ���� ������
	 * @return ���ּҿ� �湮 ���� �����ϰ� �����Ͽ� ��ġ�ϴ� �������� ������ �����Ѵ�
	 */
	public HouseOwnerDTO selectHouseOwners(String address, String visitStartDate, String visitEndDate)  
	{
		HouseOwnerDTO houseOwnerDTO=null;
	
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECT_HOUSEOWNER_SQL4);
			pstmt.setString(1, "%"+address+"%");
			pstmt.setString(2, visitStartDate);
			pstmt.setString(3, visitEndDate);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				houseOwnerDTO=new HouseOwnerDTO(resultSet.getString("house_owner_code"), resultSet.getString("member_code"), resultSet.getString("job"), resultSet.getString("visit_start_date"), resultSet.getString("visit_end_date"), resultSet.getString("self_introduction"), resultSet.getString("married_state"), resultSet.getString("address"), resultSet.getString("etc"));
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
		return houseOwnerDTO;
	}

	
	/**
	 * �������ڵ忡 �ش��ϴ� ������������ ����, �湮���ɽ�����, �湮���ɸ�����, �ڱ�Ұ�, ��ȥ����, �ּ�, ���Ұ��� �����Ѵ�
	 * @param houseOwnerCode ������ �����ĺ��ڵ�
	 * @param job ����
	 * @param visitStartDate �湮���ɽ�����
	 * @param visitEndDate �湮���ɸ�����
	 * @param selfIntroduction �ڱ�Ұ�
	 * @param marriedState ��ȥ����
	 * @param address �ּ�
	 * @param etc ���Ұ�
	 * @return ���� �������θ� �����Ѵ�
	 */
	public boolean update(String houseOwnerCode, String job, String visitStartDate, String visitEndDate, String selfIntroduction, String marriedState, String address, String etc)  
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(UPDATE_HOUSEOWNER_SQL); 
			pstmt.setString(1, job);
			pstmt.setString(2, visitStartDate);  
			pstmt.setString(3, visitEndDate);  
			pstmt.setString(4, selfIntroduction);  
			pstmt.setString(5, marriedState);  
			pstmt.setString(6, address);  
			pstmt.setString(7, etc);  
			pstmt.setString(8, houseOwnerCode); 
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
