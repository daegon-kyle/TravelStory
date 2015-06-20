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
 * PostingManager, TourPlanManager, PostingSearchManager에서 사용하는 클래스
 * @author 문정현
 *
 */
public class PostingsDAOManager {
	/**
	 * 여행 일정 포스팅에 대한 정보를 얻기 위한 멤버 변수
	 */
	private TourPlanPostingDAO tourPlanPostingDAO;
	/**
	 * 여행 준비물 포스팅에 대한 정보를 얻기 위한 멤버 변수
	 */
	private TourPreparationPostingDAO tourPreparationPostingDAO;
	/**
	 * 동행자 찾기 포스팅에 대한 정보를 얻기 위한 멤버변수
	 */
	private CompanionSearchPostingDAO companionSearchPostingDAO;
	/**
	 * 일반 글 포스팅에 대한 정보를 얻기 위한 멤버 변수
	 */
	private EtcPostingDAO etcPostingDAO;
	/**
	 * default constructor
	 * <br/> PostingManager, TourPlanManager에서 생성한다
	 */
	public PostingsDAOManager(){
		this.tourPlanPostingDAO = new TourPlanPostingDAO();
		this.tourPreparationPostingDAO = new TourPreparationPostingDAO();
		this.companionSearchPostingDAO = new CompanionSearchPostingDAO();
		this.etcPostingDAO = new EtcPostingDAO();
		
	}
	/**
	 * 각 멤버 변수를 받는 생성자 
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
	 * 특정 키에 대해 제목과 내용에서 검색해서 해당하는 포스팅의 상세정보들을 가져온다.<br/>PostingSearchManager에서 사용
	 * <br/>TourPlanPostingDAO, TourPreparationPostingDAO, CompanionSearchPostingDAO, EtcPostingDAO를 사용
	 * @param key 특정 키워드
	 * @return 포스팅 상세정보들
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
	 * 특정 회원의 포스팅 중 특정 키에 대해 제목과 내용에서 검색해서 해당하는 포스팅의 상세정보들을 가져온다.<br/>PostingSearchManager에서 사용
	 * <br/>TourPlanPostingDAO, TourPreparationPostingDAO, CompanionSearchPostingDAO, EtcPostingDAO를 사용
	 * @param memberCode 멤버 코드
	 * @param key 특정 키워드
	 * @return 포스팅 상세정보들
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
	 * 특정 회원의 포스팅 중 특정 소카테고리에서 작성한 포스팅의 상세정보들을 가져온다. <br/>PostingSearchManager에서 사용
	 * <br/>TourPlanPostingDAO, TourPreparationPostingDAO, CompanionSearchPostingDAO, EtcPostingDAO를 사용
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
	 * 여행일정 포스팅 중 특정 포스팅의 상세 정보를 가져온다. <br/> PostingManager에서 사용<br/> TourPlanPostingDAO를 사용
	 * @param postingCode 포스팅 코드
	 * @return 포스팅 상세정보
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
	 * 여행 준비물 포스팅에서 특정 포스팅의 상세 정보를 가져온다 <br/> TourPreparationManager에서 사용 <br/>TourPreparationPostingDAO를 사용
	 * @param postingCode 포스팅 코드
	 * @return 포스팅 상세 정보
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
	 * 동행자 찾기 포스팅에서 특정 포스팅의 상세정보를 가져온다 <br/> CompanionRecommendManager에서 사용<br/>ComapanionSearchPostingDAO를 사용
	 * @param postingCode 포스팅 코드
	 * @return 포스팅 상세 정보
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
	 * 일반 글 포스팅에서 특정 포스팅의 상세정보를 가져온다. <br/>사용 안함
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
	 * 여행 일정 포스팅 중 조건에 맞는 포스팅의 목록 정보를 가져온다. <br/> TourPlanManager에서 사용 <br/>TourPlanPostingDAO를 사용
	 * @param condition 조건
	 * @return 포스팅 목록
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
		System.out.println("결과 : ");
		System.out.println(result);
		PostingInfoList list = new PostingInfoList();
		//System.out.println("daomanager에서....");
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
	 * 포스팅 준비물 포스팅 중 조건에 맞는 포스팅의 목록 정보를 받아온다 <br/> TourPreparationManager에서 사용 <br/> TourPreparationPostingDAO를 사용
	 * @param condition 조건
	 * @return 포스팅 목록
	 */
	public PostingInfoList getTourPreparationRecommends(TourPreparationInfo condition){
		ConvertGregorianCalendar co = new ConvertGregorianCalendar();
		String destination1 = condition.getDestination1();
		String destination2 = condition.getDestination2();
		PostingInfoList info = new PostingInfoList();
		List<TourPreparationRecommendListDTO> list = null;
		int month = condition.getStartDate().get(Calendar.MONTH)+1;
		if(month==12||month==1||month==2) // 겨울
			list = this.tourPreparationPostingDAO.selectWinterRecommendResultList(destination1, destination2);
		else if(month==3||month==4||month==5)// 봄
			list=this.tourPreparationPostingDAO.selectSpringRecommendResultList(destination1, destination2);
		else if(month==6||month==7||month==8)//여름
			list = this.tourPreparationPostingDAO.selectSummerRecommendResultList(destination1, destination2);
		else if(month==9||month==10||month==11) // 가을
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
	 * 동행자 찾기 포스팅 중 조건에 맞는 포스팅의 목록 정보를 받아온다<br/> CompanionRecommendManager에서 사용 <br/>CompanionSearchPostingDAO를 사용
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
			int reliability = dto.getReliability();  // 원래 PostingInfo의 생성자에는 likeNum이 들어가나 동행자 찾기에서는 좋아요수를 사용하지 않고 회원의 신뢰도를 사용하므로 대체하였다.
			list.addPostingInfo(new PostingInfo(date, writerName, postingCode, reliability, title));
		}
		return list;
	}
	/**
	 * 특정 포스팅의 좋아요 수를 한개 증가 시키고 행당 포스팅의 상세 정보를 가져온다 <br/>PostingManager, TourPlanManager, TourPreparationInfoManager, CompanionRecommendInfoManager에서 사용한다.
	 * <br/>PostingDataDAOManager에게 위임 처리한다.
	 * @param postingPurposeCode 포스팅 목적 코드
	 * @param postingCode 포스팅 코드
	 * @return 포스팅 상세정보
	 */
	public PostingInfo addLikeNum(String postingPurposeCode, String postingCode){
		PostingDataDAOManager manager = new PostingDataDAOManager();
		// 위임 처리
		System.out.println("PostingsDAOManager에 오긴 옴");
		boolean result = manager.addLikeNum(postingCode);
		System.out.println("PostingsDAOManager 572 라인"+result);
		if(result==false) // 수정 실패
			return null;
		System.out.println("오나");
		PostingInfo info = null;
		if(postingPurposeCode.equals("1")){ // 여행 일정 포스팅일 경우(여행 일정 추천 위젯)
			info = getTourPlanPosting(postingCode);
		}
		else if(postingPurposeCode.equals("2")){// 여행 준비물 포스팅일 경우(여행 준비물 추천 위젯){
			info = getTourPreparationPosting(postingCode);
		}
		else if(postingPurposeCode.equals("3")){ // 동행자 찾기 포스팅일 경우 (동행자 찾기 위젯) 
			info = getCompanionPosting(postingCode);
		}
		else if(postingPurposeCode.equals("4")){ // 일반 글 포스팅일 경우
			info = getEtcPosting(postingCode);
		}
		return info;
	}
}
