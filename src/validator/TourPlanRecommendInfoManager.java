package validator;

import java.util.*;

import form.TourPlanRecommendInfoForm;
/**
 * 여행일정 추천서비스를 요청한 경우, 입력사항의 공백을 체크하기 위해 사용
 * @author 대곤
 *
 */
public class TourPlanRecommendInfoManager {
	/**
	 * 여행일정추천양식
	 */
	private TourPlanRecommendInfoForm tourPlanRecommendInfoForm;
/**
 * 널생성자
 */
	public TourPlanRecommendInfoManager() {
		this(new TourPlanRecommendInfoForm());
	}
	/**
	 * 기본생성자
	 * @param tourPlanRecommendInfoForm 여행일정추천양식
	 */
	public TourPlanRecommendInfoManager(
			TourPlanRecommendInfoForm tourPlanRecommendInfoForm) {
		this.tourPlanRecommendInfoForm = tourPlanRecommendInfoForm;
	}
/**
 *  여행일정 입력사항의 공백을 체크하기 위해 사용
 * @return 에러메시지 목록
 */
	public List<String> validate(){
		ArrayList<String> list=new ArrayList<String>();
		
		//빈칸 유효성 검증
		BlankValidator blankValidator=new BlankValidator();
		if(blankValidator.validateBlank(tourPlanRecommendInfoForm.getDestination1()))
			list.add("출발지를 입력하세요");
		if(blankValidator.validateBlank(tourPlanRecommendInfoForm.getDestination2()))
			list.add("도착지를 입력하세요");
		if(blankValidator.validateBlank(tourPlanRecommendInfoForm.getRestrauntPreference()))
			list.add("맛집 선호도를 입력하세요");
		if(blankValidator.validateBlank(tourPlanRecommendInfoForm.getHealingPreference()))
			list.add("힐링 선호도를 입력하세요");
		if(blankValidator.validateBlank(tourPlanRecommendInfoForm.getAttractionPreference()))
			list.add("관광명소 선호도를 입력하세요");
		if(blankValidator.validateBlank(tourPlanRecommendInfoForm.getShoppingPreference()))
			list.add("쇼핑 선호도를 입력하세요");
		if(blankValidator.validateBlank(tourPlanRecommendInfoForm.getEtcPreference()))
			list.add("기타 선호도를 입력하세요");
		
		return list;
	}
	/**
	 * 여행일정 입력사항 반환
	 * @return 여행일정 입력사항
	 */
	public TourPlanRecommendInfoForm getTourPlanRecommendInfoForm() {
		return tourPlanRecommendInfoForm;
	}
	/**
	 * 여행일정 입력사항 설정
	 * @param tourPlanRecommendInfoForm 여행일정 입력사항
	 */
	public void setTourPlanRecommendInfoForm(
			TourPlanRecommendInfoForm tourPlanRecommendInfoForm) {
		this.tourPlanRecommendInfoForm = tourPlanRecommendInfoForm;
	}
	
	
}
