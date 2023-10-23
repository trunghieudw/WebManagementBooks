import Services.AuthorService;
import Services.BookService;
import Services.UserService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

import Entities.Books;

public class RMIClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            BookService bookService = (BookService) registry.lookup("BookService");
            UserService userService = (UserService) registry.lookup("UserService");
            AuthorService authorService = (AuthorService) registry.lookup("AuthorService");

            Scanner scanner = new Scanner(System.in);
            int choice;
            boolean exit = false;

            while (!exit) {
                System.out.println("Menu:");
                System.out.println("1. Add Book");
                System.out.println("2. Remove Book");
                System.out.println("3. Update Book");
                System.out.println("4. Get All Books");
                System.out.println("5. Add User");
                System.out.println("6. Remove User");
                System.out.println("7. Update User");
                System.out.println("8. Get All Users");
                System.out.println("9. Add Author");
                System.out.println("10. Remove Author");
                System.out.println("11. Update Author");
                System.out.println("12. Get All Authors");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        // Thêm sách
                        System.out.println("Enter book title: ");
                        String title = scanner.next();
                        System.out.println("Enter book author: ");
                        String author = scanner.next();
                        // Gọi phương thức từ dịch vụ để thêm sách
                        bookService.addBook(new Books(title, author));
                        System.out.println("Book added successfully.");
                        break;
                    case 2:
                        // Thực hiện xoá sách
                        System.out.println("Enter book ID to delete: ");
                        String bookIdToDelete = scanner.next();
                        // Gọi phương thức từ dịch vụ để xoá sách
                        boolean isDeleted = bookService.removeBook(bookIdToDelete);
                        if (isDeleted) {
                            System.out.println("Book with ID " + bookIdToDelete + " has been deleted.");
                        } else {
                            System.out
                                    .println("Book with ID " + bookIdToDelete + " not found or could not be deleted.");
                        }
                        break;
                    case 3:
                        // Thực hiện cập nhật sách
                        System.out.println("Enter book ID to update: ");
                        String bookIdToUpdate = scanner.next();
                        System.out.println("Enter new book title: ");
                        String newTitle = scanner.next();
                        System.out.println("Enter new book author: ");
                        String newAuthor = scanner.next();
                        // Tạo một đối tượng Books mới với thông tin cập nhật
                        Books updatedBook = new Books(bookIdToUpdate, newTitle, newAuthor);
                        // Gọi phương thức từ dịch vụ để cập nhật sách
                        boolean isUpdated = bookService.updateBook(updatedBook);
                        if (isUpdated) {
                            System.out.println("Book with ID " + bookIdToUpdate + " has been updated.");
                        } else {
                            System.out
                                    .println("Book with ID " + bookIdToUpdate + " not found or could not be updated.");
                        }
                        break;
                    case 4:
                        // Lấy danh sách tất cả sách
                        List<Books> books = bookService.getAllBooks();
                        for (Books book : books) {
                            System.out.println(book.getTitle() + " by " + book.getAuthor());
                        }
                        break;
                    case 5:
                        // Thực hiện thêm người dùng
                        break;
                    case 6:
                        // Thực hiện xoá người dùng
                        break;
                    case 7:
                        // Thực hiện cập nhật người dùng
                        break;
                    case 8:
                        // Lấy danh sách tất cả người dùng
                        break;
                    case 9:
                        // Thực hiện thêm tác giả
                        break;
                    case 10:
                        // Thực hiện xoá tác giả
                        break;
                    case 11:
                        // Thực hiện cập nhật tác giả
                        break;
                    case 12:
                        // Lấy danh sách tất cả tác giả
                        break;
                    case 0:
                        exit = true;
                        break;
                    default:
                        System.out.println("Hay lua chon 1 cai khac");
                        break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
