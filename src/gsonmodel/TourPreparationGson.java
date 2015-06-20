package gsonmodel;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
public class TourPreparationGson extends PostingInfoGson{
	private String startDate;
	private String endDate;
	private String destination1;
	private String destination2;
	public TourPreparationGson(GregorianCalendar writingDate, String writerName,
			String content, String postingCode, String postingPurposeCode,
			int likeNum, String title, String categoryCode, GregorianCalendar startDate,
			GregorianCalendar endDate, String destination1, String destination2) {
		super(writingDate, writerName, content, postingCode, postingPurposeCode, likeNum, title, categoryCode);
		SimpleDateFormat format= new SimpleDateFormat("yyyy.MM.dd");
		this.startDate = format.format(startDate.getTime());
		this.endDate = format.format(endDate.getTime());
		this.destination1 = destination1;
		this.destination2 = destination2;
	}
	public TourPreparationGson() {
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
	@Override
	public String toString() {
		return "TourPreparationGson [startDate=" + startDate + ", endDate="
				+ endDate + ", destination1=" + destination1
				+ ", destination2=" + destination2 + "]";
	}
	
}
