
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

// Implements the remote interface and makes this object available through RMI
public class LibraryServiceImpl extends UnicastRemoteObject
        implements LibraryService {

    // Stores books using book ID as the key and Book object as the value
    private HashMap<String, Book> books;

    // Stores currently issued books (Book ID -> Student Name)
    private HashMap<String, String> issuedBooks;

    // Stores the history of book issuing operations
    private List<String> issuedBookHistory;

    // Constructor: initializes the HashMap
    public LibraryServiceImpl() throws RemoteException {
        books = new HashMap<>();
        issuedBooks = new HashMap<>();
        issuedBookHistory = new ArrayList<>();

    }

    // Adds a new book to the library
    @Override
    public String addBook(String bookId, String title, String author)
            throws RemoteException {

        // Check if the book ID already exists
        if (books.containsKey(bookId)) {
            return "Book ID already exists";
        }

        // Create a new Book object
        Book book = new Book(bookId, title, author);

        // Store the book in the HashMap
        books.put(bookId, book);

        return "Book added successfully";
    }

    // Searches for a book by its title
    @Override
    public String searchBook(String title) throws RemoteException {

        // Loop through all stored books
        for (Book book : books.values()) {

            // Compare titles without considering uppercase or lowercase
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book.toString();
            }
        }

        // Return this message if no matching book is found
        return "Book not found";
    }

    // Returns the details of all books in the library
    // Returns all available books
    @Override
    public List<String> viewAllBooks() throws RemoteException {

        List<String> bookList = new ArrayList<>();

        for (Book book : books.values()) {

            // Check if the book is not currently issued
            if (!issuedBooks.containsKey(book.getBookId())) {
                bookList.add(book.toString());
            }
        }

        return bookList;
    }

    // Issues a book to a student
    public String issueBook(String bookId, String studentName)
            throws RemoteException {

        // Check if the book exists in the library
        if (!books.containsKey(bookId)) {
            return "Book not found";
        }

        // Check if the book is already issued
        if (issuedBooks.containsKey(bookId)) {
            return "Book is already issued";
        }

        // Get the book details
        Book book = books.get(bookId);

        // Store the book ID and student name
        issuedBooks.put(bookId, studentName);

        // Add the issuing operation to the history
        issuedBookHistory.add(
                "Book ID: " + bookId +
                        ", Title: " + book.getTitle() +
                        ", Student: " + studentName);

        return "Book issued successfully";
    }

    // Returns the history of issued books
    public List<String> viewIssuedBookHistory() {

        // Return all issuing records
        return new ArrayList<>(issuedBookHistory);
    }
}
