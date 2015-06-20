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
 * 지도에업로드한 사진 정보를 관리한다
 * @author 화섭
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
	 * 지도에 업로드한 사진정보를 등록한다
	 * @param memberCode 회원 고유식별코드
	 * @param photoCode 사진 고유식별코드
	 * @param locationCode 위치 고유식별코드
	 * @param content 사진에 대한 간단한 메모
	 * @return 등록성공여부를 리턴한다
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
	 * 등록된 모든 지도에 업로드한 사진의 정보를 삭제한다
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
	 * 지도에 등록한 사진코드에 해당하는 지도에 등록된 사진의 정보를 삭제한다
	 * @param mapPhotoUploadCode 지도에 등록한 사진정보의 고유식별코드
	 * @return 삭제 성공여부를 리턴한다
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
	 * 회원코드에 해당하는 지도에 등록한 사진정보를 삭제한다
	 * @param memberCode 회원 고유식별코드
	 * @return 삭제성공여부를 리턴한다
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
	 * 위치코드에 해당하는 지도에 등록한 사진정보를 삭제한다
	 * @param locationCode 위치 고유식별코드
	 * @return 삭제 성공여부를 리턴한다
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
	 * 등록된 모든 지도에 등록된 사진정보들을 검색한다
	 * @return 등록된 모든 지도에 등록된 사진정보를 리턴한다
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
	 * 지도에 등록한 사진코드에 해당하는 지도에 등록한 사진정보를 검색한다
	 * @param mapPhotoUploadCode 지도에 등록한 사진 고유식별코드
	 * @return 지도에 등록한 사진코드에 해당하는 지도에 등록되 사진정보를 리턴한다
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
	 * 회원코드에 해당하는 지도에 등록된 사진정보들을 검색한다
	 * @param memberCode 회원 고유식별코드
	 * @return 회원코드에 해당하는 지도에 등록된 사진정보들을 리턴한다
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
	 * 위치정보코드에 해당하는 사진업로드정보를 검색한다
	 * @param locationCode 위치 고유식별코드
	 * @return 위치정보코드에 해당하는 사진업로드정보를 리턴한다
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
	 * 회원코드에 위치코드에 해당하는 지도에업로드된사진정보를 검색한다
	 * @param memberCode 회원 고유식별코드
	 * @param locationCode 위치 고유식별코드
	 * @return 회원코드와 위치코드에 해당하는 지도에 업로드된 사진정보를 리턴한다
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
	 * 지도에 업로드된 사진 코드에 해당하는 지도에 업로드된 사진정보의 사진코드와 위치코드, 메모를 수정한다
	 * @param mapPhotoUploadCode 지도에업로드된사진의 고유식별코드
	 * @param photoCode 사진 고유식별코드
	 * @param locationCode 위치 고유식별코드
	 * @param content 사진에 대한 간략한 메모
	 * @return 수정 성공여부를 리턴한다
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
	 * 지도에등록된사진정보의 코드에 해당하는 지도에등록된 사진정보의 메모를 수정한다
	 * @param mapPhotoUploadCode 지도에 등록된 사진의 고유식별코드
	 * @param content 사진에 대한 간략한 메모
	 * @return 지도에등록된사진정보코드에 해당하는 지도에 등록된 사진정보를 리턴한다
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
