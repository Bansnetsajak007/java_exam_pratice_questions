// Server program 

import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main (String[] args){
        try {
            //step 1: Create a server socket
            ServerSocket  serversocket = new ServerSocket(5000);
            System.out.println("Server is waiting for client request");

            //step 2: Accept the client request 
            Socket socket  = serversocket.accept();
            System.out.println("Client connected");     

            //step 3: Create input and output streams
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            
            //step 4: Read data from client and send response
            String clientMessage = in.readLine();
            System.out.println("Client Says: " + clientMessage);

            // Send response to client  
            String serverMessage = "Hello from Server"; 
            out.println(serverMessage);

            //step 5: Close the connections     
            socket.close(); 
            serversocket.close();   
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}