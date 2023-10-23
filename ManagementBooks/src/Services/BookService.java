package Services;

import Entities.Books;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface BookService extends Remote {
    List<Books> searchBooks(String keyword) throws RemoteException;

}
