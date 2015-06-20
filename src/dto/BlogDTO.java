//�ۼ���¥ : 2014/7/19
//�ۼ��� : ��ȭ��

package dto;

/**
 * ��α� ���̺� �� Ŭ����
 * @author ȭ��
 *
 */
public class BlogDTO 
{
	private String blogCode;
	private String memberCode;
	private String layoutCode;
	private String fontName;
	private String bgColorCode;
	
	/**
	 * ��α� �⺻ ������
	 */
	public BlogDTO() {
		this("","","","","");
	}
	
	/**
	 * �������ڸ� �޴� ��α� ������
	 * @param blogCode ��α� ���� �ĺ��ڵ�
	 * @param memberCode ȸ�� ���� �ĺ��ڵ�
	 * @param layoutCode ���̾ƿ� ���� �ĺ��ڵ�
	 * @param fontName ��Ʈ��
	 * @param bgColorCode ������
	 */
	public BlogDTO(String blogCode, String memberCode, String layoutCode, String fontName, String bgColorCode) 
	{ 
		this.blogCode = blogCode;
		this.memberCode = memberCode;
		this.layoutCode = layoutCode;
		this.fontName = fontName;
		this.bgColorCode = bgColorCode;
	}
	
	/**
	 * ��α� �ڵ带 ���Ϲ޴´�
	 * @return
	 */
	public String getBlogCode() {
		return blogCode;
	}
	
	/**
	 * ��α��ڵ带 �����Ѵ�
	 * @param blogCode
	 */
	public void setBlogCode(String blogCode) {
		this.blogCode = blogCode;
	}
	/**
	 * ȸ���ڵ带 �����Ѵ�
	 * @return
	 */
	public String getMemberCode() {
		return memberCode;
	}
	/**
	 * ȸ���ڵ带 �����Ѵ�
	 * @param memberCode
	 */
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	/**
	 * ���̾ƿ��ڵ带 �����Ѵ�
	 * @return
	 */
	public String getLayoutCode() {
		return layoutCode;
	}
	/**
	 * ���̾ƿ��ڵ带 �����Ѵ�
	 * @param layoutCode
	 */
	public void setLayoutCode(String layoutCode) {
		this.layoutCode = layoutCode;
	}
	/**
	 * ��Ʈ���� �����Ѵ�
	 * @return
	 */
	public String getFontName() {
		return fontName;
	}
	/**
	 * ��Ʈ���� �����Ѵ�
	 * @param fontName
	 */
	public void setFontName(String fontName) {
		this.fontName = fontName;
	}
	/**
	 * ������ �����Ѵ�
	 * @return
	 */
	public String getBgColorCode() {
		return bgColorCode;
	}
	/**
	 * ������ �����Ѵ�
	 * @param bgColorCode
	 */
	public void setBgColorCode(String bgColorCode) {
		this.bgColorCode = bgColorCode;
	}

}
