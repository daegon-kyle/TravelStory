package validator;

import form.HouseOwnerEssentialInfoForm;
import converter.ConvertGregorianCalendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ArrayList;
/**
 * �������ʼ��Է»������� �˻��ϴ� Ŭ����
 * @author ���
 *
 */
public class HouseOwnerEssentialInfoValidator {
	/**
	 * ������ �ʼ��Է»�����
	 */
	private HouseOwnerEssentialInfoForm houseOwnerEssentialInfoForm;
/**
 * �λ�����
 */
	public HouseOwnerEssentialInfoValidator() {
		this(new HouseOwnerEssentialInfoForm());
	}
	/**
	 * �⺻������
	 * @param houseOwnerEssentialInfoForm
	 */
	public HouseOwnerEssentialInfoValidator(
			HouseOwnerEssentialInfoForm houseOwnerEssentialInfoForm) {
		this.houseOwnerEssentialInfoForm = houseOwnerEssentialInfoForm;
	}
/**
 * ��ĭ �� ��¥ ��ȿ�������ϴ� �޼ҵ�
 * @return
 */
	public List<String> validate(){
		ArrayList<String> list=new ArrayList<String>();
		
		//��ĭ ��ȿ�� ����
		BlankValidator blankValidator=new BlankValidator();
		if(blankValidator.validateBlank(houseOwnerEssentialInfoForm.getAddress()))
			list.add("���ּҸ� �Է����ּ���");
		if(blankValidator.validateBlank(houseOwnerEssentialInfoForm.getVisitStartDate()))
			list.add("�湮 ���۳�¥�� �Է����ּ���");
		if(blankValidator.validateBlank(houseOwnerEssentialInfoForm.getVisitEndDate()))
			list.add("�湮 ����¥�� �Է����ּ���");
		if(blankValidator.validateBlank(houseOwnerEssentialInfoForm.getJob()))
			list.add("������ �Է����ּ���");
		if(blankValidator.validateBlank(houseOwnerEssentialInfoForm.getMarriedState()))
			list.add("��ȥ������ �Է����ּ���");
		if(blankValidator.validateBlank(houseOwnerEssentialInfoForm.getSelfIntroduction()))
			list.add("�ڱ�Ұ��� �Է����ּ���");
		if(blankValidator.validateBlank(houseOwnerEssentialInfoForm.getEtc()))
			list.add("��Ÿ������ �Է����ּ���");
		
		//��¥ ��ȿ�� ����
		
		ConvertGregorianCalendar convertGregorianCalendar=new ConvertGregorianCalendar();
		
		
		GregorianCalendar start=convertGregorianCalendar.convert(houseOwnerEssentialInfoForm.getVisitStartDate());

		GregorianCalendar end=convertGregorianCalendar.convert(houseOwnerEssentialInfoForm.getVisitEndDate());

		if( new DateValidator().validateDate(start, end) != "")
			list.add(new DateValidator().validateDate(start, end));
		
		return list;
	}
	
	/**
	 * �������ʼ��������� ��ȯ�ϱ� ���� �޼ҵ�
	 * @return �������ʼ�������
	 */
	public HouseOwnerEssentialInfoForm getHouseOwnerEssentialInfoForm() {
		return houseOwnerEssentialInfoForm;
	}
	/**
	 * �������ʼ������� ����
	 * @param houseOwnerEssentialInfoForm �������ʼ�������
	 */
	public void setHouseOwnerEssentialInfoForm(
			HouseOwnerEssentialInfoForm houseOwnerEssentialInfoForm) {
		this.houseOwnerEssentialInfoForm = houseOwnerEssentialInfoForm;
	}
}
