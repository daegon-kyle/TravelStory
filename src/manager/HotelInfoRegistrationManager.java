package manager;

import dao.HotelManagerDAO;
import model.HotelInfo;
/**
 * ����ڰ� ���ھ�ü�� �Ǳ� ���� �Է��� ������ DB�� �����ϱ� ���� Ŭ����
 * @author ���
 *
 */
public class HotelInfoRegistrationManager {
	/**
	 * ȣ������
	 */
	private HotelInfo hotelInfo;

	/**
	 * �λ�����
	 */
	public HotelInfoRegistrationManager() {
		this(new HotelInfo());
	}
/**
 * �⺻������
 * @param hotel ���ھ�ü����
 */
	public HotelInfoRegistrationManager(HotelInfo hotel) {
		this.hotelInfo = hotel;
	}
	
	
	
/**
 * ���ھ�ü���� ��ȯ
 * @return ���ھ�ü����
 */
	public HotelInfo getHotelInfo() {
		return hotelInfo;
	}
/**
 * ���ھ�ü���� ����
 * @param hotelInfo ���ھ�ü����
 */
	public void setHotelInfo(HotelInfo hotelInfo) {
		this.hotelInfo = hotelInfo;
	}
	
	
	
	/**
	 * HotelManagerDAOManager Ŭ������ save �޼ҵ带 ���� ȣ������ ����
	 * @param memberCode ȸ���ڵ�
	 * @return ���� ��������
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
