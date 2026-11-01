import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

public class LibraryClient {

    public static void main(String[] args) {

        try {

            // Connect to the RMI Registry
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Look up the remote service
            LibraryService service = (LibraryService) registry.lookup("LibraryService");

            Scanner scanner = new Scanner(System.in);

            int choice;

            do {

                System.out.println("\n===== Library Management System =====");
                System.out.println("1. Add Book");
                System.out.println("2. Search Book");
                System.out.println("3. View All Available Books");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");

                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {

                    case 1:

                        System.out.print("Enter Book ID: ");
                        String bookId = scanner.nextLine();

                        System.out.print("Enter Book Title: ");
                        String title = scanner.nextLine();

                        System.out.print("Enter Book Author: ");
                        String author = scanner.nextLine();

                        String addResult = service.addBook(bookId, title, author);

                        System.out.println(addResult);

                        break;

                    case 2:

                        System.out.print("Enter Book Title: ");
                        String searchTitle = scanner.nextLine();

                        String searchResult = service.searchBook(searchTitle);

                        System.out.println(searchResult);

                        break;

                    case 3:

                        List<String> books = service.viewAllBooks();

                        if (books.isEmpty()) {
                            System.out.println("No available books.");
                        } else {
                            System.out.println("\nAvailable Books:");

                            for (String book : books) {
                                System.out.println(book);
                            }
                        }

                        break;

                    case 4:

                        System.out.println("Exiting Library System...");
                        break;

                    default:

                        System.out.println("Invalid choice.");

                }

            } while (choice != 4);

            scanner.close();

        } catch (Exception e) {

            System.out.println("Client error: " + e.getMessage());
            e.printStackTrace();

        }
    }
}