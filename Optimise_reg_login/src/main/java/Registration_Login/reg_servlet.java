package Registration_Login;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/register")

public class reg_servlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	public String uname, email_id, password;
	public long mobile_number;
	public int output = 0;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		uname = request.getParameter("uname");
		email_id = request.getParameter("email_id");
		password = request.getParameter("password");
		mobile_number = Long.parseLong(request.getParameter("mobile_number"));
		
		reg_member member = new reg_member(uname, email_id, password, mobile_number);  // create object for reg_member class(to set all variables as private)
		
		JDBC db_reg = new JDBC();  //create object for JDBC class for Java database connectivity
		
		 PrintWriter out = response.getWriter();
		 response.setContentType("text/html;charset=UTF-8");
		
		 RequestDispatcher rd = request.getRequestDispatcher("index_reg.jsp");
		 rd.include(request, response);
		 
		 try
		 {
			 output = db_reg.insert_data(member);  // call the insert_data() for inserting the data into DB
		 }
		 catch (ClassNotFoundException | SQLException e) 
		 {
			e.printStackTrace();
		 }
		 
		 if(output == 1)    //If output == 1, means there an insertion operation done in DB, Newuser registered.
		  {
			  out.print("<html><body><center>");
			  out.print("User registered successfully");
			  out.println("<br>Please Login to Continue..");
			  out.print("</center></body></html>");
		  }	
		else               //If output == 0, means there an no insertion operation done in DB, No Newuser registered.
		{
			  out.print("<html><body><center>");
			  out.print("User already exists");
			  out.print("<br><br>");
			  out.print("Try register with another email-id");
			  out.print("<br><br>");
			  out.print("or Login to continue..");
			  out.print("</center></body></html>"); 
		}	
	}

}
