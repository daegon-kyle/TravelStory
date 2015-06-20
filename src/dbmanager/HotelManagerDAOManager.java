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
 * Application �޴����� HotelInfoRegistrationManager�κ��� ���ھ�ü ������ ��û �޾� ó���ϴ�DB���� �Ŵ��� Ŭ����   
 * @author ȭ��
 *
 */
public class HotelManagerDAOManager 
{
	private HotelManagerDAO hotelManagerDAO; 
	
	/**
	 * �⺻�����ڷ� HotelManagerDAO�� �ν��Ͻ�ȭ�Ѵ�
	 */
	public HotelManagerDAOManager()
	{
		hotelManagerDAO=new HotelManagerDAO(); 
	}
	
	/**
	 * ���ھ�ü ����� HotelManagerDAO���� ��û�ϰ� ó������� Application �޴����� HotelInfoRegistrationManager�� �����Ѵ� 	
	 * @param memberCode ȸ�������ĺ��ڵ�
	 * @param hotelInfo ����� ���ھ�ü ����
	 * @return ���ھ�ü ��� �������θ� �����Ѵ�
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
	 * ��ϵ� ���ھ�ü ������ HotelMangerDAO�� ��û�ϰ� ó������� Application �޴����� HotelInfoRegistrationManager�� �����Ѵ�
	 * @return ���� �������θ� �����Ѵ�
	 */
	public boolean deleteAll()
	{
		return hotelManagerDAO.deleteAll();
	}
	
	/**
	 * ȸ���ڵ忡 �ش��ϴ� ���ھ�ü���� ������ HotelManagerDAO�� ��û�ϰ� ó������� Application �޴����� HotelInfoRegistrationManager�� �����Ѵ�
	 * @param memberCode ȸ���ڵ�
	 * @return ���� ��������
	 */
	public boolean delete(String memberCode)
	{
		return hotelManagerDAO.delete(memberCode);
	}
	
	/**
	 * ��ϵ� ��� ���ھ�ü ���� �˻��� HotelManagerDAO�� ��û�ϰ� ó������� Application �Ŵ����� HotelManagerdAOManager�� �����Ѵ�
	 * @return ��ϵ� ��� ���ھ�ü ������ �����Ѵ�
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
	 * ȸ�������� �ش��ϴ� ���ھ�ü�������ڵ带 HotelManagerDAO�� ��û�ϰ� ó������� Application�Ŵ����� HotelManagerDAOManager�� �����Ѵ�
	 * @param memberCode ȸ���ڵ�
	 * @return ȸ���ڵ忡 �ش��ϴ� ���ھ�ü�������ڵ�
	 */
	public String getHotelManagerCode(String memberCode)
	{
		return hotelManagerDAO.selectHotelManagerCode(memberCode);
	}
	
	/**
	 * ���ھ�ü�������ڵ忡 �ش��ϴ� ���ھ�ü������ HotelManagerDAO�� ��û�ϰ� ó������� APplication�Ŵ����� HotelManagerDAOManger�� �����Ѵ�
	 * @param hotelManagerCode ���ھ�ü�������ڵ�
	 * @return ���ھ�ü �������ڵ忡 �ش��ϴ� ���ھ�ü������ �����Ѵ�
	 */
	public HotelInfo getByHotelManagerCode(String hotelManagerCode)
	{
		HotelInfo hotelInfo=changeToHotelInfo(hotelManagerDAO.selectByHotelManagerCode(hotelManagerCode));
		return hotelInfo;
	}
	
	/**
	 * ȸ���ڵ忡 �ش��ϴ� ���ھ�ü������ HotelManagerDAO�� ��û�ϰ� ó������� APplication�Ŵ����� HotelManagerDAOManger�� �����Ѵ�
	 * @param memberCode ȸ���ڵ�
	 * @return ȸ���ڵ忡 �ش��ϴ� ���ھ�ü������ �����Ѵ�
	 */
	public HotelInfo getByMemberCode(String memberCode)
	{
		HotelInfo hotelInfo=changeToHotelInfo(hotelManagerDAO.selectByMemberCode(memberCode));
		return hotelInfo;
	}
	
	/**
	 * ��ġ�� �ش��ϴ� ���ھ�ü������ HotelManagerDAO�� ��û�ϰ� ó������� APplication�Ŵ����� HotelManagerDAOManger�� �����Ѵ�
	 * @param location ���ھ�ü ��ġ
	 * @return ���ھ�ü ��ġ�� �ش��ϴ� ���ھ�ü�������� �����Ѵ�
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
	 * ȸ���ڵ忡 �ش��ϴ� ���ھ�ü�� ���� ������  HotelManagerDAO�� ��û�ϰ� ó������� APplication�Ŵ����� HotelManagerDAOManger�� �����Ѵ�
	 * @param memberCode ȸ���ڵ�
	 * @param hotelInfo ���ھ�ü ����
	 * @return ������������
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
	 * ���ھ�ü ���̺� ���� HotelManagerDTOŬ������ ������ ���ھ�ü ������ ������ HotelInfo Ŭ������ ��ȯ�Ѵ� 
	 * @param hotelManagerDTO ���ھ�ü ���̺� ����
	 * @return ������ ���ھ�ü������ ������ Ŭ����
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
