package auticka;

public class Brusle extends Vozidlo {
  public Brusle() {
    super(8, 25, Pohon.Manualni);
  }

  @Override
  public String vydejZvuk() {
    return "Skrip Skrip";
  }
}
