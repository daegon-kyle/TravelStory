package model;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
/**
 * �������� ���� ���� �湮 ��û��������� ĸ��ȭ �ϰ� �ִ� Ŭ���� 
 * @author ����
 *
 */
public class VisitRequestInfoForOwnerList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3120692729934194046L;
	/**
	 * �������� ���� �湮��û���� ��� 
	 */
	private List<VisitRequestInfoForOwner> visitRequestInfoForOwnerList;
	/**
	 * null ������ 
	 */
	public VisitRequestInfoForOwnerList() {
		this(new ArrayList<VisitRequestInfoForOwner>());
	}
	/**
	 * �����ε� ������ 
	 * @param visitRequestInfoForOwnerList �������� ���� �湮��û ������� 
	 */
	public VisitRequestInfoForOwnerList(List<VisitRequestInfoForOwner> visitRequestInfoForOwnerList) {
		this.visitRequestInfoForOwnerList = visitRequestInfoForOwnerList;
	}
/**
 * �湮��û ��������� ��ȯ�Ѵ�. 
 * @return �������� ���� �湮��û ������� 
 */
	public List<VisitRequestInfoForOwner> getVisitRequestInfoForOwner() {
		return visitRequestInfoForOwnerList;
	}
	/**
	 * �湮��û����� �����Ѵ�. 
	 * @param visitRequestInfoForOwnerList �������� ���� �湮��û���
	 */
	public void setVisitRequestInfoForOwner(List<VisitRequestInfoForOwner> visitRequestInfoForOwnerList) {
		this.visitRequestInfoForOwnerList = visitRequestInfoForOwnerList;
	}
	/**
	 * �湮��û��Ͽ� �߰��ϱ� ���� �޼ҵ� 
	 * @param visitRequestInfoForOwner �߰��� �湮��û���� 
	 * @return ���������� �߰��Ǿ��� ��� true���� , �ƴϸ� false����
	 */
	public boolean addVisitRequestInfoForOwner(VisitRequestInfoForOwner visitRequestInfoForOwner){
		if(visitRequestInfoForOwnerList.add(visitRequestInfoForOwner))
			return true;
		else
			return false;
	}
	/**
	 * �湮��û ��������� �����ϱ� ���� �޼ҵ�
	 * @param email
	 * @return ������ �湮��û���� ����, �������� �ʾ��� ��� null���� 
	 */
	public VisitRequestInfoForOwner deleteRequestInfoForOwner(String email){
		for(VisitRequestInfoForOwner temp: visitRequestInfoForOwnerList){
			if(temp.getToruistEssentialInfo().getEmail().equals(email)){
				visitRequestInfoForOwnerList.remove(temp);
				return temp;
			}
		}
		return null;
	}
	/**
	 * �湮��û������ �˻��ϱ� ���� �޼ҵ� 
	 * @param email ������ ���ఴ�湮��û������ �̸��� 
	 * @return ������ ���ఴ�湮��û����, �������� ������� null���� 
	 */
	public VisitRequestInfoForOwner searchRequestInfoForOwner(String email){
		for(VisitRequestInfoForOwner temp: visitRequestInfoForOwnerList){
			if(temp.getToruistEssentialInfo().getEmail().equals(email)){
				return temp;
			}
		}
		return null;
	}
	/**
	 * �湮��û������ �����ϱ� ���� �޼ҵ� 
	 * @param email ������ �湮��û������ �̸��� 
	 * @param newVisitRequestInfoForOwner ���Ӱ� �Է��� �湮��û���� 
	 * @return ������ �湮��û������ ����, �������� �ʾҴٸ� null���� 
	 */
	public VisitRequestInfoForOwner reviseRequestInfoForOwner(String email,VisitRequestInfoForOwner newVisitRequestInfoForOwner){
		for(VisitRequestInfoForOwner temp: visitRequestInfoForOwnerList){
			if(temp.getToruistEssentialInfo().getEmail().equals(email)){
				int index=visitRequestInfoForOwnerList.indexOf(temp);
				visitRequestInfoForOwnerList.set(index, newVisitRequestInfoForOwner);
				return temp;
			}
		}
		return null;
	}
}
