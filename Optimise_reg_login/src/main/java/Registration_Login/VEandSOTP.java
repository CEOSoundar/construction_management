package Registration_Login;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/VerifyEmailAndSendOTPMail")  //Verify Entered Email-Id and if matches then send OTP to entered Email-Id
public class VEandSOTP extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	public int verify;
	public static String OTP;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String Entered_Email = request.getParameter("forgot_emailid");  //get the email-id for password reset
		
		JDBC chk_obj = new JDBC();   // create object for JDBC 
		/*we create an object for JDBC class, in which we can access the checkEmailforReset() and 
		this takes the value of entered email-id and goes to the checkEmailforReset(Entered_Email)
		in that method there is an execute query which will takes the email-id and stored in resultset
		if there is a email-id means it gives 1 otherwise it will return 0, from this we can understand
		that if 1 means there is a registered email-id and if 0 means there is no such email-id present 
		in the database ("PresentOrNot" variable holds the result value)
		*/
		
		//sendOTPtoMail mail_otp_obj = new sendOTPtoMail();  //create object for sendOTPtoMail class for send OTP to email-id
		
		try
		{
			verify = chk_obj.checkEmailforReset(Entered_Email); // 0 for "No"  // 1 for "Yes"
			
			PrintWriter out = response.getWriter();
			response.setContentType("text/html;charset=UTF-8");
			RequestDispatcher rd = request.getRequestDispatcher("forgot_pass.jsp");
			rd.include(request, response);
			
			if(verify == 1)
			{
				OTP = sendOTPtoMail.get_OTP(Entered_Email);
				
				out.print("<html><body><center>");
				out.print("OTP Sent !" + Entered_Email);
				out.println("<br>Please Enter into OTP Box");
				out.print("</center></body></html>"); 
				
				//we need to send the system generated OTP to another class method
				
				compare_otps.system_otp(OTP);  //sending OTP to 
				Email_pass_update.gettingEmail_id(Entered_Email); //sending Email-id to Email_pass_update class
			    				
			}
			else
			{				
				 out.print("<html><body><center>");
				 out.print("Invalid Email-Id");
				 out.print("</center></body></html>");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
}
