import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Thay đổi thông tin kết nối dựa trên cơ sở dữ liệu của bạn
            String url = "jdbc:mysql://localhost:3306/ManagementBooks"; // URL kết nối
            String username = "root"; // Tên người dùng
            String password = "123123"; // Mật khẩu

            // Tạo kết nối đến cơ sở dữ liệu
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Database connection error: " + e.getMessage());
        }
        return connection;
    }
}
