package form;

/**
 * �α����ϱ����� �⺻������ �Է��ؾ��ϴ� �� Ŭ����
 * 
 *
 */
public class LoginForm {
	/**
	 * ���̵�
	 */
	private String id;
	/**
	 * ���
	 */
	private String password;
	
	/**
	 * �λ�����
	 */
	public LoginForm() {
		this("","");
	}

	/**
	 * ������
	 * @param id ���̵�
	 * @param password ��й�ȣ
	 */
	public LoginForm(String id, String password) {
		this.id = id;
		this.password = password;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
}
