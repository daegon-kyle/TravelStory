package model;

import java.sql.*;

public class DBConnectionPool 
{
	private static DBConnectionPool instance;
	private String id;
	private String password;
	private String driver;
	
	public DBConnectionPool()
	{
		id="user18";
		password="123";
		driver="oracle.jdbc.driver.OracleDriver";
		
		driverLoading();
	}
	
	public static synchronized DBConnectionPool getInstance()
	{
		if(instance==null)
		{
			instance=new DBConnectionPool();
			return instance;
		}
		return instance;
	}
	
	public void driverLoading()
	{
		try
		{
			Class.forName(driver);
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}
	
	public Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", id, password);
	}
}
