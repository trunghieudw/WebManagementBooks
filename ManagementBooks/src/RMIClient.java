import Entities.Books;
import Services.LibraryService;
import Services.ManagementService;

import java.rmi.Naming;
import java.util.List;

public class RMIClient {
    public static void main(String[] args) {
        try {
            // Connect to the RMI registry running on the server
            ManagementService managementService = (ManagementService) Naming.lookup("rmi://localhost/ManagementService");

            // Get the LibraryService from the ManagementService
            LibraryService libraryService = managementService.getLibraryService();

            // Retrieve the list of books
            List<Books> books = libraryService.getAllBooks();
            System.out.println("Available books: " + books);

            // Simulate borrowing a book (assuming bookId exists in the list)
            String userId = "123";
            String bookId = "Book 1";  // Replace with a valid book ID
            libraryService.borrowBook(userId, bookId);

            // Simulate returning a book
            libraryService.returnBook(userId, bookId);

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
