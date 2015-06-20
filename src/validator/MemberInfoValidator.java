package validator;

import form.MemberInfoForm;
import java.util.*;

public class MemberInfoValidator {
	private MemberInfoForm memberInfoForm;
	
	public MemberInfoValidator()
	{
	}
	public MemberInfoValidator(MemberInfoForm memberInfoForm)
	{
		this.memberInfoForm=memberInfoForm;
	}
	
	public List<String> validate(){
		ArrayList<String> list=new ArrayList<String>();
		
		//��ĭ ��ȿ�� ����
		BlankValidator blankValidator=new BlankValidator();
		if(blankValidator.validateBlank(memberInfoForm.getEmail()))
			list.add("�̸����� �Է��ϼ���");
		if(blankValidator.validateBlank(memberInfoForm.getName()))
			list.add("�̸��� �Է��ϼ���");
		if(blankValidator.validateBlank(memberInfoForm.getPassword()))
			list.add("��й�ȣ�� �Է��ϼ���");
		if(blankValidator.validateBlank(memberInfoForm.getBirthDate()))
			list.add("���ϳ�¥�� �Է��ϼ���");
		if(blankValidator.validateBlank(memberInfoForm.getGender()))
			list.add("������ �Է��ϼ���");
		if(blankValidator.validateBlank(memberInfoForm.getPhone()))
			list.add("��ȭ��ȣ�� �Է��ϼ���");
		
		//���� ��ȿ�� ����
		//�̸��ϰ� ��ȭ��ȣ
		if(validateEmail()!="")
			list.add(validateEmail());
		if(validatePhone()!="")
			list.add(validatePhone());
		if(validatePassword()!="")
			list.add(validatePassword());
		if(validatePasswordCheck()!="")
			list.add(validatePasswordCheck());
		return list;
	}
	
	public String validateEmail(){
		if(memberInfoForm.getEmail().contains("@"))
			return "";
		else
			return "�̸��� ������ �ƴմϴ�. �̸����� �Է����ּ���";
	}
	public String validatePhone(){
		try{
			Integer.parseInt(memberInfoForm.getPhone());
		}
		catch(NumberFormatException nfe){
			return "��ȭ��ȣ�� ���ڷ� �Է����ּ���"; 
		}
		return "";
	}
	public String validatePassword()
	{
		int length=memberInfoForm.getPassword().length();
		
		if(length<6 || length>=16)
			return "��й�ȣ�� 6~16�ڷ� �ۼ����ּ���";
		else
			return "";
	}
	public String validatePasswordCheck()
	{
		String password=memberInfoForm.getPassword();
		String passwordCheck=memberInfoForm.getPasswordCheck();
		
		if(!password.equals(passwordCheck))
			return "��й�ȣ�� ��ġ���� �ʽ��ϴ�";
		else
			return "";
		
	}
	public MemberInfoForm getMemberInfoForm() {
		return memberInfoForm;
	}
	public void setMemberInfoForm(MemberInfoForm memberInfoForm) {
		this.memberInfoForm = memberInfoForm;
	}
}
