package dbmanager;

import dao.MemberDAO;
import dto.MemberDTO;
import model.MemberInfo;
import model.MemberInfoList;
import converter.ConvertGregorianCalendar; 
import java.util.GregorianCalendar;

/**
 * application���� �Ŵ����� MemberJoinManager �κ��� ȸ�������� ���� ��û�� �޾� ó����  MemberDAO�� ��û�� �� ����� �����Ѵ� 
 * @author ȭ��
 *
 */
public class MemberDAOManager 
{
	private MemberDAO memberDAO;
	
	/**
	 * �⺻�����ڷ� MemberDAO�� �ν��Ͻ�ȭ�Ѵ�
	 */
	public MemberDAOManager()
	{
		memberDAO=new MemberDAO();
	}
	
	/**
	 * ȸ�������� ���޹޾� db������ MemberDAO�� ���� ��û�ϰ� �װ���� �����Ѵ�
	 * @param memberInfo ������ ȸ������
	 * @return ���� ��������
	 */
	public boolean save(MemberInfo memberInfo)
	{
		ConvertGregorianCalendar convertCalendar=new ConvertGregorianCalendar();
	
				
		String name=memberInfo.getName();
		String email=memberInfo.getEmail();
		String password=memberInfo.getPassword();
		String birthdate=convertCalendar.convert(memberInfo.getBirthDate());		
		String phone=memberInfo.getPhone();
		String gender=memberInfo.getGender(); 
		
		return memberDAO.insert("2", name, email, password, birthdate, phone, gender); //2�� ��������ڵ�� �Ϲ�ȸ���� ��Ÿ���� 
	}
	
	/**
	 * db�� ����� ��� ȸ���� ���� ������ MemberDAO�� ���� ��û�ϰ� �װ���� �����Ѵ�
	 * @return ���� ��������
	 */
	public boolean deleteAll()
	{
		return memberDAO.deleteAll();		
	}
	
	/**
	 * ȸ���ڵ忡 �ش��ϴ� ȸ���� ������ ã�� ������ MemberDAO�� ���� ��û�ϰ� �� ����� �����Ѵ�
	 * @param memberCode ȸ���ڵ�
	 * @return ���� ��������
	 */
	public boolean deleteMember(String memberCode)
	{
		return memberDAO.deleteMember(memberCode);		
	}
	
	/**
	 * �̸��ϰ� ��й�ȣ�� �ش��ϴ� ȸ���� ������ ã�� ������ MemberDAO�� ���� ��û�ϰ� �� ����� �����Ѵ�
	 * @param email �̸���
	 * @param password ��й�ȣ
	 * @return ���� ��������
	 */
	public boolean deleteMember(String email, String password)
	{
		return memberDAO.deleteMember(email, password);
	}
	
	/**
	 * ��ϵ� ��� ȸ���� ���� �˻��� MemberDAO�� ���� ��û�ϰ� �װ���� �����Ѵ�
	 * @return ��ϵ��ִ� ��� ȸ����������� �����Ѵ�
	 */
	public MemberInfoList getAll()
	{ 
		MemberInfoList memberInfoList=new MemberInfoList();
		
		for(MemberDTO member :memberDAO.selectAll())
		{
			MemberInfo memberInfo=changeToMemberInfo(member);
			memberInfoList.addMemberInfo(memberInfo);
		}
		return memberInfoList;
	}
	
	/**
	 * ȸ���ڵ忡 �ش��ϴ� ȸ������ �˻��� MemberDAO�� ���� ��û�ϰ� �� ����� �����Ѵ�
	 * @param memberCode ȸ���ڵ�
	 * @return ȸ���ڵ忡 �ش��ϴ� ȸ������
	 */
	public MemberInfo getMemberInfo(String memberCode)
	{
		MemberDTO member=memberDAO.select(memberCode);
		
		return changeToMemberInfo(member);
	}
	
	/**
	 * �̸��Ͽ� �ش��ϴ� ��й�ȣ �˻��� MemberDAO�� ���� ��û�ϰ� �� ����� �����Ѵ�
	 * @param email �̸���
	 * @return �̸��Ͽ� �ش��ϴ� ��й�ȣ�� �����Ѵ�
	 */
	public String getPassword(String email)
	{
		return memberDAO.selectPassword(email);
	}
	
	/**
	 * ȸ���ڵ忡 �ش��ϴ� ȸ������ ������ MemberDAO�� ���� ��û�ϰ� �� ����� �����Ѵ�
	 * @param memberCode ȸ���ڵ�
	 * @param memberInfo ������ ȸ������
	 * @return ���� ��������
	 */
	public boolean modify(String memberCode, MemberInfo memberInfo)
	{
		ConvertGregorianCalendar convertGregorianCalendar=new ConvertGregorianCalendar();
		
		String name=memberInfo.getName();
		String email=memberInfo.getEmail();
		String password=memberInfo.getPassword();
		String birthdate=convertGregorianCalendar.convert(memberInfo.getBirthDate());
		String phone=memberInfo.getPhone();
		String gender=memberInfo.getGender();
		
		return memberDAO.update(memberCode, name, email, password, birthdate, phone, gender);
	}
	
	/**
	 * ȸ���� �ſ뵵 ������ MembeDAO�� ���� ��û�ϰ� �� ����� �����Ѵ�
	 * @param memberCode ȸ���ڵ�
	 * @param reliability �ſ뵵
	 * @return ������������
	 */
	public boolean modify(String memberCode, int reliability)
	{
		return memberDAO.update(memberCode, reliability);
	}
	
	/**
	 * ȸ���� �̸����ּ� ������ MemberDAO�� ���� ��û�ϰ� �װ���� �����Ѵ�
	 * @param memberCode ȸ���ڵ�
	 * @param email �̸���
	 * @return ������������
	 */
	public boolean modify(String memberCode, String email)
	{
		return memberDAO.update(memberCode, email);
	}
	

	/**
	 * ȸ�� ���̺� ������ ������ MemberDTOŬ������ ������ �̵��� ���� ȸ������ Ŭ���� MemberInfo�� ��ȯ�Ͽ� �����Ѵ�
	 * @param memberDTO ȸ�� ���̺� ������ ������ Ŭ����
	 * @return ȸ�������� ������ ������ MemberInfo Ŭ����
	 */
	public MemberInfo changeToMemberInfo(MemberDTO memberDTO)
	{
		ConvertGregorianCalendar convertGregorianCalendar=new ConvertGregorianCalendar();
		 
		String name=memberDTO.getName();
		String email=memberDTO.getEmail();
		String password=memberDTO.getPassword();
		GregorianCalendar birthDate =convertGregorianCalendar.convert(memberDTO.getBirthdate());
		String phone=memberDTO.getPhone();
		String gender=memberDTO.getGender();
		String myMemberCode=memberDTO.getMemberCode();
		String memberLevel=memberDTO.getLevelCode();
		int reliability=memberDTO.getReliability();
		
		MemberInfo memberInfo=new MemberInfo(name, email, password, birthDate, gender, phone, myMemberCode, memberLevel, reliability); 
		
		return memberInfo;
	}
}
