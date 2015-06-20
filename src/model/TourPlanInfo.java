package model;

import java.io.Serializable;
import java.util.GregorianCalendar;
/**
 * �������� ���������� 
 * @author ����
 * 
 */
public class TourPlanInfo extends PostingInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1980987551815979519L;
	/**
	 * �������� 
	 */
	private LikingInfo likingInfo;
	/**
	 * ������� 1 
	 */
	private String destination1;
	/** 
	 * ������� 2 
	 */
	private String destination2;
	/**
	 * null������ 
	 */
	public TourPlanInfo(){
		this("","",new LikingInfo());
	}
	/**
	 * �����ε� ������ 
	 * @param destination1
	 * @param destination2
	 * @param likingInfo
	 */
	public TourPlanInfo(String destination1, String destination2,LikingInfo likingInfo){
		super();
		this.likingInfo = likingInfo;
		this.destination1 = destination1;
		this.destination2 = destination2;
	}
	public TourPlanInfo(String title, String content, String postingPurposeCode, String categoryCode, String destination1, String destination2,LikingInfo likingInfo){
		super(content, postingPurposeCode, title, categoryCode);
		this.likingInfo = likingInfo;
		this.destination1 = destination1;
		this.destination2 = destination2;
	}
	/**
	 * �����ε� ������ 
	 * @param writingDate
	 * @param writerName
	 * @param content
	 * @param postingCode
	 * @param postingPurposeCode
	 * @param likeNum
	 * @param title
	 * @param categoryCode
	 * @param likingInfo
	 * @param destination1
	 * @param destination2
	 */
	public TourPlanInfo(GregorianCalendar writingDate, String writerName,
			String content, String postingCode, String postingPurposeCode,
			int likeNum, String title, String categoryCode,LikingInfo likingInfo, String destination1, String destination2){
		super(writingDate,writerName,content,postingCode,postingPurposeCode,likeNum,title,categoryCode);
		this.likingInfo = likingInfo;
		this.destination1 = destination1;
		this.destination2 = destination2;
	}
/**
 * ��õ���� ��ȯ�Ѵ�. 
 * @return ��õ�� 
 */
	public LikingInfo getLikingInfo() {
		return likingInfo;
	}
/**
 * ��õ���� �����Ѵ�. 
 * @param likingInfo ��õ�� 
 */
	public void setLikingInfo(LikingInfo likingInfo) {
		this.likingInfo = likingInfo;
	}
/**
 * �������� ��ȯ�Ѵ�. 
 * @return ������
 */
	public String getDestination1() {
		return destination1;
	}
/**
 * �������� �����Ѵ�. 
 * @param destination1 ������
 */
	public void setDestination1(String destination1) {
		this.destination1 = destination1;
	}
/**
 * �������� ��ȯ�Ѵ�. 
 * @return ������ 
 */
	public String getDestination2() {
		return destination2;
	}
/**
 * �������� �����Ѵ�. 
 * @param destination2 ������ 
 */
	public void setDestination2(String destination2) {
		this.destination2 = destination2;
	}
	
	
	
}
