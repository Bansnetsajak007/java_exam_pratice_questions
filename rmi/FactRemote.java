//implement the remote interface 

import java.rmi.*;
import java.rmi.server.*;

public class FactRemote extends UnicastRemoteObject implements factorial_interface{
    public FactRemote() throws RemoteException {
        super();
    }

    public int calculateFactorial(int n) throws RemoteException {
        if(n==0)
            return 1;
        else
            return n*calculateFactorial(n-1);
    }
}