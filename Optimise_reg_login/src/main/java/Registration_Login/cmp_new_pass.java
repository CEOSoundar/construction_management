package Registration_Login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/new_password_change")
public class cmp_new_pass extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	public int status;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String password1 = request.getParameter("new_password");
		String password2 = request.getParameter("retype_password");
		
		//System.out.println("new_password : " + password1);
		//System.out.println("retype_password : " + password2);
		
		// need to call the password update() in JDBC
		
		Email_pass_update.gettingpassword(password2);
		
		try 
		{
			status = JDBC.setPassword();
			
			if(status == 1)
			{
				System.out.println("Password changed");
				response.sendRedirect("pass_successful.jsp");	
			}
			else
			{
				System.out.println("Password not changed");
			}
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		
		
		
		
	}

}
