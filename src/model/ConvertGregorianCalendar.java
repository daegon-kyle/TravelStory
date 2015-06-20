package model;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

public class ConvertGregorianCalendar {
	public String convert(GregorianCalendar date){
		SimpleDateFormat simple = new SimpleDateFormat("yyyy/MM/dd");
		return simple.format(date.getTime());
	}
	
	public GregorianCalendar convert(String date){
		StringTokenizer token = new StringTokenizer(date, "/");
		int year = Integer.parseInt((String)token.nextElement());
		int month = Integer.parseInt((String)token.nextElement());
		int dayOfMonth = Integer.parseInt((String)token.nextElement());
		return new GregorianCalendar(year, month, dayOfMonth);
	}
}
