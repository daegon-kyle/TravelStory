//작성날짜 : 2014/7/zz19
//작성자 : 이화섭

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
 * 블로그에 적용중인 위젯의 정보를 관리하는 클래스이다
 * @author 화섭
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
	 * 블로그에 적용될 위젯의 정보를 등록한다
	 * @param widgetCode 위젯 고유 식별코드
	 * @param blogCode 블로그 고유 식별코드
	 * @return 등록 성공여부를 리턴한다
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
	 * 블로그에 적용된 위젯 정보들을 모두 삭제한다
	 * @return 삭제 성공여부
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
	 * 적용된위젯정보코드에 해당되는 적용된위젯정보를 삭제한다
	 * @param usedWidgetCode 적용된 위젯 고유식별코드
	 * @return 삭제 성공여부를 리턴한다
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
	 * 블로그코드에 해당하는 적요된위젯정보를 삭제한다
	 * @param blogCode 블로그 고유식별코드
	 * @return 삭제 성공여부를 리턴한다
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
	 * 등록된 모든 적용된위젯정보를 검색한다
	 * @return 등록된 모든 적용된 위젯정보를 리턴한다
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
	 * 적용된위젯코드에 해당하는 적용된위젯정보를 검색한다
	 * @param usedWidgetCode 적용된위젯 고유식별코드
	 * @return 적용된위젯정보코드에 해당하는 적용된위젯정보를 리턴한다
	 */
	public UsedWidgetDTO select(String usedWidgetCode) //usedWidgetCode에 해당되는 정보를 찾는다
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
	 * 적용된위젯코드에 해당하는 적용된위젯정보의 위젯코드와 블록코드를 수정한다
	 * @param usedWidgetCode 적용된위젯 고유식별코드
	 * @param widgetCode 위젯 고유식별코드
	 * @param blogCode 블로그 고유식별코드
	 * @return 수정 성공여부를 리턴한다
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
