package relationaldbs.dao;

import java.util.List;

import relationaldbs.model.User;

/**
 * 
 *@author david
 *@author Rubén
 *10 abr 2026
 */
public class UserDaoImplementation implements UserDao {

	@Override
	public boolean insert(User user) {
		// TODO Auto-generated method stub
		String insertSQL = "INSERT INTO users (name, password, isVIP, balance) " +
        "VALUES (?, ?, ?, ?)";
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
