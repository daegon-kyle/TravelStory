package dao;
import java.util.*;
import java.sql.*;
import dto.PostingDTO;
/**
 * 포스팅에 대한 공통 정보를 조작하기 위해 사용한다.<br/>PostingDataDAOManager에서 사용한다
 * @author 문정현
 *
 */
public class PostingDAO {
	/**
	 * 새로운 포스팅 공통 정보를 저장하기 위해 사용되는 쿼리문
	 */
	private final static String INSERT_POSTING_WITHOUT_LIKE_NUM_SQL="INSERT INTO posting_tb(posting_code, posting_purpose_code, member_code, sub_category_code, title, content, writing_date) VALUES(posting_code.nextVal, ?, ?, ?, ?, ?, ?)";
	/**
	 * 새로운 포스팅 공통정보를 저장하기 위해 사용되는 쿼리문
	 */
	private final static String INSERT_POSTING_WITHOUT_WRITING_DATE_SQL="INSERT INTO posting_tb(posting_code, posting_purpose_code, member_code, sub_category_code, title, content, writing_date) VALUES(posting_code.nextVal, ?, ?, ?, ?, ?, SYSDATE)";
	/**
	 * 새로운 포스팅 공통정보를 저장하기 위해 사용되는 쿼리문
	 */
	private final static String INSERT_POSTING_SQL="INSERT INTO posting_tb VALUES(posting_code.nextVal, ?, ?, ?, ?, ?, ?,?)";
	/**
	 * 저장된 모든 포스팅 공통정보를 삭제하기 위해 사용되는 쿼리문
	 */
	private final static String DELETE_ALL_SQL="delete from posting_tb";
	/**
	 * 저장된 포스팅 공통정보 중 특정 포스팅의 공통 정보를 삭제하기 위해 사용되는 쿼리문
	 */
	private final static String DELETE_POSTING_BY_POSTING_CODE_SQL="delete from posting_tb where posting_code=?";
	/**
	 * 저장된 포스팅 공통정보 중 특정 소카테고리에 작성된 포스팅 공통정보를 삭제하기 위해 사용되는 쿼리문
	 */
	private final static String DELETE_POSTING_BY_SUB_CATRGORY_CODE_SQL="delete from posting_tb where sub_category_code=?";
	/**
	 * 저장된 모든 포스팅 공통정보를 가져오기 위해 사용되는 쿼리문
	 */
	private final static String SELECT_ALL_SQL="select posting_code, posting_purpose_code, member_code, sub_category_code, title, like_num, content, TO_CHAR(writing_date, 'YYYY/MM/DD') writing_date from posting_tb";
	/**
	 * 저장된 포스팅 공통 정보 중 특정 포스팅의 공통 정보를 가져오기 위한 쿼리문
	 */
	private final static String SELECT_POSTING_SQL="select posting_code, posting_purpose_code, member_code, sub_category_code, title, like_num, content, TO_CHAR(writing_date, 'YYYY/MM/DD') writing_date from posting_tb where posting_code=?";
	/**
	 * 저장된 포스팅 공통 정보 중 특정 회원이 작성한 포스팅 공통정보들을 가져오기 위한 쿼리문
	 */
	private final static String SELECT_POSTINGS_BY_MEMBER_CODE_SQL="select posting_code, posting_purpose_code, member_code, sub_category_code, title, like_num, content, TO_CHAR(writing_date, 'YYYY/MM/DD') writing_date from posting_tb where member_code=?";
	/**
	 * 저장된 포스팅 공통 정보 중 특정 카테고리에 작성된 포스팅의 공통 정보들을 가져오기 위한 쿼리문
	 */
	private final static String SELECT_POSTINGS_BY_SUB_CATEGORY_CODE_SQL="select posting_code, posting_purpose_code, member_code, sub_category_code, title, like_num, content, TO_CHAR(writing_date, 'YYYY/MM/DD') writing_date from posting_tb where sub_category_code=?";
	/**
	 * 저장된 포스팅 공통 정보 중 특정 포스팅 목적에 일치하는 포스팅 공통 정보를 가져오기 위한 쿼리문
	 */
	private final static String SELECT_POSTINGS_BY_POSTING_PURPOSE_CODE_SQL="select posting_code, posting_purpose_code, member_code, sub_category_code, title, like_num, content, TO_CHAR(writing_date, 'YYYY/MM/DD') writing_date from posting_tb where posting_purpose_code=?";
	/**
	 * 저장된 포스팅 공통 정보 중 특정 포스팅의 정보를 수정하기 위한 쿼리문
	 */
	private final static String UPDATE_POSTING_SQL="UPDATE posting_tb SET sub_category_code=?, title=?, content=? WHERE posting_code=?";
	/**
	 * 특정 회원이 작성한 포스팅 공통 정보 중 가장 큰 포스팅 코드 값을 가져오기 위한 쿼리문
	 */
	private final static String SELECT_MAX_POSTING_CODE_BY_MEMBER_CODE="select MAX(TO_NUMBER(posting_code)) max from posting_tb where member_code=?";
	/**
	 * 특정 포스팅의 좋아요 수를 가져오기 위한 쿼리문
	 */
	private final static String SELECT_LIKE_NUM_BY_POSTING_CODE_SQL="select like_num from posting_tb where posting_code=?";
	/**
	 * 특정 포스팅의 좋아요 수를 수정하기 위한 쿼리문
	 */
	private final static String UPDATE_LIKE_NUM_BY_POSTING_CODE_SQL="update posting_tb set like_num=? where posting_code=?";
	/**
	 * default constructor
	 */
	public PostingDAO(){
		
	}
	/**
	 * 새로운 포스팅 공통정보를 저장한다.('좋아요 수'는 생략할 경우) <br/>사용안함
	 * @param postingPurposeCode 포스팅 목적 코드
	 * @param memberCode 회원 코드
	 * @param subCategoryCode 소카테고리 코드
	 * @param title 제목
	 * @param content 내용
	 * @param writingDate 작성 날짜
	 * @return true - 저장에 성공했을 경우 <br/> false - 저장에 실패했을 경우
	 */
	public boolean insert(String postingPurposeCode, String memberCode, String subCategoryCode, String title, String content, String writingDate){
		Connection conn = null;
		PreparedStatement pre = null;
		int rowNum=0;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(INSERT_POSTING_WITHOUT_LIKE_NUM_SQL);
			pre.setString(1, postingPurposeCode);
			pre.setString(2, memberCode);
			pre.setString(3, subCategoryCode);
			pre.setString(4, title);
			pre.setString(5, content);
			pre.setString(6, writingDate);
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
	 * 새로운 포스팅 공통 정보를 저장한다.('작성날짜', '좋아요 수'는 생략)<br/>PostingDataDAOManager에서 호출된다
	 * @param postingPurposeCode 포스팅 목적 코드
	 * @param memberCode 회원 코드
	 * @param subCategoryCode 소 카테고리 코드
	 * @param title 제목
	 * @param content 내용
	 * @return true - 저장에 성공했을 경우 <br/> false - 저장에 실패했을 경우
	 */
	public boolean insert(String postingPurposeCode, String memberCode, String subCategoryCode, String title, String content){
		Connection conn = null;
		PreparedStatement pre = null;
		int rowNum=0;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(INSERT_POSTING_WITHOUT_WRITING_DATE_SQL);
			pre.setString(1, postingPurposeCode);
			pre.setString(2, memberCode);
			pre.setString(3, subCategoryCode);
			pre.setString(4, title);
			pre.setString(5, content);
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
	 * 새로운 포스팅 공통 정보를 저장한다. <br/>사용안함
	 * @param postingPurposeCode 목적코드
	 * @param memberCode 회원 코드
	 * @param subCategoryCode 소카테고리 코드
	 * @param title 제목
	 * @param likeNum 좋아요 수
	 * @param content 내용
	 * @param writingDate 작성 날짜
	 * @return true - 저장에 성공했을 경우 <br/> false - 저장에 실패했을 경우
	 */
	public boolean insert(String postingPurposeCode, String memberCode, String subCategoryCode, String title, int likeNum, String content, String writingDate){
		Connection conn = null;
		PreparedStatement pre = null;
		int rowNum=0;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(INSERT_POSTING_SQL);
			pre.setString(1, postingPurposeCode);
			pre.setString(2, memberCode);
			pre.setString(3, subCategoryCode);
			pre.setString(4, title);
			pre.setInt(5, likeNum);
			pre.setString(6, content);
			pre.setString(7, writingDate);
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
	 * 저장된  모든 포스팅의 공통 정보를 삭제한다.<br/>사용안함
	 * @return true - 삭제에 성공했을 경우 <br/> false - 삭제에 실패했을 경우
	 */
	public boolean deleteAll(){
		Connection conn = null;
		PreparedStatement pre = null;
		int rowNum = 0;
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
				conn.close();
				pre.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		if(rowNum>0)
			return true;
		else
			return false;
	}
	/**
	 * 저장된 포스팅 공통 정보 중 특정 포스팅의 공통 정보를 삭제한다.<br/>PostingDataDAOManager에서 호출된다
	 * @param postingCode 특정 포스팅 코드
	 * @return true - 삭제에 성공했을 경우 <br/> false - 삭제에 실패 했을 경우
	 */
	public boolean deletePosting(String postingCode){
		Connection conn = null;
		PreparedStatement pre = null;
		int rowNum=0;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre=conn.prepareStatement(DELETE_POSTING_BY_POSTING_CODE_SQL);
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
	 * 저장된 포스팅의 공통 정보 중 특정 소카테고리에 작성한 포스팅의 공통 정보를 삭제한다.<br/>PostingDataDAOManager에서 호출된다
	 * @param subCategoryCode 소카테고리 코드
	 * @return true - 삭제에 성공했을 경우 <br/> false - 삭제에 실패했을 경우
	 */
	public boolean deletePostings(String subCategoryCode){
		Connection conn = null;
		PreparedStatement pre = null;
		int rowNum=0;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(DELETE_POSTING_BY_SUB_CATRGORY_CODE_SQL);
			pre.setString(1, subCategoryCode);
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
		if(rowNum>0)
			return true;
		return false;
	}
	/**
	 * 저장된 모든 포스팅의 공통 정보들을 가져온다.<br/>사용안함
	 * @return 포스팅의 공통 정보들
	 */
	public List<PostingDTO> selectAll(){
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		List<PostingDTO> list = new ArrayList<PostingDTO>();
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_ALL_SQL);
			re=pre.executeQuery();
			while(re.next()){
				String code = re.getString("posting_code");
				String purposeCode=re.getString("posting_purpose_code");
				String memberCode = re.getString("member_code");
				String subCategoryCode = re.getString("sub_category_code");
				String title = re.getString("title");
				int likeNum = re.getInt("like_num");
				String content = re.getString("content");
				String writingDate = re.getString("writing_date");
				list.add(new PostingDTO(code, purposeCode, memberCode, subCategoryCode, title, likeNum, content, writingDate));
			}
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
		return list;
	}
	/**
	 * 저장된 공통 정보 중 특정 포스팅의 공통 정보를 가져온다. <br/>사용안함
	 * @param postingCode 포스팅 코드
	 * @return 특정 포스팅의 공통 정보
	 */
	public PostingDTO select(String postingCode){
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		PostingDTO dto = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_POSTING_SQL);
			pre.setString(1, postingCode);
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("posting_code");
				String purposeCode=re.getString("posting_purpose_code");
				String memberCode = re.getString("member_code");
				String subCategoryCode = re.getString("sub_category_code");
				String title = re.getString("title");
				int likeNum = re.getInt("like_num");
				String content = re.getString("content");
				String writingDate = re.getString("writing_date");
				dto=new PostingDTO(code, purposeCode, memberCode, subCategoryCode, title, likeNum, content, writingDate);
			}
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
		return dto;
	}
	/**
	 * 저장된 포스팅 공통 정보 중 특정 회원이 작성한 공통 정보들을 가져온다. <br/>사용안함
	 * @param memberCode 회원 코드
	 * @return 특정 회원이 작성한 포스팅 공통정보들
	 */
	public List<PostingDTO> selectByMember(String memberCode){
		Connection conn = null;
		PreparedStatement pre= null;
		ResultSet re = null;
		List<PostingDTO> list = new ArrayList<PostingDTO>();
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_POSTINGS_BY_MEMBER_CODE_SQL);
			pre.setString(1, memberCode);
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("posting_code");
				String purposeCode=re.getString("posting_purpose_code");
				String memberCode1 = re.getString("member_code");
				String subCategoryCode = re.getString("sub_category_code");
				String title = re.getString("title");
				int likeNum = re.getInt("like_num");
				String content = re.getString("content");
				String writingDate = re.getString("writing_date");
				list.add(new PostingDTO(code, purposeCode, memberCode1, subCategoryCode, title, likeNum, content, writingDate));
			}
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
		return list;
	}
	/**
	 * 작성된 포스팅 공통 정보 중 특정 소카테고리에 작성한 포스팅의 공통정보들를 가져온다. <br/>사용안함
	 * @param subCategoryCode 소카테고리
	 * @return 포스팅의 공통정보들
	 */
	public List<PostingDTO> selectBySubCategory(String subCategoryCode){
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		List<PostingDTO> list = new ArrayList<PostingDTO>();
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_POSTINGS_BY_SUB_CATEGORY_CODE_SQL);
			pre.setString(1, subCategoryCode);
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("posting_code");
				String purposeCode=re.getString("posting_purpose_code");
				String memberCode = re.getString("member_code");
				String subCategoryCode1 = re.getString("sub_category_code");
				String title = re.getString("title");
				int likeNum = re.getInt("like_num");
				String content = re.getString("content");
				String writingDate = re.getString("writing_date");
				list.add(new PostingDTO(code, purposeCode, memberCode, subCategoryCode1, title, likeNum, content, writingDate));
			}
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
		return list;
	}
	/**
	 * 저장된 포스팅의 공통 정보 중 포스팅 목적에 따라 가져온다. <br/>사용안함
	 * @param postingPurposeCode 포스팅 목적 코드
	 * @return 포스팅 목적에 따른 포스팅의 공통정보들
	 */
	public List<PostingDTO> selectByPurpose(String postingPurposeCode){
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		List<PostingDTO> list = new ArrayList<PostingDTO>();
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_POSTINGS_BY_POSTING_PURPOSE_CODE_SQL);
			pre.setString(1, postingPurposeCode);
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("posting_code");
				String purposeCode=re.getString("posting_purpose_code");
				String memberCode = re.getString("member_code");
				String subCategoryCode1 = re.getString("sub_category_code");
				String title = re.getString("title");
				int likeNum = re.getInt("like_num");
				String content = re.getString("content");
				String writingDate = re.getString("writing_date");
				list.add(new PostingDTO(code, purposeCode, memberCode, subCategoryCode1, title, likeNum, content, writingDate));
			}
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
		return list;
	}
	/**
	 * 저장된 공통 정보 중 특정 포스팅의 공통 정보를 수정한다.<br/>PostingDataDAOManager에서 호출된다
	 * @param postingCode 포스팅 코드
	 * @param subCategoryCode 소카테고리코드
	 * @param title 포스팅 제목
	 * @param content 포스팅 내용
	 * @return true - 수정에 성공했을 경우 <br/> false - 수정에 실패했을 경우
	 */
	public boolean update(String postingCode, String subCategoryCode, String title, String content){
		int rowNum=0;
		PreparedStatement pre = null;
		Connection conn = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(UPDATE_POSTING_SQL);
			pre.setString(1, subCategoryCode);
			pre.setString(2, title);
			pre.setString(3, content);
			pre.setString(4,postingCode);
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
	 * 특정 회원이 작성한 포스팅의 가장 큰 코드 값을 가져온다.  <br/>포스팅을 추가할 때 이 메소드를 통해 얻은 포스팅 코드를 가지고 각 포스팅의 필수 정보 테이블에 넣는다
	 * @param memberCode
	 * @return
	 */
	public String selectMaxPostingCode(String memberCode){
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		String code = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_MAX_POSTING_CODE_BY_MEMBER_CODE);
			pre.setString(1, memberCode);
			re = pre.executeQuery();
			while(re.next()){
				code = re.getString("max");
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
		return code;
	}
	/**
	 * 특정 포스팅의 좋아요 수를 가져온다.  <br/>PostingDataDAOManager에서 사용한다.
	 * @param postingCode 포스팅 코드
	 * @return 좋아요 수
	 */
	public int selectLikeNum(String postingCode){
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		int num = 0;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre=conn.prepareStatement(SELECT_LIKE_NUM_BY_POSTING_CODE_SQL);
			pre.setString(1, postingCode);
			re = pre.executeQuery();
			while(re.next()){
				num = re.getInt("like_num");
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
		return num;
	}
	/**
	 * 특정 포스팅의 좋아요 수를 수정한다. <br/>PostingDataDAOManager에서 사용한다
	 * @param postingCode
	 * @param likeNum
	 * @return
	 */
	public boolean update(String postingCode, int likeNum){
		Connection conn = null;
		PreparedStatement pre = null;
		int rowNum = 0;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(UPDATE_LIKE_NUM_BY_POSTING_CODE_SQL);
			pre.setInt(1, likeNum);
			pre.setString(2, postingCode);
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
