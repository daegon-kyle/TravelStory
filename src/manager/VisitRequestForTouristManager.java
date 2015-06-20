package manager;

import dbmanager.TouristVisitRequestToOwnerDAOManager;
import dbmanager.VisitRequestInfoDAOManager;
import model.TouristEssentialInfo;
import model.VisitRequestInfoForOwnerList;
import model.VisitRequestInfoForTourist;
import model.VisitRequestInfoForTouristList;
/**
 * 여행객이 집주인에게 방문신청 관리를 위한 매니저 
 * VisitRequestServlet에서 호출 
 * @author 영한
 *
 */
public class VisitRequestForTouristManager {
	/**
	 *  여행객을 위한 방문신청목록 
	 */
	private VisitRequestInfoForTouristList visitRequestInfoForTouristList;
	/**
	 * null 생성자 
	 */
	public VisitRequestForTouristManager() {
		this(new VisitRequestInfoForTouristList());
	}
	/**
	 * 여행객을 위한 방문신청리스트를 초기화하는 생성자  
	 * @param visitRequestInfoForTouristList 여행객을 위한 방문신청리스트 
	 */
	public VisitRequestForTouristManager(VisitRequestInfoForTouristList visitRequestInfoForTouristList) {
		this.visitRequestInfoForTouristList = visitRequestInfoForTouristList;
	}
	
	/**
	 * 여행객을 위한 방문신청리스트를 반환한다. 
	 * @return 여행객을위한 방문신청리스트 
	 */
	public VisitRequestInfoForTouristList getVisitRequestInfoForTouristList() {
		return visitRequestInfoForTouristList;
	}
	/**
	 * 여행객을 위한 방문신청리스트를 세팅한다.
	 * @param visitRequestInfoForTouristList 여행객을 위한 방문신청리스트 
	 */
	public void setVisitRequestInfoForTouristList(VisitRequestInfoForTouristList visitRequestInfoForTouristList) {
		this.visitRequestInfoForTouristList = visitRequestInfoForTouristList;
	}
	
	public void setVisitRequestInfoForTouristList(String memberCode){
		VisitRequestInfoDAOManager visitRequestInfoDAOManager = new VisitRequestInfoDAOManager();
		visitRequestInfoForTouristList = visitRequestInfoDAOManager.getHouseOwnerInfos(memberCode);
		
	}
	/**
	 * 회원(여행객)코드, 집주인코드, 여행객필수입력정보를 이용하여 방문신청을 한다. 
	 * @param memberCode 회원(여행객)코드 
	 * @param houseOwnerCode 집주인코드 
	 * @param touristEssentialInfo 여행객 필수입력정보
	 * @return 추가 성공하면 true리턴, 아니면 false리턴 
	 */
	public boolean addVisitRequest(String memberCode, String houseOwnerCode, TouristEssentialInfo touristEssentialInfo){
		TouristVisitRequestToOwnerDAOManager touristVisitRequestToOwnerDAOManager = new TouristVisitRequestToOwnerDAOManager();
		return touristVisitRequestToOwnerDAOManager.save(memberCode, houseOwnerCode, touristEssentialInfo);
	}
	/**
	 * 회원이 추가한 방문신청정보를 삭제한다. 
	 * @param memberCode 회원(여행객)코드 
	 * @param houseOwnerCode 집주인코드 
	 * @return 추가 성공하면 true리턴, 아니면 false리턴 
	 */
	public boolean removeVisitRequest(String memberCode, String houseOwnerCode){
		System.out.println();
		return true;
	}
}
