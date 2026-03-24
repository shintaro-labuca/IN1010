public class MilitærResept extends HvitResept {

    public MilitærResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient) {
        super(legemiddel, utskrivendeLege, pasient, 3);
    }

    @Override
    public int prisÅBetale() {
        return 0;
    }
    
}
