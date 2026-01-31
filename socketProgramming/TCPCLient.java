// Client program 

import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main (String[] args) {
        try {
            //create socket connection to server
            String Host_url = "192.168.1.71"; // Server IP address    
            Socket socket = new Socket(Host_url, 5000);

            //create input and output streams
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            //send data to server
            String clientMessage = "Hello from Client";
            out.println(clientMessage);

            //read response from server
            String serverReply = in.readLine();
            System.out.println("Server Says: " + serverReply);

            //close the connections
            socket.close();



        } catch (Exception e) {
            System.out.println(e);
        }
    }
}