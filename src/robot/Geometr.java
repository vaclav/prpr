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
    graphics.fillRect(500,50,100,100);
    graphics.setColor(Color.red);
    graphics.drawOval(500, 50, 100, 100);
    graphics.drawRect(500, 50, 100, 100);
    graphics.setColor(Color.LIGHT_GRAY);
    graphics.fillRect(100, 150, 100, 100);

    graphics.setColor(Color.green);
    graphics.fillOval(100, 150, 100, 100);
    graphics.fillOval(500,50,100,100);



  }
}
