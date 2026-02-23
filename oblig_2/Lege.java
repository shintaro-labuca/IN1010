public class Lege {

    public final String navn;

    public Lege(String navn) {
        this.navn = navn;
    }

    public String hentNavn() {
        return this.navn;
    }

    @Override
    public String toString() {
        return "Navn: " + this.navn;
    }
}
