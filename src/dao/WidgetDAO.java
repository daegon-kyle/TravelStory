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
 * ���������� �����ϴ� Ŭ�����̴�
 * @author ȭ��
 *
 */
public class WidgetDAO 
{
	private static final String INSERT_WIDGET_SQL="INSERT INTO widget_tb VALUES(widget_code.NEXTVAL,?)";
	private static final String DELETEALL_WIDGET_SQL="DELETE FROM widget_tb";
	private static final String DELETE_WIDGET_SQL="DELETE FROM widget_tb WHERE widget_code=?";
	private static final String SELECTALL_WIDGET_SQL="SELECT widget_code, widget_name FROM widget_tb";
	private static final String SELECT_WIDGET_SQL="SELECT widget_code, widget_name FROM widget_tb WHERE widget_code=?";
	private static final String UPDATE_WIDGET_SQL="UPDATE widget_tb SET widget_name=? WHERE widget_code=?";
	
	
	public WidgetDAO()
	{
	}
	
	/**
	 * ���� ������ ����Ѵ�
	 * @param widgetCode ���� �����ĺ��ڵ�
	 * @param widgetName ������
	 * @return ��ϼ������θ� �����Ѵ�
	 */
	public boolean insert(String widgetName)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(INSERT_WIDGET_SQL); 
			pstmt.setString(1, widgetName);
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
	 * ��ϵ� ��� ���������� �����Ѵ�
	 * @return ���� ��������
	 */
	public boolean deleteAll()
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(DELETEALL_WIDGET_SQL);
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
	 * �����ڵ忡 �ش��ϴ� ���������� �����Ѵ�
	 * @param widgetCode ���� �����ĺ��ڵ�
	 * @return ���� �������θ� �����Ѵ�
	 */
	public boolean delete(String widgetCode)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(DELETE_WIDGET_SQL);
			pstmt.setString(1,  widgetCode);
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
	 * ��ϵ� ������������� �˻��Ѵ�
	 * @return ��ϵ� ��������� �������� �����Ѵ�
	 */
	public List<WidgetDTO> selectAll()
	{
		List<WidgetDTO> list=new ArrayList<WidgetDTO>();
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECTALL_WIDGET_SQL);
			
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				WidgetDTO widgetDTO=new WidgetDTO(resultSet.getString("widget_code"), resultSet.getString("widget_name"));
				list.add(widgetDTO);
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
				catch(Exception e){}
			}
		}
		return list;
	}
	
	/**
	 * �����ڵ忡 �ش��ϴ� ���������� �˻��Ѵ�
	 * @param widgetCode ���� �����ĺ��ڵ�
	 * @return �����ڵ忡 �ش��ϴ� ���������� �����Ѵ�
	 */
	public WidgetDTO select(String widgetCode) //�����ڵ忡 �ش�Ǵ� ������ ã�´�
	{
		WidgetDTO widgetDTO=null;
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECT_WIDGET_SQL);
			pstmt.setString(1, widgetCode);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				widgetDTO=new WidgetDTO(resultSet.getString("widget_code"), resultSet.getString("widget_name")); 
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
		return widgetDTO;
	}
	
	/**
	 * �����ڵ忡 �ش��ϴ� ���������� �������� �����Ѵ�
	 * @param widgetCode ���� �����ĺ��ڵ�
	 * @param widgetName ������ ������
	 * @return ���� �������θ� �����Ѵ�
	 */
	public boolean update(String widgetCode, String widgetName) //���� ���� �����Ѵ�.
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(UPDATE_WIDGET_SQL);
			pstmt.setString(1, widgetName); 
			pstmt.setString(2, widgetCode);
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