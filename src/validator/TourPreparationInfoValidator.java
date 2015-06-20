package validator;

import form.TourPreparationInfoForm;
import java.util.*;
/**
 * 여행준비물 포스팅을 하기 위해 입력한 양식을 체크하기 위해 사용하는 클래스  
 * @author 대곤
 *
 */
public class TourPreparationInfoValidator {
	/**
	 * 여행준비물 양식
	 */
	private TourPreparationInfoForm tourPreparationInfoForm;
/**
 * 널생성자
 */
	public TourPreparationInfoValidator() {
		this(new TourPreparationInfoForm());
	}
	/**
	 * 기본생성자
	 * @param tourPreparationInfoForm
	 */
	public TourPreparationInfoValidator(
			TourPreparationInfoForm tourPreparationInfoForm) {
		this.tourPreparationInfoForm = tourPreparationInfoForm;
	}
/**
 * 여행준비물 양식의 공백을 체크하기 위해 사용하는 메소드, BlankValidator의 validateBlank 메소드 호출
 * @return 에러메시지 목록
 */
	public List<String> validate(){
		ArrayList<String> list=new ArrayList<String>();
		
		//빈칸 유효성 검증
		BlankValidator blankValidator=new BlankValidator();
		if(blankValidator.validateBlank(tourPreparationInfoForm.getDestination1()))
			list.add("출발지를 입력하세요");
		if(blankValidator.validateBlank(tourPreparationInfoForm.getDestination2()))
			list.add("도착지를 입력하세요");
		if(blankValidator.validateBlank(tourPreparationInfoForm.getStartDate()))
			list.add("출발날짜를 입력하세요");
		if(blankValidator.validateBlank(tourPreparationInfoForm.getEndDate()))
			list.add("도착날짜를 입력하세요");
		if(blankValidator.validateBlank(tourPreparationInfoForm.getTitle()))
			list.add("제목을 입력하세요");
		if(blankValidator.validateBlank(tourPreparationInfoForm.getContent()))
			list.add("내용을 입력하세요");
		
		//날짜 유효성 검증
		GregorianCalendar start=new GregorianCalendar(Integer.parseInt(tourPreparationInfoForm.getStartDate().substring(0, 4)), Integer.parseInt(tourPreparationInfoForm.getStartDate().substring(4, 6)), Integer.parseInt(tourPreparationInfoForm.getStartDate().substring(6, 8)));
		GregorianCalendar end=new GregorianCalendar(Integer.parseInt(tourPreparationInfoForm.getEndDate().substring(0, 4)), Integer.parseInt(tourPreparationInfoForm.getEndDate().substring(4, 6)), Integer.parseInt(tourPreparationInfoForm.getEndDate().substring(6, 8)));
		
		if( new DateValidator().validateDate(start, end) != "")
			list.add(new DateValidator().validateDate(start, end));
		
		return list;
	}
	/**
	 * 여행준비물 양식 반환
	 * @return 여행준비물 양식
	 */
	public TourPreparationInfoForm getTourPreparationInfoForm() {
		return tourPreparationInfoForm;
	}
	/**
	 * 여행준비물 양식 설정
	 * @param tourPreparationInfoForm 여행준비물 양식
	 */
	public void setTourPreparationInfoForm(
			TourPreparationInfoForm tourPreparationInfoForm) {
		this.tourPreparationInfoForm = tourPreparationInfoForm;
	}
	
}
