public class Spesialist extends Lege implements Godkjenningsfritak {
    
    private String kontrollkode;

    public Spesialist(String navn, String kontrollkode) {
        super(navn);
        this.kontrollkode = kontrollkode;
    }

    public String hentKontrollkode() {
        return this.kontrollkode;
    }

     @Override
    public String toString() {
        return "Navn: " + this.hentNavn() + " Kontrollkode: " + this.hentKontrollkode();
    }
}
