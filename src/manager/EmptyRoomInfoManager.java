package manager;

import dbmanager.HotelEmptyRoomDAOManager;
import model.EmptyRoomInfo;
import model.EmptyRoomInfoList;
/**
 * 공실정보를 관리하기 위해 사용하는 매니저
 * @author 대곤
 *
 */
public class EmptyRoomInfoManager {
	/**
	 * 공실정보
	 */
	private EmptyRoomInfo emptyRoomInfo;
	
	/**
	 * 널생성자
	 */
	public EmptyRoomInfoManager() {
		this(new EmptyRoomInfo());
	}
/**
 * 기본생성자
 * @param emptyRoomInfo 공실정보
 */
	public EmptyRoomInfoManager(EmptyRoomInfo emptyRoomInfo) {
		this.emptyRoomInfo = emptyRoomInfo;
	}
/**
 * 공실정보 반환
 * @return 공실정보
 */
	public EmptyRoomInfo getEmptyRoomInfo() {
		return emptyRoomInfo;
	}
/**
 * 공실정보 설정
 * @param emptyRoomInfo 공실정보
 */
	public void setEmptyRoomInfo(EmptyRoomInfo emptyRoomInfo) {
		this.emptyRoomInfo = emptyRoomInfo;
	}
	/**
	 * 공실정보 추가, HotelEmptyRoomDAOManager의 save메소드 호출
	 * @return 추가한 공실정보
	 */
	public boolean addEmptyRoomInfo(){
		HotelEmptyRoomDAOManager hotelEmptyRoomDAOManager = new HotelEmptyRoomDAOManager();		
		return hotelEmptyRoomDAOManager.saveEmptyRoom(emptyRoomInfo);
	}
	/**
	 * 공실정보 삭제, HotelEmptyRoomDAOManager의 deleteEmptyRoom메소드 호출
	 * @return 삭제한 공실정보
	 */
	public EmptyRoomInfo deleteEmptyRoomInfo(){
		return null;
	}
	/**
	 * 공실코드를 이용하여 공실정보를 삭제한다. 
	 * @param emptyRoomCode
	 * @return 삭제성공시 true 반환 , 아니면 false
	 */
	public boolean deleteEmptyRoomInfo(String emptyRoomCode){
		HotelEmptyRoomDAOManager hotelEmptyRoomDAOManager  = new HotelEmptyRoomDAOManager();
		return hotelEmptyRoomDAOManager.deleteEmptyRoom(emptyRoomCode);
	}
	/**
	 * 공실정보 수정, HotelEmptyRoomDAOManager의 modify메소드 호출
	 * @return 수정한 공실정보
	 */
	public EmptyRoomInfo reviseEmptyRoomInfo(){
		System.out.println("EmptyRoomInfoManager: 진입");
		HotelEmptyRoomDAOManager hotelEmptyRoomDAOManager  = new HotelEmptyRoomDAOManager();
		if(hotelEmptyRoomDAOManager.update(emptyRoomInfo.getEmptyRoomCode(), emptyRoomInfo)){
			return emptyRoomInfo;
		}
		return null;
	}
	
	public EmptyRoomInfoList searchEmptyRoomInfo(){
		HotelEmptyRoomDAOManager hotelEmptyRoomDAOManager = new HotelEmptyRoomDAOManager();
		return hotelEmptyRoomDAOManager.getEmptyRoomInfos(emptyRoomInfo.getHotelCode());		
	}
	
}
