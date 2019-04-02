package robot;

import javax.swing.*;
import java.awt.*;

public class Geometr extends Malir {
  public Geometr(Graphics platno) {
    super(platno);
  }

  @Override
  protected void nakresli() {
    graphics.setColor(Color.green);
    graphics.fillRect(700,50,100,100);
    graphics.setColor(Color.red);
    graphics.drawOval(700, 650, 100, 100);
    graphics.drawRect(100, 50, 100, 100);
    graphics.setColor(Color.LIGHT_GRAY);
    graphics.fillRect(100, 650, 100, 100);
  }
}
