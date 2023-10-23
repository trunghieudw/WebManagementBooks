package ServiceImpl;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Services.BookService;
import Services.LibraryService;
import Services.ManagementService;
import Services.UserService;

public class ManagementServiceImpl extends UnicastRemoteObject implements ManagementService {
    private LibraryService libraryService;
    private UserService userService;
    private BookService bookService;

    public ManagementServiceImpl(LibraryService libraryService) throws RemoteException {
        super();
        this.libraryService = libraryService;
        // Initialize the userService and bookService as needed
        // For simplicity, we'll initialize them as null
        this.userService = null;
        this.bookService = null;
    }

    @Override
    public LibraryService getLibraryService() throws RemoteException {
        return this.libraryService;
    }

    @Override
    public UserService getUserService() throws RemoteException {
        return this.userService;
    }

    @Override
    public BookService getBookService() throws RemoteException {
        return this.bookService;
    }
}
