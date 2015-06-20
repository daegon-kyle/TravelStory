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
 * 소카테고리정보를 관리하는 클래스이다
 * @author 화섭
 *
 */
public class SubCategoryDAO 
{
	private static final String INSERT_SUBCATE_SQL="INSERT INTO sub_category_tb VALUES(sub_category_code.NEXTVAL, ?, ?)";
	private static final String DELETEALL_SUBCATE_SQL="DELETE FROM sub_category_tb";
	private static final String DELETE_SUBCATE_SQL1="DELETE FROM sub_category_tb WHERE sub_category_code=?";
	private static final String DELETE_SUBCATE_SQL2="DELETE FROM sub_category_tb WHERE main_category_code=?";
	private static final String SELECTALL_SUBCATE_SQL="SELECT sub_category_code, main_category_code, category_name FROM sub_category_tb";
	private static final String SELECT_SUBCATE_SQL1="SELECT sub_category_code, main_category_code, category_name FROM sub_category_tb WHERE sub_category_code=?";
	private static final String SELECT_SUBCATE_SQL2 ="SELECT sub_category_code, main_category_code, category_name FROM sub_category_tb WHERE main_category_code=?";
	private static final String UPDATE_SUBCATE_SQL1="UPDATE sub_category_tb SET main_category_code=?, category_name=? WHERE sub_category_code=?";
	private static final String UPDATE_SUBCATE_SQL2="UPDATE sub_category_tb SET main_category_code=? WHERE sub_category_code=?";
	private static final String UPDATE_SUBCATE_SQL3="UPDATE sub_category_tb SET category_name=? WHERE sub_category_code=?";
	  
	public SubCategoryDAO()
	{
	}
	
	/**
	 * 소카테고리정보를 등록한다
	 * @param mainCategoryCode 대카테고리 고유식별코드
	 * @param subCategoryName 소카테고리명
	 * @return 등록 성공여부를 리턴한다
	 */
	public boolean insert(String mainCategoryCode, String subCategoryName)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(INSERT_SUBCATE_SQL); 
			pstmt.setString(1, mainCategoryCode);  
			pstmt.setString(2, subCategoryName);  
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
	 * 등록된 모든 소카테고리 정보들을 삭제한다
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
			pstmt=connection.prepareStatement(DELETEALL_SUBCATE_SQL);
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
	 * 소카테고리코드에 해당하는 소카테고리정보를 삭제한다
	 * @param subCategoryCode 소카테고리 고유식별코드
	 * @return 삭제 성공여부를 리턴한다
	 */
	public boolean delete(String subCategoryCode)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(DELETE_SUBCATE_SQL1);
			pstmt.setString(1,  subCategoryCode);
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
	 * 대카테고리코드에 해당(대카테고리 소속)하는 소카테고리들을 삭제한다 
	 * @param mainCategoryCode 대카테고리 고유식별코드
	 * @return 삭제 성공여부를 리턴한다
	 */
	public boolean deleteSubCategorys(String mainCategoryCode)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(DELETE_SUBCATE_SQL2);
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
	 * 등록된 모든 소카테고리정보들을 검색한다
	 * @return 등록된 모든 소카테고리정보들을 리턴한다
	 */
	public List<SubCategoryDTO> selectAll()
	{
		List<SubCategoryDTO> list=new ArrayList<SubCategoryDTO>();
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECTALL_SUBCATE_SQL);
			
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				SubCategoryDTO subCategoryDTO=new SubCategoryDTO(resultSet.getString("sub_category_code"), resultSet.getString("main_category_code"), resultSet.getString("category_name"));
				list.add(subCategoryDTO);
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
	 * 소카테고리코드에 해당하는 소카테고리의 정보를 검색한다
	 * @param subCategoryCode 소카테고리 고유식별코드
	 * @return 소카테고리코드에 해당하는 소카테고리의 정보를 리터한다
	 */
	public SubCategoryDTO selectSubCategory(String subCategoryCode) 
	{
		SubCategoryDTO subCategoryDTO=null;
	
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECT_SUBCATE_SQL1);
			pstmt.setString(1, subCategoryCode);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				subCategoryDTO=new SubCategoryDTO(resultSet.getString("sub_category_code"), resultSet.getString("main_category_code"), resultSet.getString("category_name"));
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
		return subCategoryDTO;
	}
	
	/**
	 * 대카테고리코드에 해당하는 소 카테고리정보들을 검색한다
	 * @param mainCategoryCode 대카테고리 고유식별코드
	 * @return 대카테고리코드에 해당하는 소 카테고리정보들을 리턴한다
	 */
	public List<SubCategoryDTO> selectSubCategorys(String mainCategoryCode) //main카테고리의 자식 카테고리들을 찾는다
	{
		List<SubCategoryDTO> list=new ArrayList<SubCategoryDTO>();
	
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECT_SUBCATE_SQL2);
			pstmt.setString(1, mainCategoryCode);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				SubCategoryDTO subCategoryDTO=new SubCategoryDTO(resultSet.getString("sub_category_code"), resultSet.getString("main_category_code"), resultSet.getString("category_name"));
				list.add(subCategoryDTO);
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
	 * 소카테고리코드에 해당하는 소카테고리정보의 대카테고리와 소카테고리명을 수정한다
	 * @param subCategoryCode  소카테고리 고유식별코드
	 * @param mainCategoryCode 대카테고리 고유식별코드
	 * @param subCategoryName 소카테고리명
	 * @return 수정 성공여부를 리턴한다
	 */
	public boolean update(String subCategoryCode, String mainCategoryCode, String subCategoryName)  
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(UPDATE_SUBCATE_SQL1);
			pstmt.setString(1, mainCategoryCode);
			pstmt.setString(2, subCategoryName); 
			pstmt.setString(3, subCategoryCode); 
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
	 * 소카테고리코드에 해당하는 소카테고리정보의 대카테고리코드를 수정한다
	 * @param subCategoryCode 소카테고리 고유식별코드
	 * @param mainCategoryCode 대카테고리 고유식별코드
	 * @return 수정 성공여부를 리턴한다
	 */
	public boolean updateMainCategoryCode(String subCategoryCode, String mainCategoryCode) 
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(UPDATE_SUBCATE_SQL2);
			pstmt.setString(1, mainCategoryCode); 
			pstmt.setString(2, subCategoryCode); 
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
	 * 소카테고리코드에 해당하는 소카테고리정보의 소카테고리명을 수정한다
	 * @param subCategoryCode 소카테고리 고유식별코드
	 * @param subCategoryName 소카테고리명
	 * @return 수정 성공여부를 리턴한다
	 */
	public boolean updateSubCategoryName(String subCategoryCode, String subCategoryName) 
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(UPDATE_SUBCATE_SQL3);
			pstmt.setString(1, subCategoryName); 
			pstmt.setString(2, subCategoryCode); 
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
}
