package form;

/**
 * ������������ �������� �ø��� ���� �Է��ؾ��ϴ� �� Ŭ����
 * PostingAddServlet���� ȣ��
 * @author ����
 *
 */
public class TourPlanInfoForm {
	/**
	 * �����
	 */
	private String destination1;
	/**
	 * ������
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
	 * ������ȣ��
	 */
	private String restrauntPreference;
	/**
	 * ���� ��ȣ��
	 */
	private String healingPreference;
	/**
	 * ������� ��ȣ��
	 */
	private String attractionPreference;
	/**
	 * ���μ�ȣ��
	 */
	private String shoppingPreference;
	/**
	 * ��Ÿ ��ȣ��
	 */
	private String etcPreference;
/**
 * null ������ 
 */
	public TourPlanInfoForm() {
		this("","","","","","","","","");
	}
	/**
	 * ������,����, ����, ������ȣ��, ������ȣ��, ������� ��ȣ��, ���μ�ȣ��, ��Ÿ ��ȣ���� �ʱ�ȭ�ϴ� ������ 
	 * @param destination1 ������1 
	 * @param destination2 ������2
	 * @param title ����
	 * @param content ����
	 * @param restrauntPreference ������ȣ�� 
	 * @param healingPreference ������ȣ�� 
	 * @param attractionPreference ������� ��ȣ�� 
	 * @param shoppingPreference ���μ�ȣ�� 
	 * @param etcPreference ��Ÿ��ȣ�� 
	 */
	public TourPlanInfoForm(String destination1, String destination2,
			String title, String content, String restrauntPreference,
			String healingPreference, String attractionPreference,
			String shoppingPreference, String etcPreference) {
		this.destination1 = destination1;
		this.destination2 = destination2;
		this.title = title;
		this.content = content;
		this.restrauntPreference = restrauntPreference;
		this.healingPreference = healingPreference;
		this.attractionPreference = attractionPreference;
		this.shoppingPreference = shoppingPreference;
		this.etcPreference = etcPreference;
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
	 * �������������Ѵ�. 
	 * @param destination2 ������ 
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
	 * ������ȣ���� �����Ѵ�.
	 * @return ������ȣ�� 
	 */
	public String getRestrauntPreference() {
		return restrauntPreference;
	}
	/**
	 * ������ȣ���� �����Ѵ�.
	 * @param restrauntPreference ������ȣ�� 
	 */
	public void setRestrauntPreference(String restrauntPreference) {
		this.restrauntPreference = restrauntPreference;
	}
	/**
	 * ���� ��ȣ���� ��ȯ�ϴ�.
	 * @return ������ȣ�� 
	 */
	public String getHealingPreference() {
		return healingPreference;
	}
	/**
	 * ������ȣ���� �����Ѵ�.
	 * @param healingPreference ������ȣ��  
	 */
	public void setHealingPreference(String healingPreference) {
		this.healingPreference = healingPreference;
	}
	/**
	 * ������Ҹ� ��ȯ�Ѵ�.
	 * @return �������
	 */
	public String getAttractionPreference() {
		return attractionPreference;
	}
	/**
	 * ������Ҹ� �����Ѵ�.
	 * @param attractionPreference �������
	 */
	public void setAttractionPreference(String attractionPreference) {
		this.attractionPreference = attractionPreference;
	}
	/**
	 * ���μ�ȣ���� ��ȯ�Ѵ�.
	 * @return ���μ�ȣ�� 
	 */
	public String getShoppingPreference() {
		return shoppingPreference;
	}
	/**
	 * ���μ�ȣ���� �����Ѵ�.
	 * @param shoppingPreference ���μ�ȣ�� 
	 */
	public void setShoppingPreference(String shoppingPreference) {
		this.shoppingPreference = shoppingPreference;
	}
	/**
	 * ��Ÿ��ȣ���� ��ȯ�Ѵ�.
	 * @return ��Ÿ��ȣ�� 
	 */
	public String getEtcPreference() {
		return etcPreference;
	}
	/**
	 * ��Ÿ��ȣ���� �����Ѵ�.
	 * @param etcPreference ��Ÿ��ȣ�� 
	 */
	public void setEtcPreference(String etcPreference) {
		this.etcPreference = etcPreference;
	}
}
