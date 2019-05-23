package palindrom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

public class Palindrom extends JFrame {

  final JTextField poleProZadaniSlova = new JTextField(90);
  final JButton tlacitko = new JButton("Testuj");

  private void pripravitOkno() {
    getRootPane().setDefaultButton(tlacitko);
    final JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
    panel.add(new JLabel("Slovo:"));
    panel.add(poleProZadaniSlova);
    panel.add(tlacitko);
    tlacitko.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        otestujPalindrom();
      }
    });
    this.getContentPane().add(panel, BorderLayout.CENTER);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setVisible(true);
    this.pack();
  }

  private void otestujPalindrom() {
    if(spravneZadani()) {
      final String text = poleProZadaniSlova.getText().trim();
      if (jePalindrom(text)) {
        ukazVysledek(text + " není palindrom! Obráceně je to totiž: " + otoc(text));
      } else {
        ukazVysledek(text + " je palindrom!");
      }
    }
  }

  private String otoc(String text) {
    final int delka = text.length()-1;
    int index = 0;
    StringBuilder otocenyText = new StringBuilder();
    while(index<=delka) {
      otocenyText.append(text.charAt(delka - index));
      index+=1;
    }
    return otocenyText.toString();
  }

  private boolean jePalindrom(String text) {
    final int delka = text.length()-1;
    int index = 0;
    while(index<delka) {
      if(text.charAt(index) != text.charAt(delka-index)) {
        return false;
      }
      index+=1;
    }
    return true;
  }

  private boolean spravneZadani() {
    if (poleProZadaniSlova.getText().trim().equals("")) {
      ukazChybu("No tak...");
      return false;
    }
    return true;
  }

  private void ukazVysledek(String vysledek) {
    JOptionPane.showMessageDialog(this, vysledek, "Hotovo!!!", INFORMATION_MESSAGE);
  }
  private void ukazChybu(String popisChyby) {
    JOptionPane.showMessageDialog(this, popisChyby, "Chyba!!!", ERROR_MESSAGE);
  }

  public static void main(String[] args) {
    final Palindrom palindrom = new Palindrom();
    palindrom.pripravitOkno();
  }

}
