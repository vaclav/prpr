package kalkulator;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class Kalkulator extends JFrame {

  final JTextField hodnota1 = new JTextField();
  final JTextField hodnota2 = new JTextField();
  final TextArea vysledkovaTabule = new TextArea(40, 80);

  private void plus() {
    if (spravneZadani()) {
      try {
        final String a = hodnota1.getText();
        final String b = hodnota2.getText();
        final int i = Integer.parseInt(a);
        final int j = Integer.parseInt(b);
        final int vysledek = i + j;
        vysledkovaTabule.setText(vysledkovaTabule.getText() + a + " + " + b + " = " + vysledek + "\n");
      } catch (NumberFormatException e) {
        ukazChybu("Chybné číslo");
      }
    }
  }

  private void minus() {
    if (spravneZadani()) {
      try {
        final String a = hodnota1.getText();
        final String b = hodnota2.getText();
        final int i = Integer.parseInt(a);
        final int j = Integer.parseInt(b);
        final int vysledek = i - j;
        vysledkovaTabule.setText(vysledkovaTabule.getText() + a + " - " + b + " = " + vysledek + "\n");
      } catch (NumberFormatException e) {
        ukazChybu("Chybné číslo");
      }
    }
  }

  private void krat() {
    if (spravneZadani()) {
      try {
        final String a = hodnota1.getText();
        final String b = hodnota2.getText();
        final int i = Integer.parseInt(a);
        final int j = Integer.parseInt(b);
        final int vysledek = i * j;
        vysledkovaTabule.setText(vysledkovaTabule.getText() + a + " * " + b + " = " + vysledek + "\n");
      } catch (NumberFormatException e) {
        ukazChybu("Chybné číslo");
      }
    }
  }

  private void deleno() {
    if (spravneZadani()) {
      try {
        final String a = hodnota1.getText();
        final String b = hodnota2.getText();
        final int i = Integer.parseInt(a);
        final int j = Integer.parseInt(b);
        if(j==0) {
          ukazChybu("Nebudu dělit nulou");
          return;
        }
        if (i % j == 0) {
          int vysledek = i / j;
          vysledkovaTabule.setText(vysledkovaTabule.getText() + a + " / " + b + " = " + vysledek + "\n");
        } else {
          double vysledek = (double)i/j;
          vysledkovaTabule.setText(vysledkovaTabule.getText() + a + " / " + b + " = " + vysledek + "\n");
        }
      } catch (NumberFormatException e) {
        ukazChybu("Chybné číslo");
      }
    }
  }

  private void vycisti() {
    vysledkovaTabule.setText("");
    final JLabel p = new JLabel(new ImageIcon("src/auticka/ideal-funcore-m-bicycle.jpg"), SwingConstants.LEFT);
    this.getContentPane().add(p, BorderLayout.WEST);
    this.setVisible(false);
    this.setVisible(true);
  }

  private boolean spravneZadani() {
    if (hodnota1.getText().trim().equals("")) {
      ukazChybu("Chybí první číslo");
      return false;
    }
    if (hodnota2.getText().trim().equals("")) {
      ukazChybu("Chybí druhé číslo");
      return false;
    }
    return true;
  }

  private void pripravitOkno() {
    pripravHorniPanel();
    pripravTlacitka();
    this.getContentPane().add(new JScrollPane(vysledkovaTabule), BorderLayout.CENTER);

    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setVisible(true);
    this.pack();
  }

  private void pripravTlacitka() {
    final JPanel panelTlacitek = new JPanel();
    panelTlacitek.setLayout(new BoxLayout(panelTlacitek, BoxLayout.X_AXIS));
    final JButton tlacitkoSecti = new JButton("+");
    panelTlacitek.add(tlacitkoSecti);
    final JButton tlacitkoOdecti = new JButton("-");
    panelTlacitek.add(tlacitkoOdecti);
    final JButton tlacitkoVynasob = new JButton("*");
    panelTlacitek.add(tlacitkoVynasob);
    final JButton tlacitkoVydel = new JButton("/");
    panelTlacitek.add(tlacitkoVydel);
    final JButton tlacitkoVycisti = new JButton("Vyčisti výsledky");
    panelTlacitek.add(tlacitkoVycisti);
    this.getContentPane().add(panelTlacitek, BorderLayout.SOUTH);

    tlacitkoSecti.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        plus();
      }
    });
    tlacitkoOdecti.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        minus();
      }
    });
    tlacitkoVynasob.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        krat();
      }
    });
    tlacitkoVydel.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        deleno();
      }
    });
    tlacitkoVycisti.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        vycisti();
      }
    });
  }

  private void pripravHorniPanel() {
    final JPanel horniPanel = new JPanel();
    horniPanel.setLayout(new BoxLayout(horniPanel, BoxLayout.X_AXIS));
    horniPanel.add(new JLabel("1. číslo:"));
    horniPanel.add(hodnota1);
    horniPanel.add(new JLabel("2. číslo:"));
    horniPanel.add(hodnota2);
    this.getContentPane().add(horniPanel, BorderLayout.NORTH);
  }

  private void ukazChybu(String popisChyby) {
    JOptionPane.showMessageDialog(this, popisChyby, "Chyba!!!", ERROR_MESSAGE);
  }

  public static void main(String[] args) {
    final Kalkulator kalkulator = new Kalkulator();
    kalkulator.pripravitOkno();
  }
}
