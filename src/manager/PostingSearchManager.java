package manager;

import java.util.ArrayList;
import java.util.List;

import dbmanager.PostingsDAOManager;

import model.PostingInfo;
import model.PostingInfoList;
/**
 * 포스팅검색을 위한 매니저 클래스 
 * PostingSearchServlet에서 호출 
 * @author 영한
 *
 */
public class PostingSearchManager {
	/**
	 * 검색키워드 
	 */
	private String searchKeyword;
	/**
	 * null생성자 
	 */
	public PostingSearchManager() {
		this("");
	}
/**
 * 검색키워드를 초기화해주는 생성자 
 * @param searchKeyword
 */
	public PostingSearchManager(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	
/**
 * 검색키워드를 반환한다.
 * @return 검색키워드 
 */
	public String getSearchKeyword() {
		return searchKeyword;
	}
/**
 * 검색키워드를 세팅한다. 
 * @param searchKeyword 검색키워드 
 */
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	/**
	 * 자신의 포스팅중에서 검색키워드를 이용하여 검색한다.  
	 * @param memberCode 회원코드 
	 * @return 포스팅목록 
	 */
	public List<PostingInfo> searchPosting(String memberCode){
		PostingsDAOManager postingsDAOManager=new PostingsDAOManager();
		PostingInfoList postingInfoList=postingsDAOManager.getPostingsOnlyMember(memberCode, searchKeyword);
		
		ArrayList<PostingInfo> postingList=(ArrayList<PostingInfo>)postingInfoList.getPostingInfoList();
		for(PostingInfo tmp : postingList){
			System.out.println(tmp.getTitle());
		}
		return postingList;
	}
	/**
	 * 전체 포스팅에서 검색키워드를 이용하여 검색한다. 
	 * @return 검색된 포스팅정보목록 
	 */
	public List<PostingInfo> searchPosting(){
		return null;
	}
}
