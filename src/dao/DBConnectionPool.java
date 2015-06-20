package dao;
import java.sql.*;
public class DBConnectionPool {
	private static DBConnectionPool instance;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private String user = "travelstory";
	private String password = "1234";

	public static synchronized DBConnectionPool getInstance(){
		if(instance==null){
			instance = new DBConnectionPool();
			return instance;
		}
		return instance;
	}

	private DBConnectionPool(){
		driverLoading(this.driver, this.url, this.user, this.password);
	}

	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, user, password);
	}

	public void driverLoading(String driver, String url, String user, String password){
		System.out.println("driverLoading : " + driver + ":" + user + ":" + password);
		if(driver!=null) this.driver = driver;
		if(url!=null) this.url = url;
		if(user!=null) this.user = user;
		if(password!=null) this.password = password;
		try{
			Class.forName(driver);
		}
		catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
