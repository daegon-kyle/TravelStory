package model;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

/**
 * 공실 정보 목록
 * <br>EmptyRoomInfoManagerServlet과 EmptyRoomReservationServet에서 사용하는 클래스
 * @author 대곤
 *
 */
public class EmptyRoomInfoList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2659018967379338889L;
	/**
	 * 공실정보를 목록으로 가지는 멤버변수
	 */
	private List<EmptyRoomInfo> emptyRoomList;
/**
 * 널생성자
 */
	public EmptyRoomInfoList() {
		this(new ArrayList<EmptyRoomInfo>());
	}
	/**
	 * 기본생성자
	 * @param emptyRoomList 공실목록
	 */
	public EmptyRoomInfoList(List<EmptyRoomInfo> emptyRoomList) {
		this.emptyRoomList = emptyRoomList;
	}
	/**
	 * 공실정보목록반환
	 * @return 공실정보목록
	 */
	public List<EmptyRoomInfo> getEmptyRoomList() {
		return emptyRoomList;
	}
	/**
	 * 공실정보목록 설정
	 * @param emptyRoomList 공실정보목록
	 */
	public void setEmptyRoomList(List<EmptyRoomInfo> emptyRoomList) {
		this.emptyRoomList = emptyRoomList;
	}
/**
 * 공실정보 추가
 * @param emptyRoomInfo 공실정보
 * @return 추가여부
 */
	public boolean addEmptyRoomInfo(EmptyRoomInfo emptyRoomInfo){
		if(emptyRoomList.add(emptyRoomInfo))
			return true;
		else
			return false;
	}
	/**
	 * 공실정보 삭제
	 * @param emptyRoomCode 공실코드
	 * @return 삭제한 공실정보
	 */
	public EmptyRoomInfo deleteEmptyRoomInfo(String emptyRoomCode){
		for(EmptyRoomInfo temp:emptyRoomList){
			if(temp.getEmptyRoomCode().equals(emptyRoomCode)){
				emptyRoomList.remove(temp);
				return temp;
			}
		}
		return null;
	}
	/**
	 * 공실정보 검색
	 * @param emptyRoomCode 공실 코드
	 * @return 공실정보
	 */
	private EmptyRoomInfo searchEmptyRoomInfo(String emptyRoomCode){
		for(EmptyRoomInfo temp:emptyRoomList){
			if(temp.getEmptyRoomCode().equals(emptyRoomCode)){
				return temp;
			}
		}
		return null;
	}
	/**
	 * 공실정보 수정
	 * @param oldEmptyRoomInfo 기존공실정보
	 * @param newEmptyRoomInfo 새로운공실정보
	 * @return 수정된 공실정보
	 */
	public EmptyRoomInfo reviseEmptyRoomInfo(EmptyRoomInfo oldEmptyRoomInfo, EmptyRoomInfo newEmptyRoomInfo){
		for(EmptyRoomInfo temp:emptyRoomList){
			if(temp.getEmptyRoomCode().equals(oldEmptyRoomInfo.getEmptyRoomCode())){
				int index=emptyRoomList.indexOf(temp);
				emptyRoomList.set(index, newEmptyRoomInfo);
				return temp;
			}
		}
		return null;
	}
	/**
	 * 공실정보 수정
	 * @param emptyRoomCode 기존공실정보코드
	 * @param newEmptyRoomInfo 새로운 공실정보
	 * @return 수정된 공실정보
	 */
	public EmptyRoomInfo reviseEmptyRoomInfo(String emptyRoomCode, EmptyRoomInfo newEmptyRoomInfo){
		for(EmptyRoomInfo temp:emptyRoomList){
			if(temp.getEmptyRoomCode().equals(emptyRoomCode)){
				int index=emptyRoomList.indexOf(temp);
				emptyRoomList.set(index, newEmptyRoomInfo);
				return temp;
			}
		}
		return null;
	}
}
