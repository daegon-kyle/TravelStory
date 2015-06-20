// 0721 문정현
package dao;
import dto.EtcPostingDTO;
import java.sql.*;
import java.util.*;
/**
 * 일반 글 포스팅의 상세 정보를 가져오기 위해 사용한다.<br/>PostingsDAOManger에서 사용된다.
 * @author 문정현
 *
 */
public class EtcPostingDAO {
	/**
	 * 전체 일반 글 포스팅을 가져오기 위해 사용되는 쿼리문
	 */
	private static final String SELECT_ALL_SQL="select posting_code, posting_purpose_name, member_code, sub_category_code, sub_category_name, title, TO_CHAR(writing_date, 'YYYY/MM/DD') writing_date,writer_name, content, like_num from etc_posting_view order by writing_date DESC, like_num DESC";
	/**
	 * 전체 회원이 작성한 일반 포스팅 중 특정 포스팅을 가져오기 위해 사용되는 쿼리문
	 */
	private static final String SELECT_POSTING_BY_POSTING_CODE_SQL="select posting_code, posting_purpose_name, member_code, sub_category_code, sub_category_name, title, TO_CHAR(writing_date, 'YYYY/MM/DD') writing_date,writer_name, content, like_num from etc_posting_view where posting_code=? order by writing_date DESC, like_num DESC";
	/**
	 * 전체 회원이 작성한 일반 포스팅 중 특정 회원이 작성한 포스팅을 가져오기 위해 사용되는 쿼리문
	 */
	private static final String SELECT_POSTINGS_BY_MEMBER_CODE_SQL="select posting_code, posting_purpose_name, member_code, sub_category_code, sub_category_name, title, TO_CHAR(writing_date, 'YYYY/MM/DD') writing_date,writer_name, content, like_num from etc_posting_view where member_code=? order by writing_date DESC, like_num DESC";
	/**
	 * 특정 회원이 작성한 일반 포스팅 중 특정한 소카테고리에 작성한 포스팅을 가져오기 위해 사용되는 쿼리문
	 */
	private static final String SELECT_POSTINGS_BY_SUBCATEGORY_CODE_SQL="select posting_code, posting_purpose_name, member_code, sub_category_code, sub_category_name, title, TO_CHAR(writing_date, 'YYYY/MM/DD') writing_date,writer_name, content, like_num from etc_posting_view where member_code=? and sub_category_code=? order by writing_date DESC, like_num DESC";
	/**
	 * 특정 회원이 작성한 일반 포스팅 중 제목 또는 내용에 특정 키워드에 만족하는 포스팅을 가져오기 위해 사용되는 쿼리문
	 */
	private static final String SELECT_POSTINGS_BY_MEMBER_AND_TITLE_OR_CONTENT_SQL="select posting_code, posting_purpose_name, member_code, sub_category_code, sub_category_name, title, TO_CHAR(writing_date, 'YYYY/MM/DD') writing_date,writer_name, content, like_num from etc_posting_view where member_code=? and (title LIKE ? or content LIKE ?) order by writing_date DESC, like_num DESC";
	/**
	 * 전체 회원이 작성한 일반 포스팅 중 제목 또는 내용에 특정 키워드에 만족하는 포스팅을 가져오기 위해 사용되는 쿼리문
	 */
	private static final String SELECT_POSTINGS_BY_TITLE_AND_CONTENT_SQL="select posting_code, posting_purpose_name, member_code, sub_category_code, sub_category_name, title, TO_CHAR(writing_date, 'YYYY/MM/DD') writing_date,writer_name, content, like_num from etc_posting_view where title LIkE ? or content LIKE ? order by writing_date DESC, like_num DESC";
	/**
	 * default constructor
	 */
	public EtcPostingDAO(){
		
	}
	/**
	 * 전체 회원이 작성한 일반 포스팅의 상세정보를 가져온다. <br/>사용안함
	 * @return 일반 포스팅의 상세 정보 목록
	 */
	public List<EtcPostingDTO> selectAll(){
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		List<EtcPostingDTO> list = new ArrayList<EtcPostingDTO>();
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_ALL_SQL);
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("posting_code");
				String purposeCode = re.getString("posting_purpose_name");
				String memberCode = re.getString("member_code");
				String subCategoryCode = re.getString("sub_category_code");
				String subCategoryName = re.getString("sub_category_name");
				String title = re.getString("title");
				String writingDate = re.getString("writing_date");
				String writerName = re.getString("writer_name");
				String content = re.getString("content");
				int likeNum = re.getInt("like_num");
				list.add(new EtcPostingDTO(code, purposeCode, memberCode, subCategoryCode, subCategoryName, title, writingDate, writerName, content, likeNum));
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
	 * 전체 회원이 작성한 일반 포스팅 중 특정 포스팅의 상세 정보를 가져온다. <br/>PostingsDAOManger에서 호출한다
	 * @param postingCode 특정 포스팅의 코드
	 * @return 특정한 일반 포스팅의 상세정보
	 */
	public EtcPostingDTO selectPosting(String postingCode){
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		EtcPostingDTO dto = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_POSTING_BY_POSTING_CODE_SQL);
			pre.setString(1, postingCode);
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("posting_code");
				String purposeCode = re.getString("posting_purpose_name");
				String memberCode = re.getString("member_code");
				String subCategoryCode = re.getString("sub_category_code");
				String subCategoryName = re.getString("sub_category_name");
				String title = re.getString("title");
				String writingDate = re.getString("writing_date");
				String writerName = re.getString("writer_name");
				String content = re.getString("content");
				int likeNum = re.getInt("like_num");
				dto = new EtcPostingDTO(code, purposeCode, memberCode, subCategoryCode, subCategoryName, title, writingDate, writerName, content, likeNum);
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
	 * 전체 회원이 작성한 일반 포스팅 중 특정 회원이 작성한 일반 포스팅의 상세 정보 목록을 가져온다.<br/>PostingsDAOManger에서 호출한다
	 * @param memberCode 특정 회원의 코드
	 * @return 일반 포스팅의 상세정보목록
	 */
	public List<EtcPostingDTO> selectPostings(String memberCode){
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		List<EtcPostingDTO> list = new ArrayList<EtcPostingDTO>();
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_POSTINGS_BY_MEMBER_CODE_SQL);
			pre.setString(1, memberCode);
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("posting_code");
				String purposeCode = re.getString("posting_purpose_name");
				String memberCode1 = re.getString("member_code");
				String subCategoryCode = re.getString("sub_category_code");
				String subCategoryName = re.getString("sub_category_name");
				String title = re.getString("title");
				String writingDate = re.getString("writing_date");
				String writerName = re.getString("writer_name");
				String content = re.getString("content");
				int likeNum = re.getInt("like_num");
				list.add(new EtcPostingDTO(code, purposeCode, memberCode1, subCategoryCode, subCategoryName, title, writingDate, writerName, content, likeNum));
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
	 * 특정 회원이 작성한 일반 포스팅 중 특정 소카테고리에 작성한 일반 포스팅의 상세정보목록을 가져온다.<br/>PostingsDAOManger에서 호출한다
	 * @param memberCode 특정 회원의 코드
	 * @param subCategoryCode 소카테고리의 코그
	 * @return 일반 포스팅의 상세정보목록
	 */
	public List<EtcPostingDTO> selectPostings(String memberCode, String subCategoryCode){
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		List<EtcPostingDTO> list = new ArrayList<EtcPostingDTO>();
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_POSTINGS_BY_SUBCATEGORY_CODE_SQL);
			pre.setString(1, memberCode);
			pre.setString(2, subCategoryCode);
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("posting_code");
				String purposeCode = re.getString("posting_purpose_name");
				String memberCode1 = re.getString("member_code");
				String subCategoryCode1 = re.getString("sub_category_code");
				String subCategoryName = re.getString("sub_category_name");
				String title = re.getString("title");
				String writingDate = re.getString("writing_date");
				String writerName = re.getString("writer_name");
				String content = re.getString("content");
				int likeNum = re.getInt("like_num");
				list.add(new EtcPostingDTO(code, purposeCode, memberCode1, subCategoryCode1, subCategoryName, title, writingDate, writerName, content, likeNum));
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
	 * 특정 회원이 작성한 일반 포스팅 중 제목 또는 내용이 특정 키워드에 만족하는 일반 글의 상세정보 목록을 가져온다.<br/>PostingsDAOManger에서 호출한다
	 * @param memberCode 특정 멤버의 코드
	 * @param key 특정 키워드
	 * @return 일반 포스팅의 정보목록
	 */
	public List<EtcPostingDTO> selectPostingsOnlyMember(String memberCode, String key){
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		List<EtcPostingDTO> list = new ArrayList<EtcPostingDTO>();
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_POSTINGS_BY_MEMBER_AND_TITLE_OR_CONTENT_SQL);
			pre.setString(1, memberCode);
			pre.setString(2, "%"+key+"%");
			pre.setString(3, "%"+key+"%");
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("posting_code");
				String purposeCode = re.getString("posting_purpose_name");
				String memberCode1 = re.getString("member_code");
				String subCategoryCode = re.getString("sub_category_code");
				String subCategoryName = re.getString("sub_category_name");
				String title = re.getString("title");
				String writingDate = re.getString("writing_date");
				String writerName = re.getString("writer_name");
				String content = re.getString("content");
				int likeNum = re.getInt("like_num");
				list.add(new EtcPostingDTO(code, purposeCode, memberCode1, subCategoryCode, subCategoryName, title, writingDate, writerName, content, likeNum));
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
	 * 전체 회원이 작성한 일반 포스팅 중 제목 또는 내용이 특정 키워드에 만족하는 포스팅의 상세정보목록을 가져온다.<br/>PostingsDAOManger에서 호출한다
	 * @param key 특정 키워드
	 * @return 일반 포스팅의 상세정보 목록
	 */
	public List<EtcPostingDTO> selectPostingsAll(String key){
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		List<EtcPostingDTO> list = new ArrayList<EtcPostingDTO>();
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_POSTINGS_BY_TITLE_AND_CONTENT_SQL);
			pre.setString(1, "%"+key+"%");
			pre.setString(2, "%"+key+"%");
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("posting_code");
				String purposeCode = re.getString("posting_purpose_name");
				String memberCode = re.getString("member_code");
				String subCategoryCode = re.getString("sub_category_code");
				String subCategoryName = re.getString("sub_category_name");
				String title = re.getString("title");
				String writingDate = re.getString("writing_date");
				String writerName = re.getString("writer_name");
				String content = re.getString("content");
				int likeNum = re.getInt("like_num");
				list.add(new EtcPostingDTO(code, purposeCode, memberCode, subCategoryCode, subCategoryName, title, writingDate, writerName, content, likeNum));
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
