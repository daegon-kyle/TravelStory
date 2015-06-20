package model;

import java.util.List;
import java.util.ArrayList;
/**
 * 여행객을 위한 방문신청정보목록을 캡슐화하고 있는 클래스  
 * @author 영한
 *
 */
public class VisitRequestInfoForTouristList implements  java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2838732373137009894L;
	/**
	 * 방문신청정보 목록
	 * 여행객이 신청한 집주인정보와 신청상태를 목록으로 갖고있다.
	 */
	private List<VisitRequestInfoForTourist> visitRequestForTouristList;
	/**
	 * null생성자 
	 */
	public VisitRequestInfoForTouristList() {
		this(new ArrayList<VisitRequestInfoForTourist>());
	}
/**
 * 여행객을 위한 방문신청정보를 초기화하는 생성자 
 * @param visitRequestForTouristList 여행객을 위한 방문신청정보
 */
	public VisitRequestInfoForTouristList(
			List<VisitRequestInfoForTourist> visitRequestForTouristList) {
		this.visitRequestForTouristList = visitRequestForTouristList;
	}
/**
 * 여행객을 위한 방문신청정보을 반환한다. 
 * @return 여행객을 위한 방문신청정보
 */
	public List<VisitRequestInfoForTourist> getVisitRequestForTourist() {
		return visitRequestForTouristList;
	}
	/**
	 * 여행객을 위한 방문신청정보를 세팅한다. 
	 * @param visitRequestForTourist 여행객을 위한 방문신청정보 
	 */
	public void setVisitRequestForTourist(	
			List<VisitRequestInfoForTourist> visitRequestForTourist) {
		this.visitRequestForTouristList = visitRequestForTourist;
	}
	/**
	 * 방문신청정보를 추가하기 위한 메소드 
	 * @param visitRequestInfoForTourist 추가할 방문신청정보 목록 
	 * @return 성공적으로 추가되었을 경우 true리턴, 아니면 false리턴 
	 */
	public boolean addVisitRequestInfoForTourist(VisitRequestInfoForTourist visitRequestInfoForTourist){
		if(visitRequestForTouristList.add(visitRequestInfoForTourist))
			return true;
		else
			return false;
	}
	/**
	 * 방문신청여행객정보를 삭제하기 위한 메소드 
	 * @param email 삭제할 방문신청정보의 이메일 
	 * @return 삭제한 방문신청정보를 리턴 ,삭제되지 않았으면 null리턴
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
	 * 방문신청정보를 검색하기 위한 메소드 
	 * @param email 검색할 방문신청정보의 이메일
	 * @return 검색한 방문신청정보를 리턴 , 검색결과가 없는경우 null리턴 
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
	 * 방문신청정보를 수정하기 위한 메소드 
	 * @param email 수정할 방문신청정보의 이메일 
	 * @param newVisitRequestInfoForTourist 새롭게 수정할 방문신청정보 
 	 * @return 수정한 방문신청 정보 , 아니면 null리턴 
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
