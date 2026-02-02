// Client code 

// client calls the remote method to calculate factorial

import java.rmi.*;
import java.rmi.registry.*;
import java.util.Scanner;


public class Client {
    public static void main (String[] args) {
        try{
            int number;

            // Getting the registry
            Registry registry = LocateRegistry.getRegistry("localhost",5000);
            factorial_interface obj = (factorial_interface) registry.lookup("factorial_service");  //server bata factorial_service ko object lina ko lagi leko


            //taking input from user
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter a number to calculate its factorial: ");
            number = sc.nextInt();  
            int result = obj.calculateFactorial(number);    

            System.out.println("Factorial of " + number + " is: " + result);
        } catch(Exception e){
            System.out.println(e);
        }
    }
}