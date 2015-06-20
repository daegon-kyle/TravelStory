// 0721 ¹®Á¤Çö
package dto;

public class TourPlanPostingDTO {
	private String postingCode;
	private String postingPuposeName;
	private String memberCode;
	private String subCategoryCode;
	private String subCategoryName;
	private String title;
	private String destination1;
	private String destination2;
	private String writingDate;
	private String writerName;
	private String restaurantPreference;
	private String healingPreference;
	private String attractionPreference;
	private String shoppingPreference;
	private String etcPreference;
	private String content;
	private int likeNum;
	public TourPlanPostingDTO(String postingCode, String postingPuposeName,
			String memberCode, String subCategoryCode, String subCategoryName,
			String title, String destination1, String destination2,
			String writingDate, String writerName, String restaurantPreference,
			String healingPreference, String attractionPreference,
			String shoppingPreference, String etcPreference, String content,
			int likeNum) {
		this.postingCode = postingCode;
		this.postingPuposeName = postingPuposeName;
		this.memberCode = memberCode;
		this.subCategoryCode = subCategoryCode;
		this.subCategoryName = subCategoryName;
		this.title = title;
		this.destination1 = destination1;
		this.destination2 = destination2;
		this.writingDate = writingDate;
		this.writerName = writerName;
		this.restaurantPreference = restaurantPreference;
		this.healingPreference = healingPreference;
		this.attractionPreference = attractionPreference;
		this.shoppingPreference = shoppingPreference;
		this.etcPreference = etcPreference;
		this.content = content;
		this.likeNum = likeNum;
	}
	public TourPlanPostingDTO() {
	}
	public String getPostingCode() {
		return postingCode;
	}
	public void setPostingCode(String postingCode) {
		this.postingCode = postingCode;
	}
	public String getPostingPuposeName() {
		return postingPuposeName;
	}
	public void setPostingPuposeName(String postingPuposeName) {
		this.postingPuposeName = postingPuposeName;
	}
	public String getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	public String getSubCategoryCode() {
		return subCategoryCode;
	}
	public void setSubCategoryCode(String subCategoryCode) {
		this.subCategoryCode = subCategoryCode;
	}
	public String getSubCategoryName() {
		return subCategoryName;
	}
	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getWritingDate() {
		return writingDate;
	}
	public void setWritingDate(String writingDate) {
		this.writingDate = writingDate;
	}
	public String getWriterName() {
		return writerName;
	}
	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}
	public String getRestaurantPreference() {
		return restaurantPreference;
	}
	public void setRestaurantPreference(String restaurantPreference) {
		this.restaurantPreference = restaurantPreference;
	}
	public String getHealingPreference() {
		return healingPreference;
	}
	public void setHealingPreference(String healingPreference) {
		this.healingPreference = healingPreference;
	}
	public String getAttractionPreference() {
		return attractionPreference;
	}
	public void setAttractionPreference(String attractionPreference) {
		this.attractionPreference = attractionPreference;
	}
	public String getShoppingPreference() {
		return shoppingPreference;
	}
	public void setShoppingPreference(String shoppingPreference) {
		this.shoppingPreference = shoppingPreference;
	}
	public String getEtcPreference() {
		return etcPreference;
	}
	public void setEtcPreference(String etcPreference) {
		this.etcPreference = etcPreference;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getLikeNum() {
		return likeNum;
	}
	public void setLikeNum(int likeNum) {
		this.likeNum = likeNum;
	}
	@Override
	public String toString() {
		return "TourPlanPostingDTO [postingCode=" + postingCode
				+ ", postingPuposeName=" + postingPuposeName + ", memberCode="
				+ memberCode + ", subCategoryCode=" + subCategoryCode
				+ ", subCategoryName=" + subCategoryName + ", title=" + title
				+ ", destination1=" + destination1 + ", destination2="
				+ destination2 + ", writingDate=" + writingDate
				+ ", writerName=" + writerName + ", restaurantPreference="
				+ restaurantPreference + ", healingPreference="
				+ healingPreference + ", attractionPreference="
				+ attractionPreference + ", shoppingPreference="
				+ shoppingPreference + ", etcPreference=" + etcPreference
				+ ", content=" + content + ", likeNum=" + likeNum + "]";
	}
	
}
