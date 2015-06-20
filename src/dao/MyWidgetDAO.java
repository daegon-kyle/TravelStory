//작성날짜 : 2014/7/20
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
 * 위젯을적용한 블로그와 회원에 대한 정보에 접근하여 관리하는 클래스이다
 * @author 화섭
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
	 * 회원코드에 해당하는 본인이 적용한 위젯정보를 검색한다
	 * @param memberCode 회원 고유식별코드
	 * @return 본인이 블로그에 적용한 위젯정보들을 리턴한다
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
	 * 회원코드와 위젯코드에 해당하는 위젯정보를 검색한다
	 * @param memberCode 회원 고유식별코드
	 * @param widgetCode 위젯 고유식별코드
	 * @return 회원코드와 위젯코드에 해당하는 위젯정보를 리턴한다
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
	 * 모든 위젯정보를 검색한다
	 * @return 등록된 모든 위젯정보를 리턴한다
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

