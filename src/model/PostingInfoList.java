package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * 포스팅정보 목록 관리 클래스 
 * @author 영한
 *
 */
public class PostingInfoList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7852254195179077467L;
	/**
	 * 포스팅정보목록
	 */
	private List<PostingInfo> postingInfoList;
	/**
	 * null 생성자 
	 */
	public PostingInfoList() {
		this(new ArrayList<PostingInfo>());
	}
	/**
	 * 포스팅정보목록을 초기화하는 생성자 
	 * @param postingInfoList 포스팅정보목록 
	 */
	public PostingInfoList(List<PostingInfo> postingInfoList) {
		this.postingInfoList = postingInfoList;
	}
	/**
	 * 포스팅정보목록을 반환한다. 
	 * @return 포스팅정보목록 
	 */
	public List<PostingInfo> getPostingInfoList() {
		return postingInfoList;
	}
	/**
	 * 포스팅정보목록을 세팅한다. 
	 * @param postingInfoList 포스팅정보목록
	 */
	public void setPostingInfoList(List<PostingInfo> postingInfoList) {
		this.postingInfoList = postingInfoList;
	}
	/**
	 * 포스팅을 추가하기 위한 메소드
	 * @param postingInfo
	 * @return 성공적으로 추가되면 true 아니면 false 리턴
	 */
	public boolean addPostingInfo(PostingInfo postingInfo){
		if(postingInfoList.add(postingInfo))
			return true;
		return false;
	}
	/**
	 * 포스팅을 삭제하기 위한 메소드 
	 * @param postingCode 삭제하려는 포스팅코드 
	 * @return 삭제한 포스팅정보 리턴, 삭제되지 않으면 null리턴
	 */
	public PostingInfo deletePostingInfo(String postingCode){
		PostingInfo postingInfo = searchPosting(postingCode);
		if(postingInfo != null){
			postingInfoList.remove(postingInfo);
		}
		return postingInfo;
	}
	/**
	 * 포스팅 검색하기 위한 메소드
	 * @param postingCode 검색할 포스팅 코드 
	 * @return 검색된 포스팅정보 , 검색 실패 할 경우 null리턴 
	 */
	public PostingInfo searchPosting(String postingCode){
		for(PostingInfo postingInfo : postingInfoList){
			if(postingInfo.getPostingCode().equals(postingCode)){
				return postingInfo;
			}
		}
		return null;
	}
	/**
	 * 키워드를 이용하여 검색 하기 위한 메소드 ( 제목과 내용을 검색 ) 
	 * @param keyword 검색할 키워드 
	 * @return 검색된 포스팅의 목록 리턴 
	 */
	public List<PostingInfo> searchPostingKeyword(String keyword){
		List<PostingInfo> resultList = new ArrayList<PostingInfo>();
		for(PostingInfo postingInfo : postingInfoList){
			if(postingInfo.getTitle().equals(keyword) || postingInfo.getContent().equals(keyword)){
				resultList.add(postingInfo);
			}
		}
		return resultList;		
	}
	/**
	 * 포스팅정보를 수정하기 위한 메소드 
	 * @param oldPostingInfo 수정할 대상  
	 * @param newPostingInfo 새로운 포스팅정보 
	 * @return 수정한 포스팅정보 리턴, 수정되지 않으면 null리턴
	 */
	public PostingInfo revisePosting(PostingInfo oldPostingInfo, PostingInfo newPostingInfo){
		for(PostingInfo postingInfo : postingInfoList){
			if(postingInfo.getPostingCode().equals(oldPostingInfo.getPostingCode())){
				int index = postingInfoList.indexOf(postingInfo);
				postingInfoList.set(index, newPostingInfo);
				return postingInfo;
			}
		}
		return null;
	}
	
	
}
