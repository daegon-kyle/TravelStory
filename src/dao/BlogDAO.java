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
 * 블로그 정보(블로그 설정사항인 레이아웃, 폰트명, 배경화면색)를 관리하는 클래스이다
 * @author 화섭
 *
 */
public class BlogDAO 
{
	private static final String INSERT_BLOG_SQL="INSERT INTO blog_tb VALUES(blog_code.NEXTVAL,?,?,?,?)"; 
	private static final String DELETEALL_BLOG_SQL="DELETE FROM blog_tb";
	private static final String DELETE_BLOG_SQL="DELETE FROM blog_tb WHERE blog_code=?";
	private static final String SELECTALL_BLOG_SQL="SELECT blog_code, member_code, layout_code, font_name, bg_color_code FROM blog_tb";
	private static final String SELECT_BLOG_SQL="SELECT blog_code, member_code, layout_code, font_name, bg_color_code FROM blog_tb WHERE blog_code=?";
	private static final String SELECT_BLOG_SQL1="SELECT blog_code FROM blog_tb WHERE member_code=?";
	private static final String UPDATE_BLOG_SQL1="UPDATE blog_tb SET layout_code=?, font_name=?, bg_color_code=? WHERE blog_code=?";
	private static final String UPDATE_BLOG_SQL2="UPDATE blog_tb SET layout_code=? WHERE blog_code=?";
	private static final String UPDATE_BLOG_SQL3="UPDATE blog_tb SET font_name=? WHERE blog_code=?";
	private static final String UPDATE_BLOG_SQL4="UPDATE blog_tb SET bg_color_code=? WHERE blog_code=?"; 
	  
	
	public BlogDAO()
	{
	}
	
	/**
	 * 블로그 정보를 저장한다 
	 * @param memberCode 회원 고유 식별코드
	 * @param layoutCode 레이아웃 고유 식별코드
	 * @param fontName 폰트명
	 * @param bgColorCode 배경화면색상
	 * @return 저장 성공여부를 리턴한다
	 */
	public boolean insert(String memberCode, String layoutCode, String fontName, String bgColorCode)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(INSERT_BLOG_SQL);
			pstmt.setString(1, memberCode); 
			pstmt.setString(2, layoutCode); 
			pstmt.setString(3, fontName); 
			pstmt.setString(4, bgColorCode); 
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
	 * 등록된 모든 블록 정보를 삭제한다
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
			pstmt=connection.prepareStatement(DELETEALL_BLOG_SQL);
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
	 * 블로그 코드에 해당되는 블로그정보를 삭제한다
	 * @param blogCode삭제 성공여부를 리턴한다
	 * @return
	 */
	public boolean delete(String blogCode)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(DELETE_BLOG_SQL);
			pstmt.setString(1,  blogCode);
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
	 * 등록된 모든 블로그 정보를 검색한다
	 * @return 등록된 모든 블로그 정보를 리턴한다
	 */
	public List<BlogDTO> selectAll()
	{
		List<BlogDTO> list=new ArrayList<BlogDTO>();
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECTALL_BLOG_SQL);
			
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				BlogDTO blogDTO=new BlogDTO(resultSet.getString("blog_code"), resultSet.getString("member_code"), resultSet.getString("layout_code"), resultSet.getString("font_name"), resultSet.getString("bg_color_code"));
				list.add(blogDTO);
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
	 * 블로그 코드에 해당되는 블로그 정보를 검색한다
	 * @param blogCode 블로그 고유 식별코드
	 * @return 블로그 코드에 해당되는 블로그 정보를 리턴한다
	 */
	public BlogDTO select(String blogCode) //블로그코드에 해당되는 정보를 찾는다
	{
		BlogDTO blogDTO=null;
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECT_BLOG_SQL);
			pstmt.setString(1, blogCode);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				blogDTO=new BlogDTO(resultSet.getString("blog_code"), resultSet.getString("member_code"), resultSet.getString("layout_code"), resultSet.getString("font_name"), resultSet.getString("bg_color_code"));
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
		return blogDTO;
	}

	/**
	 * 회원코드에 일치하는 블로그 코드를 검색한다
	 * @param memberCode 회원 고유식별코드
	 * @return 회원 코드에 해당되는 블로그 코드를 리턴한다
	 */
	public String selectBlogCode(String memberCode)
	{
		String blogCode=null;
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECT_BLOG_SQL1);
			pstmt.setString(1, memberCode);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				blogCode=resultSet.getString("blog_code");}
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
		return blogCode;
	}
	/**
	 * 블로그 코드에 해당되는 블로그 정보의 레이아웃코드, 폰트명, 배경색상을 수정한다
	 * @param blogCode 블로그 고유식별코드
	 * @param layoutCode 레이아웃 고유식별코드
	 * @param fontName 폰트명
	 * @param bgColorCode 배경화면색상명
	 * @return 수정 성공여부를 리턴한다
	 */
	public boolean update(String blogCode, String layoutCode, String fontName, String bgColorCode) //블로그정보를 수정한다.
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(UPDATE_BLOG_SQL1);
			pstmt.setString(1, layoutCode);
			pstmt.setString(2, fontName);
			pstmt.setString(3, bgColorCode);
			pstmt.setString(4, blogCode);
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
	 * 블로그코드에 해당되는 블로그정보의 레이아웃 코드를 수정한다
	 * @param blogCode 블로그 고유식별코드
	 * @param layoutCode 레이아웃 고유 식별코드
	 * @return 수정 성공여부를 리턴한다
	 */
	public boolean updateLayout(String blogCode, String layoutCode) //레이아웃정보를 수정한다.
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(UPDATE_BLOG_SQL2);
			pstmt.setString(1, layoutCode); 
			pstmt.setString(2, blogCode);
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
	 * 블로그코드에 해당되는 블로그정보의 폰트명을 수정한다
	 * @param blogCode 블로그 고유식별코드
	 * @param fontName 폰트명
	 * @return수저성공여부를 리턴한다
	 */
	public boolean updateFont(String blogCode, String fontName) //폰트를 수정한다.
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(UPDATE_BLOG_SQL3); 
			pstmt.setString(1, fontName); 
			pstmt.setString(2, blogCode);
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
	 * 블로그코드에 해당되는 블로그정보의 배경화면색상을 수정한다
	 * @param blogCode 블로그 고유식별코드
	 * @param bgColorCode 배경화면색상명
	 * @return 수정성공여부를 리턴한다
	 */
	public boolean updateBgColor(String blogCode, String bgColorCode) //배경색을 수정한다.
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(UPDATE_BLOG_SQL4);
			pstmt.setString(1, bgColorCode);
			pstmt.setString(2, blogCode);
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
