CREATE	DATABASE ManagementBooks;
USE ManagementBooks;

CREATE TABLE Books (
    BookID INT PRIMARY KEY AUTO_INCREMENT,
    Title VARCHAR(255),
    Author VARCHAR(255),
    Available BOOLEAN
);
CREATE TABLE Users (
    UserID VARCHAR(50) PRIMARY KEY,
    UserName VARCHAR(100),
    Email VARCHAR(100)
);
CREATE TABLE BorrowedBooks (
    BorrowID INT PRIMARY KEY AUTO_INCREMENT,
    UserID VARCHAR(50),
    BookID INT,
    BorrowDate DATE,
    ReturnDate DATE,
    FOREIGN KEY (UserID) REFERENCES Users(UserID),
    FOREIGN KEY (BookID) REFERENCES Books(BookID)
);
CREATE TABLE Authors (
    AuthorID INT PRIMARY KEY AUTO_INCREMENT,
    AuthorName VARCHAR(255)
);
ALTER TABLE Books
ADD COLUMN AuthorID INT,
ADD FOREIGN KEY (AuthorID) REFERENCES Authors(AuthorID);