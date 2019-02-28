package bojovaHra;

public class Zloduch extends Bojovnik {

    boolean nazivu = true;
    public Zloduch(String jmeno, int sila) {
        super (jmeno, sila);
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
