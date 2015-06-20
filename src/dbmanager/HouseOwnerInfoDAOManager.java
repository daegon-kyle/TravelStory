//작성날짜 : 2014/7/27
//작성자 : 이화섭

package dbmanager;
import java.util.GregorianCalendar;

import dao.HouseOwnerDAO;
import dto.HouseOwnerDTO;
import dao.VisitRequestDAO; 
import model.HouseOwnerEssentialInfo;
import converter.ConvertGregorianCalendar; 
/**
 * 집주인에 대한 정보와 방문 요청 상태를 조작하기 위한 클래스 <br/>VisitAcceptManager, HouseOwnerInfoManager에서 사용한다.
 * @author 문정현
 *
 */
public class HouseOwnerInfoDAOManager {
	/**
	 * 집주인에 대한 정보를 조작하기 위한 멤버변수
	 */
	private HouseOwnerDAO houseOwnerDAO;
	/**
	 * 방문신청 상태를 조작하기 위한 멤버 변수
	 */
	private VisitRequestDAO visitRequestDAO;
	/**
	 * 멤버 변수를 받는 생성자
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
	 * 집주인의 정보를 저장한다. <br/> HouseOwnerInfoManager에서 사용한다 <br/> HouseOwnerDAO를 사용한다.
	 * @param memberCode 집주인의 멤버 코드
	 * @param houseOwnerEssentailInf 집주인의 필수정보
	 * @return true - 저장 성공 <br/> false - 저장 실패
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
	 * 집주인의 정보를 삭제한다. <br/>HouseOwnerInfoManager에서 사용한다 <br/>  HouseOwnerDAO를 사용한다.
	 * @param houseOwnerCode 집주인 코드
	 * @return true - 삭제 성공 <br/> false - 삭제 실패
	 */
	public boolean delete(String houseOwnerCode){
		return houseOwnerDAO.deleteHouseOwnerCode(houseOwnerCode);
	}
	/**
	 * 집주인의 정보를 수정한다 <br/> HouseOwnerInfoManager에서 사용한다 <br/> HouseOwnerDAO를 사용한다.
	 * @param houseOwnerCode 집주인 코드
	 * @param houseOwnerEssentialInfo 수정할 집주인의 정보
	 * @return true - 수정 성공 <br/> false - 수정 실패
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
	 * 집주인이 방문 신청 상태를 수정한다. <br/>VisitAcceptManager에서 사용한다 <br/>VisitRequestDAO를 사욯한다.
	 * @param houseOwnerCode 집주인 코드
	 * @param touristCode 방문 요청객 코드
	 * @param requestState 수락/ 대기/ 거절
	 * @return true - 수정 성공 <br/> false - 수정 실패
	 */
	public boolean modifyVisitRequestState(String houseOwnerCode, String touristCode, String requestState){
		return visitRequestDAO.update(houseOwnerCode, touristCode, requestState);
	}
	/**
	 * 집주인에 대한 정보를 가져온다. (사용 안함)
	 * @param houseOwnerCode 집주인 코드
	 * @return 집주인 정보
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
