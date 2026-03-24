public abstract class Resept {
    private static int reseptIdTeller = 0;

    public final Legemiddel legemiddel;
    public final Lege utskrivendeLege;
    public final Pasient pasient;
    private int reit;
    public final int id;

    public Resept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
        this.legemiddel = legemiddel;
        this.utskrivendeLege = utskrivendeLege;
        this.pasient = pasient;
        this.reit = reit;
        this.id = reseptIdTeller++;
    }

    public int hentId() {
        return this.id;
    }

    public Legemiddel hentLegemiddel() {
        return this.legemiddel;
    }

    public Lege hentLege() {
        return this.utskrivendeLege;
    }

    public Pasient hentPasient() {
        return this.pasient;
    }

    public int hentReit() {
        return this.reit;
    }

    public boolean bruk() {
        if (this.reit > 0) {
            this.reit--;
            return true;
        }
        return false;
    }

    abstract public String farge();

    abstract public int prisÅBetale();

    @Override
    public String toString() {
        return "Legemiddel: " + this.legemiddel + " Lege: " + this.utskrivendeLege + " Pasient ID: " + this.pasient + " Antall reit: " + this.reit;
    }
}
