// Define the remote interface

import java.rmi.*;

public interface factorial_interface extends Remote {
    public int calculateFactorial(int n) throws RemoteException;
}