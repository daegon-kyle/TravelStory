// 0720 ������
package dao;
import java.sql.*;
import java.util.*;

import dto.CompanionRecommendDTO;
/**
 * ������ ã�� �������� �ʼ� ������ �����ϱ� ���� ���Ǵ�. <br/> PostingDataDAOManager���� ����Ѵ�
 * @author ������
 *
 */
public class CompanionRecommendDAO {
	/**
	 * ������ ã�� �������� �ʼ� ������ �����ϱ� ���� ���Ǵ� ������
	 */
	private final static String INDERT_COMPANION_RECOMMEND_SQL="INSERT INTO companion_recommend_tb VALUES(companion_recommend_code.nextVal, ?,?,?, ?, ?,?,?)";
	/**
	 * ����� ������ ã�� �������� �ʼ� ������ ��� �����ϱ� ���� ���Ǵ� ������
	 */
	private final static String DELETE_ALL_SQL="delete from companion_recommend_tb";
	/**
	 * ����� ������ ã�� �������� �ʼ� ���� �� Ư�� �������� �����ϱ� ���� ���Ǵ� ������
	 */
	private final static String DELETE_BY_POSTING_CODE_SQL="delete from companion_recommend_tb where posting_code=?";
	/**
	 * ����� ������ ã�� �������� �ʼ� ������ ��� �������� ���� ���Ǵ� ������
	 */
	private final static String SELECT_ALL_SQL="select companion_recommend_code, posting_code, destination1, destination2, TO_CHAR(start_date, 'YYYY/MM/DD') start_date, TO_CHAR(end_date, 'YYYY/MM/DD') end_date, other_age, other_gender from companion_recommend_tb";
	/**
	 * ����� ������ ã�� ������ �� Ư�� �������� �ʼ� ������ �������� ���� ���Ǵ� ������
	 */
	private final static String SELECT_BY_POSTING_CODE_SQL="select companion_recommend_code, posting_code, destination1, destination2, TO_CHAR(start_date, 'YYYY/MM/DD') start_date, TO_CHAR(end_date, 'YYYY/MM/DD') end_date, other_age, other_gender from companion_recommend_tb where posting_code=?";
	/**
	 * ����� ������ ã�� ������ �� ���ǿ� �����ϴ� �������� �ʼ� ������ �������� ���� ���Ǵ� ������
	 */
	private final static String SELECT_BY_CONDITIONS_SQL="select companion_recommend_code, posting_code, destination1, destination2, TO_CHAR(start_date, 'YYYY/MM/DD') start_date, TO_CHAR(end_date, 'YYYY/MM/DD') end_date, other_age, other_gender from companion_recommend_tb where destination1=? and destination2=? and start_date=? and end_date=? and other_age=? and other_gender=?";
	/**
	 * ����� ������ ã�� ������ �� Ư�� �������� �ʼ� ������ �����ϱ� ���� ���Ǵ� ������
	 */
	private final static String UPDATE_COMPANION_RECOMMEND_SQL="UPDATE companion_recommend_tb SET  destination1=?, destination2=?, start_date=?, end_date=?,other_age=?, other_gender=? WHERE posting_code=?";
	/**
	 * default constructor
	 */
	public CompanionRecommendDAO(){
		
	}
	/**
	 * ������ ã�� �������� �ʼ� ������ �����ϱ� ���� ����Ѵ�. <br/>PostingDataDAOManager���� ȣ��ȴ�
	 * @param postingCode ������ �ڵ�
	 * @param destination1 �������(��/��)
	 * @param destination2 �������(��)
	 * @param startDate ���������
	 * @param endDate ����������
	 * @param otherAge ���ϴ� ����� ���̴�
	 * @param otherGender ���ϴ� ����� ����
	 * @return true - ���� ���� <br/> false - ���� ����
	 */
	public boolean insert(String postingCode, String destination1, String destination2, String startDate, String endDate, int otherAge, String otherGender){
		Connection conn = null;
		PreparedStatement pre = null;
		int rowNum = 0;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(INDERT_COMPANION_RECOMMEND_SQL);
			pre.setString(1, postingCode);
			pre.setString(2, destination1);
			pre.setString(3, destination2);
			pre.setString(4, startDate);
			pre.setString(5, endDate);
			pre.setInt(6, otherAge);
			pre.setString(7, otherGender);
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
	public boolean deleteAll(){
		Connection conn = null;
		PreparedStatement pre = null;
		int rowNum = 0;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre=conn.prepareStatement(DELETE_ALL_SQL);
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
	 * ������ ã�� ������ �� Ư�� �������� �ʼ� ������ �����Ѵ�.<br/>PostingDataDAOManager���� ȣ��ȴ�
	 * @param postingCode ������ �ڵ�
	 * @return true - �Ѱ��� ������ ������ ������ ��� <br/> false - 0�� �Ǵ� 2�� �̻��� ������ ������ ������ ���
	 */
	public boolean delete(String postingCode){
		Connection conn = null;
		PreparedStatement pre = null;
		int rowNum = 0;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(DELETE_BY_POSTING_CODE_SQL);
			pre.setString(1, postingCode);
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
	 * ����� ��� ������ ã�� �������� �ʼ� ������ �����´�.<br/>������
	 * @return ��� ������ ã�� �������� �ʼ� ���� ���
	 */
	public List<CompanionRecommendDTO> selectAll(){
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		List<CompanionRecommendDTO> list = new ArrayList<CompanionRecommendDTO>();
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_ALL_SQL);
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("companion_recommend_code");
				String postingCode = re.getString("posting_code");
				String destination1 = re.getString("destination1");
				String destination2 = re.getString("destination2");
				String startDate = re.getString("start_date");
				String endDate = re.getString("end_date");
				int otherAge = re.getInt("other_age");
				String otherGender = re.getString("other_gender");
				list.add(new CompanionRecommendDTO(code, postingCode, destination1, destination2, startDate, endDate, otherAge, otherGender));
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
	 * ����� ������ ã�� ������ �� Ư�� �������� �ʼ� ������ �����´�.<br/>������
	 * @param postingCode ������ �ڵ�
	 * @return Ư�� �������� �ʼ� ����
	 */
	public CompanionRecommendDTO select(String postingCode){
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		CompanionRecommendDTO dto = new CompanionRecommendDTO ();
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_BY_POSTING_CODE_SQL);
			pre.setString(1, postingCode);
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("companion_recommend_code");
				String postingCode1 = re.getString("posting_code");
				String destination1 = re.getString("destination1");
				String destination2 = re.getString("destination2");
				String startDate = re.getString("start_date");
				String endDate = re.getString("end_date");
				int otherAge = re.getInt("other_age");
				String otherGender = re.getString("other_gender");
				dto = new CompanionRecommendDTO(code, postingCode1, destination1, destination2, startDate, endDate, otherAge, otherGender);
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
	 * ����� ������ ã�� ������ �� ���ǿ� ��ġ�ϴ� �������� �ʼ� �������� �����´�. <br/>������
	 * @param destination1 �������(��/��)
	 * @param destination2 �������(��)
	 * @param startDate ���� ������
	 * @param endDate ����������
	 * @param otherAge ���ϴ� ����� ���̴�
	 * @param otherGender ���ϴ� ����� ����
	 * @return ������ ã�� �������� �ʼ� ���� ���
	 */
	public List<CompanionRecommendDTO> select(String destination1, String destination2, String startDate, String endDate, int otherAge, String otherGender){
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		List<CompanionRecommendDTO> list = new ArrayList<CompanionRecommendDTO>();
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_BY_CONDITIONS_SQL);
			pre.setString(1, destination1);
			pre.setString(2, destination2);
			pre.setString(3, startDate);
			pre.setString(4, endDate);
			pre.setInt(5, otherAge);
			pre.setString(6, otherGender);
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("companion_recommend_code");
				String postingCode = re.getString("posting_code");
				String destination3 = re.getString("destination1");
				String destination4 = re.getString("destination2");
				String startDate1 = re.getString("start_date");
				String endDate1 = re.getString("end_date");
				int otherAge1 = re.getInt("other_age");
				String otherGender1 = re.getString("other_gender");
				list.add(new CompanionRecommendDTO(code, postingCode, destination3, destination4, startDate1, endDate1, otherAge1, otherGender1));
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally{
			try{
				conn.close();
				re.close();
				pre.close();
				
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		return list;
	}
	/**
	 * Ư�� ������ ã�� �������� �ʼ� ������ ��� �����Ѵ�. <br/>PostingDataDAOManager���� ȣ��ȴ�
	 * @param postingCode Ư�� �������� �ڵ�
	 * @param destination1 �������(��/��)
	 * @param destination2 �������(��)
	 * @param startDate ���������
	 * @param endDate ����������
	 * @param otherAge ���ϴ� ��� ���̴�
	 * @param otherGender ���ϴ� ��� ����
	 * @return true - ������ �������� ��� <br/> false - ������ �������� ���
	 */
	public boolean update(String postingCode, String destination1, String destination2, String startDate, String endDate, int otherAge, String otherGender){
		Connection conn = null;
		PreparedStatement pre = null;
		int rowNum = 0;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre= conn.prepareStatement(UPDATE_COMPANION_RECOMMEND_SQL);
			pre.setString(1, destination1);
			pre.setString(2, destination2);
			pre.setString(3, startDate);
			pre.setString(4, endDate);
			pre.setInt(5, otherAge);
			pre.setString(6, otherGender);
			pre.setString(7, postingCode);
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
