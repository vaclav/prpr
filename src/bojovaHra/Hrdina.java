package bojovaHra;

public class Hrdina extends Bojovnik {
    int zivoty;

    public Hrdina(String jmeno, int sila, int zivoty) {
        this.jmeno = jmeno;
        this.sila = sila;
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

    public void souboj(Zloduch zlo) {
        if(this.sila > zlo.sila) {
            zlo.nazivu = false;
        } else {
            this.zivoty -= zlo.sila;
        }
    }
}
