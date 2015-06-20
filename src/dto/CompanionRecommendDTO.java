// 0719 ¹®Á¤Çö
package dto;

public class CompanionRecommendDTO {
	private String companionRecommendCode;
	private String postingCode;
	private String destination1;
	private String destination2;
	private String startDate;
	private String endDate;
	int otherAge;
	private String otherGender;
	public CompanionRecommendDTO(String companionRecommendCode,
			String postingCode, String destination1, String destination2,
			String startDate, String endDate, int otherAge, String otherGender) {
		this.companionRecommendCode = companionRecommendCode;
		this.postingCode = postingCode;
		this.destination1 = destination1;
		this.destination2 = destination2;
		this.startDate = startDate;
		this.endDate = endDate;
		this.otherAge = otherAge;
		this.otherGender = otherGender;
	}
	public CompanionRecommendDTO() {
	}
	public String getCompanionRecommendCode() {
		return companionRecommendCode;
	}
	public void setCompanionRecommendCode(String companionRecommendCode) {
		this.companionRecommendCode = companionRecommendCode;
	}
	public String getPostingCode() {
		return postingCode;
	}
	public void setPostingCode(String postingCode) {
		this.postingCode = postingCode;
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
	public int getOtherAge() {
		return otherAge;
	}
	public void setOtherAge(int otherAge) {
		this.otherAge = otherAge;
	}
	public String getOtherGender() {
		return otherGender;
	}
	public void setOtherGender(String otherGender) {
		this.otherGender = otherGender;
	}
	@Override
	public String toString() {
		return "CompanionRecommendDTO [companionRecommendCode="
				+ companionRecommendCode + ", postingCode=" + postingCode
				+ ", destination1=" + destination1 + ", destination2="
				+ destination2 + ", startDate=" + startDate + ", endDate="
				+ endDate + ", otherAge=" + otherAge + ", otherGender="
				+ otherGender + "]";
	}
	
	
}
