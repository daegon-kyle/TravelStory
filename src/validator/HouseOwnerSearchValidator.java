package validator;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import form.HouseOwnerEssentialInfoForm;

public class HouseOwnerSearchValidator {
	
	private HouseOwnerEssentialInfoForm houseOwnerEssentialInfoForm;
	

	public HouseOwnerSearchValidator() {
		this(new HouseOwnerEssentialInfoForm());
	}


	public HouseOwnerSearchValidator(
			HouseOwnerEssentialInfoForm houseOwnerEssentialInfoForm) {
		this.houseOwnerEssentialInfoForm = houseOwnerEssentialInfoForm;
	}
	
	public HouseOwnerEssentialInfoForm getHouseOwnerEssentialInfoForm() {
		return houseOwnerEssentialInfoForm;
	}


	public void setHouseOwnerEssentialInfoForm(
			HouseOwnerEssentialInfoForm houseOwnerEssentialInfoForm) {
		this.houseOwnerEssentialInfoForm = houseOwnerEssentialInfoForm;
	}


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
		//��¥ ��ȿ�� ����
		
		GregorianCalendar start=new GregorianCalendar(Integer.parseInt(houseOwnerEssentialInfoForm.getVisitStartDate().substring(0, 4)), Integer.parseInt(houseOwnerEssentialInfoForm.getVisitStartDate().substring(5, 	7)), Integer.parseInt(houseOwnerEssentialInfoForm.getVisitStartDate().substring(8, 10)));
		GregorianCalendar end=new GregorianCalendar(Integer.parseInt(houseOwnerEssentialInfoForm.getVisitEndDate().substring(0, 4)), Integer.parseInt(houseOwnerEssentialInfoForm.getVisitEndDate().substring(5, 7)), Integer.parseInt(houseOwnerEssentialInfoForm.getVisitEndDate().substring(8, 10)));
			
		if( new DateValidator().validateDate(start, end) != "")
			list.add(new DateValidator().validateDate(start, end));
		
		return list;
	}
}
