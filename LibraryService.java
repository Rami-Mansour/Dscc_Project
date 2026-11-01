import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface LibraryService extends Remote {

    String addBook(String bookId, String title, String author)
            throws RemoteException;

    String searchBook(String title)
            throws RemoteException;

    List<String> viewAllBooks()
            throws RemoteException;

    String issueBook(String bookId, String studentName)
            throws RemoteException;

    List<String> viewIssuedBookHistory()
            throws RemoteException;
}