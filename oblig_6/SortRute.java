public class SortRute extends Rute {
    public SortRute(int rad, int kol, Labyrint lab) {
        super(rad, kol, lab);
    }

    @Override
    public String toString() {
        return "#";
    }

    @Override
    public void finn(Rute fra) {
        // Gjør ingenting, siden det er sort rute
    }
}
