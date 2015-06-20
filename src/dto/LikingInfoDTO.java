//작성날짜 : 2014/7/19
//작성자 : 이화섭

package dto;

/**
 * 선호도 테이블 정보를 저장할 클래스
 * @author 화섭
 *
 */
public class LikingInfoDTO 
{
	private String likingInfoCode;
	private int restaurant;
	private int healing;
	private int attraction;
	private int shopping;
	private int etc;
	
	/**
	 * 기본생성자
	 */
	public LikingInfoDTO()
	{
		this("",0,0,0,0,0);
	}
	
	
	/**
	 * 전달인자를 받는 생성자
	 * @param likingInfoCode 선호도코드
	 * @param restaurant 맛집선호
	 * @param healing 힐링
	 * @param attraction 명소선호
	 * @param shopping 쇼핑선호
	 * @param etc 기타선호
	 */
	public LikingInfoDTO(String likingInfoCode, int restaurant, int healing,
			int attraction, int shopping, int etc) { 
		this.likingInfoCode = likingInfoCode;
		this.restaurant = restaurant;
		this.healing = healing;
		this.attraction = attraction;
		this.shopping = shopping;
		this.etc = etc;
	}
	/**
	 * 선호도코드를 리턴한다
	 * @return
	 */
	public String getLikingInfoCode() {
		return likingInfoCode;
	}
	/**
	 * 선호도코드를 설정한다
	 * @param likingInfoCode
	 */
	public void setLikingInfoCode(String likingInfoCode) {
		this.likingInfoCode = likingInfoCode;
	}
	/**
	 * 맛집정보를 리턴한다
	 * @return
	 */
	public int getRestaurant() {
		return restaurant;
	}
	/**
	 * 맛집정보를 설정한다
	 * @param restaurant
	 */
	public void setRestaurant(int restaurant) {
		this.restaurant = restaurant;
	}
	/**
	 * 힐링선호도를 리턴한다
	 * @return
	 */
	public int getHealing() {
		return healing;
	}
	/**
	 * 힐링선호도를 설정한다
	 * @param healing
	 */
	public void setHealing(int healing) {
		this.healing = healing;
	}
	/**
	 * 명소선호도를 리턶나다
	 * @return
	 */
	public int getAttraction() {
		return attraction;
	}
	/**
	 * 명소선호도를 설정한다
	 * @param attraction
	 */
	public void setAttraction(int attraction) {
		this.attraction = attraction;
	}
	/**
	 * 쇼핑선호도를 리턴한다
	 * @return
	 */
	public int getShopping() {
		return shopping;
	}
	/**
	 * 쇼핑선호도를 설정한다
	 * @param shopping
	 */
	public void setShopping(int shopping) {
		this.shopping = shopping;
	}
	/**
	 * 기타선호도를 리턴한다
	 * @return
	 */
	public int getEtc() {
		return etc;
	}
	/**
	 * 기타선호도를 설정한다
	 * @param etc
	 */
	public void setEtc(int etc) {
		this.etc = etc;
	}
	
	
}
