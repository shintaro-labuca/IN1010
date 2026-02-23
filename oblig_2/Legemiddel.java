public abstract class Legemiddel {
    private static int idTeller = 0;

    public final String navn;
    public final int id;
    private int pris;
    public final double mengdeVirkestoff;


    public Legemiddel(String navn, int pris, double mengdeVirkestoff) {
    this.navn = navn;
    this.pris = pris;
    this.mengdeVirkestoff = mengdeVirkestoff;
    this.id = idTeller++;
    }

    public int hentPris() {
        return pris;
    }

    public void settNyPris(int pris) {
        this.pris = pris;
    }

    @Override
    public String toString() {
        return "Navn: " + navn + ", ID: " + id + ", Pris: " + pris + ", Virkestoff i mg: " + mengdeVirkestoff;
    }


}


