package dao;
import dto.CompanionSearchPostingDTO;
import dto.CompanionSearchRecommendListDTO;
import java.util.*;
import java.sql.*;
/**
 * ������ ã�� �������� �� ���� �� �˻� ����� �������� ���� ���ȴ�.<br/>PostingsDAOManger���� ���ȴ�
 * @author ������
 *
 */
public class CompanionSearchPostingDAO {
	/**
	 * ��ü ȸ���� �ۼ��� ������ ã�� �������� �������� ���� ������
	 */
	private final static String SELECT_ALL_SQL="select * from companion_search_posting_view order by reliability DESC, writing_date DESC";
	/**
	 * ������ ã�� ������ �� Ư�� �������� �������� ���� ������
	 */
	private final static String SELECT_POSTING__SQL="select * from companion_search_posting_view where posting_code=? order by reliability DESC, writing_date DESC";
	/**
	 * Ư�� ȸ���� �ۼ��� ��� ������ ã�� �������� �������� ���� ������
	 */
	private final static String SELECT_POSTINGS_BY_MEMBER_CODE_SQL="select * from companion_search_posting_view where member_code=? order by reliability DESC, writing_date DESC";
	/**
	 * Ư�� ȸ���� �ۼ��� ������ ã�� �����õ� �� Ư���� ��ī�װ��� �ۼ��� �������� �������� ���� ������
	 */
	private final static String SELECT_POSTINGS_BY_MEMBER_CODE_AND_SUB_CATEGORY_SQL="select * from companion_search_posting_view where member_code=? and sub_category_code=? order by reliability DESC, writing_date DESC";
	/**
	 * Ư�� ȸ���� �ۼ��� ��� ������ ã�� ������ �� ���� �Ǵ� ���뿡�� Ư�� Ű����� ��ġ�ϴ� ���� �ִ� �������� �������� ���� ������
	 */
	private final static String SELECT_POSTINGS_BY_MEMBER_CODE_AND_TITLE_OR_CONTENT_SQL="select * from companion_search_posting_view where member_code=? and (title LIKE ? or content LIKE ?) order by reliability DESC, writing_date DESC";
	/**
	 * ȸ���� �Է��� Ư�� ���ǵ鿡 �����ϴ� ������ ã�� �������� �������� ���� ������
	 */
	private final static String SELECT_POSTINGS_BY_CONDITIONS_SQL="select * from companion_search_posting_view where destination1=? and destination2=? and start_date>=? and end_date<=? and other_gender=? and other_age=? order by reliability DESC, writing_date DESC";
	/**
	 * ��ü ȸ���� �ۼ��� ������ ã�� ������ �� ���� �Ǵ� ���뿡 Ư�� Ű����� ��ġ�ϴ� �������� �������� ���� ������
	 */
	private final static String SELECT_POSTINGS_BY_TITLE_OR_CONTENT_SQL="select * from companion_search_posting_view where title LIKE ? or content LIKE ? order by reliability DESC, writing_date DESC";
	/**
	 * ��ü ȸ���� �ۼ��� ������ ã�� ������ �� Ư�� Ű���尡 �ۼ����� �̸��� �����ϴ� �������� ������ ����� �������� ���� ������
	 */
	private final static String SELECT_POSTINGS_BY_WRITER_NAME_SQL="select * from companion_search_posting_view where writer_name LIKE ? order by reliability DESC, writing_date DESC";
	/**
	 * ȸ���� �Է��� Ư�� ���ǿ� �����ϴ� ������ ��õ ����� �������� ���� ������
	 */
	private final static String SELECT_RECOMMEND_RESULT_LIST_BY_CONDITIONS_SQL="select posting_code, title, writing_date, writer_name, reliability from companion_search_posting_view where destination1 LIKE ? and destination2 LIKE ? and start_date>=? and end_date<=? and other_gender=? and other_age=? order by reliability DESC, writing_date DESC";
	/**
	 * default constructor
	 */
	public CompanionSearchPostingDAO(){
		
	}
	/**
	 * ��ü ȸ���� �ۼ��� ������ �� ������ ã�� �������� �� ���� �����´� <br/>������
	 * @return ��ü ȸ���� �ۼ��� ������ ã�� �������� ������ ���
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
	 * ��ü ȸ���� �ۼ��� ������ ã�� ������ �� Ư���� �������� �������� �����´�.<br/>PostingsDAOManger���� ȣ���Ѵ�
	 * @param postingCode Ư���� ������ ã�� �������� �ڵ�
	 * @return Ư���� ������ ã�� �������� ������
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
	 * Ư�� ȸ���� �ۼ��� ������ ã�� �������� �����´�.<br/>PostingsDAOManger���� ȣ���Ѵ�
	 * @param memberCode Ư�� ȸ���� �ڵ�
	 * @return Ư�� ȸ���� �ۼ��� ������ ã�� �������� ������ ���
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
	 * Ư�� ȸ���� �ۼ��� ������ ã�� ������ �� Ư���� ��ī�װ��� �ۼ��� �������� ������ ����� �����´�.<br/>PostingsDAOManger���� ȣ���Ѵ�
	 * @param memberCode Ư�� ȸ���� �ڵ�
	 * @param subCategoryCode Ư�� ��ī�װ��� �ڵ�
	 * @return Ư�� ȸ���� �� ��ī�װ��� �ۼ��� ������ ã�� �������� �� ���� ���
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
	 * Ư�� ȸ���� �ۼ��� ���� ���� ������ �� ���� �Ǵ� ���뿡�� Ư�� Ű����� ��ġ�ϴ� �������� ������ ����� �����´�.<br/>PostingsDAOManger���� ȣ���Ѵ�
	 * @param memberCode Ư�� ȸ���� �ڵ�
	 * @param key Ư�� Ű����
	 * @return Ư�� ȸ���� �ۼ��� ������ ã�� ������ �� Ư�� Ű���带 �����ϰ� �ִ� �������� ������ ���
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
	 * ��ü ȸ���� �ۼ��� ������ ã�� ������ �� ���� �Ǵ� ������  Ư�� Ű����� ��ġ�ϴ� �������� ������ ����� �����´�. <br/>PostingsDAOManger���� ȣ���Ѵ�
	 * @param key Ư�� Ű���� 
	 * @return Ư�� Ű����� ��ġ�ϴ� ������ ã�� �������� ������ ���
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
	 * ��ü ȸ���� �ۼ��� ������ ã�� ������ �� ȸ���� ��ġ�� ���ǿ� �����Ѵ� �������� ������ ����� �����´�.<br/>PostingsDAOManger���� ȣ���Ѵ�
	 * @param destination1 �������(��/��)
	 * @param destination2 �������(��)
	 * @param startDate ���������
	 * @param endDate ����������
	 * @param otherGender ���ϴ� ����� ���� (�� or ��)
	 * @param otherAge ���ϴ� ����� ���̴�
	 * @return ���ǿ� �����ϴ� ������ ã�� �������� ������ ���
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
	 * ��ü ȸ���� �ۼ��� ������ ã�� ������ �� �ۼ��� �̸��� Ư�� Ű���忡 �����ϴ� �������� �������� �����´�. <br/>������
	 * @param writerName �������� �ۼ��� ȸ���� �̸�
	 * @return ���ǿ� �����ϴ� ������ ã�� �������� ������ ���
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
	 * ��ü ȸ���� �ۼ��� ������ ã�� ������ �� ȸ���� ��ġ�� ���ǿ� �����Ѵ� �������� �˻���� ����� �����´�.<br/>PostingsDAOManger���� ȣ���Ѵ�
	 * @param destination1 �������(��/��)
	 * @param destination2 �������(��)
	 * @param startDate ���������
	 * @param endDate ����������
	 * @param otherGender ���ϴ� ����� ����(�� or ��)
	 * @param otherAge ���ϴ� ����� ���̴�
	 * @return ���ǿ� �����ϴ� ������ ã�� �������� �˻���� ���
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
			System.out.println("while�� �ȿ���...");
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
