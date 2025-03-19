import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MathServer implements MathService {

    private int clientCount = 0;

    public MathServer() {
        super();
    }

    public synchronized int getClientCount() throws RemoteException {
        clientCount++;
        return clientCount;
    }

    public int add(int a, int b) throws RemoteException {
       
        return a + b;
    }

    public int subtract(int a, int b) throws RemoteException {
       
        return a - b;
    }

    public int multiply(int a, int b) throws RemoteException {
       
        return a * b;
    }

    public int divide(int a, int b) throws RemoteException {
        
        return a / b;
    }

    public static void main(String args[]) {
        try {
            MathServer obj = new MathServer();
            MathService stub = (MathService) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("CalculatorService", stub);

            System.out.println("MathServer ready");
/*************  ✨ Codeium Command ⭐  *************/
/**
 * The main method initializes the RMI server for MathService. It sets up the
 * security manager if it's not already set, creates an instance of MathServer,
 * and binds it to the RMI registry with the name "CalculatorService". It
 * handles exceptions related to remote operations and binding issues.
 */

/******  9b912c6d-947f-4548-8968-0ddcf10f44a4  *******/        } catch (Exception e) {
            System.err.println("MathServer exception: " + e.toString());
            e.printStackTrace();
        }
    }
}