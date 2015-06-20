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
 * 여행객 정보를 관리하는 클래스이다
 * @author 화섭
 *
 */
public class TouristDAO 
{
	private static final String INSERT_TOURIST_SQL="INSERT INTO tourist_tb VALUES(tourist_code.NEXTVAL, ?, ?, ?, ?, ?, ?)";
	private static final String DELETEALL_TOURIST_SQL="DELETE FROM tourist_tb";
	private static final String DELETE_TOURIST_SQL1="DELETE FROM tourist_tb WHERE tourist_code=?";
	private static final String DELETE_TOURIST_SQL2="DELETE FROM tourist_tb WHERE member_code=?";
	private static final String SELECTALL_TOURIST_SQL="SELECT tourist_code, member_code, job, companion_num, TO_CHAR(arrival_date, 'YYYY/MM/DD') arrival_date, TO_CHAR(departure_date, 'YYYY/MM/DD') departure_date, self_introduction FROM tourist_tb";
	private static final String SELECT_TOURIST_SQL1="SELECT member_code FROM tourist_tb WHERE tourist_code=?";
	private static final String SELECT_TOURIST_SQL2="SELECT tourist_code FROM tourist_tb WHERE member_code=?";
	private static final String SELECT_TOURIST_SQL3="SELECT tourist_code, member_code, job, companion_num, TO_CHAR(arrival_date, 'YYYY/MM/DD') arrival_date, TO_CHAR(departure_date, 'YYYY/MM/DD') departure_date, self_introduction FROM tourist_tb WHERE tourist_code=?";
	private static final String UPDATE_TOURIST_SQL="UPDATE tourist_tb SET job=?, companion_num=?, arrival_date=?, departure_date=?, self_introduction=? WHERE tourist_code=?";
	private static final String GET_TOURIST_SQL="SELECT max(tourist_code) maxcode FROM tourist_tb";
 
	   
	public TouristDAO()
	{
	}
	
	/**
	 * 여행객의 정보를 등록하는 클래스이다
	 * @param memberCode 회원 고유식별코드
	 * @param job 직업
	 * @param companionNum 동행자수
	 * @param arrivalDate 방문일
	 * @param departureDate 방문종료일
	 * @param selfIntroduction 자기소개
	 * @return 등록 성공여부를 리턴한다
	 */
	public boolean insert(String memberCode, String job, int companionNum, String arrivalDate, String departureDate, String selfIntroduction)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(INSERT_TOURIST_SQL);
			pstmt.setString(1, memberCode); 
			pstmt.setString(2, job); 
			pstmt.setInt(3, companionNum);  
			pstmt.setString(4, arrivalDate);  
			pstmt.setString(5, departureDate);  
			pstmt.setString(6, selfIntroduction);  
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
	 * 등록된 모든 여행객의 정보를 삭제한다
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
			pstmt=connection.prepareStatement(DELETEALL_TOURIST_SQL);
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
	 * 여행객코드에 해당하는 여행객의정보를 삭제한다
	 * @param touristCode 여행객의 고유식별코드
	 * @return 삭제 성공여부를 검색한다
	 */
	public boolean deleteTouristCode(String touristCode)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(DELETE_TOURIST_SQL1);
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
	 * 회원코드에 해당하는 여행객의정보를 삭제한다
	 * @param memberCode 회원고유식별코드
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
			pstmt=connection.prepareStatement(DELETE_TOURIST_SQL2);
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
	 * 등록된 모든 여행객들의 정보를 검색한다
	 * @return 등록된 모든 여행객들의 정보를 리턴한다
	 */
	public List<TouristDTO> selectAll()
	{
		List<TouristDTO> list=new ArrayList<TouristDTO>();
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECTALL_TOURIST_SQL);
			
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				TouristDTO touristDTO=new TouristDTO(resultSet.getString("tourist_code"), resultSet.getString("member_code"), resultSet.getString("job"), resultSet.getInt("companion_num"), resultSet.getString("arrival_date"), resultSet.getString("departure_date"), resultSet.getString("self_introduction"));
				list.add(touristDTO);
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
	 * 여행객코드에 해당하는 회원의 코드를 검색한다
	 * @param touristCode 여행객 고유식별코드
	 * @return 여행객코드에 해당하는 회원의 코드를 리턴한다
	 */
	public String selectMemberCode(String touristCode) //여행객코드로 회원코드를 찾는다
	{
		String memberCode=null;
	
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECT_TOURIST_SQL1);
			pstmt.setString(1, touristCode);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				memberCode=resultSet.getString("member_code"); 
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
		return memberCode;
	}
	
	/**
	 * 회원코드에 해당하는 여행객 코드(회원이 여행객정보를 입력하여 등록할떄마다 생성됨, 한회원이 여러개의 여행객코드 보유 가능)들을 검색한다
	 * @param memberCode 회원 고유식별코드
	 * @return 회원코드에 해당하는 여행객코드들을 리턴한다
	 */
	public List<String> selectTouristCode(String memberCode) //회원코드로 여행객코드들을 찾아온다(한 회원이 여러번 줍주인에게 신청한 경우)
	{
		List<String> list=new ArrayList<String>();
	
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECT_TOURIST_SQL2);
			pstmt.setString(1, memberCode);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				String touristCode=resultSet.getString("tourist_code");
				list.add(touristCode);
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
	 * 여행객코드에 해당하는 여행객의 정보를 검색한다
	 * @param touristCode 여행객 고유식별코드
	 * @return 여행객코드에 해당하는 여행객의 정보를 리턴한다
	 */
	public TouristDTO select(String touristCode)
	{
		TouristDTO touristDTO=null;
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECT_TOURIST_SQL3);
			pstmt.setString(1, touristCode);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				touristDTO=new TouristDTO(resultSet.getString("tourist_code"), resultSet.getString("member_code"), resultSet.getString("job"), resultSet.getInt("companion_num"), resultSet.getString("arrival_date"), resultSet.getString("departure_date"), resultSet.getString("self_introduction"));
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
		return touristDTO;
	}
	
	/**
	 * 여행객코드에 해당해는 여행객 정보의 직업, 동행자수, 방문일, 방문종료일, 자기소개를 수정한다
	 * @param touristCode 여행객 고유식별코드
	 * @param job 여행객 직업
	 * @param companionNum 여행객 동행자수
	 * @param arrivalDate 여행객 방문일
	 * @param departureDate 여행객 방문만기일
	 * @param selfIntroduction 여행객 자기소개
	 * @return 수정성공여부를 리턴한다
	 */
	public boolean update(String touristCode, String job, int companionNum, String arrivalDate, String departureDate, String selfIntroduction)  
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(UPDATE_TOURIST_SQL);
			pstmt.setString(1, job);
			pstmt.setInt(2, companionNum); 
			pstmt.setString(3, arrivalDate);
			pstmt.setString(4, departureDate); 
			pstmt.setString(5, selfIntroduction);
			pstmt.setString(6, touristCode); 
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
	
	public String getTouristMaxCode()
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		String maxCode=null;
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(GET_TOURIST_SQL);
			 
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				maxCode=resultSet.getString("maxcode");
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
		return maxCode;
	}
	 
}
