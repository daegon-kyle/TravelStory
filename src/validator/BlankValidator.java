package validator;

public class BlankValidator {
	
	public boolean validateBlank(String str){
		if(str=="")
			return true;	//��ĭ�̸� ��
		else
			return false;	//��ĭ�ƴϸ� ���� 
	}
}
