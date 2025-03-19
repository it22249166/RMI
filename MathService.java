import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MathService extends Remote {
    int getClientCount() throws RemoteException;
    int add(int a, int b) throws RemoteException;
    int subtract(int a, int b) throws RemoteException;
    int multiply(int a, int b) throws RemoteException; // Corrected method name
    int divide(int a, int b) throws RemoteException;

}