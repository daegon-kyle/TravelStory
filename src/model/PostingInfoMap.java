package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author ¿µÇÑ
 *
 */
public class PostingInfoMap implements  java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4180137126744387781L;
	private Map<String,List<PostingInfo>> postingMap;
	
	public PostingInfoMap() {
		this(new HashMap<String,List<PostingInfo>>());
	}

	public PostingInfoMap(Map<String,List<PostingInfo>> postingMap) {
		this.postingMap = postingMap;
	}

	public Map<String, List<PostingInfo>> getPostingMap() {
		return postingMap;
	}

	public void setPostingMap(Map<String, List<PostingInfo>> postingMap) {
		this.postingMap = postingMap;
	}
	
	public boolean putPostingInfo(String postingPurposeCode, PostingInfo postingInfo){
		List<PostingInfo> list = postingMap.get(postingPurposeCode);
		list.add(postingInfo);
		if(postingMap.put(postingPurposeCode,list)!= null)
			return true;
		return false;
	}
	
	public PostingInfo deletePostingInfo(String postingPurposeCode, String postingCode){
		List<PostingInfo> list = postingMap.get(postingPurposeCode);
		for(PostingInfo postingInfo : list){
			if(postingInfo.getPostingCode().equals(postingCode)){
				list.remove(postingInfo);
				postingMap.put(postingPurposeCode, list);
				return postingInfo;
			}
		}
		return null;
	}
	
	public PostingInfo deletePostingInfo(String postingCode){
		Collection<List<PostingInfo>> col =  postingMap.values();
		for(List<PostingInfo> list : col){
			for(PostingInfo postingInfo : list){
				if(postingInfo.getPostingCode().equals(postingCode)){
					list.remove(postingInfo);
					postingMap.put(postingInfo.getPostingPurposeCode(),list);
					return postingInfo;
				}
			}
		}
		return null;
	}
	
	public PostingInfo searchPostingInfo(String postingPurposeCode, String postingCode){
		List<PostingInfo> list = postingMap.get(postingPurposeCode);
		for(PostingInfo postingInfo : list){
			if(postingInfo.getPostingCode().equals(postingCode)){
				return postingInfo;
			}
		}
		return null;
	}
	
	public PostingInfo searchPostingInfo(String postingCode){
		Collection<List<PostingInfo>> col = postingMap.values();
		for(List<PostingInfo> list : col){
			for(PostingInfo postingInfo : list){
				if(postingInfo.getPostingCode().equals(postingCode)){
					return postingInfo;
				}
			}
		}
		return null;
	}
	
	public PostingInfo revisePosting(String postingCode, PostingInfo newPostingInfo){
		Collection<List<PostingInfo>> col = postingMap.values();
		for(List<PostingInfo> list : col){
			for(PostingInfo postingInfo : list){
				if(postingInfo.getPostingCode().equals(postingCode)){
					int index = list.indexOf(postingInfo);
					list.remove(index);
					list.add(index,newPostingInfo);
					postingMap.put(postingInfo.getPostingPurposeCode(), list);
					return newPostingInfo;
				}
			}
		}
		return null;
	}

}
