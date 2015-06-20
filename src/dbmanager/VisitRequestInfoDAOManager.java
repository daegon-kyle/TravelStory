package dbmanager;
import java.util.GregorianCalendar;
import java.util.List;

import converter.ConvertGregorianCalendar;

import dao.*;
import dto.*;
import model.*;
/**
 * �����ο��� ��û�� ���ఴ�� ������ �������� ���� Ŭ���� <br/>VisitAcceptManager ���� ����Ѵ�.
 * @author ������
 *
 */
public class VisitRequestInfoDAOManager {
	/**
	 * �����ο��� ��û�� �湮���� ������ �������� ���� �������
	 */
	private VisitRequestersInfoDAO requester;
	/**
	 * default constructor
	 */
	public VisitRequestInfoDAOManager(){
		this(new VisitRequestersInfoDAO());
	}
	/**
	 * �⺭ ������ �޴� ������
	 * @param requester
	 */
	public VisitRequestInfoDAOManager(VisitRequestersInfoDAO requester) {
		this.requester = requester;
	}
	/**
	 * Ư�� �����ο��� �湮�� ��û�� ���ఴ�� ������ �����´�. <br/>VisitAcceptManager���� ����Ѵ�. <br/> VisitRequestInfoDAO�� ����Ѵ�.
	 * @param houseOwnerCode ������ �ڵ�
	 * @return ��û ���ఴ�� �� ����
	 */
	public VisitRequestInfoForOwnerList getRequesterInfos(String houseOwnerCode){
		VisitRequestInfoForOwnerList visitRequestInfoForOwnerList = new VisitRequestInfoForOwnerList();
		ConvertGregorianCalendar converter = new ConvertGregorianCalendar();
		for(VisitRequestersInfoDTO dto : requester.selectTouristInfos(houseOwnerCode)){
			GregorianCalendar arrivalDate = converter.convert(dto.getTouristArrivalDate());
			GregorianCalendar departureDate = converter.convert(dto.getTouristDepartureDate());			
			TouristEssentialInfo touristEssentialInfo = new TouristEssentialInfo(dto.getTouristCode(),dto.getTouristSelfIntroduction(),arrivalDate,
					departureDate, dto.getTouristCompanionNum(), dto.getTouristJob(),
					dto.getTouristName(), dto.getTouristEmail(), "");
			VisitRequestInfoForOwner visitRequestInfoForOwner = new VisitRequestInfoForOwner(touristEssentialInfo,dto.getRequestState());
			visitRequestInfoForOwnerList.addVisitRequestInfoForOwner(visitRequestInfoForOwner);
		}
		return visitRequestInfoForOwnerList;
	}
	
	public VisitRequestInfoForTouristList getHouseOwnerInfos(String memberCode){
		
		VisitRequestInfoForTouristList visitRequestInfoForTouristList = new VisitRequestInfoForTouristList(); 
		ConvertGregorianCalendar converter = new ConvertGregorianCalendar();
		CheckRequestStateDAO checkRequestStateDAO = new CheckRequestStateDAO();
		for(CheckRequestStateDTO dto :checkRequestStateDAO.selectRequestStates(memberCode)){
			GregorianCalendar visitStartDate = converter.convert(dto.getHouseOwnerVisitStartDate());
			GregorianCalendar visitEndDate = converter.convert(dto.getHouseOwnerVisitEndDate());
			
			HouseOwnerEssentialInfo houseOwnerEssentialInfo = new HouseOwnerEssentialInfo(dto.getHouseOwnerCode(), dto.getHouseOwnerAddress(),
					visitStartDate, visitEndDate, dto.getHouseOwnerJob(), dto.getHouseOwnerMarriedState(),dto.getHouseOwnerSelfIntroduction(),
					dto.getHouseOwnerEtc(), dto.getHouseOwnerName(), dto.getHouseOwnerEmail());
			
			VisitRequestInfoForTourist visitRequestInfoForTourist = new VisitRequestInfoForTourist(houseOwnerEssentialInfo,dto.getRequestState());
			visitRequestInfoForTouristList.addVisitRequestInfoForTourist(visitRequestInfoForTourist);
		}
		return visitRequestInfoForTouristList;
	}

}
