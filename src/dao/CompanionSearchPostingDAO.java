package dao;
import dto.CompanionSearchPostingDTO;
import dto.CompanionSearchRecommendListDTO;
import java.util.*;
import java.sql.*;
/**
 * 동행자 찾기 포스팅의 상세 정보 및 검색 결과를 가져오기 위해 사용된다.<br/>PostingsDAOManger에서 사용된다
 * @author 문정현
 *
 */
public class CompanionSearchPostingDAO {
	/**
	 * 전체 회원이 작성한 동행자 찾기 포스팅을 가져오기 위한 쿼리문
	 */
	private final static String SELECT_ALL_SQL="select * from companion_search_posting_view order by reliability DESC, writing_date DESC";
	/**
	 * 동행자 찾기 포스팅 중 특정 포스팅을 가져오기 위한 쿼리문
	 */
	private final static String SELECT_POSTING__SQL="select * from companion_search_posting_view where posting_code=? order by reliability DESC, writing_date DESC";
	/**
	 * 특정 회원이 작성한 모든 동행자 찾기 포스팅을 가져오기 위한 쿼리문
	 */
	private final static String SELECT_POSTINGS_BY_MEMBER_CODE_SQL="select * from companion_search_posting_view where member_code=? order by reliability DESC, writing_date DESC";
	/**
	 * 특정 회원이 작성한 동행자 찾기 포스팅들 중 특정한 소카테고리에 작성한 포스팅을 가져오기 위한 쿼리문
	 */
	private final static String SELECT_POSTINGS_BY_MEMBER_CODE_AND_SUB_CATEGORY_SQL="select * from companion_search_posting_view where member_code=? and sub_category_code=? order by reliability DESC, writing_date DESC";
	/**
	 * 특정 회원이 작성한 모든 동행자 찾기 포스팅 중 제목 또는 내용에서 특정 키워드와 일치하는 것이 있는 포스팅을 가져오기 위한 쿼리문
	 */
	private final static String SELECT_POSTINGS_BY_MEMBER_CODE_AND_TITLE_OR_CONTENT_SQL="select * from companion_search_posting_view where member_code=? and (title LIKE ? or content LIKE ?) order by reliability DESC, writing_date DESC";
	/**
	 * 회원이 입력한 특정 조건들에 만족하는 동행자 찾기 포스팅을 가져오기 위한 쿼리문
	 */
	private final static String SELECT_POSTINGS_BY_CONDITIONS_SQL="select * from companion_search_posting_view where destination1=? and destination2=? and start_date>=? and end_date<=? and other_gender=? and other_age=? order by reliability DESC, writing_date DESC";
	/**
	 * 전체 회원이 작성한 동행자 찾기 포스팅 중 제목 또는 내용에 특정 키워드와 일치하는 포스팅을 가져오기 위한 쿼리문
	 */
	private final static String SELECT_POSTINGS_BY_TITLE_OR_CONTENT_SQL="select * from companion_search_posting_view where title LIKE ? or content LIKE ? order by reliability DESC, writing_date DESC";
	/**
	 * 전체 회원이 작성한 동행자 찾기 포스팅 중 특정 키워드가 작성자의 이름에 만족하는 포스팅의 상세정보 목록을 가져오기 위한 쿼리문
	 */
	private final static String SELECT_POSTINGS_BY_WRITER_NAME_SQL="select * from companion_search_posting_view where writer_name LIKE ? order by reliability DESC, writing_date DESC";
	/**
	 * 회원이 입력한 특정 조건에 만족하는 동행자 추천 목록을 가져오기 위한 쿼리문
	 */
	private final static String SELECT_RECOMMEND_RESULT_LIST_BY_CONDITIONS_SQL="select posting_code, title, writing_date, writer_name, reliability from companion_search_posting_view where destination1 LIKE ? and destination2 LIKE ? and start_date>=? and end_date<=? and other_gender=? and other_age=? order by reliability DESC, writing_date DESC";
	/**
	 * default constructor
	 */
	public CompanionSearchPostingDAO(){
		
	}
	/**
	 * 전체 회원이 작성한 포스팅 중 동행자 찾기 포스팅의 상세 보를 가져온다 <br/>사용안함
	 * @return 전체 회원이 작성한 동행자 찾기 포스팅의 상세정보 목록
	 */
	public List<CompanionSearchPostingDTO> selectAll(){
		Connection conn = null;
		PreparedStatement pre =  null;
		ResultSet re = null;
		List<CompanionSearchPostingDTO> list = new ArrayList<CompanionSearchPostingDTO>();
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_ALL_SQL);
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("posting_code");
				String purposeName = re.getString("posting_purpose_name");
				String memberCode= re.getString("member_code");
				String subCategoryCode = re.getString("sub_category_code");
				String subCategoryName = re.getString("sub_category_name");
				String title = re.getString("title");
				String destination1 = re.getString("destination1");
				String destination2 = re.getString("destination2");
				String writingDate = re.getString("writing_date");
				String name= re.getString("writer_name");
				String start=re.getString("start_date");
				String end=re.getString("end_date");
				String otherGender = re.getString("other_gender");
				int otherAge = re.getInt("other_age");
				String content = re.getString("content");
				int reliability = re.getInt("reliability");
				list.add(new CompanionSearchPostingDTO(code, purposeName, memberCode, subCategoryCode, subCategoryName, title, destination1, destination2, writingDate, name, start, end, otherGender, otherAge, content, reliability ));
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
	 * 전체 회원이 작성한 동행자 찾기 포스팅 중 특정한 포스팅의 상세정보를 가져온다.<br/>PostingsDAOManger에서 호출한다
	 * @param postingCode 특정한 동행자 찾기 포스팅의 코드
	 * @return 특정한 동행자 찾기 포스팅의 상세정보
	 */
	public CompanionSearchPostingDTO selectPosting(String postingCode){
		Connection conn = null;
		PreparedStatement pre =  null;
		ResultSet re = null;
		CompanionSearchPostingDTO dto = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_POSTING__SQL);
			pre.setString(1, postingCode);
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("posting_code");
				String purposeName = re.getString("posting_purpose_name");
				String memberCode= re.getString("member_code");
				String subCategoryCode = re.getString("sub_category_code");
				String subCategoryName = re.getString("sub_category_name");
				String title = re.getString("title");
				String destination1 = re.getString("destination1");
				String destination2 = re.getString("destination2");
				String writingDate = re.getString("writing_date");
				String name= re.getString("writer_name");
				String start=re.getString("start_date");
				String end=re.getString("end_date");
				String otherGender = re.getString("other_gender");
				int otherAge = re.getInt("other_age");
				String content = re.getString("content");
				int reliability = re.getInt("reliability");
				dto = new CompanionSearchPostingDTO(code, purposeName, memberCode, subCategoryCode, subCategoryName, title, destination1, destination2, writingDate, name, start, end, otherGender, otherAge, content, reliability );
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
	 * 특정 회원이 작성한 동행자 찾기 포스팅을 가져온다.<br/>PostingsDAOManger에서 호출한다
	 * @param memberCode 특정 회원의 코드
	 * @return 특정 회원이 작성한 동행자 찾기 포스팅의 상세정보 목록
	 */
	public List<CompanionSearchPostingDTO> selectPostings(String memberCode){
		Connection conn = null;
		PreparedStatement pre =  null;
		ResultSet re = null;
		List<CompanionSearchPostingDTO> list = new ArrayList<CompanionSearchPostingDTO>();
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_POSTINGS_BY_MEMBER_CODE_SQL);
			pre.setString(1, memberCode);
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("posting_code");
				String purposeName = re.getString("posting_purpose_name");
				String memberCode1= re.getString("member_code");
				String subCategoryCode = re.getString("sub_category_code");
				String subCategoryName = re.getString("sub_category_name");
				String title = re.getString("title");
				String destination1 = re.getString("destination1");
				String destination2 = re.getString("destination2");
				String writingDate = re.getString("writing_date");
				String name= re.getString("writer_name");
				String start=re.getString("start_date");
				String end=re.getString("end_date");
				String otherGender = re.getString("other_gender");
				int otherAge = re.getInt("other_age");
				String content = re.getString("content");
				int reliability = re.getInt("reliability");
				list.add(new CompanionSearchPostingDTO(code, purposeName, memberCode1, subCategoryCode, subCategoryName, title, destination1, destination2, writingDate, name, start, end, otherGender, otherAge, content, reliability ));
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
	 * 특정 회원이 작성한 동행자 찾기 포스팅 중 특정한 소카테고리에 작성한 포스팅의 상세정보 목록을 가져온다.<br/>PostingsDAOManger에서 호출한다
	 * @param memberCode 특정 회원의 코드
	 * @param subCategoryCode 특정 소카테고리의 코드
	 * @return 특정 회원이 한 소카테고리에 작성한 동행자 찾기 포스팅의 상세 정보 목록
	 */
	public List<CompanionSearchPostingDTO> selectPostings(String memberCode, String subCategoryCode){
		Connection conn = null;
		PreparedStatement pre =  null;
		ResultSet re = null;
		List<CompanionSearchPostingDTO> list = new ArrayList<CompanionSearchPostingDTO>();
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_POSTINGS_BY_MEMBER_CODE_AND_SUB_CATEGORY_SQL);
			pre.setString(1, memberCode);
			pre.setString(2, subCategoryCode);
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("posting_code");
				String purposeName = re.getString("posting_purpose_name");
				String memberCode1= re.getString("member_code");
				String subCategoryCode1 = re.getString("sub_category_code");
				String subCategoryName = re.getString("sub_category_name");
				String title = re.getString("title");
				String destination1 = re.getString("destination1");
				String destination2 = re.getString("destination2");
				String writingDate = re.getString("writing_date");
				String name= re.getString("writer_name");
				String start=re.getString("start_date");
				String end=re.getString("end_date");
				String otherGender = re.getString("other_gender");
				int otherAge = re.getInt("other_age");
				String content = re.getString("content");
				int reliability = re.getInt("reliability");
				list.add(new CompanionSearchPostingDTO(code, purposeName, memberCode1, subCategoryCode1, subCategoryName, title, destination1, destination2, writingDate, name, start, end, otherGender, otherAge, content, reliability ));
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
	 * 특정 회원이 작성한 여행 일정 포스팅 중 제목 또는 내용에서 특정 키워드와 일치하는 포스팅의 상세정보 목록을 가져온다.<br/>PostingsDAOManger에서 호출한다
	 * @param memberCode 특정 회원의 코드
	 * @param key 특정 키워드
	 * @return 특정 회원이 작성한 동행자 찾기 포스팅 중 특정 키워드를 포함하고 있는 포스팅의 상세정보 목록
	 */
	public List<CompanionSearchPostingDTO> selectPostingsOnlyMember(String memberCode, String key){
		Connection conn = null;
		PreparedStatement pre =  null;
		ResultSet re = null;
		List<CompanionSearchPostingDTO> list = new ArrayList<CompanionSearchPostingDTO>();
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
				String memberCode1= re.getString("member_code");
				String subCategoryCode = re.getString("sub_category_code");
				String subCategoryName = re.getString("sub_category_name");
				String title = re.getString("title");
				String destination1 = re.getString("destination1");
				String destination2 = re.getString("destination2");
				String writingDate = re.getString("writing_date");
				String name= re.getString("writer_name");
				String start=re.getString("start_date");
				String end=re.getString("end_date");
				String otherGender = re.getString("other_gender");
				int otherAge = re.getInt("other_age");
				String content = re.getString("content");
				int reliability = re.getInt("reliability");
				list.add(new CompanionSearchPostingDTO(code, purposeName, memberCode1, subCategoryCode, subCategoryName, title, destination1, destination2, writingDate, name, start, end, otherGender, otherAge, content, reliability ));
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
	 * 전체 회원이 작성한 동행자 찾기 포스팅 중 제목 또는 내용이  특정 키워드와 일치하는 포스팅의 상세정보 목록을 가져온다. <br/>PostingsDAOManger에서 호출한다
	 * @param key 특정 키워드 
	 * @return 특정 키워드와 일치하는 동행자 찾기 포스팅의 상세정보 목록
	 */
	public List<CompanionSearchPostingDTO> selectPostingsAll(String key){
		Connection conn = null;
		PreparedStatement pre =  null;
		ResultSet re = null;
		List<CompanionSearchPostingDTO> list = new ArrayList<CompanionSearchPostingDTO>();
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_POSTINGS_BY_TITLE_OR_CONTENT_SQL);
			pre.setString(1, "%"+key+"%");
			pre.setString(2, "%"+key+"%");
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("posting_code");
				String purposeName = re.getString("posting_purpose_name");
				String memberCode= re.getString("member_code");
				String subCategoryCode = re.getString("sub_category_code");
				String subCategoryName = re.getString("sub_category_name");
				String title = re.getString("title");
				String destination1 = re.getString("destination1");
				String destination2 = re.getString("destination2");
				String writingDate = re.getString("writing_date");
				String name= re.getString("writer_name");
				String start=re.getString("start_date");
				String end=re.getString("end_date");
				String otherGender = re.getString("other_gender");
				int otherAge = re.getInt("other_age");
				String content = re.getString("content");
				int reliability = re.getInt("reliability");
				list.add(new CompanionSearchPostingDTO(code, purposeName, memberCode, subCategoryCode, subCategoryName, title, destination1, destination2, writingDate, name, start, end, otherGender, otherAge, content, reliability ));
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
	 * 전체 회원이 작성한 동행자 찾기 포스팅 중 회원이 일치한 조건에 만족한는 포스팅의 상세정보 목록을 가져온다.<br/>PostingsDAOManger에서 호출한다
	 * @param destination1 여행장소(시/도)
	 * @param destination2 여행장소(구)
	 * @param startDate 여행시작일
	 * @param endDate 여행종료일
	 * @param otherGender 원하는 상대의 성별 (남 or 여)
	 * @param otherAge 원하는 상대의 나이대
	 * @return 조건에 만족하는 동행자 찾기 포스팅의 상세정보 목록
	 */
	public List<CompanionSearchPostingDTO> selectPostings(String destination1, String destination2, String startDate, String endDate, String otherGender, int otherAge){
		Connection conn = null;
		PreparedStatement pre =  null;
		ResultSet re = null;
		List<CompanionSearchPostingDTO> list = new ArrayList<CompanionSearchPostingDTO>();
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_POSTINGS_BY_CONDITIONS_SQL);
			pre.setString(1, "%"+destination1+"%");
			pre.setString(2, "%"+destination2+"%");
			pre.setString(3, startDate);
			pre.setString(4, endDate);
			pre.setString(5, otherGender);
			pre.setInt(6, otherAge);
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("posting_code");
				String purposeName = re.getString("posting_purpose_name");
				String memberCode= re.getString("member_code");
				String subCategoryCode = re.getString("sub_category_code");
				String subCategoryName = re.getString("sub_category_name");
				String title = re.getString("title");
				String destination3 = re.getString("destination1");
				String destination4 = re.getString("destination2");
				String writingDate = re.getString("writing_date");
				String name= re.getString("writer_name");
				String start=re.getString("start_date");
				String end=re.getString("end_date");
				String otherGender1 = re.getString("other_gender");
				int otherAge1 = re.getInt("other_age");
				String content = re.getString("content");
				int reliability = re.getInt("reliability");
				list.add(new CompanionSearchPostingDTO(code, purposeName, memberCode, subCategoryCode, subCategoryName, title, destination3, destination4, writingDate, name, start, end, otherGender1, otherAge1, content, reliability ));
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
	 * 전체 회원이 작성한 동행자 찾기 포스팅 중 작성자 이름이 특정 키워드에 만족하는 포스팅의 상세정보를 가져온다. <br/>사용안함
	 * @param writerName 포스팅을 작성한 회원의 이름
	 * @return 조건에 만족하는 동행자 찾기 포스팅의 상세정보 목록
	 */
	public List<CompanionSearchPostingDTO> selectPostingsAllByWriterName(String writerName){
		Connection conn = null;
		PreparedStatement pre =  null;
		ResultSet re = null;
		List<CompanionSearchPostingDTO> list = new ArrayList<CompanionSearchPostingDTO>();
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_POSTINGS_BY_WRITER_NAME_SQL);
			pre.setString(1, "%"+writerName+"%");
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("posting_code");
				String purposeName = re.getString("posting_purpose_name");
				String memberCode= re.getString("member_code");
				String subCategoryCode = re.getString("sub_category_code");
				String subCategoryName = re.getString("sub_category_name");
				String title = re.getString("title");
				String destination1 = re.getString("destination1");
				String destination2 = re.getString("destination2");
				String writingDate = re.getString("writing_date");
				String name= re.getString("writer_name");
				String start=re.getString("start_date");
				String end=re.getString("end_date");
				String otherGender = re.getString("other_gender");
				int otherAge = re.getInt("other_age");
				String content = re.getString("content");
				int reliability = re.getInt("reliability");
				list.add(new CompanionSearchPostingDTO(code, purposeName, memberCode, subCategoryCode, subCategoryName, title, destination1, destination2, writingDate, name, start, end, otherGender, otherAge, content, reliability ));
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
	 * 전체 회원이 작성한 동행자 찾기 포스팅 중 회원이 일치한 조건에 만족한는 포스팅의 검색결과 목록을 가져온다.<br/>PostingsDAOManger에서 호출한다
	 * @param destination1 여행장소(시/도)
	 * @param destination2 여행장소(구)
	 * @param startDate 여행시작일
	 * @param endDate 여행종료일
	 * @param otherGender 원하는 상대의 성별(남 or 여)
	 * @param otherAge 원하는 상대의 나이대
	 * @return 조건에 만족하는 동행자 찾기 포스팅의 검색결과 목록
	 */
	public List<CompanionSearchRecommendListDTO> selectRecommendResultList(String destination1, String destination2, String startDate, String endDate, String otherGender, int otherAge){
		Connection conn = null;
		PreparedStatement pre =  null;
		ResultSet re = null;
		List<CompanionSearchRecommendListDTO> list = new ArrayList<CompanionSearchRecommendListDTO>();
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_RECOMMEND_RESULT_LIST_BY_CONDITIONS_SQL);
			pre.setString(1, "%"+destination1+"%");
			pre.setString(2, "%"+destination2+"%");
			pre.setString(3, startDate);
			pre.setString(4, endDate);
			pre.setString(5, otherGender);
			pre.setInt(6, otherAge);
			re = pre.executeQuery();
			System.out.println("while문 안에서...");
			while(re.next()){
				String code = re.getString("posting_code");
				String title = re.getString("title");
				String writingDate = re.getString("writing_date");
				String name= re.getString("writer_name");
				int reliability = re.getInt("reliability");
				System.out.println(code+", "+title+", "+writingDate+", "+name+", "+reliability);
				list.add(new CompanionSearchRecommendListDTO(code, title, writingDate, name, reliability ));
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
