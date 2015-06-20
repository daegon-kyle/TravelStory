package model;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class CompanionRecommendInfo extends PostingInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1312994215837865424L;
	private int reliability;
	private String otherGender;
	private int otherAge;
	private String destination1;
	private String destination2;
	private GregorianCalendar startDate;
	private GregorianCalendar endDate;
	
	public CompanionRecommendInfo() {
		this(0,"",0,"","",new GregorianCalendar(),new GregorianCalendar());
	}
	
	public CompanionRecommendInfo(String destination1, String destination2,String otherGender,
			int otherAge, GregorianCalendar startDate, GregorianCalendar endDate) {
		this(0,otherGender,otherAge,destination1,destination2,startDate,endDate);
	}
	public CompanionRecommendInfo(String content, String postingPurposeCode, String title, String categoryCode, String otherGender, int otherAge, String destination1, String destination2,
			GregorianCalendar startDate, GregorianCalendar endDate){
		super(content, postingPurposeCode, title, categoryCode);
		this.otherGender=otherGender;
		this.otherAge=otherAge;
		this.destination1=destination1;
		this.destination2=destination2;
		this.startDate=startDate;
		this.endDate=endDate;
	}
	public CompanionRecommendInfo(int reliability, String otherGender,
			int otherAge, String destination1, String destination2,
			GregorianCalendar startDate, GregorianCalendar endDate) {
		this.reliability = reliability;
		this.otherGender = otherGender;
		this.otherAge = otherAge;
		this.destination1 = destination1;
		this.destination2 = destination2;
		this.startDate = startDate;
		this.endDate = endDate;
	}


	public CompanionRecommendInfo(GregorianCalendar writingDate, String writerName,
			String content, String postingCode, String postingPurposeCode,
			int likeNum, String title, String categoryCode,int reliability, String otherGender,
			int otherAge, String destination1, String destination2,
			GregorianCalendar startDate, GregorianCalendar endDate) {
		super(writingDate,writerName,content,postingCode,postingPurposeCode,likeNum,title,categoryCode);
		this.reliability = reliability;
		this.otherGender = otherGender;
		this.otherAge = otherAge;
		this.destination1 = destination1;
		this.destination2 = destination2;
		this.startDate = startDate;
		this.endDate = endDate;
	}


	public int getReliability() {
		return reliability;
	}


	public void setReliability(int reliability) {
		this.reliability = reliability;
	}


	public String getOtherGender() {
		return otherGender;
	}


	public void setOtherGender(String otherGender) {
		this.otherGender = otherGender;
	}


	public int getOtherAge() {
		return otherAge;
	}


	public void setOtherAge(int otherAge) {
		this.otherAge = otherAge;
	}


	public String getDestination1() {
		return destination1;
	}


	public void setDestination1(String destination1) {
		this.destination1 = destination1;
	}


	public String getDestination2() {
		return destination2;
	}


	public void setDestination2(String destination2) {
		this.destination2 = destination2;
	}


	public GregorianCalendar getStartDate() {
		return startDate;
	}


	public void setStartDate(GregorianCalendar startDate) {
		this.startDate = startDate;
	}


	public GregorianCalendar getEndDate() {
		return endDate;
	}


	public void setEndDate(GregorianCalendar endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "CompanionRecommendInfo [reliability=" + reliability
				+ ", otherGender=" + otherGender + ", otherAge=" + otherAge
				+ ", destination1=" + destination1 + ", destination2="
				+ destination2 + ", startDate=" + startDate + ", endDate="
				+ endDate + "]";
	}


	
	
	
}
