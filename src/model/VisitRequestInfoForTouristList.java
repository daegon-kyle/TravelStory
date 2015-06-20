package model;

import java.util.List;
import java.util.ArrayList;
/**
 * ���ఴ�� ���� �湮��û��������� ĸ��ȭ�ϰ� �ִ� Ŭ����  
 * @author ����
 *
 */
public class VisitRequestInfoForTouristList implements  java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2838732373137009894L;
	/**
	 * �湮��û���� ���
	 * ���ఴ�� ��û�� ������������ ��û���¸� ������� �����ִ�.
	 */
	private List<VisitRequestInfoForTourist> visitRequestForTouristList;
	/**
	 * null������ 
	 */
	public VisitRequestInfoForTouristList() {
		this(new ArrayList<VisitRequestInfoForTourist>());
	}
/**
 * ���ఴ�� ���� �湮��û������ �ʱ�ȭ�ϴ� ������ 
 * @param visitRequestForTouristList ���ఴ�� ���� �湮��û����
 */
	public VisitRequestInfoForTouristList(
			List<VisitRequestInfoForTourist> visitRequestForTouristList) {
		this.visitRequestForTouristList = visitRequestForTouristList;
	}
/**
 * ���ఴ�� ���� �湮��û������ ��ȯ�Ѵ�. 
 * @return ���ఴ�� ���� �湮��û����
 */
	public List<VisitRequestInfoForTourist> getVisitRequestForTourist() {
		return visitRequestForTouristList;
	}
	/**
	 * ���ఴ�� ���� �湮��û������ �����Ѵ�. 
	 * @param visitRequestForTourist ���ఴ�� ���� �湮��û���� 
	 */
	public void setVisitRequestForTourist(	
			List<VisitRequestInfoForTourist> visitRequestForTourist) {
		this.visitRequestForTouristList = visitRequestForTourist;
	}
	/**
	 * �湮��û������ �߰��ϱ� ���� �޼ҵ� 
	 * @param visitRequestInfoForTourist �߰��� �湮��û���� ��� 
	 * @return ���������� �߰��Ǿ��� ��� true����, �ƴϸ� false���� 
	 */
	public boolean addVisitRequestInfoForTourist(VisitRequestInfoForTourist visitRequestInfoForTourist){
		if(visitRequestForTouristList.add(visitRequestInfoForTourist))
			return true;
		else
			return false;
	}
	/**
	 * �湮��û���ఴ������ �����ϱ� ���� �޼ҵ� 
	 * @param email ������ �湮��û������ �̸��� 
	 * @return ������ �湮��û������ ���� ,�������� �ʾ����� null����
	 */
	public VisitRequestInfoForTourist deleteVisitRequestInfoForTourist(String email){
		for(VisitRequestInfoForTourist temp:visitRequestForTouristList){
			if(temp.getHouseOwnerEssentialInfo().getEmail().equals(email)){
				visitRequestForTouristList.remove(temp);
				return temp;
			}
		}
		return null;
	}
	/**
	 * �湮��û������ �˻��ϱ� ���� �޼ҵ� 
	 * @param email �˻��� �湮��û������ �̸���
	 * @return �˻��� �湮��û������ ���� , �˻������ ���°�� null���� 
	 */
	public VisitRequestInfoForTourist searchVisitRequestInfoForTourist(String email){
		for(VisitRequestInfoForTourist temp:visitRequestForTouristList){
			if(temp.getHouseOwnerEssentialInfo().getEmail().equals(email)){
				return temp;
			}
		}
		return null;
	}
	/**
	 * �湮��û������ �����ϱ� ���� �޼ҵ� 
	 * @param email ������ �湮��û������ �̸��� 
	 * @param newVisitRequestInfoForTourist ���Ӱ� ������ �湮��û���� 
 	 * @return ������ �湮��û ���� , �ƴϸ� null���� 
	 */
	public VisitRequestInfoForTourist reviseVisitRequestInfoForTourist(String email, VisitRequestInfoForTourist newVisitRequestInfoForTourist){
		for(VisitRequestInfoForTourist temp:visitRequestForTouristList){
			if(temp.getHouseOwnerEssentialInfo().getEmail().equals(email)){
				int index=visitRequestForTouristList.indexOf(temp);
				visitRequestForTouristList.set(index, newVisitRequestInfoForTourist);
				return temp;
			}
		}
		return null;
	}
}
