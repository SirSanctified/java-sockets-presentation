// package resources;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    private static final int PORT = 9090;

    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(PORT)) {
            System.out.println("UDP Server listening on port " + PORT);
            
            byte[] receiveBuffer = new byte[1024];
            
            while (true) {
                // Prepare packet for receiving data
                DatagramPacket receivePacket = new DatagramPacket(
                    receiveBuffer, 
                    receiveBuffer.length
                );
                
                // Receive packet from client
                socket.receive(receivePacket);
                
                // Process received data
                String message = new String(
                    receivePacket.getData(), 0, 
                    receivePacket.getLength()
                );
                System.out.println("Received: " + message);
                
                // Prepare and send response
                String response = "Server received: " + message;
                byte[] sendBuffer = response.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(
                    sendBuffer, 
                    sendBuffer.length,
                    receivePacket.getAddress(),
                    receivePacket.getPort()
                );
                socket.send(sendPacket);
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}