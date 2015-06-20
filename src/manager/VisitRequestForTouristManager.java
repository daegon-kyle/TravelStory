package manager;

import dbmanager.TouristVisitRequestToOwnerDAOManager;
import dbmanager.VisitRequestInfoDAOManager;
import model.TouristEssentialInfo;
import model.VisitRequestInfoForOwnerList;
import model.VisitRequestInfoForTourist;
import model.VisitRequestInfoForTouristList;
/**
 * ���ఴ�� �����ο��� �湮��û ������ ���� �Ŵ��� 
 * VisitRequestServlet���� ȣ�� 
 * @author ����
 *
 */
public class VisitRequestForTouristManager {
	/**
	 *  ���ఴ�� ���� �湮��û��� 
	 */
	private VisitRequestInfoForTouristList visitRequestInfoForTouristList;
	/**
	 * null ������ 
	 */
	public VisitRequestForTouristManager() {
		this(new VisitRequestInfoForTouristList());
	}
	/**
	 * ���ఴ�� ���� �湮��û����Ʈ�� �ʱ�ȭ�ϴ� ������  
	 * @param visitRequestInfoForTouristList ���ఴ�� ���� �湮��û����Ʈ 
	 */
	public VisitRequestForTouristManager(VisitRequestInfoForTouristList visitRequestInfoForTouristList) {
		this.visitRequestInfoForTouristList = visitRequestInfoForTouristList;
	}
	
	/**
	 * ���ఴ�� ���� �湮��û����Ʈ�� ��ȯ�Ѵ�. 
	 * @return ���ఴ������ �湮��û����Ʈ 
	 */
	public VisitRequestInfoForTouristList getVisitRequestInfoForTouristList() {
		return visitRequestInfoForTouristList;
	}
	/**
	 * ���ఴ�� ���� �湮��û����Ʈ�� �����Ѵ�.
	 * @param visitRequestInfoForTouristList ���ఴ�� ���� �湮��û����Ʈ 
	 */
	public void setVisitRequestInfoForTouristList(VisitRequestInfoForTouristList visitRequestInfoForTouristList) {
		this.visitRequestInfoForTouristList = visitRequestInfoForTouristList;
	}
	
	public void setVisitRequestInfoForTouristList(String memberCode){
		VisitRequestInfoDAOManager visitRequestInfoDAOManager = new VisitRequestInfoDAOManager();
		visitRequestInfoForTouristList = visitRequestInfoDAOManager.getHouseOwnerInfos(memberCode);
		
	}
	/**
	 * ȸ��(���ఴ)�ڵ�, �������ڵ�, ���ఴ�ʼ��Է������� �̿��Ͽ� �湮��û�� �Ѵ�. 
	 * @param memberCode ȸ��(���ఴ)�ڵ� 
	 * @param houseOwnerCode �������ڵ� 
	 * @param touristEssentialInfo ���ఴ �ʼ��Է�����
	 * @return �߰� �����ϸ� true����, �ƴϸ� false���� 
	 */
	public boolean addVisitRequest(String memberCode, String houseOwnerCode, TouristEssentialInfo touristEssentialInfo){
		TouristVisitRequestToOwnerDAOManager touristVisitRequestToOwnerDAOManager = new TouristVisitRequestToOwnerDAOManager();
		return touristVisitRequestToOwnerDAOManager.save(memberCode, houseOwnerCode, touristEssentialInfo);
	}
	/**
	 * ȸ���� �߰��� �湮��û������ �����Ѵ�. 
	 * @param memberCode ȸ��(���ఴ)�ڵ� 
	 * @param houseOwnerCode �������ڵ� 
	 * @return �߰� �����ϸ� true����, �ƴϸ� false���� 
	 */
	public boolean removeVisitRequest(String memberCode, String houseOwnerCode){
		System.out.println();
		return true;
	}
}
