package manager;

import dbmanager.PostingDataDAOManager;
import model.CompanionRecommendInfo;
import model.PostingInfo;
import model.TourPlanInfo;
import model.TourPreparationInfo;
/**
 * 포스팅 추가를 위한 매니저 클래스 
 * PostingAddServlet에서 호출 
 * @author 영한
 *
 */
public class PostingAddManager {
	/**
	 *  포스팅정보 객체 
	 */
	private PostingInfo postingInfo;
	/**
	 * 여행준비물정보 객체 
	 */
	private TourPreparationInfo tourPreparationInfo;
	/**
	 * 여행일정 객체 
	 */
	private TourPlanInfo tourPlan;
	/**
	 * 동행자추천정보 
	 */
	private CompanionRecommendInfo companionRecommendInfo;
	/**
	 * null 생성자 
	 */
	public PostingAddManager() {
		this(new PostingInfo(),new TourPreparationInfo(),new TourPlanInfo(),new CompanionRecommendInfo());
	}
	
	/**
	 * 포스팅정보, 동행자추천정보로 초기화하는 생성자 
	 * @param postingInfo 포스팅정보 
	 * @param companionRecommendInfo 동행자추천정보
	 */
	public PostingAddManager(PostingInfo postingInfo,
			CompanionRecommendInfo companionRecommendInfo) {
		this.postingInfo = postingInfo;
		this.companionRecommendInfo = companionRecommendInfo;
	}

/**
 * 포스팅정보, 여행일정으로 초기화하는 생성자 
 * @param postingInfo 포스팅정보
 * @param tourPlan 여행일정 
 */
	public PostingAddManager(PostingInfo postingInfo, TourPlanInfo tourPlan) {
		this.postingInfo = postingInfo;
		this.tourPlan = tourPlan;
	}

/**
 * 포스팅정보, 여행준비물정보로 초기화하는 생성자 
 * @param postingInfo 포스팅정보
 * @param tourPreparationInfo 여행준비물
 */
	public PostingAddManager(PostingInfo postingInfo,
			TourPreparationInfo tourPreparationInfo) {
		this.postingInfo = postingInfo;
		this.tourPreparationInfo = tourPreparationInfo;
	}

/**
 * 포스팅정보, 여행준비물정보, 여행일정정보, 동행자추천정보로 초기화하는 생성자 
 * @param postingInfo 포스팅정보
 * @param tourPreparationInfo 여행준비물정보
 * @param tourPlan 여행일정정보
 * @param companionRecommendInfo 동행자추천정보
 */
	public PostingAddManager(PostingInfo postingInfo,
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
 * 여행준비물을 반환한다. 
 * @return 여행준비물
 */
	public TourPreparationInfo getTourPreparationInfo() {
		return tourPreparationInfo;
	}

/**
 * 여행준비물을 세팅한다. 
 * @param tourPreparationInfo 여행준비물
 */
	public void setTourPreparationInfo(TourPreparationInfo tourPreparationInfo) {
		this.tourPreparationInfo = tourPreparationInfo;
	}

/**
 * 여행일정을 반환한다. 
 * @return 여행일정 
 */
	public TourPlanInfo getTourPlan() {
		return tourPlan;
	}

/**
 * 여행일정을 세팅한다. 
 * @param tourPlan 여행일정 
 */
	public void setTourPlan(TourPlanInfo tourPlan) {
		this.tourPlan = tourPlan;
	}

/**
 * 동행자추천을 반환한다. 
 * @return 동행자추천정보
 */
	public CompanionRecommendInfo getCompanionRecommendInfo() {
		return companionRecommendInfo;
	}

/**
 * 동행자추천을 세팅한다. 
 * @param companionRecommendInfo 동행자추천정보
 */
	public void setCompanionRecommendInfo(
			CompanionRecommendInfo companionRecommendInfo) {
		this.companionRecommendInfo = companionRecommendInfo;
	}
	
	
	/**
	 * 포스팅을 추가하다.  	
	 * @return 성공적으로 추가하면 포스팅정보를 반환 , 아니면 null 반환 
	 */
	public PostingInfo addPosting(String memberCode){
		PostingDataDAOManager postingDataDAOManager=new PostingDataDAOManager();
		if(postingDataDAOManager.savePosting(postingInfo, memberCode))
			return postingInfo;
		else
			return null;
	}
	/**
	 * 여행일정포스팅을 추가하다 
	 * @return 성공적으로 추가하면 여행일정포스팅정보를 반환 , 아니면 null 반환
	 */
	public TourPlanInfo addTourPlanPosting(String memberCode){
		PostingDataDAOManager postingDataDAOManager=new PostingDataDAOManager();
		if(postingDataDAOManager.savePosting(tourPlan, memberCode))
			return tourPlan;
		else
			return null;
	}
	/**
	 * 동행자추천포스팅을 추가하다. 
	 * @return 동행자추천정보 
	 */
	public CompanionRecommendInfo addCompanionPosting(String memberCode){
		PostingDataDAOManager postingDataDAOManager=new PostingDataDAOManager();
		if(postingDataDAOManager.savePosting(companionRecommendInfo, memberCode))
			return companionRecommendInfo;
		else
			return null;
	}
	/**
	 * 여행준비물정보를 추가하다 
	 * @return 여행준비물정보
	 */
	public TourPreparationInfo addTourPreparationPosting(String memberCode){
		PostingDataDAOManager postingDataDAOManager=new PostingDataDAOManager();
		if(postingDataDAOManager.savePosting(tourPreparationInfo, memberCode))
			return tourPreparationInfo;
		else
			return null;
	}
	
	
}
