package zadanie2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public class MovieDAOImpl implements MovieDAO {

    public Connection connection;

    public MovieDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createTable() {
        String query = "CREATE TABLE IF NOT EXISTS movies (" +
                "id INTEGER AUTO_INCREMENT Primary key, " +
                "title VARCHAR(255), " +
                "genre VARCHAR (255), " +
                "yearOfRelease INTEGER);";
        statementExecuteUpdate(query);
    }

    @Override
    public void deleteTable() {
        String query = "drop table movies;";
        statementExecuteUpdate(query);
    }

    @Override
    public void createMovie(Movie movie) {
        String query = "INSERT INTO movies (title, genre, yearOfRelease) VALUES (?,?,?);";
    }

    @Override
    public void deleteMovie(int id) {

    }

    @Override
    public void updateMoviesTitle(int id, String newTitle) {

    }

    @Override
    public Optional<Movie> findMovieById(int id) {
        return Optional.empty();
    }

    @Override
    public List<Movie> findAll() {
        return null;
    }

    private void statementExecuteUpdate(String query) {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException exp) {

        }
    }

    private void preparedStatementExecuteUpdate(String query) {
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.executeUpdate();
        } catch (SQLException exp) {

        }
    }
}
