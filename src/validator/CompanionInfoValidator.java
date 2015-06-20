package validator;

import form.CompanionInfoForm;
import java.util.*;
/**
 * CompanionInfoForm의 공백여부 체크하는 클래스
 * @author 대곤
 *
 */
public class CompanionInfoValidator {
	/**
	 * CompanionInfoForm 클래스(동행자포스팅)
	 */
	private CompanionInfoForm companionInfoForm;
	/**
	 * 널생성자
	 */
	public CompanionInfoValidator() {
		this(new CompanionInfoForm());
	}
	/**
	 * 기본생성자
	 * @param 사용자가 입력한 CompanionInfoForm 클래스
	 */
	public CompanionInfoValidator(CompanionInfoForm companionInfoForm) {
		this.companionInfoForm = companionInfoForm;
	}
	/**
	 * 빈칸+날짜 검사하는 메소드
	 * @return 오류메시지 목록 
	 */
	public List<String> validate(){
		ArrayList<String> list=new ArrayList<String>();
		
		//빈칸 유효성 검증
		BlankValidator blankValidator=new BlankValidator();
		if(blankValidator.validateBlank(companionInfoForm.getOtherGender()))
			list.add("상대방 성별을 입력하세요");
		if(blankValidator.validateBlank(companionInfoForm.getDestination1()))
			list.add("출발지를 입력하세요");
		if(blankValidator.validateBlank(companionInfoForm.getDestination2()))
			list.add("도착지를 입력하세요");
		if(blankValidator.validateBlank(companionInfoForm.getStartDate()))
			list.add("출발날짜를 입력하세요");
		if(blankValidator.validateBlank(companionInfoForm.getEndDate()))
			list.add("도착날짜를 입력하세요");
		if(blankValidator.validateBlank(companionInfoForm.getTitle()))
			list.add("제목을 입력하세요");
		if(blankValidator.validateBlank(companionInfoForm.getContent()))
			list.add("자기소개를 입력하세요");
		
		//날짜 유효성 검증
		GregorianCalendar start=new GregorianCalendar(Integer.parseInt(companionInfoForm.getStartDate().substring(0, 4)), Integer.parseInt(companionInfoForm.getStartDate().substring(4, 6)), Integer.parseInt(companionInfoForm.getStartDate().substring(6, 8)));
		GregorianCalendar end=new GregorianCalendar(Integer.parseInt(companionInfoForm.getEndDate().substring(0, 4)), Integer.parseInt(companionInfoForm.getEndDate().substring(4, 6)), Integer.parseInt(companionInfoForm.getEndDate().substring(6, 8)));
		
		if( new DateValidator().validateDate(start, end) != "")
			list.add(new DateValidator().validateDate(start, end));
		
		return list;
	}

/**
 * CompanionInfoForm 반환
 * @returnCompanionInfoForm
 */
	public CompanionInfoForm getCompanionInfoForm() {
		return companionInfoForm;
	}
	/**
	 * CompanionInfoForm의 설정
	 * @param  companionInfoForm
	 */
	public void setCompanionInfoForm(CompanionInfoForm companionInfoForm) {
		this.companionInfoForm = companionInfoForm;
	}
	
	
}
