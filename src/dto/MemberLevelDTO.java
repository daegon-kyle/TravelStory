//�ۼ���¥ : 2014/7/19
//�ۼ��� : ��ȭ��

package dto;

/**
 * ȸ����� ���̺� ������ ������ Ŭ����
 * @author ȭ��
 *
 */
public class MemberLevelDTO 
{
	private String levelCode;
	private String levelName;
	
	/**
	 * �⺻������
	 */
	public MemberLevelDTO()
	{
		this("","");
	}
	
	/**
	 * �������ڸ� �޴� ������
	 * @param levelCode ����� ��
	 * @param levelName ��޸�
	 */
	public MemberLevelDTO(String levelCode, String levelName) { 
		this.levelCode = levelCode;
		this.levelName = levelName;
	}
	/**
	 * ȸ������ڵ带 �����Ѵ�
	 * @return
	 */
	public String getLevelCode() {
		return levelCode;
	}
	/**
	 * ȸ������ڵ带 �����Ѵ�
	 * @param levelCode
	 */
	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}
	/**
	 * ȸ����޸��� �����Ѵ�
	 * @return
	 */
	public String getLevelName() {
		return levelName;
	}
	/**
	 * ȸ����޸��� �����Ѵ�
	 * @param levelName
	 */
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
}
