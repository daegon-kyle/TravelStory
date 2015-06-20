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
 * 방문신청정보를 관리하는 클래스이다
 * @author 화섭
 *
 */
public class VisitRequestDAO 
{
	private static final String INSERT_VISITREQUEST_SQL="INSERT INTO visit_request_tb VALUES(visit_request_code.NEXTVAL, ?, ?, ?)";
	private static final String DELETEALL_VISITREQUEST_SQL="DELETE FROM visit_request_tb";
	private static final String DELETE_VISITREQUEST_SQL1="DELETE FROM visit_request_tb WHERE house_owner_code=? AND tourist_code=?";
	private static final String DELETE_VISITREQUEST_SQL2="DELETE FROM visit_request_tb WHERE house_owner_code=?";
	private static final String DELETE_VISITREQUEST_SQL3="DELETE FROM visit_request_tb WHERE tourist_code=?";
	
	private static final String SELECTALL_VISITREQUEST_SQL="SELECT visit_request_code, house_owner_code, tourist_code, request_state FROM visit_request_tb";
	private static final String SELECT_VISITREQUEST_SQL1="SELECT visit_request_code, house_owner_code, tourist_code, request_state FROM visit_request_tb WHERE house_owner_code=?";
	private static final String SELECT_VISITREQUEST_SQL2="SELECT visit_request_code, house_owner_code, tourist_code, request_state FROM visit_request_tb WHERE tourist_code=?";
	private static final String SELECT_VISITREQUEST_SQL3="SELECT visit_request_code, house_owner_code, tourist_code, request_state FROM visit_request_tb WHERE house_owner_code=? AND tourist_code=?";
	private static final String UPDATE_VISITREQUEST_SQL="UPDATE visit_request_tb SET request_state=? WHERE house_owner_code=? AND tourist_code=?"; 
	private static final String GETTOURISTCODE_SQL="SELECT visit tourist_code FROM visit_request_tb WHERE house_owner_code=? AND member_code=?";
	
	public VisitRequestDAO()
	{
	}
	
	/**
	 * 방문신청정보를 등록한다
	 * @param houseOwnerCode 집주인 고유식별코드
	 * @param touristCode 여행객 고유식별코드
	 * @param requestState 진행상태
	 * @return 등록 성공엽를 리턴한다
	 */
	public boolean insert(String houseOwnerCode, String touristCode, String requestState)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(INSERT_VISITREQUEST_SQL);
			pstmt.setString(1, houseOwnerCode); 
			pstmt.setString(2, touristCode);  
			pstmt.setString(3, requestState);  
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
	 * 등록된 모든 방문신청 상태를 삭제한다
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
			pstmt=connection.prepareStatement(DELETEALL_VISITREQUEST_SQL);
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
	 * 집주인과 여행객 사이의 진행상태를 삭제한다
	 * @param houseOwnerCode 집주인 고유식별코드
	 * @param touristCode 여행객고유식별코드
	 * @return 삭제 성공여부를 리턴한다
	 */
	public boolean delete(String houseOwnerCode, String touristCode) //하나의 요청을 삭제
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(DELETE_VISITREQUEST_SQL1);
			pstmt.setString(1,  houseOwnerCode);
			pstmt.setString(2,  touristCode);
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
	 * 집주인코드에 해당하는 집주인의 진행상태 정보들을 모두 삭제한다
	 * @param houseOwnerCode 집주인 고유식별코드
	 * @return 삭제 성공여부를 리턴한다
	 */
	public boolean deleteHouseOwnerCode(String houseOwnerCode)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(DELETE_VISITREQUEST_SQL2);
			pstmt.setString(1,  houseOwnerCode);
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
	 * 여행객 코드에 해당하는 여행객의 진행상태들을 모두 삭제한다
	 * @param touristCode 여행객 고유식별코드
	 * @return 삭제 성공여부를 리턴한다
	 */
	public boolean deleteTouristCode(String touristCode)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(DELETE_VISITREQUEST_SQL3);
			pstmt.setString(1,  touristCode);
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
	 * 등록된 모든 진행상태를 검색한다
	 * @return 등록된 모든 진행상태를 리턴한다
	 */
	public List<VisitRequestDTO> selectAll()
	{
		List<VisitRequestDTO> list=new ArrayList<VisitRequestDTO>();
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECTALL_VISITREQUEST_SQL);
			
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				VisitRequestDTO visitRequestDTO=new VisitRequestDTO(resultSet.getString("visit_request_code"), resultSet.getString("house_owner_code"), resultSet.getString("tourist_code"), resultSet.getString("request_state"));
				list.add(visitRequestDTO);
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
	 * 집주인코드를 이용해 집주인 본인에게 방문신청한 모든 여행객들과의 진행상태들을 검색한다
	 * @param houseOwnerCode 집주인 고유식별코드
	 * @return 집주인에게 방문신청한 모든 여행객들과의 진행상태를 리턴한다
	 */
	public List<VisitRequestDTO> selectHouseOwnerCode(String houseOwnerCode)//집주인이 본인집에 방문 요청한 여행객 리스트 검색한다
	{
		List<VisitRequestDTO> list=new ArrayList<VisitRequestDTO>();
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECT_VISITREQUEST_SQL1);
			pstmt.setString(1, houseOwnerCode);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				VisitRequestDTO visitRequestDTO=new VisitRequestDTO(resultSet.getString("visit_request_code"), resultSet.getString("house_owner_code"), resultSet.getString("tourist_code"), resultSet.getString("request_state"));
				list.add(visitRequestDTO);
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
	 * 여행객코드를 이용해 여행객 본인이 방문신청한 집주인들과의 진행상태를 검색한다
	 * @param touristCode 여행객 고유 식별코드
	 * @return 여행객코드에 해당하는 집주인과의 진행상태를 리턴한다
	 */
	public List<VisitRequestDTO> selectTouristCode(String touristCode) //여행객이 본인이 신청한 집주인리스트를 검색한다. 
	{
		List<VisitRequestDTO> list=new ArrayList<VisitRequestDTO>();
	
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECT_VISITREQUEST_SQL2);
			pstmt.setString(1, touristCode);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				VisitRequestDTO visitRequestDTO=new VisitRequestDTO(resultSet.getString("visit_request_code"), resultSet.getString("house_owner_code"), resultSet.getString("tourist_code"), resultSet.getString("request_state"));
				list.add(visitRequestDTO);
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
	 * 집주인과 여행객 사이의 진행상태를 검색한다
	 * @param houseOwnerCode 집주인의 고유식별코드
	 * @param touristCode 여행객의 고유식별코드
	 * @return 집주인과 여행객사이의 진행상태를 리턴한다
	 */
	public VisitRequestDTO select(String houseOwnerCode, String touristCode) 
	{
		VisitRequestDTO visitRequestDTO=null;
	
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECT_VISITREQUEST_SQL3);
			pstmt.setString(1, houseOwnerCode);
			pstmt.setString(2, touristCode);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				visitRequestDTO=new VisitRequestDTO(resultSet.getString("visit_request_code"), resultSet.getString("house_owner_code"), resultSet.getString("tourist_code"), resultSet.getString("request_state"));
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
		return visitRequestDTO;
	}
	
	/**
	 * 집주인코드와 여행객 코드에 해당하는 진행상태정보의 진행상태를 수정한다
	 * @param houseOwnerCode 집주인 고유식별코드
	 * @param touristCode 여행객 고유식벼로드
	 * @param requestState 진행상태
	 * @return 수정 성공여부를 리턴한다
	 */
	public boolean update(String houseOwnerCode, String touristCode, String requestState)  
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(UPDATE_VISITREQUEST_SQL);
			pstmt.setString(1, requestState);
			pstmt.setString(2, houseOwnerCode); 
			pstmt.setString(3, touristCode);
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
	
	public String getTouristCode(String houseOwnerCode, String memberCode)
	{
		String touristCode=null;
		
		VisitRequestDTO visitRequestDTO=null;
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(GETTOURISTCODE_SQL);
			pstmt.setString(1, houseOwnerCode);
			pstmt.setString(2, memberCode);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				touristCode=resultSet.getString("tourist_code");
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
		return touristCode;
	}
	 
}
