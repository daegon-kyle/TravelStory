package validator;

import form.TourPlanInfoForm;
import java.util.*;
/**
 * ����������õ�������� ��û�Ͽ��� �� �Է��ϱ� ���� ����ϴ� Ŭ����
 * @author ���
 *
 */
public class TourPlanInfoValidator {
	/**
	 * ���������������
	 */
	private TourPlanInfoForm tourPlanInfoForm;
/**
 * �λ�����
 */
	public TourPlanInfoValidator() {
		this(new TourPlanInfoForm());
	}
	/**
	 * �⺻������
	 * @param tourPlanInfoForm
	 */
	public TourPlanInfoValidator(TourPlanInfoForm tourPlanInfoForm) {
		this.tourPlanInfoForm = tourPlanInfoForm;
	}
	/**
	 * ����������������� �������� üũ�Ѵ�.
	 * @return �����޽��� ���
	 */
	public List<String> validate(){
		ArrayList<String> list=new ArrayList<String>();
		
		//��ĭ ��ȿ�� ����
		BlankValidator blankValidator=new BlankValidator();
		if(blankValidator.validateBlank(tourPlanInfoForm.getDestination1()))
			list.add("������� �Է��ϼ���");
		if(blankValidator.validateBlank(tourPlanInfoForm.getDestination2()))
			list.add("�������� �Է��ϼ���");
		if(blankValidator.validateBlank(tourPlanInfoForm.getTitle()))
			list.add("������ �Է��ϼ���");
		if(blankValidator.validateBlank(tourPlanInfoForm.getContent()))
			list.add("������ �Է��ϼ���");
		if(blankValidator.validateBlank(tourPlanInfoForm.getRestrauntPreference()))
			list.add("���� ��ȣ���� �Է��ϼ���");
		if(blankValidator.validateBlank(tourPlanInfoForm.getHealingPreference()))
			list.add("���� ��ȣ���� �Է��ϼ���");
		if(blankValidator.validateBlank(tourPlanInfoForm.getAttractionPreference()))
			list.add("������� ��ȣ���� �Է��ϼ���");
		if(blankValidator.validateBlank(tourPlanInfoForm.getShoppingPreference()))
			list.add("���� ��ȣ���� �Է��ϼ���");
		if(blankValidator.validateBlank(tourPlanInfoForm.getEtcPreference()))
			list.add("��Ÿ ��ȣ���� �Է��ϼ���");
		
		return list;
	}
	/**
	 * ��������������� ��ȯ
	 * @return ���������������
	 */
	public TourPlanInfoForm getTourPlanInfoForm() {
		return tourPlanInfoForm;
	}
	/**
	 * ��������������� ����
	 * @param tourPlanInfoForm ���������������
	 */
	public void setTourPlanInfoForm(TourPlanInfoForm tourPlanInfoForm) {
		this.tourPlanInfoForm = tourPlanInfoForm;
	}
}
