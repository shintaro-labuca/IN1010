package IN1010.Fellesøvelser;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class Bildeplassering {
    private ArrayList<Person> personer = new ArrayList<>();
    private ArrayList<Bilde> bilder = new ArrayList<>();
    private ArrayList<Vegg> vegger = new ArrayList<>();

    public void lesPersonFraFil(String filnavn) {
        try {
            Scanner sc = new Scanner(new File(filnavn));
            while (sc.hasNextLine()) {
                String[] linje = sc.nextLine().split(";");
                Person nyPerson = new Person(linje[0], linje[1]);
                personer.add(nyPerson);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            
        }
    }
}
