package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * ���ǻ�������� <br>EmptyRoomInfoManagerServlet���� ����ϴ� Ŭ����
 * @author ���
 *
 */
public class EmptyRoomDetailInfoList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8461667874572393113L;
	/**
	 * ���ǻ��������
	 */
	private List<EmptyRoomDetailInfo> emptyRoomDetailInfoList;
/**
 * �� ������
 */
	public EmptyRoomDetailInfoList() {
		this(new ArrayList<EmptyRoomDetailInfo>());
	}
/**
 * �⺻������
 * @param emptyRoomDetailInfoList ���ǻ��������
 */
	public EmptyRoomDetailInfoList(
			List<EmptyRoomDetailInfo> emptyRoomDetailInfoList) {
		this.emptyRoomDetailInfoList = emptyRoomDetailInfoList;
	}
/**
 * ���̻�������� ��ȯ
 * @return ���̻��������
 */
	public List<EmptyRoomDetailInfo> getEmptyRoomDetailInfoList() {
		return emptyRoomDetailInfoList;
	}
/**
 * ���ǻ�������� ����
 * @param emptyRoomDetailInfoList ���ǻ��������
 */
	public void setEmptyRoomDetailInfoList(
			List<EmptyRoomDetailInfo> emptyRoomDetailInfoList) {
		this.emptyRoomDetailInfoList = emptyRoomDetailInfoList;
	}
	/**
	 * ���ǻ����� �߰�
	 * @param emptyRoomDetailInfo ���ǻ�����
	 * @return �߰�����
	 */
	public boolean addEmptyRoomDetailInfo(EmptyRoomDetailInfo emptyRoomDetailInfo){
		if(emptyRoomDetailInfoList.add(emptyRoomDetailInfo)){
			return true;
		}
		return false;
	}
	/**
	 * ���ǻ����� ����
	 * @param emptyRoomDetialInfoCode ���ǻ������ڵ�
	 * @return ��������
	 */
	public boolean deleteEmptyRoomDetailInfo(String emptyRoomDetialInfoCode){
		for(EmptyRoomDetailInfo emptyRoomDetailInfo : emptyRoomDetailInfoList){
			if(emptyRoomDetailInfo.getEmptyRoomCode().equals(emptyRoomDetialInfoCode)){
				emptyRoomDetailInfoList.remove(emptyRoomDetailInfo);
				return true;
			}
		}
		return false;
	}
	/**
	 * ���ǻ����� �˻�
	 * @param emptyRoomDetialInfoCode ���ǻ������ڵ�
	 * @return ���ǻ�����
	 */
	public EmptyRoomDetailInfo searchEmptyRoomDetailInfo(String emptyRoomDetialInfoCode){
		for(EmptyRoomDetailInfo emptyRoomDetailInfo : emptyRoomDetailInfoList){
			if(emptyRoomDetailInfo.getEmptyRoomCode().equals(emptyRoomDetialInfoCode))
				return emptyRoomDetailInfo;
		}
		return null;
	}
	/**
	 * ���ǻ����� ����
	 * @param emptyRoomDetailInfoCode ���ǻ������ڵ�
	 * @param emptyRoomDetialInfo ���ǻ�����
	 * @return ��������
	 */
	public boolean reviseEmptyRoomDetailInfo(String emptyRoomDetailInfoCode, EmptyRoomDetailInfo emptyRoomDetialInfo){
		for(EmptyRoomDetailInfo temp : emptyRoomDetailInfoList){
			if(temp.getEmptyRoomCode().equals(emptyRoomDetialInfo.getEmptyRoomCode())){
				int index = emptyRoomDetailInfoList.indexOf(temp);
				emptyRoomDetailInfoList.set(index, emptyRoomDetialInfo);
				return true;
			}
		}
		return false;
	}
	
}
