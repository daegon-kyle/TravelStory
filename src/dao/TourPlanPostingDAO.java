// 0721 문정현
package dao;
import dto.TourPlanPostingDTO;
import java.util.*;
import java.sql.*;
import dto.TourPlanRecommendListDTO;
/**
 * 여행 일정 포스팅의 상세 정보 및 검색 결과를 가져오기 위해 사용된다.<br/>PostingsDAOManger에서 사용된다
 * @author 문정현
 *
 */
public class TourPlanPostingDAO {
	/**
	 * 전체 회원의 여행 일정 포스팅의 상세 정보를 가져오기 위한 쿼리문
	 */
	private static final String SELECT_ALL_SQL="select * from tour_plan_posting_view order by like_num DESC, writing_date DESC";
	/**
	 * 특정한 한개의 포스팅의 상세 정보를 가져오기 위한 쿼리문
	 */
	private static final String SELECT_POSTING_SQL="select * from tour_plan_posting_view where posting_code=? order by like_num DESC, writing_date DESC";
	/**
	 * 특정 회원이 작성한 여행 일정 포스팅의 상세 정보를 가져오기 위한 쿼리문
	 */
	private static final String SELECT_POSTINGS_BY_MEMBER_CODE_SQL="select * from tour_plan_posting_view where member_code=? order by like_num DESC, writing_date DESC";
	/**
	 * 특정 회원이 특정한 소 카테고리에 작성한 여행 일정 포스팅의 상세 정보를 가져오기 위한 쿼리문
	 */
	private static final String SELECT_POSTINGS_BY_SUB_CATEGORY_SQL="select * from tour_plan_posting_view where member_code=? and sub_category_code=? order by like_num DESC, writing_date DESC";
	/**
	 * 특정 회원이 작성한 여행 일정 포스팅 중 제목 또는 내용에 특정 키워드를 검색해 상세정보를 가져오기 위한 쿼리문
	 */
	private static final String SELECT_POSTINGS_BY_MEMBER_AND_TITLE_OR_CONTENT_SQL="select * from tour_plan_posting_view where member_code=? and (title LIKE ? or content LIKE ?) order by like_num DESC, writing_date DESC";
	/**
	 * 전체 회원이 작성한 여행 일정 포스팅 중 조건에 맞는 포스팅의 상세 정보를 가져오기 위한 쿼리문
	 */
	private static final String SELECT_POSTINGS_BY_CONDITIONS_SQL="select * from tour_plan_posting_view where destination1=? and destination2=? and restaurant_preference BETWEEN ? AND ? and healing_preference BETWEEN ? AND ? and attraction_preference BETWEEN ? AND ? and shopping_preference BETWEEN ? AND ? and etc_preference BETWEEN ? AND ? order by like_num DESC, writing_date DESC";
	/**
	 * 전체 회원이 작성한 여행 일정 포스팅 중 제목 또는 내용을 특정 키워드로 검색해 가져오기 위한 쿼리문
	 */
	private static final String SELECT_POSTINGS_BY_TITLE_OR_CONTENT_SQL="select * from tour_plan_posting_view where title LIKE ? or content LIKE ? order by like_num DESC, writing_date DESC";
	/**
	 * 전체 회원이 작성한 여행 일정 포스팅 중 작성자의 이름을 특정 키워드로 검색해 가져오기 위한 쿼리문
	 */
	private static final String SELECT_POSTINGS_BY_WRITER_NAME_SQL="select * from tour_plan_posting_view where writer_name LIKE ?";
	/**
	 * 전체 회원이 작성한 여행 일정 포스팅 중 조건에 맞는 포스팅 목록을 가져오기 위한 쿼리문
	 */
	private static final String SELECT_SEARCH_RESULT_LIST_SQL="select posting_code, title, writing_date, writer_name, like_num from tour_plan_posting_view where destination1 LIKE ? and destination2 LIKE ? and (restaurant_preference BETWEEN ? AND ?) and (healing_preference BETWEEN ? AND ?) and (attraction_preference BETWEEN ? AND ?) and (shopping_preference BETWEEN ? AND ?) and (etc_preference BETWEEN ? AND ?)  order by like_num DESC, writing_date DESC";
	/**
	 * default constructor
	 */
	public TourPlanPostingDAO(){
		
	}
	/**
	 * 전체 회원이 작성한 여행 일정 포스팅의 상세 정보를 모두 가져온다. <br/>사용안함
	 * 
	 * @return 전체 회원의 여행 일정 포스팅의 상세 정보 목록
	 */
	public List<TourPlanPostingDTO> selectAll(){
		List<TourPlanPostingDTO> list = new ArrayList<TourPlanPostingDTO>();
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_ALL_SQL);
			re = pre.executeQuery();
			while(re.next()){
				String postingCode = re.getString("posting_code");
				String purposeName = re.getString("posting_purpose_name");
				String memberCode = re.getString("member_code");
				String subCategoryCode = re.getString("sub_category_code");
				String subCategoryName = re.getString("sub_category_name");
				String title = re.getString("title");
				String destination1 = re.getString("destination1");
				String destination2 = re.getString("destination2");
				String writingDate = re.getString("writing_date");
				String writerName = re.getString("writer_name");
				String restaurantPre = re.getString("restaurant_preference");
				String healingPre= re.getString("healing_preference");
				String attractionPre = re.getString("attraction_preference");
				String shoppingPre = re.getString("shopping_preference");
				String etcPre = re.getString("etc_preference");
				String content = re.getString("content");
				int likeNum = re.getInt("like_num");
				list.add(new TourPlanPostingDTO(postingCode, purposeName, memberCode, subCategoryCode, subCategoryName, title, destination1, destination2, writingDate, writerName, restaurantPre, healingPre, attractionPre, shoppingPre, etcPre, content, likeNum));
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
	 * 가져오고 싶은 특정 한개의 여행일정 포스팅 정보를 가져온다. <br/>PostingsDAOManger에서 호출한다
	 * @param postingCode 가져오고 싶은 여행 일정 포스팅의 코드
	 * @return 한 개의 여행 일정 포스팅의 상세정보
	 */
	public TourPlanPostingDTO selectPosting(String postingCode){
		TourPlanPostingDTO dto = null;
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_POSTING_SQL);
			pre.setString(1, postingCode);
			re = pre.executeQuery();
			while(re.next()){
				String postingCode1 = re.getString("posting_code");
				String purposeName = re.getString("posting_purpose_name");
				String memberCode = re.getString("member_code");
				String subCategoryCode = re.getString("sub_category_code");
				String subCategoryName = re.getString("sub_category_name");
				String title = re.getString("title");
				String destination1 = re.getString("destination1");
				String destination2 = re.getString("destination2");
				String writingDate = re.getString("writing_date");
				String writerName = re.getString("writer_name");
				String restaurantPre = re.getString("restaurant_preference");
				String healingPre= re.getString("healing_preference");
				String attractionPre = re.getString("attraction_preference");
				String shoppingPre = re.getString("shopping_preference");
				String etcPre = re.getString("etc_preference");
				String content = re.getString("content");
				int likeNum = re.getInt("like_num");
				dto = new TourPlanPostingDTO(postingCode1, purposeName, memberCode, subCategoryCode, subCategoryName, title, destination1, destination2, writingDate, writerName, restaurantPre, healingPre, attractionPre, shoppingPre, etcPre, content, likeNum);
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
	 * 특정 회원이 작성한 모든 여행 일정 포스팅의 상세정보를 가져온다.<br/>PostingsDAOManger에서 호출한다
	 * @param memberCode 여행 일정 포스팅의 상세정보를  가져오고 싶은 특정 회원의 코드
	 * @return 특정 회원이 작성한 모든 여행 일정 포스팅의 상세정보 목록
	 */
	public List<TourPlanPostingDTO> selectPostings(String memberCode){
		List<TourPlanPostingDTO> list = new ArrayList<TourPlanPostingDTO>();
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_POSTINGS_BY_MEMBER_CODE_SQL);
			pre.setString(1, memberCode);
			re = pre.executeQuery();
			while(re.next()){
				String postingCode = re.getString("posting_code");
				String purposeName = re.getString("posting_purpose_name");
				String memberCode1 = re.getString("member_code");
				String subCategoryCode = re.getString("sub_category_code");
				String subCategoryName = re.getString("sub_category_name");
				String title = re.getString("title");
				String destination1 = re.getString("destination1");
				String destination2 = re.getString("destination2");
				String writingDate = re.getString("writing_date");
				String writerName = re.getString("writer_name");
				String restaurantPre = re.getString("restaurant_preference");
				String healingPre= re.getString("healing_preference");
				String attractionPre = re.getString("attraction_preference");
				String shoppingPre = re.getString("shopping_preference");
				String etcPre = re.getString("etc_preference");
				String content = re.getString("content");
				int likeNum = re.getInt("like_num");
				list.add(new TourPlanPostingDTO(postingCode, purposeName, memberCode1, subCategoryCode, subCategoryName, title, destination1, destination2, writingDate, writerName, restaurantPre, healingPre, attractionPre, shoppingPre, etcPre, content, likeNum));
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
	 * 특정 회원이 특정 소카테고리에 작성한 모든 여행 일정 포스팅의 상세 정보를 가져온다 <br/>PostingsDAOManger에서 호출한다
	 * @param memberCode 특정 회원의 코드
	 * @param subCategoryCode 특정 회원이 생성한 소카테고리의 코드
	 * @return 특정 회원이 하나의 소카테고리에 작성한 모든 여행 일정 포스팅의 상세 정보 목록
	 */
	public List<TourPlanPostingDTO> selectPostings(String memberCode, String subCategoryCode){
		List<TourPlanPostingDTO> list = new ArrayList<TourPlanPostingDTO>();
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_POSTINGS_BY_SUB_CATEGORY_SQL);
			pre.setString(1, memberCode);
			pre.setString(2, subCategoryCode);
			re = pre.executeQuery();
			while(re.next()){
				String postingCode = re.getString("posting_code");
				String purposeName = re.getString("posting_purpose_name");
				String memberCode1 = re.getString("member_code");
				String subCategoryCode1 = re.getString("sub_category_code");
				String subCategoryName = re.getString("sub_category_name");
				String title = re.getString("title");
				String destination1 = re.getString("destination1");
				String destination2 = re.getString("destination2");
				String writingDate = re.getString("writing_date");
				String writerName = re.getString("writer_name");
				String restaurantPre = re.getString("restaurant_preference");
				String healingPre= re.getString("healing_preference");
				String attractionPre = re.getString("attraction_preference");
				String shoppingPre = re.getString("shopping_preference");
				String etcPre = re.getString("etc_preference");
				String content = re.getString("content");
				int likeNum = re.getInt("like_num");
				list.add(new TourPlanPostingDTO(postingCode, purposeName, memberCode1, subCategoryCode1, subCategoryName, title, destination1, destination2, writingDate, writerName, restaurantPre, healingPre, attractionPre, shoppingPre, etcPre, content, likeNum));
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
	 * 특정 회원이 작성한 여행 일정 포스팅 중 제목 또는 내용에서 특정 키워드와 일치하는 포스팅의 상세정보를 가져온다. <br/>PostingsDAOManger에서 호출한다
	 * @param memberCode 특정회원의 코드
	 * @param key 검색하고 싶은 키워드
	 * @return 특정 회원이 작성한 여행 일정 포스팅 중 키워드와 일치하는 제목 또는 내용을 가진 여행 일정 포스팅 목록
	 */
	public List<TourPlanPostingDTO> selectPostingsOnlyMember(String memberCode, String key){
		List<TourPlanPostingDTO> list = new ArrayList<TourPlanPostingDTO>();
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_POSTINGS_BY_MEMBER_AND_TITLE_OR_CONTENT_SQL);
			pre.setString(1, memberCode);
			pre.setString(2, "%"+key+"%");
			pre.setString(3, "%"+key+"%");
			re = pre.executeQuery();
			while(re.next()){
				String postingCode = re.getString("posting_code");
				String purposeName = re.getString("posting_purpose_name");
				String memberCode1 = re.getString("member_code");
				String subCategoryCode = re.getString("sub_category_code");
				String subCategoryName = re.getString("sub_category_name");
				String title = re.getString("title");
				String destination1 = re.getString("destination1");
				String destination2 = re.getString("destination2");
				String writingDate = re.getString("writing_date");
				String writerName = re.getString("writer_name");
				String restaurantPre = re.getString("restaurant_preference");
				String healingPre= re.getString("healing_preference");
				String attractionPre = re.getString("attraction_preference");
				String shoppingPre = re.getString("shopping_preference");
				String etcPre = re.getString("etc_preference");
				String content = re.getString("content");
				int likeNum = re.getInt("like_num");
				list.add(new TourPlanPostingDTO(postingCode, purposeName, memberCode1, subCategoryCode, subCategoryName, title, destination1, destination2, writingDate, writerName, restaurantPre, healingPre, attractionPre, shoppingPre, etcPre, content, likeNum));
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
	 * 한 회원이 여행일정을 추천 받기 위해 입력한 정보와 일치하는 여행 일정 포스팅의 상세 정보를 가져온다.<br/>PostingsDAOManger에서 호출한다
	 * @param destination1 회원이 입력한 여행장소(시/도)
	 * @param destination2 회원이 입력한 여행장소(구)
	 * @param restaurantPreference 회원이 입력한 맛집 선호도
	 * @param healingPreference 회원이 입력한 힐링 선호도
	 * @param attractionPreference 회원이 입력한 관광명소 선호도
	 * @param shoppingPreference 회원이 입력한 쇼핑 선호도
	 * @param etcPreference 회원이 입력한 기타 선호도
	 * @return 한 회원이 입력한 정보와 일치하는 여행 일정 포스팅의 상세 정보
	 */
	public List<TourPlanPostingDTO> selectPostings(String destination1, String destination2, int restaurantPreference, int healingPreference, int attractionPreference, int shoppingPreference, int etcPreference){
		List<TourPlanPostingDTO> list = new ArrayList<TourPlanPostingDTO>();
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_POSTINGS_BY_CONDITIONS_SQL);
			pre.setString(1, destination1);
			pre.setString(2, destination2);
			pre.setInt(3, restaurantPreference-1);
			pre.setInt(4, restaurantPreference+1);
			pre.setInt(5, healingPreference-1);
			pre.setInt(6, healingPreference+1);
			pre.setInt(7, attractionPreference-1);
			pre.setInt(8, attractionPreference+1);
			pre.setInt(9, shoppingPreference-1);
			pre.setInt(10, shoppingPreference+1);
			pre.setInt(11, etcPreference-1);
			pre.setInt(12, etcPreference+1);
			re = pre.executeQuery();
			while(re.next()){
				String postingCode = re.getString("posting_code");
				String purposeName = re.getString("posting_purpose_name");
				String memberCode = re.getString("member_code");
				String subCategoryCode = re.getString("sub_category_code");
				String subCategoryName = re.getString("sub_category_name");
				String title = re.getString("title");
				String destination3 = re.getString("destination1");
				String destination4 = re.getString("destination2");
				String writingDate = re.getString("writing_date");
				String writerName = re.getString("writer_name");
				String restaurantPre = re.getString("restaurant_preference");
				String healingPre= re.getString("healing_preference");
				String attractionPre = re.getString("attraction_preference");
				String shoppingPre = re.getString("shopping_preference");
				String etcPre = re.getString("etc_preference");
				String content = re.getString("content");
				int likeNum = re.getInt("like_num");
				list.add(new TourPlanPostingDTO(postingCode, purposeName, memberCode, subCategoryCode, subCategoryName, title, destination3, destination4, writingDate, writerName, restaurantPre, healingPre, attractionPre, shoppingPre, etcPre, content, likeNum));
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
	 * 전체 회원이 작성한 여행 일정 포스팅 중 제목 또는 내용에서 특정 키워드와 일치하는 포스팅의 상세 정보를 가져온다.<br/>PostingsDAOManger에서 호출한다
	 * @param key 특정 키워드
	 * @return 특정 키워드와 일치하는 여행 일정 포스팅 목록
	 */
	public List<TourPlanPostingDTO> selectPostingsAll(String key){
		List<TourPlanPostingDTO> list = new ArrayList<TourPlanPostingDTO>();
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
				String postingCode = re.getString("posting_code");
				String purposeName = re.getString("posting_purpose_name");
				String memberCode = re.getString("member_code");
				String subCategoryCode = re.getString("sub_category_code");
				String subCategoryName = re.getString("sub_category_name");
				String title = re.getString("title");
				String destination1 = re.getString("destination1");
				String destination2 = re.getString("destination2");
				String writingDate = re.getString("writing_date");
				String writerName = re.getString("writer_name");
				String restaurantPre = re.getString("restaurant_preference");
				String healingPre= re.getString("healing_preference");
				String attractionPre = re.getString("attraction_preference");
				String shoppingPre = re.getString("shopping_preference");
				String etcPre = re.getString("etc_preference");
				String content = re.getString("content");
				int likeNum = re.getInt("like_num");
				list.add(new TourPlanPostingDTO(postingCode, purposeName, memberCode, subCategoryCode, subCategoryName, title, destination1, destination2, writingDate, writerName, restaurantPre, healingPre, attractionPre, shoppingPre, etcPre, content, likeNum));
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
	 * 사용 안함
	 * @param writerName
	 * @return
	 */
	public List<TourPlanPostingDTO> selectPostingsAllByWriterName(String writerName){
		List<TourPlanPostingDTO> list = new ArrayList<TourPlanPostingDTO>();
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_POSTINGS_BY_WRITER_NAME_SQL);
			pre.setString(1, "%"+writerName+"%");
			re = pre.executeQuery();
			while(re.next()){
				String postingCode = re.getString("posting_code");
				String purposeName = re.getString("posting_purpose_name");
				String memberCode = re.getString("member_code");
				String subCategoryCode = re.getString("sub_category_code");
				String subCategoryName = re.getString("sub_category_name");
				String title = re.getString("title");
				String destination1 = re.getString("destination1");
				String destination2 = re.getString("destination2");
				String writingDate = re.getString("writing_date");
				String writerName1 = re.getString("writer_name");
				String restaurantPre = re.getString("restaurant_preference");
				String healingPre= re.getString("healing_preference");
				String attractionPre = re.getString("attraction_preference");
				String shoppingPre = re.getString("shopping_preference");
				String etcPre = re.getString("etc_preference");
				String content = re.getString("content");
				int likeNum = re.getInt("like_num");
				list.add(new TourPlanPostingDTO(postingCode, purposeName, memberCode, subCategoryCode, subCategoryName, title, destination1, destination2, writingDate, writerName1, restaurantPre, healingPre, attractionPre, shoppingPre, etcPre, content, likeNum));
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
	 * 한 회원이 여행일정을 추천 받기 위해 입력한 정보와 일치하는 여행 일정 포스팅 검색 결과 목록을 가져온다. <br/>PostingsDAOManger에서 호출한다
	 * @param destination1 회원이 입력한 여행장소(시/도)
	 * @param destination2 회원이 입력한 여행장소(구)
	 * @param restaurantPreference 회원이 입력한 맛집 선호도
	 * @param healingPreference 회원이 입력한 힐링 선호도
	 * @param attractionPreference 회원이 입력한 관광명소 선호도
	 * @param shoppingPreference 회원이 입력한 쇼핑 선호도
	 * @param etcPreference 회원이 입력한 기타 선호도
	 * @return 회원이 입력한 정보와 일치하는 여행 일정 포스팅의 목록
	 */
	public List<TourPlanRecommendListDTO> selectRecommendResultList(String destination1, String destination2, int restaurantPreference, int healingPreference, int attractionPreference, int shoppingPreference, int etcPreference){
		List<TourPlanRecommendListDTO> list = new ArrayList<TourPlanRecommendListDTO>();
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_SEARCH_RESULT_LIST_SQL);
			pre.setString(1, "%"+destination1+"%");
			pre.setString(2, "%"+destination2+"%");
			pre.setInt(3, restaurantPreference-1);
			pre.setInt(4, restaurantPreference+1);
			pre.setInt(5, healingPreference-1);
			pre.setInt(6, healingPreference+1);
			pre.setInt(7, attractionPreference-1);
			pre.setInt(8, attractionPreference+1);
			pre.setInt(9, shoppingPreference-1);
			pre.setInt(10, shoppingPreference+1);
			pre.setInt(11, etcPreference-1);
			pre.setInt(12, etcPreference+1);
			re = pre.executeQuery();
			System.out.println("추천 결과dao메소드 안에서....");
			while(re.next()){
				String postingCode = re.getString("posting_code");
				String title = re.getString("title");
				String writingDate = re.getString("writing_date");
				String writerName = re.getString("writer_name");
				int likeNum = re.getInt("like_num");
				System.out.println(postingCode+", "+title+", "+writingDate+", "+writerName+", "+likeNum);
				list.add(new TourPlanRecommendListDTO(postingCode, title, writingDate, writerName, likeNum));
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
