package dto;

public class TourPreparationPostingDTO {
	private String postingCode;
	private String postingPurposeName;
	private String memberCode;
	private String subCategoryCode;
	private String subCategoryName;
	private String title;
	private String destination1;
	private String destination2;
	private String writingDate;
	private String writerName;
	private String startDate;
	private String endDate;
	private String content;
	private int likeNum;
	public TourPreparationPostingDTO(String postingCode,
			String postingPurposeName, String memberCode,
			String subCategoryCode, String subCategoryName, String title,
			String destination1, String destination2, String writingDate,
			String writerName, String startDate, String endDate,
			String content, int likeNum) {
		this.postingCode = postingCode;
		this.postingPurposeName = postingPurposeName;
		this.memberCode = memberCode;
		this.subCategoryCode = subCategoryCode;
		this.subCategoryName = subCategoryName;
		this.title = title;
		this.destination1 = destination1;
		this.destination2 = destination2;
		this.writingDate = writingDate;
		this.writerName = writerName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.content = content;
		this.likeNum = likeNum;
	}
	public TourPreparationPostingDTO() {
	}
	public String getPostingCode() {
		return postingCode;
	}
	public void setPostingCode(String postingCode) {
		this.postingCode = postingCode;
	}
	public String getPostingPurposeName() {
		return postingPurposeName;
	}
	public void setPostingPurposeName(String postingPurposeName) {
		this.postingPurposeName = postingPurposeName;
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
		return "TourPreparationPostingDTO [postingCode=" + postingCode
				+ ", postingPurposeName=" + postingPurposeName
				+ ", memberCode=" + memberCode + ", subCategoryCode="
				+ subCategoryCode + ", subCategoryName=" + subCategoryName
				+ ", title=" + title + ", destination1=" + destination1
				+ ", destination2=" + destination2 + ", writingDate="
				+ writingDate + ", writerName=" + writerName + ", startDate="
				+ startDate + ", endDate=" + endDate + ", content=" + content
				+ ", likeNum=" + likeNum + "]";
	}
	
}
