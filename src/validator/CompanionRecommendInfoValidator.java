package validator;

import form.CompanionRecommendInfoForm;
import java.util.*;
/**
 * CompanionRecommendInfoForm의 공백여부 체크하는 클래스
 * @author 대곤
 *
 */
public class CompanionRecommendInfoValidator {
	/**
	 *  CompanionRecommendInfoForm 클래스(동행자추천하기)
	 */
	private CompanionRecommendInfoForm companionRecommendInfoForm;
/**
 * 널생성자
 */
	public CompanionRecommendInfoValidator() {
		this(new CompanionRecommendInfoForm());
	}
	/**
	 * 기본생성자
	 * @param CompanionRecommendInfoForm
	 */
	public CompanionRecommendInfoValidator(
			CompanionRecommendInfoForm companionRecommendInfoForm) {
		this.companionRecommendInfoForm = companionRecommendInfoForm;
	}
	/**
	 * 사용자가 입력한 CompanionRecommendInfoForm 공백+날짜유효성 검사
	 * @return 에러메시지 목록
	 */
	public List<String> validate(){
		ArrayList<String> list=new ArrayList<String>();
		
		//빈칸 유효성 검증
		BlankValidator blankValidator=new BlankValidator();
		if(blankValidator.validateBlank(companionRecommendInfoForm.getOtherGender()))
			list.add("상대방 성별을 입력하세요");
		if(blankValidator.validateBlank(companionRecommendInfoForm.getDestination1()))
			list.add("출발지를 입력하세요");
		if(blankValidator.validateBlank(companionRecommendInfoForm.getDestination2()))
			list.add("도착지를 입력하세요");
		if(blankValidator.validateBlank(companionRecommendInfoForm.getStartDate()))
			list.add("출발날짜를 입력하세요");
		if(blankValidator.validateBlank(companionRecommendInfoForm.getEndDate()))
			list.add("도착날짜를 입력하세요");
		if(blankValidator.validateBlank(companionRecommendInfoForm.getOtherAge()))
			list.add("상대방 나이를 입력하세요");
		
		//날짜 유효성 검증
		// 시작일
		StringTokenizer token = new StringTokenizer(companionRecommendInfoForm.getStartDate(), "-");
		int year = Integer.parseInt((String)token.nextElement());
		int month = Integer.parseInt((String)token.nextElement());
		int dayOfMonth = Integer.parseInt((String)token.nextElement());
		GregorianCalendar start=new GregorianCalendar(year, month-1, dayOfMonth);
		// 종료일
		token = new StringTokenizer(companionRecommendInfoForm.getEndDate(), "-");
		year = Integer.parseInt((String)token.nextElement());
		month = Integer.parseInt((String)token.nextElement());
		GregorianCalendar end=new GregorianCalendar(year, month-1, dayOfMonth);
		if( new DateValidator().validateDate(start, end) != "")
			list.add(new DateValidator().validateDate(start, end));
		
		return list;
	}
	/**
	 * CompanionRecommendInfoForm(동행자추천하기)반환
	 * @return  CompanionRecommendInfoForm(동행자추천하기)
	 */
	public CompanionRecommendInfoForm getCompanionRecommendInfoForm() {
		return companionRecommendInfoForm;
	}
	/**
	 *CompanionRecommendInfoForm(동행자추천하기)로 설정
	 * @param CompanionRecommendInfoForm(동행자추천하기)
	 */
	public void setCompanionRecommendInfoForm(
			CompanionRecommendInfoForm companionRecommendInfoForm) {
		this.companionRecommendInfoForm = companionRecommendInfoForm;
	}
}
