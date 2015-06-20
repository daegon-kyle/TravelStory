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
		
		//빈칸 유효성 검증
		BlankValidator blankValidator=new BlankValidator();
		if(blankValidator.validateBlank(memberInfoForm.getEmail()))
			list.add("이메일을 입력하세요");
		if(blankValidator.validateBlank(memberInfoForm.getName()))
			list.add("이름을 입력하세요");
		if(blankValidator.validateBlank(memberInfoForm.getPassword()))
			list.add("비밀번호를 입력하세요");
		if(blankValidator.validateBlank(memberInfoForm.getBirthDate()))
			list.add("생일날짜를 입력하세요");
		if(blankValidator.validateBlank(memberInfoForm.getGender()))
			list.add("성별을 입력하세요");
		if(blankValidator.validateBlank(memberInfoForm.getPhone()))
			list.add("전화번호를 입력하세요");
		
		//숫자 유효성 검증
		//이메일과 전화번호
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
			return "이메일 형식이 아닙니다. 이메일을 입력해주세요";
	}
	public String validatePhone(){
		try{
			Integer.parseInt(memberInfoForm.getPhone());
		}
		catch(NumberFormatException nfe){
			return "전화번호는 숫자로 입력해주세요"; 
		}
		return "";
	}
	public String validatePassword()
	{
		int length=memberInfoForm.getPassword().length();
		
		if(length<6 || length>=16)
			return "비밀번호는 6~16자로 작성해주세요";
		else
			return "";
	}
	public String validatePasswordCheck()
	{
		String password=memberInfoForm.getPassword();
		String passwordCheck=memberInfoForm.getPasswordCheck();
		
		if(!password.equals(passwordCheck))
			return "비밀번호가 일치하지 않습니다";
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
