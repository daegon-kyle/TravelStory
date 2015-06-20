// 0720 ¹®Á¤Çö
package dto;

public class TourPreparationDTO {
	private String tourPreparationCode;
	private String postingCode;
	private String destination1;
	private String destination2;
	private String startDate;
	private String endDate;
	public TourPreparationDTO(String tourPreparationCode, String postingCode,
			String destination1, String destination2, String startDate,
			String endDate) {
		this.tourPreparationCode = tourPreparationCode;
		this.postingCode = postingCode;
		this.destination1 = destination1;
		this.destination2 = destination2;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public TourPreparationDTO() {
	}
	public String getTourPreparationCode() {
		return tourPreparationCode;
	}
	public void setTourPreparationCode(String tourPreparationCode) {
		this.tourPreparationCode = tourPreparationCode;
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
	@Override
	public String toString() {
		return "TourPreparationDTO [tourPreparationCode=" + tourPreparationCode
				+ ", postingCode=" + postingCode + ", destination1="
				+ destination1 + ", destination2=" + destination2
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
}
