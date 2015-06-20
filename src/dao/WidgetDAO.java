//작성날짜 : 2014/7/19
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
 * 위젯정보를 관리하는 클래스이다
 * @author 화섭
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
	 * 위젯 정보를 등록한다
	 * @param widgetCode 위젯 고유식별코드
	 * @param widgetName 위젯명
	 * @return 등록성공여부를 리턴한다
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
	 * 등록된 모든 위젯정보를 삭제한다
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
	 * 위젯코드에 해당하는 위젯정보를 삭제한다
	 * @param widgetCode 위젯 고유식별코드
	 * @return 삭제 성공여부를 리턴한다
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
	 * 등록된 모든위젯정보를 검색한다
	 * @return 등록된 모든위젯의 정보들을 리턴한다
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
	 * 위젯코드에 해당하는 위젯정보를 검색한다
	 * @param widgetCode 위젯 고유식별코드
	 * @return 위젯코드에 해당하는 위젯정보를 리턴한다
	 */
	public WidgetDTO select(String widgetCode) //위젯코드에 해당되는 정보를 찾는다
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
	 * 위젯코드에 해당하는 위젯정보의 위젯명을 수정한다
	 * @param widgetCode 위젯 고유식별코드
	 * @param widgetName 수정할 위젯명
	 * @return 수정 성공여부를 리턴한다
	 */
	public boolean update(String widgetCode, String widgetName) //위젯 명을 수정한다.
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