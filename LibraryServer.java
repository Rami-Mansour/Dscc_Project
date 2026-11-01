import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class LibraryServer {

    public static void main(String[] args) {

        try {

            // Create the RMI Registry
            Registry registry = LocateRegistry.createRegistry(1099);

            // Create the remote service object
            LibraryServiceImpl service = new LibraryServiceImpl();

            // Register the service in the RMI Registry
            registry.rebind("LibraryService", service);

            System.out.println("Library Server is running...");

        } catch (Exception e) {
            System.out.println("Server error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}