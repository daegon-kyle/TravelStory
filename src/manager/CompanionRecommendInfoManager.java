package manager;

import model.PostingInfoList;
import model.PostingInfo;
import model.CompanionRecommendInfo;
import java.util.List;
import dbmanager.PostingsDAOManager;
/**
 * ��������õ������ �Ŵ����ϱ� ���� ����ϴ� Ŭ����
 * @author ���, ����
 *
 */
public class CompanionRecommendInfoManager {
	/**
	 * �������������
	 */
	private PostingInfoList postingInfoList;
/**
 * �λ�����
 */
	public CompanionRecommendInfoManager() {
		this(new PostingInfoList());
	}
	/**
	 * �⺻������
	 * @param postingInfoList �������������
	 */
	public CompanionRecommendInfoManager(PostingInfoList postingInfoList) {
		this.postingInfoList = postingInfoList;
	}
	/**
	 * ��������������� ��ȯ
	 * @return �������������
	 */
	public PostingInfoList getPostingInfoList() {
		return postingInfoList;
	}
	/**
	 * ��������������� ����
	 * @param postingInfoList �������������
	 */
	public void setPostingInfoList(PostingInfoList postingInfoList) {
		this.postingInfoList = postingInfoList;
	}
	/**
	 * DB �����Ͽ� ��������õ ����(�������� �Է���)�� �ش��ϴ� ������ ��õ ������ ��� ������ ����
	 * <br>PostingDAOManager�� getCompanionRecommends�޼ҵ� ȣ��
	 * @param companionRecommendInfo ��������õ����
	 * @return ��������õ������� ��ȯ
	 */
	public List<PostingInfo> check(PostingInfo postingInfo){
		PostingsDAOManager daoManager = new PostingsDAOManager();
		return daoManager.getCompanionRecommends((CompanionRecommendInfo)postingInfo).getPostingInfoList();
	}
	/**
	 * Ư�� �������� �� ������ �����´�. <br/>PostingsDAOManager�� ����Ѵ�.
	 * @param postingCode ������ �ڵ�
	 * @return ����Ƽ�� ������
	 */
	public PostingInfo check(String postingCode){
		PostingsDAOManager daoManager = new PostingsDAOManager();
		return daoManager.getCompanionPosting(postingCode);
	}
	/**
	 * Ư�� �������� ���ƿ� ���� 1 ���� ��Ų��. <br/>PostingsDAOManager�� ����Ѵ�.
	 * @param postingCode ������ �ڵ�
	 * @return �������� ������
	 */
	public PostingInfo addLikeNum(String postingCode){
		PostingsDAOManager daoManager = new PostingsDAOManager();
		return daoManager.addLikeNum("3", postingCode);
	}
}
