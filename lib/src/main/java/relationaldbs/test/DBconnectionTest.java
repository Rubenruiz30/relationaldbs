package relationaldbs.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnectionTest {

    private static String jdbURL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USURNAME = "postgres";
    private static final String password = "admin";

    public static void main(String[] args) {

        try (Connection connection =
                     DriverManager.getConnection(jdbURL, USURNAME, password);
             Statement st = connection.createStatement()) {

            System.out.println(connection);

            try {
                st.execute("CREATE DATABASE happy");
                System.out.println("Base de datos creada");
            } catch (SQLException e) {
                // 42P04 = database already exists
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
}

