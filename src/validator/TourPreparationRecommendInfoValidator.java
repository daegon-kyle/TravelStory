package validator;

import form.TourPreparationRecommendInfoForm;
import java.util.*;
/**
 * 여행준비물추천서비스를 요청한 후, 입력사항의 공백유무를 체크하기 위해 사용하는 메소드
 * @author 대곤
 *
 */
public class TourPreparationRecommendInfoValidator {
	/**
	 * 여행준비물 양식
	 */
	private TourPreparationRecommendInfoForm tourPreparationRecommendInfoForm;
/**
 * 널생성자
 */
	public TourPreparationRecommendInfoValidator() {
		this(new TourPreparationRecommendInfoForm());
	}
	/**
	 * 기본생성자
	 * @param tourPreparationRecommendInfoForm 여행준비물 양식
	 */
	public TourPreparationRecommendInfoValidator(
			TourPreparationRecommendInfoForm tourPreparationRecommendInfoForm) {
		super();
		this.tourPreparationRecommendInfoForm = tourPreparationRecommendInfoForm;
	}
	/**
	 * 여행준비물추천서비스의 공백유무를 체크해주는 메소드, blankValidator의 validateBlank메소드 호출
	 * @return 에러메시지 목록
	 */
	public List<String> validate(){
		ArrayList<String> list=new ArrayList<String>();
		
		//빈칸 유효성 검증
		BlankValidator blankValidator=new BlankValidator();
		if(blankValidator.validateBlank(tourPreparationRecommendInfoForm.getDestination1()))
			list.add("출발지를 입력하세요");
		if(blankValidator.validateBlank(tourPreparationRecommendInfoForm.getDestination2()))
			list.add("도착지를 입력하세요");
		if(blankValidator.validateBlank(tourPreparationRecommendInfoForm.getStartDate()))
			list.add("출발날짜를 입력하세요");
		if(blankValidator.validateBlank(tourPreparationRecommendInfoForm.getEndDate()))
			list.add("도착날짜를 입력하세요");

		//날짜 유효성 검증
				// 시작일
				StringTokenizer token = new StringTokenizer(tourPreparationRecommendInfoForm.getStartDate(), "-");
				int year = Integer.parseInt((String)token.nextElement());
				int month = Integer.parseInt((String)token.nextElement());
				int dayOfMonth = Integer.parseInt((String)token.nextElement());
				GregorianCalendar start=new GregorianCalendar(year, month-1, dayOfMonth);
				// 종료일
				token = new StringTokenizer(tourPreparationRecommendInfoForm.getEndDate(), "-");
				year = Integer.parseInt((String)token.nextElement());
				month = Integer.parseInt((String)token.nextElement());
				GregorianCalendar end=new GregorianCalendar(year, month-1, dayOfMonth);
		if( new DateValidator().validateDate(start, end) != "")
			list.add(new DateValidator().validateDate(start, end));
		
		return list;
	}
	/**
	 * 여행준비물 양식 반환
	 * @return 여행준비물 양식
	 */
	public TourPreparationRecommendInfoForm getTourPreparationRecommendInfoForm() {
		return tourPreparationRecommendInfoForm;
	}
	/**
	 * 여행준비물 양식 설정
	 * @param tourPreparationRecommendInfoForm 여행준비물 양식
	 */
	public void setTourPreparationRecommendInfoForm(
			TourPreparationRecommendInfoForm tourPreparationRecommendInfoForm) {
		this.tourPreparationRecommendInfoForm = tourPreparationRecommendInfoForm;
	}
	
	
}
