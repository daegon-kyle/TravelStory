package validator;

import java.util.ArrayList;

import form.PostingInfoForm;
import java.util.*;
/**
 * ������������ ��ȿ���� �˻��ϴ� Ŭ����
 * @author ���
 *
 */
public class PostingInfoValidator {
	/**
	 * �������������
	 */
	private PostingInfoForm postingInfoForm;
/**
 * �λ�����
 */
	public PostingInfoValidator() {
		this(new PostingInfoForm());
	}
	/**
	 * �⺻������
	 * @param postingInfoForm �������������
	 */
	public PostingInfoValidator(PostingInfoForm postingInfoForm) {
		this.postingInfoForm = postingInfoForm;
	}
	/**
	 * ������������ ���������� üũ�ϴ� �޼ҵ�, BlankValidator�� validateBlank�޼ҵ� ȣ��
	 * @return �����޽��� ���
	 */
	public List<String> validate(){
		ArrayList<String> list=new ArrayList<String>();
		
		//��ĭ ��ȿ�� ����
		BlankValidator blankValidator=new BlankValidator();
		if(blankValidator.validateBlank(postingInfoForm.getTitle()))
			list.add("������ �Է��ϼ���");
		if(blankValidator.validateBlank(postingInfoForm.getContent()))
			list.add("������ �Է��ϼ���");
		
		return list;
	}
	/**
	 * ������������� ��ȯ
	 * @return �������������
	 */
	public PostingInfoForm getPostingInfoForm() {
		return postingInfoForm;
	}
	/**
	 * ������������� ����
	 * @param postingInfoForm �������������
	 */
	public void setPostingInfoForm(PostingInfoForm postingInfoForm) {
		this.postingInfoForm = postingInfoForm;
	}
	
	
}
