public class Pasient {
    private static int pasientIDTeller = 0;
    private String navn;
    private String fødselsnummer;
    private IndeksertListe<Resept> resepter;
    private int pasientID;

    public Pasient(String navn, String fødselsnummer) {
        this.navn = navn;
        this.fødselsnummer = fødselsnummer;
        pasientID = pasientIDTeller++;
        resepter = new IndeksertListe<Resept>();

    }

    public void leggTilResept(Resept resept) {
        resepter.leggTil(resept);
    }

    public String hentNavn() {
        return this.navn;
    }

    public String hentFødselsnummer() {
        return this.fødselsnummer;
    }

    public int hentPasientID() {
        return this.pasientID;
    }

}
