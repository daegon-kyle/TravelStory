package validator;

import form.HotelInfoForm;
import java.util.*;
/**
 * ȣ�������� ��ĭ�˻��ϴ� Ŭ����
 * @author ���
 *
 */
public class HotelInfoValidator {
	/**
	 * UI���� ����ڰ� �Է���, ���ھ�ü ����� �ϱ� ���� �ʿ��� �� Ŭ����
	 */
	private HotelInfoForm hotelInfoForm;
/**
 * �λ�����
 */
	public HotelInfoValidator() {
		this(new HotelInfoForm());
	}
	/**
	 * �⺻������
	 * @param hotelInfoForm UI���� ����ڰ� �Է���, ���ھ�ü ����� �ϱ� ���� �ʿ��� �� Ŭ����
	 */
	public HotelInfoValidator(HotelInfoForm hotelInfoForm) {
		super();
		this.hotelInfoForm = hotelInfoForm;
	}
	/**
	 * ��ĭ ��ȿ�� �����ϴ� �޼ҵ�
	 * @return �����޽��� ���
	 */
	public List<String> validate(){
		ArrayList<String> list=new ArrayList<String>();
		
		//��ĭ ��ȿ�� ����
		BlankValidator blankValidator=new BlankValidator();
		if(blankValidator.validateBlank(hotelInfoForm.getHotelName()))
			list.add("ȣ�ڸ��� �Է��ϼ���");
		if(blankValidator.validateBlank(hotelInfoForm.getHotelLocation()))
			list.add("ȣ����ġ�� �Է��ϼ���");
		if(blankValidator.validateBlank(hotelInfoForm.getHotelIntroduction()))
			list.add("ȣ�ڼҰ��� �Է��ϼ���");
		if(blankValidator.validateBlank(hotelInfoForm.getHotelReservationPagePath()))
			list.add("ȣ�ڿ����������� �Է��ϼ���");
		
		
		return list;
	}
	/**
	 * ȣ�������� ��ȯ
	 * @return ȣ��������
	 */
	public HotelInfoForm getHotelInfoForm() {
		return hotelInfoForm;
	}
	/**
	 * ȣ������ �� ����
	 * @param hotelInfoForm ȣ��������
	 */
	public void setHotelInfoForm(HotelInfoForm hotelInfoForm) {
		this.hotelInfoForm = hotelInfoForm;
	}
}
