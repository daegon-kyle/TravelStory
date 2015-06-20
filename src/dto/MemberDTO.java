//작성날짜 : 2014/7/19
//작성자 : 이화섭

package dto;

/**
 * 멤버 테이블 정보를 저장할 클래스
 * @author 화섭
 *
 */
public class MemberDTO 
{
	private String memberCode;
	private String levelCode;
	private String name;
	private String email;
	private String password;
	private String birthdate;
	private String phone;
	private String gender;
	private int reliability;
	/**
	 * 널생성자
	 */
	public MemberDTO()
	{
		this("","","","","","","","",0);
	}
	/**
	 * 전달인자를 받는 생성자
	 * @param name 이름
	 * @param email 이메일
	 * @param birthdate 생일
	 * @param phone 전화번호
	 * @param gender 성
	 * @param reliability 신뢰도
	 */
	public MemberDTO(String name, String email,
			String birthdate, String phone, String gender, int reliability)
	{
		this("", "", name, email, "", birthdate, phone, gender, reliability);
	}
	
	/**
	 * 전달인자를 받는 생성자
	 * @param memberCode 회원코드
	 * @param levelCode 회원등급코드
	  * @param name 이름
	 * @param email 이메일
	 * @param birthdate 생일
	 * @param phone 전화번호
	 * @param gender 성
	 * @param reliability 신뢰도
	 */
	public MemberDTO(String memberCode, String levelCode, String name, String email,
			String password, String birthdate, String phone, String gender)
	{
		this(memberCode, levelCode, name, email, password, birthdate, phone, gender, 0);
	}
	
	/**
	 * 모든 전달인자를 받는 생성자
	 * @param memberCode 회원코드
	 * @param levelCode 회원등급코드
	 * @param name 이름
	 * @param email 이메일
	 * @param password 비밀번호
	 * @param birthdate 생일
	 * @param phone 전화번호
	 * @param gender 성
	 * @param reliability 신뢰도
	 */
	public MemberDTO(String memberCode, String levelCode, String name, String email,
			String password, String birthdate, String phone, String gender,
			int reliability) { 
		this.memberCode = memberCode;
		this.levelCode = levelCode;
		this.name = name;
		this.email = email;
		this.password = password;
		this.birthdate = birthdate;
		this.phone = phone;
		this.gender = gender;
		this.reliability = reliability;
	}
	
	/**
	 * 회원코드를 리턴한다
	 * @return
	 */
	public String getMemberCode() {
		return memberCode;
	}

	/**
	 * 회원코드를 설정한다
	 * @param memberCode
	 */
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	/**
	 * 회원등급을 리턴한다
	 * @return
	 */
	public String getLevelCode() {
		return levelCode;
	}
	/**
	 * 회원등급을 설정한다
	 * @param levelCode
	 */
	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}
	/**
	 * 이름을 리턴한다
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * 이름을 설정한다
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 이메일을 리턴한다
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 이메일을 설정한다
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 비밀번호를 리턴한다
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 비밀번호를 설정한다
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 생일을 리턴한다
	 * @return
	 */
	public String getBirthdate() {
		return birthdate;
	}
	/**
	 * 생일을 설정한다
	 * @param birthdate
	 */
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	/**
	 * 전화번호를 리턴한다
	 * @return
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 전화번호를 설정한다
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 성을 리턴한다
	 * @return
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * 성을 설정한다
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * 신뢰도를 리턴한다
	 * @return
	 */
	public int getReliability() {
		return reliability;
	}
	/**
	 * 신뢰도를 설정한다
	 * @param reliability
	 */
	public void setReliability(int reliability) {
		this.reliability = reliability;
	}
	
	
}
