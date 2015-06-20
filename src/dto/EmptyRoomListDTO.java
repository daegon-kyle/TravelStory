//�ۼ���¥ : 2014/7/19
//�ۼ��� : ��ȭ��

package dto;

/**
 * ���Ǹ���Ʈ ���̺� ������������ Ŭ����
 * @author ȭ��
 *
 */
public class EmptyRoomListDTO 
{
	private String roomCode;
	private String hotelName;
	private double oldPrice;
	private double discountPrice;
	private int capacity;
	private String hotelLocation;
	private String availableDate;
	
	/**
	 * �⺻������
	 */
	public EmptyRoomListDTO()
	{
		this("","",0,0,0,"","");
	}

	/**
	 * �������ڸ� �޴� ������
	 * @param roomCode �����ڵ�
	 * @param hotelName ȣ�ڸ�
	 * @param oldPrice ������
	 * @param discountPrice ���ΰ�
	 * @param capacity ��ũ��
	 * @param hotelLocation ���ھ�ü��ġ
	 * @param availableDate ��밡����
	 */
	public EmptyRoomListDTO(String roomCode, String hotelName, double oldPrice, double discountPrice, int capacity, String hotelLocation, String availableDate) 
	{
		this.roomCode = roomCode;
		this.hotelName = hotelName;
		this.oldPrice = oldPrice;
		this.discountPrice = discountPrice;
		this.capacity = capacity;
		this.hotelLocation = hotelLocation;
		this.availableDate = availableDate;
	}

	/**
	 * ���ڵ带 �����Ѵ�
	 * @return
	 */
	public String getRoomCode() {
		return roomCode;
	}

	/**
	 * ���ڵ带 �����Ѵ�
	 * @param roomCode
	 */
	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	/**
	 * ȣ�׷��� �����Ѵ�
	 * @return
	 */
	public String getHotelName() {
		return hotelName;
	}

	/**
	 * ȣ�ڸ��� �����Ѵ�
	 * @param hotelName
	 */
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	/**
	 * �������� �����Ѵ�
	 * @return
	 */
	public double getOldPrice() {
		return oldPrice;
	}
	
	/**
	 * �������� �����Ѵ�
	 * @param oldPrice
	 */
	public void setOldPrice(double oldPrice) {
		this.oldPrice = oldPrice;
	}

	/**
	 * ���ΰ��� �����Ѵ�
	 * @return
	 */
	public double getDiscountPrice() {
		return discountPrice;
	}

	/**
	 * ���ΰ��� �����Ѵ�
	 * @param discountPrice
	 */
	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}

	/**
	 * ��ũ�⸦ �����Ѵ�
	 * @return
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * ��ũ�⸦ �����Ѵ�
	 * @param capacity
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * ȣ����ġ�� �����Ѵ�
	 * @return
	 */
	public String getHotelLocation() {
		return hotelLocation;
	}

	/**
	 * ȣ����ġ�� �����Ѵ�
	 * @param hotelLocation
	 */
	public void setHotelLocation(String hotelLocation) {
		this.hotelLocation = hotelLocation;
	}

	/**
	 * ��밡������ �����Ѵ�
	 * @return
	 */
	public String getAvailableDate() {
		return availableDate;
	}

	/**
	 * ��밡������ �����Ѵ�
	 * @param availableDate
	 */
	public void setAvailableDate(String availableDate) {
		this.availableDate = availableDate;
	}
	
	

}
