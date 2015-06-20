package gsonmodel;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
public class PostingInfoGson {
	private String writingDate;
	private String writerName;
	private String content;
	private String postingCode;
	private String postingPurposeCode;
	private int likeNum;
	private String title;
	private String categoryCode;
	public PostingInfoGson(GregorianCalendar writingDate, String writerName,
			String content, String postingCode, String postingPurposeCode,
			int likeNum, String title, String categoryCode) {
		SimpleDateFormat simple = new SimpleDateFormat("yyyy.MM.dd");
		this.writingDate = simple.format(writingDate.getTime());
		this.writerName = writerName;
		this.content = content;
		this.postingCode = postingCode;
		this.postingPurposeCode = postingPurposeCode;
		this.likeNum = likeNum;
		this.title = title;
		this.categoryCode = categoryCode;
	}
	public PostingInfoGson() {
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public int getLikeNum() {
		return likeNum;
	}
	public void setLikeNum(int likeNum) {
		this.likeNum = likeNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	@Override
	public String toString() {
		return "PostingInfoGson [writingDate=" + writingDate + ", writerName="
				+ writerName + ", content=" + content + ", postingCode="
				+ postingCode + ", postingPurposeCode=" + postingPurposeCode
				+ ", likeNum=" + likeNum + ", title=" + title
				+ ", categoryCode=" + categoryCode + "]";
	}
	
}
