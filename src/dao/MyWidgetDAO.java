//�ۼ���¥ : 2014/7/20
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
 * ������������ ��α׿� ȸ���� ���� ������ �����Ͽ� �����ϴ� Ŭ�����̴�
 * @author ȭ��
 *
 */
public class MyWidgetDAO 
{
	private static final String SELECT_MYWIDGET_SQL1="SELECT member_code, my_widget_code, my_widget_name FROM my_widget_view WHERE member_code=?";
	private static final String SELECT_MYWIDGET_SQL2="SELECT member_code, my_widget_code, my_widget_name FROM my_widget_view WHERE member_code=? AND my_widget_code=?";
	private static final String SELECTALL_MYWIDGET_SQL="SELECT member_code, my_widget_code, my_widget_name FROM my_widget_view";

	
	public MyWidgetDAO()
	{
	}
 
	
	/**
	 * ȸ���ڵ忡 �ش��ϴ� ������ ������ ���������� �˻��Ѵ�
	 * @param memberCode ȸ�� �����ĺ��ڵ�
	 * @return ������ ��α׿� ������ ������������ �����Ѵ�
	 */
	public List<MyWidgetDTO> select(String memberCode)
	{
		List<MyWidgetDTO> list=new ArrayList<MyWidgetDTO>();
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection(); 
			pstmt=connection.prepareStatement(SELECT_MYWIDGET_SQL1);
			pstmt.setString(1, memberCode);  
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				MyWidgetDTO myWidgetDTO=new MyWidgetDTO(resultSet.getString("member_code"), resultSet.getString("blog_code"), resultSet.getString("used_widget_code"), resultSet.getString("my_widget_code"), resultSet.getString("my_widget_name"));
				list.add(myWidgetDTO);
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
	 * ȸ���ڵ�� �����ڵ忡 �ش��ϴ� ���������� �˻��Ѵ�
	 * @param memberCode ȸ�� �����ĺ��ڵ�
	 * @param widgetCode ���� �����ĺ��ڵ�
	 * @return ȸ���ڵ�� �����ڵ忡 �ش��ϴ� ���������� �����Ѵ�
	 */
	public MyWidgetDTO select(String memberCode, String widgetCode)
	{
		MyWidgetDTO myWidgetDTO=null;
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection(); 
			pstmt=connection.prepareStatement(SELECT_MYWIDGET_SQL2);
			pstmt.setString(1, memberCode);
			pstmt.setString(2, widgetCode);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				myWidgetDTO=new MyWidgetDTO(resultSet.getString("member_code"), resultSet.getString("blog_code"), resultSet.getString("used_widget_code"), resultSet.getString("my_widget_code"), resultSet.getString("my_widget_name"));
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
		return myWidgetDTO;
	}
	
	/**
	 * ��� ���������� �˻��Ѵ�
	 * @return ��ϵ� ��� ���������� �����Ѵ�
	 */
	public List<MyWidgetDTO> selectAllWidget()
	{
		List<MyWidgetDTO> list=new ArrayList<MyWidgetDTO>();
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection(); 
			pstmt=connection.prepareStatement(SELECTALL_MYWIDGET_SQL); 
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				MyWidgetDTO myWidgetDTO=new MyWidgetDTO(resultSet.getString("member_code"), resultSet.getString("blog_code"), resultSet.getString("used_widget_code"), resultSet.getString("my_widget_code"), resultSet.getString("my_widget_name"));
				list.add(myWidgetDTO);
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

