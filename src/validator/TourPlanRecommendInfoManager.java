package validator;

import java.util.*;

import form.TourPlanRecommendInfoForm;
/**
 * �������� ��õ���񽺸� ��û�� ���, �Է»����� ������ üũ�ϱ� ���� ���
 * @author ���
 *
 */
public class TourPlanRecommendInfoManager {
	/**
	 * ����������õ���
	 */
	private TourPlanRecommendInfoForm tourPlanRecommendInfoForm;
/**
 * �λ�����
 */
	public TourPlanRecommendInfoManager() {
		this(new TourPlanRecommendInfoForm());
	}
	/**
	 * �⺻������
	 * @param tourPlanRecommendInfoForm ����������õ���
	 */
	public TourPlanRecommendInfoManager(
			TourPlanRecommendInfoForm tourPlanRecommendInfoForm) {
		this.tourPlanRecommendInfoForm = tourPlanRecommendInfoForm;
	}
/**
 *  �������� �Է»����� ������ üũ�ϱ� ���� ���
 * @return �����޽��� ���
 */
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
	/**
	 * �������� �Է»��� ��ȯ
	 * @return �������� �Է»���
	 */
	public TourPlanRecommendInfoForm getTourPlanRecommendInfoForm() {
		return tourPlanRecommendInfoForm;
	}
	/**
	 * �������� �Է»��� ����
	 * @param tourPlanRecommendInfoForm �������� �Է»���
	 */
	public void setTourPlanRecommendInfoForm(
			TourPlanRecommendInfoForm tourPlanRecommendInfoForm) {
		this.tourPlanRecommendInfoForm = tourPlanRecommendInfoForm;
	}
	
	
}
