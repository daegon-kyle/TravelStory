package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * ���������� ��� ���� Ŭ���� 
 * @author ����
 *
 */
public class PostingInfoList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7852254195179077467L;
	/**
	 * �������������
	 */
	private List<PostingInfo> postingInfoList;
	/**
	 * null ������ 
	 */
	public PostingInfoList() {
		this(new ArrayList<PostingInfo>());
	}
	/**
	 * ��������������� �ʱ�ȭ�ϴ� ������ 
	 * @param postingInfoList ������������� 
	 */
	public PostingInfoList(List<PostingInfo> postingInfoList) {
		this.postingInfoList = postingInfoList;
	}
	/**
	 * ��������������� ��ȯ�Ѵ�. 
	 * @return ������������� 
	 */
	public List<PostingInfo> getPostingInfoList() {
		return postingInfoList;
	}
	/**
	 * ��������������� �����Ѵ�. 
	 * @param postingInfoList �������������
	 */
	public void setPostingInfoList(List<PostingInfo> postingInfoList) {
		this.postingInfoList = postingInfoList;
	}
	/**
	 * �������� �߰��ϱ� ���� �޼ҵ�
	 * @param postingInfo
	 * @return ���������� �߰��Ǹ� true �ƴϸ� false ����
	 */
	public boolean addPostingInfo(PostingInfo postingInfo){
		if(postingInfoList.add(postingInfo))
			return true;
		return false;
	}
	/**
	 * �������� �����ϱ� ���� �޼ҵ� 
	 * @param postingCode �����Ϸ��� �������ڵ� 
	 * @return ������ ���������� ����, �������� ������ null����
	 */
	public PostingInfo deletePostingInfo(String postingCode){
		PostingInfo postingInfo = searchPosting(postingCode);
		if(postingInfo != null){
			postingInfoList.remove(postingInfo);
		}
		return postingInfo;
	}
	/**
	 * ������ �˻��ϱ� ���� �޼ҵ�
	 * @param postingCode �˻��� ������ �ڵ� 
	 * @return �˻��� ���������� , �˻� ���� �� ��� null���� 
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
	 * Ű���带 �̿��Ͽ� �˻� �ϱ� ���� �޼ҵ� ( ����� ������ �˻� ) 
	 * @param keyword �˻��� Ű���� 
	 * @return �˻��� �������� ��� ���� 
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
	 * ������������ �����ϱ� ���� �޼ҵ� 
	 * @param oldPostingInfo ������ ���  
	 * @param newPostingInfo ���ο� ���������� 
	 * @return ������ ���������� ����, �������� ������ null����
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
