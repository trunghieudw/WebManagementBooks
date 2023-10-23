package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entities.Books;

public class BookDAO {
    private Connection connection; // Thay bằng kết nối cơ sở dữ liệu thực tế

    public BookDAO(Connection connection) {
        this.connection = connection;
    }
    public boolean addBook(Books book) {
        try {
            // Sử dụng PreparedStatement để thêm sách vào cơ sở dữ liệu
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO books (bookId, title, author) VALUES (?, ?, ?)");
            preparedStatement.setString(1, book.getBookId());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setString(3, book.getAuthor());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean removeBook(String bookId) {
        try {
            // Sử dụng PreparedStatement để xoá sách dựa trên bookId
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM books WHERE bookId = ?");
            preparedStatement.setString(1, bookId);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateBook(Books book) {
        try {
            // Sử dụng PreparedStatement để cập nhật thông tin sách
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE books SET title = ?, author = ? WHERE bookId = ?");
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setString(3, book.getBookId());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Books getBook(String bookId) {
        try {
            // Truy vấn thông tin sách dựa trên bookId
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM books WHERE bookId = ?");
            preparedStatement.setString(1, bookId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                return new Books(bookId, title, author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
