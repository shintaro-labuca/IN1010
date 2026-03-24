public class BlåResept extends Resept {
    
    public BlåResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
        super(legemiddel, utskrivendeLege, pasient, reit);
    }

    public String farge() {
        return "blå";
    }

    public int prisÅBetale() {
        return (int) Math.round(this.legemiddel.hentPris() * 0.25);
    }
}
