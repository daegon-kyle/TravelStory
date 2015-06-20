package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 호텔목록을 보여주기 위해 만들어진 EmptyRoomListInfo를 캡슐화한 목록 클래스
 *  <br>EmptyRoomInfoManagerServlet, EmptyRoomReservationServlet에서 사용하는 클래스
 */
public class EmptyRoomListInfoList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1522093948730549752L;
	/**
	 * 공실정보목록정보 보여주기 위한 목록
	 */
	private List<EmptyRoomListInfo> emptyRoomListInfoList;
	
	/**
	 * 널생성자
	 */
	public EmptyRoomListInfoList() {
		this(new ArrayList<EmptyRoomListInfo>());
	}
/**
 * 기본생성자
 * @param emptyRoomListInfoList 공실목록정보의목록
 */
	public EmptyRoomListInfoList(List<EmptyRoomListInfo> emptyRoomListInfoList) {
		this.emptyRoomListInfoList = emptyRoomListInfoList;
	}
/**
 * 공실목록정보의 목록을 반환
 * @return 공실목록정보목록
 */
	public List<EmptyRoomListInfo> getEmptyRoomListInfoList() {
		return emptyRoomListInfoList;
	}
/**
 * 공실목록정보의 목록 설정
 * @param emptyRoomListInfoList 공실목록정보
 */
	public void setEmptyRoomListInfoList(
			List<EmptyRoomListInfo> emptyRoomListInfoList) {
		this.emptyRoomListInfoList = emptyRoomListInfoList;
	}
	/**
	 * 공실목록정보의 목록에 공실목록정보 추가하기 위한 클래스
	 * @param emptyRoomListInfo 추가하려는 공실목록정보
	 * @return 추가된 공실목록정보
	 */
	public boolean addEmptyRoomListInfo(EmptyRoomListInfo emptyRoomListInfo)
	{
		return emptyRoomListInfoList.add(emptyRoomListInfo);
	}
}
