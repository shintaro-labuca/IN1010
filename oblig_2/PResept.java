public class PResept extends HvitResept {
    
    public PResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientID, int reit) {
        super(legemiddel, utskrivendeLege, pasientID, reit);
    }

    @Override
    public int prisÅBetale() {
       int pris = this.legemiddel.hentPris();
       if (pris - 108 >= 0) {
        return pris - 108; 
       }

       return 0; 
    }
}
