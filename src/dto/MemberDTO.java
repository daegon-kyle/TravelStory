//�ۼ���¥ : 2014/7/19
//�ۼ��� : ��ȭ��

package dto;

/**
 * ��� ���̺� ������ ������ Ŭ����
 * @author ȭ��
 *
 */
public class MemberDTO 
{
	private String memberCode;
	private String levelCode;
	private String name;
	private String email;
	private String password;
	private String birthdate;
	private String phone;
	private String gender;
	private int reliability;
	/**
	 * �λ�����
	 */
	public MemberDTO()
	{
		this("","","","","","","","",0);
	}
	/**
	 * �������ڸ� �޴� ������
	 * @param name �̸�
	 * @param email �̸���
	 * @param birthdate ����
	 * @param phone ��ȭ��ȣ
	 * @param gender ��
	 * @param reliability �ŷڵ�
	 */
	public MemberDTO(String name, String email,
			String birthdate, String phone, String gender, int reliability)
	{
		this("", "", name, email, "", birthdate, phone, gender, reliability);
	}
	
	/**
	 * �������ڸ� �޴� ������
	 * @param memberCode ȸ���ڵ�
	 * @param levelCode ȸ������ڵ�
	  * @param name �̸�
	 * @param email �̸���
	 * @param birthdate ����
	 * @param phone ��ȭ��ȣ
	 * @param gender ��
	 * @param reliability �ŷڵ�
	 */
	public MemberDTO(String memberCode, String levelCode, String name, String email,
			String password, String birthdate, String phone, String gender)
	{
		this(memberCode, levelCode, name, email, password, birthdate, phone, gender, 0);
	}
	
	/**
	 * ��� �������ڸ� �޴� ������
	 * @param memberCode ȸ���ڵ�
	 * @param levelCode ȸ������ڵ�
	 * @param name �̸�
	 * @param email �̸���
	 * @param password ��й�ȣ
	 * @param birthdate ����
	 * @param phone ��ȭ��ȣ
	 * @param gender ��
	 * @param reliability �ŷڵ�
	 */
	public MemberDTO(String memberCode, String levelCode, String name, String email,
			String password, String birthdate, String phone, String gender,
			int reliability) { 
		this.memberCode = memberCode;
		this.levelCode = levelCode;
		this.name = name;
		this.email = email;
		this.password = password;
		this.birthdate = birthdate;
		this.phone = phone;
		this.gender = gender;
		this.reliability = reliability;
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
	 * ȸ������� �����Ѵ�
	 * @return
	 */
	public String getLevelCode() {
		return levelCode;
	}
	/**
	 * ȸ������� �����Ѵ�
	 * @param levelCode
	 */
	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}
	/**
	 * �̸��� �����Ѵ�
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * �̸��� �����Ѵ�
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * �̸����� �����Ѵ�
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * �̸����� �����Ѵ�
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * ��й�ȣ�� �����Ѵ�
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * ��й�ȣ�� �����Ѵ�
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * ������ �����Ѵ�
	 * @return
	 */
	public String getBirthdate() {
		return birthdate;
	}
	/**
	 * ������ �����Ѵ�
	 * @param birthdate
	 */
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	/**
	 * ��ȭ��ȣ�� �����Ѵ�
	 * @return
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * ��ȭ��ȣ�� �����Ѵ�
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * ���� �����Ѵ�
	 * @return
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * ���� �����Ѵ�
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * �ŷڵ��� �����Ѵ�
	 * @return
	 */
	public int getReliability() {
		return reliability;
	}
	/**
	 * �ŷڵ��� �����Ѵ�
	 * @param reliability
	 */
	public void setReliability(int reliability) {
		this.reliability = reliability;
	}
	
	
}
