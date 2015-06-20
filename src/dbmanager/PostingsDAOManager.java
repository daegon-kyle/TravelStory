package dbmanager;
import dao.CompanionSearchPostingDAO;
import dao.EtcPostingDAO;
import dao.TourPlanPostingDAO;
import dao.TourPreparationPostingDAO;
import dto.TourPreparationPostingDTO;
import dto.CompanionSearchRecommendListDTO;
import dto.TourPreparationRecommendListDTO;
import dto.TourPlanRecommendListDTO;
import dto.CompanionSearchPostingDTO;
import dto.EtcPostingDTO;
import dto.TourPlanPostingDTO;
import model.PostingInfo;
import model.PostingInfoList;
import model.TourPlanInfo;
import model.TourPreparationInfo;
import model.CompanionRecommendInfo;
import model.LikingInfo;

import java.util.Calendar;
import java.util.List;
import java.util.GregorianCalendar;

import converter.ConvertGregorianCalendar;
/**
 * PostingManager, TourPlanManager, PostingSearchManager���� ����ϴ� Ŭ����
 * @author ������
 *
 */
public class PostingsDAOManager {
	/**
	 * ���� ���� �����ÿ� ���� ������ ��� ���� ��� ����
	 */
	private TourPlanPostingDAO tourPlanPostingDAO;
	/**
	 * ���� �غ� �����ÿ� ���� ������ ��� ���� ��� ����
	 */
	private TourPreparationPostingDAO tourPreparationPostingDAO;
	/**
	 * ������ ã�� �����ÿ� ���� ������ ��� ���� �������
	 */
	private CompanionSearchPostingDAO companionSearchPostingDAO;
	/**
	 * �Ϲ� �� �����ÿ� ���� ������ ��� ���� ��� ����
	 */
	private EtcPostingDAO etcPostingDAO;
	/**
	 * default constructor
	 * <br/> PostingManager, TourPlanManager���� �����Ѵ�
	 */
	public PostingsDAOManager(){
		this.tourPlanPostingDAO = new TourPlanPostingDAO();
		this.tourPreparationPostingDAO = new TourPreparationPostingDAO();
		this.companionSearchPostingDAO = new CompanionSearchPostingDAO();
		this.etcPostingDAO = new EtcPostingDAO();
		
	}
	/**
	 * �� ��� ������ �޴� ������ 
	 * @param tourPlanPostingDAO
	 * @param tourPreparationPostingDAO
	 * @param companionSearchPostingDAO
	 * @param etcPostingDAO
	 */
	public PostingsDAOManager(TourPlanPostingDAO tourPlanPostingDAO,
			TourPreparationPostingDAO tourPreparationPostingDAO,
			CompanionSearchPostingDAO companionSearchPostingDAO,
			EtcPostingDAO etcPostingDAO) {
		this.tourPlanPostingDAO = tourPlanPostingDAO;
		this.tourPreparationPostingDAO = tourPreparationPostingDAO;
		this.companionSearchPostingDAO = companionSearchPostingDAO;
		this.etcPostingDAO = etcPostingDAO;
	}
	/**
	 * Ư�� Ű�� ���� ����� ���뿡�� �˻��ؼ� �ش��ϴ� �������� ���������� �����´�.<br/>PostingSearchManager���� ���
	 * <br/>TourPlanPostingDAO, TourPreparationPostingDAO, CompanionSearchPostingDAO, EtcPostingDAO�� ���
	 * @param key Ư�� Ű����
	 * @return ������ ��������
	 */
	public PostingInfoList getPostings(String key){
		PostingInfoList list = new PostingInfoList();
		List<TourPlanPostingDTO> tourPlan = this.tourPlanPostingDAO.selectPostingsAll(key);
		List<TourPreparationPostingDTO> tourPreparation = this.tourPreparationPostingDAO.selectPostingsAll(key);
		List<CompanionSearchPostingDTO> companionSearch = this.companionSearchPostingDAO.selectPostingsAll(key);
		List<EtcPostingDTO> etc = this.etcPostingDAO.selectPostingsAll(key);
		
		int tourPlanNum = tourPlan.size();
		int tourPreparationNum = tourPreparation.size();
		int companionSearchNum = companionSearch.size();
		int etcNum = etc.size();
		int tpIndex =0;
		int tprIndex=0;
		int cIndex=0;
		int eIndex=0;
		
		PostingInfo postingInfo = null;
		ConvertGregorianCalendar co = new ConvertGregorianCalendar();
		
		while(true){
			if(tourPlanNum!=0){
				GregorianCalendar date = co.convert(tourPlan.get(tpIndex).getWritingDate());
				String writerName = tourPlan.get(tpIndex).getWriterName();
				String content = tourPlan.get(tpIndex).getContent();
				String postingCode1 =tourPlan.get(tpIndex).getPostingCode();
				String postingPurposeName = tourPlan.get(tpIndex).getPostingPuposeName();
				int likeNum = tourPlan.get(tpIndex).getLikeNum();
				String title = tourPlan.get(tpIndex).getTitle();
				String subCategoryName = tourPlan.get(tpIndex).getSubCategoryName();
				String destination1 = tourPlan.get(tpIndex).getDestination1();
				String destination2 = tourPlan.get(tpIndex).getDestination2();
				int res = Integer.parseInt(tourPlan.get(tpIndex).getRestaurantPreference());
				int hl = Integer.parseInt(tourPlan.get(tpIndex).getHealingPreference());
				int a = Integer.parseInt(tourPlan.get(tpIndex).getAttractionPreference());
				int s = Integer.parseInt(tourPlan.get(tpIndex).getShoppingPreference());
				int e = Integer.parseInt(tourPlan.get(tpIndex).getEtcPreference());
				LikingInfo liking = new LikingInfo(res, hl, a, s, e);
				postingInfo= new TourPlanInfo(date, writerName, content, postingCode1, postingPurposeName, likeNum, title, subCategoryName, liking, destination1, destination2);
				list.addPostingInfo(postingInfo);
				tpIndex++;
				tourPlanNum--;
			}
			if(tourPreparationNum!=0){
				GregorianCalendar date = co.convert(tourPreparation.get(tprIndex).getWritingDate());
				String writerName = tourPreparation.get(tprIndex).getWriterName();
				String content = tourPreparation.get(tprIndex).getContent();
				String postingCode=tourPreparation.get(tprIndex).getPostingCode();
				String postingPurposeName = tourPreparation.get(tprIndex).getPostingPurposeName();
				int likeNum = tourPreparation.get(tprIndex).getLikeNum();
				String title = tourPreparation.get(tprIndex).getTitle();
				String subCategoryName = tourPreparation.get(tprIndex).getSubCategoryName();
				GregorianCalendar startDate = co.convert(tourPreparation.get(tprIndex).getStartDate());
				GregorianCalendar endDate = co.convert(tourPreparation.get(tprIndex).getEndDate());
				String destination1 = tourPreparation.get(tprIndex).getDestination1();
				String destination2 = tourPreparation.get(tprIndex).getDestination2();
				postingInfo=new TourPreparationInfo(date, writerName, content, postingCode, postingPurposeName, likeNum, title, subCategoryName, startDate, endDate, destination1, destination2);
				list.addPostingInfo(postingInfo);
				tprIndex++;
				tourPreparationNum--;
			}
			if(companionSearchNum!=0){
				GregorianCalendar writingDate = co.convert(companionSearch.get(cIndex).getWritingDate());
				String writerName = companionSearch.get(cIndex).getWriterName();
				String content = companionSearch.get(cIndex).getContent();
				String postingCode = companionSearch.get(cIndex).getPostingCode();
				String postingPurposeName = companionSearch.get(cIndex).getPostingPurposeName();
				int likeNum = 0;
				String title = companionSearch.get(cIndex).getTitle();
				String subCategoryName= companionSearch.get(cIndex).getSubCategoryName();
				int reliability = companionSearch.get(cIndex).getReliability();
				String otherGender = companionSearch.get(cIndex).getOtherGender();
				int otherAge= companionSearch.get(cIndex).getOtherAge();
				String destination1 = companionSearch.get(cIndex).getDestination1();
				String destination2 = companionSearch.get(cIndex).getDestination2();
				GregorianCalendar startDate = co.convert(companionSearch.get(cIndex).getStartDate());
				GregorianCalendar endDate = co.convert(companionSearch.get(cIndex).getEndDate());
				postingInfo = new CompanionRecommendInfo(writingDate, writerName, content, postingCode, postingPurposeName, likeNum, title, subCategoryName, reliability, otherGender, otherAge, destination1, destination2, startDate, endDate);
				list.addPostingInfo(postingInfo);
				cIndex++;
				companionSearchNum--;
			}
			if(etcNum!=0){
				GregorianCalendar writingDate = co.convert(etc.get(eIndex).getWritingDate());
				String writerName = etc.get(eIndex).getWriterName();
				String content = etc.get(eIndex).getContent();
				String postingCode= etc.get(eIndex).getPostingCode();
				String postingPurposeName = etc.get(eIndex).getPostingPurposeName();
				int likeNum = etc.get(eIndex).getLikeNum();
				String title = etc.get(eIndex).getTitle();
				String subCategoryName = etc.get(eIndex).getSubCategoryName();
				postingInfo = new PostingInfo(writingDate, writerName, content, postingCode, postingPurposeName, likeNum, title, subCategoryName);
				list.addPostingInfo(postingInfo);
				eIndex++;
				etcNum--;
			}
			if(tourPlanNum==0&&tourPreparationNum==0&&companionSearchNum==0&&etcNum==0)
				break;
		}
		return list;
		
	}
	/**
	 * Ư�� ȸ���� ������ �� Ư�� Ű�� ���� ����� ���뿡�� �˻��ؼ� �ش��ϴ� �������� ���������� �����´�.<br/>PostingSearchManager���� ���
	 * <br/>TourPlanPostingDAO, TourPreparationPostingDAO, CompanionSearchPostingDAO, EtcPostingDAO�� ���
	 * @param memberCode ��� �ڵ�
	 * @param key Ư�� Ű����
	 * @return ������ ��������
	 */
	public PostingInfoList getPostingsOnlyMember(String memberCode, String key){
		PostingInfoList list = new PostingInfoList();
		List<TourPlanPostingDTO> tourPlan = this.tourPlanPostingDAO.selectPostingsOnlyMember(memberCode, key);
		List<TourPreparationPostingDTO> tourPreparation = this.tourPreparationPostingDAO.selectPostingsOnlyMember(memberCode, key);
		List<CompanionSearchPostingDTO> companionSearch = this.companionSearchPostingDAO.selectPostingsOnlyMember(memberCode, key);
		List<EtcPostingDTO> etc = this.etcPostingDAO.selectPostingsOnlyMember(memberCode, key);
		
		int tourPlanNum = tourPlan.size();
		int tourPreparationNum = tourPreparation.size();
		int companionSearchNum = companionSearch.size();
		int etcNum = etc.size();
		
		System.out.println("PostingsOnlyMember");
		System.out.println(tourPlanNum+" "+tourPreparationNum+" "+companionSearchNum+" "+etcNum);
		
		int tpIndex =0;
		int tprIndex=0;
		int cIndex=0;
		int eIndex=0;
		
		PostingInfo postingInfo = null;
		ConvertGregorianCalendar co = new ConvertGregorianCalendar();
		while(true){
			if(tourPlanNum!=0){
				GregorianCalendar date = co.convert(tourPlan.get(tpIndex).getWritingDate());
				String writerName = tourPlan.get(tpIndex).getWriterName();
				String content = tourPlan.get(tpIndex).getContent();
				String postingCode1 =tourPlan.get(tpIndex).getPostingCode();
				String postingPurposeName = tourPlan.get(tpIndex).getPostingPuposeName();
				int likeNum = tourPlan.get(tpIndex).getLikeNum();
				String title = tourPlan.get(tpIndex).getTitle();
				String subCategoryName = tourPlan.get(tpIndex).getSubCategoryName();
				String destination1 = tourPlan.get(tpIndex).getDestination1();
				String destination2 = tourPlan.get(tpIndex).getDestination2();
				int res = Integer.parseInt(tourPlan.get(tpIndex).getRestaurantPreference());
				int hl = Integer.parseInt(tourPlan.get(tpIndex).getHealingPreference());
				int a = Integer.parseInt(tourPlan.get(tpIndex).getAttractionPreference());
				int s = Integer.parseInt(tourPlan.get(tpIndex).getShoppingPreference());
				int e = Integer.parseInt(tourPlan.get(tpIndex).getEtcPreference());
				LikingInfo liking = new LikingInfo(res, hl, a, s, e);
				postingInfo= new TourPlanInfo(date, writerName, content, postingCode1, postingPurposeName, likeNum, title, subCategoryName, liking, destination1, destination2);
				
				list.addPostingInfo(postingInfo);
				tpIndex++;
				tourPlanNum--;
			}
			if(tourPreparationNum!=0){
				GregorianCalendar date = co.convert(tourPreparation.get(tprIndex).getWritingDate());
				String writerName = tourPreparation.get(tprIndex).getWriterName();
				String content = tourPreparation.get(tprIndex).getContent();
				String postingCode=tourPreparation.get(tprIndex).getPostingCode();
				String postingPurposeName = tourPreparation.get(tprIndex).getPostingPurposeName();
				int likeNum = tourPreparation.get(tprIndex).getLikeNum();
				String title = tourPreparation.get(tprIndex).getTitle();
				String subCategoryName = tourPreparation.get(tprIndex).getSubCategoryName();
				GregorianCalendar startDate = co.convert(tourPreparation.get(tprIndex).getStartDate());
				GregorianCalendar endDate = co.convert(tourPreparation.get(tprIndex).getEndDate());
				String destination1 = tourPreparation.get(tprIndex).getDestination1();
				String destination2 = tourPreparation.get(tprIndex).getDestination2();
				postingInfo=new TourPreparationInfo(date, writerName, content, postingCode, postingPurposeName, likeNum, title, subCategoryName, startDate, endDate, destination1, destination2);
				
				list.addPostingInfo(postingInfo);
				tprIndex++;
				tourPreparationNum--;
			}
			if(companionSearchNum!=0){
				GregorianCalendar writingDate = co.convert(companionSearch.get(cIndex).getWritingDate());
				String writerName = companionSearch.get(cIndex).getWriterName();
				String content = companionSearch.get(cIndex).getContent();
				String postingCode = companionSearch.get(cIndex).getPostingCode();
				String postingPurposeName = companionSearch.get(cIndex).getPostingPurposeName();
				int likeNum = 0;
				String title = companionSearch.get(cIndex).getTitle();
				String subCategoryName= companionSearch.get(cIndex).getSubCategoryName();
				int reliability = companionSearch.get(cIndex).getReliability();
				String otherGender = companionSearch.get(cIndex).getOtherGender();
				int otherAge= companionSearch.get(cIndex).getOtherAge();
				String destination1 = companionSearch.get(cIndex).getDestination1();
				String destination2 = companionSearch.get(cIndex).getDestination2();
				GregorianCalendar startDate = co.convert(companionSearch.get(cIndex).getStartDate());
				GregorianCalendar endDate = co.convert(companionSearch.get(cIndex).getEndDate());
				postingInfo = new CompanionRecommendInfo(writingDate, writerName, content, postingCode, postingPurposeName, likeNum, title, subCategoryName, reliability, otherGender, otherAge, destination1, destination2, startDate, endDate);
				
				list.addPostingInfo(postingInfo);
				cIndex++;
				companionSearchNum--;
			}
			if(etcNum!=0){
				GregorianCalendar writingDate = co.convert(etc.get(eIndex).getWritingDate());
				String writerName = etc.get(eIndex).getWriterName();
				String content = etc.get(eIndex).getContent();
				String postingCode= etc.get(eIndex).getPostingCode();
				String postingPurposeName = etc.get(eIndex).getPostingPurposeName();
				int likeNum = etc.get(eIndex).getLikeNum();
				String title = etc.get(eIndex).getTitle();
				String subCategoryName = etc.get(eIndex).getSubCategoryName();
				postingInfo = new PostingInfo(writingDate, writerName, content, postingCode, postingPurposeName, likeNum, title, subCategoryName);
				
				list.addPostingInfo(postingInfo);
				eIndex++;
				etcNum--;
			}
			if(tourPlanNum==0&&tourPreparationNum==0&&companionSearchNum==0&&etcNum==0)
				break;
		}
		return list;
	}
	/**
	 * Ư�� ȸ���� ������ �� Ư�� ��ī�װ����� �ۼ��� �������� ���������� �����´�. <br/>PostingSearchManager���� ���
	 * <br/>TourPlanPostingDAO, TourPreparationPostingDAO, CompanionSearchPostingDAO, EtcPostingDAO�� ���
	 * @param memberCode
	 * @param subCategoryCode
	 * @return
	 */
	public PostingInfoList getPostings(String memberCode, String subCategoryCode){
		PostingInfoList list = new PostingInfoList();
		List<TourPlanPostingDTO> tourPlan = this.tourPlanPostingDAO.selectPostings(memberCode, subCategoryCode);
		List<TourPreparationPostingDTO> tourPreparation = this.tourPreparationPostingDAO.selectPostings(memberCode, subCategoryCode);
		List<CompanionSearchPostingDTO> companionSearch = this.companionSearchPostingDAO.selectPostings(memberCode, subCategoryCode);
		List<EtcPostingDTO> etc = this.etcPostingDAO.selectPostings(memberCode, subCategoryCode);
		
		int tourPlanNum = tourPlan.size();
		int tourPreparationNum = tourPlan.size();
		int companionSearchNum = companionSearch.size();
		int etcNum = etc.size();
		int tpIndex =0;
		int tprIndex=0;
		int cIndex=0;
		int eIndex=0;
		
		PostingInfo postingInfo = null;
		ConvertGregorianCalendar co = new ConvertGregorianCalendar();
		
		while(true){
			if(tourPlanNum!=0){
				GregorianCalendar date = co.convert(tourPlan.get(tpIndex).getWritingDate());
				String writerName = tourPlan.get(tpIndex).getWriterName();
				String content = tourPlan.get(tpIndex).getContent();
				String postingCode1 =tourPlan.get(tpIndex).getPostingCode();
				String postingPurposeName = tourPlan.get(tpIndex).getPostingPuposeName();
				int likeNum = tourPlan.get(tpIndex).getLikeNum();
				String title = tourPlan.get(tpIndex).getTitle();
				String subCategoryName = tourPlan.get(tpIndex).getSubCategoryName();
				String destination1 = tourPlan.get(tpIndex).getDestination1();
				String destination2 = tourPlan.get(tpIndex).getDestination2();
				int res = Integer.parseInt(tourPlan.get(tpIndex).getRestaurantPreference());
				int hl = Integer.parseInt(tourPlan.get(tpIndex).getHealingPreference());
				int a = Integer.parseInt(tourPlan.get(tpIndex).getAttractionPreference());
				int s = Integer.parseInt(tourPlan.get(tpIndex).getShoppingPreference());
				int e = Integer.parseInt(tourPlan.get(tpIndex).getEtcPreference());
				LikingInfo liking = new LikingInfo(res, hl, a, s, e);
				postingInfo= new TourPlanInfo(date, writerName, content, postingCode1, postingPurposeName, likeNum, title, subCategoryName, liking, destination1, destination2);
				list.addPostingInfo(postingInfo);
				tpIndex++;
				tourPlanNum--;
			}
			if(tourPreparationNum!=0){
				GregorianCalendar date = co.convert(tourPreparation.get(tprIndex).getWritingDate());
				String writerName = tourPreparation.get(tprIndex).getWriterName();
				String content = tourPreparation.get(tprIndex).getContent();
				String postingCode=tourPreparation.get(tprIndex).getPostingCode();
				String postingPurposeName = tourPreparation.get(tprIndex).getPostingPurposeName();
				int likeNum = tourPreparation.get(tprIndex).getLikeNum();
				String title = tourPreparation.get(tprIndex).getTitle();
				String subCategoryName = tourPreparation.get(tprIndex).getSubCategoryName();
				GregorianCalendar startDate = co.convert(tourPreparation.get(tprIndex).getStartDate());
				GregorianCalendar endDate = co.convert(tourPreparation.get(tprIndex).getEndDate());
				String destination1 = tourPreparation.get(tprIndex).getDestination1();
				String destination2 = tourPreparation.get(tprIndex).getDestination2();
				postingInfo=new TourPreparationInfo(date, writerName, content, postingCode, postingPurposeName, likeNum, title, subCategoryName, startDate, endDate, destination1, destination2);
				list.addPostingInfo(postingInfo);
				tprIndex++;
				tourPreparationNum--;
			}
			if(companionSearchNum!=0){
				GregorianCalendar writingDate = co.convert(companionSearch.get(cIndex).getWritingDate());
				String writerName = companionSearch.get(cIndex).getWriterName();
				String content = companionSearch.get(cIndex).getContent();
				String postingCode = companionSearch.get(cIndex).getPostingCode();
				String postingPurposeName = companionSearch.get(cIndex).getPostingPurposeName();
				int likeNum = 0;
				String title = companionSearch.get(cIndex).getTitle();
				String subCategoryName= companionSearch.get(cIndex).getSubCategoryName();
				int reliability = companionSearch.get(cIndex).getReliability();
				String otherGender = companionSearch.get(cIndex).getOtherGender();
				int otherAge= companionSearch.get(cIndex).getOtherAge();
				String destination1 = companionSearch.get(cIndex).getDestination1();
				String destination2 = companionSearch.get(cIndex).getDestination2();
				GregorianCalendar startDate = co.convert(companionSearch.get(cIndex).getStartDate());
				GregorianCalendar endDate = co.convert(companionSearch.get(cIndex).getEndDate());
				postingInfo = new CompanionRecommendInfo(writingDate, writerName, content, postingCode, postingPurposeName, likeNum, title, subCategoryName, reliability, otherGender, otherAge, destination1, destination2, startDate, endDate);
				list.addPostingInfo(postingInfo);
				cIndex++;
				companionSearchNum--;
			}
			if(etcNum!=0){
				GregorianCalendar writingDate = co.convert(etc.get(eIndex).getWritingDate());
				String writerName = etc.get(eIndex).getWriterName();
				String content = etc.get(eIndex).getContent();
				String postingCode= etc.get(eIndex).getPostingCode();
				String postingPurposeName = etc.get(eIndex).getPostingPurposeName();
				int likeNum = etc.get(eIndex).getLikeNum();
				String title = etc.get(eIndex).getTitle();
				String subCategoryName = etc.get(eIndex).getSubCategoryName();
				postingInfo = new PostingInfo(writingDate, writerName, content, postingCode, postingPurposeName, likeNum, title, subCategoryName);
				list.addPostingInfo(postingInfo);
				eIndex++;
				etcNum--;
			}
			if(tourPlanNum==0&&tourPreparationNum==0&&companionSearchNum==0&&etcNum==0)
				break;
		}
		return list;
	}
	/**
	 * �������� ������ �� Ư�� �������� �� ������ �����´�. <br/> PostingManager���� ���<br/> TourPlanPostingDAO�� ���
	 * @param postingCode ������ �ڵ�
	 * @return ������ ������
	 */
	public PostingInfo getTourPlanPosting(String postingCode){
		TourPlanPostingDTO tourPlan=this.tourPlanPostingDAO.selectPosting(postingCode);
		ConvertGregorianCalendar co = new ConvertGregorianCalendar();
		GregorianCalendar date = co.convert(tourPlan.getWritingDate());
		String writerName = tourPlan.getWriterName();
		String content = tourPlan.getContent();
		String postingCode1 =tourPlan.getPostingCode();
		String postingPurposeName = tourPlan.getPostingPuposeName();
		int likeNum = tourPlan.getLikeNum();
		String title = tourPlan.getTitle();
		String subCategoryName = tourPlan.getSubCategoryName();
		String destination1 = tourPlan.getDestination1();
		String destination2 = tourPlan.getDestination2();
		int res = Integer.parseInt(tourPlan.getRestaurantPreference());
		int hl = Integer.parseInt(tourPlan.getHealingPreference());
		int a = Integer.parseInt(tourPlan.getAttractionPreference());
		int s = Integer.parseInt(tourPlan.getShoppingPreference());
		int e = Integer.parseInt(tourPlan.getEtcPreference());
		LikingInfo liking = new LikingInfo(res, hl, a, s, e);
		return new TourPlanInfo(date, writerName, content, postingCode1, postingPurposeName, likeNum, title, subCategoryName, liking, destination1, destination2);
	}
	/**
	 * ���� �غ� �����ÿ��� Ư�� �������� �� ������ �����´� <br/> TourPreparationManager���� ��� <br/>TourPreparationPostingDAO�� ���
	 * @param postingCode ������ �ڵ�
	 * @return ������ �� ����
	 */
	public PostingInfo getTourPreparationPosting(String postingCode){
		TourPreparationPostingDTO tourPreparation = this.tourPreparationPostingDAO.selectPosting(postingCode);
		ConvertGregorianCalendar co = new ConvertGregorianCalendar();
		GregorianCalendar date = co.convert(tourPreparation.getWritingDate());
		String writerName = tourPreparation.getWriterName();
		String content = tourPreparation.getContent();
		String postingCode1=tourPreparation.getPostingCode();
		String postingPurposeName = tourPreparation.getPostingPurposeName();
		int likeNum = tourPreparation.getLikeNum();
		String title = tourPreparation.getTitle();
		String subCategoryName = tourPreparation.getSubCategoryName();
		GregorianCalendar startDate = co.convert(tourPreparation.getStartDate());
		GregorianCalendar endDate = co.convert(tourPreparation.getEndDate());
		String destination1 = tourPreparation.getDestination1();
		String destination2 = tourPreparation.getDestination2();
		return new TourPreparationInfo(date, writerName, content, postingCode1, postingPurposeName, likeNum, title, subCategoryName, startDate, endDate, destination1, destination2);
	}
	/**
	 * ������ ã�� �����ÿ��� Ư�� �������� �������� �����´� <br/> CompanionRecommendManager���� ���<br/>ComapanionSearchPostingDAO�� ���
	 * @param postingCode ������ �ڵ�
	 * @return ������ �� ����
	 */
	public PostingInfo getCompanionPosting(String postingCode){
		CompanionSearchPostingDTO companionSearch = this.companionSearchPostingDAO.selectPosting(postingCode);
		ConvertGregorianCalendar co = new ConvertGregorianCalendar();
		GregorianCalendar writingDate = co.convert(companionSearch.getWritingDate());
		String writerName = companionSearch.getWriterName();
		String content = companionSearch.getContent();
		String postingCode1 = companionSearch.getPostingCode();
		String postingPurposeName = companionSearch.getPostingPurposeName();
		int likeNum = 0;
		String title = companionSearch.getTitle();
		String subCategoryName= companionSearch.getSubCategoryName();
		int reliability = companionSearch.getReliability();
		String otherGender = companionSearch.getOtherGender();
		int otherAge= companionSearch.getOtherAge();
		String destination1 = companionSearch.getDestination1();
		String destination2 = companionSearch.getDestination2();
		GregorianCalendar startDate = co.convert(companionSearch.getStartDate());
		GregorianCalendar endDate = co.convert(companionSearch.getEndDate());
		return new CompanionRecommendInfo(writingDate, writerName, content, postingCode1, postingPurposeName, likeNum, title, subCategoryName, reliability, otherGender, otherAge, destination1, destination2, startDate, endDate);
	}
	/**
	 * �Ϲ� �� �����ÿ��� Ư�� �������� �������� �����´�. <br/>��� ����
	 * @param postingCode
	 * @return
	 */
	public PostingInfo getEtcPosting(String postingCode){
		EtcPostingDTO etc = this.etcPostingDAO.selectPosting(postingCode);
		ConvertGregorianCalendar co = new ConvertGregorianCalendar();
		GregorianCalendar writingDate = co.convert(etc.getWritingDate());
		String writerName = etc.getWriterName();
		String content = etc.getContent();
		String postingCode1= etc.getPostingCode();
		String postingPurposeName = etc.getPostingPurposeName();
		int likeNum = etc.getLikeNum();
		String title = etc.getTitle();
		String subCategoryName = etc.getSubCategoryName();
		return new PostingInfo(writingDate, writerName, content, postingCode1, postingPurposeName, likeNum, title, subCategoryName);
	}
	/**
	 * ���� ���� ������ �� ���ǿ� �´� �������� ��� ������ �����´�. <br/> TourPlanManager���� ��� <br/>TourPlanPostingDAO�� ���
	 * @param condition ����
	 * @return ������ ���
	 */
	public PostingInfoList getTourPlanRecommends(TourPlanInfo condition){
		ConvertGregorianCalendar convert = new ConvertGregorianCalendar();
		String destination1 = condition.getDestination1();
		System.out.println("destination1"+destination1);
		String destination2 = condition.getDestination2();
		System.out.println("desination2"+destination2);
		LikingInfo like = condition.getLikingInfo();
		//System.out.println(like);
		List<TourPlanRecommendListDTO> result = this.tourPlanPostingDAO.selectRecommendResultList(destination1, destination2, like.getRestaurantPreference(), like.getHealingPreference(), like.getAttractionPreference(), like.getShoppingPreference(), like.getEtcPreference() );
		System.out.println("��� : ");
		System.out.println(result);
		PostingInfoList list = new PostingInfoList();
		//System.out.println("daomanager����....");
		for(TourPlanRecommendListDTO dto : result){
			String postingCode = dto.getPostingCode();
			String title = dto.getTitle();
			GregorianCalendar date = convert.convert(dto.getWritingDate());
			String name = dto.getWriterName();
			int likeNum = dto.getLikeNum();
			System.out.println(postingCode+", "+title+", "+date+", "+name+", "+likeNum+", ");
			list.addPostingInfo(new PostingInfo(date, name, postingCode, likeNum, title));
		}
		return list;
	}
	/**
	 * ������ �غ� ������ �� ���ǿ� �´� �������� ��� ������ �޾ƿ´� <br/> TourPreparationManager���� ��� <br/> TourPreparationPostingDAO�� ���
	 * @param condition ����
	 * @return ������ ���
	 */
	public PostingInfoList getTourPreparationRecommends(TourPreparationInfo condition){
		ConvertGregorianCalendar co = new ConvertGregorianCalendar();
		String destination1 = condition.getDestination1();
		String destination2 = condition.getDestination2();
		PostingInfoList info = new PostingInfoList();
		List<TourPreparationRecommendListDTO> list = null;
		int month = condition.getStartDate().get(Calendar.MONTH)+1;
		if(month==12||month==1||month==2) // �ܿ�
			list = this.tourPreparationPostingDAO.selectWinterRecommendResultList(destination1, destination2);
		else if(month==3||month==4||month==5)// ��
			list=this.tourPreparationPostingDAO.selectSpringRecommendResultList(destination1, destination2);
		else if(month==6||month==7||month==8)//����
			list = this.tourPreparationPostingDAO.selectSummerRecommendResultList(destination1, destination2);
		else if(month==9||month==10||month==11) // ����
			list = this.tourPreparationPostingDAO.selectFallRecommendResultList(destination1, destination2);
		for(TourPreparationRecommendListDTO dto : list){
			String postingCode = dto.getPostingCode();
			String title = dto.getTitle();
			GregorianCalendar date = co.convert(dto.getWritingDate());
			String writerName = dto.getWriterName();
			int likeNum = dto.getLikeNum();
			info.addPostingInfo(new PostingInfo(date, writerName, postingCode, likeNum, title));
		}
		return info;
	}
	/**
	 * ������ ã�� ������ �� ���ǿ� �´� �������� ��� ������ �޾ƿ´�<br/> CompanionRecommendManager���� ��� <br/>CompanionSearchPostingDAO�� ���
	 * @param condition
	 * @return
	 */
	public PostingInfoList getCompanionRecommends(CompanionRecommendInfo condition){
		ConvertGregorianCalendar co = new ConvertGregorianCalendar();
		String destination1 = condition.getDestination1();
		String destination2 = condition.getDestination2();
		String startDate = co.convert(condition.getStartDate());
		String endDate = co.convert(condition.getEndDate());
		String gender = condition.getOtherGender();
		int age = condition.getOtherAge();
		PostingInfoList list= new PostingInfoList();
		List<CompanionSearchRecommendListDTO> result = this.companionSearchPostingDAO.selectRecommendResultList(destination1, destination2, startDate, endDate, gender, age);
		for(CompanionSearchRecommendListDTO dto : result){
			String postingCode = dto.getPostingCode();
			String title = dto.getTitle();
			GregorianCalendar date = co.convert(dto.getWritingDate());
			String writerName = dto.getWriterName();
			int reliability = dto.getReliability();  // ���� PostingInfo�� �����ڿ��� likeNum�� ���� ������ ã�⿡���� ���ƿ���� ������� �ʰ� ȸ���� �ŷڵ��� ����ϹǷ� ��ü�Ͽ���.
			list.addPostingInfo(new PostingInfo(date, writerName, postingCode, reliability, title));
		}
		return list;
	}
	/**
	 * Ư�� �������� ���ƿ� ���� �Ѱ� ���� ��Ű�� ��� �������� �� ������ �����´� <br/>PostingManager, TourPlanManager, TourPreparationInfoManager, CompanionRecommendInfoManager���� ����Ѵ�.
	 * <br/>PostingDataDAOManager���� ���� ó���Ѵ�.
	 * @param postingPurposeCode ������ ���� �ڵ�
	 * @param postingCode ������ �ڵ�
	 * @return ������ ������
	 */
	public PostingInfo addLikeNum(String postingPurposeCode, String postingCode){
		PostingDataDAOManager manager = new PostingDataDAOManager();
		// ���� ó��
		System.out.println("PostingsDAOManager�� ���� ��");
		boolean result = manager.addLikeNum(postingCode);
		System.out.println("PostingsDAOManager 572 ����"+result);
		if(result==false) // ���� ����
			return null;
		System.out.println("����");
		PostingInfo info = null;
		if(postingPurposeCode.equals("1")){ // ���� ���� �������� ���(���� ���� ��õ ����)
			info = getTourPlanPosting(postingCode);
		}
		else if(postingPurposeCode.equals("2")){// ���� �غ� �������� ���(���� �غ� ��õ ����){
			info = getTourPreparationPosting(postingCode);
		}
		else if(postingPurposeCode.equals("3")){ // ������ ã�� �������� ��� (������ ã�� ����) 
			info = getCompanionPosting(postingCode);
		}
		else if(postingPurposeCode.equals("4")){ // �Ϲ� �� �������� ���
			info = getEtcPosting(postingCode);
		}
		return info;
	}
}
