package bojovaHra;

public abstract class Bojovnik {
    String jmeno;
    int sila;
    public Bojovnik (String jmeno, int sila){
    this.jmeno = jmeno;
    this.sila = sila;
    }
    public void prohrat() {

    }

    public abstract boolean jeNazivu();
}
