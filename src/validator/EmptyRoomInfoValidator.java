package validator;

import form.EmptyRoomInfoForm;
import java.util.*;
/**
 * 공실정보등록한 정보를 체크하기 위한 클래스
 * @author 대곤
 *
 */
public class EmptyRoomInfoValidator {
	/**
	 * 공실정보폼
	 */
	private EmptyRoomInfoForm emptyRoomInfoForm;
/**
 * 널생성자
 */
	public EmptyRoomInfoValidator() {
		this(new EmptyRoomInfoForm());
	}
	/**
	 * 기본생성자
	 * @param emptyRoomInfoForm 공실정보폼(UI에서 입력)
	 */
	public EmptyRoomInfoValidator(EmptyRoomInfoForm emptyRoomInfoForm) {
		this.emptyRoomInfoForm = emptyRoomInfoForm;
	}
/**
 * 빈칸유효성검증+날짜정보 유효성검증
 * @return
 */
	public List<String> validate(){
		ArrayList<String> list=new ArrayList<String>();
		
		//빈칸 유효성 검증
		BlankValidator blankValidator=new BlankValidator();
		if(blankValidator.validateBlank(emptyRoomInfoForm.getEmptyRoomName()))
			list.add("공실이름을  입력해주세요");
		if(blankValidator.validateBlank(emptyRoomInfoForm.getOldPrice()))
			list.add("기존가격을  입력해주세요");
		if(blankValidator.validateBlank(emptyRoomInfoForm.getDiscountPrice()))
			list.add("할인가격을 입력해주세요");
		if(blankValidator.validateBlank(emptyRoomInfoForm.getSpace()))
			list.add("평수를 입력해주세요");
		if(blankValidator.validateBlank(emptyRoomInfoForm.getCheckInTime()))
			list.add("체크인시간을 입력해주세요");
		if(blankValidator.validateBlank(emptyRoomInfoForm.getCheckOutTime()))
			list.add("체크아웃시간을 입력해주세요");
		if(blankValidator.validateBlank(emptyRoomInfoForm.getFacilityList()))
			list.add("이용가능시설1을 입력해주세요");
		if(blankValidator.validateBlank(emptyRoomInfoForm.getEtc()))
			list.add("기타정보를 입력해주세요");
		
		return list;
	}
	/**
	 * 공실정보폼 반환
	 * @return 공실정보폼
	 */
	public EmptyRoomInfoForm getEmptyRoomInfoForm() {
		return emptyRoomInfoForm;
	}
	/**
	 * 공실정보폼 설정
	 * @param emptyRoomInfoForm 공실정보폼
	 */
	public void setEmptyRoomInfoForm(EmptyRoomInfoForm emptyRoomInfoForm) {
		this.emptyRoomInfoForm = emptyRoomInfoForm;
	}
}
