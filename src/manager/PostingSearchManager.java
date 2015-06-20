package manager;

import java.util.ArrayList;
import java.util.List;

import dbmanager.PostingsDAOManager;

import model.PostingInfo;
import model.PostingInfoList;
/**
 * �����ð˻��� ���� �Ŵ��� Ŭ���� 
 * PostingSearchServlet���� ȣ�� 
 * @author ����
 *
 */
public class PostingSearchManager {
	/**
	 * �˻�Ű���� 
	 */
	private String searchKeyword;
	/**
	 * null������ 
	 */
	public PostingSearchManager() {
		this("");
	}
/**
 * �˻�Ű���带 �ʱ�ȭ���ִ� ������ 
 * @param searchKeyword
 */
	public PostingSearchManager(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	
/**
 * �˻�Ű���带 ��ȯ�Ѵ�.
 * @return �˻�Ű���� 
 */
	public String getSearchKeyword() {
		return searchKeyword;
	}
/**
 * �˻�Ű���带 �����Ѵ�. 
 * @param searchKeyword �˻�Ű���� 
 */
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	/**
	 * �ڽ��� �������߿��� �˻�Ű���带 �̿��Ͽ� �˻��Ѵ�.  
	 * @param memberCode ȸ���ڵ� 
	 * @return �����ø�� 
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
	 * ��ü �����ÿ��� �˻�Ű���带 �̿��Ͽ� �˻��Ѵ�. 
	 * @return �˻��� ������������� 
	 */
	public List<PostingInfo> searchPosting(){
		return null;
	}
}
