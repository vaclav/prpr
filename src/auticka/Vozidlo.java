package auticka;

import java.awt.*;

public abstract class Vozidlo implements Animacek{
  int pocetKol;
  int maximalniRychlost;
  Pohon druhPohonu;

  public Vozidlo(int pocetKol, int maximalniRychlost, Pohon druhPohonu) {
    this.pocetKol = pocetKol;
    this.maximalniRychlost = maximalniRychlost;
    this.druhPohonu = druhPohonu;
  }

  public abstract String vydejZvuk();

  @Override
  public void nakresliSe(Graphics platno, int x, int y) {
    platno.drawString(vydejZvuk(), x + 30, y - 60);
  }
}
