package dbmanager;
import java.util.GregorianCalendar;
import java.util.List;

import converter.ConvertGregorianCalendar;

import dao.*;
import dto.*;
import model.*;
/**
 * 집주인에게 신청한 여행객의 정보를 가져오기 위한 클래스 <br/>VisitAcceptManager 에서 사용한다.
 * @author 문정현
 *
 */
public class VisitRequestInfoDAOManager {
	/**
	 * 집주인에게 요청한 방문객의 정보를 가져오기 위한 멤버변수
	 */
	private VisitRequestersInfoDAO requester;
	/**
	 * default constructor
	 */
	public VisitRequestInfoDAOManager(){
		this(new VisitRequestersInfoDAO());
	}
	/**
	 * 멤벼 변수를 받는 생성자
	 * @param requester
	 */
	public VisitRequestInfoDAOManager(VisitRequestersInfoDAO requester) {
		this.requester = requester;
	}
	/**
	 * 특정 집주인에게 방문을 신청한 여행객의 정보를 가져온다. <br/>VisitAcceptManager에서 사용한다. <br/> VisitRequestInfoDAO를 사용한다.
	 * @param houseOwnerCode 집주인 코드
	 * @return 신청 여행객의 상세 정보
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
