package manager;


import model.PostingInfo;
import java.util.List;
import model.PostingInfoList;
import dbmanager.PostingsDAOManager;
import model.TourPlanInfo;
/**
 * 
 * @author ������
 *
 */
public class TourPlanManager extends PostingManager {
	public TourPlanManager(){
		super();
	}
	public TourPlanManager(PostingInfoList postingInfoList){
		super(postingInfoList);
	}
	/**
	 * ����ڰ� �Է��� ���ǿ� �ش��ϴ� �������� �⺻ ���� ����� �����´�. <br/>PostingsDAOManager�� ����Ѵ�.
	 * @param ����ڰ� �Է��� ����
	 * @return ������ �⺻ ������
	 */
	public List<PostingInfo> check(PostingInfo postingInfo){
		PostingsDAOManager daoManager = new PostingsDAOManager();
		return daoManager.getTourPlanRecommends((TourPlanInfo)postingInfo).getPostingInfoList();
	}
	/**
	 * Ư�� �������� �� ������ �����´�. <br/> PostingsDAOManager�� ����Ѵ�.
	 * @param ������ �ڵ�
	 * @return ������ �� ����
	 */
	public PostingInfo check(String postingCode){
		PostingInfo info = null;
		PostingsDAOManager daoManager = new PostingsDAOManager();
		info = daoManager.getTourPlanPosting(postingCode);
		return info;
	}
	/**
	 * Ư�� �������� ���ƿ� ���� 1 ���� ��Ų��. <br/> PostingsDAOManager�� ����Ѵ�.
	 * @param ������ �ڵ�
	 * @return ������ ������
	 */
	public PostingInfo addLikeNum(String postingCode){
		PostingsDAOManager daoManager = new PostingsDAOManager();
		System.out.println("TourPlanManager�� 34���� "+postingCode);
		PostingInfo info =  daoManager.addLikeNum("1", postingCode); // ���� ���� ������ �̹Ƿ� ������ ���� �ڵ� ���� 1�� ����
		System.out.println("TourPlanManager���� ��� ��"+info);
		return info;
	}
}
