import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Subsekvensregister {
    private ArrayList<Frekvenstabell> register;
    private static final int SUBSEKVENSLENGDE = 3;

    public Subsekvensregister() {
    this.register = new ArrayList<>();
    }

    public void settInn (Frekvenstabell f) {
        register.add(f);
    }

    public Frekvenstabell taUt() {
        Frekvenstabell tabell = register.get(register.size() - 1);
        register.remove(register.size() - 1);

        return tabell;
    }

    public int antall() {
        return register.size();
    }

    public static Frekvenstabell les(String filnavn) throws FileNotFoundException {
        Frekvenstabell f = new Frekvenstabell();

        Scanner s = new Scanner(new File(filnavn));
        while (s.hasNextLine()) {
            String linje = s.nextLine();
            for (int i = 0; i <= linje.length() - SUBSEKVENSLENGDE; i++) { // Flytter 1 til høyre for hver iterasjon, frem til lengden av linjen - 3
                String subsekvens = linje.substring(i, i + SUBSEKVENSLENGDE); // Subsekvens av lengde 3
                f.put(subsekvens, 1);
            }
        }
        s.close();
        return f;
    }

}


