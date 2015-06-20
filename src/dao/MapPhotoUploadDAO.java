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
 * ���������ε��� ���� ������ �����Ѵ�
 * @author ȭ��
 *
 */
public class MapPhotoUploadDAO 
{
	private static final String INSERT_MAPPHOTOUPLOAD_SQL="INSERT INTO map_photo_upload_tb VALUES(map_photo_upload_code,?,?, ?,?)";
	private static final String DELETEALL_MAPPHOTOUPLOAD_SQL="DELETE FROM map_photo_upload_tb";
	private static final String DELETE_MAPPHOTOUPLOAD_SQL1="DELETE FROM map_photo_upload_tb WHERE map_photo_upload_code=?";
	private static final String DELETE_MAPPHOTOUPLOAD_SQL2="DELETE FROM map_photo_upload_tb WHERE member_code=?";
	private static final String DELETE_MAPPHOTOUPLOAD_SQL3="DELETE FROM map_photo_upload_tb WHERE location_code=?";
	private static final String SELECTALL_MAPPHOTOUPLOAD_SQL="SELECT map_photo_upload_code, member_code, photo_code, location_code, content FROM map_photo_upload_tb";
	private static final String SELECT_MAPPHOTOUPLOAD_SQL1="SELECT map_photo_upload_code, member_code, photo_code, location_code, content FROM map_photo_upload_tb WHERE map_photo_upload_code=?";
	private static final String SELECT_MAPPHOTOUPLOAD_SQL2="SELECT map_photo_upload_code, member_code, photo_code, location_code, content FROM map_photo_upload_tb WHERE member_code=?";
	private static final String SELECT_MAPPHOTOUPLOAD_SQL3="SELECT map_photo_upload_code, member_code, photo_code, location_code, content FROM map_photo_upload_tb WHERE location_code=?";
	private static final String SELECT_MAPPHOTOUPLOAD_SQL4="SELECT map_photo_upload_code, member_code, photo_code, location_code, content FROM map_photo_upload_tb WHERE member_code=? AND location_code=?";
	private static final String UPDATE_MAPPHOTOUPLOAD_SQL1="UPDATE map_photo_upload_tb SET photo_code=?, location_code=?, content=? WHERE map_photo_upload_code=?";
	private static final String UPDATE_MAPPHOTOUPLOAD_SQL2="UPDATE map_photo_upload_tb SET content=? WHERE map_photo_upload_code=?";
 
	
	public MapPhotoUploadDAO()
	{
	}
	
	/**
	 * ������ ���ε��� ���������� ����Ѵ�
	 * @param memberCode ȸ�� �����ĺ��ڵ�
	 * @param photoCode ���� �����ĺ��ڵ�
	 * @param locationCode ��ġ �����ĺ��ڵ�
	 * @param content ������ ���� ������ �޸�
	 * @return ��ϼ������θ� �����Ѵ�
	 */
	public boolean insert(String memberCode, String photoCode, String locationCode, String content)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(INSERT_MAPPHOTOUPLOAD_SQL); 
			pstmt.setString(1, memberCode); 
			pstmt.setString(2, photoCode); 
			pstmt.setString(3, locationCode); 
			pstmt.setString(4, content); 
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
	 * ��ϵ� ��� ������ ���ε��� ������ ������ �����Ѵ�
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
			pstmt=connection.prepareStatement(DELETEALL_MAPPHOTOUPLOAD_SQL);
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
	 * ������ ����� �����ڵ忡 �ش��ϴ� ������ ��ϵ� ������ ������ �����Ѵ�
	 * @param mapPhotoUploadCode ������ ����� ���������� �����ĺ��ڵ�
	 * @return ���� �������θ� �����Ѵ�
	 */
	public boolean deleteByMapPhoto(String mapPhotoUploadCode)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(DELETE_MAPPHOTOUPLOAD_SQL1);
			pstmt.setString(1,  mapPhotoUploadCode);
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
	 * ȸ���ڵ忡 �ش��ϴ� ������ ����� ���������� �����Ѵ�
	 * @param memberCode ȸ�� �����ĺ��ڵ�
	 * @return �����������θ� �����Ѵ�
	 */
	public boolean deleteByMem(String memberCode)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(DELETE_MAPPHOTOUPLOAD_SQL2);
			pstmt.setString(1,  memberCode);
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
	 * ��ġ�ڵ忡 �ش��ϴ� ������ ����� ���������� �����Ѵ�
	 * @param locationCode ��ġ �����ĺ��ڵ�
	 * @return ���� �������θ� �����Ѵ�
	 */
	public boolean deleteByLocation(String locationCode)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(DELETE_MAPPHOTOUPLOAD_SQL3);
			pstmt.setString(1,  locationCode);
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
	 * ��ϵ� ��� ������ ��ϵ� ������������ �˻��Ѵ�
	 * @return ��ϵ� ��� ������ ��ϵ� ���������� �����Ѵ�
	 */
	public List<MapPhotoUploadDTO> selectAll()
	{
		List<MapPhotoUploadDTO> list=new ArrayList<MapPhotoUploadDTO>();
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECTALL_MAPPHOTOUPLOAD_SQL);
			
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				MapPhotoUploadDTO mapPhotoUploadDTO=new MapPhotoUploadDTO(resultSet.getString("map_photo_upload_code"), resultSet.getString("member_code"), resultSet.getString("photo_code"), resultSet.getString("location_code"), resultSet.getString("content"));
				list.add(mapPhotoUploadDTO);
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
	 * ������ ����� �����ڵ忡 �ش��ϴ� ������ ����� ���������� �˻��Ѵ�
	 * @param mapPhotoUploadCode ������ ����� ���� �����ĺ��ڵ�
	 * @return ������ ����� �����ڵ忡 �ش��ϴ� ������ ��ϵ� ���������� �����Ѵ�
	 */
	public MapPhotoUploadDTO selectByMapPhoto(String mapPhotoUploadCode)  
	{
		MapPhotoUploadDTO mapPhotoUploadDTO=null;
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECT_MAPPHOTOUPLOAD_SQL1);
			pstmt.setString(1, mapPhotoUploadCode);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				mapPhotoUploadDTO=new MapPhotoUploadDTO(resultSet.getString("map_photo_upload_code"), resultSet.getString("member_code"), resultSet.getString("photo_code"), resultSet.getString("location_code"), resultSet.getString("content"));
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
		return mapPhotoUploadDTO;
	}
	
	/**
	 * ȸ���ڵ忡 �ش��ϴ� ������ ��ϵ� ������������ �˻��Ѵ�
	 * @param memberCode ȸ�� �����ĺ��ڵ�
	 * @return ȸ���ڵ忡 �ش��ϴ� ������ ��ϵ� ������������ �����Ѵ�
	 */
	public List<MapPhotoUploadDTO> selectByMem(String memberCode)
	{
		List<MapPhotoUploadDTO> list=new ArrayList<MapPhotoUploadDTO>();
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECT_MAPPHOTOUPLOAD_SQL2);
			pstmt.setString(1, memberCode);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				MapPhotoUploadDTO mapPhotoUploadDTO=new MapPhotoUploadDTO(resultSet.getString("map_photo_upload_code"), resultSet.getString("member_code"), resultSet.getString("photo_code"), resultSet.getString("location_code"), resultSet.getString("content"));
				list.add(mapPhotoUploadDTO);
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
	 * ��ġ�����ڵ忡 �ش��ϴ� �������ε������� �˻��Ѵ�
	 * @param locationCode ��ġ �����ĺ��ڵ�
	 * @return ��ġ�����ڵ忡 �ش��ϴ� �������ε������� �����Ѵ�
	 */
	public List<MapPhotoUploadDTO> selectByLocation(String locationCode)
	{
		List<MapPhotoUploadDTO> list=new ArrayList<MapPhotoUploadDTO>();
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECT_MAPPHOTOUPLOAD_SQL3);
			pstmt.setString(1, locationCode);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				MapPhotoUploadDTO mapPhotoUploadDTO=new MapPhotoUploadDTO(resultSet.getString("map_photo_upload_code"), resultSet.getString("member_code"), resultSet.getString("photo_code"), resultSet.getString("location_code"), resultSet.getString("content"));
				list.add(mapPhotoUploadDTO);
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
	 * ȸ���ڵ忡 ��ġ�ڵ忡 �ش��ϴ� ���������ε�Ȼ��������� �˻��Ѵ�
	 * @param memberCode ȸ�� �����ĺ��ڵ�
	 * @param locationCode ��ġ �����ĺ��ڵ�
	 * @return ȸ���ڵ�� ��ġ�ڵ忡 �ش��ϴ� ������ ���ε�� ���������� �����Ѵ�
	 */
	public List<MapPhotoUploadDTO> selectByLocation(String memberCode, String locationCode)
	{
		List<MapPhotoUploadDTO> list=new ArrayList<MapPhotoUploadDTO>();
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECT_MAPPHOTOUPLOAD_SQL4);
			pstmt.setString(1, memberCode);
			pstmt.setString(1, locationCode);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				MapPhotoUploadDTO mapPhotoUploadDTO=new MapPhotoUploadDTO(resultSet.getString("map_photo_upload_code"), resultSet.getString("member_code"), resultSet.getString("photo_code"), resultSet.getString("location_code"), resultSet.getString("content"));
				list.add(mapPhotoUploadDTO);
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
	 * ������ ���ε�� ���� �ڵ忡 �ش��ϴ� ������ ���ε�� ���������� �����ڵ�� ��ġ�ڵ�, �޸� �����Ѵ�
	 * @param mapPhotoUploadCode ���������ε�Ȼ����� �����ĺ��ڵ�
	 * @param photoCode ���� �����ĺ��ڵ�
	 * @param locationCode ��ġ �����ĺ��ڵ�
	 * @param content ������ ���� ������ �޸�
	 * @return ���� �������θ� �����Ѵ�
	 */
	public boolean update(String mapPhotoUploadCode, String photoCode, String locationCode, String content) 
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(UPDATE_MAPPHOTOUPLOAD_SQL1);
			pstmt.setString(1, photoCode);
			pstmt.setString(2, locationCode);
			pstmt.setString(3, content);
			pstmt.setString(4, mapPhotoUploadCode);
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
	 * ��������ϵȻ��������� �ڵ忡 �ش��ϴ� ��������ϵ� ���������� �޸� �����Ѵ�
	 * @param mapPhotoUploadCode ������ ��ϵ� ������ �����ĺ��ڵ�
	 * @param content ������ ���� ������ �޸�
	 * @return ��������ϵȻ��������ڵ忡 �ش��ϴ� ������ ��ϵ� ���������� �����Ѵ�
	 */
	public boolean update(String mapPhotoUploadCode, String content) 
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(UPDATE_MAPPHOTOUPLOAD_SQL2);
			pstmt.setString(1, content);
			pstmt.setString(2, mapPhotoUploadCode);
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
