package Services;

import Entities.Books;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BookService extends Remote {
    boolean addBook(Books book) throws RemoteException;
    boolean removeBook(String book) throws RemoteException;
    boolean updateBook(Books book) throws RemoteException;
    Books getBook(String bookId) throws RemoteException;
}
