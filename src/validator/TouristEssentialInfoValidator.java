package validator;

import form.TouristEssentialInfoForm;
import java.util.*;

/**
 * 여행객이 방문신청을 선택한 경우, 입력사항의 공백 및 날짜 정보를 체크하기 위한 클래스
 * @author 대곤
 *
 */
public class TouristEssentialInfoValidator {
	/**
	 * 여행객필수정보양식
	 */
	private TouristEssentialInfoForm touristEssentialInfoForm;
		/**
		 * 널생성자
		 */
	public TouristEssentialInfoValidator() {
		this(new TouristEssentialInfoForm());
	}
	/**
	 * 기본생성자
	 * @param touristEssentialInfoForm 여행객필수정보양식
	 */
	public TouristEssentialInfoValidator(
			TouristEssentialInfoForm touristEssentialInfoForm) {
		this.touristEssentialInfoForm = touristEssentialInfoForm;
	}
/**
 * 여행객필수정보양식의 공백유무 및 날짜를 체크하기 위한 메소드, BlankValidator의 validateBlank, DateValidator와 validateDate메소드 호출
 * @return 에러메시지 목록
 */
	public List<String> validate(){
		ArrayList<String> list=new ArrayList<String>();
		
		//빈칸 유효성 검증
		BlankValidator blankValidator=new BlankValidator();
		if(blankValidator.validateBlank(touristEssentialInfoForm.getVisitStartDate()))
			list.add("방문 시작날짜를 입력하세요");
		if(blankValidator.validateBlank(touristEssentialInfoForm.getVisitEndDate()))
			list.add("방문 끝날짜를 입력하세요");
		if(blankValidator.validateBlank(touristEssentialInfoForm.getCompanionNum()))
			list.add("동행자수를 입력하세요");
		if(blankValidator.validateBlank(touristEssentialInfoForm.getSelfIntroduction()))
			list.add("자기소개를 입력하세요");
		if(blankValidator.validateBlank(touristEssentialInfoForm.getJob()))
			list.add("직업을 입력하세요");
		
		//날짜 유효성 검증
		GregorianCalendar start=new GregorianCalendar(Integer.parseInt(touristEssentialInfoForm.getVisitStartDate().substring(0, 4)), Integer.parseInt(touristEssentialInfoForm.getVisitStartDate().substring(5, 7)), Integer.parseInt(touristEssentialInfoForm.getVisitStartDate().substring(8, 10)));
		GregorianCalendar end=new GregorianCalendar(Integer.parseInt(touristEssentialInfoForm.getVisitEndDate().substring(0, 4)), Integer.parseInt(touristEssentialInfoForm.getVisitEndDate().substring(5, 7)), Integer.parseInt(touristEssentialInfoForm.getVisitEndDate().substring(8, 10)));
				
		if( new DateValidator().validateDate(start, end) != "")
			list.add(new DateValidator().validateDate(start, end));
		
		return list;
	}
/**
 * 여행객필수정보양식 반환
 * @return 여행객필수정보양식
 */
	public TouristEssentialInfoForm getTouristEssentialInfoForm() {
		return touristEssentialInfoForm;
	}
	/**
	 * 여행객필수정보양식 설정
	 * @param touristEssentialInfoForm 여행객필수정보양식
	 */
	public void setTouristEssentialInfoForm(
			TouristEssentialInfoForm touristEssentialInfoForm) {
		this.touristEssentialInfoForm = touristEssentialInfoForm;
	}
	
	
}
