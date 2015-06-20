package model;

import java.io.Serializable;
import java.util.GregorianCalendar;
/**
 * 여행일정 포스팅정보 
 * @author 영한
 * 
 */
public class TourPlanInfo extends PostingInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1980987551815979519L;
	/**
	 * 취향정보 
	 */
	private LikingInfo likingInfo;
	/**
	 * 여행장소 1 
	 */
	private String destination1;
	/** 
	 * 여행장소 2 
	 */
	private String destination2;
	/**
	 * null생성자 
	 */
	public TourPlanInfo(){
		this("","",new LikingInfo());
	}
	/**
	 * 오버로딩 생성자 
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
	 * 오버로딩 생성자 
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
 * 추천수를 반환한다. 
 * @return 추천수 
 */
	public LikingInfo getLikingInfo() {
		return likingInfo;
	}
/**
 * 추천수를 세팅한다. 
 * @param likingInfo 추천수 
 */
	public void setLikingInfo(LikingInfo likingInfo) {
		this.likingInfo = likingInfo;
	}
/**
 * 목적지를 반환한다. 
 * @return 목적지
 */
	public String getDestination1() {
		return destination1;
	}
/**
 * 목적지를 세팅한다. 
 * @param destination1 목적지
 */
	public void setDestination1(String destination1) {
		this.destination1 = destination1;
	}
/**
 * 목적지를 반환한다. 
 * @return 목적지 
 */
	public String getDestination2() {
		return destination2;
	}
/**
 * 목적지를 세팅한다. 
 * @param destination2 목적지 
 */
	public void setDestination2(String destination2) {
		this.destination2 = destination2;
	}
	
	
	
}
