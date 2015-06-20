package validator;

import form.TourPreparationRecommendInfoForm;
import java.util.*;
/**
 * �����غ���õ���񽺸� ��û�� ��, �Է»����� ���������� üũ�ϱ� ���� ����ϴ� �޼ҵ�
 * @author ���
 *
 */
public class TourPreparationRecommendInfoValidator {
	/**
	 * �����غ� ���
	 */
	private TourPreparationRecommendInfoForm tourPreparationRecommendInfoForm;
/**
 * �λ�����
 */
	public TourPreparationRecommendInfoValidator() {
		this(new TourPreparationRecommendInfoForm());
	}
	/**
	 * �⺻������
	 * @param tourPreparationRecommendInfoForm �����غ� ���
	 */
	public TourPreparationRecommendInfoValidator(
			TourPreparationRecommendInfoForm tourPreparationRecommendInfoForm) {
		super();
		this.tourPreparationRecommendInfoForm = tourPreparationRecommendInfoForm;
	}
	/**
	 * �����غ���õ������ ���������� üũ���ִ� �޼ҵ�, blankValidator�� validateBlank�޼ҵ� ȣ��
	 * @return �����޽��� ���
	 */
	public List<String> validate(){
		ArrayList<String> list=new ArrayList<String>();
		
		//��ĭ ��ȿ�� ����
		BlankValidator blankValidator=new BlankValidator();
		if(blankValidator.validateBlank(tourPreparationRecommendInfoForm.getDestination1()))
			list.add("������� �Է��ϼ���");
		if(blankValidator.validateBlank(tourPreparationRecommendInfoForm.getDestination2()))
			list.add("�������� �Է��ϼ���");
		if(blankValidator.validateBlank(tourPreparationRecommendInfoForm.getStartDate()))
			list.add("��߳�¥�� �Է��ϼ���");
		if(blankValidator.validateBlank(tourPreparationRecommendInfoForm.getEndDate()))
			list.add("������¥�� �Է��ϼ���");

		//��¥ ��ȿ�� ����
				// ������
				StringTokenizer token = new StringTokenizer(tourPreparationRecommendInfoForm.getStartDate(), "-");
				int year = Integer.parseInt((String)token.nextElement());
				int month = Integer.parseInt((String)token.nextElement());
				int dayOfMonth = Integer.parseInt((String)token.nextElement());
				GregorianCalendar start=new GregorianCalendar(year, month-1, dayOfMonth);
				// ������
				token = new StringTokenizer(tourPreparationRecommendInfoForm.getEndDate(), "-");
				year = Integer.parseInt((String)token.nextElement());
				month = Integer.parseInt((String)token.nextElement());
				GregorianCalendar end=new GregorianCalendar(year, month-1, dayOfMonth);
		if( new DateValidator().validateDate(start, end) != "")
			list.add(new DateValidator().validateDate(start, end));
		
		return list;
	}
	/**
	 * �����غ� ��� ��ȯ
	 * @return �����غ� ���
	 */
	public TourPreparationRecommendInfoForm getTourPreparationRecommendInfoForm() {
		return tourPreparationRecommendInfoForm;
	}
	/**
	 * �����غ� ��� ����
	 * @param tourPreparationRecommendInfoForm �����غ� ���
	 */
	public void setTourPreparationRecommendInfoForm(
			TourPreparationRecommendInfoForm tourPreparationRecommendInfoForm) {
		this.tourPreparationRecommendInfoForm = tourPreparationRecommendInfoForm;
	}
	
	
}
