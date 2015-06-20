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
 * 집주인의 정보를 관리하는 클래스이다
 * @author 화섭
 *
 */
public class HouseOwnerDAO 
{
	private static final String INSERT_HOUSEOWNER_SQL="INSERT INTO house_owner_tb VALUES(house_owner_code.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String DELETEALL_HOUSEOWNER_SQL="DELETE FROM house_owner_tb";
	private static final String DELETE_HOUSEOWNER_SQL1="DELETE FROM house_owner_tb WHERE house_owner_code=?";
	private static final String DELETE_HOUSEOWNER_SQL2="DELETE FROM house_owner_tb WHERE member_code=?";
	private static final String SELECTALL_HOUSEOWNER_SQL="SELECT house_owner_code, member_code, job,TO_CHAR(visit_start_date, 'YYYY/MM/DD') visit_start_date, TO_CHAR(visit_end_date, 'YYYY/MM/DD') visit_end_date, self_introduction, married_state, address, etc FROM house_owner_tb";
	private static final String SELECT_HOUSEOWNER_SQL1="SELECT house_owner_code, member_code, job, TO_CHAR(visit_start_date, 'YYYY/MM/DD') visit_start_date, TO_CHAR(visit_end_date, 'YYYY/MM/DD') visit_end_date, self_introduction, married_state, address, etc FROM house_owner_tb WHERE house_owner_code=?";
	private static final String SELECT_HOUSEOWNER_SQL2="SELECT house_owner_code FROM house_owner_tb WHERE member_code=?";
	private static final String SELECT_HOUSEOWNER_SQL3="SELECT house_owner_code, member_code, job, TO_CHAR(visit_start_date, 'YYYY/MM/DD') visit_start_date, TO_CHAR(visit_end_date, 'YYYY/MM/DD') visit_end_date, self_introduction, married_state, address, etc FROM house_owner_tb WHERE member_code=?";
	private static final String SELECT_HOUSEOWNER_SQL4="SELECT house_owner_code, member_code, job, TO_CHAR(visit_start_date, 'YYYY/MM/DD') visit_start_date, TO_CHAR(visit_end_date, 'YYYY/MM/DD') visit_end_date, self_introduction, married_state, address, etc FROM house_owner_tb WHERE address like ? AND visit_start_date<=? AND ?<=visit_end_date";
	private static final String UPDATE_HOUSEOWNER_SQL="UPDATE house_owner_tb SET job=?, visit_start_date=?, visit_end_date=?, self_introduction=?, married_state=?, address=?, etc=?  WHERE house_owner_code=?";
	
	public HouseOwnerDAO()
	{
	}
	
	/**
	 * 집주인의 정보를 등록한다
	 * @param memberCode 회원 고유식별코드
	 * @param job  직업
	 * @param visitStartDate 방문가능시작일
	 * @param visitEndDate 방문가능만기일
	 * @param selfIntroduction 자기소개
	 * @param marriedState 결혼상태
	 * @param address 주소
	 * @param etc 본인의 집에 대한 간략한 소개
	 * @return 등록 성공여부를 리턴한다
	 */
	public boolean insert(String memberCode, String job, String visitStartDate, String visitEndDate, String selfIntroduction, String marriedState, String address, String etc)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(INSERT_HOUSEOWNER_SQL);
			pstmt.setString(1, memberCode); 
			pstmt.setString(2, job);
			pstmt.setString(3, visitStartDate);  
			pstmt.setString(4, visitEndDate);  
			pstmt.setString(5, selfIntroduction);  
			pstmt.setString(6, marriedState);  
			pstmt.setString(7, address);  
			pstmt.setString(8, etc);  
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
	 * 등록된 모든 집주인정보들을 삭제한다
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
			pstmt=connection.prepareStatement(DELETEALL_HOUSEOWNER_SQL);
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
	 * 집주인코드에 해당하는 집주인정보를 삭제한다
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
			pstmt=connection.prepareStatement(DELETE_HOUSEOWNER_SQL1);
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
	 * 회원코드에 해당하는 집주인의 정보를 삭제한다
	 * @param memberCode 회원 고유식별코드
	 * @return 삭제 성공여부를 리턴한다
	 */
	public boolean deleteMemberCode(String memberCode)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(DELETE_HOUSEOWNER_SQL2);
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
	 * 등록된 모든 집주인의 정보를 검색한다
	 * @return 등록된 모든 집주인의 정보를 리턴한다
	 */
	public List<HouseOwnerDTO> selectAll()
	{
		List<HouseOwnerDTO> list=new ArrayList<HouseOwnerDTO>();
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECTALL_HOUSEOWNER_SQL);
			
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				HouseOwnerDTO houseOwnerDTO=new HouseOwnerDTO(resultSet.getString("house_owner_code"), resultSet.getString("member_code"), resultSet.getString("job"), resultSet.getString("visit_start_date"), resultSet.getString("visit_end_date"), resultSet.getString("self_introduction"), resultSet.getString("married_state"), resultSet.getString("address"), resultSet.getString("etc"));
				list.add(houseOwnerDTO);
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
	 * 집주인 코드에 해당하는 집주인의 정보를 검색한다
	 * @param houseOwnerCode 집주인 고유식별코드
	 * @return 집주인코드에 해당하는 집주인의 정보를 리턴한다
	 */
	public HouseOwnerDTO selectHouseOwner(String houseOwnerCode) 
	{
		HouseOwnerDTO houseOwnerDTO=null;
	
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECT_HOUSEOWNER_SQL1);
			pstmt.setString(1, houseOwnerCode);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				houseOwnerDTO=new HouseOwnerDTO(resultSet.getString("house_owner_code"), resultSet.getString("member_code"), resultSet.getString("job"), resultSet.getString("visit_start_date"), resultSet.getString("visit_end_date"), resultSet.getString("self_introduction"), resultSet.getString("married_state"), resultSet.getString("address"), resultSet.getString("etc"));
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
		return houseOwnerDTO;
	}
	
	/**
	 * 회원코드에 해당하는 집주인의 코드를 검색한다
	 * @param memberCode 회원 고유식별코드
	 * @return 회원코드에 해당하는 집주인의 정보를 리턴한다
	 */
	public String selectHouseOwnerCode(String memberCode) //회원코드로 집주인코드를 찾아준다 
	{
		String houseOwnerCode=null;
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECT_HOUSEOWNER_SQL2);
			pstmt.setString(1, memberCode);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				houseOwnerCode=resultSet.getString("house_owner_code");
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
		return houseOwnerCode;
	}
	
	/**
	 * 회원코드에 해당하는 집주인의 정보를 검색한다
	 * @param memberCode 회원 고유식별코드
	 * @return 회원코드에 해당하는 집주인의 정보를 리턴한다
	 */
	public HouseOwnerDTO selectMemberCode(String memberCode) //회원코드로 집주인의 정보를 찾아준다 
	{
		HouseOwnerDTO houseOwnerDTO=null;
	
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECT_HOUSEOWNER_SQL3);
			pstmt.setString(1, memberCode);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				houseOwnerDTO=new HouseOwnerDTO(resultSet.getString("house_owner_code"), resultSet.getString("member_code"), resultSet.getString("job"), resultSet.getString("visit_start_date"), resultSet.getString("visit_end_date"), resultSet.getString("self_introduction"), resultSet.getString("married_state"), resultSet.getString("address"), resultSet.getString("etc"));
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
		return houseOwnerDTO;
	}


	/**
	 * 집주소와 방문 예상 시작일과 종료일이 일치하는 집주인의 정보를 검색한다 
	 * @param address 집주인의 주소
	 * @param visitStartDate 방문 예상 시작일
	 * @param visitEndDate 방문 에상 종료일
	 * @return 집주소와 방문 에상 시작일과 종료일에 일치하는 집주인의 정보를 리턴한다
	 */
	public HouseOwnerDTO selectHouseOwners(String address, String visitStartDate, String visitEndDate)  
	{
		HouseOwnerDTO houseOwnerDTO=null;
	
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECT_HOUSEOWNER_SQL4);
			pstmt.setString(1, "%"+address+"%");
			pstmt.setString(2, visitStartDate);
			pstmt.setString(3, visitEndDate);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				houseOwnerDTO=new HouseOwnerDTO(resultSet.getString("house_owner_code"), resultSet.getString("member_code"), resultSet.getString("job"), resultSet.getString("visit_start_date"), resultSet.getString("visit_end_date"), resultSet.getString("self_introduction"), resultSet.getString("married_state"), resultSet.getString("address"), resultSet.getString("etc"));
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
		return houseOwnerDTO;
	}

	
	/**
	 * 집주인코드에 해당하는 집주인정보의 직업, 방문가능시작일, 방문가능만기일, 자기소개, 결혼상태, 주소, 집소개를 수정한다
	 * @param houseOwnerCode 집주인 고유식별코드
	 * @param job 직업
	 * @param visitStartDate 방문가능시작일
	 * @param visitEndDate 방문가능만기일
	 * @param selfIntroduction 자기소개
	 * @param marriedState 결혼상태
	 * @param address 주소
	 * @param etc 집소개
	 * @return 수정 성공여부를 리턴한다
	 */
	public boolean update(String houseOwnerCode, String job, String visitStartDate, String visitEndDate, String selfIntroduction, String marriedState, String address, String etc)  
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(UPDATE_HOUSEOWNER_SQL); 
			pstmt.setString(1, job);
			pstmt.setString(2, visitStartDate);  
			pstmt.setString(3, visitEndDate);  
			pstmt.setString(4, selfIntroduction);  
			pstmt.setString(5, marriedState);  
			pstmt.setString(6, address);  
			pstmt.setString(7, etc);  
			pstmt.setString(8, houseOwnerCode); 
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
