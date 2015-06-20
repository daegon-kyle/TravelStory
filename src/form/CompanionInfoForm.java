package form;
/**
 * 사용자가 입력한 동행자추천 포스팅을 저장하기 위한 폼 클래스
 * 
 *
 */
public class CompanionInfoForm {
	/**
	 * 상대방 성별
	 */
	private String otherGender;
	/**
	 * 출발지
	 */
	private String destination1;
	/**
	 * 도착지
	 */
	private String destination2;
	/**
	 * 방문 시작 날짜
	 */
	private String startDate;
	/**
	 * 방문 끝 날짜
	 */
	private String endDate;
	/**
	 * 제목
	 */
	private String title;
	/**
	 * 내용
	 */
	private String content;
	/**
	 * 포스팅 목적 코드
	 */
	private String postingPurposeCode;
	/**
	 * 카테고리 코드
	 */
	private String categoryCode;
	
	/**
	 * 널 생성자
	 */
	public CompanionInfoForm() {
		this("","","","","","","","","");
	}
	/**
	 * 생성자
	 * @param otherGender 다른 성별
	 * @param destination1 출발지
	 * @param destination2 도착지
	 * @param startDate 시작날짜
	 * @param endDate 도착날짜
	 * @param title 제목
	 * @param content 내용
	 * @param postingPurposeCode 포스팅목적코드
	 * @param categoryCode 카테고리 코드
	 */
	public CompanionInfoForm(String otherGender,
			String destination1, String destination2, String startDate,
			String endDate,String title,
			String content, String postingPurposeCode, String categoryCode) {
		this.otherGender = otherGender;
		this.destination1 = destination1;
		this.destination2 = destination2;
		this.startDate = startDate;
		this.endDate = endDate;
		this.title = title;
		this.content = content;
		this.postingPurposeCode = postingPurposeCode;
		this.categoryCode = categoryCode;
	}

	public String getOtherGender() {
		return otherGender;
	}
	public void setOtherGender(String otherGender) {
		this.otherGender = otherGender;
	}
	public String getDestination1() {
		return destination1;
	}
	public void setDestination1(String destination1) {
		this.destination1 = destination1;
	}
	public String getDestination2() {
		return destination2;
	}
	public void setDestination2(String destination2) {
		this.destination2 = destination2;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPostingPurposeCode() {
		return postingPurposeCode;
	}
	public void setPostingPostingPurposeCode(String postingPurposeCode) {
		this.postingPurposeCode = postingPurposeCode;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	
	
}
