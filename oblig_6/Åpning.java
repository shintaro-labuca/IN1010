public class Åpning extends HvitRute {
    public Åpning(int rad, int kol, Labyrint lab) {
        super(rad, kol, lab);
    }

    @Override
    public void finn(Rute fra) {
        labyrint.fantÅpning = true;
        teller = globalTeller++;
        System.out.println("(" + radnummer + "," + kolonnenummer + ")\n");
    }

    
}
