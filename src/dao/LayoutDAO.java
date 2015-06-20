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
 * ���̾ƿ� ������ �����ϴ� Ŭ�����̴�
 * @author ȭ��
 *
 */
public class LayoutDAO 
{
	private static final String INSERT_LAYOUT_SQL="INSERT INTO layout_tb VALUES(layout_code.NEXTVAL, ?)";
	private static final String DELETEALL_LAYOUT_SQL="DELETE FROM layout_tb";
	private static final String DELETE_LAYOUT_SQL="DELETE FROM layout_tb WHERE layout_code=?";
	private static final String SELECTALL_LAYOUT_SQL="SELECT layout_code, layout_name FROM layout_tb";
	private static final String SELECT_LAYOUT_SQL="SELECT layout_code, layout_name FROM layout_tb WHERE layout_code=?";
	private static final String UPDATE_LAYOUT_SQL="UPDATE layout_tb SET layout_name=? WHERE layout_code=?";
	
	
	public LayoutDAO()
	{
	}
	
	/**
	 * ���̾ƿ� ������ ����Ѵ�
	 * @param layoutName ���̾ƿ� �̸�
	 * @return ��� �������θ� �����Ѵ�
	 */
	public boolean insert(String layoutName)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(INSERT_LAYOUT_SQL);
			pstmt.setString(1, layoutName); 
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
	 * ��ϵ� ��� ���̾ƿ� ������ �����Ѵ�
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
			pstmt=connection.prepareStatement(DELETEALL_LAYOUT_SQL);
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
	 * ���̾ƿ� �����ĺ��ڵ忡 �ش��ϴ� ���̾ƿ� ������ �����Ѵ�
	 * @param layoutCode ���̾ƿ� ���� �ĺ��ڵ�
	 * @return ���� ��������
	 */
	public boolean delete(String layoutCode)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(DELETE_LAYOUT_SQL);
			pstmt.setString(1,  layoutCode);
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
	 * ��ϵ� ��� ���̾ƿ� ������ �˻��Ѵ�
	 * @return ��ϵ� ��� ���̾ƿ� ������ �����Ѵ�
	 */
	public List<LayoutDTO> selectAll()
	{
		List<LayoutDTO> list=new ArrayList<LayoutDTO>();
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECTALL_LAYOUT_SQL);
			
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				LayoutDTO layoutDTO=new LayoutDTO(resultSet.getString("layout_code"), resultSet.getString("layout_name"));
				list.add(layoutDTO);
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
	 * ���̾ƿ� �ڵ忡 �ش��ϴ� ���̾ƿ� ������ �˻��Ѵ�
	 * @param layoutCode ���̾ƿ� �����ĺ��ڵ�
	 * @return ���̾ƿ� �ڵ忡 �ش��ϴ� ���̾ƿ� ������ �����Ѵ�
	 */
	public LayoutDTO select(String layoutCode) //���̾ƿ��ڵ忡 �ش�Ǵ� ������ ã�´�
	{
		LayoutDTO layoutDTO=null;
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECT_LAYOUT_SQL);
			pstmt.setString(1, layoutCode);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				layoutDTO=new LayoutDTO(resultSet.getString("layout_code"), resultSet.getString("layout_name")); 
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
		return layoutDTO;
	}
	
	/**
	 * ���̾ƿ� �ڵ忡 �ش��ϴ� ���̾ƿ� ������ ���̾ƿ����� �����Ѵ�
	 * @param layoutCode ���̾ƿ� �����ĺ��ڵ�
	 * @param layoutName ���̾ƿ� ��
	 * @return ���� �������θ� �����Ѵ�
	 */
	public boolean update(String layoutCode, String layoutName) //���̾ƿ� ���� �����Ѵ�.
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(UPDATE_LAYOUT_SQL);
			pstmt.setString(1, layoutName); 
			pstmt.setString(2, layoutCode);
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
