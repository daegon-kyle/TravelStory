// 0720 ¹®Á¤Çö
package dto;

public class TourPlanDTO {
	private String tourPlanCode;
	private String postingCode;
	private String likingInfoCode;
	private String destination1;
	private String destination2;
	public TourPlanDTO(String tourPlanCode, String postingCode,
			String likingInfoCode, String destination1, String destination2) {
		this.tourPlanCode = tourPlanCode;
		this.postingCode = postingCode;
		this.likingInfoCode = likingInfoCode;
		this.destination1 = destination1;
		this.destination2 = destination2;
	}
	public TourPlanDTO() {
	}
	public String getTourPlanCode() {
		return tourPlanCode;
	}
	public void setTourPlanCode(String tourPlanCode) {
		this.tourPlanCode = tourPlanCode;
	}
	public String getPostingCode() {
		return postingCode;
	}
	public void setPostingCode(String postingCode) {
		this.postingCode = postingCode;
	}
	public String getLikingInfoCode() {
		return likingInfoCode;
	}
	public void setLikingInfoCode(String likingInfoCode) {
		this.likingInfoCode = likingInfoCode;
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
		return "TourPlanDTO [tourPlanCode=" + tourPlanCode + ", postingCode="
				+ postingCode + ", likingInfoCode=" + likingInfoCode
				+ ", destination1=" + destination1 + ", destination2="
				+ destination2 + "]";
	}
	
	
}
