package validator;

import java.util.*;

import form.TourPlanRecommendInfoForm;

public class TourPlanRecommendInfoValidator {
	private TourPlanRecommendInfoForm tourPlanRecommendInfoForm;

	public TourPlanRecommendInfoValidator() {
		this(new TourPlanRecommendInfoForm());
	}
	public TourPlanRecommendInfoValidator(
			TourPlanRecommendInfoForm tourPlanRecommendInfoForm) {
		super();
		this.tourPlanRecommendInfoForm = tourPlanRecommendInfoForm;
	}

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
	
	public TourPlanRecommendInfoForm getTourPlanRecommendInfoForm() {
		return tourPlanRecommendInfoForm;
	}
	public void setTourPlanRecommendInfoForm(
			TourPlanRecommendInfoForm tourPlanRecommendInfoForm) {
		this.tourPlanRecommendInfoForm = tourPlanRecommendInfoForm;
	}
	
	
}
