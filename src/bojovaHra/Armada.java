package bojovaHra;

public class Armada {
    String jmeno;
    Bojovnik[] bojovnici;

    public Armada(String jmeno, Bojovnik... bojovnici) {
        this.jmeno = jmeno;
        this.bojovnici = bojovnici;
    }

    public void souboj(Armada tiDruzi) {
        if (this.sila() > tiDruzi.sila()) {
            tiDruzi.prohrat();
        } else {
            this.prohrat();
        }
    }

    public int sila() {
        return bojovnici.length;
    }

    public void prohrat() {
        for (int i = 0; i < bojovnici.length; i++) {
            Bojovnik bojovnik = bojovnici[i];
            bojovnik.prohrat();
        }

    }
}
