package auticka;

import java.awt.*;

public class SlapaciKolo extends Vozidlo implements Animacek {

  Color barva;

  public SlapaciKolo(Color barva) {
    super(2, 50, Pohon.Manualni);
    this.barva = barva;
  }

  @Override
  public String vydejZvuk() {
    return "vrz vrz";
  }

  @Override
  public void nakresliSe(Graphics platno, int x, int y) {
    platno.setColor(Color.black);
    int stredPrednihoKolaX = x;
    int stredPrednihoKolaY = y;
    int stredZadnihoKolaX = x + 40;
    int stredZadnihoKolaY = y;
    platno.drawOval(stredPrednihoKolaX-15, stredPrednihoKolaY - 15, 30, 30);
    platno.drawOval(stredPrednihoKolaX-2, stredPrednihoKolaY - 2, 4, 4);
    platno.drawOval(stredZadnihoKolaX-15, stredZadnihoKolaY - 15, 30, 30);
    platno.drawOval(stredZadnihoKolaX-2, stredZadnihoKolaY - 2, 4, 4);
    platno.setColor(this.barva);
    platno.drawLine(stredPrednihoKolaX, stredPrednihoKolaY, stredPrednihoKolaX + 20, stredPrednihoKolaY - 30);
    platno.drawLine(stredZadnihoKolaX, stredZadnihoKolaY, stredZadnihoKolaX - 40, stredZadnihoKolaY);
    super.nakresliSe(platno, x, y);
  }
}
