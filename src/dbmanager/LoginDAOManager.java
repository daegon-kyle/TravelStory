package dbmanager;

import dao.MemberDAO;
import dao.HouseOwnerDAO;
import dao.HotelManagerDAO;

/**
 * Application���� �Ŵ��� LoginManager���� �α��� ��û�� �޾� ó���ϴ�DB���� �Ŵ��� Ŭ���� 
 * @author ȭ��
 *
 */
public class LoginDAOManager 
{
	private MemberDAO memberDAO;
	private HouseOwnerDAO houseOwnerDAO;
	private HotelManagerDAO hotelManagerDAO;
	
	/**
	 * �⺻�����ڷ� MemberDAO, HouseOwnerDAO �׸��� HotelManagerDAO�� �ν��Ͻ�ȭ�Ѵ�
	 */
	public LoginDAOManager()
	{
		memberDAO=new MemberDAO();
		houseOwnerDAO=new HouseOwnerDAO();
		hotelManagerDAO=new HotelManagerDAO();
	}
	
	/**
	 * LoginManager�κ��� �̸��ϰ� ��й�ȣ�� ���޹޾� �̿� �ش��ϴ� ȸ���� �ڵ带 MemberDAO�� ��û�ϰ� �� ����� �����Ѵ�
	 * @param email ����ڰ� �Է��� �̸���
	 * @param password ����ڰ� �Է��� ��й�ȣ
	 * @return �Է��� ������ �ش��ϴ� ������� ȸ���ڵ�
	 */
	public String getMemberCode(String email, String password)
	{
		return memberDAO.selectCode(email, password);
	}
	
	/**
	 * ����ڰ� �̸����� �ؾ������ ��� LoginManager�κ��� �̸��� ��ȭ��ȣ�� ���޹޾� �̿� �ش��ϴ� ȸ���� �̸����� MemberDAO�� ��û�ϰ� �� ����� �����Ѵ�
	 * @param name ����ڰ� �Է��� �̸�
	 * @param phone ����ڰ� �Է��� ��ȭ��ȣ
	 * @return �Է��� ������ �ش��ϴ� ȸ�� �̸���
	 */
	public String getEmail(String name, String phone)
	{
		return memberDAO.selectEmail(name, phone);
	}
	
	/**
	 * ��й�ȣ�� �ؾ������ ��� LoginManager�κ��� �̸��ϰ� �̸��� ���޹޾� �̿� �ش��ϴ� ȸ���� ��й�ȣ�� MemberDAO�� ��û�ϰ� �� ����� �����Ѵ�
	 * @param email ����ڰ� �Է��� �̸���
	 * @param name ����ڰ� �Է��� �̸�
	 * @return �Է��� ������ �ش��ϴ� ȸ���� ��й�ȣ
	 */
	public String getPassword(String email, String name)
	{
		return memberDAO.selectPassword(email, name);
	}
	
	/**
	 * ����ڰ� �Է��� ��й�ȣ�� �߸��Ǿ����� �߸��� �̸������� Ȯ���ϱ� ���� LoginManger�κ��� �̸����� ���޹޾� �̿� �ش��ϴ� ȸ���� ��й�ȣ�� MemberDAO�� ��û�ϰ� �װ���� �����Ѵ�
	 * @param email ����ڰ� �Է��� �̸���
	 * @return �Է��� ������ �ش��ϴ� ȸ���� ��й�ȣ
	 */
	public String getPassword(String email)
	{
		return memberDAO.selectPassword(email);
	}
	
	/**
	 * LoginManager�κ��� ȸ���ڵ带 ���޹޾� �̿� �ش��ϴ� ������ �ڵ尡 �ִ��� HouseOwnerDAO�� ��û�ϰ� �װ���� �����Ѵ�
	 * @param memberCode ȸ�� �����ĺ��ڵ�
	 * @return ȸ���ڵ忡 �ش��ϴ� �������ڵ�
	 */
	public String getHouseOwnerCode(String memberCode)
	{
		return houseOwnerDAO.selectHouseOwnerCode(memberCode);
	}
	
	/**
	 * LoginManager�κ��� ȸ���ڵ带 ���޹޾� �̿� �ش��ϴ� ���ھ�ü �ڵ尡 �̴µ� HotelManagerDAO�� ��û�ϰ� �� ����� �����Ѵ�
	 * @param memberCode ȸ�� �����ĺ��ڵ�
	 * @return ȸ�� �ڵ忡 �ش��ϴ� ���ھ�ü�ڵ�
	 */
	public String getHotelManageCode(String memberCode)
	{
		return hotelManagerDAO.selectHotelManagerCode(memberCode);
	}
	

}
