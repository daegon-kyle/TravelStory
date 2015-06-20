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
		
		//빈칸 유효성 검증
		BlankValidator blankValidator=new BlankValidator();
		if(blankValidator.validateBlank(emptyRoomSearchForm.getHotelLocation()))
			list.add("위치를 입력하세요");
		if(blankValidator.validateBlank(emptyRoomSearchForm.getDate()))
			list.add("날짜를 입력하세요");
	
		return list;
	}

}
  		
	 