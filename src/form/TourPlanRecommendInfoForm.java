package form;
/**
 * 여행일정 추천받기위해 입력해야 하는 폼 클래스
 * TourPlanServlet에서 호출 
 * @author 영한
 *
 */
public class TourPlanRecommendInfoForm {
	/**
	 * 출발지
	 */
	private String destination1;
	/**
	 * 도착지
	 */
	private String destination2;
	/**
	 * 맛집 선호도
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
	 * 쇼핑 선호도
	 */
	private String shoppingPreference;
	/**
	 * 기타 선호도
	 */
	private String etcPreference;
	/**
	 * null 생성자 
	 */
	public TourPlanRecommendInfoForm() {

	}
	/**
	 * 목적지1, 목적지2, 맛집선호도, 힐링선호도, 관광명소선호도, 쇼핑선호도, 기타선호도를 초기화하는 생성자 
	 * @param destination1 목적지1
	 * @param destination2 목적지2
	 * @param restrauntPreference 맛집선호도
	 * @param healingPreference 힐링선호도
	 * @param attractionPreference 관광명소선호도
	 * @param shoppingPreference 쇼핑선호도
	 * @param etcPreference 기타선호도
	 */
	public TourPlanRecommendInfoForm(String destination1, String destination2,
			String restrauntPreference, String healingPreference,
			String attractionPreference, String shoppingPreference,
			String etcPreference) {
		this.destination1 = destination1;
		this.destination2 = destination2;
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
	 * 목적지를 세팅한다. 
	 * @param destination2 목적지 
	 */
	public void setDestination2(String destination2) {
		this.destination2 = destination2;
	}
	/**
	 * 맛집선호도를 반환한다.
	 * @return 맛집선호도
	 */
	public String getRestrauntPreference() {
		return restrauntPreference;
	}
	/**
	 * 맛집선호도를 세팅한다. 
	 * @param restrauntPreference
	 */
	public void setRestrauntPreference(String restrauntPreference) {
		this.restrauntPreference = restrauntPreference;
	}
	/**
	 * 힐링선호도를 반환한다.
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
