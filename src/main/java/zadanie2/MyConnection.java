package zadanie2;

import java.sql.*;

public class MyConnection {
    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/zadania_jdbc",
                "root",
                "admin")) {

            MovieDAOImpl movieDAOimpl = new MovieDAOImpl(connection);

        } catch (SQLException exp) {
        }
    }
}
