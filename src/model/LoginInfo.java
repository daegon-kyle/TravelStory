package model;
/**
 * ������� �α��� ������ �����ϱ� ���� �ʿ��� ��������� ĸ��ȭ�� Ŭ����
 * <br>LoginServlet���� ����ϱ� ���� Ŭ����
 * @author ���
 *
 */
public class LoginInfo implements  java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5527072754681823659L;
	/**
	 * �̸���
	 */
	private String email;
	/**
	 * ��й�ȣ
	 */
	private String password;
	
	/**
	 * �λ�����
	 */
	public LoginInfo() {
		super();
	}
	/**
	 * �⺻������
	 * @param email �̸���
	 * @param password ��й�ȣ
	 */
	public LoginInfo(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	/**
	 * �̸��� ��ȯ
	 * @return �̸���
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * �̸��� ����
	 * @param email �̸���
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * ��й�ȣ ��ȯ
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * �̸��� ����
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
