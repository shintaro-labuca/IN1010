import java.util.TreeMap;
import java.util.Map;
import java.io.PrintWriter;

public class Frekvenstabell extends TreeMap<String, Integer> {
    @Override
    public String toString() {
        String resultat = "";

        for (Map.Entry<String, Integer> entry : this.entrySet()) {
            String nøkkel = entry.getKey();
            Integer verdi = entry.getValue();
            resultat += nøkkel + " " + verdi + "\n";
        }

        return resultat;
    }

    public static Frekvenstabell flett(Frekvenstabell f1, Frekvenstabell f2) {
        Frekvenstabell flettet = new Frekvenstabell();

        for (Map.Entry<String, Integer> entry : f1.entrySet()) {
            flettet.put(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, Integer> entry : f2.entrySet()) {
            String nøkkel = entry.getKey();
            Integer verdi = entry.getValue();

            if (flettet.containsKey(nøkkel)) { // Hvis det finnes i ordboken allerede
                flettet.put(nøkkel, flettet.get(nøkkel) + verdi);
            } else {
                flettet.put(nøkkel, verdi);
            }
        }

        return flettet;
    }

    public void skrivTilFil(String filnavn) {
        PrintWriter f = null;
        try {
            f = new PrintWriter(filnavn);
            f.print(this.toString());
        } catch (Exception e) {
            System.out.println("Kunne ikke skriv til filen.");
            System.exit(1);
        }
        f.close();
    }


}
