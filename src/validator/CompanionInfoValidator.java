package validator;

import form.CompanionInfoForm;
import java.util.*;
/**
 * CompanionInfoForm�� ���鿩�� üũ�ϴ� Ŭ����
 * @author ���
 *
 */
public class CompanionInfoValidator {
	/**
	 * CompanionInfoForm Ŭ����(������������)
	 */
	private CompanionInfoForm companionInfoForm;
	/**
	 * �λ�����
	 */
	public CompanionInfoValidator() {
		this(new CompanionInfoForm());
	}
	/**
	 * �⺻������
	 * @param ����ڰ� �Է��� CompanionInfoForm Ŭ����
	 */
	public CompanionInfoValidator(CompanionInfoForm companionInfoForm) {
		this.companionInfoForm = companionInfoForm;
	}
	/**
	 * ��ĭ+��¥ �˻��ϴ� �޼ҵ�
	 * @return �����޽��� ��� 
	 */
	public List<String> validate(){
		ArrayList<String> list=new ArrayList<String>();
		
		//��ĭ ��ȿ�� ����
		BlankValidator blankValidator=new BlankValidator();
		if(blankValidator.validateBlank(companionInfoForm.getOtherGender()))
			list.add("���� ������ �Է��ϼ���");
		if(blankValidator.validateBlank(companionInfoForm.getDestination1()))
			list.add("������� �Է��ϼ���");
		if(blankValidator.validateBlank(companionInfoForm.getDestination2()))
			list.add("�������� �Է��ϼ���");
		if(blankValidator.validateBlank(companionInfoForm.getStartDate()))
			list.add("��߳�¥�� �Է��ϼ���");
		if(blankValidator.validateBlank(companionInfoForm.getEndDate()))
			list.add("������¥�� �Է��ϼ���");
		if(blankValidator.validateBlank(companionInfoForm.getTitle()))
			list.add("������ �Է��ϼ���");
		if(blankValidator.validateBlank(companionInfoForm.getContent()))
			list.add("�ڱ�Ұ��� �Է��ϼ���");
		
		//��¥ ��ȿ�� ����
		GregorianCalendar start=new GregorianCalendar(Integer.parseInt(companionInfoForm.getStartDate().substring(0, 4)), Integer.parseInt(companionInfoForm.getStartDate().substring(4, 6)), Integer.parseInt(companionInfoForm.getStartDate().substring(6, 8)));
		GregorianCalendar end=new GregorianCalendar(Integer.parseInt(companionInfoForm.getEndDate().substring(0, 4)), Integer.parseInt(companionInfoForm.getEndDate().substring(4, 6)), Integer.parseInt(companionInfoForm.getEndDate().substring(6, 8)));
		
		if( new DateValidator().validateDate(start, end) != "")
			list.add(new DateValidator().validateDate(start, end));
		
		return list;
	}

/**
 * CompanionInfoForm ��ȯ
 * @returnCompanionInfoForm
 */
	public CompanionInfoForm getCompanionInfoForm() {
		return companionInfoForm;
	}
	/**
	 * CompanionInfoForm�� ����
	 * @param  companionInfoForm
	 */
	public void setCompanionInfoForm(CompanionInfoForm companionInfoForm) {
		this.companionInfoForm = companionInfoForm;
	}
	
	
}
