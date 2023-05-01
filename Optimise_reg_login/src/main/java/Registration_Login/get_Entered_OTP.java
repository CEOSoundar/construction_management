package Registration_Login;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/entered_user_otp")
public class get_Entered_OTP extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	public boolean compare_result;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
        String user_otp = request.getParameter("entered_otp");
        
        compare_otps.user_otp(user_otp);
        compare_result = compare_otps.otp_compare();
        
        if(compare_result)
        {
        	response.sendRedirect("new_pass_reset.jsp"); // new password page entry point
        }
        else
        {
        	PrintWriter out = response.getWriter();
			response.setContentType("text/html;charset=UTF-8");
			RequestDispatcher rd = request.getRequestDispatcher("forgot_pass.jsp");
			rd.include(request, response);
			
			out.println("OTP not match");
        }      
	}
}
