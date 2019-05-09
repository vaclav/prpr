package auticka;

import java.io.IOException;
import java.net.*;

public class Vypravec {
  public static void main(String[] args) throws IOException {
    DatagramSocket udpSocket = new DatagramSocket();
    InetAddress mcIPAddress = InetAddress.getByName("230.1.1.1");
    byte[] msg = "OMDLI".getBytes();
    DatagramPacket packet = new DatagramPacket(msg, msg.length);
    packet.setAddress(mcIPAddress);
    packet.setPort(12345);
    udpSocket.send(packet);

    System.out.println("Sent a  multicast message.");
    System.out.println("Exiting application");
    udpSocket.close();
  }
}
