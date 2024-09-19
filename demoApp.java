import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class DemoApp {
    public static void main(String[] args) {
        try {
            // Connect to MySQL database
            Connection conn = DriverManager.getConnection("jdbc:mysql://mysql-container:3306/demo", "root", "password");

            // Create a table
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS users (id INT AUTO_INCREMENT, name VARCHAR(255), PRIMARY KEY(id))");

            // Insert data
            stmt.execute("INSERT INTO users (name) VALUES ('John Doe')");

            // Retrieve and display data
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            System.out.println("Users in the database:");
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
