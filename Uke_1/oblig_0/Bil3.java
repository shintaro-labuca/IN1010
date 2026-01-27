
public class Bil3 {

    private int bilnummer;
    private String eier;

    public Bil3(int bilnummer, String eier) { //Konstruktør
        this.bilnummer = bilnummer;
        this.eier = eier;
    }
    
    public void hei() {
        System.out.println("Jeg er en bil");
        System.out.println("Bilnummeret mitt er: " + bilnummer);
        System.out.println("Eieren er: " + eier);
    }

    public int hentNummer(){
        return bilnummer;
    }

}
