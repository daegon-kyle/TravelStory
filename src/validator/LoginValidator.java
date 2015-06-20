package validator;

import form.LoginForm;
import java.util.*;
/**
 * �α��� ���� ��������� ���� ������� �Է¿��θ� �˻��ϴ� Ŭ����
 * @author ���
 *
 */
public class LoginValidator {
	/**
	 * �α�����
	 */
	private LoginForm loginForm;
/**
 * �λ�����
 */
	public LoginValidator() {
		this(new LoginForm());
	}
	/**
	 * �⺻������
	 * @param loginForm �α�����
	 */
	public LoginValidator(LoginForm loginForm) {
		this.loginForm = loginForm;
	}
	/**
	 * ���̵�� ��й�ȣ���� ���鿩�θ� üũ�� �� �����޽�����ȯ
	 * @return �����޽��� ���
	 */
	public List<String> validate(){
		ArrayList<String> list=new ArrayList<String>();
		
		//��ĭ ��ȿ�� ����
		BlankValidator blankValidator=new BlankValidator();
		if(blankValidator.validateBlank(loginForm.getId()))
			list.add("���̵� �Է��ϼ���");
		if(blankValidator.validateBlank(loginForm.getPassword()))
			list.add("��й�ȣ�� �Է��ϼ���");
		
		if(validateEmail()!="")
			list.add(validateEmail());

		if(validatePassword()!="")
			list.add(validatePassword());
		
		return list;
	}
	/**
	 * �α��� �� ��ȯ
	 * @return �α��� ��
	 */
	public LoginForm getLoginForm() {
		return loginForm;
	}
	/**
	 * �α��� �� ����
	 * @param loginForm �α��� ��
	 */
	public void setLoginForm(LoginForm loginForm) {
		this.loginForm = loginForm;
	}
	
	public String validatePassword()
	{
		int length=loginForm.getPassword().length();
		
		if(length<6 || length>=16)
			return "��й�ȣ�� 6~16�ڷ� �ۼ����ּ���";
		else
			return "";
	}
	
	public String validateEmail(){
		if(loginForm.getId().contains("@"))
			return "";
		else
			return "�̸��� ������ �ƴմϴ�. �̸����� �Է����ּ���";
	}
}


