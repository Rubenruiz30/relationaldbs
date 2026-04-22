package relationaldbs.test;

import relationaldbs.dao.ProductDao;
import relationaldbs.dao.ProductDaoImpl;
import relationaldbs.model.Product;
public class ProductDaoTest {
	public static void main(String[] args) {
		
	
	ProductDao productDaoTest= new ProductDaoImpl();
	productDaoTest.createTable();
	productDaoTest.insert(new Product("Ruben", "Ruiz", "Admin", 0));
	productDaoTest.update(new Product("Ruben","20","jesus", 0));
	productDaoTest.find(0);
	productDaoTest.findAll();
	productDaoTest.delete(1);
}

	
}
