package manager;

import dbmanager.PostingDataDAOManager;
import model.CompanionRecommendInfo;
import model.PostingInfo;
import model.TourPlanInfo;
import model.TourPreparationInfo;
/**
 * ������ ������ ���� �Ŵ��� Ŭ���� 
 * PostingReviseServlet���� ȣ�� 
 * @author ����
 *
 */
public class PostingReviseManager {
	/**
	 * ����������
	 */
	private PostingInfo postingInfo;
	/**
	 * �����غ�����
	 */
	private TourPreparationInfo tourPreparationInfo;
	/**
	 * ������������
	 */
	private TourPlanInfo tourPlan;
	/**
	 * ��������õ����
	 */
	private CompanionRecommendInfo companionRecommendInfo;
	/**
	 * null������ 
	 */
	public PostingReviseManager() {
		this(new PostingInfo(),new TourPreparationInfo(),new TourPlanInfo(),new CompanionRecommendInfo());
	}
	
/**
 * ������������ , ��������õ������ �ʱ�ȭ�ϴ� ������ 
 * @param postingInfo ����������
 * @param companionRecommendInfo ��������õ����
 */
	public PostingReviseManager(PostingInfo postingInfo,
			CompanionRecommendInfo companionRecommendInfo) {
		this.postingInfo = postingInfo;
		this.companionRecommendInfo = companionRecommendInfo;
	}

/**
 * ������������, ���������� �ʱ�ȭ�ϴ� ������ 
 * @param postingInfo ���������� 
 * @param tourPlan ��������
 */
	public PostingReviseManager(PostingInfo postingInfo, TourPlanInfo tourPlan) {
		this.postingInfo = postingInfo;
		this.tourPlan = tourPlan;
	}

/**
 * ������������ �����غ������� �ʱ�ȭ�ϴ� ������ 
 * @param postingInfo ���������� 
 * @param tourPreparationInfo �����غ����� 
 */
	public PostingReviseManager(PostingInfo postingInfo,
			TourPreparationInfo tourPreparationInfo) {
		this.postingInfo = postingInfo;
		this.tourPreparationInfo = tourPreparationInfo;
	}

/**
 * ����������, �����غ�����, ������������ , ��������õ������ �ʱ�ȭ�ϴ� ������ 
 * @param postingInfo ���������� 
 * @param tourPreparationInfo �����غ����� 
 * @param tourPlan ������������ 
 * @param companionRecommendInfo ��������õ���� 
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
 * ������������ ��ȯ�Ѵ�. 
 * @return ���������� 
 */
	public PostingInfo getPostingInfo() {
		return postingInfo;
	}

/**
 * ������������ �����Ѵ�. 
 * @param postingInfo ���������� 
 */
	public void setPostingInfo(PostingInfo postingInfo) {
		this.postingInfo = postingInfo;
	}

/**
 * �����غ������� ��ȯ�Ѵ�. 
 * @return �����غ����� 
 */
	public TourPreparationInfo getTourPreparationInfo() {
		return tourPreparationInfo;
	}

/**
 * �����غ������� �����Ѵ�. 
 * @param tourPreparationInfo �����غ����� 
 */
	public void setTourPreparationInfo(TourPreparationInfo tourPreparationInfo) {
		this.tourPreparationInfo = tourPreparationInfo;
	}

/**
 * �������������� ��ȯ�Ѵ�. 
 * @return ������������ 
 */
	public TourPlanInfo getTourPlan() {
		return tourPlan;
	}

/**
 * �������������� �����Ѵ�. 
 * @param tourPlan �������� 
 */
	public void setTourPlan(TourPlanInfo tourPlan) {
		this.tourPlan = tourPlan;
	}

/**
 * ��������õ������ ��ȯ�Ѵ�. 
 * @return ��������õ���� 
 */
	public CompanionRecommendInfo getCompanionRecommendInfo() {
		return companionRecommendInfo;
	}

/**
 * ��������õ������ �����Ѵ�. 
 * @param companionRecommendInfo ��������õ���� 
 */
	public void setCompanionRecommendInfo(
			CompanionRecommendInfo companionRecommendInfo) {
		this.companionRecommendInfo = companionRecommendInfo;
	}
	/**
	 * �������� �����Ѵ�. 
	 * @return ������ �����Ͽ��� ��� ������������ ��ȯ, �ƴϸ� null ��ȯ 
	 */
	public PostingInfo revisePosting(String memberCode){
		PostingDataDAOManager postingDataDAOManager=new PostingDataDAOManager();
		if(postingDataDAOManager.modifyPosting(postingInfo, memberCode))
			return postingInfo;
		else
			return null;
	}
	/**
	 * ��������õ�������� �����Ѵ�. 
	 * @return ������ �����Ͽ��� ��� ������ ��õ ������������ ��ȯ, �ƴϸ� null ��ȯ 
	 */
	public CompanionRecommendInfo reviseCompanionPosting(String memberCode){
		PostingDataDAOManager postingDataDAOManager=new PostingDataDAOManager();
		if(postingDataDAOManager.modifyPosting(companionRecommendInfo, memberCode))
			return companionRecommendInfo;
		else
			return null;
	}
	/**
	 * ���������������� �����Ѵ�. 
	 * @return ������ �����Ͽ��� ��� �������� ������������ ��ȯ, �ƴϸ� null ��ȯ 
	 */
	public TourPlanInfo reviseTourPlanPosting(String memberCode){
		PostingDataDAOManager postingDataDAOManager=new PostingDataDAOManager();
		if(postingDataDAOManager.modifyPosting(tourPlan, memberCode))
			return tourPlan;
		else
			return null;
	}
	/**
	 * �����غ��������� �����Ѵ�. 
	 * @return ������ �����Ͽ��� ��� �����غ� ������������ ��ȯ, �ƴϸ� null ��ȯ 
	 */
	public TourPreparationInfo reviseTourPreparationPosting(String memberCode){
		PostingDataDAOManager postingDataDAOManager=new PostingDataDAOManager();
		if(postingDataDAOManager.modifyPosting(tourPreparationInfo, memberCode))
			return tourPreparationInfo;
		else
			return null;
	}
	
}
