// 0721 ������
package dao;
import dto.EtcPostingDTO;
import java.sql.*;
import java.util.*;
/**
 * �Ϲ� �� �������� �� ������ �������� ���� ����Ѵ�.<br/>PostingsDAOManger���� ���ȴ�.
 * @author ������
 *
 */
public class EtcPostingDAO {
	/**
	 * ��ü �Ϲ� �� �������� �������� ���� ���Ǵ� ������
	 */
	private static final String SELECT_ALL_SQL="select posting_code, posting_purpose_name, member_code, sub_category_code, sub_category_name, title, TO_CHAR(writing_date, 'YYYY/MM/DD') writing_date,writer_name, content, like_num from etc_posting_view order by writing_date DESC, like_num DESC";
	/**
	 * ��ü ȸ���� �ۼ��� �Ϲ� ������ �� Ư�� �������� �������� ���� ���Ǵ� ������
	 */
	private static final String SELECT_POSTING_BY_POSTING_CODE_SQL="select posting_code, posting_purpose_name, member_code, sub_category_code, sub_category_name, title, TO_CHAR(writing_date, 'YYYY/MM/DD') writing_date,writer_name, content, like_num from etc_posting_view where posting_code=? order by writing_date DESC, like_num DESC";
	/**
	 * ��ü ȸ���� �ۼ��� �Ϲ� ������ �� Ư�� ȸ���� �ۼ��� �������� �������� ���� ���Ǵ� ������
	 */
	private static final String SELECT_POSTINGS_BY_MEMBER_CODE_SQL="select posting_code, posting_purpose_name, member_code, sub_category_code, sub_category_name, title, TO_CHAR(writing_date, 'YYYY/MM/DD') writing_date,writer_name, content, like_num from etc_posting_view where member_code=? order by writing_date DESC, like_num DESC";
	/**
	 * Ư�� ȸ���� �ۼ��� �Ϲ� ������ �� Ư���� ��ī�װ��� �ۼ��� �������� �������� ���� ���Ǵ� ������
	 */
	private static final String SELECT_POSTINGS_BY_SUBCATEGORY_CODE_SQL="select posting_code, posting_purpose_name, member_code, sub_category_code, sub_category_name, title, TO_CHAR(writing_date, 'YYYY/MM/DD') writing_date,writer_name, content, like_num from etc_posting_view where member_code=? and sub_category_code=? order by writing_date DESC, like_num DESC";
	/**
	 * Ư�� ȸ���� �ۼ��� �Ϲ� ������ �� ���� �Ǵ� ���뿡 Ư�� Ű���忡 �����ϴ� �������� �������� ���� ���Ǵ� ������
	 */
	private static final String SELECT_POSTINGS_BY_MEMBER_AND_TITLE_OR_CONTENT_SQL="select posting_code, posting_purpose_name, member_code, sub_category_code, sub_category_name, title, TO_CHAR(writing_date, 'YYYY/MM/DD') writing_date,writer_name, content, like_num from etc_posting_view where member_code=? and (title LIKE ? or content LIKE ?) order by writing_date DESC, like_num DESC";
	/**
	 * ��ü ȸ���� �ۼ��� �Ϲ� ������ �� ���� �Ǵ� ���뿡 Ư�� Ű���忡 �����ϴ� �������� �������� ���� ���Ǵ� ������
	 */
	private static final String SELECT_POSTINGS_BY_TITLE_AND_CONTENT_SQL="select posting_code, posting_purpose_name, member_code, sub_category_code, sub_category_name, title, TO_CHAR(writing_date, 'YYYY/MM/DD') writing_date,writer_name, content, like_num from etc_posting_view where title LIkE ? or content LIKE ? order by writing_date DESC, like_num DESC";
	/**
	 * default constructor
	 */
	public EtcPostingDAO(){
		
	}
	/**
	 * ��ü ȸ���� �ۼ��� �Ϲ� �������� �������� �����´�. <br/>������
	 * @return �Ϲ� �������� �� ���� ���
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
	 * ��ü ȸ���� �ۼ��� �Ϲ� ������ �� Ư�� �������� �� ������ �����´�. <br/>PostingsDAOManger���� ȣ���Ѵ�
	 * @param postingCode Ư�� �������� �ڵ�
	 * @return Ư���� �Ϲ� �������� ������
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
	 * ��ü ȸ���� �ۼ��� �Ϲ� ������ �� Ư�� ȸ���� �ۼ��� �Ϲ� �������� �� ���� ����� �����´�.<br/>PostingsDAOManger���� ȣ���Ѵ�
	 * @param memberCode Ư�� ȸ���� �ڵ�
	 * @return �Ϲ� �������� ���������
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
	 * Ư�� ȸ���� �ۼ��� �Ϲ� ������ �� Ư�� ��ī�װ��� �ۼ��� �Ϲ� �������� ����������� �����´�.<br/>PostingsDAOManger���� ȣ���Ѵ�
	 * @param memberCode Ư�� ȸ���� �ڵ�
	 * @param subCategoryCode ��ī�װ��� �ڱ�
	 * @return �Ϲ� �������� ���������
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
	 * Ư�� ȸ���� �ۼ��� �Ϲ� ������ �� ���� �Ǵ� ������ Ư�� Ű���忡 �����ϴ� �Ϲ� ���� ������ ����� �����´�.<br/>PostingsDAOManger���� ȣ���Ѵ�
	 * @param memberCode Ư�� ����� �ڵ�
	 * @param key Ư�� Ű����
	 * @return �Ϲ� �������� �������
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
	 * ��ü ȸ���� �ۼ��� �Ϲ� ������ �� ���� �Ǵ� ������ Ư�� Ű���忡 �����ϴ� �������� ����������� �����´�.<br/>PostingsDAOManger���� ȣ���Ѵ�
	 * @param key Ư�� Ű����
	 * @return �Ϲ� �������� ������ ���
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
