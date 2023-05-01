package Registration_Login;

import java.util.Properties;
import java.util.Random;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class sendOTPtoMail 
{
	public static boolean b;
	
	public static String get_OTP(String toEmail_id)
	{
        String to = toEmail_id;
        String from = "soundar0045.s@gmail.com";
        String subject = "OTP for Password Change!";
        String otp = null;
        String result = null;
        
        //sendOTPtoMail m = new sendOTPtoMail();
        
        otp = getOTP();
        
        b = sendEmail(to, from, subject, otp);
        
        if(b) 
        {
        	result = otp;
            System.out.println("Email is sent successfully");
        } 
        else 
        {
        	result = "false";
            System.out.println("There is problem in sending email");
        }
		return result; 
	}
	
	public static String getOTP()      //generating Random OTP 
	{
		//String UppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		//String LowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		//String Spl_chars = "-";
		int length = 5;
		
		//String combination = UppercaseLetters + LowercaseLetters + numbers + Spl_chars;
		String combination = numbers ;
		
		char[] password = new char[length];
		
		Random r = new Random();
		
		for(int i = 0; i < length; i++)
		{
			password [i] = combination.charAt(r.nextInt(combination.length()));
		}
		
		String OTP = new String(password);
		
		System.out.println("Generated Password is " + OTP);
		
		return OTP;
	}
	
	
	public static boolean sendEmail(String to, String from, String subject, String text) 
    {
    boolean flag = false;

    //smtp properties

    Properties properties = new Properties();
    properties.put("mail.smtp.auth", true);
    properties.put("mail.smtp.starttls.enable", true);
    properties.put("mail.smtp.port", "587");
    properties.put("mail.smtp.host", "smtp.gmail.com");

    final String username = "soundar0045.s@gmail.com";
    final String password = "ghpuigdbtgedlqjv";
    
    //session
    Session session = Session.getInstance(properties, new Authenticator() {
      @Override
      protected PasswordAuthentication getPasswordAuthentication() {
      return new PasswordAuthentication(username, password);
      }});
    
    try 
    {
       Message message = new MimeMessage(session);
       message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
       message.setFrom(new InternetAddress(from));
       message.setSubject(subject);
       message.setText(text);
       Transport.send(message);
       flag = true;
     } 
    catch (Exception e) 
    {
      e.printStackTrace();
    }
        
    return flag;

    }
}
