package auticko;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Hra extends JFrame {
  private final List<Postava> postavy = new ArrayList<Postava>();

  private final JPanel plocha = new JPanel() {
    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      for(Postava postava : postavy) {
        postava.nakresliSe(g);
      }
    }
  };

  private void init() {
    getRootPane().getContentPane().add(plocha);
    plocha.setBackground(Color.white);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setVisible(true);
    this.pack();
    this.setFocusable(true);
    this.setFocusTraversalKeysEnabled(false);
  }

  public static void main(String[] args) {
    final Hra hra = new Hra();
    hra.setPreferredSize(new Dimension(1024, 870));
    hra.init();
    final Auto a1 = new Auto(50, 20);
    hra.postavy.add(a1);
    final Ovladac o1 = new Ovladac(a1, hra);
    hra.addKeyListener(o1);
    hra.repaint();
  }
}
