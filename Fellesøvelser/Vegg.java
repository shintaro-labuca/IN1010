package IN1010.Fellesøvelser;

import java.util.ArrayList;

public class Vegg {
    private int antPlasser;
    private Bilde[] bilder;
    private int antBilder = 0;

    public Vegg(int antPlasser) {
        this.antPlasser = antPlasser;
        this.bilder = new Bilde[this.antPlasser];
    }

    public boolean ledigPlass() {
        return antBilder < antPlasser;

    }

    public boolean sjekkRamme(String rammetype) {

        if (antBilder == 0 || rammetype.equals("")) {
            return true;
        }

        for (Bilde bilde : bilder) {
            if (bilde != null) {
                if (!bilde.hentRammetype().equals("")) {
                    return bilde.hentRammetype().equals(rammetype);
                }
            }
        }

        return true;
    }

    public ArrayList<Bilde> plasserBilder(ArrayList<Bilde> nyeBilder) {
        ArrayList<Bilde> gjenståendeBilder = new ArrayList<>();
        int antHengtOpp = 0;

        for (Bilde bilde : nyeBilder) {
            if (ledigPlass()) {
                bilde.hengOpp();
                bilder[antBilder] = bilde;
                antBilder++;
                antHengtOpp++;
            }
        }

        if (antHengtOpp < nyeBilder.size()) {
            for (int i = antHengtOpp; i < nyeBilder.size(); i++) {
                gjenståendeBilder.add(nyeBilder.get(i));
            }
        }

        return gjenståendeBilder;
    }
}
