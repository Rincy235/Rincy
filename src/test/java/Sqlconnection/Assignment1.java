package Sqlconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class Assignment1 {

	@Test
	public void ExecuteQuery() throws SQLException 
	{
		Connection con=null;
		String s = "Aishwarya";
		try
		{
		        //step 1: Register the database
				Driver driverref = new Driver();
				DriverManager.registerDriver(driverref);
				
				//step 2: Establish the connection with database
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Customer", "root", "root");
				
				//step 3: Issue create statement
				Statement stat = con.createStatement();
				
				//step 4: Execute query
				ResultSet result = stat.executeQuery("select CustomerName from customer;");
				
				while(result.next())
				{
					if(result.getString(1).equals(s))
					{
						System.out.println("available");
					}
					else
					{
						System.out.println(" not available");
					}
				}
		}
		catch(Exception e)
		{
			
		}
				//step 5: close database connection
		finally
		{
				con.close();
		}
		
	}
}
