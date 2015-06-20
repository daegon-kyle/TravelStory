package form;

/**
 * 로그인하기위해 기본적으로 입력해야하는 폼 클래스
 * 
 *
 */
public class LoginForm {
	/**
	 * 아이디
	 */
	private String id;
	/**
	 * 비번
	 */
	private String password;
	
	/**
	 * 널생성자
	 */
	public LoginForm() {
		this("","");
	}

	/**
	 * 생성자
	 * @param id 아이디
	 * @param password 비밀번호
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
