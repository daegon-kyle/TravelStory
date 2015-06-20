package model;

import java.io.Serializable;
/**
 * 취향정보를 캡슐화한 클래스
 * <br>TourPlanInfoServlet에서 사용하려는 클래스
 * @author 대곤
 *
 */
public class LikingInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5561472474285273527L;
	/**
	 * 맛집선호도
	 */
	private int restaurantPreference;
	/**
	 * 힐링 선호도
	 */
	private int healingPreference;
	/**
	 * 취향 선호도
	 */
	private int attractionPreference;
	/**
	 * 쇼핑 선호도
	 */
	private int shoppingPreference;
	/**
	 * 기타 선호도
	 */
	private int etcPreference;
	/**
	 * 널생성자
	 */
	public LikingInfo() {
		this(0,0,0,0,0);
	}
	/**
	 * 기본생성자
	 * @param restrauntPreference 맛집선호도
	 * @param healingPreference 힐링선호도
	 * @param attractionPreference 관광명소선호도
	 * @param shoppingPreference 쇼핑선호도
	 * @param etcPreference 기타선호도
	 */
	public LikingInfo(int restaurantPreference, int healingPreference,
			int attractionPreference, int shoppingPreference, int etcPreference) {
		this.restaurantPreference = restaurantPreference;
		this.healingPreference = healingPreference;
		this.attractionPreference = attractionPreference;
		this.shoppingPreference = shoppingPreference;
		this.etcPreference = etcPreference;
	}
	/**
	 * 맛집선호도 반환
	 * @return 맛집선호도
	 */
	public int getRestaurantPreference() {
		return restaurantPreference;
	}
	/**
	 * 맛집선호도 설정
	 * @param restrauntPreference 맛집선호도
	 */
	public void setRestaurantPreference(int restaurantPreference) {
		this.restaurantPreference = restaurantPreference;
	}
	/**
	 * 힐링선호도 반환
	 * @return 힐링선호도
	 */
	public int getHealingPreference() {
		return healingPreference;
	}
	/**
	 * 힐링선호도 설정
	 * @param healingPreference 힐링선호도
	 */
	public void setHealingPreference(int healingPreference) {
		this.healingPreference = healingPreference;
	}
	/**
	 * 관광명소 선호도 반환
	 * @return 관광명소 선호도
	 */
	public int getAttractionPreference() {
		return attractionPreference;
	}
	/**
	 * 관광명소 선호도 설정
	 * @param attractionPreference 관광명소 선호도
	 */
	public void setAttractionPreference(int attractionPreference) {
		this.attractionPreference = attractionPreference;
	}
	/**
	 * 쇼핑선호도 반환
	 * @return 쇼핑선호도
	 */
	public int getShoppingPreference() {
		return shoppingPreference;
	}
	/**
	 * 쇼핑선호도 설정
	 * @param shoppingPreference 쇼핑선호도
	 */
	public void setShoppingPreference(int shoppingPreference) {
		this.shoppingPreference = shoppingPreference;
	}
	/**
	 * 기타선호도 반환
	 * @return 기타선호도
	 */
	public int getEtcPreference() {
		return etcPreference;
	}
	/**
	 * 기타선호도 설정
	 * @param etcPreference 기타 선호도
	 */
	public void setEtcPreference(int etcPreference) {
		this.etcPreference = etcPreference;
	}
	
	public String toString() {
		return "LikingInfo [restaurantPreference=" + restaurantPreference
				+ ", healingPreference=" + healingPreference
				+ ", attractionPreference=" + attractionPreference
				+ ", shoppingPreference=" + shoppingPreference
				+ ", etcPreference=" + etcPreference + "]";
	}
}
