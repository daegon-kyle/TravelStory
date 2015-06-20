package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * ȣ�ڸ���� �����ֱ� ���� ������� EmptyRoomListInfo�� ĸ��ȭ�� ��� Ŭ����
 *  <br>EmptyRoomInfoManagerServlet, EmptyRoomReservationServlet���� ����ϴ� Ŭ����
 */
public class EmptyRoomListInfoList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1522093948730549752L;
	/**
	 * ��������������� �����ֱ� ���� ���
	 */
	private List<EmptyRoomListInfo> emptyRoomListInfoList;
	
	/**
	 * �λ�����
	 */
	public EmptyRoomListInfoList() {
		this(new ArrayList<EmptyRoomListInfo>());
	}
/**
 * �⺻������
 * @param emptyRoomListInfoList ���Ǹ�������Ǹ��
 */
	public EmptyRoomListInfoList(List<EmptyRoomListInfo> emptyRoomListInfoList) {
		this.emptyRoomListInfoList = emptyRoomListInfoList;
	}
/**
 * ���Ǹ�������� ����� ��ȯ
 * @return ���Ǹ���������
 */
	public List<EmptyRoomListInfo> getEmptyRoomListInfoList() {
		return emptyRoomListInfoList;
	}
/**
 * ���Ǹ�������� ��� ����
 * @param emptyRoomListInfoList ���Ǹ������
 */
	public void setEmptyRoomListInfoList(
			List<EmptyRoomListInfo> emptyRoomListInfoList) {
		this.emptyRoomListInfoList = emptyRoomListInfoList;
	}
	/**
	 * ���Ǹ�������� ��Ͽ� ���Ǹ������ �߰��ϱ� ���� Ŭ����
	 * @param emptyRoomListInfo �߰��Ϸ��� ���Ǹ������
	 * @return �߰��� ���Ǹ������
	 */
	public boolean addEmptyRoomListInfo(EmptyRoomListInfo emptyRoomListInfo)
	{
		return emptyRoomListInfoList.add(emptyRoomListInfo);
	}
}
