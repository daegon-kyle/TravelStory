package validator;

import form.EmptyRoomSearchForm;
import java.util.List;
import java.util.ArrayList;

public class EmptyRoomSearchValidator 
{
	private EmptyRoomSearchForm emptyRoomSearchForm;
	
	public EmptyRoomSearchValidator()
	{
		this(new EmptyRoomSearchForm());
	}
	
	public EmptyRoomSearchValidator(EmptyRoomSearchForm emptyRoomSearchForm)
	{
		this.emptyRoomSearchForm=emptyRoomSearchForm;
	}
	
	public List<String> validate()
	{
		ArrayList<String> list=new ArrayList<String>();
		
		//��ĭ ��ȿ�� ����
		BlankValidator blankValidator=new BlankValidator();
		if(blankValidator.validateBlank(emptyRoomSearchForm.getHotelLocation()))
			list.add("��ġ�� �Է��ϼ���");
		if(blankValidator.validateBlank(emptyRoomSearchForm.getDate()))
			list.add("��¥�� �Է��ϼ���");
	
		return list;
	}

}
  		
	 