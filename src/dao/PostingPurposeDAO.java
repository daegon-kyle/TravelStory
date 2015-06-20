// 0719 문정현
package dao;
import java.util.*;
import java.sql.*;

import dto.PostingPurposeDTO;
/**
 * 포스팅 목적에 대한 정보를 조작하기 위해 사용한다. <br/>호출하는 매니져 없음
 * @author 문정현
 *
 */
public class PostingPurposeDAO {
	/**
	 * 새로운 포스팅 목적에 대한 정보를 저장하기 위해 사용되는 쿼리문
	 */
	private final static String INSERT_POSTING_PURPOSE_SQL="INSERT INTO posting_purpose_tb VALUES(posting_purpose_code.nextVal, ?)";
	/**
	 * 저장된 포스팅 목적에 대한 모든 정보를 삭제하기 위해 사용되는 쿼리문
	 */
	private final static String DELETE_ALL_SQL="delete from posting_purpose_tb";
	/**
	 * 저장된 포스팅 목적에 대한 정보 중 특정 정보를 삭제하기 위해 사용되는 쿼리문
	 */
	private final static String DELETE_POSTING_PURPOSE_SQL="DELETE FROM posting_purpose_tb WHERE posting_purpose_code=?";
	/**
	 * 저장된 포스팅 목적에 대한 모든 정보를 가져오기 위해 사용되는 쿼리문
	 */
	private final static String SELECT_ALL_SQL="select * from posting_purpose_tb";
	/**
	 * 저장된 포스팅 목적에 대한 정보 중 특정 포스팅 목적에 대한 정보를 가져오기 위해 사용되는 쿼리문
	 */
	private final static String SELECT_POSTING_PURPOSE_SQL="select * from posting_purpose_tb where posting_purpose_code=?";
	/**
	 * 저장된 포스팅 목적에 대한 정보 중 특정 포스팅 목적에 대한 정보를 수정하기 위해 사용되는 쿼리문
	 */
	private final static String UPDATE_POSTING_PURPOSE_SQL="UPDATE posting_purpose_tb SET posting_purpose_name=? WHERE posting_purpose_code=?";
	/**
	 * default constructor
	 */
	public PostingPurposeDAO(){
		
	}
	/**
	 * 새로운 포스팅 목적 정보를 저장한다
	 * @param postingPurposeName 포스팅 목적 명
	 * @return true - 저장에 성공했을 경우 <br/> false - 저장에 실패했을 경우
	 */
	public boolean insert(String postingPurposeName){
		Connection conn = null;
		PreparedStatement pre = null;
		int rowNum = 0;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(INSERT_POSTING_PURPOSE_SQL);
			pre.setString(1, postingPurposeName);
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
		if(rowNum ==1)
			return true;
		return false;
	}
	/**
	 * 저장된 모든 포스팅 목적에 대한 정보를 삭제한다.
	 * @return true - 삭제에 성공했을 경우 <br/> false - 삭제에 실패 했을 경우
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
		return false;
	}
	/**
	 * 저장된 포스팅 목적 정보 중 특정 포스팅 목정 정보를 삭제한다.
	 * @param postingPurposeCode 포스팅 목적 코드
	 * @return true - 삭제에 성공했을 경우 <br/> false - 삭제에 실패했을 경우
	 */
	public boolean delete(String postingPurposeCode){
		Connection conn = null;
		PreparedStatement pre = null;
		int rowNum = 0;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(DELETE_POSTING_PURPOSE_SQL);
			pre.setString(1, postingPurposeCode);
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
	 * 저장된 모든 포스팅 목적 정보를 가져온다.
	 * @return 모든 포스팅 목적 정보들
	 */
	public List<PostingPurposeDTO> selectAll(){
		List<PostingPurposeDTO> list = new ArrayList<PostingPurposeDTO>();
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_ALL_SQL);
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("posting_purpose_code");
				String name = re.getString("posting_purpose_name");
				list.add(new PostingPurposeDTO(code, name));
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally{
			try{
				conn.close();
				pre.close();
				re.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		return list;
	}
	/**
	 * 저장된 포스팅 목적 정보 중 특정 포스팅 목적 정보를 가져온다.
	 * @param postingPurposeCode 포스팅 목적 코드
	 * @return 특정 포스팅 목정 정보
	 */
	public PostingPurposeDTO select(String postingPurposeCode){
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet re = null;
		PostingPurposeDTO dto = null;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_POSTING_PURPOSE_SQL);
			pre.setString(1,  postingPurposeCode);
			re = pre.executeQuery();
			while(re.next()){
				String code = re.getString("posting_purpose_code");
				String name = re.getString("posting_purpose_name");
				dto = new PostingPurposeDTO(code, name);
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		finally{
			try{
				conn.close();
				pre.close();
				re.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		return dto;
	}
	/**
	 * 저장된 포스팅 목적 정보 중 특정 포스팅 목적 정보를 수정한다.
	 * @param postingPurposeCode 포스팅 목적 코드
	 * @param postingPurposeName 포스팅 목적 명
	 * @return true - 수정에 성공했을 경우 <br/> false - 수정에 실패 했을 경우
	 */
	public boolean update(String postingPurposeCode, String postingPurposeName){
		Connection conn = null;
		PreparedStatement pre =null;
		int rowNum = 0;
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(UPDATE_POSTING_PURPOSE_SQL);
			pre.setString(1, postingPurposeName);
			pre.setString(2, postingPurposeCode);
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
}
