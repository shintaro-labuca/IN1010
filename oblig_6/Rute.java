public abstract class Rute {
    private int radnummer;
    private int kolonnenummer;
    private Labyrint labyrint;
    protected Rute nord, syd, vest, øst;

    public Rute(int rad, int kol, Labyrint lab) {
        radnummer = rad;
        kolonnenummer = kol;
        labyrint = lab;
    }
}
