package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 공실상세정보목록 <br>EmptyRoomInfoManagerServlet에서 사용하는 클래스
 * @author 대곤
 *
 */
public class EmptyRoomDetailInfoList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8461667874572393113L;
	/**
	 * 공실상세정보목록
	 */
	private List<EmptyRoomDetailInfo> emptyRoomDetailInfoList;
/**
 * 널 생성자
 */
	public EmptyRoomDetailInfoList() {
		this(new ArrayList<EmptyRoomDetailInfo>());
	}
/**
 * 기본생성자
 * @param emptyRoomDetailInfoList 공실상세정보목록
 */
	public EmptyRoomDetailInfoList(
			List<EmptyRoomDetailInfo> emptyRoomDetailInfoList) {
		this.emptyRoomDetailInfoList = emptyRoomDetailInfoList;
	}
/**
 * 공싱상세정보목록 반환
 * @return 공싱상세정보목록
 */
	public List<EmptyRoomDetailInfo> getEmptyRoomDetailInfoList() {
		return emptyRoomDetailInfoList;
	}
/**
 * 공실상세정보목록 설정
 * @param emptyRoomDetailInfoList 공실상세정보목록
 */
	public void setEmptyRoomDetailInfoList(
			List<EmptyRoomDetailInfo> emptyRoomDetailInfoList) {
		this.emptyRoomDetailInfoList = emptyRoomDetailInfoList;
	}
	/**
	 * 공실상세정보 추가
	 * @param emptyRoomDetailInfo 공실상세정보
	 * @return 추가여부
	 */
	public boolean addEmptyRoomDetailInfo(EmptyRoomDetailInfo emptyRoomDetailInfo){
		if(emptyRoomDetailInfoList.add(emptyRoomDetailInfo)){
			return true;
		}
		return false;
	}
	/**
	 * 공실상세정보 삭제
	 * @param emptyRoomDetialInfoCode 공실상세정보코드
	 * @return 삭제여부
	 */
	public boolean deleteEmptyRoomDetailInfo(String emptyRoomDetialInfoCode){
		for(EmptyRoomDetailInfo emptyRoomDetailInfo : emptyRoomDetailInfoList){
			if(emptyRoomDetailInfo.getEmptyRoomCode().equals(emptyRoomDetialInfoCode)){
				emptyRoomDetailInfoList.remove(emptyRoomDetailInfo);
				return true;
			}
		}
		return false;
	}
	/**
	 * 공실상세정보 검색
	 * @param emptyRoomDetialInfoCode 공실상세정보코드
	 * @return 공실상세정보
	 */
	public EmptyRoomDetailInfo searchEmptyRoomDetailInfo(String emptyRoomDetialInfoCode){
		for(EmptyRoomDetailInfo emptyRoomDetailInfo : emptyRoomDetailInfoList){
			if(emptyRoomDetailInfo.getEmptyRoomCode().equals(emptyRoomDetialInfoCode))
				return emptyRoomDetailInfo;
		}
		return null;
	}
	/**
	 * 공실상세정보 수정
	 * @param emptyRoomDetailInfoCode 공실상세정보코드
	 * @param emptyRoomDetialInfo 공실상세정보
	 * @return 수정여부
	 */
	public boolean reviseEmptyRoomDetailInfo(String emptyRoomDetailInfoCode, EmptyRoomDetailInfo emptyRoomDetialInfo){
		for(EmptyRoomDetailInfo temp : emptyRoomDetailInfoList){
			if(temp.getEmptyRoomCode().equals(emptyRoomDetialInfo.getEmptyRoomCode())){
				int index = emptyRoomDetailInfoList.indexOf(temp);
				emptyRoomDetailInfoList.set(index, emptyRoomDetialInfo);
				return true;
			}
		}
		return false;
	}
	
}
