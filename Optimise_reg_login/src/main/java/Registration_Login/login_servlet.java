package Registration_Login;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/login")
public class login_servlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	String email_id, password;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		email_id = request.getParameter("email_id");
		password = request.getParameter("password");
		
		JDBC check_obj = new JDBC();
		
		 PrintWriter out = response.getWriter();
		 response.setContentType("text/html;charset=UTF-8");
		
		 RequestDispatcher rd = request.getRequestDispatcher("index_login.jsp");
		 rd.include(request, response);  
		
		try 
		{
		   if(check_obj.check_crediential(email_id, password))
			{
				HttpSession session = request.getSession();
				session.setAttribute("email_id", email_id);
				response.sendRedirect("Welcome_Page.jsp");
			}
			else
			{
				//response.sendRedirect("index_login.jsp");
//				out.println("<center>");
//				out.print(email_id + " This is not a registered email-id");
//				out.print("<br><br>");
//				out.print("Please check the email-id again or try registeration");
//				out.println("</center>");
				
				out.println("<center>");
				out.print("Email-ID or Password is incorrect");
				out.print("<br><br>");
				out.print("Please check the email-id and password");
				out.println("</center>");
			}
		} 
		catch (ClassNotFoundException e) 
		{  
			e.printStackTrace(); 
		} 
		catch (SQLException e)   
		{  
			e.printStackTrace(); 
		}
	}
}
