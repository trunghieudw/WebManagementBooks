package Services;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ManagementService extends Remote {
    LibraryService getLibraryService() throws RemoteException;
    UserService getUserService() throws RemoteException;
    BookService getBookService() throws RemoteException;
}
