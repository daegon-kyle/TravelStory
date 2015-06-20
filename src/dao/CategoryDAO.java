package dao;
import dto.CategoryDTO;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 카테고리에 대한 정보를 조작하기 위해 사용한다. <br/>BlogCustomizingServlet에서 사용한다.
 * @author 문정현
 *
 */
public class CategoryDAO {
	/**
	 * 전체 회원의 카테고리에 대한 정보를 가져오기 위해 사용되는 쿼리문
	 */
	private final static String SELECT_ALL_SQL="select * from category_view";
	/**
	 * 특정 회원이 설정한 카테고리 정보를 가져오기 위해 사용되는 쿼리문
	 */
	private final static String SELECT_CATEGORYS_BY_MEMBER_CODE_SQL="select * from category_view where member_code=?";
	/**
	 * 특정 회원이 설정한 한개의 상위 카테고리에 속한 하위 카테고리의 정보를 가져오기 위해 사용되는 쿼리문
	 */
	private final static String SELECT_SUB_CATEGORYS_BY_MAIN_CATEGORY_SQL="select * from category_view where member_code=? and main_category_code=?";
	/**
	 * 특정 회원이 설정한 한개의 하위 카테고리가 속한 상위 카테고리의 정보를 가져오기 위해 사용되는 쿼리문
	 */
	private final static String SELECT_MAIN_CATEGORY_BY_SUB_CATEGORY_SQL="select * from category_view where member_code=? and sub_category_code=?";
	/**
	 * 특정 회원의 코드를 이용하여 해당 회원의 블로그 코드를 가져오기 위해 사용되는 쿼리문
	 */
	private final static String SELECT_BLOG_CODE_BY_MEMBER_CODE_SQL="select blog_code from category_view where member_code=?";
	/**
	 * default constructor
	 */
	public CategoryDAO(){
		
	}
	/**
	 * 전체 회원이 설정한 카테고리 정보를 가져온다. <br/>사용안함
	 * @return 전체 회원의 카테고리 정보들
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
	 * 특정 회원이 설정한 카테고리에 대한 정보를 가져온다. <br/>사용안함
	 * @param memberCode 회원 코드
	 * @return 특정 회원의 카테고리 정보들
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
	 * 특정 회원이 설정한 카테고리의 정보 중 특정 상위 카테고리에 속한 하위 카테고리의 정보들을 가져온다.<br/>BlogCostumizingServlet에서 호출된다.
	 * @param memberCode 회원 코드
	 * @param mainCategoryCode 상위 카테고리 코드
	 * @return 특정 상위 카테고리에 속한 하위 카테고리의 정보들
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
	 * 특정 회원이 설정한 카테고리 정보 중 특정 하위 카테고리가 속한 상위 카테고리의 정보를 가져온다. <br/>사용안함
	 * @param memberCode 회원코드
	 * @param subCategoryCode 하위 카테고리 코드
	 * @return 특정 회원의 하위카테고리가 속한 상위카테고리의 정보
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
	 * 특정 회원의 블로그 코드를 가져온다. <br/>사용안함
	 * @param memberCode 회원의 코드
	 * @return 특정 회원의 블로그 코드
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
				break; // blog_code한개만 가지고 오기 위해서
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
	 * 특정 회원이 가진 대카테고리의 코드를 모두 가져온다. <br/>BlogCostumizingServlet에서 호출된다.
	 * @param memberCode 회원코드
	 * @return 대카테고리 코드들
	 */
	public List<String> selectMainCategoryCodes(String memberCode){
		return null;
	}
}
