package manager;

import dao.PostingDAO;
import model.CompanionRecommendInfo;
import model.PostingInfo;
import model.TourPlanInfo;
import model.TourPreparationInfo;
/**
 * �������� �����ϱ����� �Ŵ��� Ŭ���� 
 * PostingDeleteServlet���� ȣ�� 
 * @author ����
 *
 */
public class PostingDeleteManager {
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
	public PostingDeleteManager() {
		this(new PostingInfo(),new TourPreparationInfo(),new TourPlanInfo(),new CompanionRecommendInfo());
	}
	
	public PostingDeleteManager(PostingInfo postingInfo) {
		this.postingInfo = postingInfo;
	}

	/**
	 * ���������� , �����غ������� �ʱ�ȭ�ϴ� ������ 
	 * @param postingInfo ���������� 
	 * @param tourPreparationInfo �����غ� ���� 
	 */
	public PostingDeleteManager(PostingInfo postingInfo,
			TourPreparationInfo tourPreparationInfo) {
		this.postingInfo = postingInfo;
		this.tourPreparationInfo = tourPreparationInfo;
	}
	/**
	 * ����������, ��������õ������ �ʱ�ȭ�ϴ� ������ 
	 * @param postingInfo ���������� 
	 * @param companionRecommendInfo ��������õ���� 
	 */
	public PostingDeleteManager(PostingInfo postingInfo,
			CompanionRecommendInfo companionRecommendInfo) {
		this.postingInfo = postingInfo;
		this.companionRecommendInfo = companionRecommendInfo;
	}
	/**
	 * ����������, �������������� �ʱ�ȭ�ϴ� ������ 
	 * @param postingInfo ����������
	 * @param tourPlan ������������ 
	 */
	public PostingDeleteManager(PostingInfo postingInfo, TourPlanInfo tourPlan) {
		this.postingInfo = postingInfo;
		this.tourPlan = tourPlan;
	}
	/**
	 * ����������, �����غ�����, ��������, ��������õ������ �ʱ�ȭ�ϴ� ������ 
	 * @param postingInfo ����������
	 * @param tourPreparationInfo �����غ�
	 * @param tourPlan ��������
	 * @param companionRecommendInfo ��������õ����
	 */
	public PostingDeleteManager(PostingInfo postingInfo,
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
	 * �������������� ��ȯ�Ѵ�. 
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
	 * @return ���������� �����Ǿ����� ���������� ��ȯ , �ƴϸ� null ��ȯ 
	 */
	public PostingInfo deletePosting(String memberCode){
		PostingDAO postingDAO=new PostingDAO();
		if( postingDAO.deletePosting(postingInfo.getPostingCode()))
			return postingInfo;
		else
			return null;
	}
	/**
	 * ��������õ�������� �����Ѵ�.
	 * @return ���������� �����Ǿ����� ��������õ ���������� ��ȯ , �ƴϸ� null ��ȯ
	 */
	public CompanionRecommendInfo deleteCompanionPosting(){
		return null;
	}
	/**
	 * ���������������� �����Ѵ�. 
	 * @return ���������� �����Ǿ����� �������� ���������� ��ȯ , �ƴϸ� null ��ȯ
	 */
	public TourPlanInfo deleteTourPlanPosting(){
		return null;
	}
	/**
	 * �����غ��������� �����Ѵ�. 
	 * @return ���������� �����Ǿ����� �����غ� ���������� ��ȯ , �ƴϸ� null ��ȯ
	 */
	public TourPreparationInfo deleteTourPreparationPosting(){
		return null;
	}	
}
