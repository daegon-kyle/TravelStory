//작성날짜 : 2014/7/20
//작성자 : 이화섭


package dto;

/**
 * 내블로그에 적용된 위젯 테이블 정보를 저장할 클래스
 * @author 화섭
 *
 */
public class MyWidgetDTO 
{
	private String memberCode;
	private String blogCode;
	private String usedWidgetCode;
	private String myWidgetCode;
	private String myWidetName;
	
	/**
	 * 기본생성자
	 */
	public MyWidgetDTO()
	{
		this("","","","","");
	}

	/**
	 * 전달인자를 받는 생서자
	 * @param memberCode 회원코드
	 * @param blogCode 블로그코드
	 * @param usedWidgetCode 사용된위젯코드
	 * @param myWidgetCode 사용자의 위젯코드
	 * @param myWidetName 사용자의 위젯명
	 */
	public MyWidgetDTO(String memberCode, String blogCode,
			String usedWidgetCode, String myWidgetCode, String myWidetName) { 
		this.memberCode = memberCode;
		this.blogCode = blogCode;
		this.usedWidgetCode = usedWidgetCode;
		this.myWidgetCode = myWidgetCode;
		this.myWidetName = myWidetName;
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
	 * 블로그코드를 리턴한다
	 * @return
	 */
	public String getBlogCode() {
		return blogCode;
	}

	/**
	 * 블로그코드를 설정한다
	 * @param blogCode
	 */
	public void setBlogCode(String blogCode) {
		this.blogCode = blogCode;
	}

	/**
	 * 사용된위젯코드를 리턴한다
	 * @return
	 */
	public String getUsedWidgetCode() {
		return usedWidgetCode;
	}

	/**
	 * 사용된위젯코드를 수정한다
	 * @param usedWidgetCode
	 */
	public void setUsedWidgetCode(String usedWidgetCode) {
		this.usedWidgetCode = usedWidgetCode;
	}

	/**
	 * 사용자 위젯코드를 리ㅓㅌㄴ한다
	 * @return
	 */
	public String getMyWidgetCode() {
		return myWidgetCode;
	}

	/**
	 * 사용자 위젯코드를 설정한다
	 * @param myWidgetCode
	 */
	public void setMyWidgetCode(String myWidgetCode) {
		this.myWidgetCode = myWidgetCode;
	}

	/**
	 * 사용자위젯명을 리턴한다
	 * @return
	 */
	public String getMyWidetName() {
		return myWidetName;
	}

	/**
	 * 사용자위젯명을 설정한다
	 * @param myWidetName
	 */
	public void setMyWidetName(String myWidetName) {
		this.myWidetName = myWidetName;
	}

	@Override
	public String toString() {
		return "MyWidgetDTO [memberCode=" + memberCode + ", blogCode="
				+ blogCode + ", usedWidgetCode=" + usedWidgetCode
				+ ", myWidgetCode=" + myWidgetCode + ", myWidetName="
				+ myWidetName + "]";
	}
	
	

}
