package form;

public class CompanionRecommendInfoForm {
	private String otherGender;
	private String destination1;
	private String destination2;
	private String startDate;
	private String endDate;
	private String otherAge;
	
	public CompanionRecommendInfoForm() {
		this("","","","","","");
	}
	public CompanionRecommendInfoForm(String otherGender,
			String destination1, String destination2, String startDate,
			String endDate, String otherAge) {
		super();
		this.otherGender = otherGender;
		this.destination1 = destination1;
		this.destination2 = destination2;
		this.startDate = startDate;
		this.endDate = endDate;
		this.otherAge = otherAge;
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
	public String getOtherAge() {
		return otherAge;
	}
	public void setOtherAge(String otherAge) {
		this.otherAge = otherAge;
	}
	@Override
	public String toString() {
		return "CompanionRecommendInfoForm [otherGender=" + otherGender
				+ ", destination1=" + destination1 + ", destination2="
				+ destination2 + ", startDate=" + startDate + ", endDate="
				+ endDate + ", otherAge=" + otherAge + "]";
	}
	
}
