package robot;

import javax.swing.*;
import java.awt.*;

public class Stopar extends Malir {
  public Stopar(Graphics platno) {
    super(platno);
  }

  @Override
  protected void nakresli() {
    graphics.setColor(Color.green);
    int tedX = 0;
    int tedY = 0;
    int potomX = 100;
    int potomY = 100;
    graphics.drawLine(tedX, tedY, potomX, potomY);

    graphics.setColor(Color.blue);
    tedX = potomX;
    tedY = potomY;
    potomX = 311;
    potomY = 210;
    graphics.drawLine(tedX, tedY, potomX, potomY);

    graphics.setColor(Color.yellow);
    tedX = potomX;
    tedY = potomY;
    potomX = 400;
    potomY = 30;
    graphics.drawLine(tedX, tedY, potomX, potomY);

    graphics.setColor(Color.lightGray);
    tedX = potomX;
    tedY = potomY;
    potomX = 700;
    potomY = 400;
    graphics.drawLine(tedX, tedY, potomX, potomY);
  }
}
