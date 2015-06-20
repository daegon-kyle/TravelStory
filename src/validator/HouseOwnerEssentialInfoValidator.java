package validator;

import form.HouseOwnerEssentialInfoForm;
import converter.ConvertGregorianCalendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ArrayList;
/**
 * 집주인필수입력사항폼을 검사하는 클래스
 * @author 대곤
 *
 */
public class HouseOwnerEssentialInfoValidator {
	/**
	 * 집주인 필수입력사항폼
	 */
	private HouseOwnerEssentialInfoForm houseOwnerEssentialInfoForm;
/**
 * 널생성자
 */
	public HouseOwnerEssentialInfoValidator() {
		this(new HouseOwnerEssentialInfoForm());
	}
	/**
	 * 기본생성자
	 * @param houseOwnerEssentialInfoForm
	 */
	public HouseOwnerEssentialInfoValidator(
			HouseOwnerEssentialInfoForm houseOwnerEssentialInfoForm) {
		this.houseOwnerEssentialInfoForm = houseOwnerEssentialInfoForm;
	}
/**
 * 빈칸 및 날짜 유효성검증하는 메소드
 * @return
 */
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
		if(blankValidator.validateBlank(houseOwnerEssentialInfoForm.getJob()))
			list.add("직업을 입력해주세요");
		if(blankValidator.validateBlank(houseOwnerEssentialInfoForm.getMarriedState()))
			list.add("결혼유무를 입력해주세요");
		if(blankValidator.validateBlank(houseOwnerEssentialInfoForm.getSelfIntroduction()))
			list.add("자기소개를 입력해주세요");
		if(blankValidator.validateBlank(houseOwnerEssentialInfoForm.getEtc()))
			list.add("기타정보를 입력해주세요");
		
		//날짜 유효성 검증
		
		ConvertGregorianCalendar convertGregorianCalendar=new ConvertGregorianCalendar();
		
		
		GregorianCalendar start=convertGregorianCalendar.convert(houseOwnerEssentialInfoForm.getVisitStartDate());

		GregorianCalendar end=convertGregorianCalendar.convert(houseOwnerEssentialInfoForm.getVisitEndDate());

		if( new DateValidator().validateDate(start, end) != "")
			list.add(new DateValidator().validateDate(start, end));
		
		return list;
	}
	
	/**
	 * 집주인필수정보폼을 반환하기 위한 메소드
	 * @return 집주인필수정보폼
	 */
	public HouseOwnerEssentialInfoForm getHouseOwnerEssentialInfoForm() {
		return houseOwnerEssentialInfoForm;
	}
	/**
	 * 집주인필수정보폼 설정
	 * @param houseOwnerEssentialInfoForm 집주인필수정보폼
	 */
	public void setHouseOwnerEssentialInfoForm(
			HouseOwnerEssentialInfoForm houseOwnerEssentialInfoForm) {
		this.houseOwnerEssentialInfoForm = houseOwnerEssentialInfoForm;
	}
}
