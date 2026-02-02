import java.net.*;

public class UDPClient {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();

            String serverIP = "192.168.1.71";
            InetAddress address = InetAddress.getByName(serverIP);

            String clientMessage = "Hello from Client";
            byte[] sendData = clientMessage.getBytes();

            // Send packet
            DatagramPacket sendPacket =
                    new DatagramPacket(
                            sendData,
                            sendData.length,
                            address,
                            5000
                    );

            socket.send(sendPacket);

            // Receive response
            byte[] buffer = new byte[1024];
            DatagramPacket receivePacket =
                    new DatagramPacket(buffer, buffer.length);

            socket.receive(receivePacket);

            String serverReply =
                    new String(receivePacket.getData(), 0, receivePacket.getLength());

            System.out.println("Server Says: " + serverReply);

            socket.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
