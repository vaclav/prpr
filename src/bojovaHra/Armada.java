package bojovaHra;

public class Armada {
    String jmeno;
    Bojovnik[] bojovnici;

    public Armada(String jmeno, Bojovnik... bojovnici) {
        this.jmeno = jmeno;
        this.bojovnici = bojovnici;
    }

    public int sila() {
        int celkovasila = 0;
        for (Bojovnik bojovnik : bojovnici) {
            celkovasila += bojovnik.sila;

            }

        return celkovasila;
    }

    public void prohrat() {
        for (Bojovnik bojovnik : bojovnici) {
            bojovnik.prohrat();
        }
    }

    public void souboj(Armada tiDruzi) {
        if (this.sila() > tiDruzi.sila()*3) {
            tiDruzi.prohrat();
        } else {
            this.prohrat();
        }
    }
}
