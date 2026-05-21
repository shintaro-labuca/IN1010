public class Kelner extends Ansatt{
    Samling<Bord> bordBetjent;

    public Kelner(String navn) {
        super(navn);
        bordBetjent = new Samling<>(10);
    }

    public int hentAntallServerer() {
        int antallServerer = 0;

        for (Bord bord : bordBetjent) {
            if (bord.gjestegruppe != null) {
                antallServerer += bord.gjestegruppe.gjester.antall();
            }
        }
        return antallServerer;
    }
}
