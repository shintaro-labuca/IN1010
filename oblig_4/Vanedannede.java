public class Vanedannede extends Legemiddel {

    public final int styrke;

    public Vanedannede(String navn, int pris, double mengdeVirkestoff, int styrke) {
        super(navn, pris, mengdeVirkestoff);
        this.styrke = styrke;
    }
}
