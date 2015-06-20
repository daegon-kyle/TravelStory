package form;

/**
 * 
 * �����غ� �������� �ϱ� ���� �Է��ؾ��ϴ� �� Ŭ����
 * PostingAddServlet���� ȣ�� 
 * @author ���
 *
 */
public class TourPreparationInfoForm {
	/**
	 * ������۳�¥
	 */
	private String startDate;
	/**
	 * ���� �� ��¥
	 */
	private String endDate;
	/**
	 * �����
	 */
	private String destination1;
	/**
	 * ������¥
	 */
	private String destination2;
	/**
	 * ����
	 */
	private String title;
	/**
	 * ����
	 */
	private String content;
	/**
	 * �����ø����ڵ�
	 */
	private String postingPurposeCode;
	/**
	 * ī�װ� �ڵ�
	 */
	private String categoryCode;
	/**
	 * null  ������ 
	 */
	public TourPreparationInfoForm() {
		this("","","","","","","","");
	}

/**
 * ������, ������, ������1, ������2, ����, ����, �����ø����ڵ�, ī�װ��ڵ带 �ʱ�ȭ�ϴ� ������ 
 * @param startDate ������
 * @param endDate ������ 
 * @param destination1 ������1
 * @param destination2 ������2
 * @param title ����
 * @param content ����
 * @param postingPurposeCode �����ø����ڵ�
 * @param categoryCode ī�װ��ڵ带 �ʱ�ȭ�ϴ� ������ 
 */
	public TourPreparationInfoForm(String startDate, String endDate,
			String destination1, String destination2,String title, String content, String postingPurposeCode, String categoryCode){
		this.startDate = startDate;
		this.endDate = endDate;
		this.destination1 = destination1;
		this.destination2 = destination2;
		this.title = title;
		this.content = content;
		this.postingPurposeCode = postingPurposeCode;
		this.categoryCode = categoryCode;
	}

/**
 * ����������� ��ȯ�Ѵ�.
 * @return ��������� 
 */
	public String getStartDate() {
		return startDate;
	}

/**
 * ����������� �����Ѵ�. 
 * @param startDate ��������� 
 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

/**
 * ������������ ��ȯ�Ѵ�.
 * @return ���������� 
 */
	public String getEndDate() {
		return endDate;
	}

/**
 * ������������ �����Ѵ�. 
 * @param endDate ���������� 
 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

/**
 * ����������� ��ȯ�Ѵ�. 
 * @return ��������� 
 */
	public String getDestination1() {
		return destination1;
	}

/**
 * ����������� �����Ѵ�.
 * @param destination1 ��������� 
 */
	public void setDestination1(String destination1) {
		this.destination1 = destination1;
	}

/**
 * ����������� ��ȯ�Ѵ�. 
 * @return ��������� 
 */
	public String getDestination2() {
		return destination2;
	}

/**
 * ����������� �����Ѵ�. 
 * @param destination2 ��������� 
 */
	public void setDestination2(String destination2) {
		this.destination2 = destination2;
	}

/**
 * ������ ��ȯ�Ѵ�. 
 * @return ����
 */
	public String getTitle() {
		return title;
	}

/**
 * ������ �����Ѵ�. 
 * @param title ���� 
 */
	public void setTitle(String title) {
		this.title = title;
	}

/**
 * ������ ��ȯ�Ѵ�.
 * @return ����
 */
	public String getContent() {
		return content;
	}

/**
 * ������ �����Ѵ�. 
 * @param content ����
 */
	public void setContent(String content) {
		this.content = content;
	}

/**
 * �����ø����ڵ带 ��ȯ�Ѵ�. 
 * @return �����ø����ڵ� 
 */
	public String getPostingPurposeCode() {
		return postingPurposeCode;
	}

/**
 * ������ �����ڵ带 �����Ѵ�. 
 * @param postingPurposeCode �����ø��� �ڵ� 
 */
	public void setPostingPurposeCode(String postingPurposeCode) {
		this.postingPurposeCode = postingPurposeCode;
	}

/**
 * ī�װ��ڵ带 ��ȯ�Ѵ�. 
 * @return ī�װ��ڵ� 
 */
	public String getCategoryCode() {
		return categoryCode;
	}

/**
 * ī�װ��ڵ带 �����Ѵ�. 
 * @param categoryCode ī�װ��ڵ� 
 */
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	
}
