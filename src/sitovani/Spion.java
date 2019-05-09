package sitovani;

import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Spion {

  public void naslouchej(final JTextArea platno) {
    Runnable runnable = new Runnable() {
      public void run() {
        while(true) {
          try {
            InetAddress mcIPAddress = InetAddress.getByName("230.1.1.1");
            MulticastSocket mcSocket = new MulticastSocket(12345);
            mcSocket.joinGroup(mcIPAddress);

            DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);

            mcSocket.receive(packet);
            String msg = new String(packet.getData(), packet.getOffset(),
                    packet.getLength());

            mcSocket.leaveGroup(mcIPAddress);
            mcSocket.close();
            System.out.println("msg = " + msg);

            if(msg.equals("OHLUCHNI")) {
              msg = msg + "\n" + "Teď už nic neuslyšíš!";
            }
            if(msg.equals("OMDLI")) {
              msg = msg + "\n" + "Teď končíš!";
            }
            final String zprava = msg;
            SwingUtilities.invokeAndWait(new Runnable() {
              @Override
              public void run() {
                platno.setText(platno.getText() + "\n" + zprava);
              }
            });
            if(msg.startsWith("OHLUCHNI")) {
              break;
            }
            if(msg.startsWith("OMDLI")) {
              Thread.sleep(5000);
              System.exit(1);
            }
          } catch (IOException e) {
            e.printStackTrace();
          } catch (InterruptedException e) {
            e.printStackTrace();
          } catch (InvocationTargetException e) {
            e.printStackTrace();
          }
        }
      }
    };
    final Thread thread = new Thread(runnable);
    thread.setDaemon(true);
    thread.start();
  }
}
