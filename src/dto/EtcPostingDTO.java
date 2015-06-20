// 0721 ¹®Á¤Çö
package dto;

public class EtcPostingDTO {
	private String postingCode;
	private String postingPurposeName;
	private String memberCode;
	private String subCategoryCode;
	private String subCategoryName;
	private String title;
	private String writingDate;
	private String writerName;
	private String content;
	private int likeNum;
	public EtcPostingDTO(String postingCode, String postingPurposeName,
			String memberCode, String subCategoryCode, String subCategoryName,
			String title, String writingDate, String writerName,
			String content, int likeNum) {
		this.postingCode = postingCode;
		this.postingPurposeName = postingPurposeName;
		this.memberCode = memberCode;
		this.subCategoryCode = subCategoryCode;
		this.subCategoryName = subCategoryName;
		this.title = title;
		this.writingDate = writingDate;
		this.writerName = writerName;
		this.content = content;
		this.likeNum = likeNum;
	}
	public EtcPostingDTO() {
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
	public int getLikeNum() {
		return likeNum;
	}
	public void setLikeNum(int likeNum) {
		this.likeNum = likeNum;
	}
	@Override
	public String toString() {
		return "EtcPostingDTO [postingCode=" + postingCode
				+ ", postingPurposeName=" + postingPurposeName
				+ ", memberCode=" + memberCode + ", subCategoryCode="
				+ subCategoryCode + ", subCategoryName=" + subCategoryName
				+ ", title=" + title + ", writingDate=" + writingDate
				+ ", writerName=" + writerName + ", content=" + content
				+ ", likeNum=" + likeNum + "]";
	}
	
}
