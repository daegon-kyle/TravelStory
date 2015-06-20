package form;

/**
 * ���ھ�ü ����� �ϱ� ���� ����ϴ� �� Ŭ����
 * 
 *
 */
public class HotelInfoForm {
	/**
	 * ȣ�ڸ�
	 */
	private String hotelName;
	/**
	 * ȣ�� ��ġ
	 */
	private String hotelLocation;
	/**
	 * ȣ�� �Ұ�
	 */
	private String hotelIntroduction;
	/**
	 * ȣ�� ���������� ���
	 */
	private String hotelReservationPagePath;
	
	/**
	 * �λ�����
	 */
	public HotelInfoForm() {
		this("","","","");
	}
	/**
	 * ������
	 * @param hotelName ȣ���̸�
	 * @param hotelLocation ȣ����ġ
	 * @param hotelIntroduction ȣ�ڼҰ�
	 * @param hotelReservationPagePath ȣ�ڿ���������
	 */
	public HotelInfoForm(String hotelName, String hotelLocation,
			String hotelIntroduction, String hotelReservationPagePath) {
		this.hotelName = hotelName;
		this.hotelLocation = hotelLocation;
		this.hotelIntroduction = hotelIntroduction;
		this.hotelReservationPagePath = hotelReservationPagePath;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelLocation() {
		return hotelLocation;
	}

	public void setHotelLocation(String hotelLocation) {
		this.hotelLocation = hotelLocation;
	}

	public String getHotelIntroduction() {
		return hotelIntroduction;
	}

	public void setHotelIntroduction(String hotelIntroduction) {
		this.hotelIntroduction = hotelIntroduction;
	}

	public String getHotelReservationPagePath() {
		return hotelReservationPagePath;
	}

	public void setHotelReservationPagePath(String hotelReservationPagePath) {
		this.hotelReservationPagePath = hotelReservationPagePath;
	}
	
	
}
