package validator;

import form.TourPreparationInfoForm;
import java.util.*;
/**
 * �����غ� �������� �ϱ� ���� �Է��� ����� üũ�ϱ� ���� ����ϴ� Ŭ����  
 * @author ���
 *
 */
public class TourPreparationInfoValidator {
	/**
	 * �����غ� ���
	 */
	private TourPreparationInfoForm tourPreparationInfoForm;
/**
 * �λ�����
 */
	public TourPreparationInfoValidator() {
		this(new TourPreparationInfoForm());
	}
	/**
	 * �⺻������
	 * @param tourPreparationInfoForm
	 */
	public TourPreparationInfoValidator(
			TourPreparationInfoForm tourPreparationInfoForm) {
		this.tourPreparationInfoForm = tourPreparationInfoForm;
	}
/**
 * �����غ� ����� ������ üũ�ϱ� ���� ����ϴ� �޼ҵ�, BlankValidator�� validateBlank �޼ҵ� ȣ��
 * @return �����޽��� ���
 */
	public List<String> validate(){
		ArrayList<String> list=new ArrayList<String>();
		
		//��ĭ ��ȿ�� ����
		BlankValidator blankValidator=new BlankValidator();
		if(blankValidator.validateBlank(tourPreparationInfoForm.getDestination1()))
			list.add("������� �Է��ϼ���");
		if(blankValidator.validateBlank(tourPreparationInfoForm.getDestination2()))
			list.add("�������� �Է��ϼ���");
		if(blankValidator.validateBlank(tourPreparationInfoForm.getStartDate()))
			list.add("��߳�¥�� �Է��ϼ���");
		if(blankValidator.validateBlank(tourPreparationInfoForm.getEndDate()))
			list.add("������¥�� �Է��ϼ���");
		if(blankValidator.validateBlank(tourPreparationInfoForm.getTitle()))
			list.add("������ �Է��ϼ���");
		if(blankValidator.validateBlank(tourPreparationInfoForm.getContent()))
			list.add("������ �Է��ϼ���");
		
		//��¥ ��ȿ�� ����
		GregorianCalendar start=new GregorianCalendar(Integer.parseInt(tourPreparationInfoForm.getStartDate().substring(0, 4)), Integer.parseInt(tourPreparationInfoForm.getStartDate().substring(4, 6)), Integer.parseInt(tourPreparationInfoForm.getStartDate().substring(6, 8)));
		GregorianCalendar end=new GregorianCalendar(Integer.parseInt(tourPreparationInfoForm.getEndDate().substring(0, 4)), Integer.parseInt(tourPreparationInfoForm.getEndDate().substring(4, 6)), Integer.parseInt(tourPreparationInfoForm.getEndDate().substring(6, 8)));
		
		if( new DateValidator().validateDate(start, end) != "")
			list.add(new DateValidator().validateDate(start, end));
		
		return list;
	}
	/**
	 * �����غ� ��� ��ȯ
	 * @return �����غ� ���
	 */
	public TourPreparationInfoForm getTourPreparationInfoForm() {
		return tourPreparationInfoForm;
	}
	/**
	 * �����غ� ��� ����
	 * @param tourPreparationInfoForm �����غ� ���
	 */
	public void setTourPreparationInfoForm(
			TourPreparationInfoForm tourPreparationInfoForm) {
		this.tourPreparationInfoForm = tourPreparationInfoForm;
	}
	
}
