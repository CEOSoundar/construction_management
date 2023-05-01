package Registration_Login;

public class compare_otps 
{
    public static String mail_otp;
    public static String user_otp;
    public static boolean otp_compare;
    
	public static void system_otp(String sys_otp)
	{
		mail_otp = sys_otp;
	}
	
	public static void user_otp(String usr_otp)
	{
		user_otp = usr_otp;
	}
	
	public static boolean otp_compare()
	{
		otp_compare = false;
		
		if(mail_otp.equals(user_otp)) 
		{
			otp_compare = true;
			System.out.println("OTP Match");
			return otp_compare;
		}
		System.out.println("OTP not Match");
		return otp_compare;
	}
}
