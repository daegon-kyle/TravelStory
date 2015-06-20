package form;
/**
 * 여행준비물 추천서비스를 받기 위해 입력해야 하는 폼 클래스
 * TourPreparationServlet에서 호출 
 * @author 영한
 *
 */
public class TourPreparationRecommendInfoForm {
	/**
	 * 여행 시작 날짜
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
	 * 도착지
	 */
	private String destination2;
	/**
	 * null 생성자 
	 */
	public TourPreparationRecommendInfoForm() {
		this("","","","");
	}
	/**
	 * 여행시작일, 여행종료일, 목적지1, 목적지2로 초기화하는 생성자 
	 * @param startDate 여행시작일
	 * @param endDate 여행종료일
	 * @param destination1 목적지1
	 * @param destination2 목적지2
	 */
	public TourPreparationRecommendInfoForm(String startDate, String endDate,
			String destination1, String destination2) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.destination1 = destination1;
		this.destination2 = destination2;
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
	 * 목적지를 반환한다. 
	 * @return 목적지 
	 */
	public String getDestination1() {
		return destination1;
	}
	/**
	 * 목적지를 세팅한다. 
	 * @param destination1 목적지 
	 */
	public void setDestination1(String destination1) {
		this.destination1 = destination1;
	}
	/**
	 * 목적지를 반환한다. 
	 * @return 목적지 
	 */
	public String getDestination2() {
		return destination2;
	}
	/**
	 * 목적지를 세팅한다.
	 * @param destination2 목적지 
	 */
	public void setDestination2(String destination2) {
		this.destination2 = destination2;
	}
}
