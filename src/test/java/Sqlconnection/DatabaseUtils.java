package Sqlconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtils {
	/*
	@Test
	public void ExecuteQuery() throws SQLException
	{
		//step 1: Register the database
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		
		//step 2: Establish the connection with database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Customer", "root", "root");
		
		//step 3: Issue create statement
		Statement stat = con.createStatement();
		
		//step 4: Execute query
		ResultSet result = stat.executeQuery("select * from customer;");
		while(result.next())
		{
			System.out.print(result.getString(1)+'\t'+result.getString(2)+'\t');
		
		}

		//step 5: close database connection
		con.close();
	}
	*/

	@Test
	public void ExecuteUpdate() throws SQLException
	{
		Connection con = null;
		try {
		//step 1: Register the database
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		
		//step 2: Establish the connection with database
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Customer", "root", "root");
		
		//step 3: Issue create statement
		Statement stat = con.createStatement();
		
		//step 4: Execute query
		int result = stat.executeUpdate("insert into customer values('Vasanth','Chaitra','Hebbal','Bangalore',52641,'India');");
		if(result==1)
		{
			System.out.print("Project is successfully created"+'\t');
		
		}
		else
		{
			System.out.print("Query failed"+'\t');
		}
		}
		 catch(Exception e) {
		 
		 }
			 
			 finally {
		//step 5: close database connection
		con.close();
		System.out.print("Connection closed"+'\t');
		 }
	}
}


