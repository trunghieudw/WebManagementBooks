package Services;

import Entities.Books;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface BookService extends Remote {
    List<Books> getAllBooks() throws RemoteException;

    boolean addBook(Books book) throws RemoteException;

    boolean removeBook(String book) throws RemoteException;

    boolean updateBook(Books book) throws RemoteException;

    Books getBook(String bookId) throws RemoteException;
}
