package validator;

import form.EmptyRoomInfoForm;
import java.util.*;
/**
 * ������������� ������ üũ�ϱ� ���� Ŭ����
 * @author ���
 *
 */
public class EmptyRoomInfoValidator {
	/**
	 * ����������
	 */
	private EmptyRoomInfoForm emptyRoomInfoForm;
/**
 * �λ�����
 */
	public EmptyRoomInfoValidator() {
		this(new EmptyRoomInfoForm());
	}
	/**
	 * �⺻������
	 * @param emptyRoomInfoForm ����������(UI���� �Է�)
	 */
	public EmptyRoomInfoValidator(EmptyRoomInfoForm emptyRoomInfoForm) {
		this.emptyRoomInfoForm = emptyRoomInfoForm;
	}
/**
 * ��ĭ��ȿ������+��¥���� ��ȿ������
 * @return
 */
	public List<String> validate(){
		ArrayList<String> list=new ArrayList<String>();
		
		//��ĭ ��ȿ�� ����
		BlankValidator blankValidator=new BlankValidator();
		if(blankValidator.validateBlank(emptyRoomInfoForm.getEmptyRoomName()))
			list.add("�����̸���  �Է����ּ���");
		if(blankValidator.validateBlank(emptyRoomInfoForm.getOldPrice()))
			list.add("����������  �Է����ּ���");
		if(blankValidator.validateBlank(emptyRoomInfoForm.getDiscountPrice()))
			list.add("���ΰ����� �Է����ּ���");
		if(blankValidator.validateBlank(emptyRoomInfoForm.getSpace()))
			list.add("����� �Է����ּ���");
		if(blankValidator.validateBlank(emptyRoomInfoForm.getCheckInTime()))
			list.add("üũ�νð��� �Է����ּ���");
		if(blankValidator.validateBlank(emptyRoomInfoForm.getCheckOutTime()))
			list.add("üũ�ƿ��ð��� �Է����ּ���");
		if(blankValidator.validateBlank(emptyRoomInfoForm.getFacilityList()))
			list.add("�̿밡�ɽü�1�� �Է����ּ���");
		if(blankValidator.validateBlank(emptyRoomInfoForm.getEtc()))
			list.add("��Ÿ������ �Է����ּ���");
		
		return list;
	}
	/**
	 * ���������� ��ȯ
	 * @return ����������
	 */
	public EmptyRoomInfoForm getEmptyRoomInfoForm() {
		return emptyRoomInfoForm;
	}
	/**
	 * ���������� ����
	 * @param emptyRoomInfoForm ����������
	 */
	public void setEmptyRoomInfoForm(EmptyRoomInfoForm emptyRoomInfoForm) {
		this.emptyRoomInfoForm = emptyRoomInfoForm;
	}
}
