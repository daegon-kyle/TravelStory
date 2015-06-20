// 0721 ¹®Á¤Çö
package dto;

public class PostingListDTO {
	private String postingCode;
	private String postingPurposeCode;
	private String title;
	private String writingDate;
	private String writerName;
	private int likeNum;
	public PostingListDTO(String postingCode, String postingPurposeCode,
			String title, String writingDate, String writerName, int likeNum) {
		this.postingCode = postingCode;
		this.postingPurposeCode = postingPurposeCode;
		this.title = title;
		this.writingDate = writingDate;
		this.writerName = writerName;
		this.likeNum = likeNum;
	}
	public PostingListDTO() {
	}
	public String getPostingCode() {
		return postingCode;
	}
	public void setPostingCode(String postingCode) {
		this.postingCode = postingCode;
	}
	public String getPostingPurposeCode() {
		return postingPurposeCode;
	}
	public void setPostingPurposeCode(String postingPurposeCode) {
		this.postingPurposeCode = postingPurposeCode;
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
		return "PostingListDTO [postingCode=" + postingCode
				+ ", postingPurposeCode=" + postingPurposeCode + ", title="
				+ title + ", writingDate=" + writingDate + ", writerName="
				+ writerName + ", likeNum=" + likeNum + "]";
	}
	
}
