public class Integrasjonstest {
    public static void main(String[] args) {

        // Leger
        Lege lege1 = new Lege("Dr. Hansen");
        Spesialist spesialist1 = new Spesialist("Dr. Spesialist", "ABC123");

        //Legemidler
        Legemiddel vanlig = new Vanlig("Paracet", 29, 500.0);
        Legemiddel vanedannende = new Vanedannede("Otrivin", 57, 2.3, 3);
        Legemiddel narkotisk = new Narkotisk("Cosylan", 230, 5.0, 4);

        // Resepter
        Resept hvit = new HvitResept(vanlig, lege1, 0, 4);
        Resept blå = new BlåResept(vanedannende, lege1, 1, 5);
        Resept militær = new MilitærResept(narkotisk, spesialist1, 2);
        Resept p = new PResept(vanlig, lege1, 3, 2);

        System.out.println("Leger:");
        System.out.println(lege1);
        System.out.println(spesialist1);

        System.out.println("\nLegemidler");
        System.out.println(vanlig);
        System.out.println(vanedannende);
        System.out.println(narkotisk);

        System.out.println("\nResepter");
        System.out.println(hvit);
        System.out.println(blå);
        System.out.println(militær);
        System.out.println(p);

    
        System.out.println("\n farge + prisÅBetale");
        System.out.println("Hvit:    farge=" + hvit.farge() + ", prisÅBetale=" + hvit.prisÅBetale());
        System.out.println("Blå:     farge=" + blå.farge() + ", prisÅBetale=" + blå.prisÅBetale());
        System.out.println("Militær: farge=" + militær.farge() + ", prisÅBetale=" + militær.prisÅBetale());
        System.out.println("P:       farge=" + p.farge() + ", prisÅBetale=" + p.prisÅBetale());

        System.out.println("\nreit og bruk()");
        System.out.println("Militær start reit: " + militær.hentReit());
        System.out.println("bruk() -> " + militær.bruk() + " | reit nå: " + militær.hentReit());
        System.out.println("bruk() -> " + militær.bruk() + " | reit nå: " + militær.hentReit());
        System.out.println("bruk() -> " + militær.bruk() + " | reit nå: " + militær.hentReit());
        System.out.println("bruk() -> " + militær.bruk() + " | reit nå: " + militær.hentReit());

      
        System.out.println("\nKONTROLL: ID-er");
        System.out.println("Legemiddel-IDer: vanlig=" + vanlig.id + ", vanedannende=" + vanedannende.id + ", narkotisk=" + narkotisk.id);
        System.out.println("Resept-IDer: hvit=" + hvit.hentId() + ", blå=" + blå.hentId() + ", militær=" + militær.hentId() + ", p=" + p.hentId());

    }
}