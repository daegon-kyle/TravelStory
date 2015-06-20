package form;

/**
 * 포스팅하기 위해 필수적으로 입력하는 포스팅 폼 클래스
 * 일반글 포스팅을 하기위해 PostingAddServlet에서 호출한다. 
 * @author 대곤
 *
 */
public class PostingInfoForm {
	/**
	 * 제목
	 */
	private String title;
	/**
	 * 내용
	 */
	private String content;
	
	/**
	 * null 생성자 
	 */
	public PostingInfoForm() {
		this("","");
	}

	/**
	 * 제목, 내용을 초기화하는 생성자 
	 * @param title 제목 
	 * @param content 내용
	 */
	public PostingInfoForm(String title, String content) {
		this.title = title;
		this.content = content;
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
}
