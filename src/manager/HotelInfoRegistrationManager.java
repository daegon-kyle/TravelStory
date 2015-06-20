package manager;

import dao.HotelManagerDAO;
import model.HotelInfo;
/**
 * 사용자가 숙박업체가 되기 위해 입력한 정보를 DB에 저장하기 위한 클래스
 * @author 대곤
 *
 */
public class HotelInfoRegistrationManager {
	/**
	 * 호텔정보
	 */
	private HotelInfo hotelInfo;

	/**
	 * 널생성자
	 */
	public HotelInfoRegistrationManager() {
		this(new HotelInfo());
	}
/**
 * 기본생성자
 * @param hotel 숙박업체정보
 */
	public HotelInfoRegistrationManager(HotelInfo hotel) {
		this.hotelInfo = hotel;
	}
	
	
	
/**
 * 숙박업체정보 반환
 * @return 숙박업체정보
 */
	public HotelInfo getHotelInfo() {
		return hotelInfo;
	}
/**
 * 숙박업체정보 설정
 * @param hotelInfo 숙박업체정보
 */
	public void setHotelInfo(HotelInfo hotelInfo) {
		this.hotelInfo = hotelInfo;
	}
	
	
	
	/**
	 * HotelManagerDAOManager 클래스의 save 메소드를 통해 호텔정보 저장
	 * @param memberCode 회원코드
	 * @return 저장 성공여부
	 */
	public boolean registerHotelInfo(String memberCode)
	{
		String hotelName=hotelInfo.getHotelName();
		String hotelLocation=hotelInfo.getHotelLocation();
		String hotelIntroduction=hotelInfo.getHotelIntroduction();
		String reservationPagePath=hotelInfo.getReservationPagePath();
		HotelManagerDAO  hotelManagerDAO=new HotelManagerDAO();	
		return hotelManagerDAO.insert(memberCode, hotelName, hotelLocation, hotelIntroduction, reservationPagePath);
	}
	
	public String getHotelManagerCode(String memberCode)
	{
		HotelManagerDAO hotelManagerDAO=new HotelManagerDAO();
		return hotelManagerDAO.selectHotelManagerCode(memberCode);
	}
}
