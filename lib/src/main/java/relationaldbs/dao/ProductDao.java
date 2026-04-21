package relationaldbs.dao;

import java.util.List;

import relationaldbs.model.Product;


public interface ProductDao {
	public void createTable() ;
    /**
     * Insert a product object into database
     * @param product
     * @return true if inserted successfully, otherwise false
     */
    public boolean insert(Product product);

    /**
     * Delete a product by id
     * @param id
     * @return true if product is deleted successfully
     */
    public boolean delete(long id);

    /**
     * Update a product
     * @param product
     */
    public void update(Product product);

    /**
     * Find a product by id
     * @param id
     * @return product found or null
     */
    public Product find(long id);

    /**
     * Find all products
     * @return list of products
     */
    public List<Product> findAll();

}

	