
package Registration_Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC 
{
    public static Connection con;
	
	public int db_result;
	public int PresentOrNot;
	public static int  update_pass_result;
	
	//JDBC Connection method
    public static void getConnection() throws ClassNotFoundException, SQLException
    {
    	Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/construction_Management";
		String username = "root";
		String pword = "12345";
		con = DriverManager.getConnection(url,username,pword);
    }
    
    //Insert data into database method
    public int insert_data(reg_member mem) throws ClassNotFoundException, SQLException 
    {
    	getConnection();
    	    	
    	String ins= "insert into user value(?,?,?,?)";
    	
    	PreparedStatement ps = con.prepareStatement(ins);
		ps.setString(1, mem.getUname());
		ps.setString(2, mem.getEmail_id());
		ps.setString(3, mem.getPassword());
		ps.setLong(4, mem.getMobile_number());
		
		try
		{
		   db_result = ps.executeUpdate();
		}
		catch(SQLException e)
		{
			db_result = 0;
		}
		
    	return db_result;
    }
    
    //Check the credentials(Email-Id and Password) method
    public boolean check_crediential(String emailid, String password) throws SQLException, ClassNotFoundException 
	{
 	    getConnection();
		
		String sql = "select * from user where email_id=? and password=?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, emailid);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next())
		{
			return true;
		}
		return false;
	}
    
    public int checkEmailforReset(String email_for_forgot) throws ClassNotFoundException, SQLException
    {
    	PresentOrNot = 0;
    	
    	getConnection();
    	
        String sql = "select email_id from user where email_id=?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, email_for_forgot);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next())
		{
			PresentOrNot = 1;
			return PresentOrNot;
		}
    	  	
    	return PresentOrNot;
    }
    
    public static int setPassword() throws ClassNotFoundException, SQLException
    {
    	getConnection();
    	
        String sql = "update user set password=? where email_id =?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, Email_pass_update.Password_update);
		ps.setString(2, Email_pass_update.Email_id_update);
    	
		update_pass_result = ps.executeUpdate();
		
//		System.out.println(Email_pass_update.Email_id_update);
//		System.out.println(Email_pass_update.Password_update);
//		System.out.println(update_pass_result);
		
    	return update_pass_result;
    }
}
