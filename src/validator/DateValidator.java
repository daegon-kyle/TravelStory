package validator;

import java.util.GregorianCalendar;

public class DateValidator {
	public String validateDate(GregorianCalendar date1, GregorianCalendar date2){
		String temp="";
		if( date1.compareTo(date2)>0 ){
			temp=("끝날짜가 시작날짜보다 우선합니다.");
		}
		return temp;
	}
}
