package model;

import java.io.Serializable;
import java.util.GregorianCalendar;
/**
 * 여행준비물 포스팅 정보 클래스 
 * @author 영한
 *
 */
public class TourPreparationInfo extends PostingInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1955653877878125680L;
	/**
	 * 여행출발 날짜
	 */
	private GregorianCalendar startDate;
	/**
	 * 여행종료 날짜 
	 */
	private GregorianCalendar endDate;
	/**
	 * 여행지 1 
	 */
	private String destination1;
	/**
	 * 여행지 2
	 */
	private String destination2;
	/**
	 * null 생성자 
	 */
	public TourPreparationInfo() {
		this(new GregorianCalendar(),new GregorianCalendar(),"","");
	}
/**
 * 오버로딩 생성자 
 * @param startDate
 * @param endDate
 * @param destination1
 * @param destination2
 */
	public TourPreparationInfo(String content, String postingPurposeCode, String title, String categoryCode, GregorianCalendar startDate,
			GregorianCalendar endDate, String destination1, String destination2) {
		super(content, postingPurposeCode, title,categoryCode);
		this.startDate = startDate;
		this.endDate = endDate;
		this.destination1 = destination1;
		this.destination2 = destination2;
	}
	public TourPreparationInfo(GregorianCalendar startDate,
			GregorianCalendar endDate, String destination1, String destination2) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
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
 * @param startDate
 * @param endDate
 * @param destination1
 * @param destination2
 */
	public TourPreparationInfo(GregorianCalendar writingDate,
			String writerName, String content, String postingCode,
			String postingPurposeCode, int likeNum, String title,
			String categoryCode, GregorianCalendar startDate,
			GregorianCalendar endDate, String destination1, String destination2) {
		super(writingDate, writerName, content, postingCode,
				postingPurposeCode, likeNum, title, categoryCode);
		this.startDate = startDate;
		this.endDate = endDate;
		this.destination1 = destination1;
		this.destination2 = destination2;

	}

/**
 * 여행시작일을 반환한다. 
 * @return 여행시작일 
 */

	public GregorianCalendar getStartDate() {
		return startDate;
	}


/**
 * 여행시작일을 세팅한다. 
 * @param startDate 여행시작일 
 */
	public void setStartDate(GregorianCalendar startDate) {
		this.startDate = startDate;
	}


/**
 * 여행종료일을 반환한다. 
 * @return 여행종료일 
 */
	public GregorianCalendar getEndDate() {
		return endDate;
	}


/**
 * 여행종료일을 세팅한다. 
 * @param endDate 여행종료일
 */
	public void setEndDate(GregorianCalendar endDate) {
		this.endDate = endDate;
	}


/**
 *  목적지를 세팅한다. 
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
