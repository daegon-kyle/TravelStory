package form;
/**
 * �����غ� ��õ���񽺸� �ޱ� ���� �Է��ؾ� �ϴ� �� Ŭ����
 * TourPreparationServlet���� ȣ�� 
 * @author ����
 *
 */
public class TourPreparationRecommendInfoForm {
	/**
	 * ���� ���� ��¥
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
	 * ������
	 */
	private String destination2;
	/**
	 * null ������ 
	 */
	public TourPreparationRecommendInfoForm() {
		this("","","","");
	}
	/**
	 * ���������, ����������, ������1, ������2�� �ʱ�ȭ�ϴ� ������ 
	 * @param startDate ���������
	 * @param endDate ����������
	 * @param destination1 ������1
	 * @param destination2 ������2
	 */
	public TourPreparationRecommendInfoForm(String startDate, String endDate,
			String destination1, String destination2) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.destination1 = destination1;
		this.destination2 = destination2;
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
	 * �������� ��ȯ�Ѵ�. 
	 * @return ������ 
	 */
	public String getDestination1() {
		return destination1;
	}
	/**
	 * �������� �����Ѵ�. 
	 * @param destination1 ������ 
	 */
	public void setDestination1(String destination1) {
		this.destination1 = destination1;
	}
	/**
	 * �������� ��ȯ�Ѵ�. 
	 * @return ������ 
	 */
	public String getDestination2() {
		return destination2;
	}
	/**
	 * �������� �����Ѵ�.
	 * @param destination2 ������ 
	 */
	public void setDestination2(String destination2) {
		this.destination2 = destination2;
	}
}
