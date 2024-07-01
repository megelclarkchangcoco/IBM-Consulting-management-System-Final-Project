package sratch;

import java.sql.Connection;
import java.sql.DriverManager;

public class tester {
	public static void main(String[] args) {
		try {
			String url = "jdbc:sqlserver://LAPTOP-C5593DBG\\SQLEXPRESS;databaseName=accTest;integratedSecurity=true;encrypt=false;";
			Connection con = DriverManager.getConnection(url);
			
			
			System.out.println("Connect Success1");
			
		} catch (Exception e) {
			System.out.println("Connect failed");
			e.printStackTrace();
		}
	}
}
