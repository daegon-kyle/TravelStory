package validator;

import form.CompanionRecommendInfoForm;
import java.util.*;
/**
 * CompanionRecommendInfoForm�� ���鿩�� üũ�ϴ� Ŭ����
 * @author ���
 *
 */
public class CompanionRecommendInfoValidator {
	/**
	 *  CompanionRecommendInfoForm Ŭ����(��������õ�ϱ�)
	 */
	private CompanionRecommendInfoForm companionRecommendInfoForm;
/**
 * �λ�����
 */
	public CompanionRecommendInfoValidator() {
		this(new CompanionRecommendInfoForm());
	}
	/**
	 * �⺻������
	 * @param CompanionRecommendInfoForm
	 */
	public CompanionRecommendInfoValidator(
			CompanionRecommendInfoForm companionRecommendInfoForm) {
		this.companionRecommendInfoForm = companionRecommendInfoForm;
	}
	/**
	 * ����ڰ� �Է��� CompanionRecommendInfoForm ����+��¥��ȿ�� �˻�
	 * @return �����޽��� ���
	 */
	public List<String> validate(){
		ArrayList<String> list=new ArrayList<String>();
		
		//��ĭ ��ȿ�� ����
		BlankValidator blankValidator=new BlankValidator();
		if(blankValidator.validateBlank(companionRecommendInfoForm.getOtherGender()))
			list.add("���� ������ �Է��ϼ���");
		if(blankValidator.validateBlank(companionRecommendInfoForm.getDestination1()))
			list.add("������� �Է��ϼ���");
		if(blankValidator.validateBlank(companionRecommendInfoForm.getDestination2()))
			list.add("�������� �Է��ϼ���");
		if(blankValidator.validateBlank(companionRecommendInfoForm.getStartDate()))
			list.add("��߳�¥�� �Է��ϼ���");
		if(blankValidator.validateBlank(companionRecommendInfoForm.getEndDate()))
			list.add("������¥�� �Է��ϼ���");
		if(blankValidator.validateBlank(companionRecommendInfoForm.getOtherAge()))
			list.add("���� ���̸� �Է��ϼ���");
		
		//��¥ ��ȿ�� ����
		// ������
		StringTokenizer token = new StringTokenizer(companionRecommendInfoForm.getStartDate(), "-");
		int year = Integer.parseInt((String)token.nextElement());
		int month = Integer.parseInt((String)token.nextElement());
		int dayOfMonth = Integer.parseInt((String)token.nextElement());
		GregorianCalendar start=new GregorianCalendar(year, month-1, dayOfMonth);
		// ������
		token = new StringTokenizer(companionRecommendInfoForm.getEndDate(), "-");
		year = Integer.parseInt((String)token.nextElement());
		month = Integer.parseInt((String)token.nextElement());
		GregorianCalendar end=new GregorianCalendar(year, month-1, dayOfMonth);
		if( new DateValidator().validateDate(start, end) != "")
			list.add(new DateValidator().validateDate(start, end));
		
		return list;
	}
	/**
	 * CompanionRecommendInfoForm(��������õ�ϱ�)��ȯ
	 * @return  CompanionRecommendInfoForm(��������õ�ϱ�)
	 */
	public CompanionRecommendInfoForm getCompanionRecommendInfoForm() {
		return companionRecommendInfoForm;
	}
	/**
	 *CompanionRecommendInfoForm(��������õ�ϱ�)�� ����
	 * @param CompanionRecommendInfoForm(��������õ�ϱ�)
	 */
	public void setCompanionRecommendInfoForm(
			CompanionRecommendInfoForm companionRecommendInfoForm) {
		this.companionRecommendInfoForm = companionRecommendInfoForm;
	}
}
