//�ۼ���¥ : 2014/7/27
//�ۼ��� : ��ȭ��

package manager;

import model.HouseOwnerEssentialInfo;
import dbmanager.HouseOwnerInfoDAOManager;
/**
 * ������������ �����ϱ� ���� Ŭ����
 * @author ���
 *
 */
public class HouseOwnerInfoManager {
	/**
	 * ������ �ʼ��Է»��� ����
	 */
	private HouseOwnerEssentialInfo houseOwnerEssentialInfo;
	/**
	 * �λ�����
	 */
	public HouseOwnerInfoManager() {
		this(new HouseOwnerEssentialInfo());
	}
/**
 * �⺻������
 * @param houseOwnerEssentialInfo ������ �ʼ��Է»�������
 */
	public HouseOwnerInfoManager(HouseOwnerEssentialInfo houseOwnerEssentialInfo) {
		this.houseOwnerEssentialInfo = houseOwnerEssentialInfo;
	}
/**
 * ���������� ��ȯ
 * @return ���������� ��ȯ
 */
	public HouseOwnerEssentialInfo getHouseOwnerEssentialInfo() {
		return houseOwnerEssentialInfo;
	}
/**
 * ���������� ����
 * @param houseOwnerEssentialInfo ����������
 */
	public void setHouseOwnerEssentialInfo(
			HouseOwnerEssentialInfo houseOwnerEssentialInfo) {
		this.houseOwnerEssentialInfo = houseOwnerEssentialInfo;
	}
	/**
	 * HouseOwnerInfoDAOManager�� save�޼ҵ带 ���� DB�� ����
	 * @param memberCode ȸ���ڵ�
	 * @return �߰��� ����������
	 */
	public boolean addHouseOwnerInfo(String memberCode)
	{
		HouseOwnerInfoDAOManager houseOwnerInfoDAOManager=new HouseOwnerInfoDAOManager();
		return houseOwnerInfoDAOManager.save(memberCode, houseOwnerEssentialInfo);
	}
	/**
	 *  HouseOwnerInfoDAOManager�� modify�޼ҵ带 ���� DB�� ����
	 * @param houseOwnerCode ������ �ڵ�
	 * @return
	 */
	public boolean modifyHouseOwnerInfo(String houseOwnerCode)
	{
		HouseOwnerInfoDAOManager houseOwnerInfoDAOManager=new HouseOwnerInfoDAOManager();
		return houseOwnerInfoDAOManager.modify(houseOwnerCode, houseOwnerEssentialInfo);
	}
	/**
	 *  HouseOwnerInfoDAOManager�� delete�޼ҵ带 ���� DB�� ����
	 * @param houseOwnerCode �������ڵ�
	 * @return ���� ��������
	 */
	public boolean deleteHouseOwnerInfo(String houseOwnerCode)
	{
		HouseOwnerInfoDAOManager houseOwnerInfoDAOManager=new HouseOwnerInfoDAOManager();
		return houseOwnerInfoDAOManager.delete(houseOwnerCode);
	}
	
	public HouseOwnerEssentialInfo getHouseOwnerInfo(String houseOwnerCode) 
	{
		HouseOwnerInfoDAOManager houseOwnerInfoDAOManager=new HouseOwnerInfoDAOManager();
		return houseOwnerInfoDAOManager.getHouseOwner(houseOwnerCode);
	}
}
