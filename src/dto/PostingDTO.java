// 0719 ¹®Á¤Çö
package dto;

public class PostingDTO {
	private String postingCode;
	private String postingPurposeCode;
	private String memberCode;
	private String subCategoryCode;
	private String title;
	private int likeNum;
	private String content;
	private String writingDate;
	public PostingDTO(){
		
	}
	public PostingDTO(String postingCode, String postingPurposeCode,
			String memberCode, String subCategoryCode, String title,
			int likeNum, String content, String writingDate) {
		this.postingCode = postingCode;
		this.postingPurposeCode = postingPurposeCode;
		this.memberCode = memberCode;
		this.subCategoryCode = subCategoryCode;
		this.title = title;
		this.likeNum = likeNum;
		this.content = content;
		this.writingDate = writingDate;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getLikeNum() {
		return likeNum;
	}
	public void setLikeNum(int likeNum) {
		this.likeNum = likeNum;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWritingDate() {
		return writingDate;
	}
	public void setWritingDate(String writingDate) {
		this.writingDate = writingDate;
	}
	@Override
	public String toString() {
		return "PostingDTO [postingCode=" + postingCode
				+ ", postingPurposeCode=" + postingPurposeCode
				+ ", memberCode=" + memberCode + ", subCategoryCode="
				+ subCategoryCode + ", title=" + title + ", likeNum=" + likeNum
				+ ", content=" + content + ", writingDate=" + writingDate + "]";
	}
	
}
