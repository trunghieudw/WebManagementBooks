package ServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.BookDAO;
import Entities.Books;
import Services.BookService;

public class BookServiceImpl extends UnicastRemoteObject implements BookService {
    private BookDAO bookDAO;

    public BookServiceImpl(Connection connection) throws RemoteException {
        super();
        bookDAO = new BookDAO(connection);
    }

    @Override
    public boolean addBook(Books book) throws RemoteException {
        return bookDAO.addBook(book);
    }

    @Override
    public boolean removeBook(String bookId) throws RemoteException {
        return bookDAO.removeBook(bookId);
    }

    @Override
    public boolean updateBook(Books book) throws RemoteException {
        return bookDAO.updateBook(book);
    }

    @Override
    public Books getBook(String bookId) throws RemoteException {
        return bookDAO.getBook(bookId);
    }

    @Override
    public List<Books> getAllBooks() throws RemoteException {
        return bookDAO.getAllBooks();
    }

}
