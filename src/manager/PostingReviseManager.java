package manager;

import dbmanager.PostingDataDAOManager;
import model.CompanionRecommendInfo;
import model.PostingInfo;
import model.TourPlanInfo;
import model.TourPreparationInfo;
/**
 * 포스팅 수정을 위한 매니저 클래스 
 * PostingReviseServlet에서 호출 
 * @author 영한
 *
 */
public class PostingReviseManager {
	/**
	 * 포스팅정보
	 */
	private PostingInfo postingInfo;
	/**
	 * 여행준비물정보
	 */
	private TourPreparationInfo tourPreparationInfo;
	/**
	 * 여행일정정보
	 */
	private TourPlanInfo tourPlan;
	/**
	 * 동행자추천정보
	 */
	private CompanionRecommendInfo companionRecommendInfo;
	/**
	 * null생성자 
	 */
	public PostingReviseManager() {
		this(new PostingInfo(),new TourPreparationInfo(),new TourPlanInfo(),new CompanionRecommendInfo());
	}
	
/**
 * 포스팅정보와 , 동행자추천정보를 초기화하는 생성자 
 * @param postingInfo 포스팅정보
 * @param companionRecommendInfo 동행자추천정보
 */
	public PostingReviseManager(PostingInfo postingInfo,
			CompanionRecommendInfo companionRecommendInfo) {
		this.postingInfo = postingInfo;
		this.companionRecommendInfo = companionRecommendInfo;
	}

/**
 * 포스팅정보와, 여행일정을 초기화하는 생성자 
 * @param postingInfo 포스팅정보 
 * @param tourPlan 여행일정
 */
	public PostingReviseManager(PostingInfo postingInfo, TourPlanInfo tourPlan) {
		this.postingInfo = postingInfo;
		this.tourPlan = tourPlan;
	}

/**
 * 포스팅정보와 여행준비물정보를 초기화하는 생성자 
 * @param postingInfo 포스팅정보 
 * @param tourPreparationInfo 여행준비물정보 
 */
	public PostingReviseManager(PostingInfo postingInfo,
			TourPreparationInfo tourPreparationInfo) {
		this.postingInfo = postingInfo;
		this.tourPreparationInfo = tourPreparationInfo;
	}

/**
 * 포스팅정보, 여행준비물정보, 여행일정정보 , 동행자추천정보를 초기화하는 생성자 
 * @param postingInfo 포스팅정보 
 * @param tourPreparationInfo 여행준비물정보 
 * @param tourPlan 여행일정정보 
 * @param companionRecommendInfo 동행자추천정보 
 */
	public PostingReviseManager(PostingInfo postingInfo,
			TourPreparationInfo tourPreparationInfo, TourPlanInfo tourPlan,
			CompanionRecommendInfo companionRecommendInfo) {
		this.postingInfo = postingInfo;
		this.tourPreparationInfo = tourPreparationInfo;
		this.tourPlan = tourPlan;
		this.companionRecommendInfo = companionRecommendInfo;
	}

/**
 * 포스팅정보를 반환한다. 
 * @return 포스팅정보 
 */
	public PostingInfo getPostingInfo() {
		return postingInfo;
	}

/**
 * 포스팅정보를 세팅한다. 
 * @param postingInfo 포스팅정보 
 */
	public void setPostingInfo(PostingInfo postingInfo) {
		this.postingInfo = postingInfo;
	}

/**
 * 여행준비물정보를 반환한다. 
 * @return 여행준비물정보 
 */
	public TourPreparationInfo getTourPreparationInfo() {
		return tourPreparationInfo;
	}

/**
 * 여행준비물정보를 세팅한다. 
 * @param tourPreparationInfo 여행준비물정보 
 */
	public void setTourPreparationInfo(TourPreparationInfo tourPreparationInfo) {
		this.tourPreparationInfo = tourPreparationInfo;
	}

/**
 * 여행일정정보를 반환한다. 
 * @return 여행일정정보 
 */
	public TourPlanInfo getTourPlan() {
		return tourPlan;
	}

/**
 * 여행일정정보를 세팅한다. 
 * @param tourPlan 여행일정 
 */
	public void setTourPlan(TourPlanInfo tourPlan) {
		this.tourPlan = tourPlan;
	}

/**
 * 동행자추천정보를 반환한다. 
 * @return 동행자추천정보 
 */
	public CompanionRecommendInfo getCompanionRecommendInfo() {
		return companionRecommendInfo;
	}

/**
 * 동행자추천정보를 세팅한다. 
 * @param companionRecommendInfo 동행자추천정보 
 */
	public void setCompanionRecommendInfo(
			CompanionRecommendInfo companionRecommendInfo) {
		this.companionRecommendInfo = companionRecommendInfo;
	}
	/**
	 * 포스팅을 수정한다. 
	 * @return 수정에 성공하였을 경우 포스팅정보를 반환, 아니면 null 반환 
	 */
	public PostingInfo revisePosting(String memberCode){
		PostingDataDAOManager postingDataDAOManager=new PostingDataDAOManager();
		if(postingDataDAOManager.modifyPosting(postingInfo, memberCode))
			return postingInfo;
		else
			return null;
	}
	/**
	 * 동행자추천포스팅을 수정한다. 
	 * @return 수정에 성공하였을 경우 동행자 추천 포스팅정보를 반환, 아니면 null 반환 
	 */
	public CompanionRecommendInfo reviseCompanionPosting(String memberCode){
		PostingDataDAOManager postingDataDAOManager=new PostingDataDAOManager();
		if(postingDataDAOManager.modifyPosting(companionRecommendInfo, memberCode))
			return companionRecommendInfo;
		else
			return null;
	}
	/**
	 * 여행일정포스팅을 수정한다. 
	 * @return 수정에 성공하였을 경우 여행일정 포스팅정보를 반환, 아니면 null 반환 
	 */
	public TourPlanInfo reviseTourPlanPosting(String memberCode){
		PostingDataDAOManager postingDataDAOManager=new PostingDataDAOManager();
		if(postingDataDAOManager.modifyPosting(tourPlan, memberCode))
			return tourPlan;
		else
			return null;
	}
	/**
	 * 여행준비물포스팅을 수정한다. 
	 * @return 수정에 성공하였을 경우 여행준비물 포스팅정보를 반환, 아니면 null 반환 
	 */
	public TourPreparationInfo reviseTourPreparationPosting(String memberCode){
		PostingDataDAOManager postingDataDAOManager=new PostingDataDAOManager();
		if(postingDataDAOManager.modifyPosting(tourPreparationInfo, memberCode))
			return tourPreparationInfo;
		else
			return null;
	}
	
}
