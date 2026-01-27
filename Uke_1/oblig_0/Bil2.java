
public class Bil2 {

    private int bilnummer;
    private String eier;


    public Bil2(int bilnummer, String eier) { //Konstruktør
        this.bilnummer = bilnummer;
        this.eier = eier;
    }
    
    public void hei() {
        System.out.println("Jeg er en bil");
        System.out.println("Bilnummeret mitt er: " + bilnummer);
        System.out.println("Eieren er: " + eier);
    }

}
