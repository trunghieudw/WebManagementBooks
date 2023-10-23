package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entities.Authors;

public class AuthorDAO {
    private Connection connection; // Thay bằng kết nối cơ sở dữ liệu thực tế

    public AuthorDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean addAuthor(Authors author) {
        try {
            // Sử dụng PreparedStatement để thêm tác giả vào cơ sở dữ liệu
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO authors (authorId, name) VALUES (?, ?)");
            preparedStatement.setString(1, author.getAuthorId());
            preparedStatement.setString(2, author.getName());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean removeAuthor(String authorId) {
        try {
            // Sử dụng PreparedStatement để xoá tác giả dựa trên authorId
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM authors WHERE authorId = ?");
            preparedStatement.setString(1, authorId);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateAuthor(Authors author) {
        try {
            // Sử dụng PreparedStatement để cập nhật thông tin tác giả
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE authors SET name = ? WHERE authorId = ?");
            preparedStatement.setString(1, author.getName());
            preparedStatement.setString(2, author.getAuthorId());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Authors getAuthor(String authorId) {
        try {
            // Truy vấn thông tin tác giả dựa trên authorId
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM authors WHERE authorId = ?");
            preparedStatement.setString(1, authorId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                return new Authors(authorId, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Authors> getAllAuthors() {
        List<Authors> result = new ArrayList<>();
        try {
            // Truy vấn tất cả tác giả
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM authors");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String authorId = resultSet.getString("authorId");
                String name = resultSet.getString("name");
                result.add(new Authors(authorId, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
