package dao;
import dto.CategoryDTO;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * ī�װ��� ���� ������ �����ϱ� ���� ����Ѵ�. <br/>BlogCustomizingServlet���� ����Ѵ�.
 * @author ������
 *
 */
public class CategoryDAO {
	/**
	 * ��ü ȸ���� ī�װ��� ���� ������ �������� ���� ���Ǵ� ������
	 */
	private final static String SELECT_ALL_SQL="select * from category_view";
	/**
	 * Ư�� ȸ���� ������ ī�װ� ������ �������� ���� ���Ǵ� ������
	 */
	private final static String SELECT_CATEGORYS_BY_MEMBER_CODE_SQL="select * from category_view where member_code=?";
	/**
	 * Ư�� ȸ���� ������ �Ѱ��� ���� ī�װ��� ���� ���� ī�װ��� ������ �������� ���� ���Ǵ� ������
	 */
	private final static String SELECT_SUB_CATEGORYS_BY_MAIN_CATEGORY_SQL="select * from category_view where member_code=? and main_category_code=?";
	/**
	 * Ư�� ȸ���� ������ �Ѱ��� ���� ī�װ��� ���� ���� ī�װ��� ������ �������� ���� ���Ǵ� ������
	 */
	private final static String SELECT_MAIN_CATEGORY_BY_SUB_CATEGORY_SQL="select * from category_view where member_code=? and sub_category_code=?";
	/**
	 * Ư�� ȸ���� �ڵ带 �̿��Ͽ� �ش� ȸ���� ��α� �ڵ带 �������� ���� ���Ǵ� ������
	 */
	private final static String SELECT_BLOG_CODE_BY_MEMBER_CODE_SQL="select blog_code from category_view where member_code=?";
	/**
	 * default constructor
	 */
	public CategoryDAO(){
		
	}
	/**
	 * ��ü ȸ���� ������ ī�װ� ������ �����´�. <br/>������
	 * @return ��ü ȸ���� ī�װ� ������
	 */
	public List<CategoryDTO> selectAll(){
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		List<CategoryDTO> list = new ArrayList<CategoryDTO>();
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_ALL_SQL);
			re = pre.executeQuery();
			while(re.next()){
				String memberCode= re.getString("member_code");
				String blogCode = re.getString("blog_code");
				String mainCategoryCode = re.getString("main_category_code");
				String mainCategoryName = re.getString("main_category_name");
				String subCategoryCode= re.getString("sub_category_code");
				String subCategoryName = re.getString("sub_category_name");
				list.add(new CategoryDTO(memberCode, blogCode, mainCategoryCode, mainCategoryName, subCategoryCode, subCategoryName));
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
	 * Ư�� ȸ���� ������ ī�װ��� ���� ������ �����´�. <br/>������
	 * @param memberCode ȸ�� �ڵ�
	 * @return Ư�� ȸ���� ī�װ� ������
	 */
	public List<CategoryDTO> selectCategorys(String memberCode){
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		List<CategoryDTO> list = new ArrayList<CategoryDTO>();
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_CATEGORYS_BY_MEMBER_CODE_SQL);
			pre.setString(1, memberCode);
			re = pre.executeQuery();
			while(re.next()){
				String memberCode1= re.getString("member_code");
				String blogCode = re.getString("blog_code");
				String mainCategoryCode = re.getString("main_category_code");
				String mainCategoryName = re.getString("main_category_name");
				String subCategoryCode= re.getString("sub_category_code");
				String subCategoryName = re.getString("sub_category_name");
				list.add(new CategoryDTO(memberCode1, blogCode, mainCategoryCode, mainCategoryName, subCategoryCode, subCategoryName));
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
	 * Ư�� ȸ���� ������ ī�װ��� ���� �� Ư�� ���� ī�װ��� ���� ���� ī�װ��� �������� �����´�.<br/>BlogCostumizingServlet���� ȣ��ȴ�.
	 * @param memberCode ȸ�� �ڵ�
	 * @param mainCategoryCode ���� ī�װ� �ڵ�
	 * @return Ư�� ���� ī�װ��� ���� ���� ī�װ��� ������
	 */
	public List<CategoryDTO> selectSubCategorys(String memberCode, String mainCategoryCode){
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		List<CategoryDTO> list = new ArrayList<CategoryDTO>();
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_SUB_CATEGORYS_BY_MAIN_CATEGORY_SQL);
			pre.setString(1, memberCode);
			pre.setString(2, mainCategoryCode);
			re = pre.executeQuery();
			while(re.next()){
				String memberCode1= re.getString("member_code");
				String blogCode = re.getString("blog_code");
				String mainCategoryCode1 = re.getString("main_category_code");
				String mainCategoryName = re.getString("main_category_name");
				String subCategoryCode= re.getString("sub_category_code");
				String subCategoryName = re.getString("sub_category_name");
				list.add(new CategoryDTO(memberCode1, blogCode, mainCategoryCode1, mainCategoryName, subCategoryCode, subCategoryName));
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
	 * Ư�� ȸ���� ������ ī�װ� ���� �� Ư�� ���� ī�װ��� ���� ���� ī�װ��� ������ �����´�. <br/>������
	 * @param memberCode ȸ���ڵ�
	 * @param subCategoryCode ���� ī�װ� �ڵ�
	 * @return Ư�� ȸ���� ����ī�װ��� ���� ����ī�װ��� ����
	 */
	public CategoryDTO selectMainCategory(String memberCode, String subCategoryCode){
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		CategoryDTO dto = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_MAIN_CATEGORY_BY_SUB_CATEGORY_SQL);
			pre.setString(1, memberCode);
			pre.setString(2, subCategoryCode);
			re = pre.executeQuery();
			while(re.next()){
				String memberCode1= re.getString("member_code");
				String blogCode = re.getString("blog_code");
				String mainCategoryCode = re.getString("main_category_code");
				String mainCategoryName = re.getString("main_category_name");
				String subCategoryCode1= re.getString("sub_category_code");
				String subCategoryName = re.getString("sub_category_name");
				dto = new CategoryDTO(memberCode1, blogCode, mainCategoryCode, mainCategoryName, subCategoryCode1, subCategoryName);
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
	 * Ư�� ȸ���� ��α� �ڵ带 �����´�. <br/>������
	 * @param memberCode ȸ���� �ڵ�
	 * @return Ư�� ȸ���� ��α� �ڵ�
	 */
	public String selectBlogCode(String memberCode){
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		String blogCode = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_BLOG_CODE_BY_MEMBER_CODE_SQL);
			pre.setString(1, memberCode);
			re = pre.executeQuery();
			while(re.next()){
				blogCode = re.getString("blog_code");
				break; // blog_code�Ѱ��� ������ ���� ���ؼ�
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
		return blogCode;
	}
	/**
	 * Ư�� ȸ���� ���� ��ī�װ��� �ڵ带 ��� �����´�. <br/>BlogCostumizingServlet���� ȣ��ȴ�.
	 * @param memberCode ȸ���ڵ�
	 * @return ��ī�װ� �ڵ��
	 */
	public List<String> selectMainCategoryCodes(String memberCode){
		return null;
	}
}
