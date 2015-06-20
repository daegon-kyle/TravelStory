//2014.07.26
//��ȭ��

package manager;

import model.LoginInfo;
import dbmanager.LoginDAOManager;

/**
 * �α��� üũ�� �ϱ� ���� ����ϴ� Ŭ����
 * @author ���
 *
 */
public class LoginManager 
{
	/**
	 * �α�������
	 */
	private LoginInfo loginInfo;

	/**
	 * �λ�����
	 */
	public LoginManager() {
		this(new LoginInfo());
	}
	/**
	 * �⺻������
	 * @param LoginInfo �α�������
	 */
	public LoginManager(LoginInfo loginInfo) {
		this.loginInfo = loginInfo;
	}
	/**
	 * �α������� ����
	 * @return �α�������
	 */
	public LoginInfo getLoginInfo() {
		return loginInfo;
	}
	/**
	 * �α������� ����
	 * @param LoginInfo �α�������
	 */
	public void setLoginInfo(LoginInfo loginInfo)
	{
		this.loginInfo = loginInfo;
	}
	
	/**
	 * �̸������� ������, �̸��� ����� ����� �߸��Է��ߴ��� ���� Ȯ���� ���� �̸��Ͽ� �ش��ϴ� ��й�ȣ�� DB���� �Ŵ����� LoginDAOManager���� ��û�Ͽ� �����Ѵ� 
	 * @param email �̸���
	 * @return �̸��Ͽ� �ش��ϴ� �н�����
	 */
	public String getPassword(String email)
	{
		LoginDAOManager loginDAOManager=new LoginDAOManager();
		return loginDAOManager.getPassword(email);
	}
	/**
	 * �α��� üũ�ϱ� ���� DB���� �����ϴ� �޼ҵ�, LoginDAOManager�� getMemberCode�� getPassword�� ���� ��ȯ���� ���� ��
	 * @param email �̸���
	 * @param password ��й�ȣ
	 * @return �̸���, ��й�ȣ�� �ش��ϴ� ȸ���ڵ� 
	 */
	public String login(String email, String password)
	{
		LoginDAOManager loginDAOManager=new LoginDAOManager();
		return loginDAOManager.getMemberCode(email, password);
	}
	
	/**
	 * ȸ���ڵ忡 �ش��ϴ� �������ڵ带 DB���� �Ŵ����� LoginDAOManger�� ��û�ϰ� ó������� �����Ѵ�
	 * @param memberCode ȸ���ڵ� 
	 * @return ȸ���ڵ忡 �ش��ϴ� �������ڵ�
	 */
	public String getHouseOwnerCode(String memberCode)
	{
		LoginDAOManager loginDAOManager=new LoginDAOManager();
		return loginDAOManager.getHouseOwnerCode(memberCode);
	}
	
	/**
	 * ȸ���ڵ忡 �ش��ϴ� ���ھ�ü�ڵ带 DB���� �Ŵ����� LoginDAOManger�� ��û�ϰ� ó������� �����Ѵ�
	 * @param memberCode ȸ����
	 * @return ȸ���ڵ忡 �ش��ϴ� ���ھ�ü�ڵ�
	 */
	public String getHotelManagerCode(String memberCode)
	{
		LoginDAOManager loginDAOManager=new LoginDAOManager();
		return loginDAOManager.getHotelManageCode(memberCode);
	}
}
