package form;

/**
 * �������ϱ� ���� �ʼ������� �Է��ϴ� ������ �� Ŭ����
 * �Ϲݱ� �������� �ϱ����� PostingAddServlet���� ȣ���Ѵ�. 
 * @author ���
 *
 */
public class PostingInfoForm {
	/**
	 * ����
	 */
	private String title;
	/**
	 * ����
	 */
	private String content;
	
	/**
	 * null ������ 
	 */
	public PostingInfoForm() {
		this("","");
	}

	/**
	 * ����, ������ �ʱ�ȭ�ϴ� ������ 
	 * @param title ���� 
	 * @param content ����
	 */
	public PostingInfoForm(String title, String content) {
		this.title = title;
		this.content = content;
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
}
