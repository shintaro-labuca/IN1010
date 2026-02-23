public class BlåResept extends Resept {
    
    public BlåResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientID, int reit) {
        super(legemiddel, utskrivendeLege, pasientID, reit);
    }

    public String farge() {
        return "blå";
    }

    public int prisÅBetale() {
        return (int) Math.round(this.legemiddel.hentPris() * 0.25);
    }
}
