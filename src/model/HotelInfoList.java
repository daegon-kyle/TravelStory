package model;

import java.util.List;
import java.util.ArrayList;

public class HotelInfoList implements  java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5942481365284455289L;
	private List<HotelInfo> hotelList;

	public HotelInfoList() {
		this(new ArrayList<HotelInfo>());
	}
	public HotelInfoList(List<HotelInfo> hotelList) {
		super();
		this.hotelList = hotelList;
	}
	
	public List<HotelInfo> getHotelList() {
		return hotelList;
	}
	public void setHotelList(List<HotelInfo> hotelList) {
		this.hotelList = hotelList;
	}
	
	public boolean addHotelInfo(HotelInfo hotelInfo){
		if(hotelList.add(hotelInfo))
			return true;
		else
			return false;
	}
	public HotelInfo reviseHotelInfo(String hotelCode, HotelInfo newHotelInfo){
		for(HotelInfo temp:hotelList){
			if(temp.getHotelCode().equals(hotelCode)){
				int index=hotelList.indexOf(temp);
				hotelList.set(index, newHotelInfo);
				return newHotelInfo;
			}
		}
		return null;
	}
	public HotelInfo deleteHotelInfo(String hotelCode){
		for(HotelInfo temp:hotelList){
			if(temp.getHotelCode().equals(hotelCode)){
				hotelList.remove(hotelCode);
				return temp;
			}
		}
		return null;
	}
}
