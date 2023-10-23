package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entities.Users;

public class UserDAO {
    private Connection connection; // Thay bằng kết nối cơ sở dữ liệu thực tế

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean addUser(Users user) {
        try {
            // Sử dụng PreparedStatement để thêm người dùng
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (userId, userName, email) VALUES (?, ?, ?)");
            preparedStatement.setString(1, user.getUserId());
            preparedStatement.setString(2, user.getUserName());
            preparedStatement.setString(3, user.getEmail());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean removeUser(String userId) {
        try {
            // Xoá người dùng dựa trên userId
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE userId = ?");
            preparedStatement.setString(1, userId);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateUser(Users user) {
        try {
            // Cập nhật thông tin người dùng
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET userName = ?, email = ? WHERE userId = ?");
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getUserId());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Users getUser(String userId) {
        try {
            // Truy vấn thông tin người dùng dựa trên userId
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE userId = ?");
            preparedStatement.setString(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String userName = resultSet.getString("userName");
                String email = resultSet.getString("email");
                return new Users(userId, userName, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
