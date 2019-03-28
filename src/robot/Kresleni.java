package robot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class Kresleni extends JFrame {

    private void namaluj(Graphics platno) {

        //platno.setColor(Color.GREEN);
        platno.setColor(new Color(159, 200, new Random().nextInt(255)));
        final int r = new Random().nextInt(100);
        platno.fillRoundRect(100, 100, 300, 300, r, r);


        final Malir g = new Geometr(platno);
        final Malir s = new Stopar(platno);
        final Malir f = new StavitelPyramid(platno);
        g.nakresli();
        s.nakresli();
        f.nakresli();
    }

    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        final Kresleni kresleni = new Kresleni();
        kresleni.setDefaultCloseOperation(EXIT_ON_CLOSE);
        final JPanel platno = new JPanel() {
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
                platno.getGraphics().drawString("Zmáčknuto", random.nextInt(maximumSize.width / 2 - 10), maximumSize.height / 2 + random.nextInt(maximumSize.height / 2 - 10));
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
        kresleni.getContentPane().add(cudlik, BorderLayout.NORTH);
        kresleni.setVisible(true);
        kresleni.pack();

        new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kresleni.repaint();
            }
        }).start();
    }
}
