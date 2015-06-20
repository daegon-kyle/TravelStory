package validator;

import form.HotelInfoForm;
import java.util.*;
/**
 * 호텔정보폼 빈칸검사하는 클래스
 * @author 대곤
 *
 */
public class HotelInfoValidator {
	/**
	 * UI에서 사용자가 입력한, 숙박업체 등록을 하기 위해 필요한 폼 클래스
	 */
	private HotelInfoForm hotelInfoForm;
/**
 * 널생성자
 */
	public HotelInfoValidator() {
		this(new HotelInfoForm());
	}
	/**
	 * 기본생성자
	 * @param hotelInfoForm UI에서 사용자가 입력한, 숙박업체 등록을 하기 위해 필요한 폼 클래스
	 */
	public HotelInfoValidator(HotelInfoForm hotelInfoForm) {
		super();
		this.hotelInfoForm = hotelInfoForm;
	}
	/**
	 * 빈칸 유효성 검증하는 메소드
	 * @return 에러메시지 출력
	 */
	public List<String> validate(){
		ArrayList<String> list=new ArrayList<String>();
		
		//빈칸 유효성 검증
		BlankValidator blankValidator=new BlankValidator();
		if(blankValidator.validateBlank(hotelInfoForm.getHotelName()))
			list.add("호텔명을 입력하세요");
		if(blankValidator.validateBlank(hotelInfoForm.getHotelLocation()))
			list.add("호텔위치를 입력하세요");
		if(blankValidator.validateBlank(hotelInfoForm.getHotelIntroduction()))
			list.add("호텔소개를 입력하세요");
		if(blankValidator.validateBlank(hotelInfoForm.getHotelReservationPagePath()))
			list.add("호텔예약페이지를 입력하세요");
		
		
		return list;
	}
	/**
	 * 호텔정보폼 반환
	 * @return 호텔정보폼
	 */
	public HotelInfoForm getHotelInfoForm() {
		return hotelInfoForm;
	}
	/**
	 * 호텔정보 폼 설정
	 * @param hotelInfoForm 호텔정보폼
	 */
	public void setHotelInfoForm(HotelInfoForm hotelInfoForm) {
		this.hotelInfoForm = hotelInfoForm;
	}
}
