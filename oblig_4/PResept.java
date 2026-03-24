public class PResept extends HvitResept {
    
    public PResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
        super(legemiddel, utskrivendeLege, pasient, reit);
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
