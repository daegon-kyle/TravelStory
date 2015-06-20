package form;
/**
 * ����ڰ� �Է��� ��������õ �������� �����ϱ� ���� �� Ŭ����
 * 
 *
 */
public class CompanionInfoForm {
	/**
	 * ���� ����
	 */
	private String otherGender;
	/**
	 * �����
	 */
	private String destination1;
	/**
	 * ������
	 */
	private String destination2;
	/**
	 * �湮 ���� ��¥
	 */
	private String startDate;
	/**
	 * �湮 �� ��¥
	 */
	private String endDate;
	/**
	 * ����
	 */
	private String title;
	/**
	 * ����
	 */
	private String content;
	/**
	 * ������ ���� �ڵ�
	 */
	private String postingPurposeCode;
	/**
	 * ī�װ� �ڵ�
	 */
	private String categoryCode;
	
	/**
	 * �� ������
	 */
	public CompanionInfoForm() {
		this("","","","","","","","","");
	}
	/**
	 * ������
	 * @param otherGender �ٸ� ����
	 * @param destination1 �����
	 * @param destination2 ������
	 * @param startDate ���۳�¥
	 * @param endDate ������¥
	 * @param title ����
	 * @param content ����
	 * @param postingPurposeCode �����ø����ڵ�
	 * @param categoryCode ī�װ� �ڵ�
	 */
	public CompanionInfoForm(String otherGender,
			String destination1, String destination2, String startDate,
			String endDate,String title,
			String content, String postingPurposeCode, String categoryCode) {
		this.otherGender = otherGender;
		this.destination1 = destination1;
		this.destination2 = destination2;
		this.startDate = startDate;
		this.endDate = endDate;
		this.title = title;
		this.content = content;
		this.postingPurposeCode = postingPurposeCode;
		this.categoryCode = categoryCode;
	}

	public String getOtherGender() {
		return otherGender;
	}
	public void setOtherGender(String otherGender) {
		this.otherGender = otherGender;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPostingPurposeCode() {
		return postingPurposeCode;
	}
	public void setPostingPostingPurposeCode(String postingPurposeCode) {
		this.postingPurposeCode = postingPurposeCode;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	
	
}
