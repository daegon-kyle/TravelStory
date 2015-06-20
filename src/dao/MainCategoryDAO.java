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
 * 대카테고리 정보를 관리하는 클래스이다
 * @author 화섭
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
	 * 대카테고리의 정보를 등록한다 
	 * @param blogCode 블로그 고유식별코드
	 * @param mainCategoryName 대카테고리명
	 * @return 등록 성공여부를 리턴한다
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
	 * 등록된 모든 대카테고리정보를 삭제한다
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
	 * 대카테고리코드에 해당하는 정보를 삭제한다
	 * @param mainCategoryCode 대카테고리 고유식별코드
	 * @return 삭제성공여부를 리턴한다
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
	 * 블로그코드에 해당하는 대카테고리 정보들을 모두 삭제한다
	 * @param blogCode 블로그 고유식별코드
	 * @return 삭제 성공여부를 리턴한다
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
	 * 등록된 모든 대카테고리정보들을 검색한다
	 * @return 등록된 모든 대카테고리정보들을 리턴한다
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
	 * 대카테고리코드에 해당되는 대카테고리정보를 검색한다
	 * @param mainCategoryCode 대카테고리 고유식별코드
	 * @return 대카테고리코드에 해다아는 대카테고리정보를 리턴한다
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
	 * 블로그코드에 해당하는 대카테고리 정보들을 검색한다
	 * @param blogCode 블로그 고유식별코드
	 * @return 블로그 코드에 해당하는 대카테고리 정보들을 리턴한다
	 */
	public List<MainCategoryDTO> selectMainCategorys(String blogCode) //해당 blog가 보유만 케테고리 정보를 찾는다
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
	 * 대카테고리코드에 해당하는 대카테고리정보의 대카테고리명을 수정한다
	 * @param mainCategoryCode 대카테고리 고유식별코드
	 * @param mainCategoryName 대카테고리명
	 * @return 수정 성공여부를 리턴한다
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
