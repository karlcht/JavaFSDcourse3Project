package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnector {

static Connection con = null ;
	
	public static  Connection getConnection() throws SQLException 
	{ 
		
		//Added con.isClosed to avoid a closed connection con == null is not enough at times
		if (con == null || con.isClosed())
		{

			try {
				
				 Class.forName("oracle.jdbc.driver.OracleDriver"); 
				  con = (Connection) DriverManager.getConnection(
				  "jdbc:oracle:thin:@localhost:1521:xe", "system", "karl");
				  System.out.println("Connection Success"); 
			}
			
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
	
		}
		
		
		return con;
	}
}
