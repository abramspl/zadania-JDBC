package zadanie1;

import java.sql.*;

public class MoviesMain {
    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/zadania_jdbc",
                "root",
                "admin")) {


            String query = "CREATE TABLE IF NOT EXISTS movies (" +
                    "id INTEGER AUTO_INCREMENT Primary key, " +
                    "title VARCHAR(255), " +
                    "genre VARCHAR (255), " +
                    "yearOfRelease INTEGER);";

            String query2 = "INSERT INTO movies (title, genre, yearOfRelease) VALUES " +
                    "('AAA', 'aaa', 1234)," +
                    "('BBB', 'bbb', 4321)," +
                    "('CCC', 'ccc', 5555);";

            String query3 = "DELETE FROM movies WHERE id = 3;";

            String query4 = "SELECT * FROM movies;";

            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.executeUpdate(query2);

            PreparedStatement stat = connection.prepareStatement("UPDATE movies SET title = 'ddd' WHERE id = ? ");
            stat.setInt(1, 2);
            stat.executeUpdate();

            statement.executeUpdate(query3);

            ResultSet resultSet = statement.executeQuery(query4);
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + "\t\t"
                        + resultSet.getString("title") + "\t\t"
                        + resultSet.getString(3) + "\t\t"
                        + resultSet.getInt(4));
            }


        } catch (SQLException exp) {

        }


    }
}
