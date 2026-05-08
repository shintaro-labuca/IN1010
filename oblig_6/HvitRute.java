public class HvitRute extends Rute {
    public HvitRute(int rad, int kol, Labyrint lab) {
        super(rad, kol, lab);
    }

    @Override
    public String toString() {
        return ".";
    }

    @Override
    public void finn (Rute fra) {
        Rute[] naboer = {nord, syd, vest, øst};
        for (Rute nabo : naboer) {
            if (nabo != null && nabo != fra) {nabo.finn(this);}
        }
    }
}
