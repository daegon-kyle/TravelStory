package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * ������������ ������� ������ Ŭ����
 * @author ���
 *
 */
public class HouseOwnerEssentialInfoList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2369250238687043587L;
	/**
	 * ������ ���� ���
	 */
	private List<HouseOwnerEssentialInfo> houseOwnerEssentialInfoList;
	
	/**
	 * �λ�����
	 */
	public HouseOwnerEssentialInfoList() {
		this.houseOwnerEssentialInfoList = new ArrayList<HouseOwnerEssentialInfo>();
	}
/**
 * �⺻������
 * @param houseOwnerEssentialInfoList ������ �ʼ��������
 */
	public HouseOwnerEssentialInfoList(
			List<HouseOwnerEssentialInfo> houseOwnerEssentialInfoList) {
		this.houseOwnerEssentialInfoList = houseOwnerEssentialInfoList;
	}
/**
 * �������ʼ�������� ��ȯ
 * @return
 */
	public List<HouseOwnerEssentialInfo> getHouseOwnerEssentialInfoList() {
		return houseOwnerEssentialInfoList;
	}
	/**
	 * ������ �ʼ�������� ����
	 * @param houseOwnerEssentialInfoList �������ʼ��������
	 */
	public void setHouseOwnerEssentialInfoList(
			List<HouseOwnerEssentialInfo> houseOwnerEssentialInfoList) {
		this.houseOwnerEssentialInfoList = houseOwnerEssentialInfoList;
	}
	/**
	 * �������ʼ����� �߰�
	 * @param houseOwnerEssentialInfo �������ʼ�����
	 * @return �������ʼ�����
	 */
	public HouseOwnerEssentialInfo addHouseOwnerInfo(HouseOwnerEssentialInfo houseOwnerEssentialInfo){
		
		if(houseOwnerEssentialInfoList.add(houseOwnerEssentialInfo))
			return houseOwnerEssentialInfo;
		return null;
	}
	/**
	 * �������ʼ������� �˻�
	 * @param email �̸���
	 * @return ������ �ʼ�����
	 */
	public HouseOwnerEssentialInfo searchHouseOwnerInfo(String email){
		
		for(HouseOwnerEssentialInfo houseOwnerEssentialInfo : houseOwnerEssentialInfoList){
			if(houseOwnerEssentialInfo.getEmail().equals(email)){
				return houseOwnerEssentialInfo;
			}
		}
		return null;
	}
	/**
	 * ������ �ʼ����� ����
	 * @param email �̸���
	 * @param houseOwnerEssentialInfo �������ʼ�����
	 * @return ������ �������ʼ�����
	 */
	public HouseOwnerEssentialInfo reviseHouseOwnerInfo(String email, HouseOwnerEssentialInfo houseOwnerEssentialInfo){
		for(HouseOwnerEssentialInfo temp : houseOwnerEssentialInfoList){
			if(temp.getEmail().equals(email)){
				int index = houseOwnerEssentialInfoList.indexOf(temp);
				houseOwnerEssentialInfoList.set(index, houseOwnerEssentialInfo);
				return temp;
			}
		}
		return null;
	}
	/**
	 * ������ �ʼ����� ����
	 * @param email �̸���
	 * @return ������ �������ʼ�����
	 */
	public HouseOwnerEssentialInfo deleteHosueOwnerInfo(String email){
		HouseOwnerEssentialInfo houseOwnerEssentialInfo = searchHouseOwnerInfo(email);
		if(houseOwnerEssentialInfo != null){
			houseOwnerEssentialInfoList.remove(houseOwnerEssentialInfo);
		}
		return houseOwnerEssentialInfo;
	}
	
	
}
