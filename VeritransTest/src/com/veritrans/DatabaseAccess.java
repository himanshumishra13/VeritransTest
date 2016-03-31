package com.veritrans;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseAccess {
Connection connection=null;
	
	public void connect() throws SQLException, URISyntaxException
	{
		 URI dbUri = new URI(System.getenv("DATABASE_URL"));
		//String DRIVER="com.mysql.jdbc.Driver";
		
		String UserName = dbUri.getUserInfo().split(":")[0];
		String Password = dbUri.getUserInfo().split(":")[1];
		String URL = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
		/*try
		{
			Class.forName(DRIVER);
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}*/
		try
		{
			connection = DriverManager.getConnection(URL,UserName,Password);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void disconnect() throws SQLException
	{
		connection.close();
	}
	
}
