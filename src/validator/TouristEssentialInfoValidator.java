package validator;

import form.TouristEssentialInfoForm;
import java.util.*;

/**
 * ���ఴ�� �湮��û�� ������ ���, �Է»����� ���� �� ��¥ ������ üũ�ϱ� ���� Ŭ����
 * @author ���
 *
 */
public class TouristEssentialInfoValidator {
	/**
	 * ���ఴ�ʼ��������
	 */
	private TouristEssentialInfoForm touristEssentialInfoForm;
		/**
		 * �λ�����
		 */
	public TouristEssentialInfoValidator() {
		this(new TouristEssentialInfoForm());
	}
	/**
	 * �⺻������
	 * @param touristEssentialInfoForm ���ఴ�ʼ��������
	 */
	public TouristEssentialInfoValidator(
			TouristEssentialInfoForm touristEssentialInfoForm) {
		this.touristEssentialInfoForm = touristEssentialInfoForm;
	}
/**
 * ���ఴ�ʼ���������� �������� �� ��¥�� üũ�ϱ� ���� �޼ҵ�, BlankValidator�� validateBlank, DateValidator�� validateDate�޼ҵ� ȣ��
 * @return �����޽��� ���
 */
	public List<String> validate(){
		ArrayList<String> list=new ArrayList<String>();
		
		//��ĭ ��ȿ�� ����
		BlankValidator blankValidator=new BlankValidator();
		if(blankValidator.validateBlank(touristEssentialInfoForm.getVisitStartDate()))
			list.add("�湮 ���۳�¥�� �Է��ϼ���");
		if(blankValidator.validateBlank(touristEssentialInfoForm.getVisitEndDate()))
			list.add("�湮 ����¥�� �Է��ϼ���");
		if(blankValidator.validateBlank(touristEssentialInfoForm.getCompanionNum()))
			list.add("�����ڼ��� �Է��ϼ���");
		if(blankValidator.validateBlank(touristEssentialInfoForm.getSelfIntroduction()))
			list.add("�ڱ�Ұ��� �Է��ϼ���");
		if(blankValidator.validateBlank(touristEssentialInfoForm.getJob()))
			list.add("������ �Է��ϼ���");
		
		//��¥ ��ȿ�� ����
		GregorianCalendar start=new GregorianCalendar(Integer.parseInt(touristEssentialInfoForm.getVisitStartDate().substring(0, 4)), Integer.parseInt(touristEssentialInfoForm.getVisitStartDate().substring(5, 7)), Integer.parseInt(touristEssentialInfoForm.getVisitStartDate().substring(8, 10)));
		GregorianCalendar end=new GregorianCalendar(Integer.parseInt(touristEssentialInfoForm.getVisitEndDate().substring(0, 4)), Integer.parseInt(touristEssentialInfoForm.getVisitEndDate().substring(5, 7)), Integer.parseInt(touristEssentialInfoForm.getVisitEndDate().substring(8, 10)));
				
		if( new DateValidator().validateDate(start, end) != "")
			list.add(new DateValidator().validateDate(start, end));
		
		return list;
	}
/**
 * ���ఴ�ʼ�������� ��ȯ
 * @return ���ఴ�ʼ��������
 */
	public TouristEssentialInfoForm getTouristEssentialInfoForm() {
		return touristEssentialInfoForm;
	}
	/**
	 * ���ఴ�ʼ�������� ����
	 * @param touristEssentialInfoForm ���ఴ�ʼ��������
	 */
	public void setTouristEssentialInfoForm(
			TouristEssentialInfoForm touristEssentialInfoForm) {
		this.touristEssentialInfoForm = touristEssentialInfoForm;
	}
	
	
}
