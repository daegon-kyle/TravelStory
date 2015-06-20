package model;

import java.util.GregorianCalendar;
/**
 * 포스팅정보를 캡슐화 하고 있는 클래스 
 * @author 영한
 *
 */
public class PostingInfo implements  java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1341696323761921550L;
	/**
	 * 작성일자 
	 */
	private GregorianCalendar writingDate;
	/**
	 * 작성자
	 */
	private String writerName;
	/**
	 * 작성내용
	 */
	private String content;
	/**
	 * 포스팅에 부여되는 포스팅코드
	 */
	private String postingCode;
	/**
	 * 포스팅목적코드  
	 * 여행일정 : 1<br>준비물 :2<br>동행자찾기 :3<br> 기타 :4<br> 
	 */
	private String postingPurposeCode;
	/**
	 * 추천수 (좋아요) 
	 */
	private int likeNum;
	/**
	 * 제목
	 */
	private String title;
	/**
	 * 카테고리 코드 
	 */
	private String categoryCode;
	
	/**
	 * null 생성자 
	 */
	public PostingInfo() {
		this(new GregorianCalendar(),"","","","",0,"","");
	}
/**
 * 오바라이딩 생성자 
 * @param date 작성 날짜 
 * @param writerName 작성자 
 * @param postingCode 포스팅코드 
 * @param likeNum 추천수
 * @param title 제목
 */
	public PostingInfo(String content, String postingPurposeCode, String title, String categoryCode){
		this.content=content;
		this.postingPurposeCode=postingPurposeCode;
		this.title=title;
		this.categoryCode=categoryCode;
	}
	public PostingInfo(GregorianCalendar date, String writerName,String postingCode,int likeNum,String title) {
		this(date,writerName,"",postingCode,"",likeNum,title,"");
	}

/**
 * 
 * @param writingDate 작성날짜  
 * @param writerName 작성자 
 * @param content 내용 
 * @param postingCode 포스팅코드 
 * @param postingPurposeCode 포스팅목적코드 
 * @param likeNum 추천수 
 * @param title 제목 
 * @param categoryCode 카테고리코드 
 */
	public PostingInfo(GregorianCalendar writingDate, String writerName,
			String content, String postingCode, String postingPurposeCode,
			int likeNum, String title, String categoryCode) {
		this.writingDate = writingDate;
		this.writerName = writerName;
		this.content = content;
		this.postingCode = postingCode;
		this.postingPurposeCode = postingPurposeCode;
		this.likeNum = likeNum;
		this.title = title;
		this.categoryCode = categoryCode;
	}

/**
 * 작성일자를 반환한다. 
 * @return 작성일자 
 */
	public GregorianCalendar getWritingDate() {
		return writingDate;
	}

/**
 * 작성일자를 세팅한다. 
 * @param writingDate 작성일자 
 */
	public void setWritingDate(GregorianCalendar writingDate) {
		this.writingDate = writingDate;
	}

/**
 * 작성자를 반환한다. 
 * @return 작성자 
 */
	public String getWriterName() {
		return writerName;
	}

/**
 * 작성자를 세팅한다. 
 * @param writerName 작성자 
 */
	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}

/**
 * 내용을 반환한다. 
 * @return 내용 
 */
	public String getContent() {
		return content;
	}

/**
 * 내용을 세팅한다. 
 * @param content 내용 
 */
	public void setContent(String content) {
		this.content = content;
	}

/**
 * 포스팅코드를 반환한다. 
 * @return 포스팅코드 
 */
	public String getPostingCode() {
		return postingCode;
	}

/**
 * 포스팅코드를 세팅한다. 
 * @param postingCode 포스팅코드 
 */
	public void setPostingCode(String postingCode) {
		this.postingCode = postingCode;
	}

/**
 * 포스팅목적코드를 반환한다. 
 * @return 포스팅목적코드 
 */
	public String getPostingPurposeCode() {
		return postingPurposeCode;
	}

/**
 * 포스팅목적코드를 세팅한다. 
 * @param postingPurposeCode 포스팅목적코드 
 */
	public void setPostingPurposeCode(String postingPurposeCode) {
		this.postingPurposeCode = postingPurposeCode;
	}

/**
 * 추천수를 반환한다. 
 * @return 추천수 
 */
	public int getLikeNum() {
		return likeNum;
	}

/**
 * 추천수를 세팅한다. 
 * @param likeNum 추천수 
 */
	public void setLikeNum(int likeNum) {
		this.likeNum = likeNum;
	}

/**
 * 제목을 반환한다.  
 * @return 제목 
 */
	public String getTitle() {
		return title;
	}

/**
 * 제목을 세팅한다. 
 * @param title 제목
 */
	public void setTitle(String title) {
		this.title = title;
	}

/**
 * 카테고리코드를 반환한다. 
 * @return 카테고리코드 
 */
	public String getCategoryCode() {
		return categoryCode;
	}

/**
 * 카테고리코드를 세팅한다. 
 * @param categoryCode 카테고리코드 
 */
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	
	
	
	
	
}
