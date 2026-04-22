package relationaldbs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	    	    "CREATE TABLE IF NOT EXISTS users (" +
	    	    "id BIGINT PRIMARY KEY, " +
	    	    "password VARCHAR(255), " +
	    	    "name VARCHAR(255), " +
	    	    "nicknameString VARCHAR(255), " +
	    	    "balance DOUBLE PRECISION, " +
	    	    "singup BOOLEAN, " +
	    	    "surname VARCHAR(255), " +
	    	    "residence VARCHAR(255), " +
	    	    "login BOOLEAN" +
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
	    String deleteSQL = "DELETE FROM users WHERE id = ?";

	    try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
	         PreparedStatement ps = conn.prepareStatement(deleteSQL)) {

	        ps.setLong(1, id);
	        int search = ps.executeUpdate();

	        if (search > 0) {
	            System.out.println("Usuario " + id + " eliminado");
	            return true;
	        } else {
	            System.out.println("No existe un usuario con id " + id);
	            return false;
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	@Override
	public void update(User user) {
	    String sql = "UPDATE users SET name=?, Surname=?, Balance=?, Password=?, R`+"
	    		+ "esidence=?, login=?, nicknameString=?, Signup=? WHERE id=?";

	    try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
	         PreparedStatement ps = conn.prepareStatement(sql)) {

	        ps.setString(1, user.getName());
	        ps.setString(2, user.getSurname());
	        ps.setDouble(3, user.getBalance());
	        ps.setString(4, user.getPassword());
	        ps.setString(5, user.getResidence());
	        ps.setBoolean(6, user.getLogin());
	        ps.setString(7, user.getnicknameString());
	        ps.setBoolean(8, user.isSingup());
	        ps.setLong(9, user.getId());

	        ps.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	@Override
	public User find(long id) {

	    String sql = "SELECT * FROM users WHERE id = ?";

	    try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
	         PreparedStatement ps = conn.prepareStatement(sql)) {

	        ps.setLong(1, id);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) { 


	        	User user = new User(
	        		    rs.getString("name"),
	        		    rs.getString("surname"),
	        		    rs.getDouble("balance"),
	        		    rs.getString("password"),
	        		    rs.getString("residence"),
	        		    rs.getBoolean("login"),
	        		    rs.getString("nicknameString"),
	        		    rs.getBoolean("singup"),
	        		    rs.getLong("id")
	        		);

	            return user;
	        }

	    } catch(SQLException e){
	        e.printStackTrace();
	    }

	    return null;
	}
	@Override
	public User find(String email) {

	    String sql = "SELECT * FROM users WHERE nicknameString = ?";

	    try(Connection conn =
	            DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);

	        PreparedStatement ps =
	            conn.prepareStatement(sql)) {

	        ps.setString(1,email);

	        ResultSet rs = ps.executeQuery();

	        if(rs.next()){

	            User user = new User(
	                rs.getString("name"),
	                rs.getString("surname"),
	                rs.getDouble("balance"),
	                rs.getString("password"),
	                rs.getString("residence"),
	                rs.getBoolean("login"),
	                rs.getString("nicknameString"),
	                rs.getBoolean("singup"),
	                rs.getLong("id")
	            );

	            return user;
	        }

	    } catch(SQLException e){
	        e.printStackTrace();
	    }

	    return null;
	}

	@Override
	public List<User> findAll() {

	    String sql = "SELECT * FROM users";

	    List<User> users = new ArrayList<>();

	    try(Connection conn =
	            DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);

	        PreparedStatement ps =
	            conn.prepareStatement(sql);

	        ResultSet rs = ps.executeQuery()) {

	        while(rs.next()){

	            User user = new User(
	                rs.getString("name"),
	                rs.getString("surname"),
	                rs.getDouble("balance"),
	                rs.getString("password"),
	                rs.getString("residence"),
	                rs.getBoolean("login"),
	                rs.getString("nicknameString"),
	                rs.getBoolean("singup"),
	                rs.getLong("id")
	            );

	            users.add(user);
	        }

	    } catch(SQLException e){
	        e.printStackTrace();
	    }

	    return users;
	}
}
