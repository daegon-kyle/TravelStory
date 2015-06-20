package dbmanager;

import java.util.List;

import converter.ConvertGregorianCalendar;

import model.TouristEssentialInfo;
import dao.TouristDAO;
import dao.VisitRequestDAO;

/**
 * application ���� �Ŵ����� VisitRequestForTouristManager�� ���ǿ������� ���� ��û�� ������ ó���Ͽ� �����Ѵ�  
 * @author ȭ��
 *
 */
public class TouristVisitRequestToOwnerDAOManager 
{
	private TouristDAO touristDAO;
	private VisitRequestDAO visitRequestDAO;
	
	/**
	 * ���ఴ ���̺� ������ �湮��û ���̺� ������ �ν��Ͻ�ȭ�Ѵ�
	 */
	public TouristVisitRequestToOwnerDAOManager()
	{
		touristDAO=new TouristDAO();
		visitRequestDAO=new VisitRequestDAO();
	}
	
	/**
	 * �湮�������� �湮��û���� ������ VisitRequestDAO�� TouristDAO�� ��û�ϰ� application ���� �Ŵ����� VisitRequestForTouristManager�� ó������� �����Ѵ�
	 * @param touristMemberCode ���ఴ�ڵ�
	 * @param houseOwnerCode �������ڵ�
	 * @param touristEssentialInfo �����ʼ�����
	 * @return ���� ���
	 */
	public boolean save(String touristMemberCode, String houseOwnerCode, TouristEssentialInfo touristEssentialInfo)
	{
		ConvertGregorianCalendar converter = new ConvertGregorianCalendar();
		String arrivalDate = converter.convert(touristEssentialInfo.getArrivalDate());
		String departureDate = converter.convert(touristEssentialInfo.getDepartureDate());
		boolean touristInsertResult = touristDAO.insert(touristMemberCode, touristEssentialInfo.getJob(), touristEssentialInfo.getCompanionNum(), arrivalDate,
				departureDate, touristEssentialInfo.getSelfIntroduction());
		String touristCode = touristDAO.getTouristMaxCode();
		System.out.println("!!!!!"+houseOwnerCode);
		boolean visitRequestInsertResult = visitRequestDAO.insert(houseOwnerCode, touristCode, "���");
		if(touristInsertResult && visitRequestInsertResult){
			return true;
		}
		return false;
	}
	
	/**
	 * ���ఴ�ڵ忡 �ش��ϴ� ���������� �湮��û ���� ������ VisitRequestDAO�� TouristDAO�� ��û�ϰ� application ���� �Ŵ����� VisitRequestForTouristManager�� ó������� �����Ѵ�
	 * @param touristCode ���ఴ�ڵ�
	 * @return �������
	 */
	public boolean deleteInfo(String touristCode)
	{
		return true;
	}
	
	/**
	 * ȸ���ڵ忡 �ش��ϴ� ���������� �湮��û ���� ������  VisitRequestDAO�� TouristDAO�� ��û�ϰ� application ���� �Ŵ����� VisitRequestForTouristManager�� ó������� �����Ѵ�
	 * @param memberCode ȸ���ڵ�
	 * @return �������
	 */
	public boolean deleteInfos(String memberCode)
	{
		return true;
	}
	
	/**
	 * �������ڵ忡 �ش��ϴ� ���������� �湮��û���� ������  VisitRequestDAO�� TouristDAO�� ��û�ϰ� application ���� �Ŵ����� VisitRequestForTouristManager�� ó������� �����Ѵ�
	 * @param houseOwnerCode �������ڵ�
	 * @return �������
	 */
	public boolean deleteVisitRequest(String houseOwnerCode)
	{
		return true;
	}
	
	/**
	 * ȸ���ڵ忡 �ش��ϴ� ���ఴ������ �湮��û ���� ������  VisitRequestDAO�� TouristDAO�� ��û�ϰ� application ���� �Ŵ����� VisitRequestForTouristManager�� ó������� �����Ѵ�
	 * @param memberCode ȸ���ڵ�
	 * @return �������
	 */
	public boolean deleteVisitRequests(String memberCode)
	{
		return true;
	}
	
	/**
	 * ȸ���ڵ忡 �ش��ϴ� ���ఴ�ڵ����  VisitRequestDAO�� TouristDAO�� ��û�ϰ� application ���� �Ŵ����� VisitRequestForTouristManager�� ó������� �����Ѵ�
	 * @param memberCode ȸ���ڵ�
	 * @return ȸ���ڵ忡 �ش��ϴ� ���ఴ�ڵ�
	 */
	public List<String> getTouristCode(String memberCode) //���ľߵ� ����Ÿ�� VO��(����Ʈ��)
	{
		return null;
	}
	
	/**
	 * �������ڵ�� ���ఴ�ڵ忡 ��ġ�ϴ� �湮��û�ڵ� �˻���  VisitRequestDAO�� TouristDAO�� ��û�ϰ� application ���� �Ŵ����� VisitRequestForTouristManager�� ó������� �����Ѵ�
	 * @param hosueOwnerCode �������ڵ�
	 * @param touristCode ���ఴ�ڵ�
	 * @return �������ڵ�� ���ఴ�ڵ忡 ��ġ�ϴ� �湮��û�ڵ� 
	 */
	public List<String> getVisitRequestCode(String hosueOwnerCode, String touristCode)//���ľߵ� ����Ÿ�� VO��(����Ʈ��)
	{
		return null;
	}
	
	/**
	 * ���ఴ �ڵ忡 �ش��ϴ� ���ఴ����  ������  VisitRequestDAO�� TouristDAO�� ��û�ϰ� application ���� �Ŵ����� VisitRequestForTouristManager�� ó������� �����Ѵ�
	 * @param touristCode
	 * @param touristEssentialInfo
	 * @return ������������
	 */
	public boolean modify(String touristCode, TouristEssentialInfo touristEssentialInfo)
	{
		return true;
	}
	
	/**
	 *  �������ǰ� ���ఴ �ڵ忡 �ش��ϴ� ����������� ������  VisitRequestDAO�� TouristDAO�� ��û�ϰ� application ���� �Ŵ����� VisitRequestForTouristManager�� ó������� �����Ѵ�
	 * @param houseOwnerCode �������ڵ�
	 * @param touristCode ���ఴ�ڵ�
	 * @param state �������
	 * @return ������������
	 */
	public boolean modifyVisitRequestState(String houseOwnerCode, String touristCode, String state)
	{
		return true;
	}
}
