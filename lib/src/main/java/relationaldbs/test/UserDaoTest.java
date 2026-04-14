package relationaldbs.test;

import relationaldbs.dao.UserDao;
import relationaldbs.dao.UserDaoImplementation;
import relationaldbs.model.User;
public class UserDaoTest {
public static void main(String[] args) {
	//Insert test
	UserDao UserDao = new UserDaoImplementation();
	
	UserDao.insert(new User("Ruben", "Ruiz", 10, "Admin", "Rozas", true, "Ruben", false, 0));



}
}
