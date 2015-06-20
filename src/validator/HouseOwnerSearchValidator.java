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
		
		//빈칸 유효성 검증
		BlankValidator blankValidator=new BlankValidator();
		if(blankValidator.validateBlank(houseOwnerEssentialInfoForm.getAddress()))
			list.add("상세주소를 입력해주세요");
		if(blankValidator.validateBlank(houseOwnerEssentialInfoForm.getVisitStartDate()))
			list.add("방문 시작날짜를 입력해주세요");
		if(blankValidator.validateBlank(houseOwnerEssentialInfoForm.getVisitEndDate()))
			list.add("방문 끝날짜를 입력해주세요");	
		//날짜 유효성 검증
		
		GregorianCalendar start=new GregorianCalendar(Integer.parseInt(houseOwnerEssentialInfoForm.getVisitStartDate().substring(0, 4)), Integer.parseInt(houseOwnerEssentialInfoForm.getVisitStartDate().substring(5, 	7)), Integer.parseInt(houseOwnerEssentialInfoForm.getVisitStartDate().substring(8, 10)));
		GregorianCalendar end=new GregorianCalendar(Integer.parseInt(houseOwnerEssentialInfoForm.getVisitEndDate().substring(0, 4)), Integer.parseInt(houseOwnerEssentialInfoForm.getVisitEndDate().substring(5, 7)), Integer.parseInt(houseOwnerEssentialInfoForm.getVisitEndDate().substring(8, 10)));
			
		if( new DateValidator().validateDate(start, end) != "")
			list.add(new DateValidator().validateDate(start, end));
		
		return list;
	}
}
