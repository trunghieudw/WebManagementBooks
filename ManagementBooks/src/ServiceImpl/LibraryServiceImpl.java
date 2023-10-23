package ServiceImpl;
import Entities.Books;
import Services.LibraryService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class LibraryServiceImpl extends UnicastRemoteObject implements LibraryService {
    private List<Books> books;

    public LibraryServiceImpl() throws RemoteException {
        super();
        // Initialize the list of books
        books = new ArrayList<>();
        books.add(new Books("Book 1", "Author 1"));
        books.add(new Books("Book 2", "Author 2"));
        books.add(new Books("Book 3", "Author 3"));
    }

    @Override
    public List<Books> getAllBooks() throws RemoteException {
        return books;
    }

    @Override
    public void borrowBook(String userId, String bookId) throws RemoteException {
        // Simulate borrowing a book
        System.out.println("User " + userId + " borrowed book with ID " + bookId);
    }

    @Override
    public void returnBook(String userId, String bookId) throws RemoteException {
        // Simulate returning a book
        System.out.println("User " + userId + " returned book with ID " + bookId);
    }

   

   
}
