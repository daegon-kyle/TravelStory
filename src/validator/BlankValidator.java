package validator;

public class BlankValidator {
	
	public boolean validateBlank(String str){
		if(str=="")
			return true;	//ºóÄ­ÀÌ¸é Âü
		else
			return false;	//ºóÄ­¾Æ´Ï¸é °ÅÁş 
	}
}
