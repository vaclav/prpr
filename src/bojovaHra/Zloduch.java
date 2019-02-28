package bojovaHra;

public class Zloduch extends Bojovnik {

    boolean nazivu = true;

    public Zloduch(String jmeno, int sila) {
        this.jmeno = jmeno;
        this.sila = sila;
    }

    @Override
    public void prohrat() {
        this.nazivu = false;
    }

    @Override
    public boolean jeNazivu() {
        return nazivu;
    }
}
