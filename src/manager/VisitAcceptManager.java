package manager;

import dbmanager.HouseOwnerInfoDAOManager;
import dbmanager.VisitRequestInfoDAOManager;
import model.VisitRequestInfoForOwnerList;
import model.VisitRequestInfoForTouristList;
/**
 * �������� ���ఴ�� �湮��û�� ����,�����ϴ� Ŭ����  
 * VisitRequestManagerServlet���� ȣ�� 
 * @author ����
 *
 */
public class VisitAcceptManager {
	/**
	 * ���ఴ�� ���� �湮��û����Ʈ , ���ఴ�� ���� �湮��û ������ ���� �ִ�. 
	 */
	private VisitRequestInfoForOwnerList visitRequestInfoForOwnerList;
	/**
	 * null ������ 
	 */
	public VisitAcceptManager() {
		this(new VisitRequestInfoForOwnerList());
	}
	/**
	 * �湮��û����Ʈ�� �ʱ�ȭ�ϴ� ������ 
	 * @param visitRequestInfoForOwnerList ���ఴ�� ���� �湮��û ����Ʈ 
	 */
	public VisitAcceptManager(VisitRequestInfoForOwnerList visitRequestInfoForOwnerList) {
		this.visitRequestInfoForOwnerList = visitRequestInfoForOwnerList;
	}
	/**
	 * �湮��û����Ʈ�� ��ȯ�Ѵ�. 
	 * @return �湮��û����Ʈ 
	 */
	public VisitRequestInfoForOwnerList getVisitRequestInfoForOwnerList() {
		return visitRequestInfoForOwnerList;
	}
	/**
	 * �湮��û����Ʈ�� �����Ѵ�. 
	 * @param visitRequestInfoForOwnerList �湮��û����Ʈ 
	 */
	public void setVisitRequestInfoForOwnerList(VisitRequestInfoForOwnerList visitRequestInfoForOwnerList) {
		this.visitRequestInfoForOwnerList = visitRequestInfoForOwnerList;
	}
	/**
	 * ȸ���ڵ带 �̿��Ͽ� �ڽ�(������)���� �湮��û�� �湮��û����Ʈ�� <br>
	 * �����ͺ��̽����� ������ ����� �����Ѵ�.  
	 * @param memberCode ȸ���ڵ� 
	 */
	public void setVisitRequestInfoForOwnerList(String houseOwnerCode){
		//  VisitAcceptManager�� ��� VisitRequestInfoForOwnerList�� �ʱ�ȭ ���ش�.
		VisitRequestInfoDAOManager visitRequestInfoDAOManager = new VisitRequestInfoDAOManager();
		visitRequestInfoForOwnerList = visitRequestInfoDAOManager.getRequesterInfos(houseOwnerCode);
	}
	/**
	 * �湮�����Ѵ�. 
	 * @param houseOwnerCode ������ �ڵ� 
	 * @param touristCode ���ఴ �ڵ�  
	 * @return 
	 */
	public void accept(String houseOwnerCode, String touristCode){
		HouseOwnerInfoDAOManager houseOwnerInfoDAOManager = new HouseOwnerInfoDAOManager();
		houseOwnerInfoDAOManager.modifyVisitRequestState(houseOwnerCode, touristCode, "����");
	}
	/**
	 * �湮�����Ѵ�. 
	 * @param houseOwnerCode �������ڵ� 
	 * @param touristCode ���ఴ�ڵ� 
	 * @return �湮��û����Ʈ 
	 */
	public void refuse(String houseOwnerCode, String touristCode){
		HouseOwnerInfoDAOManager houseOwnerInfoDAOManager = new HouseOwnerInfoDAOManager();
		houseOwnerInfoDAOManager.modifyVisitRequestState(houseOwnerCode, touristCode, "����");
	}
}
