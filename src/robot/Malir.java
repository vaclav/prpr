package robot;

import javax.swing.*;
import java.awt.*;

abstract class Malir {

  final Graphics graphics;

  public Malir(Graphics platno) {
    graphics = platno;
  }

  abstract protected void nakresli();
}
