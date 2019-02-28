package bojovaHra;

import java.util.Random;

public class Hra {

    public static void main(String[] args) {
        final Hrdina h = new Hrdina("Bivoj", 10, 9);
        final Zloduch z1 = new Zloduch("Zombik", new Random().nextInt(4)+1);
        final Zloduch z2 = new Zloduch("Upir", 6);
        final Zloduch z3 = new Zloduch("Krystoferus", 1);
        final Zloduch z4 = new Zloduch("Trol", 8);
        final Armada armada1 = new Armada("Hrdinska Legie", h, new Hrdina("Premysl", 3, 25));
        final Armada armada2 = new Armada("Zlodusi", z1, z2, z3);

        System.out.println(h.jeNazivu());
        armada1.souboj(armada2);
        System.out.println(h.jeNazivu());
        System.out.println(z1.nazivu);
    }
}
//jalůfjasaůolofjaslůkjfůaslkjfůalsůlůkasjflůkjassoiůjfwoikfkjjsadifjeawlkůujfowikflikifůl-jkewkfloildfjaewfjlkfjoiesjk
