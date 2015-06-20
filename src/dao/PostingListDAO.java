//0721 ������
package dao;
import dto.PostingListDTO;
import java.util.*;
import java.sql.*;
/**
 * ������ �⺻ ������ �������� ���� ����Ѵ�. <br/>������
 * @author ������
 *
 */
public class PostingListDAO {
	/**
	 * ��ü ȸ���� �ۼ��� �������� �⺻ ���� ����� �������� ���� ������
	 */
	private final static String SELECT_ALL_SQL="select posting_code, posting_purpose_code, title, TO_CHAR(writing_date, 'YYYY/MM/DD') writing_date, writer_name, like_num from posting_list_view order by like_num DESC, writing_date DESC";
	/**
	 * ��ü ȸ���� �ۼ��� �������� �⺻ ���� ����� ������ ������ ���� �������� ���� ������
	 */
	private final static String SELECT_BY_PURPOSE_SQL="select posting_code, posting_purpose_code, title, TO_CHAR(writing_date, 'YYYY/MM/DD') writing_date, writer_name, like_num from posting_list_view where posting_purpose_code=? order by like_num DESC, writing_date DESC";
	/**
	 * ��ü ȸ���� �ۼ��� �������� �⺻ ���� ����� ������ ���� ���� �������� ���� ������
	 */
	private final static String SELECT_BY_TITLE_SQL="select posting_code, posting_purpose_code, title, TO_CHAR(writing_date, 'YYYY/MM/DD') writing_date, writer_name, like_num from posting_list_view where title LIKE ? order by like_num DESC, writing_date DESC";
	/**
	 * ��ü ȸ���� �ۼ��� �������� �⺻ ���� ����� �ۼ��� �̸��� ���� �������� ���� ������
	 */
	private final static String SELECT_BY_WRITER_NAME_SQL="select posting_code, posting_purpose_code, title, TO_CHAR(writing_date, 'YYYY/MM/DD') writing_date, writer_name, like_num from posting_list_view where writer_name LIKE ? order by like_num DESC, writing_date DESC";
	/**
	 * ��ü ȸ���� �ۼ��� �������� �⺻ ������ ������ �ڵ带 ���� �������� ���� ������
	 */
	private final static String SELECT_BY_POSTING_CODE="select posting_code, posting_purpose_code, title, TO_CHAR(writing_date, 'YYYY/MM/DD') writing_date, writer_name, like_num from posting_list_view where posting_code=? order by like_num DESC, writing_date DESC";
	/**
	 * default constructor
	 */
	public PostingListDAO(){
		
	}
	/**
	 * ��ü ȸ���� �ۼ��� �������� �⺻ ���� ����� ������ ������ ���� �����´�.
	 * @param postingPurposeCode ������ ���� �ڵ�
	 * @return �⺻ ���� ���
	 */
	public List<PostingListDTO> selectByPurpose(String postingPurposeCode){
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		List<PostingListDTO> list = new ArrayList<PostingListDTO>();
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_BY_PURPOSE_SQL);
			pre.setString(1, postingPurposeCode);
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("posting_code");
				String purposeCode = re.getString("posting_purpose_code");
				String title = re.getString("title");
				String writingDate = re.getString("writing_date");
				String writerName = re.getString("writer_name");
				int likeNum = re.getInt("like_num");
				list.add(new PostingListDTO(code, purposeCode, title, writingDate, writerName, likeNum));
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
	 * ��ü ȸ���� �ۼ��� �������� �⺻ ���� ����� ������ ���� ���� �����´�.
	 * @param title ������ ����
	 * @return �⺻ ���� ���
	 */
	public List<PostingListDTO> selectByTitle(String title){
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		List<PostingListDTO> list = new ArrayList<PostingListDTO>();
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_BY_TITLE_SQL);
			pre.setString(1, "%"+title+"%");
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("posting_code");
				String purposeCode = re.getString("posting_purpose_code");
				String title1 = re.getString("title");
				String writingDate = re.getString("writing_date");
				String writerName = re.getString("writer_name");
				int likeNum = re.getInt("like_num");
				list.add(new PostingListDTO(code, purposeCode, title1, writingDate, writerName, likeNum));
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
	 * ��ü ȸ���� �ۼ��� �������� �⺻ ���� ����� �ۼ��� �̸��� ���� �����´�.
	 * @param writerName �ۼ��� �̸�
	 * @return �⺻ ���� ���
	 */
	public List<PostingListDTO> selectByWriterName(String writerName){
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		List<PostingListDTO> list = new ArrayList<PostingListDTO>();
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_BY_WRITER_NAME_SQL);
			pre.setString(1, "%"+writerName+"%");
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("posting_code");
				String purposeCode = re.getString("posting_purpose_code");
				String title = re.getString("title");
				String writingDate = re.getString("writing_date");
				String writerName1 = re.getString("writer_name");
				int likeNum = re.getInt("like_num");
				list.add(new PostingListDTO(code, purposeCode, title, writingDate, writerName1, likeNum));
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
	 * ��ü ȸ���� �ۼ��� �������� �⺻ ������ ������ �ڵ带 ���� �����´�.
	 * @param postingCode ������ �ڵ�
	 * @return �⺻ ���� ���
	 */
	public List<PostingListDTO> selectByPostingCode(String postingCode){
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		List<PostingListDTO> list = new ArrayList<PostingListDTO>();
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_BY_POSTING_CODE);
			pre.setString(1, postingCode);
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("posting_code");
				String purposeCode = re.getString("posting_purpose_code");
				String title = re.getString("title");
				String writingDate = re.getString("writing_date");
				String writerName = re.getString("writer_name");
				int likeNum = re.getInt("like_num");
				list.add(new PostingListDTO(code, purposeCode, title, writingDate, writerName, likeNum));
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
	 * ��ü ȸ���� �ۼ��� �������� �⺻ ���� ����� �����´�.
	 * @return ��ü �������� �⺻ ���� ���
	 */
	public List<PostingListDTO> selectAll(){
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		List<PostingListDTO> list = new ArrayList<PostingListDTO>();
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_ALL_SQL);
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("posting_code");
				String purposeCode = re.getString("posting_purpose_code");
				String title = re.getString("title");
				String writingDate = re.getString("writing_date");
				String writerName = re.getString("writer_name");
				int likeNum = re.getInt("like_num");
				list.add(new PostingListDTO(code, purposeCode, title, writingDate, writerName, likeNum));
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
