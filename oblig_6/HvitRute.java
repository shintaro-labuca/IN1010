public class HvitRute extends Rute {
    protected int teller;

    public HvitRute(int rad, int kol, Labyrint lab) {
        super(rad, kol, lab);
    }

    @Override
    public String toString() {
        if (teller == 0) {return ".";} else {return "" + teller;}
    }

    @Override
    public void finn (Rute fra) {
        Rute[] naboer = {nord, syd, vest, øst};
        teller = globalTeller++;
        for (Rute nabo : naboer) {
            if (nabo != null && nabo != fra) {nabo.finn(this);}
        }
        
    }
}
