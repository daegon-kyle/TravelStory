package model;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

/**
 * ���� ���� ���
 * <br>EmptyRoomInfoManagerServlet�� EmptyRoomReservationServet���� ����ϴ� Ŭ����
 * @author ���
 *
 */
public class EmptyRoomInfoList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2659018967379338889L;
	/**
	 * ���������� ������� ������ �������
	 */
	private List<EmptyRoomInfo> emptyRoomList;
/**
 * �λ�����
 */
	public EmptyRoomInfoList() {
		this(new ArrayList<EmptyRoomInfo>());
	}
	/**
	 * �⺻������
	 * @param emptyRoomList ���Ǹ��
	 */
	public EmptyRoomInfoList(List<EmptyRoomInfo> emptyRoomList) {
		this.emptyRoomList = emptyRoomList;
	}
	/**
	 * ����������Ϲ�ȯ
	 * @return �����������
	 */
	public List<EmptyRoomInfo> getEmptyRoomList() {
		return emptyRoomList;
	}
	/**
	 * ����������� ����
	 * @param emptyRoomList �����������
	 */
	public void setEmptyRoomList(List<EmptyRoomInfo> emptyRoomList) {
		this.emptyRoomList = emptyRoomList;
	}
/**
 * �������� �߰�
 * @param emptyRoomInfo ��������
 * @return �߰�����
 */
	public boolean addEmptyRoomInfo(EmptyRoomInfo emptyRoomInfo){
		if(emptyRoomList.add(emptyRoomInfo))
			return true;
		else
			return false;
	}
	/**
	 * �������� ����
	 * @param emptyRoomCode �����ڵ�
	 * @return ������ ��������
	 */
	public EmptyRoomInfo deleteEmptyRoomInfo(String emptyRoomCode){
		for(EmptyRoomInfo temp:emptyRoomList){
			if(temp.getEmptyRoomCode().equals(emptyRoomCode)){
				emptyRoomList.remove(temp);
				return temp;
			}
		}
		return null;
	}
	/**
	 * �������� �˻�
	 * @param emptyRoomCode ���� �ڵ�
	 * @return ��������
	 */
	private EmptyRoomInfo searchEmptyRoomInfo(String emptyRoomCode){
		for(EmptyRoomInfo temp:emptyRoomList){
			if(temp.getEmptyRoomCode().equals(emptyRoomCode)){
				return temp;
			}
		}
		return null;
	}
	/**
	 * �������� ����
	 * @param oldEmptyRoomInfo ������������
	 * @param newEmptyRoomInfo ���ο��������
	 * @return ������ ��������
	 */
	public EmptyRoomInfo reviseEmptyRoomInfo(EmptyRoomInfo oldEmptyRoomInfo, EmptyRoomInfo newEmptyRoomInfo){
		for(EmptyRoomInfo temp:emptyRoomList){
			if(temp.getEmptyRoomCode().equals(oldEmptyRoomInfo.getEmptyRoomCode())){
				int index=emptyRoomList.indexOf(temp);
				emptyRoomList.set(index, newEmptyRoomInfo);
				return temp;
			}
		}
		return null;
	}
	/**
	 * �������� ����
	 * @param emptyRoomCode �������������ڵ�
	 * @param newEmptyRoomInfo ���ο� ��������
	 * @return ������ ��������
	 */
	public EmptyRoomInfo reviseEmptyRoomInfo(String emptyRoomCode, EmptyRoomInfo newEmptyRoomInfo){
		for(EmptyRoomInfo temp:emptyRoomList){
			if(temp.getEmptyRoomCode().equals(emptyRoomCode)){
				int index=emptyRoomList.indexOf(temp);
				emptyRoomList.set(index, newEmptyRoomInfo);
				return temp;
			}
		}
		return null;
	}
}
