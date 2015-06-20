package form;
/**
 * 
 * ���ھ�ü�� �������� ������ ����ϱ� ���� Ŭ����
 *
 */
public class EmptyRoomInfoForm {
	/**
	 * ����������
	 */
	private String emptyRoomName;
	/**
	 * ���� �� ����
	 */
	private String oldPrice;
	/**
	 * ���ΰ���
	 */
	private String discountPrice;
	/**
	 * ���
	 */
	private String space;
	/**
	 * üũ�� �ð�
	 */
	private String checkInTime;
	/**
	 * üũ�ƿ��ð�
	 */
	private String checkOutTime;
	/**
	 * �����ο�
	 */
	private String capacity;
	/**
	 * �̿밡�ɽü����
	 */
	private String facilityList;
	
	/**
	 * ��Ÿ ����
	 */
	private String etc;
	
	/**
	 * �� ������
	 */
	public EmptyRoomInfoForm() {
		this("","","","","","","","","");
	}

	/**
	 * ������
	 * @param emptyRoomName ���������̸�
	 * @param oldPrice ������ ����
	 * @param discountPrice ���ΰ���
	 * @param space ���
	 * @param checkInTime üũ�� �ð�
	 * @param checkOutTime üũ�ƿ� �ð�
	 * @param facility1 �̿밡�ɽü�1
	 * @param facility2 �̿밡�ɽü�2
	 * @param facility3 �̿밡�ɽü�3
	 * @param etc ��Ÿ
	 */
	public EmptyRoomInfoForm(String emptyRoomName, String oldPrice,
			String discountPrice, String space, String checkInTime,
			String checkOutTime,String capacity, String facilityList, String etc) {
		this.emptyRoomName = emptyRoomName;
		this.oldPrice = oldPrice;
		this.discountPrice = discountPrice;
		this.space = space;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.capacity = capacity;
		this.facilityList = facilityList;
		this.etc = etc;
	}


	public String getEmptyRoomName() {
		return emptyRoomName;
	}


	public void setEmptyRoomName(String emptyRoomName) {
		this.emptyRoomName = emptyRoomName;
	}


	public String getOldPrice() {
		return oldPrice;
	}


	public void setOldPrice(String oldPrice) {
		this.oldPrice = oldPrice;
	}


	public String getDiscountPrice() {
		return discountPrice;
	}


	public void setDiscountPrice(String discountPrice) {
		this.discountPrice = discountPrice;
	}


	public String getSpace() {
		return space;
	}


	public void setSpace(String space) {
		this.space = space;
	}


	public String getCheckInTime() {
		return checkInTime;
	}


	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}


	public String getCheckOutTime() {
		return checkOutTime;
	}


	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
	}



	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getFacilityList() {
		return facilityList;
	}

	public void setFacilityList(String facilityList) {
		this.facilityList = facilityList;
	}

	public String getEtc() {
		return etc;
	}


	public void setEtc(String etc) {
		this.etc = etc;
	}
	
	
}
