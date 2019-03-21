package robot;

import javax.swing.*;
import java.awt.*;

public class Geometr extends Malir {
  public Geometr(Graphics platno) {
    super(platno);
  }

  @Override
  protected void nakresli() {
    graphics.setColor(Color.red);
    graphics.drawOval(500, 50, 100, 200);
    graphics.fillRect(100, 150, 100, 200);
  }
}
