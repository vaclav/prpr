package cviceni.lekce1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Ovladac implements ActionListener {
  private Formular formular;

  public Ovladac(Formular formular) {
    this.formular = formular;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    formular.vysledek.setText("Nevím. Nauč mě to");
  }
}
