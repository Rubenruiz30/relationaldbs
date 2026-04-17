package relationaldbs.test;

import relationaldbs.dao.UserDao;
import relationaldbs.dao.UserDaoImplementation;
import relationaldbs.model.User;
public class UserDaoTest {
public static void main(String[] args) {
	//Insert test
	UserDao UserDao = new UserDaoImplementation();
	
	UserDao.insert(new User("Ruben", "Ruiz", 10, "Admin", "Rozas", true, "Ruben", false, 0));
	UserDao.insert(new User("Diego", "Ruiz", 20, "Admin", "Rozas", true, "Diego", false, 1));
	UserDao.update(new User("Ruben", "Ruiz", 999, "Admin123", "Madrid", true, "Ruben", true, 0)); 
	UserDao.delete(1);
	

}
}
