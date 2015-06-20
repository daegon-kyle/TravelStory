// 0722 ¹®Á¤Çö
package dto;

public class CategoryDTO {
	private String memberCode;
	private String blogCode;
	private String mainCategoryCode;
	private String mainCategoryName;
	private String subCategoryCode;
	private String subCategoryName;
	
	public CategoryDTO(String memberCode, String blogCode,
			String mainCategoryCode, String mainCategoryName,
			String subCategoryCode, String subCategoryName) {
		this.memberCode = memberCode;
		this.blogCode = blogCode;
		this.mainCategoryCode = mainCategoryCode;
		this.mainCategoryName = mainCategoryName;
		this.subCategoryCode = subCategoryCode;
		this.subCategoryName = subCategoryName;
	}
	public CategoryDTO() {
		this("","","","","","");
	}
	public String getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	public String getBlogCode() {
		return blogCode;
	}
	public void setBlogCode(String blogCode) {
		this.blogCode = blogCode;
	}
	public String getMainCategoryCode() {
		return mainCategoryCode;
	}
	public void setMainCategoryCode(String mainCategoryCode) {
		this.mainCategoryCode = mainCategoryCode;
	}
	public String getMainCategoryName() {
		return mainCategoryName;
	}
	public void setMainCategoryName(String mainCategoryName) {
		this.mainCategoryName = mainCategoryName;
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
	@Override
	public String toString() {
		return "CategoryDTO [memberCode=" + memberCode + ", blogCode="
				+ blogCode + ", mainCategoryCode=" + mainCategoryCode
				+ ", mainCategoryName=" + mainCategoryName
				+ ", subCategoryCode=" + subCategoryCode + ", subCategoryName="
				+ subCategoryName + "]";
	}
}
