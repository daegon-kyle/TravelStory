//2014.07.26
//이화섭

package manager;

import model.LoginInfo;
import dbmanager.LoginDAOManager;

/**
 * 로그인 체크를 하기 위해 사용하는 클래스
 * @author 대곤
 *
 */
public class LoginManager 
{
	/**
	 * 로그인정보
	 */
	private LoginInfo loginInfo;

	/**
	 * 널생성자
	 */
	public LoginManager() {
		this(new LoginInfo());
	}
	/**
	 * 기본생성자
	 * @param LoginInfo 로그인정보
	 */
	public LoginManager(LoginInfo loginInfo) {
		this.loginInfo = loginInfo;
	}
	/**
	 * 로그인정보 리턴
	 * @return 로그인정보
	 */
	public LoginInfo getLoginInfo() {
		return loginInfo;
	}
	/**
	 * 로그인정보 설정
	 * @param LoginInfo 로그인정보
	 */
	public void setLoginInfo(LoginInfo loginInfo)
	{
		this.loginInfo = loginInfo;
	}
	
	/**
	 * 이메일존재 유무와, 이메일 존재시 비번을 잘못입력했는지 여부 확인을 위해 이메일에 해당하는 비밀번호를 DB계층 매니저인 LoginDAOManager에게 요청하여 전달한다 
	 * @param email 이메일
	 * @return 이메일에 해당하는 패스워드
	 */
	public String getPassword(String email)
	{
		LoginDAOManager loginDAOManager=new LoginDAOManager();
		return loginDAOManager.getPassword(email);
	}
	/**
	 * 로그인 체크하기 위해 DB에서 점검하는 메소드, LoginDAOManager의 getMemberCode와 getPassword를 통해 반환받은 값을 비교
	 * @param email 이메일
	 * @param password 비밀번호
	 * @return 이메일, 비밀번호에 해당하는 회원코드 
	 */
	public String login(String email, String password)
	{
		LoginDAOManager loginDAOManager=new LoginDAOManager();
		return loginDAOManager.getMemberCode(email, password);
	}
	
	/**
	 * 회원코드에 해당하는 집주인코드를 DB계층 매니저인 LoginDAOManger에 요청하고 처리결과를 전달한다
	 * @param memberCode 회원코드 
	 * @return 회원코드에 해당하는 집주인코드
	 */
	public String getHouseOwnerCode(String memberCode)
	{
		LoginDAOManager loginDAOManager=new LoginDAOManager();
		return loginDAOManager.getHouseOwnerCode(memberCode);
	}
	
	/**
	 * 회원코드에 해당하는 숙박업체코드를 DB계층 매니저인 LoginDAOManger에 요청하고 처리결과를 전달한다
	 * @param memberCode 회원콛
	 * @return 회원코드에 해당하는 숙박업체코드
	 */
	public String getHotelManagerCode(String memberCode)
	{
		LoginDAOManager loginDAOManager=new LoginDAOManager();
		return loginDAOManager.getHotelManageCode(memberCode);
	}
}
