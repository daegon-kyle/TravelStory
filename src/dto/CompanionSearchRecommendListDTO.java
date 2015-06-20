package dto;

public class CompanionSearchRecommendListDTO {
	private String postingCode;
	private String title;
	private String writingDate;
	private String writerName;
	private int reliability;
	public CompanionSearchRecommendListDTO(String postingCode, String title,
			String writingDate, String writerName, int reliability) {
		this.postingCode = postingCode;
		this.title = title;
		this.writingDate = writingDate;
		this.writerName = writerName;
		this.reliability = reliability;
	}
	public CompanionSearchRecommendListDTO() {
	}
	public String getPostingCode() {
		return postingCode;
	}
	public void setPostingCode(String postingCode) {
		this.postingCode = postingCode;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public int getReliability() {
		return reliability;
	}
	public void setReliability(int reliability) {
		this.reliability = reliability;
	}
	@Override
	public String toString() {
		return "CompanionSearchRecommendListDTO [postingCode=" + postingCode
				+ ", title=" + title + ", writingDate=" + writingDate
				+ ", writerName=" + writerName + ", reliability=" + reliability
				+ "]";
	}
	
}
