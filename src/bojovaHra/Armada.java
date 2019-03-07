package bojovaHra;

public class Armada {
    String jmeno;
    Bojovnik[] bojovnici;

    public Armada(String jmeno, Bojovnik... bojovnici) {
        this.jmeno = jmeno;
        this.bojovnici = bojovnici;
    }

    public int sila() {
        return bojovnici.length;
    }

    public void prohrat() {
        for (Bojovnik bojovnik : bojovnici) {
            bojovnik.prohrat();
        }
    }

    public void souboj(Armada tiDruzi) {
        if (this.sila() > tiDruzi.sila()) {
            tiDruzi.prohrat();
        } else {
            this.prohrat();
        }
    }
}
