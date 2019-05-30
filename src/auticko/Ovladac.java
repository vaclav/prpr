package auticko;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.*;

public class Ovladac extends KeyAdapter {
  private final int krok = 5;
  private Postava mojePostava;
  private final Hra hra;

  public Ovladac(Postava mojePostava, Hra hra) {
    this.mojePostava = mojePostava;
    this.hra = hra;
  }

  @Override
  public void keyPressed(KeyEvent e) {
    final int keyCode = e.getKeyCode();
    switch (keyCode) {
      case VK_UP:
        mojePostava.setY(mojePostava.getY() - krok);
        mojePostava.setAktualniSmer(Smery.DOLU);
        break;
      case VK_DOWN:
        mojePostava.setY(mojePostava.getY() - krok);
        mojePostava.setAktualniSmer(Smery.NAHORU);
        break;
      case VK_LEFT:
        mojePostava.setX(mojePostava.getX() + krok);
        mojePostava.setAktualniSmer(Smery.DOPRAVA);
        break;
      case VK_RIGHT:
        mojePostava.setX(mojePostava.getX() + krok);
        mojePostava.setAktualniSmer(Smery.DOLEVA);
        break;
    }
    hra.repaint();
  }
}
