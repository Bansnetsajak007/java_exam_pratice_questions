import java.net.*;

public class UDPServer {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(5000);
            System.out.println("UDP Server waiting...");

            byte[] buffer = new byte[1024];

            // Receive packet from client
            DatagramPacket packet =
                    new DatagramPacket(buffer, buffer.length);

            socket.receive(packet);

            String clientMessage =
                    new String(packet.getData(), 0, packet.getLength());

            System.out.println("Client Says: " + clientMessage);

            // Send response to client
            String serverMessage = "Hello from Server";
            byte[] sendData = serverMessage.getBytes();

            DatagramPacket sendPacket =
                    new DatagramPacket(
                            sendData,
                            sendData.length,
                            packet.getAddress(),
                            packet.getPort()
                    );

            socket.send(sendPacket);

            socket.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
