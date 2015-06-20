package model;

import java.util.GregorianCalendar;

public class MemberInfo implements  java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3817381031258873474L;
	private String name;
	private String email;
	private String password;
	private GregorianCalendar birthDate;
	private String gender;
	private String phone;
	private String memberCode;
	private String memberLevel;
	private int reliability;
	
	
	public MemberInfo() {
		this("","","",new GregorianCalendar(), "","","","",0);
	}
	public MemberInfo(String email, String password,
			GregorianCalendar birthDate, String gender, String phone) {
		super();
		this.name=email;
		this.email = email;
		this.password = password;
		this.birthDate = birthDate;
		this.gender = gender;
		this.phone = phone;
		this.memberLevel = "0";
		this.reliability = 0;
	}
	public MemberInfo(String email, String password,
			GregorianCalendar birthDate, String gender, String phone,
			String memberCode, String memberLevel) {
		super();
		this.name=email;
		this.email = email;
		this.password = password;
		this.birthDate = birthDate;
		this.gender = gender;
		this.phone = phone;
		this.memberCode = memberCode;
		this.memberLevel = memberLevel;
		this.reliability = 0;
	}
	public MemberInfo(String name, String email, String password,
			GregorianCalendar birthDate, String gender, String phone,
			String memberCode, String memberLevel, int reliability) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.birthDate = birthDate;
		this.gender = gender;
		this.phone = phone;
		this.memberCode = memberCode;
		this.memberLevel = memberLevel;
		this.reliability = reliability;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public GregorianCalendar getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(GregorianCalendar birthDate) {
		this.birthDate = birthDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	public String getMemberLevel() {
		return memberLevel;
	}
	public void setMemberLevel(String memberLevel) {
		this.memberLevel = memberLevel;
	}
	public int getReliability() {
		return reliability;
	}
	public void setReliability(int reliability) {
		this.reliability = reliability;
	}
}
