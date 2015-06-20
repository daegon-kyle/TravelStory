package dbmanager;

import dao.*;
import dto.*;
import model.*;
import java.util.*;
/**
 * �����ÿ� ���� ������ �����ϱ� ���� PostingAddManager, PostingReviseManager, PostingDeleteManager���� ����Ѵ�
 * @author ������
 *
 */
public class PostingDataDAOManager {
	/**
	 * ������ ���� ������ �����ϱ� ���� �������
	 */
	private PostingDAO postingDAO;
	/**
	 * ���� ���� �������� �ʼ� ������ �����ϱ� ���� �������
	 */
	private TourPlanDAO tourPlanDAO;
	/**
	 * ���� ���� �������� ���� �� ���� ������ �����ϱ� ���� ��� ����
	 */
	private LikingInfoDAO likingInfoDAO;
	/**
	 * ���� �غ� �������� �ʼ� ������ �����ϱ� ���� ��� ����
	 */
	private TourPreparationDAO tourPreparationDAO;
	/**
	 * ������ ã�� �������� �ʼ� ������ �����ϱ� ���� ��� ����
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
	public PostingInfo getPosting(String postingCode){	//�������ڵ带 �̿��ؼ�, ������ �����ڵ带 �����´�. 
		PostingDAO postingDAO=new PostingDAO();
		PostingDTO postingDTO=postingDAO.select(postingCode);
		String postingPurposeCode=postingDTO.getPostingPurposeCode();
		
		PostingInfo postingInfo=new PostingInfo();
		postingInfo.setPostingPurposeCode(postingPurposeCode);
		
		return postingInfo;
	}
	/**
	 * ���� ���� �������� ������ �����Ѵ� <br/>PostingAddManager���� ��� <br/>PostingDAO, TourPlanDAO, LikingInfoDAO�� ���
	 * @param tourPlan ���� ���� �������� ����
	 * @return true - ���强�� <br/> false - ���� ����
	 */
	public boolean savePosting(TourPlanInfo tourPlan, String memberCode){
		//21�� ����ڵ�
		LikingInfo likingInfo=tourPlan.getLikingInfo();
		
		LikingInfoDAO likingInfoDAO=new LikingInfoDAO();
		System.out.println("��ȣ��!"+likingInfo.getRestaurantPreference()+likingInfo.getHealingPreference()+likingInfo.getAttractionPreference()+likingInfo.getShoppingPreference()+likingInfo.getEtcPreference());
		
		if(likingInfoDAO.insert(likingInfo.getRestaurantPreference(), likingInfo.getHealingPreference(), likingInfo.getAttractionPreference(), likingInfo.getShoppingPreference(), likingInfo.getEtcPreference())){
			String likingInfoCode=likingInfoDAO.select(likingInfo.getRestaurantPreference(), likingInfo.getHealingPreference(), likingInfo.getAttractionPreference(), likingInfo.getShoppingPreference(), likingInfo.getEtcPreference());
			System.out.println("likingInfoDAO���� ����, �ڵ��"+likingInfoCode);
			
			if(postingDAO.insert(tourPlan.getPostingPurposeCode(), memberCode, tourPlan.getCategoryCode(), tourPlan.getTitle(), tourPlan.getContent())){
				String postingCode=postingDAO.selectMaxPostingCode(memberCode);
				System.out.println("postingDAO���� ����");
				
				tourPlanDAO.insert(postingCode, likingInfoCode, tourPlan.getDestination1(),  tourPlan.getDestination1());
				return true;
			}	
		}
		return false;
	}
	/**
	 * ���� �غ� �������� ������ �����Ѵ�. <br/> PostingAddManager���� ���<br/> PostingDAO, TourPreparationDAO�� ���
	 * @param tourPreparation ���� �غ� �������� ����
	 * @return true - ���� ���� <br/> false - ���� ����
	 */
	public boolean savePosting(TourPreparationInfo tourPreparation, String memberCode){
		PostingDAO postingDAO=new PostingDAO();
		
		if(postingDAO.insert(tourPreparation.getPostingPurposeCode(), memberCode, tourPreparation.getCategoryCode(), tourPreparation.getTitle(), tourPreparation.getContent())){
			System.out.println("postingDAO ����");
			String postingCode=postingDAO.selectMaxPostingCode(memberCode);
			
			ConvertGregorianCalendar convert=new ConvertGregorianCalendar();
			String startDate=convert.convert(tourPreparation.getStartDate());
			String endDate=convert.convert(tourPreparation.getEndDate());

			
			TourPreparationDAO tourPreparationDAO=new TourPreparationDAO();
			if(tourPreparationDAO.insert(postingCode, tourPreparation.getDestination1(), tourPreparation.getDestination2(), startDate, endDate)){
				System.out.println("tourPreprationDAO ����");
				return true;
			}
		}
		return false;
	}
	/**
	 * ������ ã�� �������� ������ �����Ѵ�, <br/>PostingAddManager���� ��� <br/> PostingDAO, CompanionRecommendDAO�� ���
	 * @param companionRecommend ������ ã�� �������� ����
	 * @return true - ���� ���� <br/> false - ���� ����
	 */
	public boolean savePosting(CompanionRecommendInfo companionRecommend, String memberCode){
		PostingDAO postingDAO=new PostingDAO();
		System.out.println("savePosting�� �����ڵ�:"+companionRecommend.getPostingPurposeCode());
		if(postingDAO.insert(companionRecommend.getPostingPurposeCode(), memberCode, companionRecommend.getCategoryCode(), companionRecommend.getTitle(), companionRecommend.getContent())){
			System.out.println("PostingDAO ����");
			String postingCode=postingDAO.selectMaxPostingCode(memberCode);
			
			ConvertGregorianCalendar convert=new ConvertGregorianCalendar();
			String startDate=convert.convert(companionRecommend.getStartDate());
			String endDate=convert.convert(companionRecommend.getEndDate());
						
			CompanionRecommendDAO companionRecommendDAO=new CompanionRecommendDAO();
			if(companionRecommendDAO.insert(postingCode, companionRecommend.getDestination1(), companionRecommend.getDestination2(), startDate, endDate, companionRecommend.getOtherAge(), companionRecommend.getOtherGender())){
				System.out.println("companionRecommendDAO ����");
				return true;
			}
		}
		
		return false;
	}
	/**
	 * �Ϲ� �� �������� ������ �����Ѵ�. <br/> PostingAddManager���� ���<br/>PostingDAO�� ���
	 * @param postingInfo �Ϲ� �� �������� ����
	 * @return true - ���� ���� <br/> false- ���� ����
	 */
	public boolean savePosting(PostingInfo postingInfo, String memberCode){
		PostingDAO postingDAO=new PostingDAO();
		if(postingDAO.insert(postingInfo.getPostingPurposeCode(), memberCode, postingInfo.getCategoryCode(), postingInfo.getTitle(), postingInfo.getContent())){
			System.out.println("�Ϲݱ� ������ ����!");
			return true;
		}
		else
			return false;
	}
	/**
	 * �Ϲ� �� �������� �� ������ �����Ѵ� <br/> PostingReviseManager���� ��� <br/>PostingDAO�� ���
	 * @param postingInfo �������� ����
	 * @return true - ���� ���� <br/>false- ���� ����
	 */
	
	public boolean modifyPosting(PostingInfo postingInfo, String memberCode){
		PostingDAO postingDAO=new PostingDAO();
		if(postingDAO.update(postingInfo.getPostingCode(), postingInfo.getCategoryCode(), postingInfo.getTitle(),postingInfo.getContent()))
			return true;
		
		return false;
	}
	/**
	 * ���� ���� �������� �ʼ� ������ �����Ѵ� <br/>PostingReviseManager���� ���<br/>PostingDAO, TourPlnaDAO�� ���
	 * @param tourPlan ���� ���� ������ ����
	 * @return true - ���� ���� <br/>false- ���� ����
	 */
	public boolean modifyPosting(TourPlanInfo tourPlan, String memberCode){
		//������ �ڵ带 ������ �� ��, ������ likingInfo�� �ڵ带 �޾ƿ;� ������ �����ϴ�.
		TourPlanDAO tourPlanDAO=new TourPlanDAO();
		TourPlanDTO tourPlanDTO=tourPlanDAO.select(tourPlan.getPostingCode());
		String likingInfoCode=tourPlanDTO.getLikingInfoCode();
		//------------------------------------------------------------------------------------------------
		//�������� ����
		LikingInfo likingInfo=tourPlan.getLikingInfo();
		LikingInfoDAO likingDAO=new LikingInfoDAO();
		if(likingDAO.update(likingInfoCode, likingInfo.getRestaurantPreference(), likingInfo.getHealingPreference(), likingInfo.getAttractionPreference(), likingInfo.getShoppingPreference(), likingInfo.getEtcPreference())){
			//������ ���� ����
			System.out.println("�������� ���� ����");
			PostingDAO postingDAO=new PostingDAO();
			if(postingDAO.update(tourPlan.getPostingCode(), tourPlan.getCategoryCode(), tourPlan.getTitle(), tourPlan.getContent())){
				System.out.println("������ ���� ���� ����");
				//�������� ���� ����
				if( tourPlanDAO.update(tourPlan.getPostingCode(), likingInfoCode, tourPlan.getDestination1(), tourPlan.getDestination2())){
					System.out.println("�������� ���� ���� ����");
					return true;
				}
			}
		}		
		return false;
	}
	/**
	 * ���� �غ� �������� �ʼ� ������ �����Ѵ�<br/>PostingReviseManager���� ���<br/>PostingDAO, TourPreparationDAO�� ���
	 * @param tourPreparation ���� �غ� ������ ����
	 * @return true - ���� ���� <br/>false- ���� ����
	 */
	public boolean modifyPosting(TourPreparationInfo tourPreparation, String memberCode){
		PostingDAO postingDAO=new PostingDAO();
		System.out.println("�����غ� ���� �ʱ�ܰ�!");
		
		if(postingDAO.update(tourPreparation.getPostingCode(), tourPreparation.getCategoryCode(), tourPreparation.getTitle(), tourPreparation.getContent())){
			System.out.println("�Ϲݱ� ������ ����!");
			TourPreparationDAO tourPreparationDAO=new TourPreparationDAO();
			
			ConvertGregorianCalendar convert=new ConvertGregorianCalendar();
			String startDate=convert.convert(tourPreparation.getStartDate());
			String endDate=convert.convert(tourPreparation.getEndDate());
			
			if(tourPreparationDAO.update(tourPreparation.getPostingCode(), tourPreparation.getDestination1(), tourPreparation.getDestination2(), startDate, endDate)){
				System.out.println("�����غ� ����");
				return true;
			}
		}
		return false;
	}
	/**
	 * ������ ã�� �������� �ʼ� ������ �����Ѵ� <br/>PostingReviseManager���� ���<br/>PostingDAO, CompanionRecommendDAO�� ���
	 * @param companionRecommend ������ ã�� ������ ����
	 * @return true - ���� ���� <br/>false- ���� ����
	 */
	public boolean modifyPosting(CompanionRecommendInfo companionRecommend, String memberCode){
		PostingDAO postingDAO=new PostingDAO();
		System.out.println("������ ��õ �ʱ�");
		
		if(postingDAO.update(companionRecommend.getPostingCode(), companionRecommend.getCategoryCode(), companionRecommend.getTitle(), companionRecommend.getContent())){
			System.out.println("�Ϲݱ� ���� ����");
			
			CompanionRecommendDAO companionRecommendDAO=new CompanionRecommendDAO();
			
			ConvertGregorianCalendar convert=new ConvertGregorianCalendar();
			String startDate=convert.convert(companionRecommend.getStartDate());
			String endDate=convert.convert(companionRecommend.getEndDate());
			
			if(companionRecommendDAO.update(companionRecommend.getPostingCode(), companionRecommend.getDestination1(), companionRecommend.getDestination2(), startDate, endDate, companionRecommend.getOtherAge(), companionRecommend.getOtherGender())){
				System.out.println("������ ���� ����^^");
				return true;
			}
		}
		return false;
	}
	/**
	 * ������ �ڵ忡 �ش��ϴ� �������� ��� ������ �����Ѵ� <br/>PostingDeleteManager���� ���<br/> PostingDAO���� ���
	 * @param postingCode ������ �ڵ�
	 * @return true - ���� ���� <br/>false- ���� ����
	 */
	
	public boolean deletePosting(String postingCode, String memberCode){
		return false;
	}
	/**
	 * Ư�� �������� ���ƿ� ���� �Ѱ� ���� ��Ų��. <br/>PostingsDAOManager���� ����ó���� ���� ó���Ѵ�.<br/>PostingDAO�� ����Ѵ�.
	 * @param postingCode ������ �ڵ�
	 * @return true - ���� ����<br/> false - ���� ����
	 */
	public boolean addLikeNum(String postingCode){
		System.out.println("PostingDataDAOManager�� ���� �� �ڵ� ��"+postingCode);
		int likeNum = this.postingDAO.selectLikeNum(postingCode);
		System.out.println("PostingDAO�� ���ƿ�"+likeNum);
		return this.postingDAO.update(postingCode, ++likeNum);
	}
}
