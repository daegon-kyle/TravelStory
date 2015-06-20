package form;

/**
 * 
 * 여행준비물 포스팅을 하기 위해 입력해야하는 폼 클래스
 * PostingAddServlet에서 호출 
 * @author 대곤
 *
 */
public class TourPreparationInfoForm {
	/**
	 * 여행시작날짜
	 */
	private String startDate;
	/**
	 * 여행 끝 날짜
	 */
	private String endDate;
	/**
	 * 출발지
	 */
	private String destination1;
	/**
	 * 도착날짜
	 */
	private String destination2;
	/**
	 * 제목
	 */
	private String title;
	/**
	 * 내용
	 */
	private String content;
	/**
	 * 포스팅목적코드
	 */
	private String postingPurposeCode;
	/**
	 * 카테고리 코드
	 */
	private String categoryCode;
	/**
	 * null  생성자 
	 */
	public TourPreparationInfoForm() {
		this("","","","","","","","");
	}

/**
 * 시작일, 종료일, 목적지1, 목적지2, 제목, 내용, 포스팅목적코드, 카테고리코드를 초기화하는 생성자 
 * @param startDate 시작일
 * @param endDate 종료일 
 * @param destination1 목적지1
 * @param destination2 목적지2
 * @param title 제목
 * @param content 내용
 * @param postingPurposeCode 포스팅목적코드
 * @param categoryCode 카테고리코드를 초기화하는 생성자 
 */
	public TourPreparationInfoForm(String startDate, String endDate,
			String destination1, String destination2,String title, String content, String postingPurposeCode, String categoryCode){
		this.startDate = startDate;
		this.endDate = endDate;
		this.destination1 = destination1;
		this.destination2 = destination2;
		this.title = title;
		this.content = content;
		this.postingPurposeCode = postingPurposeCode;
		this.categoryCode = categoryCode;
	}

/**
 * 여행시작일을 반환한다.
 * @return 여행시작일 
 */
	public String getStartDate() {
		return startDate;
	}

/**
 * 여행시작일을 세팅한다. 
 * @param startDate 여행시작일 
 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

/**
 * 여행종료일을 반환한다.
 * @return 여행종료일 
 */
	public String getEndDate() {
		return endDate;
	}

/**
 * 여행종료일을 세팅한다. 
 * @param endDate 여행종료일 
 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

/**
 * 여행목적지를 반환한다. 
 * @return 여행목적지 
 */
	public String getDestination1() {
		return destination1;
	}

/**
 * 여행목적지를 세팅한다.
 * @param destination1 여행목적지 
 */
	public void setDestination1(String destination1) {
		this.destination1 = destination1;
	}

/**
 * 여행목적지를 반환한다. 
 * @return 여행목적지 
 */
	public String getDestination2() {
		return destination2;
	}

/**
 * 여행목적지를 세팅한다. 
 * @param destination2 여행목적지 
 */
	public void setDestination2(String destination2) {
		this.destination2 = destination2;
	}

/**
 * 제목을 반환한다. 
 * @return 제목
 */
	public String getTitle() {
		return title;
	}

/**
 * 제목을 세팅한다. 
 * @param title 제목 
 */
	public void setTitle(String title) {
		this.title = title;
	}

/**
 * 내용을 반환한다.
 * @return 내용
 */
	public String getContent() {
		return content;
	}

/**
 * 내용을 세팅한다. 
 * @param content 내용
 */
	public void setContent(String content) {
		this.content = content;
	}

/**
 * 포스팅목적코드를 반환한다. 
 * @return 포스팅목적코드 
 */
	public String getPostingPurposeCode() {
		return postingPurposeCode;
	}

/**
 * 포스팅 목적코드를 세팅한다. 
 * @param postingPurposeCode 포스팅목적 코드 
 */
	public void setPostingPurposeCode(String postingPurposeCode) {
		this.postingPurposeCode = postingPurposeCode;
	}

/**
 * 카테고리코드를 반환한다. 
 * @return 카테고리코드 
 */
	public String getCategoryCode() {
		return categoryCode;
	}

/**
 * 카테고리코드를 세팅한다. 
 * @param categoryCode 카테고리코드 
 */
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	
}
