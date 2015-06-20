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
 *  �������� �湮 ��û���� �湮 ��û���¿� �湮�ſ�û���� ������ �����ϴ� Ŭ����
 * @author ȭ��
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
	 * �������� �����ĺ��ڵ带 �̿��� ���� ���ο��� �湮 ��û�� ��û������ �湮��û���¹� �湮��û���� ������ �˻��Ѵ�
	 * @param houseOwnerCode �������� �����ĺ��ڵ�
	 * @return �����ο��� �湮��û�� ��û������ ������ �������
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
	 * �������� �����ĺ��ڵ�� ������º��� �з��Ͽ� ���� ���ο��� �湮 ��û�� ��û������ �湮��û���¹� �湮��û���� ������ �˻��Ѵ�
	 * @param houseOwnerCode �������� �����ĺ��ڵ�
	 * @param requestState �з��Ͽ� ������� �湮��û �������
	 * @return �����ο��� �湮��û�� ��û������ ������ �������
	 */
	public List<VisitRequestersInfoDTO> selectTouristInfos(String houseOwnerCode, String requestState) //�������(����, ����, �ź�)�� ���� �������� ���� ����Ʈ Ȯ�� ���� 
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
	 * ���� ������ �湮 ��û��  ��� ��û������ �湮��û���¹� �湮��û���� ������ �˻��Ѵ�
	 * @return �湮 ��û�� ��� ��û������ ������ �������
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
