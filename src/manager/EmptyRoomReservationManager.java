package manager;

import java.util.GregorianCalendar;
import dbmanager.EmptyRoomDetailInfoDAOManager;
import converter.ConvertGregorianCalendar;
import dbmanager.EmptyRoomListDAOManager;
import model.EmptyRoomListInfo;
import model.EmptyRoomListInfoList;
import model.EmptyRoomDetailInfo;
/**
 * ����ڰ� ���������� �����ϱ� ���� ����ϴ� �Ŵ���
 * @author ȭ��
 *
 */
public class EmptyRoomReservationManager {
	
	private EmptyRoomListInfo emptyRoomListInfo;
	private EmptyRoomDetailInfo emptyRoomDetailInfo;
	
	public EmptyRoomReservationManager()
	{
		this(new EmptyRoomListInfo(), new EmptyRoomDetailInfo());
	}
	
	public EmptyRoomReservationManager(EmptyRoomListInfo emptyRoomListInfo,
			EmptyRoomDetailInfo emptyRoomDetailInfo) 
	{
		this.emptyRoomListInfo = emptyRoomListInfo;
		this.emptyRoomDetailInfo = emptyRoomDetailInfo;
	}
	
	public EmptyRoomListInfo getEmptyRoomListInfo() {
		return emptyRoomListInfo;
	}
	public void setEmptyRoomListInfo(EmptyRoomListInfo emptyRoomListInfo) {
		this.emptyRoomListInfo = emptyRoomListInfo;
	}
	public EmptyRoomDetailInfo getEmptyRoomDetailInfo() {
		return emptyRoomDetailInfo;
	}
	public void setEmptyRoomDetailInfo(EmptyRoomDetailInfo emptyRoomDetailInfo) {
		this.emptyRoomDetailInfo = emptyRoomDetailInfo;
	}
	
	public EmptyRoomListInfoList search(String hotelLocation, GregorianCalendar date)
	{
		EmptyRoomListDAOManager emptyRoomListDAOManager=new EmptyRoomListDAOManager();
		ConvertGregorianCalendar convertGregorianCalendar=new ConvertGregorianCalendar();
		return emptyRoomListDAOManager.getEmptyRoomInfo(hotelLocation, convertGregorianCalendar.convert(date));
	}
	
	public EmptyRoomDetailInfo getEmptyRoomDetail(String emptyRoomCode)
	{
		EmptyRoomDetailInfoDAOManager emptyRoomDetailInfoDAOManager=new EmptyRoomDetailInfoDAOManager();
		
		return emptyRoomDetailInfoDAOManager.getEmptyDetailInfo(emptyRoomCode);
	}
	 
	
}
