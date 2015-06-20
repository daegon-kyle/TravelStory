package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import dto.HouseOwnerDetailInfoDTO;
/**
 * 여행객에게 제공할 집주인에 대한 자세한 정보를 얻기 위해 사용한다.<br/>HouseOwnerDetailInfoDAOManager에서 사용한다.
 * @author 문정현
 *
 */
public class HouseOwnerDetailInfoDAO {
	private final static String SELECT_HOUSE_OWNER_INFOS_SQL="select * from house_owner_detail_info_view where visit_start_date>=to_date(?,'yyyy/mm/dd') and visit_end_date>=to_date(?,'yyyy/mm/dd') and address LIKE ?";
	private final static String SELECT_ALL_HOUSE_OWNER_INFOS_SQL="select * from house_owner_detail_info_view";
	public HouseOwnerDetailInfoDAO(){
		
	}
	/**
	 * 여행객이 원하는 조건에 맞는 집주인의 정보를 가져오기 위해 사용한다. <br/>HouseOwnerDetailInfoDAOManager에서 호출된다.
	 * @param location 여행 장소
	 * @param visitStartDate 방문 시작일
	 * @param visitEndDate 방문 종료일
	 * @return 조건에 해당하는 집주인의 상세정보
	 */
	public List<HouseOwnerDetailInfoDTO> selectHouseOwners(String location, String visitStartDate, String visitEndDate){
		System.out.println("HouseOwnerDetailInfoDAO 들어왔다 ");
		Connection conn =null;
		PreparedStatement pre = null;
		ResultSet re = null;
		List<HouseOwnerDetailInfoDTO> list = new ArrayList<HouseOwnerDetailInfoDTO>();
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_HOUSE_OWNER_INFOS_SQL);
			
			pre.setString(1, visitStartDate);
			System.out.println("HouseOwnerDetailInfoDAO setString1");
			pre.setString(2, visitEndDate);
			System.out.println("HouseOwnerDetailInfoDAO setString2");
			pre.setString(3, "%"+location+"%");
			System.out.println("HouseOwnerDetailInfoDAO setString3");
			re = pre.executeQuery();
			System.out.println("HouseOwnerDetailInfoDAO before while");
			while(re.next()){
				String houseOwnerCode = re.getString("house_owner_code");
				String ownerName = re.getString("owner_name");
				String email = re.getString("email");
				String address = re.getString("address");
				String visitStartDate1 = re.getString("visit_start_date");
				String visitEndDate1 = re.getString("visit_end_date");
				String job = re.getString("job");
				String marriedState = re.getString("married_state");
				String selfIntroduction = re.getString("self_introduction");
				String etc = re.getString("etc");
				list.add(new HouseOwnerDetailInfoDTO(houseOwnerCode, ownerName, email, address, visitStartDate1, visitEndDate1, job, marriedState, selfIntroduction, etc));
				System.out.println("resultSet : " + houseOwnerCode + ownerName);
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
		for(HouseOwnerDetailInfoDTO dto : list){
			System.out.println("dao : " +dto.getHouseOwnerCode());
		}
		System.out.println("list is empty? " + list.isEmpty());
		return list;
	}
	/**
	 * 등록된 모든 집주인에 대한 상세 정보를 가져온다.<br/> 사용안함
	 * @return 등록된 모든 집주인에 대한 상세정보
	 */
	public List<HouseOwnerDetailInfoDTO> selectAll(){
		Connection conn =null;
		PreparedStatement pre = null;
		ResultSet re = null;
		List<HouseOwnerDetailInfoDTO> list = new ArrayList<HouseOwnerDetailInfoDTO>();
		try{
			conn = DBConnectionPool.getInstance().getConnection();
			pre = conn.prepareStatement(SELECT_ALL_HOUSE_OWNER_INFOS_SQL);
			re = pre.executeQuery();
			while(re.next()){
				String houseOwnerCode = re.getString("house_owner_code");
				String ownerName = re.getString("owner_name");
				String email = re.getString("email");
				String address = re.getString("address");
				String visitStartDate = re.getString("visit_start_date");
				String visitEndDate = re.getString("visit_end_date");
				String job = re.getString("job");
				String marriedState = re.getString("married_state");
				String selfIntroduction = re.getString("self_introduction");
				String etc = re.getString("etc");
				list.add(new HouseOwnerDetailInfoDTO(houseOwnerCode, ownerName, email, address, visitStartDate, visitEndDate, job, marriedState, selfIntroduction, etc));
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
