import java.util.*;


public class Eksamen {
    public static void main(String[] args) {
        
    }

    public static void settInnIArray (int [] a, int ix, int v) {
        if (ix >= 0 && ix < a.length) {
            a[ix] = v;
        }
    }

    public static int hentFraArray (int [] a, int ix) {
        if (ix < 0) {
            return a[0];
        } else if (ix >= a.length) {
            return a[a.length-1];
        } else {
            return a[ix];
        }
    }
}

abstract class EnVeis {
    EnVeis neste;
}

class EnVeisBeholder<E extends EnVeis> {
    private E første, siste;
    public void settInnSist(E ny) {
        if (første == null) {første = ny; siste = ny;}
        else {siste.neste = ny; siste = ny;}
    }
    public E taUtFørst() {
        if (første == null) {return null;}
        E ut = første;
        if (første == siste) {første = null; siste = null;}
        else {første = (E) første.neste;}
        return ut;
    }
}

class StrengInput {
    public static List<String> hent() {
        Scanner in = new Scanner(System.in);
        List<String> strengListe = new LinkedList<String>();
        String brukerStreng = "IkkeTom";
        while (!brukerStreng.equals("")) {
            brukerStreng = in.nextLine();
            strengListe.add(brukerStreng);
        }
        in.close();
        return strengListe;
    }
}


