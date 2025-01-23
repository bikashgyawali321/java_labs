
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateMovieGenre {

    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "bikash@123";

        String updateQuery = "UPDATE MOVIE SET genre = ? WHERE title = ?";

        try (Connection conn = DriverManager.getConnection(url, username, password); PreparedStatement stmt = conn.prepareStatement(updateQuery)) {

            stmt.setString(1, "Comedy");
            stmt.setString(2, "Jatra");

            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Genre updated successfully for the movie 'Jatra'!");
            } else {
                System.out.println("No movie found with the title 'Jatra'.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
