package relationdbs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBHelper {
	   private static final String JDBC_URL =
	            "jdbc:postgresql://localhost:5432/happy";
	    private static final String USERNAME = "postgres";
	    private static final String PASSWORD = "admin";
	    
	     public static Connection getConnection() {
	   try {
		return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
	   } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   }
	   return null;
	    
	    
}	  
}