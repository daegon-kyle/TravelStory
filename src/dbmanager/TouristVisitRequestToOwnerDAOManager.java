package dbmanager;

import java.util.List;

import converter.ConvertGregorianCalendar;

import model.TouristEssentialInfo;
import dao.TouristDAO;
import dao.VisitRequestDAO;

/**
 * application 계층 매니저인 VisitRequestForTouristManager가 공실예약정보 관리 요청한 사항을 처리하여 전달한다  
 * @author 화섭
 *
 */
public class TouristVisitRequestToOwnerDAOManager 
{
	private TouristDAO touristDAO;
	private VisitRequestDAO visitRequestDAO;
	
	/**
	 * 여행객 테이블 정보와 방문요청 테이블 정보를 인스턴스화한다
	 */
	public TouristVisitRequestToOwnerDAOManager()
	{
		touristDAO=new TouristDAO();
		visitRequestDAO=new VisitRequestDAO();
	}
	
	/**
	 * 방문자정보와 방문신청정보 저장을 VisitRequestDAO와 TouristDAO에 요청하고 application 계층 매니저인 VisitRequestForTouristManager에 처리결과를 전달한다
	 * @param touristMemberCode 여행객코드
	 * @param houseOwnerCode 집주인코드
	 * @param touristEssentialInfo 여행필수정보
	 * @return 저장 결과
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
		boolean visitRequestInsertResult = visitRequestDAO.insert(houseOwnerCode, touristCode, "대기");
		if(touristInsertResult && visitRequestInsertResult){
			return true;
		}
		return false;
	}
	
	/**
	 * 여행객코드에 해당하는 여행정보와 방문요청 정보 삭제를 VisitRequestDAO와 TouristDAO에 요청하고 application 계층 매니저인 VisitRequestForTouristManager에 처리결과를 전달한다
	 * @param touristCode 여행객코드
	 * @return 삭제결과
	 */
	public boolean deleteInfo(String touristCode)
	{
		return true;
	}
	
	/**
	 * 회원코드에 해당하는 여행정보와 방문요청 정보 삭제를  VisitRequestDAO와 TouristDAO에 요청하고 application 계층 매니저인 VisitRequestForTouristManager에 처리결과를 전달한다
	 * @param memberCode 회원코드
	 * @return 삭제결과
	 */
	public boolean deleteInfos(String memberCode)
	{
		return true;
	}
	
	/**
	 * 집주인코드에 해당하는 여행정보와 방문요청정보 삭제를  VisitRequestDAO와 TouristDAO에 요청하고 application 계층 매니저인 VisitRequestForTouristManager에 처리결과를 전달한다
	 * @param houseOwnerCode 집주인코드
	 * @return 삭제결과
	 */
	public boolean deleteVisitRequest(String houseOwnerCode)
	{
		return true;
	}
	
	/**
	 * 회원코드에 해당하는 여행객정보와 방문요청 정보 삭제를  VisitRequestDAO와 TouristDAO에 요청하고 application 계층 매니저인 VisitRequestForTouristManager에 처리결과를 전달한다
	 * @param memberCode 회원코드
	 * @return 삭제결과
	 */
	public boolean deleteVisitRequests(String memberCode)
	{
		return true;
	}
	
	/**
	 * 회원코드에 해당하는 여행객코드들을  VisitRequestDAO와 TouristDAO에 요청하고 application 계층 매니저인 VisitRequestForTouristManager에 처리결과를 전달한다
	 * @param memberCode 회원코드
	 * @return 회원코드에 해당하는 여행객코드
	 */
	public List<String> getTouristCode(String memberCode) //고쳐야됨 리턴타입 VO로(리스트로)
	{
		return null;
	}
	
	/**
	 * 집주인코드와 여행객코드에 일치하는 방문요청코드 검색을  VisitRequestDAO와 TouristDAO에 요청하고 application 계층 매니저인 VisitRequestForTouristManager에 처리결과를 전달한다
	 * @param hosueOwnerCode 집주인코드
	 * @param touristCode 여행객코드
	 * @return 집주인코드와 여행객코드에 일치하는 방문요청코드 
	 */
	public List<String> getVisitRequestCode(String hosueOwnerCode, String touristCode)//고쳐야됨 리턴타입 VO로(리스트로)
	{
		return null;
	}
	
	/**
	 * 여행객 코드에 해당하는 여행객정보  수정을  VisitRequestDAO와 TouristDAO에 요청하고 application 계층 매니저인 VisitRequestForTouristManager에 처리결과를 전달한다
	 * @param touristCode
	 * @param touristEssentialInfo
	 * @return 수정성공여부
	 */
	public boolean modify(String touristCode, TouristEssentialInfo touristEssentialInfo)
	{
		return true;
	}
	
	/**
	 *  집주인의과 여행객 코드에 해당하는 진행상태정보 수정을  VisitRequestDAO와 TouristDAO에 요청하고 application 계층 매니저인 VisitRequestForTouristManager에 처리결과를 전달한다
	 * @param houseOwnerCode 집주인코드
	 * @param touristCode 여행객코드
	 * @param state 진행상태
	 * @return 수정성공여부
	 */
	public boolean modifyVisitRequestState(String houseOwnerCode, String touristCode, String state)
	{
		return true;
	}
}
