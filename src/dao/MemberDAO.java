//�ۼ���¥ : 2014/7/19
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
 * ȸ�� ������ �����ϴ� Ŭ�����̴�
 * @author ȭ��
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
	 * ȸ�������� ����Ѵ�
	 * @param levelCode ȸ����� �ڵ�
	 * @param name ȸ�� �̸�
	 * @param email ȸ�� �̸���
	 * @param password ȸ�� ��й�ȣ
	 * @param birthdate ȸ�� ����
	 * @param phone ȸ���� ��ȭ��ȣ
	 * @param gender ȸ���� ��
	 * @return ��� �������θ� �����Ѵ�
	 */
	public boolean insert(String levelCode, String name, String email, String password, String birthdate, String phone, String gender)
	{
		
		System.out.println("����� insert �����°ͱ��� ����");
		
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
	 * 	 ȸ�������� ����Ѵ�
	 * @param levelCode ȸ����� �ڵ�
	 * @param name ȸ�� �̸�
	 * @param email ȸ�� �̸���
	 * @param password ȸ�� ��й�ȣ
	 * @param birthdate ȸ�� ����
	 * @param phone ȸ���� ��ȭ��ȣ
	 * @param gender ȸ���� ��
	 * @param reliability ȸ���� �ŷڵ�
	 * @return ȸ����� �������θ� �����Ѵ�
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
	 * ��ϵ� ȸ�������� ��� �����Ѵ�
	 * @return ���� �������θ� �����Ѵ�
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
	 * ȸ�� �����ĺ��ڵ忡 �ش��ϴ� ȸ���� ������ �����Ѵ�
	 * @param memberCode ȸ�� �����ĺ��ڵ�
	 * @return ���� �������θ� �����Ѵ�
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
	 * �̸��ϰ� ��й�ȣ�� ��ġ�� ȸ������ ����(ȸ��Ż��)�Ѵ�
	 * @param email ȸ���� �̸���
	 * @param password ȸ���� ��й�ȣ
	 * @return ���� �������θ� �����Ѵ�
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
	 * ��ϵ� ��� ȸ�������� �˻��Ѵ�
	 * @return ��ϵ� ��� ȸ�������� �����Ѵ�
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
	 * �̸��ϰ� ��й�ȣ ��ġ�� �����ĺ��ڵ��� ȸ���ڵ带 �˻��Ѵ�
	 * @param email ȸ�� �̸���
	 * @param password ȸ�� ��й�ȣ
	 * @return �̸��ϰ� ��й�ȣ�� ��ġ�ϴ� ȸ���ڵ带 �����Ѵ�
	 */
	public String selectCode(String email, String password) //e���ϰ� ������� ȸ���ڵ�ã�´�
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
	 * �̸��� ��ȭ��ȣ�� ��ġ�ϴ� ȸ���� �̸����� �˻��Ѵ�
	 * @param name ȸ���� �̸�
	 * @param phone ȸ���� ��ȭ��ȣ
	 * @return �̸��� ��ȭ��ȣ�� ��ġ�ϴ� ȸ���� �̸����� �����Ѵ�
	 */
	public String selectEmail(String name, String phone) //ȸ���� �̸����� �ؾ������� �̸��� ��ȭ��ȣ�� �̸����� ã�´�
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
	 * ȸ���� �̸��ϰ� �̸��� ��ġ�ϴ� ��й�ȣ�� �˻��Ѵ�
	 * @param email ȸ���� �̸���
	 * @param name ȸ���� �̸�
	 * @return ȸ���� �̸��ϰ� �̸��� ��ġ�ϴ� ��й�ȣ�� �˻��Ѵ�
	 */
	public String selectPassword(String email, String name) //ȸ���� ��й�ȣ��  �ؾ������� �̸��ϰ� ��й�ȣ�� ��й�ȣ�� ã�´�
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
	 * ȸ���� �̸��Ͽ� ��ġ�ϴ� ��й�ȣ�� �˻��Ѵ�
	 * @param email ȸ���� �̸���
	 * @return ȸ���� �̸��Ͽ� ��ġ�ϴ� ��й�ȣ�� �����Ѵ�
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
	 * ȸ���ڵ忡 �ش��ϴ� ȸ���� ������ �˻��Ѵ�
	 * @param memberCode ȸ�� �����ĺ��ڵ�
	 * @return ȸ���ڵ忡 �ش��ϴ� ȸ���� ������ �����Ѵ�
	 */
	public MemberDTO select(String memberCode) //ȸ���ڵ忡 �ش�Ǵ� ȸ������ ã�´�
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
	 * ȸ���ڵ忡 �ش��ϴ� ȸ�������� �̸�, �̸���, ��й�ȣ, ����, ��ȭ��ȣ, ������ �����Ѵ�
	 * @param memberCode ȸ���ڵ�
	 * @param name ȸ���� �̸�
	 * @param email ȸ���� �̸���
	 * @param password ȸ���� ��й�ȣ
	 * @param birthdate ȸ���� ����
	 * @param phone ȸ���� ��ȭ��ȣ
	 * @param gender ȸ���� ����
	 * @return ���� �������θ� �����Ѵ�
	 */
	public boolean update(String memberCode, String name, String email, String password, String birthdate, String phone, String gender) //ȸ���� ������ �����Ѵ�.
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
	 * ȸ���ڵ忡 �ش��ϴ� ȸ���� �ſ뵵�� �����Ѵ�
	 * @param memberCode ȸ���ڵ�
	 * @param reliability ȸ���� �ſ뵵
	 * @return ���� �������θ� �����Ѵ�
	 */
	public boolean update(String memberCode, int reliability) //ȸ���� �ſ뵵�� �ø���.
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
	 * ȸ���ڵ忡 �ش��ϴ� ȸ���� �̸����� �����Ѵ�
	 * @param memberCode ȸ���ڵ�
	 * @param email ȸ���� �̸���
	 * @return ���� �������θ� �����Ѵ�
	 */
	public boolean update(String memberCode, String email) //ȸ���� �̸����� �����Ѵ�(���������忡�� ��û�� �ʿ��� ���ɼ�).
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
