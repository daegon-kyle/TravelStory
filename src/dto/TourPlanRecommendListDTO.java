package dto;

public class TourPlanRecommendListDTO {
	private String postingCode;
	private String title;
	private String writingDate;
	private String writerName;
	private int likeNum;
	public TourPlanRecommendListDTO(String postingCode, String title,
			String writingDate, String writerName, int likeNum) {
		this.postingCode = postingCode;
		this.title = title;
		this.writingDate = writingDate;
		this.writerName = writerName;
		this.likeNum = likeNum;
	}
	public TourPlanRecommendListDTO() {
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
	public int getLikeNum() {
		return likeNum;
	}
	public void setLikeNum(int likeNum) {
		this.likeNum = likeNum;
	}
	@Override
	public String toString() {
		return "TourPlanRecommendListDTO [postingCode=" + postingCode
				+ ", title=" + title + ", writingDate=" + writingDate
				+ ", writerName=" + writerName + ", likeNum=" + likeNum + "]";
	}
	
}
