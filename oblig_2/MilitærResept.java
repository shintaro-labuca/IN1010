public class MilitærResept extends HvitResept {

    public MilitærResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientID) {
        super(legemiddel, utskrivendeLege, pasientID, 3);
    }

    @Override
    public int prisÅBetale() {
        return 0;
    }
    
}
