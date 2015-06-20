package dbmanager;
import java.util.Calendar;
import java.util.List;

import converter.ConvertGregorianCalendar;

import dao.*;
import dto.*;
import model.*;
/**
 * 여행 객이 집주인을 검색 할 때 사용한다. <br/> VisitRequestCheckForTouristManager에서 사용한다.
 * @author 문정현
 *
 */
public class HouseOwnerDetailInfoDAOManager {
	/**
	 * 집주인 상세 정보를 가져오기 위한 멤버 변수
	 */
	private HouseOwnerDetailInfoDAO houseOwnerDetailInfoDAO;
	/**
	 * 멤벼 변수를 받는 생성자
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
	 * 조건에 맞는 집주인의 정보를 가져온다. <br/>VisitRequestCheckForTouristManager에서 사용한다 <br/> HouseOwnerDetailInfoDAO를 사용한다.
	 * @param location 지역
	 * @param visitStartDate 방문 시작일
	 * @param visitEndDate 방문 종료일
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
