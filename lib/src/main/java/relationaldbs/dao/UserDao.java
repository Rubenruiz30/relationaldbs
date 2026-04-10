package relationaldbs.dao;

import java.util.List;

import relationaldbs.model.User;

public interface UserDao {
	/**
	 *Insert an user object to database 
	 * @param user
	 * @return true if inserts successfully, otherwise false
	 */
public boolean insert(User user);
/**
 * 
 * @param id
 * @return if use is delted successfullym, return true
 */
public boolean delete(long id);
/**
 * 
 * @param user
 */
public void update(User user);
public User find(long id);
/**
 * find the user by email
 * @param email
 * @return
 */

public User find(String email);
	public List<User> findAll();


}
