package manager;
import model.PostingInfoList;
import model.PostingInfo;
import java.util.List;

import dao.PostingDAO;
import dbmanager.PostingDataDAOManager;
import dbmanager.PostingsDAOManager;
/**
 * ������ ������ �Է��ϰ� �����ͺ��̽����� �ش��ϴ� �������� �������� �Ŵ���Ŭ���� 
 * ��õ�ޱ� �������� ȣ��
 * @author ����
 *
 */
public class PostingManager {
	/**
	 * �������������
	 */
	private PostingInfoList postingInfoList;
	/**
	 * null������ 
	 */
	public PostingManager(){
		this.postingInfoList = new PostingInfoList();
	}
	/**
	 * ��������������� �ʱ�ȭ�ϴ� ������ 
	 * @param postingInfoList ������������� 
	 */
	public PostingManager(PostingInfoList postingInfoList){
		this.postingInfoList=postingInfoList;
	}
	/**
	 * ������������ �Է��ϸ� �����ͺ��̽����� ������������ �����´�.
	 * <br> EXAMPLE : ������������ ����� ��ġ�ϴ� ��� ������������ ������·� ��ȯ�Ѵ�. 
	 * @param postingInfo ����������
	 * @return ������������� 
	 */
	public List<PostingInfo> check(PostingInfo postingInfo){
		// �ʿ� �����Ƿ� ���� ����
		return null;
	}
	/**
	 * ��������õ�ϰ� �󼼺������� ���� ������ �ڵ带 �̿��Ͽ� �����ͺ��̽����� ������������ �����´�. 
	 * @param postingCode �������ڵ� 
	 * @return ����������
	 */
	public PostingInfo check(String postingCode){
		PostingDataDAOManager postingDataDAOManager=new PostingDataDAOManager();
		PostingInfo postingInfo=postingDataDAOManager.getPosting(postingCode);
		return postingInfo;
	}
	public PostingInfo addLikeNum(String postingCode){
		// �� �ڽ� Ŭ������ addLikeNum(String postingCode)�� ����ϱ� ���� ����
		System.out.println("��");
		return null;
	}
}
