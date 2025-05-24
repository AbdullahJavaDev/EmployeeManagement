package org.abdullpractice.connectionfactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {
	static Connection con;
	static Statement stmt;
	static ResultSet res;
	public static Connection requestConnection() {
		String url="jdbc:mysql://localhost:3306/PROJECT";
		String userName="root";
		String passWord="SHAIKSQL123";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver is successfully loaded");
			con=DriverManager.getConnection(url,userName,passWord);
			System.out.println("Connection is successfully established");
		}
		catch(ClassNotFoundException ae) {
			System.err.println("Loding is failed");
			ae.printStackTrace();
		}
		catch(SQLException ae) {
			System.err.println("Connection get failed");
			ae.printStackTrace();
		}
		return con;		
   }
	
}
