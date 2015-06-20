package dbmanager;

import java.util.List;

import converter.ConvertGregorianCalendar;

import dao.EmptyRoomDAO;
import dto.EmptyRoomDTO;
import model.EmptyRoomInfoList;
import model.EmptyRoomInfo;

/**
 * application계층 매니져인 EmptyRoomInfoManager에서 공실정보 관리에 대한 요청을 받아 처리후 전달한다
 * @author 화섭
 *
 */
public class HotelEmptyRoomDAOManager 
{
	private EmptyRoomDAO emptyRoomDAO;
	
	/**
	 * 공실정보 테이블 관리 클래스 EmptyRoomDAO를 인스턴스화 한다
	 */
	public HotelEmptyRoomDAOManager()
	{
		emptyRoomDAO=new EmptyRoomDAO();
	}
	
	/**
	 * 화원코드에 해당하는 숙박업체코드를 EmptyRoomDAO로 요청하여 결과를 application계층 매니져인 EmptyRoomInfoManager에 전달한다
	 * @param memberCode 회원코드
	 * @return 회원코드에 해당하는 숙박업체 코드
	 */
	public String getHotelCode(String memberCode)
	{
		return null;
	}
	
	/**
	 * 숙박업체코드에 해당하는 공실정보들을 EmptyRoomDAO로 요청하여 결과를 application계층 매니져인 EmptyRoomInfoManager에 전달한다
	 * @param hotelManagerCode
	 * @return
	 */
	public EmptyRoomInfoList getEmptyRoomInfos(String hotelManagerCode)
	{
		System.out.println("HotelEmptyRoomDAO : "+ hotelManagerCode);
		EmptyRoomInfoList emptyRoomInfoList = new EmptyRoomInfoList();
		List<EmptyRoomDTO> list = emptyRoomDAO.selectEmptyRooms(hotelManagerCode);
		for(EmptyRoomDTO room : list){
			String[] facilityList = room.getFacilityList().split(",");
			EmptyRoomInfo emptyRoomInfo = new EmptyRoomInfo(room.getEmptyRoomCode(),room.getRoomName(), room.getOldPrice(), room.getDiscountPrice(), room.getSpace(),new ConvertGregorianCalendar().convert( room.getAvailableDate()),room.getHotelManagerCode(), room.getCheckInTime(), room.getCheckOutTime(), room.getCapacity(), facilityList, room.getEtc());
			emptyRoomInfoList.addEmptyRoomInfo(emptyRoomInfo);
		}
		return emptyRoomInfoList;
	}
	
	/**
	 * 공실정보 저장을 EmptyRoomDAO로 요청하여 application계층 매니져인 EmptyRoomInfoManager에 처리결과를 전달한다
	 * @param emptyRoomInfo 공실정보
	 * @return 저장결과를 전달한다
	 */
	public boolean saveEmptyRoom(EmptyRoomInfo emptyRoomInfo)
	{
		String facilityList="";
		for(String str :emptyRoomInfo.getFacilityList() ){
			facilityList+=str;
			facilityList+=",";
		}
		return emptyRoomDAO.insert(emptyRoomInfo.getHotelCode(), emptyRoomInfo.getEmptyRoomName(), emptyRoomInfo.getDiscountPrice(), 
				emptyRoomInfo.getOldPrice(), emptyRoomInfo.getCapacity(), emptyRoomInfo.getSpace(), emptyRoomInfo.getCheckInTime(),
				emptyRoomInfo.getCheckOutTime(),facilityList , emptyRoomInfo.getEtc());
	}
	
	/**
	 * 등록된 모든 공실정보 삭제를 EmptyRoomDAO로 요청하여 application계층 매니져인 EmptyRoomInfoManager에 삭제결과를 전달한다
	 * @return 삭제결과
	 */
	public boolean deleteAllEmptyRoom()
	{
		return true;
	}
	
	/**
	 * 공실정보 코드에 해당하는 공실정보 삭제를 EmptyRoomDAO로 요청하여 application계층 매니져인 EmptyRoomInfoManager에 삭제결과를 전달한다
	 * @param emptyRoomCode
	 * @return 삭제결과
	 */
	public boolean deleteEmptyRoom(String emptyRoomCode)
	{
		EmptyRoomDAO emptyRoomDAO = new EmptyRoomDAO();
		return emptyRoomDAO.deleteEmptyRoom(emptyRoomCode);
	}
	
	/**
	 * 숙박업체코드에 해당하는 공실정보 삭제를 EmptyRoomDAO로 요청하여 application계층 매니져인 EmptyRoomInfoManager에 삭제결과를 전달한다
	 * @param hotelManagerCode
	 * @return 삭제결과
	 */
	public boolean deleteEmptyRooms(String hotelManagerCode)
	{
		return true;
	}
	
	/**
	 * 공실정보 수정을 EmptyROomDAO로 요청하여 application계층 매져인 EmptyRoomInfoManager에 수정결과를 전달한다
	 * @param emptyRoomCode 공실정보코드
	 * @param modifyInfo 수정할 공실정보
	 * @return 수정결과
	 */
	public boolean update(String emptyRoomCode, EmptyRoomInfo modifyInfo)
	{
		System.out.println("HotelEmptyRoomDAOManager: "+emptyRoomCode);
		String facilityList="";
		for(String str :modifyInfo.getFacilityList() ){
			facilityList+=str;
			facilityList+=",";
		}System.out.println("HotelEmptyRoomDAOManager update메소드 : "+facilityList);
		return emptyRoomDAO.update(emptyRoomCode, modifyInfo.getEmptyRoomName(), modifyInfo.getDiscountPrice(), modifyInfo.getOldPrice(), modifyInfo.getCapacity(), 
				modifyInfo.getSpace(), modifyInfo.getCheckInTime(), modifyInfo.getCheckOutTime(), facilityList, modifyInfo.getEtc());
	}
}
