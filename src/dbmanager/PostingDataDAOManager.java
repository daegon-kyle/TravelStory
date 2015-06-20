package dbmanager;

import dao.*;
import dto.*;
import model.*;
import java.util.*;
/**
 * 포스팅에 대한 정보를 조작하기 위해 PostingAddManager, PostingReviseManager, PostingDeleteManager에서 사용한다
 * @author 문정현
 *
 */
public class PostingDataDAOManager {
	/**
	 * 포스팅 기존 정보를 조작하기 위한 멤버변수
	 */
	private PostingDAO postingDAO;
	/**
	 * 여행 일정 포스팅의 필수 정보를 조작하기 위한 멤버변수
	 */
	private TourPlanDAO tourPlanDAO;
	/**
	 * 여행 일정 포스팅의 정보 중 취향 정보를 조작하기 위한 멤버 변수
	 */
	private LikingInfoDAO likingInfoDAO;
	/**
	 * 여행 준비물 포스팅의 필수 정보를 조작하기 위한 멤버 변수
	 */
	private TourPreparationDAO tourPreparationDAO;
	/**
	 * 동행자 찾기 포스팅의 필수 정보를 조작하기 위한 멤버 변수
	 */
	private CompanionRecommendDAO companionRecommendDAO;
	/**
	 * default constructor
	 */
	public PostingDataDAOManager(){
		this.postingDAO = new PostingDAO();
		this.tourPlanDAO = new TourPlanDAO();
		this.tourPreparationDAO = new TourPreparationDAO();
		this.companionRecommendDAO =new CompanionRecommendDAO();
		this.likingInfoDAO = new LikingInfoDAO();
		
	}
	public PostingInfo getPosting(String postingCode){	//포스팅코드를 이용해서, 포스팅 목적코드를 가져온다. 
		PostingDAO postingDAO=new PostingDAO();
		PostingDTO postingDTO=postingDAO.select(postingCode);
		String postingPurposeCode=postingDTO.getPostingPurposeCode();
		
		PostingInfo postingInfo=new PostingInfo();
		postingInfo.setPostingPurposeCode(postingPurposeCode);
		
		return postingInfo;
	}
	/**
	 * 여행 일정 포스팅의 정보를 저장한다 <br/>PostingAddManager에서 사용 <br/>PostingDAO, TourPlanDAO, LikingInfoDAO를 사용
	 * @param tourPlan 여행 일정 포스팅의 정보
	 * @return true - 저장성공 <br/> false - 저장 실패
	 */
	public boolean savePosting(TourPlanInfo tourPlan, String memberCode){
		//21은 멤버코드
		LikingInfo likingInfo=tourPlan.getLikingInfo();
		
		LikingInfoDAO likingInfoDAO=new LikingInfoDAO();
		System.out.println("선호도!"+likingInfo.getRestaurantPreference()+likingInfo.getHealingPreference()+likingInfo.getAttractionPreference()+likingInfo.getShoppingPreference()+likingInfo.getEtcPreference());
		
		if(likingInfoDAO.insert(likingInfo.getRestaurantPreference(), likingInfo.getHealingPreference(), likingInfo.getAttractionPreference(), likingInfo.getShoppingPreference(), likingInfo.getEtcPreference())){
			String likingInfoCode=likingInfoDAO.select(likingInfo.getRestaurantPreference(), likingInfo.getHealingPreference(), likingInfo.getAttractionPreference(), likingInfo.getShoppingPreference(), likingInfo.getEtcPreference());
			System.out.println("likingInfoDAO까지 성공, 코드는"+likingInfoCode);
			
			if(postingDAO.insert(tourPlan.getPostingPurposeCode(), memberCode, tourPlan.getCategoryCode(), tourPlan.getTitle(), tourPlan.getContent())){
				String postingCode=postingDAO.selectMaxPostingCode(memberCode);
				System.out.println("postingDAO까지 성공");
				
				tourPlanDAO.insert(postingCode, likingInfoCode, tourPlan.getDestination1(),  tourPlan.getDestination1());
				return true;
			}	
		}
		return false;
	}
	/**
	 * 여행 준비물 포스팅의 정보를 저장한다. <br/> PostingAddManager에서 사용<br/> PostingDAO, TourPreparationDAO를 사용
	 * @param tourPreparation 여행 준비물 포스팅의 정보
	 * @return true - 저장 성공 <br/> false - 저장 실패
	 */
	public boolean savePosting(TourPreparationInfo tourPreparation, String memberCode){
		PostingDAO postingDAO=new PostingDAO();
		
		if(postingDAO.insert(tourPreparation.getPostingPurposeCode(), memberCode, tourPreparation.getCategoryCode(), tourPreparation.getTitle(), tourPreparation.getContent())){
			System.out.println("postingDAO 성공");
			String postingCode=postingDAO.selectMaxPostingCode(memberCode);
			
			ConvertGregorianCalendar convert=new ConvertGregorianCalendar();
			String startDate=convert.convert(tourPreparation.getStartDate());
			String endDate=convert.convert(tourPreparation.getEndDate());

			
			TourPreparationDAO tourPreparationDAO=new TourPreparationDAO();
			if(tourPreparationDAO.insert(postingCode, tourPreparation.getDestination1(), tourPreparation.getDestination2(), startDate, endDate)){
				System.out.println("tourPreprationDAO 성공");
				return true;
			}
		}
		return false;
	}
	/**
	 * 동행자 찾기 포스팅의 정보를 저장한다, <br/>PostingAddManager에서 사용 <br/> PostingDAO, CompanionRecommendDAO를 사용
	 * @param companionRecommend 동행자 찾기 포스팅의 정보
	 * @return true - 저장 성공 <br/> false - 저장 실패
	 */
	public boolean savePosting(CompanionRecommendInfo companionRecommend, String memberCode){
		PostingDAO postingDAO=new PostingDAO();
		System.out.println("savePosting안 목적코드:"+companionRecommend.getPostingPurposeCode());
		if(postingDAO.insert(companionRecommend.getPostingPurposeCode(), memberCode, companionRecommend.getCategoryCode(), companionRecommend.getTitle(), companionRecommend.getContent())){
			System.out.println("PostingDAO 성공");
			String postingCode=postingDAO.selectMaxPostingCode(memberCode);
			
			ConvertGregorianCalendar convert=new ConvertGregorianCalendar();
			String startDate=convert.convert(companionRecommend.getStartDate());
			String endDate=convert.convert(companionRecommend.getEndDate());
						
			CompanionRecommendDAO companionRecommendDAO=new CompanionRecommendDAO();
			if(companionRecommendDAO.insert(postingCode, companionRecommend.getDestination1(), companionRecommend.getDestination2(), startDate, endDate, companionRecommend.getOtherAge(), companionRecommend.getOtherGender())){
				System.out.println("companionRecommendDAO 성공");
				return true;
			}
		}
		
		return false;
	}
	/**
	 * 일반 글 포스팅의 정보를 저장한다. <br/> PostingAddManager에서 사용<br/>PostingDAO를 사용
	 * @param postingInfo 일반 글 포스팅의 정보
	 * @return true - 저장 성공 <br/> false- 저장 실패
	 */
	public boolean savePosting(PostingInfo postingInfo, String memberCode){
		PostingDAO postingDAO=new PostingDAO();
		if(postingDAO.insert(postingInfo.getPostingPurposeCode(), memberCode, postingInfo.getCategoryCode(), postingInfo.getTitle(), postingInfo.getContent())){
			System.out.println("일반글 포스팅 성공!");
			return true;
		}
		else
			return false;
	}
	/**
	 * 일반 글 포스팅의 상세 정보를 수정한다 <br/> PostingReviseManager에서 사용 <br/>PostingDAO를 사용
	 * @param postingInfo 포스팅의 정보
	 * @return true - 수정 성공 <br/>false- 수정 실패
	 */
	
	public boolean modifyPosting(PostingInfo postingInfo, String memberCode){
		PostingDAO postingDAO=new PostingDAO();
		if(postingDAO.update(postingInfo.getPostingCode(), postingInfo.getCategoryCode(), postingInfo.getTitle(),postingInfo.getContent()))
			return true;
		
		return false;
	}
	/**
	 * 여행 일정 포스팅의 필수 정보를 수정한다 <br/>PostingReviseManager에서 사용<br/>PostingDAO, TourPlnaDAO를 사용
	 * @param tourPlan 여행 일정 포스팅 정보
	 * @return true - 수정 성공 <br/>false- 수정 실패
	 */
	public boolean modifyPosting(TourPlanInfo tourPlan, String memberCode){
		//포스팅 코드를 가지고 온 후, 기존의 likingInfo의 코드를 받아와야 수정이 가능하다.
		TourPlanDAO tourPlanDAO=new TourPlanDAO();
		TourPlanDTO tourPlanDTO=tourPlanDAO.select(tourPlan.getPostingCode());
		String likingInfoCode=tourPlanDTO.getLikingInfoCode();
		//------------------------------------------------------------------------------------------------
		//취향정보 수정
		LikingInfo likingInfo=tourPlan.getLikingInfo();
		LikingInfoDAO likingDAO=new LikingInfoDAO();
		if(likingDAO.update(likingInfoCode, likingInfo.getRestaurantPreference(), likingInfo.getHealingPreference(), likingInfo.getAttractionPreference(), likingInfo.getShoppingPreference(), likingInfo.getEtcPreference())){
			//포스팅 정보 수정
			System.out.println("취향정보 수정 성공");
			PostingDAO postingDAO=new PostingDAO();
			if(postingDAO.update(tourPlan.getPostingCode(), tourPlan.getCategoryCode(), tourPlan.getTitle(), tourPlan.getContent())){
				System.out.println("포스팅 정보 수정 성공");
				//여행일정 정보 수정
				if( tourPlanDAO.update(tourPlan.getPostingCode(), likingInfoCode, tourPlan.getDestination1(), tourPlan.getDestination2())){
					System.out.println("여행일정 정보 수정 성공");
					return true;
				}
			}
		}		
		return false;
	}
	/**
	 * 여행 준비물 포스팅의 필수 정보를 수정한다<br/>PostingReviseManager에서 사용<br/>PostingDAO, TourPreparationDAO를 사용
	 * @param tourPreparation 여행 준비물 포스팅 정보
	 * @return true - 수정 성공 <br/>false- 수정 실패
	 */
	public boolean modifyPosting(TourPreparationInfo tourPreparation, String memberCode){
		PostingDAO postingDAO=new PostingDAO();
		System.out.println("여행준비물 수정 초기단계!");
		
		if(postingDAO.update(tourPreparation.getPostingCode(), tourPreparation.getCategoryCode(), tourPreparation.getTitle(), tourPreparation.getContent())){
			System.out.println("일반글 포스팅 성공!");
			TourPreparationDAO tourPreparationDAO=new TourPreparationDAO();
			
			ConvertGregorianCalendar convert=new ConvertGregorianCalendar();
			String startDate=convert.convert(tourPreparation.getStartDate());
			String endDate=convert.convert(tourPreparation.getEndDate());
			
			if(tourPreparationDAO.update(tourPreparation.getPostingCode(), tourPreparation.getDestination1(), tourPreparation.getDestination2(), startDate, endDate)){
				System.out.println("여행준비물 성공");
				return true;
			}
		}
		return false;
	}
	/**
	 * 동행자 찾기 포스팅의 필수 정보를 수정한다 <br/>PostingReviseManager에서 사용<br/>PostingDAO, CompanionRecommendDAO를 사용
	 * @param companionRecommend 동행자 찾기 포스팅 정보
	 * @return true - 수정 성공 <br/>false- 수정 실패
	 */
	public boolean modifyPosting(CompanionRecommendInfo companionRecommend, String memberCode){
		PostingDAO postingDAO=new PostingDAO();
		System.out.println("동행자 추천 초기");
		
		if(postingDAO.update(companionRecommend.getPostingCode(), companionRecommend.getCategoryCode(), companionRecommend.getTitle(), companionRecommend.getContent())){
			System.out.println("일반글 수정 성공");
			
			CompanionRecommendDAO companionRecommendDAO=new CompanionRecommendDAO();
			
			ConvertGregorianCalendar convert=new ConvertGregorianCalendar();
			String startDate=convert.convert(companionRecommend.getStartDate());
			String endDate=convert.convert(companionRecommend.getEndDate());
			
			if(companionRecommendDAO.update(companionRecommend.getPostingCode(), companionRecommend.getDestination1(), companionRecommend.getDestination2(), startDate, endDate, companionRecommend.getOtherAge(), companionRecommend.getOtherGender())){
				System.out.println("동행자 수정 성공^^");
				return true;
			}
		}
		return false;
	}
	/**
	 * 포스팅 코드에 해당하는 포스팅의 모든 정보을 삭제한다 <br/>PostingDeleteManager에서 사용<br/> PostingDAO에서 사용
	 * @param postingCode 포스팅 코드
	 * @return true - 삭제 성공 <br/>false- 삭제 실패
	 */
	
	public boolean deletePosting(String postingCode, String memberCode){
		return false;
	}
	/**
	 * 특정 포스팅의 좋아요 수를 한개 증가 시킨다. <br/>PostingsDAOManager에서 위임처리한 것을 처리한다.<br/>PostingDAO를 사용한다.
	 * @param postingCode 포스팅 코드
	 * @return true - 수정 성공<br/> false - 수정 실패
	 */
	public boolean addLikeNum(String postingCode){
		System.out.println("PostingDataDAOManager로 오긴 옴 코드 값"+postingCode);
		int likeNum = this.postingDAO.selectLikeNum(postingCode);
		System.out.println("PostingDAO의 좋아요"+likeNum);
		return this.postingDAO.update(postingCode, ++likeNum);
	}
}
