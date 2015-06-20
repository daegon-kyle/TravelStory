package validator;

import form.LoginForm;
import java.util.*;
/**
 * 로그인 폼을 멤버변수로 가져 사용자의 입력여부를 검사하는 클래스
 * @author 대곤
 *
 */
public class LoginValidator {
	/**
	 * 로그인폼
	 */
	private LoginForm loginForm;
/**
 * 널생성자
 */
	public LoginValidator() {
		this(new LoginForm());
	}
	/**
	 * 기본생성자
	 * @param loginForm 로그인폼
	 */
	public LoginValidator(LoginForm loginForm) {
		this.loginForm = loginForm;
	}
	/**
	 * 아이디와 비밀번호에서 공백여부를 체크한 후 에러메시지반환
	 * @return 에러메시지 목록
	 */
	public List<String> validate(){
		ArrayList<String> list=new ArrayList<String>();
		
		//빈칸 유효성 검증
		BlankValidator blankValidator=new BlankValidator();
		if(blankValidator.validateBlank(loginForm.getId()))
			list.add("아이디를 입력하세요");
		if(blankValidator.validateBlank(loginForm.getPassword()))
			list.add("비밀번호를 입력하세요");
		
		if(validateEmail()!="")
			list.add(validateEmail());

		if(validatePassword()!="")
			list.add(validatePassword());
		
		return list;
	}
	/**
	 * 로그인 폼 반환
	 * @return 로그인 폼
	 */
	public LoginForm getLoginForm() {
		return loginForm;
	}
	/**
	 * 로그인 폼 설정
	 * @param loginForm 로그인 폼
	 */
	public void setLoginForm(LoginForm loginForm) {
		this.loginForm = loginForm;
	}
	
	public String validatePassword()
	{
		int length=loginForm.getPassword().length();
		
		if(length<6 || length>=16)
			return "비밀번호는 6~16자로 작성해주세요";
		else
			return "";
	}
	
	public String validateEmail(){
		if(loginForm.getId().contains("@"))
			return "";
		else
			return "이메일 형식이 아닙니다. 이메일을 입력해주세요";
	}
}


