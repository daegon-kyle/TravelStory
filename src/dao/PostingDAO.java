package dao;
import java.util.*;
import java.sql.*;
import dto.PostingDTO;
/**
 * �����ÿ� ���� ���� ������ �����ϱ� ���� ����Ѵ�.<br/>PostingDataDAOManager���� ����Ѵ�
 * @author ������
 *
 */
public class PostingDAO {
	/**
	 * ���ο� ������ ���� ������ �����ϱ� ���� ���Ǵ� ������
	 */
	private final static String INSERT_POSTING_WITHOUT_LIKE_NUM_SQL="INSERT INTO posting_tb(posting_code, posting_purpose_code, member_code, sub_category_code, title, content, writing_date) VALUES(posting_code.nextVal, ?, ?, ?, ?, ?, ?)";
	/**
	 * ���ο� ������ ���������� �����ϱ� ���� ���Ǵ� ������
	 */
	private final static String INSERT_POSTING_WITHOUT_WRITING_DATE_SQL="INSERT INTO posting_tb(posting_code, posting_purpose_code, member_code, sub_category_code, title, content, writing_date) VALUES(posting_code.nextVal, ?, ?, ?, ?, ?, SYSDATE)";
	/**
	 * ���ο� ������ ���������� �����ϱ� ���� ���Ǵ� ������
	 */
	private final static String INSERT_POSTING_SQL="INSERT INTO posting_tb VALUES(posting_code.nextVal, ?, ?, ?, ?, ?, ?,?)";
	/**
	 * ����� ��� ������ ���������� �����ϱ� ���� ���Ǵ� ������
	 */
	private final static String DELETE_ALL_SQL="delete from posting_tb";
	/**
	 * ����� ������ �������� �� Ư�� �������� ���� ������ �����ϱ� ���� ���Ǵ� ������
	 */
	private final static String DELETE_POSTING_BY_POSTING_CODE_SQL="delete from posting_tb where posting_code=?";
	/**
	 * ����� ������ �������� �� Ư�� ��ī�װ��� �ۼ��� ������ ���������� �����ϱ� ���� ���Ǵ� ������
	 */
	private final static String DELETE_POSTING_BY_SUB_CATRGORY_CODE_SQL="delete from posting_tb where sub_category_code=?";
	/**
	 * ����� ��� ������ ���������� �������� ���� ���Ǵ� ������
	 */
	private final static String SELECT_ALL_SQL="select posting_code, posting_purpose_code, member_code, sub_category_code, title, like_num, content, TO_CHAR(writing_date, 'YYYY/MM/DD') writing_date from posting_tb";
	/**
	 * ����� ������ ���� ���� �� Ư�� �������� ���� ������ �������� ���� ������
	 */
	private final static String SELECT_POSTING_SQL="select posting_code, posting_purpose_code, member_code, sub_category_code, title, like_num, content, TO_CHAR(writing_date, 'YYYY/MM/DD') writing_date from posting_tb where posting_code=?";
	/**
	 * ����� ������ ���� ���� �� Ư�� ȸ���� �ۼ��� ������ ������������ �������� ���� ������
	 */
	private final static String SELECT_POSTINGS_BY_MEMBER_CODE_SQL="select posting_code, posting_purpose_code, member_code, sub_category_code, title, like_num, content, TO_CHAR(writing_date, 'YYYY/MM/DD') writing_date from posting_tb where member_code=?";
	/**
	 * ����� ������ ���� ���� �� Ư�� ī�װ��� �ۼ��� �������� ���� �������� �������� ���� ������
	 */
	private final static String SELECT_POSTINGS_BY_SUB_CATEGORY_CODE_SQL="select posting_code, posting_purpose_code, member_code, sub_category_code, title, like_num, content, TO_CHAR(writing_date, 'YYYY/MM/DD') writing_date from posting_tb where sub_category_code=?";
	/**
	 * ����� ������ ���� ���� �� Ư�� ������ ������ ��ġ�ϴ� ������ ���� ������ �������� ���� ������
	 */
	private final static String SELECT_POSTINGS_BY_POSTING_PURPOSE_CODE_SQL="select posting_code, posting_purpose_code, member_code, sub_category_code, title, like_num, content, TO_CHAR(writing_date, 'YYYY/MM/DD') writing_date from posting_tb where posting_purpose_code=?";
	/**
	 * ����� ������ ���� ���� �� Ư�� �������� ������ �����ϱ� ���� ������
	 */
	private final static String UPDATE_POSTING_SQL="UPDATE posting_tb SET sub_category_code=?, title=?, content=? WHERE posting_code=?";
	/**
	 * Ư�� ȸ���� �ۼ��� ������ ���� ���� �� ���� ū ������ �ڵ� ���� �������� ���� ������
	 */
	private final static String SELECT_MAX_POSTING_CODE_BY_MEMBER_CODE="select MAX(TO_NUMBER(posting_code)) max from posting_tb where member_code=?";
	/**
	 * Ư�� �������� ���ƿ� ���� �������� ���� ������
	 */
	private final static String SELECT_LIKE_NUM_BY_POSTING_CODE_SQL="select like_num from posting_tb where posting_code=?";
	/**
	 * Ư�� �������� ���ƿ� ���� �����ϱ� ���� ������
	 */
	private final static String UPDATE_LIKE_NUM_BY_POSTING_CODE_SQL="update posting_tb set like_num=? where posting_code=?";
	/**
	 * default constructor
	 */
	public PostingDAO(){
		
	}
	/**
	 * ���ο� ������ ���������� �����Ѵ�.('���ƿ� ��'�� ������ ���) <br/>������
	 * @param postingPurposeCode ������ ���� �ڵ�
	 * @param memberCode ȸ�� �ڵ�
	 * @param subCategoryCode ��ī�װ� �ڵ�
	 * @param title ����
	 * @param content ����
	 * @param writingDate �ۼ� ��¥
	 * @return true - ���忡 �������� ��� <br/> false - ���忡 �������� ���
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
	 * ���ο� ������ ���� ������ �����Ѵ�.('�ۼ���¥', '���ƿ� ��'�� ����)<br/>PostingDataDAOManager���� ȣ��ȴ�
	 * @param postingPurposeCode ������ ���� �ڵ�
	 * @param memberCode ȸ�� �ڵ�
	 * @param subCategoryCode �� ī�װ� �ڵ�
	 * @param title ����
	 * @param content ����
	 * @return true - ���忡 �������� ��� <br/> false - ���忡 �������� ���
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
	 * ���ο� ������ ���� ������ �����Ѵ�. <br/>������
	 * @param postingPurposeCode �����ڵ�
	 * @param memberCode ȸ�� �ڵ�
	 * @param subCategoryCode ��ī�װ� �ڵ�
	 * @param title ����
	 * @param likeNum ���ƿ� ��
	 * @param content ����
	 * @param writingDate �ۼ� ��¥
	 * @return true - ���忡 �������� ��� <br/> false - ���忡 �������� ���
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
	 * �����  ��� �������� ���� ������ �����Ѵ�.<br/>������
	 * @return true - ������ �������� ��� <br/> false - ������ �������� ���
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
	 * ����� ������ ���� ���� �� Ư�� �������� ���� ������ �����Ѵ�.<br/>PostingDataDAOManager���� ȣ��ȴ�
	 * @param postingCode Ư�� ������ �ڵ�
	 * @return true - ������ �������� ��� <br/> false - ������ ���� ���� ���
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
	 * ����� �������� ���� ���� �� Ư�� ��ī�װ��� �ۼ��� �������� ���� ������ �����Ѵ�.<br/>PostingDataDAOManager���� ȣ��ȴ�
	 * @param subCategoryCode ��ī�װ� �ڵ�
	 * @return true - ������ �������� ��� <br/> false - ������ �������� ���
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
	 * ����� ��� �������� ���� �������� �����´�.<br/>������
	 * @return �������� ���� ������
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
	 * ����� ���� ���� �� Ư�� �������� ���� ������ �����´�. <br/>������
	 * @param postingCode ������ �ڵ�
	 * @return Ư�� �������� ���� ����
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
	 * ����� ������ ���� ���� �� Ư�� ȸ���� �ۼ��� ���� �������� �����´�. <br/>������
	 * @param memberCode ȸ�� �ڵ�
	 * @return Ư�� ȸ���� �ۼ��� ������ ����������
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
	 * �ۼ��� ������ ���� ���� �� Ư�� ��ī�װ��� �ۼ��� �������� ���������鸦 �����´�. <br/>������
	 * @param subCategoryCode ��ī�װ�
	 * @return �������� ����������
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
	 * ����� �������� ���� ���� �� ������ ������ ���� �����´�. <br/>������
	 * @param postingPurposeCode ������ ���� �ڵ�
	 * @return ������ ������ ���� �������� ����������
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
	 * ����� ���� ���� �� Ư�� �������� ���� ������ �����Ѵ�.<br/>PostingDataDAOManager���� ȣ��ȴ�
	 * @param postingCode ������ �ڵ�
	 * @param subCategoryCode ��ī�װ��ڵ�
	 * @param title ������ ����
	 * @param content ������ ����
	 * @return true - ������ �������� ��� <br/> false - ������ �������� ���
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
	 * Ư�� ȸ���� �ۼ��� �������� ���� ū �ڵ� ���� �����´�.  <br/>�������� �߰��� �� �� �޼ҵ带 ���� ���� ������ �ڵ带 ������ �� �������� �ʼ� ���� ���̺� �ִ´�
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
	 * Ư�� �������� ���ƿ� ���� �����´�.  <br/>PostingDataDAOManager���� ����Ѵ�.
	 * @param postingCode ������ �ڵ�
	 * @return ���ƿ� ��
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
	 * Ư�� �������� ���ƿ� ���� �����Ѵ�. <br/>PostingDataDAOManager���� ����Ѵ�
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
