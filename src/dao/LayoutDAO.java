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
 * 레이아웃 정보를 관리하는 클래스이다
 * @author 화섭
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
	 * 레이아웃 정보를 등록한다
	 * @param layoutName 레이아웃 이름
	 * @return 등록 성공여부를 리턴한다
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
	 * 등록된 모든 레이아웃 정보를 삭제한다
	 * @return 삭제 성공여부를 리턴한다
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
	 * 레이아웃 고유식별코드에 해당하는 레이아웃 정보를 삭제한다
	 * @param layoutCode 레이아웃 고유 식별코드
	 * @return 삭제 성공여부
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
	 * 등록된 모든 레이아웃 정보를 검색한다
	 * @return 등록된 모든 레이아웃 정보를 리턴한다
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
	 * 레이아웃 코드에 해당하는 레이아웃 정보를 검색한다
	 * @param layoutCode 래이아웃 고유식별코드
	 * @return 레이아웃 코드에 해당하는 레이아웃 정보를 리턴한다
	 */
	public LayoutDTO select(String layoutCode) //레이아웃코드에 해당되는 정보를 찾는다
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
	 * 레이아웃 코드에 해당하는 레이아웃 정보의 레이아웃명을 수정한다
	 * @param layoutCode 레이아웃 고유식별코드
	 * @param layoutName 레이아웃 명
	 * @return 수정 성공여부를 리턴한다
	 */
	public boolean update(String layoutCode, String layoutName) //레이아웃 명을 수정한다.
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
