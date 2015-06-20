//작성날짜 : 2014/7/19
//작성자 : 이화섭

package dto;

/**
 * 회원등급 테이블 정보를 저장할 클래스
 * @author 화섭
 *
 */
public class MemberLevelDTO 
{
	private String levelCode;
	private String levelName;
	
	/**
	 * 기본생성자
	 */
	public MemberLevelDTO()
	{
		this("","");
	}
	
	/**
	 * 전달인자를 받는 생성자
	 * @param levelCode 등급코 드
	 * @param levelName 등급명
	 */
	public MemberLevelDTO(String levelCode, String levelName) { 
		this.levelCode = levelCode;
		this.levelName = levelName;
	}
	/**
	 * 회원등급코드를 리턴한다
	 * @return
	 */
	public String getLevelCode() {
		return levelCode;
	}
	/**
	 * 회원등급코드를 설정한다
	 * @param levelCode
	 */
	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}
	/**
	 * 회원등급명을 리턴한다
	 * @return
	 */
	public String getLevelName() {
		return levelName;
	}
	/**
	 * 회원등급명을 설정한다
	 * @param levelName
	 */
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
}
