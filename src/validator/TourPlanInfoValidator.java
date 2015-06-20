package validator;

import form.TourPlanInfoForm;
import java.util.*;
/**
 * 여행일정추천포스팅을 신청하였을 떄 입력하기 위해 사용하는 클래스
 * @author 대곤
 *
 */
public class TourPlanInfoValidator {
	/**
	 * 여행일정정보양식
	 */
	private TourPlanInfoForm tourPlanInfoForm;
/**
 * 널생성자
 */
	public TourPlanInfoValidator() {
		this(new TourPlanInfoForm());
	}
	/**
	 * 기본생성자
	 * @param tourPlanInfoForm
	 */
	public TourPlanInfoValidator(TourPlanInfoForm tourPlanInfoForm) {
		this.tourPlanInfoForm = tourPlanInfoForm;
	}
	/**
	 * 여행일정정보양식의 공백유무 체크한다.
	 * @return 에러메시지 목록
	 */
	public List<String> validate(){
		ArrayList<String> list=new ArrayList<String>();
		
		//빈칸 유효성 검증
		BlankValidator blankValidator=new BlankValidator();
		if(blankValidator.validateBlank(tourPlanInfoForm.getDestination1()))
			list.add("출발지를 입력하세요");
		if(blankValidator.validateBlank(tourPlanInfoForm.getDestination2()))
			list.add("도착지를 입력하세요");
		if(blankValidator.validateBlank(tourPlanInfoForm.getTitle()))
			list.add("제목을 입력하세요");
		if(blankValidator.validateBlank(tourPlanInfoForm.getContent()))
			list.add("내용을 입력하세요");
		if(blankValidator.validateBlank(tourPlanInfoForm.getRestrauntPreference()))
			list.add("맛집 선호도를 입력하세요");
		if(blankValidator.validateBlank(tourPlanInfoForm.getHealingPreference()))
			list.add("힐링 선호도를 입력하세요");
		if(blankValidator.validateBlank(tourPlanInfoForm.getAttractionPreference()))
			list.add("관광명소 선호도를 입력하세요");
		if(blankValidator.validateBlank(tourPlanInfoForm.getShoppingPreference()))
			list.add("쇼핑 선호도를 입력하세요");
		if(blankValidator.validateBlank(tourPlanInfoForm.getEtcPreference()))
			list.add("기타 선호도를 입력하세요");
		
		return list;
	}
	/**
	 * 여행일정정보양식 반환
	 * @return 여행일정정보양식
	 */
	public TourPlanInfoForm getTourPlanInfoForm() {
		return tourPlanInfoForm;
	}
	/**
	 * 여행일정정보양식 설정
	 * @param tourPlanInfoForm 여행일정정보양식
	 */
	public void setTourPlanInfoForm(TourPlanInfoForm tourPlanInfoForm) {
		this.tourPlanInfoForm = tourPlanInfoForm;
	}
}
