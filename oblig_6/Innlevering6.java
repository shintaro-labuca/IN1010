import java.util.*;

public class Innlevering6 {
    public static void main(String[] args) {
        String filnavn = args[0];
        Labyrint labyrint = new Labyrint(filnavn);

        // Kommandoløkke
        System.out.println("Slik ser labyrinten ut: \n \n" + labyrint);

        Scanner s = new Scanner(System.in);
        String linje = s.nextLine();

        System.out.println("Skriv startkoordinatene: <rad> <kolonne> (-1 for å avslutte)");
        while (!linje.equals("-1")) {
            try {
                String[] deler = linje.split(" ");
                int rad = Integer.parseInt(deler[0]);
                int kol = Integer.parseInt(deler[1]);
                labyrint.finnUtveiFra(rad, kol);
            } catch (Exception e) {
                System.out.println("Ugyldig input, prøv igjen.");
            }
            s.nextLine();
        }
        s.close();
    }
}


