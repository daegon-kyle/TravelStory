package model;

import java.io.Serializable;
import java.util.GregorianCalendar;
/**
 * �����غ� ������ ���� Ŭ���� 
 * @author ����
 *
 */
public class TourPreparationInfo extends PostingInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1955653877878125680L;
	/**
	 * ������� ��¥
	 */
	private GregorianCalendar startDate;
	/**
	 * �������� ��¥ 
	 */
	private GregorianCalendar endDate;
	/**
	 * ������ 1 
	 */
	private String destination1;
	/**
	 * ������ 2
	 */
	private String destination2;
	/**
	 * null ������ 
	 */
	public TourPreparationInfo() {
		this(new GregorianCalendar(),new GregorianCalendar(),"","");
	}
/**
 * �����ε� ������ 
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
 * �����ε� ������ 
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
 * ����������� ��ȯ�Ѵ�. 
 * @return ��������� 
 */

	public GregorianCalendar getStartDate() {
		return startDate;
	}


/**
 * ����������� �����Ѵ�. 
 * @param startDate ��������� 
 */
	public void setStartDate(GregorianCalendar startDate) {
		this.startDate = startDate;
	}


/**
 * ������������ ��ȯ�Ѵ�. 
 * @return ���������� 
 */
	public GregorianCalendar getEndDate() {
		return endDate;
	}


/**
 * ������������ �����Ѵ�. 
 * @param endDate ����������
 */
	public void setEndDate(GregorianCalendar endDate) {
		this.endDate = endDate;
	}


/**
 *  �������� �����Ѵ�. 
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
