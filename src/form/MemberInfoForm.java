package form;

public class MemberInfoForm {
	private String email;
	private String name;
	private String password;
	private String passwordCheck;
	private String birthDate;
	private String gender;
	private String phone;
	
	
	public MemberInfoForm() {
		this("","","","","","","");
	
	}

	public MemberInfoForm(String email, String name, String password, String passwordCheck, String birthDate, String gender, String phone) {
		this.email = email;
		this.name = name;
		this.password = password;
		this.passwordCheck=passwordCheck;
		this.birthDate = birthDate;
		this.gender = gender;
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordCheck() {
		return passwordCheck;
	}


	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}
	public String getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(String birthDate) {
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


}
