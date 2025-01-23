
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddMovie {

    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "bikash@123";

        String insertQuery = "INSERT INTO MOVIE (id, title, genre) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, username, password); PreparedStatement stmt = conn.prepareStatement(insertQuery)) {

            // Adding three records
            stmt.setInt(1, 1);
            stmt.setString(2, "Hello");
            stmt.setString(3, "IDK");
            stmt.executeUpdate();
            stmt.setInt(1, 2);
            stmt.setString(2, "Sambodhan");
            stmt.setString(3, "Comedy");
            stmt.executeUpdate();

            stmt.setInt(1, 3);
            stmt.setString(2, "Kabaddi");
            stmt.setString(3, "Action");
            stmt.executeUpdate();

            System.out.println("Records inserted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
