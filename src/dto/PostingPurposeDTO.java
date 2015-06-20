//0719 ¹®Á¤Çö
package dto;

public class PostingPurposeDTO {
	private String postingPurposeCode;
	private String postingPurposeName;
	public PostingPurposeDTO(String postingPurposeCode,
			String postingPurposeName) {
		this.postingPurposeCode = postingPurposeCode;
		this.postingPurposeName = postingPurposeName;
	}
	public PostingPurposeDTO() {
	}
	public String getPostingPurposeCode() {
		return postingPurposeCode;
	}
	public void setPostingPurposeCode(String postingPurposeCode) {
		this.postingPurposeCode = postingPurposeCode;
	}
	public String getPostingPurposeName() {
		return postingPurposeName;
	}
	public void setPostingPurposeName(String postingPurposeName) {
		this.postingPurposeName = postingPurposeName;
	}
	@Override
	public String toString() {
		return "PostingPurposeDTO [postingPurposeCode=" + postingPurposeCode
				+ ", postingPurposeName=" + postingPurposeName + "]";
	}
	
}
