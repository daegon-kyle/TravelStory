// 0720 ������
package dao;
import java.sql.*;
import java.util.*;

import dto.TourPlanDTO;
/**
 * ���� ���� �������� �ʼ� ������ �����Ѵ�.<br/>PostingDataDAOManager���� ����Ѵ�
 * @author ������
 *
 */
public class TourPlanDAO {
	/**
	 * ���ο� ���� ���� �������� �ʼ� ������ �����ϱ� ���� ���Ǵ� ������
	 */
	private final static String INSERT_TOUR_PLAN_SQL="INSERT INTO tour_plan_tb VALUES(tour_plan_code.nextVal, ?, ?, ?, ?)";
	/**
	 * ����� ��� ���� ���� �������� �ʼ� ������ �����ϱ� ���� ���Ǵ� ������
	 */
	private final static String DELETE_ALL_SQL="delete from tour_plan_tb";
	/**
	 * ����� ���� ���� �������� �ʼ� ���� �� Ư�� �������� �ʼ������� �����ϱ� ���� ���Ǵ� ������
	 */
	private final static String DELETE_BY_POSTING_CODE_SQL="delete from tour_plan_tb where posting_code=?";
	/**
	 * ����� ��� ���� ���� �������� �ʼ� ������ �������� ���� ���Ǵ� ������
	 */
	private final static String SELECT_ALL_SQL="select * from tour_plan_tb";
	/**
	 * ����� ���� ���� ������ �� Ư�� �������� �ʼ� ������ �������� ���� ������
	 */
	private final static String SELECT_BY_POSTING_CODE_SQL="select * from tour_plan_tb where posting_code=?";
	/**
	 * ����� ���� ���� ������ �� Ư�� ���ǿ� �����ϴ� ��������  �ʼ� ������ �������� ���� ������
	 */
	private final static String SELECT_BY_CONDITONS_SQL="select * from tour_plan_tb where liking_info_code=? and destination1=? and destination2=?";
	/**
	 * ����� ���� ���� ������ �� Ư�� �������� �ʼ� ������ �����ϱ� ���� ������
	 */
	private final static String UPDATE_TOUR_PLAN_SQL="UPDATE tour_plan_tb SET liking_info_code=?, destination1=?,destination2=?  WHERE posting_code=?";
	/**
	 * default constructor
	 */
	public TourPlanDAO(){
		
	}
	/**
	 * ���ο� ���� ���� �������� �ʼ� ������ �����Ѵ�.<br/>PostingDataDAOManager���� ȣ��ȴ�
	 * @param postingCode ������ �ڵ�
	 * @param likingInfoCode ���� ���� ���� �ڵ�
	 * @param destination1 ���� ���(��/��)
	 * @param destination2 ���� ���(��)
	 * @return true - ���忡 �������� ��� <br/> false - ���忡 ���� ���� ���
	 */
	public boolean insert(String postingCode, String likingInfoCode, String destination1, String destination2){
		Connection conn = null;
		PreparedStatement pre = null;
		int rowNum = 0;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(INSERT_TOUR_PLAN_SQL);
			pre.setString(1, postingCode);
			pre.setString(2,likingInfoCode);
			pre.setString(3, destination1);
			pre.setString(4, destination2);
			rowNum = pre.executeUpdate();
		}
		catch(SQLException sql){
			sql.printStackTrace();
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
	 * ����� ��� ���� ���� �������� �ʼ� ������ �����Ѵ�.<br/>������
	 * @return true - ������ �������� ��� <br/> false - ������ �������� ���
	 */
	public boolean deleteAll(){
		Connection conn = null;
		PreparedStatement pre = null;
		int rowNum = 0;
		try{
			conn=DBConnectionPool.getInstance().getConnection();
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
	 * ����� ���� ���� �������� �ʼ� ���� �� Ư�� �������� �ʼ������� �����Ѵ�.<br/>PostingDataDAOManager���� ȣ��ȴ�
	 * @param postingCode ������ �ڵ�
	 * @return true - ������ �������� ��� <br/> false - ������ ���� ���� ���
	 */
	public boolean delete(String postingCode){
		Connection conn = null;
		PreparedStatement pre = null;
		int rowNum=0;
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
			catch(SQLException sql){
				sql.printStackTrace();
			}
		}
		if(rowNum==1)
			return true;
		return false;
	}
	/**
	 * ����� ��� ���� ���� �������� �ʼ� ������ �����´�. <br/>������
	 * @return ��� ���� ���� �������� �ʼ� ����
	 */
	public List<TourPlanDTO> selectAll(){
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		List<TourPlanDTO> list = new ArrayList<TourPlanDTO>();
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre= conn.prepareStatement(SELECT_ALL_SQL);
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("tour_plan_code");
				String postingCode=re.getString("posting_code");
				String likingInfoCode=re.getString("liking_info_code");
				String destination1 = re.getString("destination1");
				String destination2 = re.getString("destination2");
				list.add(new TourPlanDTO(code, postingCode, likingInfoCode, destination1, destination2));
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
	 * ����� ���� ���� ������ �� Ư�� ���ǿ� �����ϴ� ��������  �ʼ� ������ �����´�.<br/>������
	 * @param likingInfoCode ���� ���� ���� �ڵ�
	 * @param destination1 �������(��/��)
	 * @param destination2 �������(��)
	 * @return ���ǿ� �����ϴ� ���� ���� �������� �ʼ�������
	 */
	public List<TourPlanDTO> select(String likingInfoCode, String destination1, String destination2){
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		List<TourPlanDTO> list = new ArrayList<TourPlanDTO>();
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre= conn.prepareStatement(SELECT_BY_CONDITONS_SQL);
			pre.setString(1, likingInfoCode);
			pre.setString(2, destination1);
			pre.setString(3, destination2);
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("tour_plan_code");
				String postingCode=re.getString("posting_code");
				String likingInfoCode1=re.getString("liking_info_code");
				String destination3 = re.getString("destination1");
				String destination4 = re.getString("destination2");
				list.add(new TourPlanDTO(code, postingCode, likingInfoCode1, destination3, destination4));
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
	 * ����� ���� ���� ������ �� Ư�� �������� �ʼ� ������ �����´�.<br/>������
	 * @param postingCode ������ �ڵ�
	 * @return ���� ���� �������� �ʼ� ����
	 */
	public TourPlanDTO select(String postingCode){
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		TourPlanDTO dto =null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre= conn.prepareStatement(SELECT_BY_POSTING_CODE_SQL);
			pre.setString(1, postingCode);
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("tour_plan_code");
				String postingCode1=re.getString("posting_code");
				String likingInfoCode=re.getString("liking_info_code");
				String destination1 = re.getString("destination1");
				String destination2 = re.getString("destination2");
				dto = new TourPlanDTO(code, postingCode1, likingInfoCode, destination1, destination2);
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
		return dto;
	}
	/**
	 * ����� ���� ���� ������ �� Ư�� �������� �ʼ� ������ �����Ѵ�.<br/>PostingDataDAOManager���� ȣ��ȴ�
	 * @param postingCode ������ �ڵ�
	 * @param likingInfoCode ���� ���� ���� �ڵ�
	 * @param destination1 �������(��/��)
	 * @param destination2 �������(��)
	 * @return true - ������ �������� ��� <br/> false - ������ �������� ���
	 */
	public boolean update(String postingCode, String likingInfoCode, String destination1, String destination2){
		Connection conn = null;
		PreparedStatement pre = null;
		int rowNum = 0;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(UPDATE_TOUR_PLAN_SQL);
			pre.setString(1, likingInfoCode);
			pre.setString(2, destination1);
			pre.setString(3, destination2);
			pre.setString(4, postingCode);
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
			catch(SQLException sqle)
			{
				sqle.printStackTrace();
			}
		}
		if(rowNum==1)
			return true;
		return false;
	}
}
