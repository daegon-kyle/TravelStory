package validator;

import java.util.ArrayList;

import form.PostingInfoForm;
import java.util.*;
/**
 * 포스팅정보의 유효성을 검사하는 클래스
 * @author 대곤
 *
 */
public class PostingInfoValidator {
	/**
	 * 포스팅정보양식
	 */
	private PostingInfoForm postingInfoForm;
/**
 * 널생성자
 */
	public PostingInfoValidator() {
		this(new PostingInfoForm());
	}
	/**
	 * 기본생성자
	 * @param postingInfoForm 포스팅정보양식
	 */
	public PostingInfoValidator(PostingInfoForm postingInfoForm) {
		this.postingInfoForm = postingInfoForm;
	}
	/**
	 * 포스팅정보의 공백유무를 체크하는 메소드, BlankValidator의 validateBlank메소드 호출
	 * @return 에러메시지 목록
	 */
	public List<String> validate(){
		ArrayList<String> list=new ArrayList<String>();
		
		//빈칸 유효성 검증
		BlankValidator blankValidator=new BlankValidator();
		if(blankValidator.validateBlank(postingInfoForm.getTitle()))
			list.add("제목을 입력하세요");
		if(blankValidator.validateBlank(postingInfoForm.getContent()))
			list.add("내용을 입력하세요");
		
		return list;
	}
	/**
	 * 포스팅정보양식 반환
	 * @return 포스팅정보양식
	 */
	public PostingInfoForm getPostingInfoForm() {
		return postingInfoForm;
	}
	/**
	 * 포스팅정보양식 설정
	 * @param postingInfoForm 포스팅정보양식
	 */
	public void setPostingInfoForm(PostingInfoForm postingInfoForm) {
		this.postingInfoForm = postingInfoForm;
	}
	
	
}
