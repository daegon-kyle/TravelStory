package dao;
import dto.TourPreparationPostingDTO;
import dto.TourPreparationRecommendListDTO;
import java.util.*;
import java.sql.*;
/**
 * ���� �غ� �����ÿ� ���� �� ���� �� �˻� ����� �������� ���� ���ȴ�.<br/> PostingsDAOManager���� ����Ѵ�
 * @author ������
 *
 */
public class TourPreparationPostingDAO {
	/**
	 * ��ü ȸ���� �ۼ��� ���� �غ� �������� �� ���� ����� �������� ���� ������
	 */
	private final static String SELECT_ALL_SQL="select * from tour_preparation_posting_view order by writing_date DESC, like_num DESC";
	/**
	 * ��ü ȸ���� �ۼ��� ���� �غ� ������ �� Ư���� �������� �������� �������� ���� ������
	 */
	private final static String SELECT_POSTING_SQL="select * from tour_preparation_posting_view where posting_code=? order by like_num DESC, writing_date DESC";
	/**
	 * ��ü ȸ���� �ۼ��� ���� �غ� ������ �� Ư�� ȸ���� �ۼ��� �� �������� �������� ���� ������
	 */
	private final static String SELECT_POSTINGS_BY_MEMBER_CODE_SQL="select * from tour_preparation_posting_view where member_code=? order by writing_date DESC, like_num DESC";
	/**
	 * Ư�� ȸ���� �ۼ��� ���� �غ� ������ �� Ư���� ��ī�װ��� �ۼ��� �������� �� ���� ��ϵ��� �������� ���� ������
	 */
	private final static String SELECT_POSTINGS_BY_MEMBER_CODE_AND_SUB_CATEGORY_CODE_SQL="select * from tour_preparation_posting_view where member_code=? and sub_category_code=? order by writing_date DESC , like_num DESC";
	/**
	 * Ư�� ȸ���� �ۼ��� ���� �غ� ������ �� Ư�� Ű���尡 ���� �Ǵ� ���뿡 �����ϴ� �������� �� ���� ��ϵ��� �������� ���� ������
	 */
	private final static String SELECT_POSTINGS_BY_MEMBER_CODE_AND_TITLE_OR_CONTENT_SQL="select * from tour_preparation_posting_view where member_code=? and (title LIKE ? or content LIKE ?) order by writing_date DESC , like_num DESC";
	/**
	 * ��ü ȸ���� ���� �ۼ��� ���� �غ� ������ �� ���� ��Ұ� ��ġ�ϴ� �������� ������ ��ϵ��� �������� ���� ������ 
	 */
	private final static String SELECT_SPRING_POSTINGS_SQL="select * from tour_preparation_posting_view where destination1=? and destination2=? and TO_CHAR(TO_DATE(start_date), 'MM')='03' or TO_CHAR(TO_DATE(start_date), 'MM')='04' or TO_CHAR(TO_DATE(start_date), 'MM')='05' order by like_num DESC, writing_date DESC";
	/**
	 * ��ü ȸ���� ������ �ۼ��� ���� �غ� ������ �� ���� ��Ұ� ��ġ�ϴ� �������� ������ ��ϵ��� �������� ���� ������
	 */
	private final static String SELECT_SUMMER_POSTINGS_SQL="select * from tour_preparation_posting_view where destination1=? and destination2=? and TO_CHAR(TO_DATE(start_date), 'MM')='06' or TO_CHAR(TO_DATE(start_date), 'MM')='07' or TO_CHAR(TO_DATE(start_date), 'MM')='08' order by like_num DESC, writing_date DESC";
	/**
	 * ��ü ȸ���� ������ �ۼ��� ���� �غ� ������ �� ���� ��Ұ� ��ġ�ϴ� �������� ������ ��ϵ��� �������� ���� ������
	 */
	private final static String SELECT_FALL_POSTINGS_SQL="select * from tour_preparation_posting_view where destination1=? and destination2=? and TO_CHAR(TO_DATE(start_date), 'MM')='09' or TO_CHAR(TO_DATE(start_date), 'MM')='10' or TO_CHAR(TO_DATE(start_date), 'MM')='11' order by like_num DESC, writing_date DESC";
	/**
	 * ��ü ȸ���� �ܿ￡ �ۼ��� ���� �غ� ������ �� ���� ��Ұ� ��ġ�ϴ� �������� ������ ��ϵ��� �������� ���� ������
	 */
	private final static String SELECT_WINTER_POSTINGS_SQL="select * from tour_preparation_posting_view where destination1=? and destination2=? and TO_CHAR(TO_DATE(start_date), 'MM')='12' or TO_CHAR(TO_DATE(start_date), 'MM')='01' or TO_CHAR(TO_DATE(start_date), 'MM')='02' order by like_num DESC, writing_date DESC";
	/**
	 * ��ü ȸ���� �ۼ��� ���� �غ� ������ �� ���� �Ǵ� ������ Ư�� Ű���忡 �����ϴ� �������� ������ ��ϵ��� �������� ���� ������
	 */
	private final static String SELECT_POSTINGS_BY_TITLE_OR_CONTENT_SQL="select * from tour_preparation_posting_view where title LIKE ? or content LIKE ? order by writing_date DESC, like_num DESC";
	/**
	 * ��ü ȸ���� �ۼ��� ���� �غ� ������ �� �ۼ��� �̸����� �������� �������� �������� ���� ������
	 */
	private final static String SELECT_POSTINGS_BY_WRITER_NAME_SQL="select * from tour_preparation_posting_view where writer_name LIKE ? order by writing_date DESC, like_num DESC";
	/**
	 * ��ü ȸ���� ���� �ۼ��� ���� �غ� ������ �� ���� ��Ұ� ��ġ�ϴ� �������� �˻� ��� ����� �������� ���� ������
	 */
	private final static String SELECT_SPRING_SEARCH_RESULT_LIST_SQL="select posting_code, title, writing_date, writer_name, like_num from tour_preparation_posting_view where destination1=? and destination2=? and TO_CHAR(TO_DATE(start_date), 'MM')='03' or TO_CHAR(TO_DATE(start_date), 'MM')='04' or TO_CHAR(TO_DATE(start_date), 'MM')='05' order by like_num DESC, writing_date DESC";
	/**
	 * ��ü ȸ���� ������ �ۼ��� ���� �غ� ������ �� ���� ��Ұ� ��ġ�ϴ� �������� �˻� ��� ����� �������� ���� ������
	 */
	private final static String SELECT_SUMMER_SEARCH_RESULT_LIST_SQL="select posting_code, title, writing_date, writer_name, like_num from tour_preparation_posting_view where destination1=? and destination2=? and TO_CHAR(TO_DATE(start_date), 'MM')='06' or TO_CHAR(TO_DATE(start_date), 'MM')='07' or TO_CHAR(TO_DATE(start_date), 'MM')='08' order by like_num DESC, writing_date DESC";
	/**
	 * ��ü ȸ���� ������ �ۼ��� ���� �غ� ������ �� ���� ��Ұ� ��ġ�ϴ� �������� �˻� ��� ����� �������� ���� ������
	 */
	private final static String SELECT_FALL_SEARCH_RESULT_LIST_SQL="select posting_code, title, writing_date, writer_name, like_num from tour_preparation_posting_view where destination1=? and destination2=? and TO_CHAR(TO_DATE(start_date), 'MM')='09' or TO_CHAR(TO_DATE(start_date), 'MM')='10' or TO_CHAR(TO_DATE(start_date), 'MM')='11' order by like_num DESC, writing_date DESC";
	/**
	 * ��ü ȸ���� �ܿ￡ �ۼ��� ���� �غ� ������ �� ���� ��Ұ� ��ġ�ϴ� �������� �˻� ��� ����� �������� ���� ������
	 */
	private final static String SELECT_WINTER_SEARCH_RESULT_LIST_SQL="select posting_code, title, writing_date, writer_name, like_num from tour_preparation_posting_view where destination1=? and destination2=? and TO_CHAR(TO_DATE(start_date), 'MM')='12' or TO_CHAR(TO_DATE(start_date), 'MM')='01' or TO_CHAR(TO_DATE(start_date), 'MM')='02' order by like_num DESC, writing_date DESC";
	/**
	 * ��ü ȸ���� �ۼ��� ������ �� ���� �غ� �������� ������ ����� �����´�.
	 * @return ��ü ���� �غ��� ������ ���
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
	 * ��ü ȸ���� �ۼ��� ���� �غ� ������ �� Ư�� ������ �Ѱ��� �����´�. <br/>PostingsDAOManger���� ȣ���Ѵ� 
	 * @param postingCode ������ �������� �ڵ�
	 * @return �ϳ��� ���� �غ� �������� ������
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
	 * ��ü ȸ���� �ۼ��� ���� �غ� ������ �� Ư�� ȸ���� �ۼ��� �������� �������� �����´� <br/>PostingsDAOManger���� ȣ���Ѵ�
	 * @param memberCode Ư�� ȸ���� �ڵ�
	 * @return ���� ȸ���� �ۼ��� ���� ���� �������� �� ���� ���
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
	 * ��ü ȸ���� �ۼ��� ���� �غ� ������ �� Ư�� ȸ���� Ư�� ��ī�װ��� �ۼ��� �������� �� �������� �����´�. <br/>PostingsDAOManger���� ȣ���Ѵ�
	 * @param memberCode Ư�� ȸ���� �ڵ�
	 * @param subCategoryCode Ư�� ȸ���� ��ī�װ� �ڵ�
	 * @return ���� �غ� �������� �� ���� ���
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
	 * Ư�� ȸ���� �ۼ��� ���� �غ� ������ �� ���� �Ǵ� ������ Ư�� Ű���带 �����ϴ� �������� ������ ����� �����´�. <br/>PostingsDAOManger���� ȣ���Ѵ�
	 * @param memberCode Ư�� ȸ���� �ڵ�
	 * @param key Ư�� Ű����
	 * @return Ư�� Ű���忡 �����ϴ� ���� �غ� �������� ������ ���
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
	 * ��ü ȸ����  3, 4, 5���� �ۼ��� ���� �غ�  ������ �� �������� ��ġ�ϴ� �������� ����������� �����´�. <br/>PostingsDAOManger���� ȣ���Ѵ�  
	 * @param destination1 �������(��/��)
	 * @param destination2 �������(��)
	 * @return ���� �ۼ��� ���� �غ� ������ �� �������� ��ġ�ϴ� �������� ������ ���
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
	 * ��ü ȸ����  6, 7, 8���� �ۼ��� ���� �غ�  ������ �� �������� ��ġ�ϴ� �������� ����������� �����´�. <br/>PostingsDAOManger���� ȣ���Ѵ�
	 * @param destination1 ������� (��/��)
	 * @param destination2 ���� ���(��)
	 * @return ������ �ۼ��� ���� �غ� ������ �� �������� ��ġ�ϴ� �������� ������ ���
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
	 * ��ü ȸ����  9, 10, 11���� �ۼ��� ���� �غ�  ������ �� �������� ��ġ�ϴ� �������� ����������� �����´�. <br/>PostingsDAOManger���� ȣ���Ѵ�
	 * @param destination1 �������(��/��)
	 * @param destination2 �������(��)
	 * @return ������ �ۼ��� ���� �غ� ������ �� �������� ��ġ�ϴ� �������� ������ ���
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
	 * ��ü ȸ����  11, 12, 1���� �ۼ��� ���� �غ�  ������ �� �������� ��ġ�ϴ� �������� ����������� �����´�. <br/>PostingsDAOManger���� ȣ���Ѵ�
	 * @param destination1 �������(��/��)
	 * @param destination2 �������(��)
	 * @return �ܿ￡ �ۼ��� ���� �غ� ������ �� �������� ��ġ�ϴ� �������� ������ ���
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
	 * ��ü ȸ���� �ۼ��� ���� �غ� ������ �� ���� �Ǵ� ���뿡 Ư�� Ű���忡 �����ϴ� �������� ������ ����� �����´� <br/>PostingsDAOManger���� ȣ���Ѵ�
	 * @param key Ư�� Ű����
	 * @return Ư�� Ű���忡 �����ϴ� ���� �غ� �������� ������ ���
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
	 * ��ü ȸ���� �ۼ��� ���� �غ� ������ �� �ۼ����� �̸��� �̿��Ͽ� �������� ����������� �����´�. <br/>������
	 * @param writerName ������ �ۼ����� �̸�
	 * @return �ۼ����� �̸��� �����ϴ� �������� ������ ���
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
	 * 3, 4, 5 ���� �ۼ��� ���� �غ� ������ �� ȸ���� �Է��� ���ǿ� �����ϴ� �������� �˻� �� �� �˻� ��� ����� �����´�. <br/>PostingsDAOManger���� ȣ���Ѵ�
	 * @param destination1 �������(��/��)
	 * @param destination2 �������(��)
	 * @return ���� �ۼ��� ���� �غ� ������ �� �˻��� ��� ���
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
			System.out.println("while�� �ȿ���...");
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
	 * 6, 7, 8 ���� �ۼ��� ���� �غ� ������ �� ȸ���� �Է��� ���ǿ� �����ϴ� �������� �˻� �� �� �˻� ��� ����� �����´�.<br/>PostingsDAOManger���� ȣ���Ѵ�
	 * @param destination1 �������(��/��)
	 * @param destination2 �������(��)
	 * @return ������ �ۼ��� ���� �غ� ������ �� �˻��� ��� ���
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
			System.out.println("while�� �ȿ���...");
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
	 * 9, 10, 11 ���� �ۼ��� ���� �غ� ������ �� ȸ���� �Է��� ���ǿ� �����ϴ� �������� �˻� �� �� �˻� ��� ����� �����´�.<br/>PostingsDAOManger���� ȣ���Ѵ�
	 * @param destination1 �������(��/��)
	 * @param destination2 �������(��)
	 * @return ������ �ۼ��� ���� �غ� ������ �� �˻��� ��� ���
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
			System.out.println("while�� �ȿ���...");
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
	 * 12, 1, 2 ���� �ۼ��� ���� �غ� ������ �� ȸ���� �Է��� ���ǿ� �����ϴ� �������� �˻� �� �� �˻� ��� ����� �����´�.<br/>PostingsDAOManger���� ȣ���Ѵ�
	 * @param destination1 �������(��/��)
	 * @param destination2 �������(��)
	 * @return �ܿ￡ �ۼ��� ���� �غ� ������ �� �˻��� ��� ���
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
			System.out.println("while�� �ȿ���...");
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
