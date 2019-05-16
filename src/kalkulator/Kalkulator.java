package kalkulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class Kalkulator extends JFrame {

  final JTextField hodnota1 = new JTextField();
  final JTextField hodnota2 = new JTextField();
  final TextArea vysledkovaTabule = new TextArea(40, 80);

  private void plus() {
  }

  private void minus() {
  }

  private void krat() {
  }

  private void deleno() {
  }

  private void vycisti() {
    vysledkovaTabule.setText("");
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
    final JButton tlacitkoOdecti = new JButton("*");
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
