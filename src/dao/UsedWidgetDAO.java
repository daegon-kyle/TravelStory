//�ۼ���¥ : 2014/7/zz19
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
 * ��α׿� �������� ������ ������ �����ϴ� Ŭ�����̴�
 * @author ȭ��
 *
 */
public class UsedWidgetDAO 
{
	private static final String INSERT_USEDWIDGET_SQL="INSERT INTO used_widget_tb VALUES(used_widget_code.NEXTVAL, ?,?)";
	private static final String DELETEALL_USEDWIDGET_SQL="DELETE FROM used_widget_tb";
	private static final String DELETE_USEDWIDGET_SQL1="DELETE FROM used_widget_tb WHERE used_widget_code=?";
	private static final String DELETE_USEDWIDGET_SQL2="DELETE FROM used_widget_tb WHERE blog_code=?";
	private static final String SELECTALL_USEDWIDGET_SQL="SELECT used_widget_code, widget_code, blog_code FROM used_widget_tb";
	private static final String SELECT_USEDWIDGET_SQL="SELECT used_widget_code, widget_code, blog_code FROM used_widget_tb WHERE used_widget_code=?";
	private static final String UPDATE_USEDWIDGET_SQL="UPDATE used_widget_tb SET widget_code=?, blog_code=? WHERE used_widget_code=?";
	 
	public UsedWidgetDAO()
	{
	}
	
	/**
	 * ��α׿� ����� ������ ������ ����Ѵ�
	 * @param widgetCode ���� ���� �ĺ��ڵ�
	 * @param blogCode ��α� ���� �ĺ��ڵ�
	 * @return ��� �������θ� �����Ѵ�
	 */
	public boolean insert(String widgetCode, String blogCode)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(INSERT_USEDWIDGET_SQL);
			pstmt.setString(1, widgetCode); 
			pstmt.setString(2, blogCode);  
			result=pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
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
				}
			}
			if(connection!=null)
			{
				try
				{
					connection.close();
				}
				catch(Exception e)
				{}
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
	 * ��α׿� ����� ���� �������� ��� �����Ѵ�
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
			pstmt=connection.prepareStatement(DELETEALL_USEDWIDGET_SQL);
			result=pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
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
	 * ��������������ڵ忡 �ش�Ǵ� ��������������� �����Ѵ�
	 * @param usedWidgetCode ����� ���� �����ĺ��ڵ�
	 * @return ���� �������θ� �����Ѵ�
	 */
	public boolean delete(String usedWidgetCode)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(DELETE_USEDWIDGET_SQL1);
			pstmt.setString(1,  usedWidgetCode);
			result=pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
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
	 * ��α��ڵ忡 �ش��ϴ� ��������������� �����Ѵ�
	 * @param blogCode ��α� �����ĺ��ڵ�
	 * @return ���� �������θ� �����Ѵ�
	 */
	public boolean deleteUsedWidgets(String blogCode)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(DELETE_USEDWIDGET_SQL2);
			pstmt.setString(1,  blogCode);
			result=pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
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
	 * ��ϵ� ��� ��������������� �˻��Ѵ�
	 * @return ��ϵ� ��� ����� ���������� �����Ѵ�
	 */
	public List<UsedWidgetDTO> selectAll()
	{
		List<UsedWidgetDTO> list=new ArrayList<UsedWidgetDTO>();
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECTALL_USEDWIDGET_SQL);
			
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				UsedWidgetDTO usedWidgetDTO=new UsedWidgetDTO(resultSet.getString("used_widget_code"), resultSet.getString("widget_code"), resultSet.getString("blog_code"));
				list.add(usedWidgetDTO);
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
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
				catch(Exception e){}
			}
		}
		return list;
	}
	
	/**
	 * ����������ڵ忡 �ش��ϴ� ��������������� �˻��Ѵ�
	 * @param usedWidgetCode ��������� �����ĺ��ڵ�
	 * @return ��������������ڵ忡 �ش��ϴ� ��������������� �����Ѵ�
	 */
	public UsedWidgetDTO select(String usedWidgetCode) //usedWidgetCode�� �ش�Ǵ� ������ ã�´�
	{
		UsedWidgetDTO usedWidgetDTO=null;
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECT_USEDWIDGET_SQL);
			pstmt.setString(1, usedWidgetCode);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				usedWidgetDTO=new UsedWidgetDTO(resultSet.getString("used_widget_code"), resultSet.getString("widget_code"), resultSet.getString("blog_code"));
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
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
				catch(Exception e){}
			}
		}
		return usedWidgetDTO;
	}
	
	/**
	 * ����������ڵ忡 �ش��ϴ� ��������������� �����ڵ�� ����ڵ带 �����Ѵ�
	 * @param usedWidgetCode ��������� �����ĺ��ڵ�
	 * @param widgetCode ���� �����ĺ��ڵ�
	 * @param blogCode ��α� �����ĺ��ڵ�
	 * @return ���� �������θ� �����Ѵ�
	 */
	public boolean update(String usedWidgetCode, String widgetCode, String blogCode)  
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(UPDATE_USEDWIDGET_SQL);
			pstmt.setString(1, usedWidgetCode);
			pstmt.setString(2, widgetCode);
			pstmt.setString(3, blogCode); 
			result=pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
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
