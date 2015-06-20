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
 * ��α� ����(��α� ���������� ���̾ƿ�, ��Ʈ��, ���ȭ���)�� �����ϴ� Ŭ�����̴�
 * @author ȭ��
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
	 * ��α� ������ �����Ѵ� 
	 * @param memberCode ȸ�� ���� �ĺ��ڵ�
	 * @param layoutCode ���̾ƿ� ���� �ĺ��ڵ�
	 * @param fontName ��Ʈ��
	 * @param bgColorCode ���ȭ�����
	 * @return ���� �������θ� �����Ѵ�
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
	 * ��ϵ� ��� ��� ������ �����Ѵ�
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
	 * ��α� �ڵ忡 �ش�Ǵ� ��α������� �����Ѵ�
	 * @param blogCode���� �������θ� �����Ѵ�
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
	 * ��ϵ� ��� ��α� ������ �˻��Ѵ�
	 * @return ��ϵ� ��� ��α� ������ �����Ѵ�
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
	 * ��α� �ڵ忡 �ش�Ǵ� ��α� ������ �˻��Ѵ�
	 * @param blogCode ��α� ���� �ĺ��ڵ�
	 * @return ��α� �ڵ忡 �ش�Ǵ� ��α� ������ �����Ѵ�
	 */
	public BlogDTO select(String blogCode) //��α��ڵ忡 �ش�Ǵ� ������ ã�´�
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
	 * ȸ���ڵ忡 ��ġ�ϴ� ��α� �ڵ带 �˻��Ѵ�
	 * @param memberCode ȸ�� �����ĺ��ڵ�
	 * @return ȸ�� �ڵ忡 �ش�Ǵ� ��α� �ڵ带 �����Ѵ�
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
	 * ��α� �ڵ忡 �ش�Ǵ� ��α� ������ ���̾ƿ��ڵ�, ��Ʈ��, �������� �����Ѵ�
	 * @param blogCode ��α� �����ĺ��ڵ�
	 * @param layoutCode ���̾ƿ� �����ĺ��ڵ�
	 * @param fontName ��Ʈ��
	 * @param bgColorCode ���ȭ������
	 * @return ���� �������θ� �����Ѵ�
	 */
	public boolean update(String blogCode, String layoutCode, String fontName, String bgColorCode) //��α������� �����Ѵ�.
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
	 * ��α��ڵ忡 �ش�Ǵ� ��α������� ���̾ƿ� �ڵ带 �����Ѵ�
	 * @param blogCode ��α� �����ĺ��ڵ�
	 * @param layoutCode ���̾ƿ� ���� �ĺ��ڵ�
	 * @return ���� �������θ� �����Ѵ�
	 */
	public boolean updateLayout(String blogCode, String layoutCode) //���̾ƿ������� �����Ѵ�.
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
	 * ��α��ڵ忡 �ش�Ǵ� ��α������� ��Ʈ���� �����Ѵ�
	 * @param blogCode ��α� �����ĺ��ڵ�
	 * @param fontName ��Ʈ��
	 * @return�����������θ� �����Ѵ�
	 */
	public boolean updateFont(String blogCode, String fontName) //��Ʈ�� �����Ѵ�.
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
	 * ��α��ڵ忡 �ش�Ǵ� ��α������� ���ȭ������� �����Ѵ�
	 * @param blogCode ��α� �����ĺ��ڵ�
	 * @param bgColorCode ���ȭ������
	 * @return �����������θ� �����Ѵ�
	 */
	public boolean updateBgColor(String blogCode, String bgColorCode) //������ �����Ѵ�.
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
