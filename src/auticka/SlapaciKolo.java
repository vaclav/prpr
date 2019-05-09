package auticka;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class SlapaciKolo extends Vozidlo {

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

    try {
      final BufferedImage image = ImageIO.read(new File("src/auticka/ideal-funcore-m-bicycle.jpg"));
      platno.drawImage(image, x + 100, y, 50, 32, new ImageObserver() {
        @Override
        public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
          return false;
        }
      });
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
