import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class KlargjørData {
    static int ANTALL_TRÅDER = 8;
    public static void main(String[] args) {
        String filnavn = args[0];
        File fil = new File(filnavn);
        String mappe = fil.getParent() + "/";
        Monitor ikkeSmittetMonitor = new Monitor();
        Monitor smitteMonitor = new Monitor();


        try { // Oppretter og kjører lesetråder
            Scanner s = new Scanner(new File(filnavn));
            ArrayList<Thread> tråder = new ArrayList<>();

            while (s.hasNextLine()) {
                String linje = s.nextLine();
                String [] deler = linje.split(",");
                String filsti = mappe + deler[0];
                boolean smittet = deler[1].equals("True");

                if (smittet) {
                        Lesetråd smittetLeseTråd = new Lesetråd(filsti, smitteMonitor);
                        Thread t = new Thread(smittetLeseTråd);
                        t.start();
                        tråder.add(t);
                } else {
                        Lesetråd ikkeSmittetLesetråd = new Lesetråd(filsti, ikkeSmittetMonitor);
                        Thread t = new Thread(ikkeSmittetLesetråd);
                        t.start();
                        tråder.add(t);
                } 
            }
            for (Thread t : tråder) { // Sørge for at alle trådene er ferdig
                try {
                    t.join();
                } catch (InterruptedException e) {
                    System.exit(1);
                }
            }
            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("Finner ikke fil: " + filnavn);
            System.exit(1);
        }
        
        // Flettetråder, 8 per monitor
        // resultat: en frekvenstabell per monitor; en smittet og ikke smittet
        ArrayList<Thread> flettetråder = new ArrayList<>();

        for (int i = 0; i < ANTALL_TRÅDER; i++) {
            Thread tSmittet = new Thread(new Flettetråd(smitteMonitor));
            tSmittet.start();

            Thread tIkkeSmittet = new Thread(new Flettetråd(ikkeSmittetMonitor));
            tIkkeSmittet.start();

            flettetråder.add(tSmittet);
            flettetråder.add(tIkkeSmittet);
        }
        for (Thread t : flettetråder) { // Tråder bli ferdig
            try {
                t.join();
            } catch (InterruptedException e) {
                System.exit(1);
            }
        }

        smitteMonitor.taUt().skrivTilFil("test_smittet");
        ikkeSmittetMonitor.taUt().skrivTilFil("test_ikke_smittet");
    }
}


