package robot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

public class Kresleni extends JFrame {

  private void namaluj(Graphics platno) {
    final Malir g = new Geometr(platno);
    final Malir s = new Stopar(platno);
    g.nakresli();
    s.nakresli();
  }

  public static void main(String[] args) throws InvocationTargetException, InterruptedException {
    final Kresleni kresleni = new Kresleni();
    kresleni.setDefaultCloseOperation(EXIT_ON_CLOSE);
    final JPanel platno = new JPanel(){
      @Override
      protected void paintComponent(Graphics g) {
        kresleni.namaluj(g);
      }
    };
    platno.setPreferredSize(new Dimension(1024, 860));
    kresleni.getContentPane().add(platno, BorderLayout.CENTER);

    final JButton tlacitkoKonec = new JButton("Konec");
    tlacitkoKonec.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        final int odpoved = JOptionPane.showConfirmDialog(kresleni, "Opravdu?", "Fakt jako konec?", JOptionPane.YES_NO_OPTION);
        if (odpoved == 0) {
          System.exit(1);
        }
      }
    });
    kresleni.getContentPane().add(tlacitkoKonec, BorderLayout.SOUTH);
    kresleni.setVisible(true);
    kresleni.pack();
  }
}
