package manager;


import model.PostingInfo;
import model.PostingInfoList;
import model.TourPreparationInfo;
import dbmanager.PostingsDAOManager;
import java.util.*;
/**
 * �����غ� ���ǿ� �´� ������������ �������� �Ŵ���
 * TourPreparationServlet���� ȣ�� 
 * @author ����, ����
 *
 */
public class TourPreparationInfoManager extends PostingManager {
/**
 * null ������ 
 */
	public TourPreparationInfoManager() {
		this(new PostingInfoList());
	}
	/**
	 * ����Ŭ������ ��������������� �ʱ�ȭ���ִ� ������ 
	 * @param postingInfoList ������������� 
	 */
	public TourPreparationInfoManager(PostingInfoList postingInfoList) {
		super(postingInfoList);
		
	}
/**
 * �����غ��������� �̿��Ͽ� ���ǿ� �´� ��� �����غ��������� ��ȯ�Ѵ�. 
 * @param postingInfo ���������� 
 * @return �˻��� ��� ����������
 */
	public List<PostingInfo> check(PostingInfo postingInfo){
		PostingsDAOManager manager = new PostingsDAOManager();
		PostingInfoList list = manager.getTourPreparationRecommends((TourPreparationInfo)postingInfo);
		return list.getPostingInfoList();
	}
/**
 * Ư�� �������� �� ������ �����´�.
 * @param ������ �ڵ�
 * @return ������ �� ����
 */
	public PostingInfo check(String postingCode){
		PostingsDAOManager manager  = new PostingsDAOManager();
		PostingInfo info = manager.getTourPreparationPosting(postingCode);
		return info;
	}
	/**
	 * �������� ���ƿ� ���� 1�� ������Ų��.
	 * @param ������ �ڵ�
	 * @return ������ �� ����
	 */
	public PostingInfo addLikeNum(String postingCode){
		PostingsDAOManager manager = new PostingsDAOManager();
		PostingInfo info = manager.addLikeNum("2", postingCode);
		System.out.println("TourPreparationInfoManage���� - "+info);
		return info;
	}
}
