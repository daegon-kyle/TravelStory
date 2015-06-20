// 0720 ������
package dao;
import java.util.*;
import java.sql.*;

import dto.TourPreparationDTO;
/**
 * ���� �غ� �������� �ʼ� ������ �����ϱ� ���� ����Ѵ�. <br/>PostingDataDAOManger���� ���ȴ�.
 * @author ������
 *
 */
public class TourPreparationDAO {
	/**
	 * ���ο� ���� �غ� �������� �ʼ� ������ �����ϱ� ����  ������
	 */
	private final static String INSERT_TOUR_PLAN_SQL="INSERT INTO tour_preparation_tb VALUES(tour_preparation_code.nextVal, ?, ?, ?, ?, ?)";
	/**
	 * ����� ��� ���� �غ� �������� �ʼ� ������ �����ϱ� ���� ������
	 */
	private final static String DELETE_ALL_SQL="delete from tour_preparation_tb";
	/**
	 * ����� ���� �غ� ������ �� Ư�� �������� �ʼ� ������ �����ϱ� ���� ������
	 */
	private final static String DELETE_TOUR_PLAN_BY_POSTING_CODE_SQL="DELETE FROM tour_preparation_tb WHERE posting_code=?";
	/**
	 * ����� ��� ���� �غ� �������� �ʼ� ������ �������� ���� ������
	 */
	private final static String SELECT_ALL_SQL="select tour_preparation_code, posting_code, destination1, destination2, TO_CHAR(start_date, 'YYYY/MM/DD') start_date, TO_CHAR(end_date, 'YYYY/MM/DD') end_date from tour_preparation_tb";
	/**
	 * ����� ���� �غ� �������� �ʼ� ���� �� Ư�� �������� �ʼ� ������ �������� ���� ������
	 */
	private final static String SELECT_TOUR_PLAN_BY_POSTING_CODE_SQL="SELECT tour_preparation_code, posting_code, destination1, destination2, TO_CHAR(start_date, 'YYYY/MM/DD') start_date, TO_CHAR(end_date, 'YYYY/MM/DD') end_date FROM tour_preparation_tb where posting_code=?";
	/**
	 * ����� ���� �غ� �������� �ʼ� ���� �� ���ǿ� �����ϴ� �������� �ʼ� ������ �������� ���� ������
	 */
	private final static String SELECT_TOUR_PLANS_BY_CONDITIONS_SQL="select tour_preparation_code, posting_code, destination1, destination2, TO_CHAR(start_date, 'YYYY/MM/DD') start_date, TO_CHAR(end_date, 'YYYY/MM/DD') end_date from tour_preparation_tb where destination1=? and destination2=? and start_date=? and end_date=?";
	/**
	 * ����� ���� �غ� �������� �ʼ� ���� �� ��(3, 4, 5��)�� �ۼ��ϰ� ������Ұ� ��ġ�ϴ� �������� �ʼ� ������ �������� ���� ������
	 */
	private final static String SELECT_SPRING_TOUR_PLANS_SQL="select tour_preparation_code, posting_code, destination1, destination2, TO_CHAR(start_date, 'YYYY/MM/DD') start_date, TO_CHAR(end_date, 'YYYY/MM/DD') end_date from tour_preparation_tb where destination1=? and destination2=? and TO_CHAR(TO_DATE(start_date), 'MM')='03' or TO_CHAR(TO_DATE(start_date), 'MM')='04' or TO_CHAR(TO_DATE(start_date), 'MM')='05'";
	/**
	 * ����� ���� �غ� �������� �ʼ� ���� �� ���� (6,7 8��)�� �ۼ��ϰ� ���� ��Ұ� ��ġ�ϴ� �������� �ʼ� ������ �������� ���� ������
	 */
	private final static String SELECT_SUMMER_TOUR_PLANS_SQL="select tour_preparation_code, posting_code, destination1, destination2, TO_CHAR(start_date, 'YYYY/MM/DD') start_date, TO_CHAR(end_date, 'YYYY/MM/DD') end_date from tour_preparation_tb where destination1=? and destination2=? and TO_CHAR(TO_DATE(start_date), 'MM')='06' or TO_CHAR(TO_DATE(start_date), 'MM')='07' or TO_CHAR(TO_DATE(start_date), 'MM')='08'";
	/**
	 * ����� ���� �غ� �������� �ʼ� ���� �� ����(9, 10, 11��)�� �ۼ��ϰ� ���� ��Ұ� ��ġ�ϴ� �������� �ʼ� ������ �������� ���� ������
	 */
	private final static String SELECT_FALL_TOUR_PLANS_SQL="select tour_preparation_code, posting_code, destination1, destination2, TO_CHAR(start_date, 'YYYY/MM/DD') start_date, TO_CHAR(end_date, 'YYYY/MM/DD') end_date from tour_preparation_tb where destination1=? and destination2=? and TO_CHAR(TO_DATE(start_date), 'MM')='09' or TO_CHAR(TO_DATE(start_date), 'MM')='10' or TO_CHAR(TO_DATE(start_date), 'MM')='11'";
	/**
	 * ����� ���� �غ� �������� �ʼ� ���� �� �ܿ�(12, 1, 2��)�� �ۼ��ϰ� ���� ��Ұ� ��ġ�ϴ� �������� �ʼ� ������ �������� ���� ������
	 */
	private final static String SELECT_WINTER_TOUR_PLANS_SQL="select tour_preparation_code, posting_code, destination1, destination2, TO_CHAR(start_date, 'YYYY/MM/DD') start_date, TO_CHAR(end_date, 'YYYY/MM/DD') end_date from tour_preparation_tb where destination1=? and destination2=? and TO_CHAR(TO_DATE(start_date), 'MM')='12' or TO_CHAR(TO_DATE(start_date), 'MM')='01' or TO_CHAR(TO_DATE(start_date), 'MM')='02'";
	/**
	 * ����� ���� �غ� �������� �ʼ� ���� �� Ư�� �������� �ʼ� ������ �����ϱ� ���� ������
	 */
	private final static String UPDATE_TOUR_PREPARATION_SQL="UPDATE tour_preparation_tb SET destination1=?, destination2=?, start_date=?, end_date=? WHERE posting_code=?";
	/**
	 * default constructor
	 */
	public TourPreparationDAO(){
		
	}
	/**
	 * ���ο� ���� �غ� �������� �ʼ� ������ �����Ѵ�. <br/>PostingDataDAOManger���� ȣ��ȴ�.
	 * @param postingCode ������ �ڵ�
	 * @param destination1 �������(��/��)
	 * @param destination2 �������(��)
	 * @param startDate ���� ������
	 * @param endDate ���� ������
	 * @return true - ���忡 �������� ��� <br/> false - ���忡 �������� ���
	 */
	public boolean insert(String postingCode, String destination1, String destination2, String startDate, String endDate){
		int rowNum = 0;
		Connection conn = null;
		PreparedStatement pre = null;
		try{
			conn= DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(INSERT_TOUR_PLAN_SQL);
			pre.setString(1, postingCode);
			pre.setString(2, destination1);
			pre.setString(3, destination2);
			pre.setString(4, startDate);
			pre.setString(5, endDate);
			rowNum = pre.executeUpdate();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally{
			try{
				pre.close();
				conn.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		if(rowNum == 1)
			return true;
		return false;
	}
	/**
	 * ����� ��� ���� �غ� �������� �ʼ� ������ �����Ѵ�.<br/>PostingDataDAOManger���� ȣ��ȴ�.
	 * @return true - ������ �������� ��� <br/> false - ������ �������� ���
	 */
	public boolean deleteAll(){
		int rowNum = 0;
		Connection conn = null;
		PreparedStatement pre = null;
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
				pre.close();
				conn.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		if(rowNum >0)
			return true;
		return false;
	}
	/**
	 * ����� ���� �غ� ������ �� Ư�� ������ ���� �غ� �ʼ� ������ �����Ѵ�.  <br/>PostingDataDAOManger���� ȣ��ȴ�.
	 * @param postingCode ������ �ڵ�
	 * @return true - ������ �������� ��� <br/> false - ������ �������� ���
	 */
	public boolean delete(String postingCode){
		int rowNum =0;
		Connection conn = null;
		PreparedStatement pre = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(DELETE_TOUR_PLAN_BY_POSTING_CODE_SQL);
			pre.setString(1, postingCode);
			rowNum = pre.executeUpdate();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally{
			try{
				pre.close();
				conn.close();
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
	 * ����� ��� ���� �غ� �������� �ʼ� ������ �����´�.  <br/>������
	 * @return ��� ���� �غ� �������� �ʼ� ����
	 */
	public List<TourPreparationDTO> selectAll(){
		List<TourPreparationDTO> list = new ArrayList<TourPreparationDTO>();
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_ALL_SQL);
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("tour_preparation_code");
				String postingCode = re.getString("posting_code");
				String destination1 = re.getString("destination1");
				String destination2 = re.getString("destination2");
				String startDate = re.getString("start_date");
				String endDate = re.getString("end_date");
				list.add(new TourPreparationDTO(code, postingCode, destination1, destination2, startDate, endDate));
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally{
			try{
				pre.close();
				conn.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		return list;
	}
	/**
	 * ����� ���� �غ� ������ �� Ư�� �������� �ʼ� ������ �����´�. <br/>������
	 * @return Ư�� ���� �غ� �������� �ʼ� ����
	 */
	public TourPreparationDTO select(String postingCode){
		TourPreparationDTO dto = null;
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_TOUR_PLAN_BY_POSTING_CODE_SQL);
			pre.setString(1, postingCode);
			re=pre.executeQuery();
			while(re.next()){
				String code = re.getString("tour_preparation_code");
				String postingCode1 = re.getString("posting_code");
				String destination1 = re.getString("destination1");
				String destination2 = re.getString("destination2");
				String startDate = re.getString("start_date");
				String endDate = re.getString("end_date");
				dto = new TourPreparationDTO(code, postingCode1, destination1, destination2, startDate, endDate);
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally{
			try{
				pre.close();
				conn.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		return dto;
	}
	/**
	 * ����� ���� �غ� �������� �ʼ� ���� �� ���ǰ� ��Ȯ�� ��ġ�ϴ� �������� �ʼ� ������ �����´�. <br/>������
	 * @param destination1 �������(��/��)
	 * @param destination2 �������(��)
	 * @param startDate ���� ������
	 * @param endDate ���� ������
	 * @return ���ǰ� ��ġ�ϴ� ���� �غ� �������� �ʼ� ������
	 */
	public List<TourPreparationDTO> select(String destination1, String destination2, String startDate, String endDate){
		List<TourPreparationDTO> list = new ArrayList<TourPreparationDTO>();
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_TOUR_PLANS_BY_CONDITIONS_SQL);
			pre.setString(1, destination1);
			pre.setString(2, destination2);
			pre.setString(3, startDate);
			pre.setString(4, endDate);
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("tour_preparation_code");
				String postingCode = re.getString("posting_code");
				String destination3 = re.getString("destination1");
				String destination4 = re.getString("destination2");
				String startDate1 = re.getString("start_date");
				String endDate1 = re.getString("end_date");
				list.add(new TourPreparationDTO(code, postingCode, destination3, destination4, startDate1, endDate1));
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally{
			try{
				pre.close();
				conn.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		return list;
	}
	/**
	 * ����� ���� �غ� �ʼ� ���� �� ��(3, 4, 5��)�� �ۼ��ǰ� ������Ұ� ��ġ�ϴ� ���� �غ� �ʼ� �������� �����´�.<br/>������
	 * @param destination1 �������(��/��)
	 * @param destination2 �������(��)
	 * @return ���ǿ� ������ ���� �غ� �ʼ� ������
	 */
	public List<TourPreparationDTO> selectSpringTourPlans(String destination1, String destination2){
		List<TourPreparationDTO> list = new ArrayList<TourPreparationDTO>();
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_SPRING_TOUR_PLANS_SQL);
			pre.setString(1, destination1);
			pre.setString(2, destination2);
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("tour_preparation_code");
				String postingCode = re.getString("posting_code");
				String destination3 = re.getString("destination1");
				String destination4 = re.getString("destination2");
				String startDate = re.getString("start_date");
				String endDate = re.getString("end_date");
				list.add(new TourPreparationDTO(code, postingCode, destination3, destination4, startDate, endDate));
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally{
			try{
				pre.close();
				conn.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		return list;
	}
	/**
	 * ����� ���� �غ� �ʼ� ���� �� ����(6, 7, 8��)�� �ۼ��ǰ� ������Ұ� ��ġ�ϴ� ���� �غ� �ʼ� �������� �����´�.<br/>������
	 * @param destination1 �������(��/��)
	 * @param destination2 �������(��)
	 * @return ���ǿ� ������ ���� �غ� �������� �ʼ� ������
	 */
	public List<TourPreparationDTO> selectSummerTourPlans(String destination1, String destination2){
		List<TourPreparationDTO> list = new ArrayList<TourPreparationDTO>();
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_SUMMER_TOUR_PLANS_SQL);
			pre.setString(1, destination1);
			pre.setString(2, destination2);
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("tour_preparation_code");
				String postingCode = re.getString("posting_code");
				String destination3 = re.getString("destination1");
				String destination4 = re.getString("destination2");
				String startDate = re.getString("start_date");
				String endDate = re.getString("end_date");
				list.add(new TourPreparationDTO(code, postingCode, destination3, destination4, startDate, endDate));
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally{
			try{
				pre.close();
				conn.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		return list;
	}
	/**
	 * ����� ���� �غ� �ʼ� ���� �� ����(9, 10, 11��)�� �ۼ��ǰ� ������Ұ� ��ġ�ϴ� ���� �غ� �ʼ� �������� �����´�.<br/>������
	 * @param destination1 �������(��/��)
	 * @param destination2 �������(��)
	 * @return ���ǿ� ������ ���� �غ� �������� �ʼ�������
	 */
	public List<TourPreparationDTO> selectFallTourPlans(String destination1, String destination2){
		List<TourPreparationDTO> list = new ArrayList<TourPreparationDTO>();
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_FALL_TOUR_PLANS_SQL);
			pre.setString(1, destination1);
			pre.setString(2, destination2);
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("tour_preparation_code");
				String postingCode = re.getString("posting_code");
				String destination3 = re.getString("destination1");
				String destination4 = re.getString("destination2");
				String startDate = re.getString("start_date");
				String endDate = re.getString("end_date");
				list.add(new TourPreparationDTO(code, postingCode, destination3, destination4, startDate, endDate));
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally{
			try{
				pre.close();
				conn.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		return list;
	}
	/**
	 * ����� ���� �غ� �ʼ� ���� �� �ܿ�(12, 1, 2��)�� �ۼ��ǰ� ������Ұ� ��ġ�ϴ� ���� �غ� �ʼ� �������� �����´�.<br/>������
	 * @param destination1 �������(��/��)
	 * @param destination2 �������(��)
	 * @return ���ǿ� ������ ���� �غ� �������� �ʼ� ������
	 */
	public List<TourPreparationDTO> selectWinterTourPlans(String destination1, String destination2){
		List<TourPreparationDTO> list = new ArrayList<TourPreparationDTO>();
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_WINTER_TOUR_PLANS_SQL);
			pre.setString(1, destination1);
			pre.setString(2, destination2);
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("tour_preparation_code");
				String postingCode = re.getString("posting_code");
				String destination3 = re.getString("destination1");
				String destination4 = re.getString("destination2");
				String startDate = re.getString("start_date");
				String endDate = re.getString("end_date");
				list.add(new TourPreparationDTO(code, postingCode, destination3, destination4, startDate, endDate));
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally{
			try{
				pre.close();
				conn.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		return list;
	}
	/**
	 * ����� ���� ���� �������� �ʼ� ���� �� Ư�� �������� �ʼ� ������ �����Ѵ�.<br/>PostingDataDAOManager���� ȣ��ȴ�
	 * @param postingCode ������ �ڵ�
	 * @param destination1 �������(��/��)
	 * @param destiantion2 �������(��)
	 * @param startDate ���� ������
	 * @param endDate ���� ������
	 * @return true - ������ �������� ��� <br/> false - ������ �������� ���
	 */
	public boolean update(String postingCode, String destination1, String destiantion2, String startDate, String endDate){
		Connection conn = null;
		PreparedStatement pre = null;
		int rowNum = 0;
		try{
			conn =DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(UPDATE_TOUR_PREPARATION_SQL);
			pre.setString(1, destination1);
			pre.setString(2, destiantion2);
			pre.setString(3, startDate);
			pre.setString(4, endDate);
			pre.setString(5, postingCode);
			rowNum = pre.executeUpdate();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally{
			try{
				pre.close();
				conn.close();
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
