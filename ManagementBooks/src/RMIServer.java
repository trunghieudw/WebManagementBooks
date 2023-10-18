import Service.LibraryService;
import Service.ManagementService;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RMIServer {

    public static void main(String[] args) {
        try {
            // Create an instance of the LibraryServiceImpl
            LibraryService libraryService = new LibraryServiceImpl();

            // Create an instance of the ManagementServiceImpl
            ManagementService managementService = new ManagementServiceImpl(libraryService);

            // Start the RMI registry on port 1099
            LocateRegistry.createRegistry(1099);

            // Bind the services to the RMI registry
            Naming.rebind("LibraryService", libraryService);
            Naming.rebind("ManagementService", managementService);

            System.out.println("Server started.");
        } catch (RemoteException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}
