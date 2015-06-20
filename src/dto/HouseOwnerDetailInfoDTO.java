package dto;

public class HouseOwnerDetailInfoDTO {
	private String houseOwnerCode;
	private String ownerName;
	private String email;
	private String address;
	private String visitStartDate;
	private String visitEndDate;
	private String job;
	private String marriedState;
	private String selfIntroduction;
	private String etc;
	public HouseOwnerDetailInfoDTO(String houseOwnerCode, String ownerName,
			String email, String address, String visitStartDate,
			String visitEndDate, String job, String marriedState,
			String selfIntroduction, String etc) {
		this.houseOwnerCode = houseOwnerCode;
		this.ownerName = ownerName;
		this.email = email;
		this.address = address;
		this.visitStartDate = visitStartDate;
		this.visitEndDate = visitEndDate;
		this.job = job;
		this.marriedState = marriedState;
		this.selfIntroduction = selfIntroduction;
		this.etc = etc;
	}
	public HouseOwnerDetailInfoDTO() {
		this("","","","","","","","","","");
	}
	public String getHouseOwnerCode() {
		return houseOwnerCode;
	}
	public void setHouseOwnerCode(String houseOwnerCode) {
		this.houseOwnerCode = houseOwnerCode;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getVisitStartDate() {
		return visitStartDate;
	}
	public void setVisitStartDate(String visitStartDate) {
		this.visitStartDate = visitStartDate;
	}
	public String getVisitEndDate() {
		return visitEndDate;
	}
	public void setVisitEndDate(String visitEndDate) {
		this.visitEndDate = visitEndDate;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getMarriedState() {
		return marriedState;
	}
	public void setMarriedState(String marriedState) {
		this.marriedState = marriedState;
	}
	public String getSelfIntroduction() {
		return selfIntroduction;
	}
	public void setSelfIntroduction(String selfIntroduction) {
		this.selfIntroduction = selfIntroduction;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}
	@Override
	public String toString() {
		return "HouseOwnerDetailInfoDTO [houseOwnerCode=" + houseOwnerCode
				+ ", ownerName=" + ownerName + ", email=" + email
				+ ", address=" + address + ", visitStartDate=" + visitStartDate
				+ ", visitEndDate=" + visitEndDate + ", job=" + job
				+ ", marriedState=" + marriedState + ", selfIntroduction="
				+ selfIntroduction + ", etc=" + etc + "]";
	}
	
}
