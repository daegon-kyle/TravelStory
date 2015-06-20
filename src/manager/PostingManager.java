package manager;
import model.PostingInfoList;
import model.PostingInfo;
import java.util.List;

import dao.PostingDAO;
import dbmanager.PostingDataDAOManager;
import dbmanager.PostingsDAOManager;
/**
 * 포스팅 조건을 입력하고 데이터베이스에서 해당하는 포스팅을 가져오는 매니저클래스 
 * 추천받기 서블릿에서 호출
 * @author 영한
 *
 */
public class PostingManager {
	/**
	 * 포스팅정보목록
	 */
	private PostingInfoList postingInfoList;
	/**
	 * null생성자 
	 */
	public PostingManager(){
		this.postingInfoList = new PostingInfoList();
	}
	/**
	 * 포스팅정보목록을 초기화하는 생성자 
	 * @param postingInfoList 포스팅정보목록 
	 */
	public PostingManager(PostingInfoList postingInfoList){
		this.postingInfoList=postingInfoList;
	}
	/**
	 * 포스팅조건을 입력하면 데이터베이스에서 포스팅정보를 가져온다.
	 * <br> EXAMPLE : 포스팅정보의 제목과 일치하는 모든 포스팅정보를 목록형태로 반환한다. 
	 * @param postingInfo 포스팅정보
	 * @return 포스팅정보목록 
	 */
	public List<PostingInfo> check(PostingInfo postingInfo){
		// 필요 없으므로 구현 안함
		return null;
	}
	/**
	 * 포스팅추천하고 상세보기기능을 위해 포스팅 코드를 이용하여 데이터베이스에서 포스팅정보를 가져온다. 
	 * @param postingCode 포스팅코드 
	 * @return 포스팅정보
	 */
	public PostingInfo check(String postingCode){
		PostingDataDAOManager postingDataDAOManager=new PostingDataDAOManager();
		PostingInfo postingInfo=postingDataDAOManager.getPosting(postingCode);
		return postingInfo;
	}
	public PostingInfo addLikeNum(String postingCode){
		// 각 자식 클래스의 addLikeNum(String postingCode)를 사용하기 위해 있음
		System.out.println("얍");
		return null;
	}
}
