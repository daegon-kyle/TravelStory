//작성날짜 : 2014/7/20
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
 *  회원이 여행객으로 등록하여 방분요청한 집주인의 정보와 진행상태를 관리하는 클래스
 * @author 화섭
 *
 */
public class CheckRequestStateDAO
{ 
	private static final String SELECT_CHECKREQUESTSTATE_SQL1="SELECT member_code, tourist_code, house_owner_code, request_state, house_owner_name, house_owner_email, house_owner_gender, house_owner_job, house_owner_visit_start_date, house_owner_visit_end_date, house_owner_self_introduction, house_owner_married_state, house_owner_address, house_owner_etc, house_owner_reliability FROM check_request_state_view WHERE member_code=? ORDER BY house_owner_visit_start_date, house_owner_reliability DESC";
	private static final String SELECT_CHECKREQUESTSTATE_SQL2="SELECT member_code, tourist_code, house_owner_code, request_state, house_owner_name, house_owner_email, house_owner_gender, house_owner_job, house_owner_visit_start_date, house_owner_visit_end_date, house_owner_self_introduction, house_owner_married_state, house_owner_address, house_owner_etc, house_owner_reliability FROM check_request_state_view WHERE member_code=? AND request_state=? ORDER BY house_owner_visit_start_date, house_owner_reliability DESC";
	private static final String SELECT_CHECKREQUESTSTATE_SQL3="SELECT member_code, tourist_code, house_owner_code, request_state, house_owner_name, house_owner_email, house_owner_gender, house_owner_job, house_owner_visit_start_date, house_owner_visit_end_date, house_owner_self_introduction, house_owner_married_state, house_owner_address, house_owner_etc, house_owner_reliability FROM check_request_state_view WHERE tourist_code=? ORDER BY house_owner_visit_start_date, house_owner_reliability DESC";
	private static final String SELECTALL_CHECKREQUESTSTATE_SQL="SELECT member_code, tourist_code, house_owner_code, request_state, house_owner_name, house_owner_email, house_owner_gender, house_owner_job, house_owner_visit_start_date, house_owner_visit_end_date, house_owner_self_introduction, house_owner_married_state, house_owner_address, house_owner_etc, house_owner_reliability FROM check_request_state_view ORDER BY house_owner_visit_start_date, house_owner_reliability DESC"; 	
	
	public CheckRequestStateDAO()
	{
		
	}
	
    
	/**
	 * 회원 본인이 여행객으로 등록하여 신청하였던 모든 집주인의 정보와 진행상태를 검색한다 
	 * @param memberCode 회원 고유 식별코드
	 * @return 방문 신청하였던 모든 집주인의 정보와 진행상태들
	 */
	public List<CheckRequestStateDTO> selectRequestStates(String memberCode)
	{
		List<CheckRequestStateDTO> list=new ArrayList<CheckRequestStateDTO>();
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection(); 
			pstmt=connection.prepareStatement(SELECT_CHECKREQUESTSTATE_SQL1);
			pstmt.setString(1, memberCode);  
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				CheckRequestStateDTO checkRequestStateDTO=new CheckRequestStateDTO(resultSet.getString("member_code"), resultSet.getString("tourist_code"), resultSet.getString("house_owner_code"), resultSet.getString("request_state"), resultSet.getString("house_owner_name"), resultSet.getString("house_owner_email"), resultSet.getString("house_owner_gender"), resultSet.getString("house_owner_job"), resultSet.getString("house_owner_visit_start_date"), resultSet.getString("house_owner_visit_end_date"), resultSet.getString("house_owner_self_introduction"), resultSet.getString("house_owner_married_state"), resultSet.getString("house_owner_address"), resultSet.getString("house_owner_etc"), resultSet.getString("house_owner_reliability"));
				list.add(checkRequestStateDTO);
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
	 * 회원 본인이 여행객으로 등록(여러번 가능)하여 신청하였던 모든 집주인의 정보와 진행상태를 검색한다 
	 * @param memberCode 회원 고유 식별코드
	 * @param requestState 진행상태
	 * @return 진행상태별로 회원 본인이 방문 신청하였던 모든 집주인의 정보와 진행상태들
	 */
	public List<CheckRequestStateDTO> selectRequestStates(String memberCode, String requestState)
	{
		List<CheckRequestStateDTO> list=new ArrayList<CheckRequestStateDTO>();
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection(); 
			pstmt=connection.prepareStatement(SELECT_CHECKREQUESTSTATE_SQL2);
			pstmt.setString(1, memberCode);  
			pstmt.setString(2, requestState);  
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				CheckRequestStateDTO checkRequestStateDTO=new CheckRequestStateDTO(resultSet.getString("member_code"), resultSet.getString("tourist_code"), resultSet.getString("house_owner_code"), resultSet.getString("request_state"), resultSet.getString("house_owner_name"), resultSet.getString("house_owner_email"), resultSet.getString("house_owner_gender"), resultSet.getString("house_owner_job"), resultSet.getString("house_owner_visit_start_date"), resultSet.getString("house_owner_visit_end_date"), resultSet.getString("house_owner_self_introduction"), resultSet.getString("house_owner_married_state"), resultSet.getString("house_owner_address"), resultSet.getString("house_owner_etc"), resultSet.getString("house_owner_reliability"));
				list.add(checkRequestStateDTO);
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
	 * 회원 본인이 여행객으로 등록(1번) 정보로 방문신청한 집주인의 정보와 진행상태를 검색한다
	 * @param touristCode 여행객 고유 식별코드
	 * @return 여행객으로 등록하여 방문신청한 모든 집주인의 정보와 진행상태들
	 */
	public CheckRequestStateDTO selectRequestState(String touristCode)
	{
		CheckRequestStateDTO checkRequestStateDTO=null;
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection(); 
			pstmt=connection.prepareStatement(SELECT_CHECKREQUESTSTATE_SQL3);
			pstmt.setString(1, touristCode);  
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				checkRequestStateDTO=new CheckRequestStateDTO(resultSet.getString("member_code"), resultSet.getString("tourist_code"), resultSet.getString("house_owner_code"), resultSet.getString("request_state"), resultSet.getString("house_owner_name"), resultSet.getString("house_owner_email"), resultSet.getString("house_owner_gender"), resultSet.getString("house_owner_job"), resultSet.getString("house_owner_visit_start_date"), resultSet.getString("house_owner_visit_end_date"), resultSet.getString("house_owner_self_introduction"), resultSet.getString("house_owner_married_state"), resultSet.getString("house_owner_address"), resultSet.getString("house_owner_etc"), resultSet.getString("house_owner_reliability"));
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
		return checkRequestStateDTO;
	} 
	
	/**
	 * 모든 방문신청한 집주인의 정보와 진행상태를 검색한다
	 * @return 모든 집주인의 정보와 진행상태들
	 */
	public List<CheckRequestStateDTO> selectAllRequestState()
	{
		List<CheckRequestStateDTO> list=new ArrayList<CheckRequestStateDTO>();
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection(); 
			pstmt=connection.prepareStatement(SELECTALL_CHECKREQUESTSTATE_SQL);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				CheckRequestStateDTO checkRequestStateDTO=new CheckRequestStateDTO(resultSet.getString("member_code"), resultSet.getString("tourist_code"), resultSet.getString("house_owner_code"), resultSet.getString("request_state"), resultSet.getString("house_owner_name"), resultSet.getString("house_owner_email"), resultSet.getString("house_owner_gender"), resultSet.getString("house_owner_job"), resultSet.getString("house_owner_visit_start_date"), resultSet.getString("house_owner_visit_end_date"), resultSet.getString("house_owner_self_introduction"), resultSet.getString("house_owner_married_state"), resultSet.getString("house_owner_address"), resultSet.getString("house_owner_etc"), resultSet.getString("house_owner_reliability"));
				list.add(checkRequestStateDTO);
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
}
