package Registration_Login;

public class reg_member 
{
	private String uname, email_id, password;
	private long mobile_number;
	
	public reg_member()
	{
		//super();
	}
	
	public reg_member(String uname, String email_id, String password, long mobile_number) // 4 parameter constructor for variable initialization
	{
		//super();
		this.uname = uname;
		this.email_id = email_id;
		this.password = password;
		this.mobile_number = mobile_number;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(long mobile_number) {
		this.mobile_number = mobile_number;
	}
}
