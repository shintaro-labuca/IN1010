package IN1010.Uke_2.oblig_1;

public class Verden {
    int antRader;
    int antKol;
    int genNr;
    Rutenett ruteNett;

    public Verden(int antRader, int antKol) {
        this.antRader = antRader;
        this.antKol = antKol;
        this.ruteNett = new Rutenett(antRader, antKol);
        this.genNr = 0;
        this.ruteNett.fyllMedTilfeldigeCeller();
        this.ruteNett.kobleAlleCeller();
    }

    public void tegn() {
        System.out.println("Generasjonsnummer: " + this.genNr);
        ruteNett.tegnRutenett();
        System.out.println("Antall levende celler: " + this.ruteNett.antallLevende());
    }

    public void oppdatering() {
        for (int r = 0; r < antRader; r++) {
            for (int k = 0; k < antKol; k++) {
                Celle celle = this.ruteNett.hentCelle(r, k);
                if (celle == null) continue;
                celle.tellLevendeNaboer();
            }
        }

        for (int r = 0; r < antRader; r++) {
            for (int k = 0; k < antKol; k++) {
                Celle celle = this.ruteNett.hentCelle(r, k);
                if (celle == null) continue;
                celle.oppdaterStatus();
            }
        }
        genNr++;
    }

}
