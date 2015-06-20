package model;

import java.io.Serializable;
/**
 * ���������� ĸ��ȭ�� Ŭ����
 * <br>TourPlanInfoServlet���� ����Ϸ��� Ŭ����
 * @author ���
 *
 */
public class LikingInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5561472474285273527L;
	/**
	 * ������ȣ��
	 */
	private int restaurantPreference;
	/**
	 * ���� ��ȣ��
	 */
	private int healingPreference;
	/**
	 * ���� ��ȣ��
	 */
	private int attractionPreference;
	/**
	 * ���� ��ȣ��
	 */
	private int shoppingPreference;
	/**
	 * ��Ÿ ��ȣ��
	 */
	private int etcPreference;
	/**
	 * �λ�����
	 */
	public LikingInfo() {
		this(0,0,0,0,0);
	}
	/**
	 * �⺻������
	 * @param restrauntPreference ������ȣ��
	 * @param healingPreference ������ȣ��
	 * @param attractionPreference ������Ҽ�ȣ��
	 * @param shoppingPreference ���μ�ȣ��
	 * @param etcPreference ��Ÿ��ȣ��
	 */
	public LikingInfo(int restaurantPreference, int healingPreference,
			int attractionPreference, int shoppingPreference, int etcPreference) {
		this.restaurantPreference = restaurantPreference;
		this.healingPreference = healingPreference;
		this.attractionPreference = attractionPreference;
		this.shoppingPreference = shoppingPreference;
		this.etcPreference = etcPreference;
	}
	/**
	 * ������ȣ�� ��ȯ
	 * @return ������ȣ��
	 */
	public int getRestaurantPreference() {
		return restaurantPreference;
	}
	/**
	 * ������ȣ�� ����
	 * @param restrauntPreference ������ȣ��
	 */
	public void setRestaurantPreference(int restaurantPreference) {
		this.restaurantPreference = restaurantPreference;
	}
	/**
	 * ������ȣ�� ��ȯ
	 * @return ������ȣ��
	 */
	public int getHealingPreference() {
		return healingPreference;
	}
	/**
	 * ������ȣ�� ����
	 * @param healingPreference ������ȣ��
	 */
	public void setHealingPreference(int healingPreference) {
		this.healingPreference = healingPreference;
	}
	/**
	 * ������� ��ȣ�� ��ȯ
	 * @return ������� ��ȣ��
	 */
	public int getAttractionPreference() {
		return attractionPreference;
	}
	/**
	 * ������� ��ȣ�� ����
	 * @param attractionPreference ������� ��ȣ��
	 */
	public void setAttractionPreference(int attractionPreference) {
		this.attractionPreference = attractionPreference;
	}
	/**
	 * ���μ�ȣ�� ��ȯ
	 * @return ���μ�ȣ��
	 */
	public int getShoppingPreference() {
		return shoppingPreference;
	}
	/**
	 * ���μ�ȣ�� ����
	 * @param shoppingPreference ���μ�ȣ��
	 */
	public void setShoppingPreference(int shoppingPreference) {
		this.shoppingPreference = shoppingPreference;
	}
	/**
	 * ��Ÿ��ȣ�� ��ȯ
	 * @return ��Ÿ��ȣ��
	 */
	public int getEtcPreference() {
		return etcPreference;
	}
	/**
	 * ��Ÿ��ȣ�� ����
	 * @param etcPreference ��Ÿ ��ȣ��
	 */
	public void setEtcPreference(int etcPreference) {
		this.etcPreference = etcPreference;
	}
	
	public String toString() {
		return "LikingInfo [restaurantPreference=" + restaurantPreference
				+ ", healingPreference=" + healingPreference
				+ ", attractionPreference=" + attractionPreference
				+ ", shoppingPreference=" + shoppingPreference
				+ ", etcPreference=" + etcPreference + "]";
	}
}
