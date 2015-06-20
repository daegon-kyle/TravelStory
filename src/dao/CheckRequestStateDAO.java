//�ۼ���¥ : 2014/7/20
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
 *  ȸ���� ���ఴ���� ����Ͽ� ��п�û�� �������� ������ ������¸� �����ϴ� Ŭ����
 * @author ȭ��
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
	 * ȸ�� ������ ���ఴ���� ����Ͽ� ��û�Ͽ��� ��� �������� ������ ������¸� �˻��Ѵ� 
	 * @param memberCode ȸ�� ���� �ĺ��ڵ�
	 * @return �湮 ��û�Ͽ��� ��� �������� ������ ������µ�
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
	 * ȸ�� ������ ���ఴ���� ���(������ ����)�Ͽ� ��û�Ͽ��� ��� �������� ������ ������¸� �˻��Ѵ� 
	 * @param memberCode ȸ�� ���� �ĺ��ڵ�
	 * @param requestState �������
	 * @return ������º��� ȸ�� ������ �湮 ��û�Ͽ��� ��� �������� ������ ������µ�
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
	 * ȸ�� ������ ���ఴ���� ���(1��) ������ �湮��û�� �������� ������ ������¸� �˻��Ѵ�
	 * @param touristCode ���ఴ ���� �ĺ��ڵ�
	 * @return ���ఴ���� ����Ͽ� �湮��û�� ��� �������� ������ ������µ�
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
	 * ��� �湮��û�� �������� ������ ������¸� �˻��Ѵ�
	 * @return ��� �������� ������ ������µ�
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
