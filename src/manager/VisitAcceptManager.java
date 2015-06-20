package manager;

import dbmanager.HouseOwnerInfoDAOManager;
import dbmanager.VisitRequestInfoDAOManager;
import model.VisitRequestInfoForOwnerList;
import model.VisitRequestInfoForTouristList;
/**
 * 집주인이 여행객의 방문신청을 수락,거절하는 클래스  
 * VisitRequestManagerServlet에서 호출 
 * @author 영한
 *
 */
public class VisitAcceptManager {
	/**
	 * 여행객을 위한 방문신청리스트 , 여행객에 대한 방문신청 정보를 갖고 있다. 
	 */
	private VisitRequestInfoForOwnerList visitRequestInfoForOwnerList;
	/**
	 * null 생성자 
	 */
	public VisitAcceptManager() {
		this(new VisitRequestInfoForOwnerList());
	}
	/**
	 * 방문신청리스트를 초기화하는 생성자 
	 * @param visitRequestInfoForOwnerList 여행객을 위한 방문신청 리스트 
	 */
	public VisitAcceptManager(VisitRequestInfoForOwnerList visitRequestInfoForOwnerList) {
		this.visitRequestInfoForOwnerList = visitRequestInfoForOwnerList;
	}
	/**
	 * 방문신청리스트를 반환한다. 
	 * @return 방문신청리스트 
	 */
	public VisitRequestInfoForOwnerList getVisitRequestInfoForOwnerList() {
		return visitRequestInfoForOwnerList;
	}
	/**
	 * 방문신청리스트를 세팅한다. 
	 * @param visitRequestInfoForOwnerList 방문신청리스트 
	 */
	public void setVisitRequestInfoForOwnerList(VisitRequestInfoForOwnerList visitRequestInfoForOwnerList) {
		this.visitRequestInfoForOwnerList = visitRequestInfoForOwnerList;
	}
	/**
	 * 회원코드를 이용하여 자신(집주인)에게 방문신청한 방문신청리스트를 <br>
	 * 데이터베이스에서 가져와 멤버에 세팅한다.  
	 * @param memberCode 회원코드 
	 */
	public void setVisitRequestInfoForOwnerList(String houseOwnerCode){
		//  VisitAcceptManager의 멤버 VisitRequestInfoForOwnerList를 초기화 해준다.
		VisitRequestInfoDAOManager visitRequestInfoDAOManager = new VisitRequestInfoDAOManager();
		visitRequestInfoForOwnerList = visitRequestInfoDAOManager.getRequesterInfos(houseOwnerCode);
	}
	/**
	 * 방문수락한다. 
	 * @param houseOwnerCode 집주인 코드 
	 * @param touristCode 여행객 코드  
	 * @return 
	 */
	public void accept(String houseOwnerCode, String touristCode){
		HouseOwnerInfoDAOManager houseOwnerInfoDAOManager = new HouseOwnerInfoDAOManager();
		houseOwnerInfoDAOManager.modifyVisitRequestState(houseOwnerCode, touristCode, "수락");
	}
	/**
	 * 방문거절한다. 
	 * @param houseOwnerCode 집주인코드 
	 * @param touristCode 여행객코드 
	 * @return 방문신청리스트 
	 */
	public void refuse(String houseOwnerCode, String touristCode){
		HouseOwnerInfoDAOManager houseOwnerInfoDAOManager = new HouseOwnerInfoDAOManager();
		houseOwnerInfoDAOManager.modifyVisitRequestState(houseOwnerCode, touristCode, "거절");
	}
}
