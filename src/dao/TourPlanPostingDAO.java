// 0721 ������
package dao;
import dto.TourPlanPostingDTO;
import java.util.*;
import java.sql.*;
import dto.TourPlanRecommendListDTO;
/**
 * ���� ���� �������� �� ���� �� �˻� ����� �������� ���� ���ȴ�.<br/>PostingsDAOManger���� ���ȴ�
 * @author ������
 *
 */
public class TourPlanPostingDAO {
	/**
	 * ��ü ȸ���� ���� ���� �������� �� ������ �������� ���� ������
	 */
	private static final String SELECT_ALL_SQL="select * from tour_plan_posting_view order by like_num DESC, writing_date DESC";
	/**
	 * Ư���� �Ѱ��� �������� �� ������ �������� ���� ������
	 */
	private static final String SELECT_POSTING_SQL="select * from tour_plan_posting_view where posting_code=? order by like_num DESC, writing_date DESC";
	/**
	 * Ư�� ȸ���� �ۼ��� ���� ���� �������� �� ������ �������� ���� ������
	 */
	private static final String SELECT_POSTINGS_BY_MEMBER_CODE_SQL="select * from tour_plan_posting_view where member_code=? order by like_num DESC, writing_date DESC";
	/**
	 * Ư�� ȸ���� Ư���� �� ī�װ��� �ۼ��� ���� ���� �������� �� ������ �������� ���� ������
	 */
	private static final String SELECT_POSTINGS_BY_SUB_CATEGORY_SQL="select * from tour_plan_posting_view where member_code=? and sub_category_code=? order by like_num DESC, writing_date DESC";
	/**
	 * Ư�� ȸ���� �ۼ��� ���� ���� ������ �� ���� �Ǵ� ���뿡 Ư�� Ű���带 �˻��� �������� �������� ���� ������
	 */
	private static final String SELECT_POSTINGS_BY_MEMBER_AND_TITLE_OR_CONTENT_SQL="select * from tour_plan_posting_view where member_code=? and (title LIKE ? or content LIKE ?) order by like_num DESC, writing_date DESC";
	/**
	 * ��ü ȸ���� �ۼ��� ���� ���� ������ �� ���ǿ� �´� �������� �� ������ �������� ���� ������
	 */
	private static final String SELECT_POSTINGS_BY_CONDITIONS_SQL="select * from tour_plan_posting_view where destination1=? and destination2=? and restaurant_preference BETWEEN ? AND ? and healing_preference BETWEEN ? AND ? and attraction_preference BETWEEN ? AND ? and shopping_preference BETWEEN ? AND ? and etc_preference BETWEEN ? AND ? order by like_num DESC, writing_date DESC";
	/**
	 * ��ü ȸ���� �ۼ��� ���� ���� ������ �� ���� �Ǵ� ������ Ư�� Ű����� �˻��� �������� ���� ������
	 */
	private static final String SELECT_POSTINGS_BY_TITLE_OR_CONTENT_SQL="select * from tour_plan_posting_view where title LIKE ? or content LIKE ? order by like_num DESC, writing_date DESC";
	/**
	 * ��ü ȸ���� �ۼ��� ���� ���� ������ �� �ۼ����� �̸��� Ư�� Ű����� �˻��� �������� ���� ������
	 */
	private static final String SELECT_POSTINGS_BY_WRITER_NAME_SQL="select * from tour_plan_posting_view where writer_name LIKE ?";
	/**
	 * ��ü ȸ���� �ۼ��� ���� ���� ������ �� ���ǿ� �´� ������ ����� �������� ���� ������
	 */
	private static final String SELECT_SEARCH_RESULT_LIST_SQL="select posting_code, title, writing_date, writer_name, like_num from tour_plan_posting_view where destination1 LIKE ? and destination2 LIKE ? and (restaurant_preference BETWEEN ? AND ?) and (healing_preference BETWEEN ? AND ?) and (attraction_preference BETWEEN ? AND ?) and (shopping_preference BETWEEN ? AND ?) and (etc_preference BETWEEN ? AND ?)  order by like_num DESC, writing_date DESC";
	/**
	 * default constructor
	 */
	public TourPlanPostingDAO(){
		
	}
	/**
	 * ��ü ȸ���� �ۼ��� ���� ���� �������� �� ������ ��� �����´�. <br/>������
	 * 
	 * @return ��ü ȸ���� ���� ���� �������� �� ���� ���
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
	 * �������� ���� Ư�� �Ѱ��� �������� ������ ������ �����´�. <br/>PostingsDAOManger���� ȣ���Ѵ�
	 * @param postingCode �������� ���� ���� ���� �������� �ڵ�
	 * @return �� ���� ���� ���� �������� ������
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
	 * Ư�� ȸ���� �ۼ��� ��� ���� ���� �������� �������� �����´�.<br/>PostingsDAOManger���� ȣ���Ѵ�
	 * @param memberCode ���� ���� �������� ��������  �������� ���� Ư�� ȸ���� �ڵ�
	 * @return Ư�� ȸ���� �ۼ��� ��� ���� ���� �������� ������ ���
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
	 * Ư�� ȸ���� Ư�� ��ī�װ��� �ۼ��� ��� ���� ���� �������� �� ������ �����´� <br/>PostingsDAOManger���� ȣ���Ѵ�
	 * @param memberCode Ư�� ȸ���� �ڵ�
	 * @param subCategoryCode Ư�� ȸ���� ������ ��ī�װ��� �ڵ�
	 * @return Ư�� ȸ���� �ϳ��� ��ī�װ��� �ۼ��� ��� ���� ���� �������� �� ���� ���
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
	 * Ư�� ȸ���� �ۼ��� ���� ���� ������ �� ���� �Ǵ� ���뿡�� Ư�� Ű����� ��ġ�ϴ� �������� �������� �����´�. <br/>PostingsDAOManger���� ȣ���Ѵ�
	 * @param memberCode Ư��ȸ���� �ڵ�
	 * @param key �˻��ϰ� ���� Ű����
	 * @return Ư�� ȸ���� �ۼ��� ���� ���� ������ �� Ű����� ��ġ�ϴ� ���� �Ǵ� ������ ���� ���� ���� ������ ���
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
	 * �� ȸ���� ���������� ��õ �ޱ� ���� �Է��� ������ ��ġ�ϴ� ���� ���� �������� �� ������ �����´�.<br/>PostingsDAOManger���� ȣ���Ѵ�
	 * @param destination1 ȸ���� �Է��� �������(��/��)
	 * @param destination2 ȸ���� �Է��� �������(��)
	 * @param restaurantPreference ȸ���� �Է��� ���� ��ȣ��
	 * @param healingPreference ȸ���� �Է��� ���� ��ȣ��
	 * @param attractionPreference ȸ���� �Է��� ������� ��ȣ��
	 * @param shoppingPreference ȸ���� �Է��� ���� ��ȣ��
	 * @param etcPreference ȸ���� �Է��� ��Ÿ ��ȣ��
	 * @return �� ȸ���� �Է��� ������ ��ġ�ϴ� ���� ���� �������� �� ����
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
	 * ��ü ȸ���� �ۼ��� ���� ���� ������ �� ���� �Ǵ� ���뿡�� Ư�� Ű����� ��ġ�ϴ� �������� �� ������ �����´�.<br/>PostingsDAOManger���� ȣ���Ѵ�
	 * @param key Ư�� Ű����
	 * @return Ư�� Ű����� ��ġ�ϴ� ���� ���� ������ ���
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
	 * ��� ����
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
	 * �� ȸ���� ���������� ��õ �ޱ� ���� �Է��� ������ ��ġ�ϴ� ���� ���� ������ �˻� ��� ����� �����´�. <br/>PostingsDAOManger���� ȣ���Ѵ�
	 * @param destination1 ȸ���� �Է��� �������(��/��)
	 * @param destination2 ȸ���� �Է��� �������(��)
	 * @param restaurantPreference ȸ���� �Է��� ���� ��ȣ��
	 * @param healingPreference ȸ���� �Է��� ���� ��ȣ��
	 * @param attractionPreference ȸ���� �Է��� ������� ��ȣ��
	 * @param shoppingPreference ȸ���� �Է��� ���� ��ȣ��
	 * @param etcPreference ȸ���� �Է��� ��Ÿ ��ȣ��
	 * @return ȸ���� �Է��� ������ ��ġ�ϴ� ���� ���� �������� ���
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
			System.out.println("��õ ���dao�޼ҵ� �ȿ���....");
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
