// 0720 문정현
package dao;
import java.util.*;
import java.sql.*;

import dto.TourPreparationDTO;
/**
 * 여행 준비물 포스팅의 필수 정보를 조작하기 위해 사용한다. <br/>PostingDataDAOManger에서 사용된다.
 * @author 문정현
 *
 */
public class TourPreparationDAO {
	/**
	 * 새로운 여행 준비물 포스팅의 필수 정보를 저장하기 위한  쿼리문
	 */
	private final static String INSERT_TOUR_PLAN_SQL="INSERT INTO tour_preparation_tb VALUES(tour_preparation_code.nextVal, ?, ?, ?, ?, ?)";
	/**
	 * 저장된 모든 여행 준비물 포스팅의 필수 정보를 삭제하기 위한 쿼리문
	 */
	private final static String DELETE_ALL_SQL="delete from tour_preparation_tb";
	/**
	 * 저장된 여행 준비물 포스팅 중 특정 포스팅의 필수 정보를 삭제하기 위한 쿼리문
	 */
	private final static String DELETE_TOUR_PLAN_BY_POSTING_CODE_SQL="DELETE FROM tour_preparation_tb WHERE posting_code=?";
	/**
	 * 저장된 모든 여행 준비물 포스팅의 필수 정보를 가져오기 위한 쿼리문
	 */
	private final static String SELECT_ALL_SQL="select tour_preparation_code, posting_code, destination1, destination2, TO_CHAR(start_date, 'YYYY/MM/DD') start_date, TO_CHAR(end_date, 'YYYY/MM/DD') end_date from tour_preparation_tb";
	/**
	 * 저장된 여행 준비물 포스팅의 필수 정보 중 특정 포스팅의 필수 정보를 가져오기 위한 쿼리문
	 */
	private final static String SELECT_TOUR_PLAN_BY_POSTING_CODE_SQL="SELECT tour_preparation_code, posting_code, destination1, destination2, TO_CHAR(start_date, 'YYYY/MM/DD') start_date, TO_CHAR(end_date, 'YYYY/MM/DD') end_date FROM tour_preparation_tb where posting_code=?";
	/**
	 * 저장된 여행 준비물 포스팅의 필수 정보 중 조건에 만족하는 포스팅의 필수 정보를 가져오기 위한 쿼리문
	 */
	private final static String SELECT_TOUR_PLANS_BY_CONDITIONS_SQL="select tour_preparation_code, posting_code, destination1, destination2, TO_CHAR(start_date, 'YYYY/MM/DD') start_date, TO_CHAR(end_date, 'YYYY/MM/DD') end_date from tour_preparation_tb where destination1=? and destination2=? and start_date=? and end_date=?";
	/**
	 * 저장된 여행 준비물 포스팅의 필수 정보 중 봄(3, 4, 5월)에 작성하고 여행장소가 일치하는 포스팅의 필수 정보를 가져오기 위한 쿼리문
	 */
	private final static String SELECT_SPRING_TOUR_PLANS_SQL="select tour_preparation_code, posting_code, destination1, destination2, TO_CHAR(start_date, 'YYYY/MM/DD') start_date, TO_CHAR(end_date, 'YYYY/MM/DD') end_date from tour_preparation_tb where destination1=? and destination2=? and TO_CHAR(TO_DATE(start_date), 'MM')='03' or TO_CHAR(TO_DATE(start_date), 'MM')='04' or TO_CHAR(TO_DATE(start_date), 'MM')='05'";
	/**
	 * 저장된 여행 준비물 포스팅의 필수 정보 중 여름 (6,7 8월)에 작성하고 여행 장소가 일치하는 포스팅의 필수 정보를 가져오기 위한 쿼리문
	 */
	private final static String SELECT_SUMMER_TOUR_PLANS_SQL="select tour_preparation_code, posting_code, destination1, destination2, TO_CHAR(start_date, 'YYYY/MM/DD') start_date, TO_CHAR(end_date, 'YYYY/MM/DD') end_date from tour_preparation_tb where destination1=? and destination2=? and TO_CHAR(TO_DATE(start_date), 'MM')='06' or TO_CHAR(TO_DATE(start_date), 'MM')='07' or TO_CHAR(TO_DATE(start_date), 'MM')='08'";
	/**
	 * 저장된 여행 준비물 포스팅의 필수 정보 중 가을(9, 10, 11월)에 작성하고 여행 장소가 일치하는 포스팅의 필수 정보를 가져오기 위한 쿼리문
	 */
	private final static String SELECT_FALL_TOUR_PLANS_SQL="select tour_preparation_code, posting_code, destination1, destination2, TO_CHAR(start_date, 'YYYY/MM/DD') start_date, TO_CHAR(end_date, 'YYYY/MM/DD') end_date from tour_preparation_tb where destination1=? and destination2=? and TO_CHAR(TO_DATE(start_date), 'MM')='09' or TO_CHAR(TO_DATE(start_date), 'MM')='10' or TO_CHAR(TO_DATE(start_date), 'MM')='11'";
	/**
	 * 저장된 여행 준비물 포스팅의 필수 정보 중 겨울(12, 1, 2월)에 작성하고 여행 장소가 일치하는 포스팅의 필수 정보를 가져오기 위한 쿼리문
	 */
	private final static String SELECT_WINTER_TOUR_PLANS_SQL="select tour_preparation_code, posting_code, destination1, destination2, TO_CHAR(start_date, 'YYYY/MM/DD') start_date, TO_CHAR(end_date, 'YYYY/MM/DD') end_date from tour_preparation_tb where destination1=? and destination2=? and TO_CHAR(TO_DATE(start_date), 'MM')='12' or TO_CHAR(TO_DATE(start_date), 'MM')='01' or TO_CHAR(TO_DATE(start_date), 'MM')='02'";
	/**
	 * 저장된 여행 준비물 포스팅의 필수 정보 중 특정 포스팅의 필수 정보를 수정하기 위한 쿼리문
	 */
	private final static String UPDATE_TOUR_PREPARATION_SQL="UPDATE tour_preparation_tb SET destination1=?, destination2=?, start_date=?, end_date=? WHERE posting_code=?";
	/**
	 * default constructor
	 */
	public TourPreparationDAO(){
		
	}
	/**
	 * 새로운 여행 준비물 포스팅의 필수 정보를 저장한다. <br/>PostingDataDAOManger에서 호출된다.
	 * @param postingCode 포스팅 코드
	 * @param destination1 여행장소(시/도)
	 * @param destination2 여행장소(구)
	 * @param startDate 여행 시작일
	 * @param endDate 여행 종료일
	 * @return true - 저장에 성공했을 경우 <br/> false - 저장에 실패했을 경우
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
	 * 저장된 모든 여행 준비물 포스팅의 필수 정보를 삭제한다.<br/>PostingDataDAOManger에서 호출된다.
	 * @return true - 삭제에 성공했을 경우 <br/> false - 삭제에 실패했을 경우
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
	 * 저장된 여행 준비물 포스팅 중 특정 포스팅 여행 준비물 필수 정보를 삭제한다.  <br/>PostingDataDAOManger에서 호출된다.
	 * @param postingCode 포스팅 코드
	 * @return true - 삭제에 성공했을 경우 <br/> false - 삭제에 실패했을 경우
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
	 * 저장된 모든 여행 준비물 포스팅의 필수 정보를 가져온다.  <br/>사용안함
	 * @return 모든 여행 준비물 포스팅의 필수 정보
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
	 * 저장된 여행 준비물 포스팅 중 특정 포스팅의 필수 정보를 가져온다. <br/>사용안함
	 * @return 특정 여행 준비물 포스팅의 필수 정보
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
	 * 저장된 여행 준비물 포스팅의 필수 정보 중 조건관 정확히 일치하는 포스팅의 필수 정보를 가져온다. <br/>사용안함
	 * @param destination1 여행장소(시/도)
	 * @param destination2 여행장소(구)
	 * @param startDate 여행 시작일
	 * @param endDate 여행 종료일
	 * @return 조건과 일치하는 여행 준비물 포스팅의 필수 정보들
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
	 * 저장된 여행 준비물 필수 정보 중 봄(3, 4, 5월)에 작성되고 여행장소가 일치하는 여행 준비물 필수 정보들을 가져온다.<br/>사용안함
	 * @param destination1 여행장소(시/도)
	 * @param destination2 여행장소(구)
	 * @return 조건에 만족된 여행 준비물 필수 정보들
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
	 * 저장된 여행 준비물 필수 정보 중 여름(6, 7, 8월)에 작성되고 여행장소가 일치하는 여행 준비물 필수 정보들을 가져온다.<br/>사용안함
	 * @param destination1 여행장소(시/도)
	 * @param destination2 여행장소(구)
	 * @return 조건에 만족된 여행 준비물 포스팅의 필수 정보들
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
	 * 저장된 여행 준비물 필수 정보 중 가을(9, 10, 11월)에 작성되고 여행장소가 일치하는 여행 준비물 필수 정보들을 가져온다.<br/>사용안함
	 * @param destination1 여행장소(시/도)
	 * @param destination2 여행장소(구)
	 * @return 조건에 만족된 여행 준비물 포스팅의 필수정보들
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
	 * 저장된 여행 준비물 필수 정보 중 겨울(12, 1, 2월)에 작성되고 여행장소가 일치하는 여행 준비물 필수 정보들을 가져온다.<br/>사용안함
	 * @param destination1 여행장소(시/도)
	 * @param destination2 여행장소(구)
	 * @return 조건에 만족된 여행 준비물 포스팅의 필수 정보들
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
	 * 저장된 여행 일정 포스팅의 필수 정보 중 특정 포스팅의 필수 정보를 수정한다.<br/>PostingDataDAOManager에서 호출된다
	 * @param postingCode 포스팅 코드
	 * @param destination1 여행장소(시/도)
	 * @param destiantion2 여행장소(구)
	 * @param startDate 여행 시작일
	 * @param endDate 여행 종료일
	 * @return true - 수정에 성공했을 경우 <br/> false - 수정에 실패했을 경우
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
