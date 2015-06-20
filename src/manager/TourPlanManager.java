package manager;


import model.PostingInfo;
import java.util.List;
import model.PostingInfoList;
import dbmanager.PostingsDAOManager;
import model.TourPlanInfo;
/**
 * 
 * @author 문정현
 *
 */
public class TourPlanManager extends PostingManager {
	public TourPlanManager(){
		super();
	}
	public TourPlanManager(PostingInfoList postingInfoList){
		super(postingInfoList);
	}
	/**
	 * 사용자가 입력한 조건에 해당하는 포스팅의 기본 정보 목록을 가져온다. <br/>PostingsDAOManager를 사용한다.
	 * @param 사용자가 입력한 조건
	 * @return 포스팅 기본 정보들
	 */
	public List<PostingInfo> check(PostingInfo postingInfo){
		PostingsDAOManager daoManager = new PostingsDAOManager();
		return daoManager.getTourPlanRecommends((TourPlanInfo)postingInfo).getPostingInfoList();
	}
	/**
	 * 특정 포스팅의 상세 정보를 가져온다. <br/> PostingsDAOManager를 사용한다.
	 * @param 포스팅 코드
	 * @return 포스팅 상세 정보
	 */
	public PostingInfo check(String postingCode){
		PostingInfo info = null;
		PostingsDAOManager daoManager = new PostingsDAOManager();
		info = daoManager.getTourPlanPosting(postingCode);
		return info;
	}
	/**
	 * 특정 포스팅의 좋아요 수를 1 증가 시킨다. <br/> PostingsDAOManager를 사용한다.
	 * @param 포스팅 코드
	 * @return 포스팅 상세정보
	 */
	public PostingInfo addLikeNum(String postingCode){
		PostingsDAOManager daoManager = new PostingsDAOManager();
		System.out.println("TourPlanManager의 34라인 "+postingCode);
		PostingInfo info =  daoManager.addLikeNum("1", postingCode); // 여행 일정 포스팅 이므로 포스팅 목적 코드 값에 1를 전달
		System.out.println("TourPlanManager에서 결과 값"+info);
		return info;
	}
}
