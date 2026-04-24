package relationaldbs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import relationaldbs.model.Product;
import relationdbs.util.DBHelper;

public class ProductDaoImpl implements ProductDao {
	



    static String createTableSQL =
            "CREATE TABLE IF NOT EXISTS products (" +
            "id serial primary key, " +
            "name VARCHAR(255), " +
            "size VARCHAR(255), " +
            "price VARCHAR(255)" +
            ");";

    public void createTable() {
        try (Connection conn = DBHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(createTableSQL)) {

            ps.executeUpdate();
            System.out.println("Tabla products creada correctamente");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean insert(Product products) {
        String insertSQL = "INSERT INTO products (id, name, size, price) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(insertSQL)) {

            ps.setLong(1, products.getId());
            ps.setString(2, products.getName());
            ps.setString(3, products.getSize());
            ps.setString(4, products.getPrice());

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(long id) {
        String deleteSQL = "DELETE FROM products WHERE id = ?";

        try (Connection conn = DBHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(deleteSQL)) {

            ps.setLong(1, id);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Producto " + id + " eliminado");
                return true;
            } else {
                System.out.println("No existe un producto con id " + id);
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void update(Product products) {
        String sql = "UPDATE products SET name = ?, price = ?, size = ? WHERE id = ?";

        try (Connection conn = DBHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, products.getName());
            ps.setString(2, products.getPrice());
            ps.setString(3, products.getSize());
            ps.setLong(4, products.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product find(long id) {

        String sql = "SELECT * FROM products WHERE id = ?";

        try (Connection conn =
        		DBHelper.getConnection();

             PreparedStatement ps =
                conn.prepareStatement(sql)) {

            ps.setLong(1,id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                Product product = new Product(
                    rs.getString("name"),
                    rs.getString("size"),
                    rs.getString("price"),
                    rs.getLong("id")
                );

                return product;
            }

        } catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Product> findAll() {

        String sql = "SELECT * FROM products";

        List<Product> products = new ArrayList<>();

        try (Connection conn =
        		DBHelper.getConnection();

             PreparedStatement ps =
                conn.prepareStatement(sql);

             ResultSet rs = ps.executeQuery()) {

            while(rs.next()){

                Product product = new Product(
                    rs.getString("name"),
                    rs.getString("size"),
                    rs.getString("price"),
                    rs.getLong("id")
                );

                products.add(product);
            }

        } catch(SQLException e){
            e.printStackTrace();
        }

        return products;
    }
}