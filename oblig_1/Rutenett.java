package IN1010.Uke_2.oblig_1;

public class Rutenett {
    int antRader;
    int antKolonner;
    Celle [][] rutene;


    public Rutenett(int antRader, int antKolonner) {
        this.antRader = antRader;
        this.antKolonner = antKolonner;
        rutene = new Celle[antRader][antKolonner];
    }

    public void lagCelle(int rad, int kol) {
        Celle celle = new Celle();
        if (Math.random() <= 0.3333) {
            celle.settLevende();
        }
        rutene[rad][kol] = celle;
    }

    public void fyllMedTilfeldigeCeller() {
        for (int r = 0; r < antRader; r++) {
            for (int k = 0; k < antKolonner; k++) {
                this.lagCelle(r, k);
            }
        }
    }

    public Celle hentCelle(int rad, int kolonne) {
    if (rad < 0 || rad >= antRader) { 
        return null;
        }
    if (kolonne < 0 || kolonne >= antKolonner) {
        return null;
    }
        return rutene[rad][kolonne];
    }

    public void tegnRutenett() {
        for (int r = 0; r < antRader; r++) {
            for (int k = 0; k < antKolonner; k++) {
                System.out.print(this.rutene[r][k].hentStatusTegn());
            }
            System.out.println();
        }
    }

    public void settNaboer(int rad, int kolonne) {
        Celle celle = this.rutene[rad][kolonne];

        for (int naboRad = rad - 1; naboRad <= rad + 1; naboRad++) {
            for (int naboKol = kolonne - 1; naboKol <= kolonne + 1; naboKol++) {

                if (naboRad == rad && naboKol == kolonne) continue;
                
                Celle nabo = this.hentCelle(naboRad, naboKol);
                if (nabo == null) continue;

                celle.leggTilNabo(nabo);
            }            
        }
    }

    public void kobleAlleCeller() {
        for (int r = 0; r < antRader; r++) {
            for (int k = 0; k < antKolonner; k++) {
                this.settNaboer(r, k);
            }
        }
    }     

    public int antallLevende() {
        int antallLevende = 0;

        for (int r = 0; r < antRader; r++) {
            for (int k = 0; k < antKolonner; k++) {
                if (rutene[r][k].erLevende()) antallLevende++;
            }
        }
        return antallLevende;
    }
}

