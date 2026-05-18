import java.util.*;

public class Innlevering6 {
    public static void main(String[] args) {
        String filnavn = args[0];
        Labyrint labyrint = new Labyrint(filnavn);

        // Kommandoløkke
        System.out.println("Slik ser labyrinten ut: \n \n" + labyrint);

        Scanner s = new Scanner(System.in);
        System.out.println("Skriv startkoordinatene: <rad> <kolonne> (-1 for å avslutte)");
        String linje = s.nextLine();

        while (!linje.equals("-1")) {
            try {
                String[] deler = linje.split(" ");
                int rad = Integer.parseInt(deler[0]);
                int kol = Integer.parseInt(deler[1]);
                labyrint.finnUtveiFra(rad, kol);
            } catch (Exception e) {
                System.out.println("Ugyldig input, prøv igjen.\n");
            }

            System.out.println("Her er labyrinten slik du gikk gjennom den: \n \n" + labyrint);
            System.out.println("Skriv inn nye koordinater. (-1 for å avslutte)");
            linje = s.nextLine();
        }
        System.out.println("Program avsluttet.");
        s.close();
    }
}


