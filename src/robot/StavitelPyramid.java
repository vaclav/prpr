package robot;

import java.awt.*;

public class StavitelPyramid extends Malir {
  public StavitelPyramid (Graphics platno) {
    super(platno);

  }
  @Override
  protected void nakresli() {
graphics.drawLine(300,300,450,500);
graphics.drawLine(300,300,150,500);
graphics.drawLine(450,500,150,500);
  }


}
