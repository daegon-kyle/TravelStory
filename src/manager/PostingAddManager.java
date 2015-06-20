package manager;

import dbmanager.PostingDataDAOManager;
import model.CompanionRecommendInfo;
import model.PostingInfo;
import model.TourPlanInfo;
import model.TourPreparationInfo;
/**
 * ������ �߰��� ���� �Ŵ��� Ŭ���� 
 * PostingAddServlet���� ȣ�� 
 * @author ����
 *
 */
public class PostingAddManager {
	/**
	 *  ���������� ��ü 
	 */
	private PostingInfo postingInfo;
	/**
	 * �����غ����� ��ü 
	 */
	private TourPreparationInfo tourPreparationInfo;
	/**
	 * �������� ��ü 
	 */
	private TourPlanInfo tourPlan;
	/**
	 * ��������õ���� 
	 */
	private CompanionRecommendInfo companionRecommendInfo;
	/**
	 * null ������ 
	 */
	public PostingAddManager() {
		this(new PostingInfo(),new TourPreparationInfo(),new TourPlanInfo(),new CompanionRecommendInfo());
	}
	
	/**
	 * ����������, ��������õ������ �ʱ�ȭ�ϴ� ������ 
	 * @param postingInfo ���������� 
	 * @param companionRecommendInfo ��������õ����
	 */
	public PostingAddManager(PostingInfo postingInfo,
			CompanionRecommendInfo companionRecommendInfo) {
		this.postingInfo = postingInfo;
		this.companionRecommendInfo = companionRecommendInfo;
	}

/**
 * ����������, ������������ �ʱ�ȭ�ϴ� ������ 
 * @param postingInfo ����������
 * @param tourPlan �������� 
 */
	public PostingAddManager(PostingInfo postingInfo, TourPlanInfo tourPlan) {
		this.postingInfo = postingInfo;
		this.tourPlan = tourPlan;
	}

/**
 * ����������, �����غ������� �ʱ�ȭ�ϴ� ������ 
 * @param postingInfo ����������
 * @param tourPreparationInfo �����غ�
 */
	public PostingAddManager(PostingInfo postingInfo,
			TourPreparationInfo tourPreparationInfo) {
		this.postingInfo = postingInfo;
		this.tourPreparationInfo = tourPreparationInfo;
	}

/**
 * ����������, �����غ�����, ������������, ��������õ������ �ʱ�ȭ�ϴ� ������ 
 * @param postingInfo ����������
 * @param tourPreparationInfo �����غ�����
 * @param tourPlan ������������
 * @param companionRecommendInfo ��������õ����
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
 * �����غ��� ��ȯ�Ѵ�. 
 * @return �����غ�
 */
	public TourPreparationInfo getTourPreparationInfo() {
		return tourPreparationInfo;
	}

/**
 * �����غ��� �����Ѵ�. 
 * @param tourPreparationInfo �����غ�
 */
	public void setTourPreparationInfo(TourPreparationInfo tourPreparationInfo) {
		this.tourPreparationInfo = tourPreparationInfo;
	}

/**
 * ���������� ��ȯ�Ѵ�. 
 * @return �������� 
 */
	public TourPlanInfo getTourPlan() {
		return tourPlan;
	}

/**
 * ���������� �����Ѵ�. 
 * @param tourPlan �������� 
 */
	public void setTourPlan(TourPlanInfo tourPlan) {
		this.tourPlan = tourPlan;
	}

/**
 * ��������õ�� ��ȯ�Ѵ�. 
 * @return ��������õ����
 */
	public CompanionRecommendInfo getCompanionRecommendInfo() {
		return companionRecommendInfo;
	}

/**
 * ��������õ�� �����Ѵ�. 
 * @param companionRecommendInfo ��������õ����
 */
	public void setCompanionRecommendInfo(
			CompanionRecommendInfo companionRecommendInfo) {
		this.companionRecommendInfo = companionRecommendInfo;
	}
	
	
	/**
	 * �������� �߰��ϴ�.  	
	 * @return ���������� �߰��ϸ� ������������ ��ȯ , �ƴϸ� null ��ȯ 
	 */
	public PostingInfo addPosting(String memberCode){
		PostingDataDAOManager postingDataDAOManager=new PostingDataDAOManager();
		if(postingDataDAOManager.savePosting(postingInfo, memberCode))
			return postingInfo;
		else
			return null;
	}
	/**
	 * ���������������� �߰��ϴ� 
	 * @return ���������� �߰��ϸ� �������������������� ��ȯ , �ƴϸ� null ��ȯ
	 */
	public TourPlanInfo addTourPlanPosting(String memberCode){
		PostingDataDAOManager postingDataDAOManager=new PostingDataDAOManager();
		if(postingDataDAOManager.savePosting(tourPlan, memberCode))
			return tourPlan;
		else
			return null;
	}
	/**
	 * ��������õ�������� �߰��ϴ�. 
	 * @return ��������õ���� 
	 */
	public CompanionRecommendInfo addCompanionPosting(String memberCode){
		PostingDataDAOManager postingDataDAOManager=new PostingDataDAOManager();
		if(postingDataDAOManager.savePosting(companionRecommendInfo, memberCode))
			return companionRecommendInfo;
		else
			return null;
	}
	/**
	 * �����غ������� �߰��ϴ� 
	 * @return �����غ�����
	 */
	public TourPreparationInfo addTourPreparationPosting(String memberCode){
		PostingDataDAOManager postingDataDAOManager=new PostingDataDAOManager();
		if(postingDataDAOManager.savePosting(tourPreparationInfo, memberCode))
			return tourPreparationInfo;
		else
			return null;
	}
	
	
}
