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
 * ��ī�װ� ������ �����ϴ� Ŭ�����̴�
 * @author ȭ��
 *
 */
public class MainCategoryDAO 
{
	private static final String INSERT_MAINCATE_SQL="INSERT INTO main_category_tb VALUES(main_category_code.NEXTVAL,?,?)";
	private static final String DELETEALL_MAINCATE_SQL="DELETE FROM main_category_tb";
	private static final String DELETE_MAINCATE_SQL1="DELETE FROM main_category_tb WHERE main_category_code=?";
	private static final String DELETE_MAINCATE_SQL2="DELTE FROM main_category_tb WHERE blog_code=?";
	private static final String SELECTALL_MAINCATE_SQL="SELECT main_category_code, blog_code, category_name FROM main_category_tb";
	private static final String SELECT_MAINCATE_SQL1="SELECT main_category_code, blog_code, category_name FROM main_category_tb WHERE main_category_code=?";
	private static final String SELECT_MAINCATE_SQL2="SELECT main_category_code, blog_code, category_name FROM main_category_tb WHERE blog_code=?";
	private static final String UPDATE_MAINCATE_SQL="UPDATE main_category_tb SET category_name=? WHERE main_category_code=?";
	
	  
	public MainCategoryDAO()
	{
	}
	
	/**
	 * ��ī�װ��� ������ ����Ѵ� 
	 * @param blogCode ��α� �����ĺ��ڵ�
	 * @param mainCategoryName ��ī�װ���
	 * @return ��� �������θ� �����Ѵ�
	 */
	public boolean insert(String blogCode, String mainCategoryName)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(INSERT_MAINCATE_SQL); 
			pstmt.setString(1, blogCode);  
			pstmt.setString(2, mainCategoryName);  
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
				{e.printStackTrace();
				}
			}
			if(connection!=null)
			{
				try
				{
					connection.close();
				}
				catch(Exception e)
				{e.printStackTrace();}
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
	 * ��ϵ� ��� ��ī�װ������� �����Ѵ�
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
			pstmt=connection.prepareStatement(DELETEALL_MAINCATE_SQL);
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
				{e.printStackTrace();
				}
			}
			if(connection!=null)
			{
				try
				{
					connection.close();
				}
				catch(Exception e){e.printStackTrace();}
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
	 * ��ī�װ��ڵ忡 �ش��ϴ� ������ �����Ѵ�
	 * @param mainCategoryCode ��ī�װ� �����ĺ��ڵ�
	 * @return �����������θ� �����Ѵ�
	 */
	public boolean delete(String mainCategoryCode)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(DELETE_MAINCATE_SQL1);
			pstmt.setString(1,  mainCategoryCode);
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
				{e.printStackTrace();
				}
			}
			if(connection!=null)
			{
				try
				{
					connection.close();
				}
				catch(Exception e){e.printStackTrace();}
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
	 * ��α��ڵ忡 �ش��ϴ� ��ī�װ� �������� ��� �����Ѵ�
	 * @param blogCode ��α� �����ĺ��ڵ�
	 * @return ���� �������θ� �����Ѵ�
	 */
	public boolean deleteMainCategorys(String blogCode)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(DELETE_MAINCATE_SQL2);
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
				{e.printStackTrace();
				}
			}
			if(connection!=null)
			{
				try
				{
					connection.close();
				}
				catch(Exception e){e.printStackTrace();}
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
	 * ��ϵ� ��� ��ī�װ��������� �˻��Ѵ�
	 * @return ��ϵ� ��� ��ī�װ��������� �����Ѵ�
	 */
	public List<MainCategoryDTO> selectAll()
	{
		List<MainCategoryDTO> list=new ArrayList<MainCategoryDTO>();
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECTALL_MAINCATE_SQL);
			
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				MainCategoryDTO mainCategoryDTO=new MainCategoryDTO(resultSet.getString("main_category_code"), resultSet.getString("blog_code"), resultSet.getString("category_name"));
				list.add(mainCategoryDTO);
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
				{e.printStackTrace();
				}
			}
			if(pstmt!=null)
			{
				try
				{
					pstmt.close();
				}
				catch(Exception e)
				{e.printStackTrace();
				}
			}
			if(connection!=null)
			{
				try
				{
					connection.close();
				}
				catch(Exception e){e.printStackTrace();}
			}
		}
		return list;
	}
	
	/**
	 * ��ī�װ��ڵ忡 �ش�Ǵ� ��ī�װ������� �˻��Ѵ�
	 * @param mainCategoryCode ��ī�װ� �����ĺ��ڵ�
	 * @return ��ī�װ��ڵ忡 �شپƴ� ��ī�װ������� �����Ѵ�
	 */
	public MainCategoryDTO selectMainCategory(String mainCategoryCode) 
	{
		MainCategoryDTO mainCategoryDTO=null;
	
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECT_MAINCATE_SQL1);
			pstmt.setString(1, mainCategoryCode);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				mainCategoryDTO=new MainCategoryDTO(resultSet.getString("main_category_code"), resultSet.getString("blog_code"), resultSet.getString("category_name")); 
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
				{e.printStackTrace();
				}
			}
			if(pstmt!=null)
			{
				try
				{
					pstmt.close();
				}
				catch(Exception e)
				{e.printStackTrace();
				}
			}
			if(connection!=null)
			{
				try
				{
					connection.close();
				}
				catch(Exception e){e.printStackTrace();}
			}
		}
		return mainCategoryDTO;
	}
	/**
	 * ��α��ڵ忡 �ش��ϴ� ��ī�װ� �������� �˻��Ѵ�
	 * @param blogCode ��α� �����ĺ��ڵ�
	 * @return ��α� �ڵ忡 �ش��ϴ� ��ī�װ� �������� �����Ѵ�
	 */
	public List<MainCategoryDTO> selectMainCategorys(String blogCode) //�ش� blog�� ������ ���װ� ������ ã�´�
	{
		List<MainCategoryDTO> list=new ArrayList<MainCategoryDTO>();
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECT_MAINCATE_SQL2);
			pstmt.setString(1, blogCode);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				MainCategoryDTO mainCategoryDTO=new MainCategoryDTO(resultSet.getString("main_category_code"), resultSet.getString("blog_code"), resultSet.getString("category_name")); 
				list.add(mainCategoryDTO);
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
				{e.printStackTrace();
				}
			}
			if(pstmt!=null)
			{
				try
				{
					pstmt.close();
				}
				catch(Exception e)
				{e.printStackTrace();
				}
			}
			if(connection!=null)
			{
				try
				{
					connection.close();
				}
				catch(Exception e){e.printStackTrace();}
			}
		}
		return list;
	}
	
	/**
	 * ��ī�װ��ڵ忡 �ش��ϴ� ��ī�װ������� ��ī�װ����� �����Ѵ�
	 * @param mainCategoryCode ��ī�װ� �����ĺ��ڵ�
	 * @param mainCategoryName ��ī�װ���
	 * @return ���� �������θ� �����Ѵ�
	 */
	public boolean updateMainCategoryName(String mainCategoryCode, String mainCategoryName)  
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(UPDATE_MAINCATE_SQL);
			pstmt.setString(1, mainCategoryName);
			pstmt.setString(2, mainCategoryCode); 
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
				{e.printStackTrace();
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
