package model;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
/**
 * 집주인을 위한 여행 방문 신청정보목록을 캡슐화 하고 있는 클래스 
 * @author 영한
 *
 */
public class VisitRequestInfoForOwnerList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3120692729934194046L;
	/**
	 * 집주인을 위한 방문신청정보 목록 
	 */
	private List<VisitRequestInfoForOwner> visitRequestInfoForOwnerList;
	/**
	 * null 생성자 
	 */
	public VisitRequestInfoForOwnerList() {
		this(new ArrayList<VisitRequestInfoForOwner>());
	}
	/**
	 * 오버로딩 생성자 
	 * @param visitRequestInfoForOwnerList 집주인을 위한 방문신청 정보목록 
	 */
	public VisitRequestInfoForOwnerList(List<VisitRequestInfoForOwner> visitRequestInfoForOwnerList) {
		this.visitRequestInfoForOwnerList = visitRequestInfoForOwnerList;
	}
/**
 * 방문신청 정보목록을 반환한다. 
 * @return 집주인을 위한 방문신청 정보목록 
 */
	public List<VisitRequestInfoForOwner> getVisitRequestInfoForOwner() {
		return visitRequestInfoForOwnerList;
	}
	/**
	 * 방문신청목록을 세팅한다. 
	 * @param visitRequestInfoForOwnerList 집주인을 위한 방문신청목록
	 */
	public void setVisitRequestInfoForOwner(List<VisitRequestInfoForOwner> visitRequestInfoForOwnerList) {
		this.visitRequestInfoForOwnerList = visitRequestInfoForOwnerList;
	}
	/**
	 * 방문신청목록에 추가하기 위한 메소드 
	 * @param visitRequestInfoForOwner 추가할 방문신청정보 
	 * @return 성공적으로 추가되었을 경우 true리턴 , 아니면 false리턴
	 */
	public boolean addVisitRequestInfoForOwner(VisitRequestInfoForOwner visitRequestInfoForOwner){
		if(visitRequestInfoForOwnerList.add(visitRequestInfoForOwner))
			return true;
		else
			return false;
	}
	/**
	 * 방문신청 정보목록을 삭제하기 위한 메소드
	 * @param email
	 * @return 삭제한 방문신청정보 리턴, 삭제되지 않았을 경우 null리턴 
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
	 * 방문신청정보를 검색하기 위한 메소드 
	 * @param email 삭제할 여행객방문신청정보의 이메일 
	 * @return 삭제한 여행객방문신청정보, 삭제되지 않은경우 null리턴 
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
	 * 방문신청정보를 수정하기 위한 메소드 
	 * @param email 수정할 방문신청정보의 이메일 
	 * @param newVisitRequestInfoForOwner 새롭게 입력할 방문신청정보 
	 * @return 수정한 방문신청정보를 리턴, 수정하지 않았다면 null리턴 
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
