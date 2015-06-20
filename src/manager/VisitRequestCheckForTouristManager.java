package manager;

import java.util.Calendar;

import dbmanager.HouseOwnerDetailInfoDAOManager;
import model.HouseOwnerEssentialInfo;
import model.HouseOwnerEssentialInfoList;

public class VisitRequestCheckForTouristManager {
	
	private HouseOwnerEssentialInfo houseOwnerEssentialInfo;

	public VisitRequestCheckForTouristManager() {
		this(new HouseOwnerEssentialInfo());
	}
	
	public VisitRequestCheckForTouristManager(
			HouseOwnerEssentialInfo houseOwnerEssentialInfo) {
		this.houseOwnerEssentialInfo = houseOwnerEssentialInfo;
	}

	public HouseOwnerEssentialInfo getHouseOwnerEssentialInfo() {
		return houseOwnerEssentialInfo;
	}

	public void setHouseOwnerEssentialInfo(
			HouseOwnerEssentialInfo houseOwnerEssentialInfo) {
		this.houseOwnerEssentialInfo = houseOwnerEssentialInfo;
	}
	
	public HouseOwnerEssentialInfoList getSearchResult(){
		HouseOwnerDetailInfoDAOManager houseOwnerDetailInfoDAOManager = new HouseOwnerDetailInfoDAOManager();
		 
		return houseOwnerDetailInfoDAOManager.getDetailInfos(houseOwnerEssentialInfo);
	}
	
	
}
