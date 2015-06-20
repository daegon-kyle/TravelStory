//�ۼ���¥ : 2014/7/19
//�ۼ��� : ��ȭ��

package dto;

/**
 * ��ȣ�� ���̺� ������ ������ Ŭ����
 * @author ȭ��
 *
 */
public class LikingInfoDTO 
{
	private String likingInfoCode;
	private int restaurant;
	private int healing;
	private int attraction;
	private int shopping;
	private int etc;
	
	/**
	 * �⺻������
	 */
	public LikingInfoDTO()
	{
		this("",0,0,0,0,0);
	}
	
	
	/**
	 * �������ڸ� �޴� ������
	 * @param likingInfoCode ��ȣ���ڵ�
	 * @param restaurant ������ȣ
	 * @param healing ����
	 * @param attraction ��Ҽ�ȣ
	 * @param shopping ���μ�ȣ
	 * @param etc ��Ÿ��ȣ
	 */
	public LikingInfoDTO(String likingInfoCode, int restaurant, int healing,
			int attraction, int shopping, int etc) { 
		this.likingInfoCode = likingInfoCode;
		this.restaurant = restaurant;
		this.healing = healing;
		this.attraction = attraction;
		this.shopping = shopping;
		this.etc = etc;
	}
	/**
	 * ��ȣ���ڵ带 �����Ѵ�
	 * @return
	 */
	public String getLikingInfoCode() {
		return likingInfoCode;
	}
	/**
	 * ��ȣ���ڵ带 �����Ѵ�
	 * @param likingInfoCode
	 */
	public void setLikingInfoCode(String likingInfoCode) {
		this.likingInfoCode = likingInfoCode;
	}
	/**
	 * ���������� �����Ѵ�
	 * @return
	 */
	public int getRestaurant() {
		return restaurant;
	}
	/**
	 * ���������� �����Ѵ�
	 * @param restaurant
	 */
	public void setRestaurant(int restaurant) {
		this.restaurant = restaurant;
	}
	/**
	 * ������ȣ���� �����Ѵ�
	 * @return
	 */
	public int getHealing() {
		return healing;
	}
	/**
	 * ������ȣ���� �����Ѵ�
	 * @param healing
	 */
	public void setHealing(int healing) {
		this.healing = healing;
	}
	/**
	 * ��Ҽ�ȣ���� ���t����
	 * @return
	 */
	public int getAttraction() {
		return attraction;
	}
	/**
	 * ��Ҽ�ȣ���� �����Ѵ�
	 * @param attraction
	 */
	public void setAttraction(int attraction) {
		this.attraction = attraction;
	}
	/**
	 * ���μ�ȣ���� �����Ѵ�
	 * @return
	 */
	public int getShopping() {
		return shopping;
	}
	/**
	 * ���μ�ȣ���� �����Ѵ�
	 * @param shopping
	 */
	public void setShopping(int shopping) {
		this.shopping = shopping;
	}
	/**
	 * ��Ÿ��ȣ���� �����Ѵ�
	 * @return
	 */
	public int getEtc() {
		return etc;
	}
	/**
	 * ��Ÿ��ȣ���� �����Ѵ�
	 * @param etc
	 */
	public void setEtc(int etc) {
		this.etc = etc;
	}
	
	
}
