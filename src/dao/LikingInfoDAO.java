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
 * 선호도 정보를 관리하는 클래스이다
 * @author 화섭
 *
 */
public class LikingInfoDAO 
{
	private static final String INSERT_LIKINGINFO_SQL="INSERT INTO liking_info_tb VALUES(liking_info_code.NEXTVAL, ?, ?, ?, ?, ?)"; 
	private static final String DELETEALL_LIKINGINFO_SQL="DELETE FROM liking_info_tb";
	private static final String DELETE_LIKINGINFO_SQL="DELETE FROM liking_info_tb WHERE liking_info_code=?";
	private static final String SELECTALL_LIKINGINFO_SQL="SELECT liking_info_code, restaurant_preference, healing_preference, attraction_preference, shopping_preference, etc_preference FROM liking_info_tb";
	private static final String SELECT_LIKINGINFO_SQL="SELECT liking_info_code, restaurant_preference, healing_preference, attraction_preference, shopping_preference, etc_preference FROM liking_info_tb WHERE liking_info_code=?";
	private static final String SELECTCODE_LIKINGINFO_SQL="SELECT liking_info_code FROM liking_info_tb WHERE restaurant_preference=? AND healing_preference=? AND attraction_preference=? AND shopping_preference=? AND etc_preference=?";
	private static final String UPDATE_LIKINGINFO_SQL="UPDATE liking_info_tb SET restaurant_preference=?, healing_preference=?, attraction_preference=?, shopping_preference=?,  etc_preference=? WHERE liking_info_code=?";
 	
	
	public LikingInfoDAO()
	{
	}
	
	/**
	 * 선호도 정보를 등록한다
	 * @param restaurant 맛집 선호도
	 * @param healing 힐링 선호도
	 * @param attraction 관광명소 선호도
	 * @param shopping 쇼핑 선호도
	 * @param etc 기타
	 * @return 등록성공여부를 리턴한다
	 */
	public boolean insert(int restaurant, int healing, int attraction, int shopping, int etc)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(INSERT_LIKINGINFO_SQL);
			pstmt.setInt(1, restaurant); 
			pstmt.setInt(2, healing); 
			pstmt.setInt(3, attraction); 
			pstmt.setInt(4, shopping); 
			pstmt.setInt(5, etc); 
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
	 * 등록된 모든 선호도 정보를 삭제한다
	 * @return 삭제성공여부를 리턴한다
	 */
	public boolean deleteAll()
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(DELETEALL_LIKINGINFO_SQL);
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
	 * 선호도코드에 해당하는 선호도 정보를 삭제한다
	 * @param likingInfoCode 선호도 고유식별코드
	 * @return 삭제 성공여부를 리턴한다
	 */
	public boolean delete(String likingInfoCode)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(DELETE_LIKINGINFO_SQL);
			pstmt.setString(1,  likingInfoCode);
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
	 * 등록된 모든 선호도 정보를 검색한다
	 * @return 등록된 모든 선호도 정보를 리턴한다
	 */
	public List<LikingInfoDTO> selectAll()
	{
		List<LikingInfoDTO> list=new ArrayList<LikingInfoDTO>();
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECTALL_LIKINGINFO_SQL);
			
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				LikingInfoDTO likingInfoDTO=new LikingInfoDTO(resultSet.getString("liking_info_code"), resultSet.getInt("restaurant_preference"), resultSet.getInt("healing_preference"), resultSet.getInt("attraction_preference"), resultSet.getInt("shopping_preference"), resultSet.getInt("etc_preference"));
				list.add(likingInfoDTO);
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
	 * 선호도 코드에 해당하는 선호도 정보를 검색한다
	 * @param likingInfoCode 선호도 고유식별코드
	 * @return 선호도 코드에 해당하는 선호도 정보를 리턴한다
	 */
	public LikingInfoDTO select(String likingInfoCode) //likingInfoCode에 해당되는 정보를 찾는다
	{
		LikingInfoDTO likingInfoDTO=null;
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECT_LIKINGINFO_SQL);
			pstmt.setString(1, likingInfoCode);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				likingInfoDTO=new LikingInfoDTO(resultSet.getString("liking_info_code"), resultSet.getInt("restaurant_preference"), resultSet.getInt("healing_preference"), resultSet.getInt("attraction_preference"), resultSet.getInt("shopping_preference"), resultSet.getInt("etc_preference"));
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
		return likingInfoDTO;
	}
	
	/**
	 * 선호도 정보에 해당하는 선호도 코드를 찾는다
	 * @param restaurant 맛집 선호도
	 * @param healing 힐링 선호도
	 * @param attraction 관광명소 선호도
	 * @param shopping 쇼핑 선호도
	 * @param etc 기타 선호도
	 * @return 선호도 정보에 해당하는 선호도 코드를 리턴한다
	 */
	public String select(int restaurant, int healing, int attraction, int shopping, int etc) //해당되는 코드를 찾는다
	{
		String likingInfoCode=null;

		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECTCODE_LIKINGINFO_SQL);
			pstmt.setInt(1, restaurant);
			pstmt.setInt(2, healing);
			pstmt.setInt(3, attraction);
			pstmt.setInt(4, shopping);
			pstmt.setInt(5, etc);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				likingInfoCode=resultSet.getString("liking_info_code");
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
		return likingInfoCode;
	}
	
	public boolean update(String likingInfoCode, int restaurant, int healing, int attraction, int shopping, int etc) //취향을 수정한다.
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(UPDATE_LIKINGINFO_SQL);
			pstmt.setInt(1, restaurant);
			pstmt.setInt(2, healing);
			pstmt.setInt(3, attraction);
			pstmt.setInt(4, shopping);
			pstmt.setInt(5, etc);
			pstmt.setString(6,  likingInfoCode);
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
