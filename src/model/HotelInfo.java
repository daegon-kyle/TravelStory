package model;

public class HotelInfo implements  java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4734876240565749215L; 
	private String hotelName;
	private String hotelCode;
	private String hotelLocation;
	private String hotelIntroduction;
	private String reservationPagePath;
	
	public HotelInfo() {
		this("","","","","");
	}
	public HotelInfo(String hotelName, String hotelLocation, String hotelIntroduction, String reservationPagePath) 
	{
		this(hotelName, "", hotelLocation, hotelIntroduction, reservationPagePath);
	}
	
	public HotelInfo(String hotelName, String hotelCode, String hotelLocation, String hotelIntroduction, String reservationPagePath) {
		this.hotelName = hotelName;
		this.hotelCode = hotelCode;
		this.hotelLocation = hotelLocation;
		this.hotelIntroduction = hotelIntroduction;
		this.reservationPagePath = reservationPagePath;
	}
 
	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelCode() {
		return hotelCode;
	}

	public void setHotelCode(String hotelCode) {
		this.hotelCode = hotelCode;
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

	public String getReservationPagePath() {
		return reservationPagePath;
	}

	public void setReservationPagePath(String reservationPagePath) {
		this.reservationPagePath = reservationPagePath;
	}
	
	
}
