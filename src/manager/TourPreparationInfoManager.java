package manager;


import model.PostingInfo;
import model.PostingInfoList;
import model.TourPreparationInfo;
import dbmanager.PostingsDAOManager;
import java.util.*;
/**
 * 여행준비물 조건에 맞는 포스팅정보를 가져오는 매니저
 * TourPreparationServlet에서 호출 
 * @author 영한, 정현
 *
 */
public class TourPreparationInfoManager extends PostingManager {
/**
 * null 생성자 
 */
	public TourPreparationInfoManager() {
		this(new PostingInfoList());
	}
	/**
	 * 슈퍼클래스의 포스팅정보목록을 초기화해주는 생성자 
	 * @param postingInfoList 포스팅정보목록 
	 */
	public TourPreparationInfoManager(PostingInfoList postingInfoList) {
		super(postingInfoList);
		
	}
/**
 * 여행준비물포스팅을 이용하여 조건에 맞는 모든 여행준비물포스팅을 반환한다. 
 * @param postingInfo 포스팅정보 
 * @return 검색된 모든 포스팅정보
 */
	public List<PostingInfo> check(PostingInfo postingInfo){
		PostingsDAOManager manager = new PostingsDAOManager();
		PostingInfoList list = manager.getTourPreparationRecommends((TourPreparationInfo)postingInfo);
		return list.getPostingInfoList();
	}
/**
 * 특정 포스팅의 상세 정보를 가져온다.
 * @param 포스팅 코드
 * @return 포스팅 상세 정보
 */
	public PostingInfo check(String postingCode){
		PostingsDAOManager manager  = new PostingsDAOManager();
		PostingInfo info = manager.getTourPreparationPosting(postingCode);
		return info;
	}
	/**
	 * 포스팅의 좋아요 수를 1개 증가시킨다.
	 * @param 포스팅 코드
	 * @return 포스팅 상세 정보
	 */
	public PostingInfo addLikeNum(String postingCode){
		PostingsDAOManager manager = new PostingsDAOManager();
		PostingInfo info = manager.addLikeNum("2", postingCode);
		System.out.println("TourPreparationInfoManage에서 - "+info);
		return info;
	}
}
