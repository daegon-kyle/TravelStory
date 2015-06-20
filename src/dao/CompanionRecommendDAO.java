// 0720 문정현
package dao;
import java.sql.*;
import java.util.*;

import dto.CompanionRecommendDTO;
/**
 * 동행자 찾기 포스팅의 필수 정보를 조작하기 위해 사용되다. <br/> PostingDataDAOManager에서 사용한다
 * @author 문정현
 *
 */
public class CompanionRecommendDAO {
	/**
	 * 동행자 찾기 포스팅의 필수 정보를 저장하기 위해 사용되는 쿼리문
	 */
	private final static String INDERT_COMPANION_RECOMMEND_SQL="INSERT INTO companion_recommend_tb VALUES(companion_recommend_code.nextVal, ?,?,?, ?, ?,?,?)";
	/**
	 * 저장된 동행자 찾기 포스팅의 필수 정보를 모두 삭제하기 위해 사용되는 쿼리문
	 */
	private final static String DELETE_ALL_SQL="delete from companion_recommend_tb";
	/**
	 * 저장된 동행자 찾기 포스팅의 필수 정보 중 특정 포스팅을 삭제하기 위해 사용되는 쿼리문
	 */
	private final static String DELETE_BY_POSTING_CODE_SQL="delete from companion_recommend_tb where posting_code=?";
	/**
	 * 저장된 동행자 찾기 포스팅의 필수 정보를 모두 가져오기 위해 사용되는 쿼리문
	 */
	private final static String SELECT_ALL_SQL="select companion_recommend_code, posting_code, destination1, destination2, TO_CHAR(start_date, 'YYYY/MM/DD') start_date, TO_CHAR(end_date, 'YYYY/MM/DD') end_date, other_age, other_gender from companion_recommend_tb";
	/**
	 * 저장된 동행자 찾기 포스팅 중 특정 포스팅의 필수 정보를 가져오기 위해 사용되는 쿼리문
	 */
	private final static String SELECT_BY_POSTING_CODE_SQL="select companion_recommend_code, posting_code, destination1, destination2, TO_CHAR(start_date, 'YYYY/MM/DD') start_date, TO_CHAR(end_date, 'YYYY/MM/DD') end_date, other_age, other_gender from companion_recommend_tb where posting_code=?";
	/**
	 * 저장된 동행자 찾기 포스팅 중 조건에 만족하는 포스팅의 필수 정보를 가져오기 위해 사용되는 쿼리문
	 */
	private final static String SELECT_BY_CONDITIONS_SQL="select companion_recommend_code, posting_code, destination1, destination2, TO_CHAR(start_date, 'YYYY/MM/DD') start_date, TO_CHAR(end_date, 'YYYY/MM/DD') end_date, other_age, other_gender from companion_recommend_tb where destination1=? and destination2=? and start_date=? and end_date=? and other_age=? and other_gender=?";
	/**
	 * 저장된 동행자 찾기 포스팅 중 특정 포스팅의 필수 정보를 수정하기 위해 사용되는 퀴리문
	 */
	private final static String UPDATE_COMPANION_RECOMMEND_SQL="UPDATE companion_recommend_tb SET  destination1=?, destination2=?, start_date=?, end_date=?,other_age=?, other_gender=? WHERE posting_code=?";
	/**
	 * default constructor
	 */
	public CompanionRecommendDAO(){
		
	}
	/**
	 * 동행자 찾기 포스팅의 필수 정보를 저장하기 위해 사용한다. <br/>PostingDataDAOManager에서 호출된다
	 * @param postingCode 포스팅 코드
	 * @param destination1 여행장소(시/도)
	 * @param destination2 여행장소(구)
	 * @param startDate 여행시작일
	 * @param endDate 여행종료일
	 * @param otherAge 원하는 상대의 나이대
	 * @param otherGender 원하는 상대의 성별
	 * @return true - 저장 성공 <br/> false - 저장 실패
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
	 * 동행자 찾기 포스팅 중 특정 포스팅의 필수 정보를 삭제한다.<br/>PostingDataDAOManager에서 호출된다
	 * @param postingCode 포스팅 코드
	 * @return true - 한개의 포스팅 정보를 삭제한 경우 <br/> false - 0개 또는 2개 이상의 포스팅 정보를 삭제한 경우
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
	 * 저장된 모든 동행자 찾기 포스팅의 필수 정보를 가져온다.<br/>사용안함
	 * @return 모든 동행자 찾기 포스팅의 필수 정보 목록
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
	 * 저장된 동행자 찾기 포스팅 중 특정 포스팅의 필수 정보를 가져온다.<br/>사용안함
	 * @param postingCode 포스팅 코드
	 * @return 특정 포스팅의 필수 정보
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
	 * 저장된 동행자 찾기 포스팅 중 조건에 일치하는 포스팅의 필수 정보들을 가져온다. <br/>사용안함
	 * @param destination1 여행장소(시/도)
	 * @param destination2 여행장소(구)
	 * @param startDate 여행 시작일
	 * @param endDate 여행종료일
	 * @param otherAge 원하는 상대의 나이대
	 * @param otherGender 원하는 상대의 성별
	 * @return 동행자 찾기 포스팅의 필수 정보 목록
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
	 * 특정 동행자 찾기 포스팅의 필수 정보를 모두 수정한다. <br/>PostingDataDAOManager에서 호출된다
	 * @param postingCode 특정 포스팅의 코드
	 * @param destination1 여행장소(시/도)
	 * @param destination2 여행장소(구)
	 * @param startDate 여행시작일
	 * @param endDate 여행종료일
	 * @param otherAge 원하는 상대 나이대
	 * @param otherGender 원하는 상대 성별
	 * @return true - 수정을 성공했을 경우 <br/> false - 수정을 실해했을 경우
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
