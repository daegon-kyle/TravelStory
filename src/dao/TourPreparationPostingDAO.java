package dao;
import dto.TourPreparationPostingDTO;
import dto.TourPreparationRecommendListDTO;
import java.util.*;
import java.sql.*;
/**
 * 여행 준비물 포스팅에 대한 상세 정보 및 검색 결과를 가져오기 위해 사용된다.<br/> PostingsDAOManager에서 사용한다
 * @author 문정현
 *
 */
public class TourPreparationPostingDAO {
	/**
	 * 전체 회원이 작성한 여행 준비물 포스팅의 상세 정보 목록을 가져오기 위한 쿼리문
	 */
	private final static String SELECT_ALL_SQL="select * from tour_preparation_posting_view order by writing_date DESC, like_num DESC";
	/**
	 * 전체 회원이 작성한 여행 준비물 포스팅 중 특정한 포스팅의 상세정보을 가져오기 위한 쿼리문
	 */
	private final static String SELECT_POSTING_SQL="select * from tour_preparation_posting_view where posting_code=? order by like_num DESC, writing_date DESC";
	/**
	 * 전체 회원이 작성한 여행 준비물 포스팅 중 특정 회원이 작성한 상세 정보들을 가져오기 위한 쿼리문
	 */
	private final static String SELECT_POSTINGS_BY_MEMBER_CODE_SQL="select * from tour_preparation_posting_view where member_code=? order by writing_date DESC, like_num DESC";
	/**
	 * 특정 회원이 작성한 여행 준비물 포스팅 중 특정한 소카테고리에 작성한 포스팅의 상세 정보 목록들을 가져오기 위한 쿼리문
	 */
	private final static String SELECT_POSTINGS_BY_MEMBER_CODE_AND_SUB_CATEGORY_CODE_SQL="select * from tour_preparation_posting_view where member_code=? and sub_category_code=? order by writing_date DESC , like_num DESC";
	/**
	 * 특정 회원이 작성한 여행 준비물 포스팅 중 특정 키워드가 제목 또는 내용에 만족하는 포스팅의 상세 정보 목록들을 가져오기 위한 쿼리문
	 */
	private final static String SELECT_POSTINGS_BY_MEMBER_CODE_AND_TITLE_OR_CONTENT_SQL="select * from tour_preparation_posting_view where member_code=? and (title LIKE ? or content LIKE ?) order by writing_date DESC , like_num DESC";
	/**
	 * 전체 회원이 봄에 작성한 여행 준비물 포스팅 중 여행 장소가 일치하는 포스팅의 상세정보 목록들을 가져오기 위한 쿼리문 
	 */
	private final static String SELECT_SPRING_POSTINGS_SQL="select * from tour_preparation_posting_view where destination1=? and destination2=? and TO_CHAR(TO_DATE(start_date), 'MM')='03' or TO_CHAR(TO_DATE(start_date), 'MM')='04' or TO_CHAR(TO_DATE(start_date), 'MM')='05' order by like_num DESC, writing_date DESC";
	/**
	 * 전체 회원이 여름에 작성한 여행 준비물 포스팅 중 여행 장소가 일치하는 포스팅의 상세정보 목록들을 가져오기 위한 쿼리문
	 */
	private final static String SELECT_SUMMER_POSTINGS_SQL="select * from tour_preparation_posting_view where destination1=? and destination2=? and TO_CHAR(TO_DATE(start_date), 'MM')='06' or TO_CHAR(TO_DATE(start_date), 'MM')='07' or TO_CHAR(TO_DATE(start_date), 'MM')='08' order by like_num DESC, writing_date DESC";
	/**
	 * 전체 회원이 가을에 작성한 여행 준비물 포스팅 중 여행 장소가 일치하는 포스팅의 상세정보 목록들을 가져오기 위한 쿼리문
	 */
	private final static String SELECT_FALL_POSTINGS_SQL="select * from tour_preparation_posting_view where destination1=? and destination2=? and TO_CHAR(TO_DATE(start_date), 'MM')='09' or TO_CHAR(TO_DATE(start_date), 'MM')='10' or TO_CHAR(TO_DATE(start_date), 'MM')='11' order by like_num DESC, writing_date DESC";
	/**
	 * 전체 회원이 겨울에 작성한 여행 준비물 포스팅 중 여행 장소가 일치하는 포스팅의 상세정보 목록들을 가져오기 위한 쿼리문
	 */
	private final static String SELECT_WINTER_POSTINGS_SQL="select * from tour_preparation_posting_view where destination1=? and destination2=? and TO_CHAR(TO_DATE(start_date), 'MM')='12' or TO_CHAR(TO_DATE(start_date), 'MM')='01' or TO_CHAR(TO_DATE(start_date), 'MM')='02' order by like_num DESC, writing_date DESC";
	/**
	 * 전체 회원이 작성한 여행 준비물 포스팅 중 제목 또는 내용이 특정 키워드에 만족하는 포스팅의 상세정보 목록들을 가져오기 위한 쿼리문
	 */
	private final static String SELECT_POSTINGS_BY_TITLE_OR_CONTENT_SQL="select * from tour_preparation_posting_view where title LIKE ? or content LIKE ? order by writing_date DESC, like_num DESC";
	/**
	 * 전체 회원이 작성한 여행 준비물 포스팅 중 작성자 이름으로 포스팅의 상세정보를 가져오기 위한 쿼리문
	 */
	private final static String SELECT_POSTINGS_BY_WRITER_NAME_SQL="select * from tour_preparation_posting_view where writer_name LIKE ? order by writing_date DESC, like_num DESC";
	/**
	 * 전체 회원이 봄에 작성한 여행 준비물 포스팅 중 여행 장소가 일치하는 포스팅의 검색 결과 목록을 가져오기 위한 쿼리문
	 */
	private final static String SELECT_SPRING_SEARCH_RESULT_LIST_SQL="select posting_code, title, writing_date, writer_name, like_num from tour_preparation_posting_view where destination1=? and destination2=? and TO_CHAR(TO_DATE(start_date), 'MM')='03' or TO_CHAR(TO_DATE(start_date), 'MM')='04' or TO_CHAR(TO_DATE(start_date), 'MM')='05' order by like_num DESC, writing_date DESC";
	/**
	 * 전체 회원이 여름에 작성한 여행 준비물 포스팅 중 여행 장소가 일치하는 포스팅의 검색 결과 목록을 가져오기 위한 쿼리문
	 */
	private final static String SELECT_SUMMER_SEARCH_RESULT_LIST_SQL="select posting_code, title, writing_date, writer_name, like_num from tour_preparation_posting_view where destination1=? and destination2=? and TO_CHAR(TO_DATE(start_date), 'MM')='06' or TO_CHAR(TO_DATE(start_date), 'MM')='07' or TO_CHAR(TO_DATE(start_date), 'MM')='08' order by like_num DESC, writing_date DESC";
	/**
	 * 전체 회원이 가을에 작성한 여행 준비물 포스팅 중 여행 장소가 일치하는 포스팅의 검색 결과 목록을 가져오기 위한 쿼리문
	 */
	private final static String SELECT_FALL_SEARCH_RESULT_LIST_SQL="select posting_code, title, writing_date, writer_name, like_num from tour_preparation_posting_view where destination1=? and destination2=? and TO_CHAR(TO_DATE(start_date), 'MM')='09' or TO_CHAR(TO_DATE(start_date), 'MM')='10' or TO_CHAR(TO_DATE(start_date), 'MM')='11' order by like_num DESC, writing_date DESC";
	/**
	 * 전체 회원이 겨울에 작성한 여행 준비물 포스팅 중 여행 장소가 일치하는 포스팅의 검색 결과 목록을 가져오기 위한 쿼리문
	 */
	private final static String SELECT_WINTER_SEARCH_RESULT_LIST_SQL="select posting_code, title, writing_date, writer_name, like_num from tour_preparation_posting_view where destination1=? and destination2=? and TO_CHAR(TO_DATE(start_date), 'MM')='12' or TO_CHAR(TO_DATE(start_date), 'MM')='01' or TO_CHAR(TO_DATE(start_date), 'MM')='02' order by like_num DESC, writing_date DESC";
	/**
	 * 전체 회원이 작성한 포스팅 중 여행 준비물 포스팅의 상세정보 목록을 가져온다.
	 * @return 전체 여행 준비물의 상세정보 목록
	 */
	public List<TourPreparationPostingDTO> selectAll(){
		List<TourPreparationPostingDTO> list = new ArrayList<TourPreparationPostingDTO>();
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_ALL_SQL);
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("posting_code");
				String purposeName = re.getString("posting_purpose_name");
				String memberCode = re.getString("member_code");
				String subCategoryCode = re.getString("sub_category_code");
				String subCategoryName = re.getString("sub_category_name");
				String title = re.getString("title");
				String destination1 = re.getString("destination1");
				String destination2 = re.getString("destination2");
				String writingDate = re.getString("writing_date");
				String writerName = re.getString("writer_name");
				String startDate = re.getString("start_date");
				String endDate = re.getString("end_date");
				String content = re.getString("content");
				int likeNum = re.getInt("like_num");
				list.add(new TourPreparationPostingDTO(code, purposeName, memberCode, subCategoryCode, subCategoryName, title, destination1, destination2, writingDate, writerName, startDate, endDate, content, likeNum));
				
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally{
			try{
				re.close();
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
	 * 전체 회원이 작성한 여행 준비물 포스팅 중 특정 포스팅 한개를 가져온다. <br/>PostingsDAOManger에서 호출한다 
	 * @param postingCode 가져올 포스팅의 코드
	 * @return 하나의 여행 준비물 포스팅의 상세정보
	 */
	public TourPreparationPostingDTO selectPosting(String postingCode){
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		TourPreparationPostingDTO dto = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_POSTING_SQL);
			pre.setString(1, postingCode);
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("posting_code");
				String purposeName = re.getString("posting_purpose_name");
				String memberCode = re.getString("member_code");
				String subCategoryCode = re.getString("sub_category_code");
				String subCategoryName = re.getString("sub_category_name");
				String title = re.getString("title");
				String destination1 = re.getString("destination1");
				String destination2 = re.getString("destination2");
				String writingDate = re.getString("writing_date");
				String writerName = re.getString("writer_name");
				String startDate = re.getString("start_date");
				String endDate = re.getString("end_date");
				String content = re.getString("content");
				int likeNum = re.getInt("like_num");
				dto = new TourPreparationPostingDTO(code, purposeName, memberCode, subCategoryCode, subCategoryName, title, destination1, destination2, writingDate, writerName, startDate, endDate, content, likeNum);
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally{
			try{
				re.close();
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
	 * 전체 회원이 작성한 여행 준비물 포스팅 중 특정 회원이 작성한 포스팅의 상세정보를 가져온다 <br/>PostingsDAOManger에서 호출한다
	 * @param memberCode 특정 회원의 코드
	 * @return 득정 회원이 작성한 여행 일정 포스팅의 상세 정보 목록
	 */
	public List<TourPreparationPostingDTO> selectPostings(String memberCode){
		List<TourPreparationPostingDTO> list = new ArrayList<TourPreparationPostingDTO>();
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_POSTINGS_BY_MEMBER_CODE_SQL);
			pre.setString(1, memberCode);
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("posting_code");
				String purposeName = re.getString("posting_purpose_name");
				String memberCode1 = re.getString("member_code");
				String subCategoryCode = re.getString("sub_category_code");
				String subCategoryName = re.getString("sub_category_name");
				String title = re.getString("title");
				String destination1 = re.getString("destination1");
				String destination2 = re.getString("destination2");
				String writingDate = re.getString("writing_date");
				String writerName = re.getString("writer_name");
				String startDate = re.getString("start_date");
				String endDate = re.getString("end_date");
				String content = re.getString("content");
				int likeNum = re.getInt("like_num");
				list.add(new TourPreparationPostingDTO(code, purposeName, memberCode1, subCategoryCode, subCategoryName, title, destination1, destination2, writingDate, writerName, startDate, endDate, content, likeNum));
				
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally{
			try{
				re.close();
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
	 * 전체 회원이 작성한 여행 준비물 포스팅 중 특정 회원이 특정 소카테고리에 작성한 포스팅의 상세 정보들을 가져온다. <br/>PostingsDAOManger에서 호출한다
	 * @param memberCode 특정 회원의 코드
	 * @param subCategoryCode 특정 회원의 소카테고리 코드
	 * @return 여행 준비물 포스팅의 상세 정보 목록
	 */
	public List<TourPreparationPostingDTO> selectPostings(String memberCode, String subCategoryCode){
		List<TourPreparationPostingDTO> list = new ArrayList<TourPreparationPostingDTO>();
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_POSTINGS_BY_MEMBER_CODE_AND_SUB_CATEGORY_CODE_SQL);
			pre.setString(1, memberCode);
			pre.setString(2, subCategoryCode);
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("posting_code");
				String purposeName = re.getString("posting_purpose_name");
				String memberCode1 = re.getString("member_code");
				String subCategoryCode1 = re.getString("sub_category_code");
				String subCategoryName = re.getString("sub_category_name");
				String title = re.getString("title");
				String destination1 = re.getString("destination1");
				String destination2 = re.getString("destination2");
				String writingDate = re.getString("writing_date");
				String writerName = re.getString("writer_name");
				String startDate = re.getString("start_date");
				String endDate = re.getString("end_date");
				String content = re.getString("content");
				int likeNum = re.getInt("like_num");
				list.add(new TourPreparationPostingDTO(code, purposeName, memberCode1, subCategoryCode1, subCategoryName, title, destination1, destination2, writingDate, writerName, startDate, endDate, content, likeNum));
				
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally{
			try{
				re.close();
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
	 * 특정 회원이 작성한 여행 준비물 포스팅 중 제목 또는 내용이 특정 키워드를 만족하는 포스팅의 상세정보 목록을 가져온다. <br/>PostingsDAOManger에서 호출한다
	 * @param memberCode 특정 회원의 코드
	 * @param key 특정 키워드
	 * @return 특정 키워드에 만족하는 여행 준비물 포스팅의 상세정보 목록
	 */
	public List<TourPreparationPostingDTO> selectPostingsOnlyMember(String memberCode, String key){
		List<TourPreparationPostingDTO> list = new ArrayList<TourPreparationPostingDTO>();
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_POSTINGS_BY_MEMBER_CODE_AND_TITLE_OR_CONTENT_SQL);
			pre.setString(1, memberCode);
			pre.setString(2, "%"+key+"%");
			pre.setString(3, "%"+key+"%");
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("posting_code");
				String purposeName = re.getString("posting_purpose_name");
				String memberCode1 = re.getString("member_code");
				String subCategoryCode = re.getString("sub_category_code");
				String subCategoryName = re.getString("sub_category_name");
				String title = re.getString("title");
				String destination1 = re.getString("destination1");
				String destination2 = re.getString("destination2");
				String writingDate = re.getString("writing_date");
				String writerName = re.getString("writer_name");
				String startDate = re.getString("start_date");
				String endDate = re.getString("end_date");
				String content = re.getString("content");
				int likeNum = re.getInt("like_num");
				list.add(new TourPreparationPostingDTO(code, purposeName, memberCode1, subCategoryCode, subCategoryName, title, destination1, destination2, writingDate, writerName, startDate, endDate, content, likeNum));
				
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally{
			try{
				re.close();
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
	 * 전체 회원이  3, 4, 5월에 작성한 여행 준비물  포스팅 중 목적지가 일치하는 포스팅의 상세정보목록을 가져온다. <br/>PostingsDAOManger에서 호출한다  
	 * @param destination1 여행장소(시/도)
	 * @param destination2 여행장소(구)
	 * @return 봄에 작성한 여행 준비물 포스팅 중 목적지가 일치하는 포스팅의 상세정보 목록
	 */
	public List<TourPreparationPostingDTO> selectSpringPostings(String destination1, String destination2){
		List<TourPreparationPostingDTO> list = new ArrayList<TourPreparationPostingDTO>();
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_SPRING_POSTINGS_SQL);
			pre.setString(1, "%"+destination1+"%");
			pre.setString(2, "%"+destination2+"%");
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("posting_code");
				String purposeName = re.getString("posting_purpose_name");
				String memberCode = re.getString("member_code");
				String subCategoryCode = re.getString("sub_category_code");
				String subCategoryName = re.getString("sub_category_name");
				String title = re.getString("title");
				String destination3 = re.getString("destination1");
				String destination4 = re.getString("destination2");
				String writingDate = re.getString("writing_date");
				String writerName = re.getString("writer_name");
				String startDate = re.getString("start_date");
				String endDate = re.getString("end_date");
				String content = re.getString("content");
				int likeNum = re.getInt("like_num");
				list.add(new TourPreparationPostingDTO(code, purposeName, memberCode, subCategoryCode, subCategoryName, title, destination3, destination4, writingDate, writerName, startDate, endDate, content, likeNum));
				
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally{
			try{
				re.close();
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
	 * 전체 회원이  6, 7, 8월에 작성한 여행 준비물  포스팅 중 목적지가 일치하는 포스팅의 상세정보목록을 가져온다. <br/>PostingsDAOManger에서 호출한다
	 * @param destination1 여행장소 (시/도)
	 * @param destination2 여행 장소(구)
	 * @return 여름에 작성한 여행 준비물 포스팅 중 목적지가 일치하는 포스팅의 상세정보 목록
	 */
	public List<TourPreparationPostingDTO> selectSummerPostings(String destination1, String destination2){
		List<TourPreparationPostingDTO> list = new ArrayList<TourPreparationPostingDTO>();
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_SUMMER_POSTINGS_SQL);
			pre.setString(1, "%"+destination1+"%");
			pre.setString(2, "%"+destination2+"%");
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("posting_code");
				String purposeName = re.getString("posting_purpose_name");
				String memberCode = re.getString("member_code");
				String subCategoryCode = re.getString("sub_category_code");
				String subCategoryName = re.getString("sub_category_name");
				String title = re.getString("title");
				String destination3 = re.getString("destination1");
				String destination4 = re.getString("destination2");
				String writingDate = re.getString("writing_date");
				String writerName = re.getString("writer_name");
				String startDate = re.getString("start_date");
				String endDate = re.getString("end_date");
				String content = re.getString("content");
				int likeNum = re.getInt("like_num");
				list.add(new TourPreparationPostingDTO(code, purposeName, memberCode, subCategoryCode, subCategoryName, title, destination3, destination4, writingDate, writerName, startDate, endDate, content, likeNum));
				
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally{
			try{
				re.close();
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
	 * 전체 회원이  9, 10, 11월에 작성한 여행 준비물  포스팅 중 목적지가 일치하는 포스팅의 상세정보목록을 가져온다. <br/>PostingsDAOManger에서 호출한다
	 * @param destination1 여행장소(시/도)
	 * @param destination2 여행장소(구)
	 * @return 가을에 작성한 여행 준비물 포스팅 중 목적지가 일치하는 포스팅의 상세정보 목록
	 */
	public List<TourPreparationPostingDTO> selectFallPostings(String destination1, String destination2){
		List<TourPreparationPostingDTO> list = new ArrayList<TourPreparationPostingDTO>();
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_FALL_POSTINGS_SQL);
			pre.setString(1, "%"+destination1+"%");
			pre.setString(2, "%"+destination2+"%");
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("posting_code");
				String purposeName = re.getString("posting_purpose_name");
				String memberCode = re.getString("member_code");
				String subCategoryCode = re.getString("sub_category_code");
				String subCategoryName = re.getString("sub_category_name");
				String title = re.getString("title");
				String destination3 = re.getString("destination1");
				String destination4 = re.getString("destination2");
				String writingDate = re.getString("writing_date");
				String writerName = re.getString("writer_name");
				String startDate = re.getString("start_date");
				String endDate = re.getString("end_date");
				String content = re.getString("content");
				int likeNum = re.getInt("like_num");
				list.add(new TourPreparationPostingDTO(code, purposeName, memberCode, subCategoryCode, subCategoryName, title, destination3, destination4, writingDate, writerName, startDate, endDate, content, likeNum));
				
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally{
			try{
				re.close();
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
	 * 전체 회원이  11, 12, 1월에 작성한 여행 준비물  포스팅 중 목적지가 일치하는 포스팅의 상세정보목록을 가져온다. <br/>PostingsDAOManger에서 호출한다
	 * @param destination1 여행장소(시/도)
	 * @param destination2 여행장소(구)
	 * @return 겨울에 작성한 여행 준비물 포스팅 중 목적지가 일치하는 포스팅의 상세정보 목록
	 */
	public List<TourPreparationPostingDTO> selectWinterPostings(String destination1, String destination2){
		List<TourPreparationPostingDTO> list = new ArrayList<TourPreparationPostingDTO>();
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_WINTER_POSTINGS_SQL);
			pre.setString(1, "%"+destination1+"%");
			pre.setString(2, "%"+destination2+"%");
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("posting_code");
				String purposeName = re.getString("posting_purpose_name");
				String memberCode = re.getString("member_code");
				String subCategoryCode = re.getString("sub_category_code");
				String subCategoryName = re.getString("sub_category_name");
				String title = re.getString("title");
				String destination3 = re.getString("destination1");
				String destination4 = re.getString("destination2");
				String writingDate = re.getString("writing_date");
				String writerName = re.getString("writer_name");
				String startDate = re.getString("start_date");
				String endDate = re.getString("end_date");
				String content = re.getString("content");
				int likeNum = re.getInt("like_num");
				list.add(new TourPreparationPostingDTO(code, purposeName, memberCode, subCategoryCode, subCategoryName, title, destination3, destination4, writingDate, writerName, startDate, endDate, content, likeNum));
				
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally{
			try{
				re.close();
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
	 * 전체 회원이 작성한 여행 준비물 포스팅 중 제목 또는 내용에 특정 키워드에 만족하는 포스팅의 상세정보 목록을 가져온다 <br/>PostingsDAOManger에서 호출한다
	 * @param key 특정 키워드
	 * @return 특정 키워드에 만족하는 여행 준비물 포스팅의 상세정보 목록
	 */
	public List<TourPreparationPostingDTO> selectPostingsAll(String key){
		List<TourPreparationPostingDTO> list = new ArrayList<TourPreparationPostingDTO>();
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_POSTINGS_BY_TITLE_OR_CONTENT_SQL);
			pre.setString(1, "%"+key+"%");
			pre.setString(2, "%"+key+"%");
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("posting_code");
				String purposeName = re.getString("posting_purpose_name");
				String memberCode = re.getString("member_code");
				String subCategoryCode = re.getString("sub_category_code");
				String subCategoryName = re.getString("sub_category_name");
				String title = re.getString("title");
				String destination1 = re.getString("destination1");
				String destination2 = re.getString("destination2");
				String writingDate = re.getString("writing_date");
				String writerName = re.getString("writer_name");
				String startDate = re.getString("start_date");
				String endDate = re.getString("end_date");
				String content = re.getString("content");
				int likeNum = re.getInt("like_num");
				list.add(new TourPreparationPostingDTO(code, purposeName, memberCode, subCategoryCode, subCategoryName, title, destination1, destination2, writingDate, writerName, startDate, endDate, content, likeNum));
				
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally{
			try{
				re.close();
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
	 * 전체 회원이 작성한 여행 준비물 포스팅 중 작성자의 이름을 이용하여 포스팅의 상세정보목록을 가져온다. <br/>사용안함
	 * @param writerName 포스팅 작성자의 이름
	 * @return 작성자의 이름에 만족하는 포스팅의 상세정보 목록
	 */
	public List<TourPreparationPostingDTO> selectPostingsAllByWriterName(String writerName){
		List<TourPreparationPostingDTO> list = new ArrayList<TourPreparationPostingDTO>();
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_POSTINGS_BY_WRITER_NAME_SQL);
			pre.setString(1, "%"+writerName+"%");
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("posting_code");
				String purposeName = re.getString("posting_purpose_name");
				String memberCode = re.getString("member_code");
				String subCategoryCode = re.getString("sub_category_code");
				String subCategoryName = re.getString("sub_category_name");
				String title = re.getString("title");
				String destination1 = re.getString("destination1");
				String destination2 = re.getString("destination2");
				String writingDate = re.getString("writing_date");
				String writerName1 = re.getString("writer_name");
				String startDate = re.getString("start_date");
				String endDate = re.getString("end_date");
				String content = re.getString("content");
				int likeNum = re.getInt("like_num");
				list.add(new TourPreparationPostingDTO(code, purposeName, memberCode, subCategoryCode, subCategoryName, title, destination1, destination2, writingDate, writerName1, startDate, endDate, content, likeNum));
				
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally{
			try{
				re.close();
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
	 * 3, 4, 5 월에 작성한 여행 준비물 포스팅 중 회원이 입력한 조건에 만족하는 포스팅을 검색 한 후 검색 결과 목록을 가져온다. <br/>PostingsDAOManger에서 호출한다
	 * @param destination1 여행장소(시/도)
	 * @param destination2 여행장소(구)
	 * @return 봄에 작성한 여행 준비물 포스팅 중 검색한 결과 목록
	 */
	public List<TourPreparationRecommendListDTO> selectSpringRecommendResultList(String destination1, String destination2){
		List<TourPreparationRecommendListDTO> list = new ArrayList<TourPreparationRecommendListDTO>();
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_SPRING_SEARCH_RESULT_LIST_SQL);
			pre.setString(1, "%"+destination1+"%");
			pre.setString(2, "%"+destination2+"%");
			re = pre.executeQuery();
			System.out.println("while문 안에서...");
			while(re.next()){
				String code = re.getString("posting_code");
				String title = re.getString("title");
				String writingDate = re.getString("writing_date");
				String writerName = re.getString("writer_name");
				int likeNum = re.getInt("like_num");
				System.out.println(code+", "+title+", "+writingDate+", "+writerName+", "+likeNum);
				list.add(new TourPreparationRecommendListDTO(code,title, writingDate, writerName, likeNum));
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally{
			try{
				re.close();
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
	 * 6, 7, 8 월에 작성한 여행 준비물 포스팅 중 회원이 입력한 조건에 만족하는 포스팅을 검색 한 후 검색 결과 목록을 가져온다.<br/>PostingsDAOManger에서 호출한다
	 * @param destination1 여행장소(시/도)
	 * @param destination2 여행장소(구)
	 * @return 여름에 작성한 여행 준비물 포스팅 중 검색한 결과 목록
	 */
	public List<TourPreparationRecommendListDTO> selectSummerRecommendResultList(String destination1, String destination2){
		List<TourPreparationRecommendListDTO> list = new ArrayList<TourPreparationRecommendListDTO>();
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_SUMMER_SEARCH_RESULT_LIST_SQL);
			pre.setString(1, "%"+destination1+"%");
			pre.setString(2, "%"+destination2+"%");
			re = pre.executeQuery();
			System.out.println("while문 안에서...");
			while(re.next()){
				String code = re.getString("posting_code");
				String title = re.getString("title");
				String writingDate = re.getString("writing_date");
				String writerName = re.getString("writer_name");
				int likeNum = re.getInt("like_num");
				System.out.println(code+", "+title+", "+writingDate+", "+writerName+", "+likeNum);
				list.add(new TourPreparationRecommendListDTO(code,title, writingDate, writerName, likeNum));
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally{
			try{
				re.close();
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
	 * 9, 10, 11 월에 작성한 여행 준비물 포스팅 중 회원이 입력한 조건에 만족하는 포스팅을 검색 한 후 검색 결과 목록을 가져온다.<br/>PostingsDAOManger에서 호출한다
	 * @param destination1 여행장소(시/도)
	 * @param destination2 여행장소(구)
	 * @return 가을에 작성한 여행 준비물 포스팅 중 검색한 결과 목록
	 */
	public List<TourPreparationRecommendListDTO> selectFallRecommendResultList(String destination1, String destination2){
		List<TourPreparationRecommendListDTO> list = new ArrayList<TourPreparationRecommendListDTO>();
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_FALL_SEARCH_RESULT_LIST_SQL);
			pre.setString(1, "%"+destination1+"%");
			pre.setString(2, "%"+destination2+"%");
			re = pre.executeQuery();
			System.out.println("while문 안에서...");
			while(re.next()){
				String code = re.getString("posting_code");
				String title = re.getString("title");
				String writingDate = re.getString("writing_date");
				String writerName = re.getString("writer_name");
				int likeNum = re.getInt("like_num");
				System.out.println(code+", "+title+", "+writingDate+", "+writerName+", "+likeNum);
				list.add(new TourPreparationRecommendListDTO(code,title, writingDate, writerName, likeNum));
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally{
			try{
				re.close();
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
	 * 12, 1, 2 월에 작성한 여행 준비물 포스팅 중 회원이 입력한 조건에 만족하는 포스팅을 검색 한 후 검색 결과 목록을 가져온다.<br/>PostingsDAOManger에서 호출한다
	 * @param destination1 여행장소(시/도)
	 * @param destination2 여행장소(구)
	 * @return 겨울에 작성한 여행 준비물 포스팅 중 검색한 결과 목록
	 */
	public List<TourPreparationRecommendListDTO> selectWinterRecommendResultList(String destination1, String destination2){
		List<TourPreparationRecommendListDTO> list = new ArrayList<TourPreparationRecommendListDTO>();
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_WINTER_SEARCH_RESULT_LIST_SQL);
			pre.setString(1, "%"+destination1+"%");
			pre.setString(2, "%"+destination2+"%");
			re = pre.executeQuery();
			System.out.println("while문 안에서...");
			while(re.next()){
				String code = re.getString("posting_code");
				String title = re.getString("title");
				String writingDate = re.getString("writing_date");
				String writerName = re.getString("writer_name");
				int likeNum = re.getInt("like_num");
				System.out.println(code+", "+title+", "+writingDate+", "+writerName+", "+likeNum);
				list.add(new TourPreparationRecommendListDTO(code,title, writingDate, writerName, likeNum));
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally{
			try{
				re.close();
				pre.close();
				conn.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		return list;
	}
}
