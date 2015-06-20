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
 *  집주인이 방문 요청객의 방문 신청상태와 방문신요청객의 정보를 관리하는 클래스
 * @author 화섭
 *
 */
public class VisitRequestersInfoDAO
{ 
	private static final String SELECT_VISITREQUESTERSINFO_SQL1="SELECT house_owner_code, tourist_code, request_state, tourist_name, tourist_email, tourist_gender, tourist_job, tourist_arrival_date, tourist_departure_date, tourist_self_introduction, tourist_companion_num, tourist_reliability FROM visit_requesters_info_view WHERE house_owner_code=? ORDER BY tourist_arrival_date, tourist_reliability DESC";
	private static final String SELECT_VISITREQUESTERSINFO_SQL2="SELECT house_owner_code, tourist_code, request_state, tourist_name, tourist_email, tourist_gender, tourist_job, tourist_arrival_date, tourist_departure_date, tourist_self_introduction, tourist_companion_num, tourist_reliability FROM visit_requesters_info_view WHERE house_owner_code=? AND request_state=? ORDER BY tourist_arrival_date, tourist_reliability DESC";
	private static final String SELECTALL_VISITREQUESTERSINFO_SQL="SELECT house_owner_code, tourist_code, request_state, tourist_name, tourist_email, tourist_gender, tourist_job, tourist_arrival_date, tourist_departure_date, tourist_self_introduction, tourist_companion_num, tourist_reliability FROM visit_requesters_info_view ORDER BY tourist_arrival_date, tourist_reliability DESC";

	
	public VisitRequestersInfoDAO()
	{
	}
   
	/**
	 * 집주인의 고유식별코드를 이용해 현재 본인에게 방문 신청한 요청객들의 방문신청상태및 방문요청객의 정보를 검색한다
	 * @param houseOwnerCode 집주인의 고유식별코드
	 * @return 집주인에게 방문신청한 요청객들의 정보와 진행상태
	 */
	public List<VisitRequestersInfoDTO> selectTouristInfos(String houseOwnerCode)
	{
		List<VisitRequestersInfoDTO> list=new ArrayList<VisitRequestersInfoDTO>();
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection(); 
			pstmt=connection.prepareStatement(SELECT_VISITREQUESTERSINFO_SQL1);
			pstmt.setString(1, houseOwnerCode);  
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				VisitRequestersInfoDTO visitRequestersInfoDTO=new VisitRequestersInfoDTO(resultSet.getString("house_owner_code"), resultSet.getString("tourist_code"), resultSet.getString("request_state"), resultSet.getString("tourist_name"), resultSet.getString("tourist_email"), resultSet.getString("tourist_gender"), resultSet.getString("tourist_job"), resultSet.getString("tourist_arrival_date"), resultSet.getString("tourist_departure_date"), resultSet.getString("tourist_self_introduction"), resultSet.getInt("tourist_companion_num"), resultSet.getString("tourist_reliability"));
				list.add(visitRequestersInfoDTO);
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
	 * 집주인의 고유식별코드와 진행상태별로 분류하여 현재 본인에게 방문 신청한 요청객들의 방문신청상태및 방문요청객의 정보를 검색한다
	 * @param houseOwnerCode 집주인의 고유식별코드
	 * @param requestState 분류하여 보고싶은 방문요청 진행상태
	 * @return 집주인에게 방문신청한 요청객들의 정보와 진행상태
	 */
	public List<VisitRequestersInfoDTO> selectTouristInfos(String houseOwnerCode, String requestState) //진행상태(진행, 수락, 거부)에 따른 집주인의 관리 리스트 확인 가능 
	{
		List<VisitRequestersInfoDTO> list=new ArrayList<VisitRequestersInfoDTO>();
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection(); 
			pstmt=connection.prepareStatement(SELECT_VISITREQUESTERSINFO_SQL2);
			pstmt.setString(1, houseOwnerCode);  
			pstmt.setString(2, requestState);  
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				VisitRequestersInfoDTO visitRequestersInfoDTO=new VisitRequestersInfoDTO(resultSet.getString("house_owner_code"), resultSet.getString("tourist_code"), resultSet.getString("request_state"), resultSet.getString("tourist_name"), resultSet.getString("tourist_email"), resultSet.getString("tourist_gender"), resultSet.getString("tourist_job"), resultSet.getString("tourist_arrival_date"), resultSet.getString("tourist_departure_date"), resultSet.getString("tourist_self_introduction"), resultSet.getInt("tourist_companion_num"), resultSet.getString("tourist_reliability"));
				list.add(visitRequestersInfoDTO);
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
	 * 서비스 내에서 방문 신청한  모든 요청객들의 방문신청상태및 방문요청객의 정보를 검색한다
	 * @return 방문 신청한 모든 요청객들의 정보와 진행상태
	 */
	public List<VisitRequestersInfoDTO> selectAllTouristInfos()
	{
		List<VisitRequestersInfoDTO> list=new ArrayList<VisitRequestersInfoDTO>();
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection(); 
			pstmt=connection.prepareStatement(SELECTALL_VISITREQUESTERSINFO_SQL); 
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				VisitRequestersInfoDTO visitRequestersInfoDTO=new VisitRequestersInfoDTO(resultSet.getString("house_owner_code"), resultSet.getString("tourist_code"), resultSet.getString("request_state"), resultSet.getString("tourist_name"), resultSet.getString("tourist_email"), resultSet.getString("tourist_gender"), resultSet.getString("tourist_job"), resultSet.getString("tourist_arrival_date"), resultSet.getString("tourist_departure_date"), resultSet.getString("tourist_self_introduction"), resultSet.getInt("tourist_companion_num"), resultSet.getString("tourist_reliability"));
				list.add(visitRequestersInfoDTO);
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
