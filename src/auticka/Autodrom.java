package auticka;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Autodrom extends JFrame {

  List<Animacek> animacci = new ArrayList<Animacek>();

  public Autodrom() {
    animacci.add(new SlapaciKolo(Color.red));
    animacci.add(new SlapaciKolo(Color.blue));
    animacci.add(new Brusle());
  }

  private void namaluj(Graphics platno) {
    final Random random = new Random();
    for (Animacek a : animacci) {
      a.nakresliSe(platno, random.nextInt(600), random.nextInt(600));
    }
  }

  public static void main(String[] args) {
    final Autodrom autodrom = new Autodrom();
    autodrom.setDefaultCloseOperation(EXIT_ON_CLOSE);
    final JPanel platno = new JPanel(){
      @Override
      protected void paintComponent(Graphics g) {
        autodrom.namaluj(g);
      }
    };
    platno.setPreferredSize(new Dimension(1024, 860));
    autodrom.getContentPane().add(platno, BorderLayout.CENTER);

    final JButton tlacitkoKonec = new JButton("Konec");
    tlacitkoKonec.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        final int odpoved = JOptionPane.showConfirmDialog(autodrom, "Opravdu?", "Fakt jako konec?", JOptionPane.YES_NO_OPTION);
        if (odpoved == 0) {
          System.exit(1);
        }
      }
    });
    autodrom.getContentPane().add(tlacitkoKonec, BorderLayout.SOUTH);

    final JTextArea area = new JTextArea();
    area.setColumns(100);
    final JScrollPane scrollPanel = new JScrollPane(area);
    autodrom.add(scrollPanel, BorderLayout.EAST);
    autodrom.setVisible(true);
    autodrom.pack();
    new Spion().naslouchej(area);
  }

}
