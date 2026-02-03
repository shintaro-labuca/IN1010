package IN1010.Fellesøvelser;

public class Person {
    private String navn;
    private String relasjon;

    public Person(String navn, String relasjon) {
        this.navn = navn;
        this.relasjon = relasjon;
    }

    public String hentNavn() {
        return this.navn;
    }

    public void relasjon() {
        System.out.println(this.relasjon);
    }
}
