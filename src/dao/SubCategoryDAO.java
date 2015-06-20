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
 * ��ī�װ������� �����ϴ� Ŭ�����̴�
 * @author ȭ��
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
	 * ��ī�װ������� ����Ѵ�
	 * @param mainCategoryCode ��ī�װ� �����ĺ��ڵ�
	 * @param subCategoryName ��ī�װ���
	 * @return ��� �������θ� �����Ѵ�
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
	 * ��ϵ� ��� ��ī�װ� �������� �����Ѵ�
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
	 * ��ī�װ��ڵ忡 �ش��ϴ� ��ī�װ������� �����Ѵ�
	 * @param subCategoryCode ��ī�װ� �����ĺ��ڵ�
	 * @return ���� �������θ� �����Ѵ�
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
	 * ��ī�װ��ڵ忡 �ش�(��ī�װ� �Ҽ�)�ϴ� ��ī�װ����� �����Ѵ� 
	 * @param mainCategoryCode ��ī�װ� �����ĺ��ڵ�
	 * @return ���� �������θ� �����Ѵ�
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
	 * ��ϵ� ��� ��ī�װ��������� �˻��Ѵ�
	 * @return ��ϵ� ��� ��ī�װ��������� �����Ѵ�
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
	 * ��ī�װ��ڵ忡 �ش��ϴ� ��ī�װ��� ������ �˻��Ѵ�
	 * @param subCategoryCode ��ī�װ� �����ĺ��ڵ�
	 * @return ��ī�װ��ڵ忡 �ش��ϴ� ��ī�װ��� ������ �����Ѵ�
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
	 * ��ī�װ��ڵ忡 �ش��ϴ� �� ī�װ��������� �˻��Ѵ�
	 * @param mainCategoryCode ��ī�װ� �����ĺ��ڵ�
	 * @return ��ī�װ��ڵ忡 �ش��ϴ� �� ī�װ��������� �����Ѵ�
	 */
	public List<SubCategoryDTO> selectSubCategorys(String mainCategoryCode) //mainī�װ��� �ڽ� ī�װ����� ã�´�
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
	 * ��ī�װ��ڵ忡 �ش��ϴ� ��ī�װ������� ��ī�װ��� ��ī�װ����� �����Ѵ�
	 * @param subCategoryCode  ��ī�װ� �����ĺ��ڵ�
	 * @param mainCategoryCode ��ī�װ� �����ĺ��ڵ�
	 * @param subCategoryName ��ī�װ���
	 * @return ���� �������θ� �����Ѵ�
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
	 * ��ī�װ��ڵ忡 �ش��ϴ� ��ī�װ������� ��ī�װ��ڵ带 �����Ѵ�
	 * @param subCategoryCode ��ī�װ� �����ĺ��ڵ�
	 * @param mainCategoryCode ��ī�װ� �����ĺ��ڵ�
	 * @return ���� �������θ� �����Ѵ�
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
	 * ��ī�װ��ڵ忡 �ش��ϴ� ��ī�װ������� ��ī�װ����� �����Ѵ�
	 * @param subCategoryCode ��ī�װ� �����ĺ��ڵ�
	 * @param subCategoryName ��ī�װ���
	 * @return ���� �������θ� �����Ѵ�
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
