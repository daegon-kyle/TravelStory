package form;

public class EmptyRoomSearchForm 
{
	private String hotelLocation;
	private String date;
	
	public EmptyRoomSearchForm()
	{
		this("","");
	}
	
	public EmptyRoomSearchForm(String hotelLocation, String date) 
	{
		this.hotelLocation = hotelLocation;
		this.date = date;
	}
	public String getHotelLocation() {
		return hotelLocation;
	}
	public void setHotelLocation(String hotelLocation) {
		this.hotelLocation = hotelLocation;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	

}
