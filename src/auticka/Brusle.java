package auticka;

import java.awt.*;

public class Brusle extends Vozidlo {
  public Brusle() {
    super(0, 25, Pohon.Manualni);
  }

  @Override
  public String vydejZvuk() {
    return "Skrip Skrip";
  }

  @Override
  public void nakresliSe(Graphics platno, int x, int y) {
    platno.setColor(Color.black);

    int prvniBodX = x;
    int prvniBodY = y;
    int druhyBodX = x + 40;
    int druhyBodY = y;
    platno.drawLine(prvniBodX - 10,prvniBodY,druhyBodX,druhyBodY);
    platno.drawLine(prvniBodX,prvniBodY - 10, druhyBodX, druhyBodY - 10);
    platno.drawLine(prvniBodX + 10, prvniBodY,prvniBodX + 10, druhyBodY - 10);
    platno.drawLine(druhyBodX - 10, prvniBodY, druhyBodX - 10, druhyBodY - 10);


  }
}
