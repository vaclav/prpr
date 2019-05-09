package auticka;

import java.awt.*;

public class Tank extends Vozidlo {

    Color barva;

    public Tank(Color barva) {
        super(10, 50, Pohon.Benzin);
        this.barva = barva;
    }

    @Override
    public String vydejZvuk() {
        return "Vrrr, bum, bum, vrrr";
    }

    @Override
    public void nakresliSe(Graphics platno, int x, int y) {
        platno.setColor(Color.black);
        int prvniKoloX = x;
        int prvniKoloY = y;
        int zadniKoloX = x + 80;
        int zadniKoloY = y;
        platno.drawOval(prvniKoloX,zadniKoloY,20,20);
        platno.drawOval(prvniKoloX + 20, prvniKoloY, 20,20);
        platno.drawOval(prvniKoloX + 40, prvniKoloY, 20,20);
        platno.drawOval(prvniKoloX + 60, prvniKoloY, 20,20);
        platno.drawOval(zadniKoloX, prvniKoloY, 20,20);
        platno.drawLine(prvniKoloX + 10, prvniKoloY, prvniKoloX + 20,prvniKoloY - 20);
        platno.drawLine(zadniKoloX + 10, zadniKoloY, zadniKoloX, zadniKoloY - 20);
        platno.drawLine(prvniKoloX + 20, prvniKoloY - 20, zadniKoloX, zadniKoloY - 20);
        platno.drawLine(prvniKoloX + 10, prvniKoloY,zadniKoloX + 10, prvniKoloY);
        platno.drawLine(prvniKoloX + 10, prvniKoloY + 20,zadniKoloX + 10, prvniKoloY + 20);
        platno.drawRect(prvniKoloX + 30, prvniKoloY - 35, 40, 15);
        platno.drawRect(prvniKoloX - 30, prvniKoloY - 30, 60,5);
    }
}









