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
 * ȸ���� ����� �����ϴ� Ŭ�����̴�
 * @author ȭ��
 *
 */
public class MemberLevelDAO 
{
	private static final String INSERT_MEMBER_LEVEL_SQL="INSERT INTO member_level_tb VALUES(member_level_code.NEXTVAL, ?)";
	private static final String DELETEALL_MEMBER_LEVEL_SQL="DELETE FROM member_level_tb";
	private static final String DELETE_MEMBER_LEVEL_SQL="DELETE FROM member_level_tb WHERE member_level_code=?";
	private static final String SELECTALL_MEMBER_LEVEL_SQL="SELECT member_level_code, member_level_name FROM member_level_tb";
	private static final String SELECT_MEMBER_LEVEL_SQL="SELECT member_level_name FROM member_level_tb WHERE member_level_code=?";
	private static final String UPDATE_MEMBER_LEVEL_SQL="UPDATE member_level_tb SET member_level_name=? WHERE member_level_code=?";
	
	public MemberLevelDAO()
	{
	}

	/**
	 * ȸ�� ����� ����Ѵ�
	 * @param levelName ��޸�
	 * @return ��� �������θ� �����Ѵ�
	 */
	public boolean insert(String levelName)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(INSERT_MEMBER_LEVEL_SQL);
			pstmt.setString(1, levelName); 
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
	 * ��ϵ��ִ� ȸ����޵��� ��� �����Ѵ�
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
			pstmt=connection.prepareStatement(DELETEALL_MEMBER_LEVEL_SQL);
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
	 * ȭ�� ��� �����ĺ��ڵ忡 �ش��ϴ� ȸ����������� �����Ѵ�
	 * @param levelCode ȸ�� ��� �����ĺ��ڵ�
	 * @return ���� �������θ� �����Ѵ�
	 */
	public boolean delete(String levelCode)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(DELETE_MEMBER_LEVEL_SQL);
			pstmt.setString(1,  levelCode);
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
	 * ��ϵ�  ��� ȸ����� ������ �˻��Ѵ�
	 * @return ��ϵ� ��� ȸ����� ������ �����Ѵ�
	 */
	public List<MemberLevelDTO> selectAll()
	{
		List<MemberLevelDTO> list=new ArrayList<MemberLevelDTO>();
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECTALL_MEMBER_LEVEL_SQL);
			
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				MemberLevelDTO memberLevelDTO=new MemberLevelDTO(resultSet.getString("member_level_code"), resultSet.getString("member_level_name"));
				list.add(memberLevelDTO);
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
	 * ȸ����� �����ĺ��ڵ忡 �ش�Ǵ� ȸ����������� �˻��Ѵ�
	 * @param levelCode ȸ����� �����ĺ��ڵ�
	 * @return ȸ����޿� �ش��ϴ� ��޸��� �����Ѵ�
	 */
	public String selectLevelName(String levelCode) //level �ڵ忡 �ش��ϴ� �̸� ����
	{
		String name=null;
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECT_MEMBER_LEVEL_SQL);
			pstmt.setString(1, levelCode);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				name=resultSet.getString("member_level_name");
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
		return name;
	}
	
	/**
	 * ȸ����޿� �ش��ϴ� ȸ����������� ��޸��� �����Ѵ�
	 * @param levelCode ȸ����� �����ĺ��ڵ�
	 * @param levelName ȸ����޸�
	 * @return ���� �������θ� �����Ѵ�
	 */
	public boolean updateLevelName(String levelCode, String levelName)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(UPDATE_MEMBER_LEVEL_SQL);
			pstmt.setString(1, levelName);
			pstmt.setString(2, levelCode);
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
