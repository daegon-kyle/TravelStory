// 0719 ������
package dao;
import java.util.*;
import java.sql.*;

import dto.PostingPurposeDTO;
/**
 * ������ ������ ���� ������ �����ϱ� ���� ����Ѵ�. <br/>ȣ���ϴ� �Ŵ��� ����
 * @author ������
 *
 */
public class PostingPurposeDAO {
	/**
	 * ���ο� ������ ������ ���� ������ �����ϱ� ���� ���Ǵ� ������
	 */
	private final static String INSERT_POSTING_PURPOSE_SQL="INSERT INTO posting_purpose_tb VALUES(posting_purpose_code.nextVal, ?)";
	/**
	 * ����� ������ ������ ���� ��� ������ �����ϱ� ���� ���Ǵ� ������
	 */
	private final static String DELETE_ALL_SQL="delete from posting_purpose_tb";
	/**
	 * ����� ������ ������ ���� ���� �� Ư�� ������ �����ϱ� ���� ���Ǵ� ������
	 */
	private final static String DELETE_POSTING_PURPOSE_SQL="DELETE FROM posting_purpose_tb WHERE posting_purpose_code=?";
	/**
	 * ����� ������ ������ ���� ��� ������ �������� ���� ���Ǵ� ������
	 */
	private final static String SELECT_ALL_SQL="select * from posting_purpose_tb";
	/**
	 * ����� ������ ������ ���� ���� �� Ư�� ������ ������ ���� ������ �������� ���� ���Ǵ� ������
	 */
	private final static String SELECT_POSTING_PURPOSE_SQL="select * from posting_purpose_tb where posting_purpose_code=?";
	/**
	 * ����� ������ ������ ���� ���� �� Ư�� ������ ������ ���� ������ �����ϱ� ���� ���Ǵ� ������
	 */
	private final static String UPDATE_POSTING_PURPOSE_SQL="UPDATE posting_purpose_tb SET posting_purpose_name=? WHERE posting_purpose_code=?";
	/**
	 * default constructor
	 */
	public PostingPurposeDAO(){
		
	}
	/**
	 * ���ο� ������ ���� ������ �����Ѵ�
	 * @param postingPurposeName ������ ���� ��
	 * @return true - ���忡 �������� ��� <br/> false - ���忡 �������� ���
	 */
	public boolean insert(String postingPurposeName){
		Connection conn = null;
		PreparedStatement pre = null;
		int rowNum = 0;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(INSERT_POSTING_PURPOSE_SQL);
			pre.setString(1, postingPurposeName);
			rowNum = pre.executeUpdate();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally{
			try{
				conn.close();
				pre.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		if(rowNum ==1)
			return true;
		return false;
	}
	/**
	 * ����� ��� ������ ������ ���� ������ �����Ѵ�.
	 * @return true - ������ �������� ��� <br/> false - ������ ���� ���� ���
	 */
	public boolean deleteAll(){
		Connection conn = null;
		PreparedStatement pre = null;
		int rowNum = 0;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(DELETE_ALL_SQL);
			rowNum = pre.executeUpdate();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally{
			try{
				conn.close();
				pre.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		if(rowNum>0)
			return true;
		return false;
	}
	/**
	 * ����� ������ ���� ���� �� Ư�� ������ ���� ������ �����Ѵ�.
	 * @param postingPurposeCode ������ ���� �ڵ�
	 * @return true - ������ �������� ��� <br/> false - ������ �������� ���
	 */
	public boolean delete(String postingPurposeCode){
		Connection conn = null;
		PreparedStatement pre = null;
		int rowNum = 0;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(DELETE_POSTING_PURPOSE_SQL);
			pre.setString(1, postingPurposeCode);
			rowNum = pre.executeUpdate();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally{
			try{
				conn.close();
				pre.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		if(rowNum==1)
			return true;
		return false;
	}
	/**
	 * ����� ��� ������ ���� ������ �����´�.
	 * @return ��� ������ ���� ������
	 */
	public List<PostingPurposeDTO> selectAll(){
		List<PostingPurposeDTO> list = new ArrayList<PostingPurposeDTO>();
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_ALL_SQL);
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("posting_purpose_code");
				String name = re.getString("posting_purpose_name");
				list.add(new PostingPurposeDTO(code, name));
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally{
			try{
				conn.close();
				pre.close();
				re.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		return list;
	}
	/**
	 * ����� ������ ���� ���� �� Ư�� ������ ���� ������ �����´�.
	 * @param postingPurposeCode ������ ���� �ڵ�
	 * @return Ư�� ������ ���� ����
	 */
	public PostingPurposeDTO select(String postingPurposeCode){
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		PostingPurposeDTO dto = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_POSTING_PURPOSE_SQL);
			pre.setString(1,  postingPurposeCode);
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("posting_purpose_code");
				String name = re.getString("posting_purpose_name");
				dto = new PostingPurposeDTO(code, name);
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally{
			try{
				conn.close();
				pre.close();
				re.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		return dto;
	}
	/**
	 * ����� ������ ���� ���� �� Ư�� ������ ���� ������ �����Ѵ�.
	 * @param postingPurposeCode ������ ���� �ڵ�
	 * @param postingPurposeName ������ ���� ��
	 * @return true - ������ �������� ��� <br/> false - ������ ���� ���� ���
	 */
	public boolean update(String postingPurposeCode, String postingPurposeName){
		Connection conn = null;
		PreparedStatement pre =null;
		int rowNum = 0;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(UPDATE_POSTING_PURPOSE_SQL);
			pre.setString(1, postingPurposeName);
			pre.setString(2, postingPurposeCode);
			rowNum = pre.executeUpdate();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally{
			try{
				conn.close();
				pre.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		if(rowNum==1)
			return true;
		return false;
	}
}
