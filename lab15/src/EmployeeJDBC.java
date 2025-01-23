
import java.sql.*;

public class EmployeeJDBC {

    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/practical";
        String username = "root";
        String password = "bikash@123";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {

            String createTableSQL = "CREATE TABLE IF NOT EXISTS employee ("
                    + "id INT PRIMARY KEY AUTO_INCREMENT, "
                    + "name VARCHAR(100), "
                    + "age INT, "
                    + "salary DECIMAL(10, 2))";

            try (Statement stmt = conn.createStatement()) {
                stmt.executeUpdate(createTableSQL);
            }

            String insertSQL = "INSERT INTO employee (name, age, salary) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                pstmt.setString(1, "John Doe");
                pstmt.setInt(2, 30);
                pstmt.setDouble(3, 50000.00);
                pstmt.executeUpdate();
                pstmt.setString(1, "Hari Chandra");
                pstmt.setInt(2, 40);
                pstmt.setDouble(3, 40000.00);
                pstmt.executeUpdate();
            }

            String selectSQL = "SELECT * FROM employee";
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(selectSQL)) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    double salary = rs.getDouble("salary");
                    System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Salary: " + salary);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
