package auticko;

import java.awt.*;

public abstract class Postava {
  private int x;
  private int y;
  private Smery aktualniSmer = Smery.NAHORU;

  public Postava() {
    this(100, 100);
  }

  public Postava(int x, int y) {
    this.x = x;
    this.y = y;
  }

  abstract void nakresliSe(Graphics graphics);

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public Smery getAktualniSmer() {
    return aktualniSmer;
  }

  public void setAktualniSmer(Smery aktualniSmer) {
    this.aktualniSmer = aktualniSmer;
  }
}
