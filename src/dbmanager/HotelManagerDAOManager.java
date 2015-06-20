package dbmanager;

import java.util.GregorianCalendar;

import dao.HotelManagerDAO;
import dao.MemberDAO;
import dto.HotelManagerDTO;
import dto.MemberDTO; 
import model.HotelInfo;
import model.HotelInfoList;
import model.MemberInfo;

/**
 * Application 메니저인 HotelInfoRegistrationManager로부터 숙박업체 관리를 요청 받아 처리하는DB계층 매니저 클래스   
 * @author 화섭
 *
 */
public class HotelManagerDAOManager 
{
	private HotelManagerDAO hotelManagerDAO; 
	
	/**
	 * 기본생성자로 HotelManagerDAO를 인스턴스화한다
	 */
	public HotelManagerDAOManager()
	{
		hotelManagerDAO=new HotelManagerDAO(); 
	}
	
	/**
	 * 숙박업체 등록을 HotelManagerDAO에게 요청하고 처리결과를 Application 메니저인 HotelInfoRegistrationManager로 전달한다 	
	 * @param memberCode 회원고유식별코드
	 * @param hotelInfo 등록할 숙박업체 정보
	 * @return 숙박업체 등록 성공여부를 전달한다
	 */
	public boolean save(String memberCode, HotelInfo hotelInfo)
	{
		String hotelName=hotelInfo.getHotelName();
		String hotelLocation=hotelInfo.getHotelLocation();
		String hotelIntroduction=hotelInfo.getHotelIntroduction();
		String reservationPagePath=hotelInfo.getReservationPagePath();
		
		return hotelManagerDAO.insert(memberCode, hotelName, hotelLocation, hotelIntroduction, reservationPagePath);
	}
	
	/**
	 * 등록된 숙박업체 삭제를 HotelMangerDAO에 요청하고 처리결과를 Application 메니저인 HotelInfoRegistrationManager로 전달한다
	 * @return 삭제 성공여부를 전달한다
	 */
	public boolean deleteAll()
	{
		return hotelManagerDAO.deleteAll();
	}
	
	/**
	 * 회원코드에 해당하는 숙박업체정보 삭제를 HotelManagerDAO에 요청하고 처리결과를 Application 메니저인 HotelInfoRegistrationManager로 전달한다
	 * @param memberCode 회원코드
	 * @return 삭제 성공여부
	 */
	public boolean delete(String memberCode)
	{
		return hotelManagerDAO.delete(memberCode);
	}
	
	/**
	 * 등록된 모든 숙박업체 정보 검색을 HotelManagerDAO에 요청하고 처리결과를 Application 매니저인 HotelManagerdAOManager로 전달한다
	 * @return 등록된 모든 숙박업체 정보를 전달한다
	 */
	public HotelInfoList getAll()
	{
		HotelInfoList list=new HotelInfoList();
		
		for(HotelManagerDTO hotelManagerDTO:hotelManagerDAO.selectAll())
		{
			HotelInfo hotelInfo=changeToHotelInfo(hotelManagerDTO);
			list.addHotelInfo(hotelInfo);
		}
		return list;
	}
	
	/**
	 * 회원정보에 해당하는 숙박업체관리자코드를 HotelManagerDAO에 요청하고 처리결과를 Application매니져인 HotelManagerDAOManager로 전달한다
	 * @param memberCode 회원코드
	 * @return 회원코드에 해당하는 숙박업체관리자코드
	 */
	public String getHotelManagerCode(String memberCode)
	{
		return hotelManagerDAO.selectHotelManagerCode(memberCode);
	}
	
	/**
	 * 숙박업체관리자코드에 해당하는 숙박업체정보를 HotelManagerDAO에 요청하고 처리결과를 APplication매니져인 HotelManagerDAOManger로 전달한다
	 * @param hotelManagerCode 숙박업체관리자코드
	 * @return 숙박업체 관리자코드에 해당하는 숙박업체정보를 전달한다
	 */
	public HotelInfo getByHotelManagerCode(String hotelManagerCode)
	{
		HotelInfo hotelInfo=changeToHotelInfo(hotelManagerDAO.selectByHotelManagerCode(hotelManagerCode));
		return hotelInfo;
	}
	
	/**
	 * 회원코드에 해당하는 숙박업체정보를 HotelManagerDAO에 요청하고 처리결과를 APplication매니져인 HotelManagerDAOManger로 전달한다
	 * @param memberCode 회원코드
	 * @return 회원코드에 해당하는 숙박업체정보를 전달한다
	 */
	public HotelInfo getByMemberCode(String memberCode)
	{
		HotelInfo hotelInfo=changeToHotelInfo(hotelManagerDAO.selectByMemberCode(memberCode));
		return hotelInfo;
	}
	
	/**
	 * 위치에 해당하는 숙박업체정보를 HotelManagerDAO에 요청하고 처리결과를 APplication매니져인 HotelManagerDAOManger로 전달한다
	 * @param location 숙박업체 위치
	 * @return 숙박업체 위치에 해당하는 숙박업체정보들을 전달한다
	 */
	public HotelInfoList getByLocation(String location)
	{
		HotelInfoList list=new HotelInfoList();
		for(HotelManagerDTO hotelManagerDTO:hotelManagerDAO.selectByLocation(location))
		{
			list.addHotelInfo(changeToHotelInfo(hotelManagerDTO));
		} 
		return list;
	}
	
	/**
	 * 회원코드에 해당하는 숙박업체의 정보 수정을  HotelManagerDAO에 요청하고 처리결과를 APplication매니져인 HotelManagerDAOManger로 전달한다
	 * @param memberCode 회원코드
	 * @param hotelInfo 숙박업체 정보
	 * @return 수정성공여부
	 */
	public boolean modify(String memberCode, HotelInfo hotelInfo)
	{
		String hotelManagerCode=hotelInfo.getHotelCode();
		String hotelName=hotelInfo.getHotelName();
		String hotelLocation=hotelInfo.getHotelLocation();
		String hotelIntroduction=hotelInfo.getHotelIntroduction();
		String reservationPagePath=hotelInfo.getReservationPagePath();
		
		return hotelManagerDAO.update(hotelManagerCode, hotelName, hotelLocation, hotelIntroduction, reservationPagePath);
	}

	/**
	 * 숙박업체 테이블 정보 HotelManagerDTO클래스를 계층간 숙박업체 정보를 전달할 HotelInfo 클래스로 변환한다 
	 * @param hotelManagerDTO 숙박업체 테이블 정보
	 * @return 계층간 숙박업체정보를 전달할 클래스
	 */
	public HotelInfo changeToHotelInfo(HotelManagerDTO hotelManagerDTO)
	{
		String hotelName=hotelManagerDTO.getHotelName();
		String hotelCode=hotelManagerDTO.getHotelManagerCode();
		String hotelLocation=hotelManagerDTO.getHotelLocation();
		String hotelIntroduction=hotelManagerDTO.getHotelIntroduction();
		String reservationPagePath=hotelManagerDTO.getReservationPagePath();
		
		HotelInfo hotelInfo=new HotelInfo(hotelName, hotelCode, hotelLocation, hotelIntroduction, reservationPagePath);
		
		return hotelInfo;
	}
}
