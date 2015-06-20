package gsonmodel;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
public class CompanionRecommendGson extends PostingInfoGson{
	private int reliability;
	private String otherGender;
	private int otherAge;
	private String destination1;
	private String destination2;
	private String startDate;
	private String endDate;
	public CompanionRecommendGson(GregorianCalendar writingDate,
			String writerName, String content, String postingCode,
			String postingPurposeCode, int likeNum, String title,
			String categoryCode, int reliability, String otherGender,
			int otherAge, String destination1, String destination2,
			GregorianCalendar startDate, GregorianCalendar endDate) {
		super(writingDate, writerName, content, postingCode,
				postingPurposeCode, likeNum, title, categoryCode);
		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
		this.reliability = reliability;
		this.otherGender = otherGender;
		this.otherAge = otherAge;
		this.destination1 = destination1;
		this.destination2 = destination2;
		this.startDate = format.format(startDate.getTime());
		this.endDate = format.format(endDate.getTime());
	}
	public CompanionRecommendGson(GregorianCalendar writingDate,
			String writerName, String content, String postingCode,
			String postingPurposeCode, int likeNum, String title,
			String categoryCode) {
		super(writingDate, writerName, content, postingCode,
				postingPurposeCode, likeNum, title, categoryCode);
	}
	public CompanionRecommendGson() {
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
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "CompanionRecommendGson [reliability=" + reliability
				+ ", otherGender=" + otherGender + ", otherAge=" + otherAge
				+ ", destination1=" + destination1 + ", destination2="
				+ destination2 + ", startDate=" + startDate + ", endDate="
				+ endDate + "]";
	}
	
}
