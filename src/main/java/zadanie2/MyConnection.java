package zadanie2;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;

public class MyConnection {
    public static void main(String[] args) {


        MysqlDataSource dataSource = new MysqlDataSource();

        dataSource.setUrl("jdbc:mysql://localhost:3306/zadania_jdbc");
        dataSource.setUser("root");
        dataSource.setPassword("admin");

        try (Connection connection = dataSource.getConnection()) {

            MovieDAOImpl movieDAOimpl = new MovieDAOImpl(connection);

            movieDAOimpl.createTable();
            movieDAOimpl.createMovie(new Movie("aaa","aaaa", 1234));



        } catch (SQLException exp) {

        }

    }
}
