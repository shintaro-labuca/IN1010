package IN1010.Uke_2.oblig_1;

import java.util.Scanner;

public class GameOfLife {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Hvor mange rader skal det være på spillbrettet: ");
        int rader = Integer.parseInt(in.nextLine());

        System.out.println("Hvor mange kolonner skal det være på spillbrettet: ");
        int kolonner = Integer.parseInt(in.nextLine());

        Verden verden = new Verden(rader, kolonner);
        verden.tegn();

        while (true) {
            System.out.println("Trykk enter for å fortsette. Skriv inn q og trykk enter for å avslutte.");
            String svar = in.nextLine();
            if (svar.equals("")) {
                verden.oppdatering();
                verden.tegn();
            }

            else if (svar.equalsIgnoreCase("q")) {
                break;
            }

            else {
                System.out.println("Ugyldig input.");
            }
        }
        in.close();
    }
}
