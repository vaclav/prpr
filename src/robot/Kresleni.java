package robot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Kresleni extends JFrame {

  private static AtomicInteger velikost = new AtomicInteger(10);

  private void namaluj(Graphics platno) {
    final Malir g = new Geometr(platno);
    final Malir s = new Stopar(platno);
    final Malir f = new StavitelPyramid(platno);
    g.nakresli();
    s.nakresli();
    f.nakresli();


    new Kruzitko(platno, 600, 400, velikost.get(), true).nakresli();
    new Kruzitko(platno, 660, 400, velikost.get(), false).nakresli();
    new Kruzitko(platno, 720, 400, velikost.get(),true).nakresli();
    //new Kruzitko(platno, platno.getClipBounds().width/2, platno.getClipBounds().height/2, velikost.get(), false).nakresli();

    final int v = new Random().nextInt(10) + velikost.get();
    platno.setColor(Color.black);

//    platno.setFont(platno.getFont().deriveFont(40.0f).deriveFont(Font.ITALIC));

    platno.setFont(new Font("Savoye LET", Font.BOLD|Font.ITALIC, v));
    platno.drawString("Tanky s plamenometem jsou nej!", platno.getClipBounds().width/2, platno.getClipBounds().height/2 - 200);
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

    final JButton cudlik = new JButton("Cudlik");
    cudlik.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        final Random random = new Random();
        final Dimension maximumSize = kresleni.getSize();
        platno.getGraphics().drawString("Zmáčknuto", random.nextInt(maximumSize.width-10),random.nextInt(maximumSize.height-10));
      }
    });

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
    kresleni.getContentPane().add(cudlik,BorderLayout.NORTH);
    kresleni.setVisible(true);
    kresleni.pack();
    Timer animator = new Timer(100, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        final int v = velikost.incrementAndGet();
        if (v > 200) {
          velikost.set(10);
        }
        kresleni.invalidate();
        kresleni.repaint();
      }
    });
    animator.start();

  }
}
