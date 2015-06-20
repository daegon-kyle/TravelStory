package form;
/**
 * �������� ��õ�ޱ����� �Է��ؾ� �ϴ� �� Ŭ����
 * TourPlanServlet���� ȣ�� 
 * @author ����
 *
 */
public class TourPlanRecommendInfoForm {
	/**
	 * �����
	 */
	private String destination1;
	/**
	 * ������
	 */
	private String destination2;
	/**
	 * ���� ��ȣ��
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
	 * ���� ��ȣ��
	 */
	private String shoppingPreference;
	/**
	 * ��Ÿ ��ȣ��
	 */
	private String etcPreference;
	/**
	 * null ������ 
	 */
	public TourPlanRecommendInfoForm() {

	}
	/**
	 * ������1, ������2, ������ȣ��, ������ȣ��, ������Ҽ�ȣ��, ���μ�ȣ��, ��Ÿ��ȣ���� �ʱ�ȭ�ϴ� ������ 
	 * @param destination1 ������1
	 * @param destination2 ������2
	 * @param restrauntPreference ������ȣ��
	 * @param healingPreference ������ȣ��
	 * @param attractionPreference ������Ҽ�ȣ��
	 * @param shoppingPreference ���μ�ȣ��
	 * @param etcPreference ��Ÿ��ȣ��
	 */
	public TourPlanRecommendInfoForm(String destination1, String destination2,
			String restrauntPreference, String healingPreference,
			String attractionPreference, String shoppingPreference,
			String etcPreference) {
		this.destination1 = destination1;
		this.destination2 = destination2;
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
	 * �������� �����Ѵ�. 
	 * @param destination2 ������ 
	 */
	public void setDestination2(String destination2) {
		this.destination2 = destination2;
	}
	/**
	 * ������ȣ���� ��ȯ�Ѵ�.
	 * @return ������ȣ��
	 */
	public String getRestrauntPreference() {
		return restrauntPreference;
	}
	/**
	 * ������ȣ���� �����Ѵ�. 
	 * @param restrauntPreference
	 */
	public void setRestrauntPreference(String restrauntPreference) {
		this.restrauntPreference = restrauntPreference;
	}
	/**
	 * ������ȣ���� ��ȯ�Ѵ�.
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
