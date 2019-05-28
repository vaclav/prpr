package auticko;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import static auticko.Smery.*;

public class Auto extends Postava {
  private int sirka;
  private int vyska;
  BufferedImage image = null;

  public Auto(int sirka, int vyska) {
    this.sirka = sirka;
    this.vyska = vyska;
    try {
      image = ImageIO.read(new File("src/auticko/auto.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  @Override
  void nakresliSe(Graphics graphics) {
//    graphics.fillOval(getX(), getY(), sirka, vyska);
    Image aktualniStav=null;
    switch(getAktualniSmer()) {
      case NAHORU:
        aktualniStav = rotate(image, Math.toRadians(90));
        break;
      case DOLU:
        aktualniStav = rotate(image, Math.toRadians(-90));
        break;
      case DOLEVA:
        aktualniStav = rotate(image, Math.toRadians(0));
        break;
      case DOPRAVA:
        aktualniStav = rotate(image, Math.toRadians(180));
        break;
    }

    graphics.drawImage(aktualniStav, getX() + 100, getY(), new ImageObserver() {
      @Override
      public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
        return false;
      }
    });

  }

  public static BufferedImage rotate(BufferedImage image, double angle) {
    double sin = Math.abs(Math.sin(angle)), cos = Math.abs(Math.cos(angle));
    int w = image.getWidth(), h = image.getHeight();
    int neww = (int)Math.floor(w*cos+h*sin), newh = (int) Math.floor(h * cos + w * sin);
    GraphicsConfiguration gc = getDefaultConfiguration();
    BufferedImage result = gc.createCompatibleImage(neww, newh, Transparency.TRANSLUCENT);
    Graphics2D g = result.createGraphics();
    g.translate((neww - w) / 2, (newh - h) / 2);
    g.rotate(angle, w / 2, h / 2);
    g.drawRenderedImage(image, null);
    g.dispose();
    return result;
  }

  private static GraphicsConfiguration getDefaultConfiguration() {
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice gd = ge.getDefaultScreenDevice();
    return gd.getDefaultConfiguration();
  }
}
