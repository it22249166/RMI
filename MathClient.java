import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class MathClient {
    public static void main(String args[]) {
        MathService service = null;

        try {
            
            service = (MathService) Naming.lookup("//localhost/CalculatorService");
            System.out.println("Number of clients connected : " + service.getClientCount());
            System.out.println("Add: " + service.add(2, 2));
            System.out.println("Subtract: " + service.subtract(5, 2));
            System.out.println("Multiply: " + service.multiply(2, 8));
            System.out.println("Divide: " + service.divide(20, 2));

        } catch (NotBoundException ne) {
            System.err.println(ne.getMessage());

        } catch (MalformedURLException me) {
            System.err.println(me.getMessage());

        } catch (RemoteException re) {
            System.err.println(re.getMessage());
        }
    }
}