//�ۼ���¥ : 2014/7/19
//�ۼ��� : ��ȭ��

package dto;

/**
 * �������� ���̺� ������ ������ Ŭ����
 * @author ȭ��
 *
 */
public class EmptyRoomDetailInfoDTO 
{
	private String roomCode;
	private String hotelName;
	private String roomName;
	private String availableDate;
	private String hotelLocation;
	private double oldPrice;
	private double discountPrice;
	private String checkInTime;
	private String checkOutTime;
	private int roomSpace;
	private int roomCapacity;
	private String hotelFacilityList;
	private String roomEtc;
	private String hotelPagePath;
	private String hotelIntroduction;
	
	/**
	 * �⺻������
	 */
	public EmptyRoomDetailInfoDTO()
	{
		this("","","","","",0,0,"","",0,0,"","","","");
	}
	
	/**
	 * �������ڸ� �޴� ������
	 * @param roomCode ���ڵ�
	 * @param hotelName ȣ�ڸ�
	 * @param roomName ���Ǹ�
	 * @param availableDate �̿밡����
	 * @param hotelLocation ȣ����ġ
	 * @param oldPrice ��������
	 * @param discountPrice ���ΰ�
	 * @param checkInTime üũ�νð�
	 * @param checkOutTime üũ�ƿ��ð�
	 * @param roomSpace �����
	 * @param roomCapacity �����ο�
	 * @param hotelFacilityList �ֺ��ü�
	 * @param roomEtc ���ǼҰ�
	 * @param hotelPagePath Ȩ������ �ּ�
	 * @param hotelIntroduction ȣ�ڼҰ�
	 */
	public EmptyRoomDetailInfoDTO(String roomCode, String hotelName, String roomName, String availableDate, String hotelLocation, double oldPrice, double discountPrice, String checkInTime, String checkOutTime, int roomSpace, int roomCapacity, String hotelFacilityList, String roomEtc, String hotelPagePath, String hotelIntroduction) 
	{ 
		this.roomCode = roomCode;
		this.hotelName = hotelName;
		this.roomName = roomName;
		this.availableDate = availableDate;
		this.hotelLocation = hotelLocation;
		this.oldPrice = oldPrice;
		this.discountPrice = discountPrice;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.roomSpace = roomSpace;
		this.roomCapacity = roomCapacity;
		this.hotelFacilityList = hotelFacilityList;
		this.roomEtc = roomEtc;
		this.hotelPagePath = hotelPagePath;
		this.hotelIntroduction=hotelIntroduction;
	}
	
	/**
	 * �����ڵ带 �����Ѵ�
	 * @return
	 */
	public String getRoomCode() {
		return roomCode;
	}
	/**
	 * �����ڵ带 �����Ѵ�
	 * @param roomCode
	 */
	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}
	/**
	 * ȣ���̸��� �����Ѵ�
	 * @return
	 */
	public String getHotelName() {
		return hotelName;
	}
	/**
	 * ȣ���̸��� �����Ѵ�
	 */
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	/**
	 * �����̸��� �����Ѵ�
	 * @return
	 */
	public String getRoomName() {
		return roomName;
	}
	/**
	 * �����̸��� �����Ѵ�
	 * @param roomName
	 */
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	/**
	 * �̿밡�ɳ�¥�� �����Ѵ�
	 * @return
	 */
	public String getAvailableDate() {
		return availableDate;
	}
	/**
	 * �̿밡�ɳ�¥�� �����Ѵ�
	 * @param availableDate
	 */
	public void setAvailableDate(String availableDate) {
		this.availableDate = availableDate;
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
	 * ���������� �����Ѵ�
	 * @return
	 */
	public double getOldPrice() {
		return oldPrice;
	}
	/**
	 * ���������� �����Ѵ�
	 * @param oldPrice
	 */
	public void setOldPrice(double oldPrice) {
		this.oldPrice = oldPrice;
	}
	/**
	 * ���ΰ����� �����Ѵ�
	 * @return
	 */
	public double getDiscountPrice() {
		return discountPrice;
	}
	/**
	 * ���ΰ����� �����Ѵ�
	 */
	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}
	/**
	 * üũ�νð��� �����Ѵ�
	 * @return
	 */
	public String getCheckInTime() {
		return checkInTime;
	}
	/**
	 * üũ�νð��� �����Ѵ�
	 * @param checkInTime
	 */
	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}
	/**
	 * üũ�ƿ��ð��� �����Ѵ�
	 * @return
	 */
	public String getCheckOutTime() {
		return checkOutTime;
	}
	/**
	 * üũ�ƿ��ð��� �����Ѵ�
	 * @param checkOutTime
	 */
	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
	}
	/**
	 * ��ũ�⸦ �����Ѵ�
	 * @return
	 */
	public int getRoomSpace() {
		return roomSpace;
	}
	/**
	 * �洔�⸦ �����Ѵ�
	 * @param roomSpace
	 */
	public void setRoomSpace(int roomSpace) {
		this.roomSpace = roomSpace;
	}
	/**
	 * ������ο��� �����Ѵ�
	 * @return
	 */
	public int getRoomCapacity() {
		return roomCapacity;
	}
	/**
	 * ������ο��� �����Ѵ�
	 * @param roomCapacity
	 */
	public void setRoomCapacity(int roomCapacity) {
		this.roomCapacity = roomCapacity;
	}
	/**
	 * �ֺ��ü��� �����Ѵ�
	 * @return
	 */
	public String getHotelFacilityList() {
		return hotelFacilityList;
	}
	/**
	 * �ֺ��ü��� �����Ѵ�
	 * @param hotelFacilityList
	 */
	public void setHotelFacilityList(String hotelFacilityList) {
		this.hotelFacilityList = hotelFacilityList;
	}
	/**
	 * ���ǼҰ��� �����Ѵ�
	 * @return
	 */
	public String getRoomEtc() {
		return roomEtc;
	}
	/**
	 * ���ǼҰ��� �����Ѵ�
	 * @param roomEtc
	 */
	public void setRoomEtc(String roomEtc) {
		this.roomEtc = roomEtc;
	}
	/**
	 * ȣ��Ȩ�������ּҸ� �����Ѵ�
	 * @return
	 */
	public String getHotelPagePath() {
		return hotelPagePath;
	}
	/**
	 * ȣ���ּҸ� �����Ѵ�
	 * @param hotelPagePath
	 */
	public void setHotelPagePath(String hotelPagePath) {
		this.hotelPagePath = hotelPagePath;
	}
	/**
	 * ȣ�ڼҰ��� �����Ѵ�
	 * @return
	 */
	public String getHotelIntroduction()
	{
		return hotelIntroduction;
	}
	
	/**
	 * ȣ�ڼҰ��� �����Ѵ�
	 * @param hotelIntroduction ȣ�ڼҰ�
	 */
	public void setHotelIntroduction(String hotelIntroduction)
	{
		this.hotelIntroduction=hotelIntroduction;
	}
}
