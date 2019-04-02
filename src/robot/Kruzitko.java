package robot;

import java.awt.*;

public class Kruzitko extends Malir {
  private final int x;
  private final int y;
  private final int velikost;
  private final boolean vypln;

  public Kruzitko(Graphics platno, int x, int y, int velikost, boolean vypln) {
    super(platno);

    this.x = x;
    this.y = y;
    this.velikost = velikost;
    this.vypln = vypln;
  }
  @Override
  protected void nakresli() {
    graphics.setColor(Color.red);
    if(vypln) {
      graphics.fillOval(x, y, velikost, velikost);
    }else{
      graphics.drawOval(x, y, velikost, velikost);
    }
  }


}
