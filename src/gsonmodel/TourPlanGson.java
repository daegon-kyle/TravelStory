package gsonmodel;

import java.util.GregorianCalendar;

public class TourPlanGson extends PostingInfoGson{
	private int restaurantPreference;
	private int healingPreference;
	private int attractionPreference;
	private int shoppingPreference;
	private int etcPreference;
	private String destination1;
	private String destination2;
	public TourPlanGson(GregorianCalendar writingDate, String writerName,
			String content, String postingCode, String postingPurposeCode,
			int likeNum, String title, String categoryCode,
			int restaurantPreference, int healingPreference,
			int attractionPreference, int shoppingPreference,
			int etcPreference, String destination1, String destination2) {
		super(writingDate, writerName, content, postingCode,
				postingPurposeCode, likeNum, title, categoryCode);
		this.restaurantPreference = restaurantPreference;
		this.healingPreference = healingPreference;
		this.attractionPreference = attractionPreference;
		this.shoppingPreference = shoppingPreference;
		this.etcPreference = etcPreference;
		this.destination1 = destination1;
		this.destination2 = destination2;
	}
	public TourPlanGson(GregorianCalendar writingDate, String writerName,
			String content, String postingCode, String postingPurposeCode,
			int likeNum, String title, String categoryCode) {
		super(writingDate, writerName, content, postingCode,
				postingPurposeCode, likeNum, title, categoryCode);
	}
	public TourPlanGson() {
	}
	public int getRestaurantPreference() {
		return restaurantPreference;
	}
	public void setRestaurantPreference(int restaurantPreference) {
		this.restaurantPreference = restaurantPreference;
	}
	public int getHealingPreference() {
		return healingPreference;
	}
	public void setHealingPreference(int healingPreference) {
		this.healingPreference = healingPreference;
	}
	public int getAttractionPreference() {
		return attractionPreference;
	}
	public void setAttractionPreference(int attractionPreference) {
		this.attractionPreference = attractionPreference;
	}
	public int getShoppingPreference() {
		return shoppingPreference;
	}
	public void setShoppingPreference(int shoppingPreference) {
		this.shoppingPreference = shoppingPreference;
	}
	public int getEtcPreference() {
		return etcPreference;
	}
	public void setEtcPreference(int etcPreference) {
		this.etcPreference = etcPreference;
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
	@Override
	public String toString() {
		return "TourPlanGson [restaurantPreference=" + restaurantPreference
				+ ", healingPreference=" + healingPreference
				+ ", attractionPreference=" + attractionPreference
				+ ", shoppingPreference=" + shoppingPreference
				+ ", etcPreference=" + etcPreference + ", destination1="
				+ destination1 + ", destination2=" + destination2 + "]";
	}
	
}
