package relationaldbs.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBconnectionTest {

    private static final String JDBC_URL =
            "jdbc:postgresql://localhost:5432/happy";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "admin";

    public static void main(String[] args) {

        createDatabase();
        createTable();
        insertUser("Manolo", "1234", true, 234.3f);
        deleteUserByUsername("Alejandro");
        selectUserByUsername("Manolo");
    }

    // ===============================
    // CREAR BASE DE DATOS
    // ===============================
    private static void createDatabase() {

        try (Connection connection =
                     DriverManager.getConnection(
                             "jdbc:postgresql://localhost:5432/postgres",
                             USERNAME, PASSWORD);
             Statement st = connection.createStatement()) {

            try {
                st.execute("CREATE DATABASE happy");
                System.out.println("Base de datos creada");
            } catch (SQLException e) {
                if ("42P04".equals(e.getSQLState())) {
                    System.out.println("La base de datos ya existe");
                } else {
                    throw e;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ===============================
    // CREAR TABLA
    // ===============================
    private static void createTable() {

        String createTableSQL =
                "CREATE TABLE IF NOT EXISTS users (" +
                "id SERIAL PRIMARY KEY, " +
                "username VARCHAR(255), " +
                "psw VARCHAR(255), " +
                "isVIP BOOLEAN, " +
                "balance FLOAT" +
                ");";

        try (Connection conn =
                     DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement ps =
                     conn.prepareStatement(createTableSQL)) {

            ps.executeUpdate();
            System.out.println("Tabla users creada");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ===============================
    // INSERT
    // ===============================
    private static void insertUser(
            String username, String psw, boolean isVIP, float balance) {

        String insertSQL =
                "INSERT INTO users (username, psw, isVIP, balance) " +
                "VALUES (?, ?, ?, ?)";

        try (Connection conn =
                     DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(insertSQL)) {

            ps.setString(1, username);
            ps.setString(2, psw);
            ps.setBoolean(3, isVIP);
            ps.setFloat(4, balance);
            ps.executeUpdate();

            System.out.println("Usuario " + username + " insertado");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ===============================
    // DELETE
    // ===============================
    private static void deleteUserByUsername(String username) {

        String deleteSQL =
                "DELETE FROM users WHERE username = ?";

        try (Connection conn =
                     DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(deleteSQL)) {

            ps.setString(1, username);
            ps.executeUpdate();
            System.out.println("Usuario " + username + " eliminado");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ===============================
    // SELECT
    // ===============================
    private static void selectUserByUsername(String username) {

        String selectSQL =
                "SELECT * FROM users WHERE username = ?";

        try (Connection conn =
                     DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(selectSQL)) {

            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("id") +
                        " | Usuario: " + rs.getString("username") +
                        " | VIP: " + rs.getBoolean("isVIP") +
                        " | Balance: " + rs.getFloat("balance")
                );
            }

            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
