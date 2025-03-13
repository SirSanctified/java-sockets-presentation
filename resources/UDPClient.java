// package resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 9090;

    public static void main(String[] args) {
        try (
            DatagramSocket socket = new DatagramSocket();
            BufferedReader userInput = new BufferedReader(
                new InputStreamReader(System.in))
        ) {
            InetAddress serverAddress = InetAddress.getByName(SERVER_ADDRESS);
            
            System.out.println("Type messages to send:");
            
            String message;
            while ((message = userInput.readLine()) != null) {
                // Send data to server
                byte[] sendBuffer = message.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(
                    sendBuffer, 
                    sendBuffer.length,
                    serverAddress, 
                    SERVER_PORT
                );
                socket.send(sendPacket);
                
                // Receive server's response
                byte[] receiveBuffer = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(
                    receiveBuffer, 
                    receiveBuffer.length
                );
                socket.receive(receivePacket);
                
                // Process response
                String response = new String(
                    receivePacket.getData(), 0, 
                    receivePacket.getLength()
                );
                System.out.println("Server response: " + response);
                
                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}