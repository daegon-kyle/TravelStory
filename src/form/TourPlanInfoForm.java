package form;

/**
 * 여행일정정보 포스팅을 올리기 위해 입력해야하는 폼 클래스
 * PostingAddServlet에서 호출
 * @author 영한
 *
 */
public class TourPlanInfoForm {
	/**
	 * 출발지
	 */
	private String destination1;
	/**
	 * 도착지
	 */
	private String destination2;
	/**
	 * 제목
	 */
	private String title;
	/**
	 * 제목
	 */
	private String content;
	/**
	 * 맛집선호도
	 */
	private String restrauntPreference;
	/**
	 * 힐링 선호도
	 */
	private String healingPreference;
	/**
	 * 관광명소 선호도
	 */
	private String attractionPreference;
	/**
	 * 쇼핑선호도
	 */
	private String shoppingPreference;
	/**
	 * 기타 선호도
	 */
	private String etcPreference;
/**
 * null 생성자 
 */
	public TourPlanInfoForm() {
		this("","","","","","","","","");
	}
	/**
	 * 목적지,제목, 내용, 맛집선호도, 힐링선호도, 관관명소 선호도, 쇼핑선호도, 기타 선호도를 초기화하는 생성자 
	 * @param destination1 목적지1 
	 * @param destination2 목적지2
	 * @param title 제목
	 * @param content 내용
	 * @param restrauntPreference 맛집선호도 
	 * @param healingPreference 힐링선호도 
	 * @param attractionPreference 관광명소 선호도 
	 * @param shoppingPreference 쇼핑선호도 
	 * @param etcPreference 기타선호도 
	 */
	public TourPlanInfoForm(String destination1, String destination2,
			String title, String content, String restrauntPreference,
			String healingPreference, String attractionPreference,
			String shoppingPreference, String etcPreference) {
		this.destination1 = destination1;
		this.destination2 = destination2;
		this.title = title;
		this.content = content;
		this.restrauntPreference = restrauntPreference;
		this.healingPreference = healingPreference;
		this.attractionPreference = attractionPreference;
		this.shoppingPreference = shoppingPreference;
		this.etcPreference = etcPreference;
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
	 * 목적지를세팅한다. 
	 * @param destination2 목적지 
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
	 * 맛집선호도를 리턴한다.
	 * @return 맛집선호도 
	 */
	public String getRestrauntPreference() {
		return restrauntPreference;
	}
	/**
	 * 맛집선호도를 세팅한다.
	 * @param restrauntPreference 맛집선호도 
	 */
	public void setRestrauntPreference(String restrauntPreference) {
		this.restrauntPreference = restrauntPreference;
	}
	/**
	 * 힐링 선호도를 반환하다.
	 * @return 힐링선호도 
	 */
	public String getHealingPreference() {
		return healingPreference;
	}
	/**
	 * 힐링선호도를 세팅한다.
	 * @param healingPreference 힐링선호도  
	 */
	public void setHealingPreference(String healingPreference) {
		this.healingPreference = healingPreference;
	}
	/**
	 * 관광명소를 반환한다.
	 * @return 관광명소
	 */
	public String getAttractionPreference() {
		return attractionPreference;
	}
	/**
	 * 관광명소를 세팅한다.
	 * @param attractionPreference 관광명소
	 */
	public void setAttractionPreference(String attractionPreference) {
		this.attractionPreference = attractionPreference;
	}
	/**
	 * 쇼핑선호도를 반환한다.
	 * @return 쇼핑선호도 
	 */
	public String getShoppingPreference() {
		return shoppingPreference;
	}
	/**
	 * 쇼핑선호도를 세팅한다.
	 * @param shoppingPreference 쇼핑선호도 
	 */
	public void setShoppingPreference(String shoppingPreference) {
		this.shoppingPreference = shoppingPreference;
	}
	/**
	 * 기타선호도를 반환한다.
	 * @return 기타선호도 
	 */
	public String getEtcPreference() {
		return etcPreference;
	}
	/**
	 * 기타선호도를 세팅한다.
	 * @param etcPreference 기타선호도 
	 */
	public void setEtcPreference(String etcPreference) {
		this.etcPreference = etcPreference;
	}
}
