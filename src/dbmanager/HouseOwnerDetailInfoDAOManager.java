package dbmanager;
import java.util.Calendar;
import java.util.List;

import converter.ConvertGregorianCalendar;

import dao.*;
import dto.*;
import model.*;
/**
 * ���� ���� �������� �˻� �� �� ����Ѵ�. <br/> VisitRequestCheckForTouristManager���� ����Ѵ�.
 * @author ������
 *
 */
public class HouseOwnerDetailInfoDAOManager {
	/**
	 * ������ �� ������ �������� ���� ��� ����
	 */
	private HouseOwnerDetailInfoDAO houseOwnerDetailInfoDAO;
	/**
	 * �⺭ ������ �޴� ������
	 * @param houseOwnerDetailInfoDAO
	 */
	public HouseOwnerDetailInfoDAOManager(HouseOwnerDetailInfoDAO houseOwnerDetailInfoDAO) {
		this.houseOwnerDetailInfoDAO = houseOwnerDetailInfoDAO;
	}
	/**
	 * default constructor
	 */
	public HouseOwnerDetailInfoDAOManager() {
		this(new HouseOwnerDetailInfoDAO());
	}
	/**
	 * ���ǿ� �´� �������� ������ �����´�. <br/>VisitRequestCheckForTouristManager���� ����Ѵ� <br/> HouseOwnerDetailInfoDAO�� ����Ѵ�.
	 * @param location ����
	 * @param visitStartDate �湮 ������
	 * @param visitEndDate �湮 ������
	 * @return
	 */
	public HouseOwnerEssentialInfoList getDetailInfos(HouseOwnerEssentialInfo houseOwnerEssentialInfo){
		HouseOwnerEssentialInfoList houseOwnerEssentialInfoList = new HouseOwnerEssentialInfoList ();
		ConvertGregorianCalendar converter = new ConvertGregorianCalendar();
		System.out.println("a"+houseOwnerEssentialInfo.getVisitStartDate().get(Calendar.MONTH));
		System.out.println("a"+houseOwnerEssentialInfo.getVisitEndDate().get(Calendar.MONTH));
		String visitStartDate= converter.convert(houseOwnerEssentialInfo.getVisitStartDate());
		String visitEndDate = converter.convert(houseOwnerEssentialInfo.getVisitEndDate());
		System.out.println("b"+visitStartDate);
		System.out.println("b"+visitEndDate);
		List<HouseOwnerDetailInfoDTO> list = houseOwnerDetailInfoDAO.selectHouseOwners(houseOwnerEssentialInfo.getAddress(), visitStartDate, visitEndDate);
		System.out.println("HouseOwnerDetailInfoDAOManager- getDetailInfos - list : "+ list);
		for(HouseOwnerDetailInfoDTO dto : list){
			System.out.println("dto houseOnwerCode :"+dto.getHouseOwnerCode());
		}
		for(HouseOwnerDetailInfoDTO h : list){
			ConvertGregorianCalendar con = new ConvertGregorianCalendar();
			houseOwnerEssentialInfoList.addHouseOwnerInfo(new HouseOwnerEssentialInfo(h.getHouseOwnerCode(),h.getAddress(), 
					con.convert(h.getVisitStartDate()), con.convert(h.getVisitEndDate()),h.getJob(),h.getMarriedState(),h.getSelfIntroduction(),
					h.getEtc(),h.getOwnerName(),h.getEmail()));
		}
		return houseOwnerEssentialInfoList;
	}
}
