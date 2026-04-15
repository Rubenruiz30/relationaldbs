package relationaldbs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.SQLException;
import java.util.List;

import org.postgresql.jdbc.PgArray;

import relationaldbs.model.User;

/**
 * 
 *@author david
 *@author Rubén
 *10 abr 2026
 */
public class UserDaoImplementation implements UserDao {
	
	   private static final String JDBC_URL =
	            "jdbc:postgresql://localhost:5432/happy";
	    private static final String USERNAME = "postgres";
	    private static final String PASSWORD = "admin";
	    static String createTableSQL =
	    		"CREATE TABLE IF NOT EXISTS Users (" +
	    				"password VARCHAR(255), " +
	    				"name VARCHAR(255), " +
	    				"nicknameString VARCHAR(255), " +
	    				"balance DOUBLE, " +
	    				"singup BOOLEAN, " +
	    				"surname VARCHAR(255), " +
	    				"residence VARCHAR(255)" +
	    				");";
	    
	@Override
	public boolean insert(User user) {
		// TODO Auto-generated method stub
		
		// The ingredients that we need to do the task
		/**
		 * Insert sql
		 */
		String insertSQL = "INSERT INTO users (password, name, nicknameString, balance, singup, surname, residence) " +
        "VALUES (?, ?, ?, ?,?,?,?)";
		/**
		 * create an object of connection to establish
		 * a network connection with
		 * our program
		 */
		try (// create an object of connection in 
		 Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
		/**
		 * create an object of preparedStatement which allows
		 * us to send and execute sqls
		 */
				
				PreparedStatement ps = conn.prepareStatement(insertSQL)) {
		ps.setString(1, user.getPassword());
		ps.setString(2, user.getName());
		ps.setString(3, user.getnicknameString());
		ps.setDouble(4,  user.getBalance());
		ps.setBoolean(5, user.isSingup());
		ps.setString(6, user.getSurname());
		ps.setString(7, user.getResidence());
		
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User find(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
