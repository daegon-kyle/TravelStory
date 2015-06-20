package model;
/**
 * 사용자의 로그인 정보를 저장하기 위해 필요한 멤버변수를 캡슐화한 클래스
 * <br>LoginServlet에서 사용하기 위한 클래스
 * @author 대곤
 *
 */
public class LoginInfo implements  java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5527072754681823659L;
	/**
	 * 이메일
	 */
	private String email;
	/**
	 * 비밀번호
	 */
	private String password;
	
	/**
	 * 널생성자
	 */
	public LoginInfo() {
		super();
	}
	/**
	 * 기본생성자
	 * @param email 이메일
	 * @param password 비밀번호
	 */
	public LoginInfo(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	/**
	 * 이메일 반환
	 * @return 이메일
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 이메일 설정
	 * @param email 이메일
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 비밀번호 반환
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 이메일 설정
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
