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
 * 회원 정보를 관리하는 클래스이다
 * @author 화섭
 *
 */
public class MemberDAO 
{
	private static final String INSERT_MEMBER_SQL="INSERT INTO member_tb(member_code, member_level_code, name, email, password, birthdate, phone, gender) VALUES(member_code.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
	private static final String INSERT_MEMBER_SQL2="INSERT INTO member_tb VALUES(member_code.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String DELETEALL_MEMBER_SQL="DELETE FROM member_tb";
	private static final String DELETE_MEMBER_SQL1="DELETE FROM member_tb WHERE member_code=?";
	private static final String DELETE_MEMBER_SQL2="DELETE FROM member_tb WHERE email=? AND password=?";
	private static final String SELECTALL_MEMBER_SQL="SELECT member_code, member_level_code, name, email, password, TO_CHAR(birthdate, 'YYYY/MM/DD') birthdate, phone, gender, reliability FROM member_tb";
	private static final String SELECTCODE_MEMBER_SQL="SELECT member_code FROM member_tb WHERE email=? AND password=?";
	private static final String SELECTEMAIL_MEMBER_SQL="SELECT email FROM member_tb WHERE name=? AND phone=?";
	private static final String SELECTPASSWORD_MEMBER_SQL="SELECT password	FROM member_tb WHERE email=? AND name=?";
	private static final String SELECTPASSWORD_MEMBER_SQL1="SELECT password FROM member_tb WHERE email=?";
	private static final String SELECT_MEMBER_SQL="SELECT member_code, member_level_code, name, email, password, TO_CHAR(birthdate, 'YYYY/MM/DD') birthdate, phone, gender, reliability FROM member_tb WHERE member_code=?";
	private static final String UPDATE_MEMBER_SQL1="UPDATE member_tb SET name=?, email=?, password=?, birthdate=?, phone=?, gender=? WHERE member_code=?";
	private static final String UPDATE_MEMBER_SQL2="UPDATE member_tb SET reliability=?	WHERE member_code=?";
	private static final String UPDATE_MEMBER_SQL3="UPDATE member_tb SET email=? WHERE member_code=?"; 
	
	
	public MemberDAO()
	{
	}
	
	/**
	 * 회원정보를 등록한다
	 * @param levelCode 회원등급 코드
	 * @param name 회원 이름
	 * @param email 회원 이메일
	 * @param password 회원 비밀번호
	 * @param birthdate 회원 생일
	 * @param phone 회원의 전화번호
	 * @param gender 회원의 성
	 * @return 등록 성공여부를 리터한다
	 */
	public boolean insert(String levelCode, String name, String email, String password, String birthdate, String phone, String gender)
	{
		
		System.out.println("제대로 insert 들어오는것까지 성공");
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(INSERT_MEMBER_SQL);
			pstmt.setString(1, levelCode);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			pstmt.setString(4, password);
			pstmt.setString(5, birthdate);
			pstmt.setString(6, phone);
			pstmt.setString(7, gender);
			result=pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
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
	 * 	 회원정보를 등록한다
	 * @param levelCode 회원등급 코드
	 * @param name 회원 이름
	 * @param email 회원 이메일
	 * @param password 회원 비밀번호
	 * @param birthdate 회원 생일
	 * @param phone 회원의 전화번호
	 * @param gender 회원의 성
	 * @param reliability 회원의 신뢰도
	 * @return 회원등록 성공여부를 리턴한다
	 */
	public boolean insert(String levelCode, String name, String email, String password, String birthdate, String phone, String gender, int reliability)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(INSERT_MEMBER_SQL2); 
			pstmt.setString(1, levelCode);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			pstmt.setString(4, password);
			pstmt.setString(5, birthdate);
			pstmt.setString(6, phone);
			pstmt.setString(7, gender);
			pstmt.setInt(8, reliability);
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
	 * 등록된 회원정보를 모두 삭제한다
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
			pstmt=connection.prepareStatement(DELETEALL_MEMBER_SQL);
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
	 * 회원 고유식별코드에 해당하는 회원의 정보를 삭제한다
	 * @param memberCode 회원 고유식별코드
	 * @return 삭제 성공여부를 리턴한다
	 */
	public boolean deleteMember(String memberCode)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(DELETE_MEMBER_SQL1);
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
	 * 이메일과 비밀번호가 일치시 회원정보 삭제(회원탈퇴)한다
	 * @param email 회원의 이메일
	 * @param password 회원의 비밀번호
	 * @return 삭제 성공여부를 리턴한다
	 */
	public boolean deleteMember(String email, String password)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(DELETE_MEMBER_SQL2);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
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
	 * 등록된 모든 회원정보를 검색한다
	 * @return 등록된 모든 회원정보를 리턴한다
	 */
	public List<MemberDTO> selectAll()
	{
		List<MemberDTO> list=new ArrayList<MemberDTO>();
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECTALL_MEMBER_SQL);
			
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				MemberDTO memberDTO=new MemberDTO(resultSet.getString("member_code"), resultSet.getString("member_level_code"), resultSet.getString("name"), resultSet.getString("email"), resultSet.getString("password"), resultSet.getString("birthdate"), resultSet.getString("phone"), resultSet.getString("gender"), resultSet.getInt("reliability"));
				list.add(memberDTO);
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
	 * 이메일과 비밀번호 일치시 고유식별코드인 회원코드를 검색한다
	 * @param email 회원 이메일
	 * @param password 회원 비밀번호
	 * @return 이메일과 비밀번호에 일치하는 회원코드를 리턴한다
	 */
	public String selectCode(String email, String password) //e메일과 비번으로 회원코드찾는다
	{
		String memberCode=null;
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECTCODE_MEMBER_SQL);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
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
	 * 이름과 전화번호에 일치하는 회원의 이메일을 검색한다
	 * @param name 회원의 이름
	 * @param phone 회원의 전화번호
	 * @return 이름과 전화번호에 일치하는 회원의 이메일을 리턴한다
	 */
	public String selectEmail(String name, String phone) //회원이 이메일을 잊어버린경우 이름과 전화번호로 이메일을 찾는다
	{
		String email=null;
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECTEMAIL_MEMBER_SQL);
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				email=resultSet.getString("email");
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
		return email;
	}
	
	/**
	 * 회원의 이메일과 이름에 일치하는 비밀번호를 검색한다
	 * @param email 회원의 이메일
	 * @param name 회원의 이름
	 * @return 회원의 이메일과 이름에 일치하는 비밀번호를 검색한다
	 */
	public String selectPassword(String email, String name) //회원이 비밀번호를  잊어버린경우 이메일과 비밀번호로 비밀번호를 찾는다
	{
		String password=null;
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECTPASSWORD_MEMBER_SQL);
			pstmt.setString(1, email);
			pstmt.setString(2, name);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				password=resultSet.getString("password");
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
		return password;
	}
	
	/**
	 * 회원의 이메일에 일치하는 비밀번호를 검색한다
	 * @param email 회원의 이메일
	 * @return 회원의 이메일에 일치하는 비밀번호를 리턴한다
	 */
	public String selectPassword(String email)
	{
		String password=null;
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECTPASSWORD_MEMBER_SQL1);
			pstmt.setString(1, email);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				password=resultSet.getString("password");
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
		return password;
	}

	/**
	 * 회원코드에 해당하는 회원의 정보를 검색한다
	 * @param memberCode 회원 고유식별코드
	 * @return 회원코드에 해당하는 회원의 정보를 리턴한다
	 */
	public MemberDTO select(String memberCode) //회원코드에 해당되는 회원정보 찾는다
	{
		MemberDTO memberDTO=null;
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(SELECT_MEMBER_SQL);
			pstmt.setString(1, memberCode);
			resultSet=pstmt.executeQuery();
			
			while(resultSet.next())
			{
				memberDTO=new MemberDTO(resultSet.getString("member_code"), resultSet.getString("member_level_code"), resultSet.getString("name"), resultSet.getString("email"), resultSet.getString("password"), resultSet.getString("birthdate"), resultSet.getString("phone"), resultSet.getString("gender"), resultSet.getInt("reliability")); 
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
		return memberDTO;
	}
	
	/**
	 * 회원코드에 해당하는 회원정보의 이름, 이메일, 비밀번호, 생일, 전화번호, 성별을 수정한다
	 * @param memberCode 회원코드
	 * @param name 회원의 이름
	 * @param email 회원의 이메일
	 * @param password 회원의 비밀번호
	 * @param birthdate 회원의 생일
	 * @param phone 회원의 전화번호
	 * @param gender 회원의 성별
	 * @return 수정 성공여부를 리턴한다
	 */
	public boolean update(String memberCode, String name, String email, String password, String birthdate, String phone, String gender) //회원의 정보를 수정한다.
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(UPDATE_MEMBER_SQL1);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, password);
			pstmt.setString(4, birthdate);
			pstmt.setString(5, phone);
			pstmt.setString(6, gender);
			pstmt.setString(7, memberCode);
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
	 * 회원코드에 해당하는 회원의 신용도를 수정한다
	 * @param memberCode 회원코드
	 * @param reliability 회원의 신용도
	 * @return 수정 성공여부를 리턴한다
	 */
	public boolean update(String memberCode, int reliability) //회원의 신용도를 올린다.
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(UPDATE_MEMBER_SQL2);
			pstmt.setInt(1, reliability);
			pstmt.setString(2, memberCode);
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
	 * 회원코드에 해당하는 회원의 이메일을 수정한다
	 * @param memberCode 회원코드
	 * @param email 회원의 이메일
	 * @return 수정 성공여부를 리턴한다
	 */
	public boolean update(String memberCode, String email) //회원의 이메일을 수정한다(관리자입장에서 요청시 필요할 가능성).
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			connection=DBConnectionPool.getInstance().getConnection();
			pstmt=connection.prepareStatement(UPDATE_MEMBER_SQL3);
			pstmt.setString(1, email);
			pstmt.setString(2, memberCode);
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
