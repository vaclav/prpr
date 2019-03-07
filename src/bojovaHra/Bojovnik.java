package bojovaHra;

public abstract class Bojovnik {
    String jmeno;
    int sila;

    public Bojovnik(String jmeno, int sila){
    this.jmeno = jmeno;
    this.sila = sila;
    }

    public void prohrat() { }

    public abstract boolean jeNazivu();

    public void souboj(Bojovnik protivnik) {
        if(this.sila > protivnik.sila) {
            protivnik.prohrat();
        } else {
            this.prohrat();
        }
    }
}
