package model;

import java.util.GregorianCalendar;
/**
 * ������������ ĸ��ȭ �ϰ� �ִ� Ŭ���� 
 * @author ����
 *
 */
public class PostingInfo implements  java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1341696323761921550L;
	/**
	 * �ۼ����� 
	 */
	private GregorianCalendar writingDate;
	/**
	 * �ۼ���
	 */
	private String writerName;
	/**
	 * �ۼ�����
	 */
	private String content;
	/**
	 * �����ÿ� �ο��Ǵ� �������ڵ�
	 */
	private String postingCode;
	/**
	 * �����ø����ڵ�  
	 * �������� : 1<br>�غ� :2<br>������ã�� :3<br> ��Ÿ :4<br> 
	 */
	private String postingPurposeCode;
	/**
	 * ��õ�� (���ƿ�) 
	 */
	private int likeNum;
	/**
	 * ����
	 */
	private String title;
	/**
	 * ī�װ� �ڵ� 
	 */
	private String categoryCode;
	
	/**
	 * null ������ 
	 */
	public PostingInfo() {
		this(new GregorianCalendar(),"","","","",0,"","");
	}
/**
 * ���ٶ��̵� ������ 
 * @param date �ۼ� ��¥ 
 * @param writerName �ۼ��� 
 * @param postingCode �������ڵ� 
 * @param likeNum ��õ��
 * @param title ����
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
 * @param writingDate �ۼ���¥  
 * @param writerName �ۼ��� 
 * @param content ���� 
 * @param postingCode �������ڵ� 
 * @param postingPurposeCode �����ø����ڵ� 
 * @param likeNum ��õ�� 
 * @param title ���� 
 * @param categoryCode ī�װ��ڵ� 
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
 * �ۼ����ڸ� ��ȯ�Ѵ�. 
 * @return �ۼ����� 
 */
	public GregorianCalendar getWritingDate() {
		return writingDate;
	}

/**
 * �ۼ����ڸ� �����Ѵ�. 
 * @param writingDate �ۼ����� 
 */
	public void setWritingDate(GregorianCalendar writingDate) {
		this.writingDate = writingDate;
	}

/**
 * �ۼ��ڸ� ��ȯ�Ѵ�. 
 * @return �ۼ��� 
 */
	public String getWriterName() {
		return writerName;
	}

/**
 * �ۼ��ڸ� �����Ѵ�. 
 * @param writerName �ۼ��� 
 */
	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}

/**
 * ������ ��ȯ�Ѵ�. 
 * @return ���� 
 */
	public String getContent() {
		return content;
	}

/**
 * ������ �����Ѵ�. 
 * @param content ���� 
 */
	public void setContent(String content) {
		this.content = content;
	}

/**
 * �������ڵ带 ��ȯ�Ѵ�. 
 * @return �������ڵ� 
 */
	public String getPostingCode() {
		return postingCode;
	}

/**
 * �������ڵ带 �����Ѵ�. 
 * @param postingCode �������ڵ� 
 */
	public void setPostingCode(String postingCode) {
		this.postingCode = postingCode;
	}

/**
 * �����ø����ڵ带 ��ȯ�Ѵ�. 
 * @return �����ø����ڵ� 
 */
	public String getPostingPurposeCode() {
		return postingPurposeCode;
	}

/**
 * �����ø����ڵ带 �����Ѵ�. 
 * @param postingPurposeCode �����ø����ڵ� 
 */
	public void setPostingPurposeCode(String postingPurposeCode) {
		this.postingPurposeCode = postingPurposeCode;
	}

/**
 * ��õ���� ��ȯ�Ѵ�. 
 * @return ��õ�� 
 */
	public int getLikeNum() {
		return likeNum;
	}

/**
 * ��õ���� �����Ѵ�. 
 * @param likeNum ��õ�� 
 */
	public void setLikeNum(int likeNum) {
		this.likeNum = likeNum;
	}

/**
 * ������ ��ȯ�Ѵ�.  
 * @return ���� 
 */
	public String getTitle() {
		return title;
	}

/**
 * ������ �����Ѵ�. 
 * @param title ����
 */
	public void setTitle(String title) {
		this.title = title;
	}

/**
 * ī�װ��ڵ带 ��ȯ�Ѵ�. 
 * @return ī�װ��ڵ� 
 */
	public String getCategoryCode() {
		return categoryCode;
	}

/**
 * ī�װ��ڵ带 �����Ѵ�. 
 * @param categoryCode ī�װ��ڵ� 
 */
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	
	
	
	
	
}
