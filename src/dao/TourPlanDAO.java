// 0720 문정현
package dao;
import java.sql.*;
import java.util.*;

import dto.TourPlanDTO;
/**
 * 여행 일정 포스팅의 필수 정보를 조작한다.<br/>PostingDataDAOManager에서 사용한다
 * @author 문정현
 *
 */
public class TourPlanDAO {
	/**
	 * 새로운 여행 일정 포스팅의 필수 정보를 저장하기 위해 사용되는 쿼리문
	 */
	private final static String INSERT_TOUR_PLAN_SQL="INSERT INTO tour_plan_tb VALUES(tour_plan_code.nextVal, ?, ?, ?, ?)";
	/**
	 * 저장된 모든 여행 일정 포스팅의 필수 정보를 삭제하기 위해 사용되는 쿼리문
	 */
	private final static String DELETE_ALL_SQL="delete from tour_plan_tb";
	/**
	 * 저장된 여행 일정 포스팅의 필수 정보 중 특정 포스팅의 필수정보를 삭제하기 위해 사용되는 쿼리문
	 */
	private final static String DELETE_BY_POSTING_CODE_SQL="delete from tour_plan_tb where posting_code=?";
	/**
	 * 저장된 모든 여행 일정 포스팅의 필수 정보를 가져오기 위해 사용되는 쿼리문
	 */
	private final static String SELECT_ALL_SQL="select * from tour_plan_tb";
	/**
	 * 저장된 여행 일정 포스팅 중 특정 포스팅의 필수 정보를 가져오기 위한 쿼리문
	 */
	private final static String SELECT_BY_POSTING_CODE_SQL="select * from tour_plan_tb where posting_code=?";
	/**
	 * 저장된 여행 일정 포스팅 중 특정 조건에 만족하는 포스팅의  필수 정보를 가져오기 위한 쿼리문
	 */
	private final static String SELECT_BY_CONDITONS_SQL="select * from tour_plan_tb where liking_info_code=? and destination1=? and destination2=?";
	/**
	 * 저장된 여행 일정 포스팅 중 특정 포스팅의 필수 정보를 수정하기 위한 쿼리문
	 */
	private final static String UPDATE_TOUR_PLAN_SQL="UPDATE tour_plan_tb SET liking_info_code=?, destination1=?,destination2=?  WHERE posting_code=?";
	/**
	 * default constructor
	 */
	public TourPlanDAO(){
		
	}
	/**
	 * 새로운 여행 일정 포스팅의 필수 정보를 저장한다.<br/>PostingDataDAOManager에서 호출된다
	 * @param postingCode 포스팅 코드
	 * @param likingInfoCode 여행 취향 정보 코드
	 * @param destination1 여행 장소(시/도)
	 * @param destination2 여행 장소(구)
	 * @return true - 저장에 성공했을 경우 <br/> false - 저장에 실패 했을 경우
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
	 * 저장된 모든 여행 일정 포스팅의 필수 정보를 삭제한다.<br/>사용안함
	 * @return true - 삭제에 성공했을 경우 <br/> false - 삭제에 실패했을 경우
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
	 * 저장된 여행 일정 포스팅의 필수 정보 중 특정 포스팅의 필수정보를 삭제한다.<br/>PostingDataDAOManager에서 호출된다
	 * @param postingCode 포스팅 코드
	 * @return true - 삭제에 성공했을 경우 <br/> false - 삭제에 실패 했을 경우
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
	 * 저장된 모든 여행 일정 포스팅의 필수 정보를 가져온다. <br/>사용안함
	 * @return 모든 여행 일정 포스팅의 필수 정보
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
	 * 저장된 여행 일정 포스팅 중 특정 조건에 만족하는 포스팅의  필수 정보를 가져온다.<br/>사용안함
	 * @param likingInfoCode 여행 취향 정보 코드
	 * @param destination1 여행장소(시/도)
	 * @param destination2 여행장소(구)
	 * @return 조건에 만족하는 여행 일정 포스팅의 필수정보들
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
	 * 저장된 여행 일정 포스팅 중 특정 포스팅의 필수 정보를 가져온다.<br/>사용안함
	 * @param postingCode 포스팅 코드
	 * @return 여행 일정 포스팅의 필수 정보
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
	 * 저장된 여행 일정 포스팅 중 특정 포스팅의 필수 정보를 수정한다.<br/>PostingDataDAOManager에서 호출된다
	 * @param postingCode 포스팅 코드
	 * @param likingInfoCode 여행 취향 정보 코드
	 * @param destination1 여행장소(시/도)
	 * @param destination2 여행장소(구)
	 * @return true - 수정에 성공했을 경우 <br/> false - 수정에 실패했을 경우
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
