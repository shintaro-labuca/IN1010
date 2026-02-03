package IN1010.Fellesøvelser;

import java.util.ArrayList;

public class Bilde {
    private String rammetype;
    private ArrayList<Person> personer;
    private boolean opphengt = false;


    public Bilde(String rammetype, ArrayList<Person> personer) {
        this.rammetype = rammetype;
        this.personer = personer;

    }

    public String hentRammetype() {
        return this.rammetype;
    }

    public boolean erMed(String navn) {
        for (Person person : personer) {
            if (person.hentNavn().equals(navn)) {
                return true;
            }
        } 
    return false;
    }

    public boolean opphengt() {
        return this.opphengt;
    }

    public void hengOpp() {
        this.opphengt = true;
    }


}
