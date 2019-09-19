package cviceni.lekce1;

import javax.swing.*;
import java.awt.*;

public class Formular extends JFrame {
  final JLabel vysledek = new JLabel("Poznám přestupný rok.");
  final JTextField zadanyRok = new JTextField("rok", 4);

  void pripravit() {
    final JPanel plochaProPolicka = new JPanel(new GridLayout(1, 3));
    plochaProPolicka.add(new JLabel("Zadejte rok:"));
    plochaProPolicka.add(zadanyRok);
    plochaProPolicka.add(vysledek);
    this.add(plochaProPolicka, BorderLayout.CENTER);
    final JButton tlacitko = new JButton("Spusť výpočet");
    this.add(tlacitko, BorderLayout.SOUTH);

    tlacitko.addActionListener(new Ovladac(this));
  }

}
