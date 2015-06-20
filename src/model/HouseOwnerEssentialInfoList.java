package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * 집주인정보를 목록으로 가지는 클래스
 * @author 대곤
 *
 */
public class HouseOwnerEssentialInfoList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2369250238687043587L;
	/**
	 * 집주인 정보 목록
	 */
	private List<HouseOwnerEssentialInfo> houseOwnerEssentialInfoList;
	
	/**
	 * 널생성자
	 */
	public HouseOwnerEssentialInfoList() {
		this.houseOwnerEssentialInfoList = new ArrayList<HouseOwnerEssentialInfo>();
	}
/**
 * 기본생성자
 * @param houseOwnerEssentialInfoList 집주인 필수정보목록
 */
	public HouseOwnerEssentialInfoList(
			List<HouseOwnerEssentialInfo> houseOwnerEssentialInfoList) {
		this.houseOwnerEssentialInfoList = houseOwnerEssentialInfoList;
	}
/**
 * 집주인필수정보목록 반환
 * @return
 */
	public List<HouseOwnerEssentialInfo> getHouseOwnerEssentialInfoList() {
		return houseOwnerEssentialInfoList;
	}
	/**
	 * 집주인 필수정보목록 설정
	 * @param houseOwnerEssentialInfoList 집주인필수정보목록
	 */
	public void setHouseOwnerEssentialInfoList(
			List<HouseOwnerEssentialInfo> houseOwnerEssentialInfoList) {
		this.houseOwnerEssentialInfoList = houseOwnerEssentialInfoList;
	}
	/**
	 * 집주인필수정보 추가
	 * @param houseOwnerEssentialInfo 집주인필수정보
	 * @return 집주인필수정보
	 */
	public HouseOwnerEssentialInfo addHouseOwnerInfo(HouseOwnerEssentialInfo houseOwnerEssentialInfo){
		
		if(houseOwnerEssentialInfoList.add(houseOwnerEssentialInfo))
			return houseOwnerEssentialInfo;
		return null;
	}
	/**
	 * 집주인필수정보를 검색
	 * @param email 이메일
	 * @return 집주인 필수정보
	 */
	public HouseOwnerEssentialInfo searchHouseOwnerInfo(String email){
		
		for(HouseOwnerEssentialInfo houseOwnerEssentialInfo : houseOwnerEssentialInfoList){
			if(houseOwnerEssentialInfo.getEmail().equals(email)){
				return houseOwnerEssentialInfo;
			}
		}
		return null;
	}
	/**
	 * 집주인 필수정보 수정
	 * @param email 이메일
	 * @param houseOwnerEssentialInfo 집주인필수정보
	 * @return 수정한 집주인필수정보
	 */
	public HouseOwnerEssentialInfo reviseHouseOwnerInfo(String email, HouseOwnerEssentialInfo houseOwnerEssentialInfo){
		for(HouseOwnerEssentialInfo temp : houseOwnerEssentialInfoList){
			if(temp.getEmail().equals(email)){
				int index = houseOwnerEssentialInfoList.indexOf(temp);
				houseOwnerEssentialInfoList.set(index, houseOwnerEssentialInfo);
				return temp;
			}
		}
		return null;
	}
	/**
	 * 집주인 필수정보 삭제
	 * @param email 이메일
	 * @return 삭제한 집주인필수정보
	 */
	public HouseOwnerEssentialInfo deleteHosueOwnerInfo(String email){
		HouseOwnerEssentialInfo houseOwnerEssentialInfo = searchHouseOwnerInfo(email);
		if(houseOwnerEssentialInfo != null){
			houseOwnerEssentialInfoList.remove(houseOwnerEssentialInfo);
		}
		return houseOwnerEssentialInfo;
	}
	
	
}
