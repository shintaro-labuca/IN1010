import java.util.*;

public class Flyformasjon implements Iterable<Fly>{
    Fly første;

    public Flyformasjon() {

    }

    public void leggTil(Fly nyFly) {
        nyFly.neste = første;
        første = nyFly;
    }

    public boolean erMed(String id) {
        Fly peker = første;

        while (peker != null) {
            if (peker.id.equals(id)) {
                return true;
            }
            peker = peker.neste;
        }
        return false;
    }

    public Fly taUt(String id) {
        Fly peker = første;
        Fly gyldigFly = null;

        if (første == null) { // Håndterer tom liste
            return null;
        }

        if (peker.id.equals(id)) { // Håndterer hvis første er gyldig
            første = første.neste;
            return peker;
        }

        while (peker != null) {
            if (peker.neste != null) {
                if (peker.neste.id.equals(id)) {
                    gyldigFly = peker.neste;
                    peker.neste = peker.neste.neste;
                    return gyldigFly;
                }
            }
            peker = peker.neste;
        }
        return null;
    }

    class FlyIterator implements Iterator<Fly> {
        Fly peker;

        public FlyIterator() {
            peker = første;
        }

        public boolean hasNext() {
            return peker != null;
        }

        public Fly next() {
            Fly neste = peker;
            peker = peker.neste;
            return neste;
        }

    }

    public FlyIterator iterator() {
        return new FlyIterator();
    }

    public PassasjerFly[] hentPassasjerFly() {
        int antall = 0;

        for (Fly fly : this) {
            if (fly instanceof PassasjerFly) {
                antall++;
            }
        }
        PassasjerFly[] passasjerFlyListe = new PassasjerFly[antall];

        antall = 0;
        for (Fly fly : this) {
            if (fly instanceof PassasjerFly) {
                passasjerFlyListe[antall] = (PassasjerFly) fly;
                antall++;
            }
        }

        return passasjerFlyListe;
    }


    public int totalVekt() {
        int totalVekt = 0;

        if (første == null) {
            return totalVekt;
        }

        for (Fly fly : this) {
            totalVekt += fly.hentMTOW();
        }
        return totalVekt;
    }

    public int maksVekt() {
        if (første == null) {
            return 0;
        }
        return maksVekt(første);
    }

    private int maksVekt(Fly peker) { // Hjelpemetode
        if (peker.neste == null) {
            return peker.MTOW;
        }
        return Math.max(peker.MTOW, maksVekt(peker.neste));
    }

}
