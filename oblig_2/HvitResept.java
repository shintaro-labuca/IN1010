public class HvitResept extends Resept {
    

    public HvitResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientID, int reit) {
        super(legemiddel, utskrivendeLege, pasientID, reit);
    }

    public String farge() {
        return "hvit";
    }

    public int prisÅBetale() {
        return this.legemiddel.hentPris();
    }


}

