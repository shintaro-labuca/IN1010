public abstract class Rute {
    protected int radnummer;
    protected int kolonnenummer;
    protected Labyrint labyrint;
    protected Rute nord, syd, vest, øst;
    static int globalTeller;

    public Rute(int rad, int kol, Labyrint lab) {
        radnummer = rad;
        kolonnenummer = kol;
        labyrint = lab;
    }

    public void finn (Rute fra) {}
}
