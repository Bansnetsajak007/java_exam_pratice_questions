// Creating the server aplication

import java.rmi.*;
import java.rmi.registry.*;

public class Server {
    public static void main(String[] args ) {
        try{
            FactRemote obj = new FactRemote();
            Registry registry = LocateRegistry.createRegistry(5000);
            registry.rebind("factorial_service", obj);   //factorial service ma bind gararw object pathako 
            System.out.println("Server is ready...");
        } catch(Exception e){
            System.out.println(e);
        }
    }
}