package IN1010.Uke_2.oblig_1;

public class Celle {
    boolean levende;
    Celle [] naboer;
    int antNaboer;
    int antLevendeNaboer;

    public Celle() {
        levende = false;
        naboer = new Celle[8];
        antNaboer = 0;
        antLevendeNaboer = 0;
    }

    public void settDød() {
        levende = false;
    }

    public void settLevende() {
        levende = true;
    }

    public boolean erLevende() {
        return levende;
    }

    public char hentStatusTegn() {
        if (this.erLevende()) {
            return 'O';
        }
        return '.';
    }

    public void leggTilNabo(Celle nabo) {
        if (antNaboer < naboer.length) {
            naboer[antNaboer] = nabo;
            antNaboer++;
        }
    }

    public void tellLevendeNaboer() {
        antLevendeNaboer = 0;
        for (int i = 0; i < antNaboer; i++) {
            if (naboer[i].erLevende()) {
                antLevendeNaboer++;
            }
        }
    }

    public void oppdaterStatus() {
        if (this.erLevende()) {
            if (this.antLevendeNaboer < 2) {
                this.settDød();
            }
            else if (this.antLevendeNaboer > 3) {
                this.settDød();
            }
        }
        else {
            if (antLevendeNaboer == 3) {
                this.settLevende();
            }
        }
    }
}
