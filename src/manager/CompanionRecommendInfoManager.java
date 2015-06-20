package manager;

import model.PostingInfoList;
import model.PostingInfo;
import model.CompanionRecommendInfo;
import java.util.List;
import dbmanager.PostingsDAOManager;
/**
 * 동행자추천정보를 매니저하기 위해 사용하는 클래스
 * @author 대곤, 정현
 *
 */
public class CompanionRecommendInfoManager {
	/**
	 * 포스팅정보목록
	 */
	private PostingInfoList postingInfoList;
/**
 * 널생성자
 */
	public CompanionRecommendInfoManager() {
		this(new PostingInfoList());
	}
	/**
	 * 기본생성자
	 * @param postingInfoList 포스팅정보목록
	 */
	public CompanionRecommendInfoManager(PostingInfoList postingInfoList) {
		this.postingInfoList = postingInfoList;
	}
	/**
	 * 포스팅정보목록을 반환
	 * @return 포스팅정보목록
	 */
	public PostingInfoList getPostingInfoList() {
		return postingInfoList;
	}
	/**
	 * 포스팅정보목록을 설정
	 * @param postingInfoList 포스팅정보목록
	 */
	public void setPostingInfoList(PostingInfoList postingInfoList) {
		this.postingInfoList = postingInfoList;
	}
	/**
	 * DB 접근하여 동행자추천 조건(위젯에서 입력한)에 해당하는 동행자 추천 포스팅 목록 가지고 오기
	 * <br>PostingDAOManager의 getCompanionRecommends메소드 호출
	 * @param companionRecommendInfo 동행자추천정보
	 * @return 동행자추천정보목록 반환
	 */
	public List<PostingInfo> check(PostingInfo postingInfo){
		PostingsDAOManager daoManager = new PostingsDAOManager();
		return daoManager.getCompanionRecommends((CompanionRecommendInfo)postingInfo).getPostingInfoList();
	}
	/**
	 * 특정 포스팅의 상세 정보를 가져온다. <br/>PostingsDAOManager를 사용한다.
	 * @param postingCode 포스팅 코드
	 * @return 포스티의 상세정보
	 */
	public PostingInfo check(String postingCode){
		PostingsDAOManager daoManager = new PostingsDAOManager();
		return daoManager.getCompanionPosting(postingCode);
	}
	/**
	 * 특정 포스팅의 좋아요 수를 1 증가 시킨다. <br/>PostingsDAOManager를 사용한다.
	 * @param postingCode 포스팅 코드
	 * @return 포스팅의 상세정보
	 */
	public PostingInfo addLikeNum(String postingCode){
		PostingsDAOManager daoManager = new PostingsDAOManager();
		return daoManager.addLikeNum("3", postingCode);
	}
}
