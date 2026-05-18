import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Labyrint {
    private int antRader;
    private int antKolonner;
    private Rute[][] ruter;
    protected boolean fantÅpning;

    public Labyrint(String filnavn) { // Leser rutenett, og lager Rute-objekter basert på tegnet
        try {
        Scanner s = new Scanner(new File(filnavn));
            antRader = s.nextInt();
            antKolonner = s.nextInt();
            ruter = new Rute[antRader][antKolonner];
            s.nextLine();
            for (int rad = 0; rad < antRader; rad++) {
                String linje = s.nextLine();
                for (int kol = 0; kol < antKolonner; kol++) {
                    char tegn = linje.charAt(kol);
                    if (tegn == '#') {
                            ruter[rad][kol] = new SortRute(rad, kol, this);
                    } else if (rad == 0 || rad == antRader - 1 || kol == 0 || kol == antKolonner - 1) { // Hvis kant, så åpning
                            ruter[rad][kol] = new Åpning(rad, kol, this);
                    } else {
                            ruter[rad][kol] = new HvitRute(rad, kol, this);
                        }
                    }
                }
        s.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fant ikke filen.");
            System.exit(1);
        }

        for (int rad = 0; rad < antRader; rad++) { // Setter naboer, setter nord,syd,øst,vest til å peke på naboer
            for (int kol = 0; kol < antKolonner; kol++) {
                if (rad > 0) {ruter[rad][kol].nord = ruter[rad - 1][kol];}
                if (rad < antRader - 1) {ruter[rad][kol].syd = ruter[rad + 1][kol];}
                if (kol > 0) {ruter[rad][kol].vest = ruter[rad][kol - 1];}
                if (kol < antKolonner - 1) {ruter[rad][kol].øst = ruter[rad][kol + 1];}
            }
        }
    }

    @Override
    public String toString() {
        String labyrint = "";
        for (Rute[] rad : ruter) {
            for (Rute rute : rad) {
                labyrint += rute.toString() + " ";
            }
        labyrint += "\n";
        }
        return labyrint;
    }

    public void finnUtveiFra(int rad, int kol) {
        fantÅpning = false;
        Rute.globalTeller = 1;

        for (Rute[] rader : ruter) {
            for (Rute rute : rader) {
                if (rute instanceof HvitRute) {((HvitRute)rute).teller = 0;} // Nullstiller teller for hver gang man skriver inn koordinat
            }
        }

        if (ruter[rad][kol] instanceof SortRute) {
            System.out.println("Du kan ikke starte på en sort rute.");
            return;
        }

        System.out.println("Åpninger: ");
        ruter[rad][kol].finn(null);

        if (!fantÅpning) {
            System.out.println("Ingen åpninger funnet fra startkoordinaten.");
        }

    }
}
