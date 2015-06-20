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
 * 회원의 등급을 관리하는 클래스이다
 * @author 화섭
 *
 */
public class MemberLevelDAO 
{
	private static final String INSERT_MEMBER_LEVEL_SQL="INSERT INTO member_level_tb VALUES(member_level_code.NEXTVAL, ?)";
	private static final String DELETEALL_MEMBER_LEVEL_SQL="DELETE FROM member_level_tb";
	private static final String DELETE_MEMBER_LEVEL_SQL="DELETE FROM member_level_tb WHERE member_level_code=?";
	private static final String SELECTALL_MEMBER_LEVEL_SQL="SELECT member_level_code, member_level_name FROM member_level_tb";
	private static final String SELECT_MEMBER_LEVEL_SQL="SELECT member_level_name FROM member_level_tb WHERE member_level_code=?";
	private static final String UPDATE_MEMBER_LEVEL_SQL="UPDATE member_level_tb SET member_level_name=? WHERE member_level_code=?";
	
	public MemberLevelDAO()
	{
	}

	/**
	 * 회원 등급을 등록한다
	 * @param levelName 등급명
	 * @return 등록 성공여부를 리턴한다
	 */
	public boolean insert(String levelName)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(INSERT_MEMBER_LEVEL_SQL);
			pstmt.setString(1, levelName); 
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
	 * 등록되있는 회원등급들을 모두 삭제한다
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
			pstmt=connection.prepareStatement(DELETEALL_MEMBER_LEVEL_SQL);
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
	 * 화원 등급 고유식별코드에 해당하는 회원등급정보를 삭제한다
	 * @param levelCode 회원 등급 고유식별코드
	 * @return 삭제 성공여부를 리턴한다
	 */
	public boolean delete(String levelCode)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(DELETE_MEMBER_LEVEL_SQL);
			pstmt.setString(1,  levelCode);
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
	 * 등록된  모든 회원등급 정보를 검색한다
	 * @return 등록된 모든 회원등급 정보를 리턴한다
	 */
	public List<MemberLevelDTO> selectAll()
	{
		List<MemberLevelDTO> list=new ArrayList<MemberLevelDTO>();
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECTALL_MEMBER_LEVEL_SQL);
			
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				MemberLevelDTO memberLevelDTO=new MemberLevelDTO(resultSet.getString("member_level_code"), resultSet.getString("member_level_name"));
				list.add(memberLevelDTO);
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
	 * 회원등급 고유식별코드에 해당되는 회원등급정보를 검색한다
	 * @param levelCode 회원등급 고유식별코드
	 * @return 회원등급에 해당하는 등급명을 리턴한다
	 */
	public String selectLevelName(String levelCode) //level 코드에 해당하는 이름 리턴
	{
		String name=null;
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECT_MEMBER_LEVEL_SQL);
			pstmt.setString(1, levelCode);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				name=resultSet.getString("member_level_name");
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
		return name;
	}
	
	/**
	 * 회원등급에 해당하는 회원등급정보의 등급명을 수정한다
	 * @param levelCode 회원등급 고유식별코드
	 * @param levelName 회원등급명
	 * @return 수정 성공여부를 리턴한다
	 */
	public boolean updateLevelName(String levelCode, String levelName)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(UPDATE_MEMBER_LEVEL_SQL);
			pstmt.setString(1, levelName);
			pstmt.setString(2, levelCode);
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
