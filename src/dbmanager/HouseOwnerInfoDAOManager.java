//�ۼ���¥ : 2014/7/27
//�ۼ��� : ��ȭ��

package dbmanager;
import java.util.GregorianCalendar;

import dao.HouseOwnerDAO;
import dto.HouseOwnerDTO;
import dao.VisitRequestDAO; 
import model.HouseOwnerEssentialInfo;
import converter.ConvertGregorianCalendar; 
/**
 * �����ο� ���� ������ �湮 ��û ���¸� �����ϱ� ���� Ŭ���� <br/>VisitAcceptManager, HouseOwnerInfoManager���� ����Ѵ�.
 * @author ������
 *
 */
public class HouseOwnerInfoDAOManager {
	/**
	 * �����ο� ���� ������ �����ϱ� ���� �������
	 */
	private HouseOwnerDAO houseOwnerDAO;
	/**
	 * �湮��û ���¸� �����ϱ� ���� ��� ����
	 */
	private VisitRequestDAO visitRequestDAO;
	/**
	 * ��� ������ �޴� ������
	 * @param houseOwnerDAO
	 * @param visitRequestDAO
	 */
	public HouseOwnerInfoDAOManager(HouseOwnerDAO houseOwnerDAO,
			VisitRequestDAO visitRequestDAO) {
		this.houseOwnerDAO = houseOwnerDAO;
		this.visitRequestDAO = visitRequestDAO;
	}
	/**
	 * default constructor
	 */
	public HouseOwnerInfoDAOManager() 
	{
		houseOwnerDAO=new HouseOwnerDAO();
		visitRequestDAO=new VisitRequestDAO();
	}
	/**
	 * �������� ������ �����Ѵ�. <br/> HouseOwnerInfoManager���� ����Ѵ� <br/> HouseOwnerDAO�� ����Ѵ�.
	 * @param memberCode �������� ��� �ڵ�
	 * @param houseOwnerEssentailInf �������� �ʼ�����
	 * @return true - ���� ���� <br/> false - ���� ����
	 */
	public boolean save(String memberCode, HouseOwnerEssentialInfo houseOwnerEssentialInfo)
	{
		ConvertGregorianCalendar convertCalendar=new ConvertGregorianCalendar();
		
		String job=houseOwnerEssentialInfo.getJob();
		String visitStartDate=convertCalendar.convert(houseOwnerEssentialInfo.getVisitStartDate());
		String visitEndDate=convertCalendar.convert(houseOwnerEssentialInfo.getVisitEndDate());
		String selfIntroduction=houseOwnerEssentialInfo.getSelfIntroduction();
		String marriedState=houseOwnerEssentialInfo.getMarriedState();
		String address=houseOwnerEssentialInfo.getAddress();
		String etc=houseOwnerEssentialInfo.getEtc();
		return houseOwnerDAO.insert(memberCode, job, visitStartDate, visitEndDate, selfIntroduction, marriedState, address, etc);
	}
	/**
	 * �������� ������ �����Ѵ�. <br/>HouseOwnerInfoManager���� ����Ѵ� <br/>  HouseOwnerDAO�� ����Ѵ�.
	 * @param houseOwnerCode ������ �ڵ�
	 * @return true - ���� ���� <br/> false - ���� ����
	 */
	public boolean delete(String houseOwnerCode){
		return houseOwnerDAO.deleteHouseOwnerCode(houseOwnerCode);
	}
	/**
	 * �������� ������ �����Ѵ� <br/> HouseOwnerInfoManager���� ����Ѵ� <br/> HouseOwnerDAO�� ����Ѵ�.
	 * @param houseOwnerCode ������ �ڵ�
	 * @param houseOwnerEssentialInfo ������ �������� ����
	 * @return true - ���� ���� <br/> false - ���� ����
	 */
	public boolean modify(String houseOwnerCode, HouseOwnerEssentialInfo houseOwnerEssentialInfo)
	{
		ConvertGregorianCalendar convertCalendar=new ConvertGregorianCalendar();
		
		String job=houseOwnerEssentialInfo.getJob();
		String visitStartDate=convertCalendar.convert(houseOwnerEssentialInfo.getVisitStartDate());
		String visitEndDate=convertCalendar.convert(houseOwnerEssentialInfo.getVisitEndDate());
		String selfIntroduction=houseOwnerEssentialInfo.getSelfIntroduction();
		String marriedState=houseOwnerEssentialInfo.getMarriedState();
		String address=houseOwnerEssentialInfo.getAddress();
		String etc=houseOwnerEssentialInfo.getEtc();
		
		return houseOwnerDAO.update(houseOwnerCode, job, visitStartDate, visitEndDate, selfIntroduction, marriedState, address, etc);
	}
	/**
	 * �������� �湮 ��û ���¸� �����Ѵ�. <br/>VisitAcceptManager���� ����Ѵ� <br/>VisitRequestDAO�� ��G�Ѵ�.
	 * @param houseOwnerCode ������ �ڵ�
	 * @param touristCode �湮 ��û�� �ڵ�
	 * @param requestState ����/ ���/ ����
	 * @return true - ���� ���� <br/> false - ���� ����
	 */
	public boolean modifyVisitRequestState(String houseOwnerCode, String touristCode, String requestState){
		return visitRequestDAO.update(houseOwnerCode, touristCode, requestState);
	}
	/**
	 * �����ο� ���� ������ �����´�. (��� ����)
	 * @param houseOwnerCode ������ �ڵ�
	 * @return ������ ����
	 */
	public HouseOwnerEssentialInfo getHouseOwner(String houseOwnerCode)
	{
		ConvertGregorianCalendar convertCalendar=new ConvertGregorianCalendar();
		
		HouseOwnerDTO houseOwnerDTO=houseOwnerDAO.selectHouseOwner(houseOwnerCode);
		
		String address=houseOwnerDTO.getAddress();
		GregorianCalendar visitStartDate=convertCalendar.convert(houseOwnerDTO.getVisitStartDate());
		GregorianCalendar visitEndDate=convertCalendar.convert(houseOwnerDTO.getVisitEndDate());
		String job=houseOwnerDTO.getJob();
		String marriedState=houseOwnerDTO.getMarriedState();
		String selfIntroduction=houseOwnerDTO.getSelfIntroduction();
		String etc=houseOwnerDTO.getEtc();
		
		HouseOwnerEssentialInfo houseOwnerEssentialInfo=new HouseOwnerEssentialInfo(address, visitStartDate, visitEndDate, job, marriedState, selfIntroduction, etc);
		return houseOwnerEssentialInfo;
	}
	
 
}
