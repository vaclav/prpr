package bojovaHra;

public class Hrdina extends Bojovnik {
    int zivoty;

    public Hrdina(String jmeno, int sila, int zivoty) {
        super(jmeno, sila);
        this.zivoty = zivoty;
    }

    @Override
    public void prohrat() {
        this.zivoty = this.zivoty - 1;
    }

    @Override
    public boolean jeNazivu() {
        return zivoty > 0;
    }
}
