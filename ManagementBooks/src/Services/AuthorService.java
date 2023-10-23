package Services;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import Entities.Authors;

public interface AuthorService extends Remote {
    List<Authors> getAllAuthors() throws RemoteException;
    Authors getAuthor(String authorId) throws RemoteException;
    boolean addAuthor(Authors author) throws RemoteException;
    boolean updateAuthor(Authors author) throws RemoteException;
    boolean removeAuthor(String authorId) throws RemoteException;
}
