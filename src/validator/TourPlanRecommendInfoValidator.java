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
		
		//��ĭ ��ȿ�� ����
		BlankValidator blankValidator=new BlankValidator();
		if(blankValidator.validateBlank(tourPlanRecommendInfoForm.getDestination1()))
			list.add("������� �Է��ϼ���");
		if(blankValidator.validateBlank(tourPlanRecommendInfoForm.getDestination2()))
			list.add("�������� �Է��ϼ���");
		if(blankValidator.validateBlank(tourPlanRecommendInfoForm.getRestrauntPreference()))
			list.add("���� ��ȣ���� �Է��ϼ���");
		if(blankValidator.validateBlank(tourPlanRecommendInfoForm.getHealingPreference()))
			list.add("���� ��ȣ���� �Է��ϼ���");
		if(blankValidator.validateBlank(tourPlanRecommendInfoForm.getAttractionPreference()))
			list.add("������� ��ȣ���� �Է��ϼ���");
		if(blankValidator.validateBlank(tourPlanRecommendInfoForm.getShoppingPreference()))
			list.add("���� ��ȣ���� �Է��ϼ���");
		if(blankValidator.validateBlank(tourPlanRecommendInfoForm.getEtcPreference()))
			list.add("��Ÿ ��ȣ���� �Է��ϼ���");
		
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
