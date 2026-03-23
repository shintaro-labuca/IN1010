class Bileiere {
    public static void main(String[] a) {
        Bil bentley = new Bil("EK34561");
        Bil toyota  = new Bil("EB65432");
        Bil subaru  = new Bil("EL66654");
        Bil audi    = new Bil("DL23145");

        Bileier ole   = new Bileier("Ole");
        Bileier per   = new Bileier("Per");
        Bileier anne  = new Bileier("Anne");
        Bileier linda = new Bileier("Linda");
        Bileier trine = new Bileier("Trine");

        ole.leggTilB(bentley);
        per.leggTilB(toyota);
        anne.leggTilB(subaru);
        linda.leggTilB(audi);
        trine.leggTilB(audi);

        ole.b(anne);
        linda.b(per);
        trine.b(linda);

        // Hva blir skrevet ut her:
        ole.skriv();
        per.skriv();
        anne.skriv();
        linda.skriv();
        trine.skriv();
    }
}

class Bil {
    String regNr;
    Bil(String n) { regNr = n; }
}

class Bileier {
    Bil minB; String navn;
    Bileier(String n) { navn = n; }

    public void leggTilB(Bil b) {
        minB = b; 
        }

    public void b(Bileier andre) {
        Bil taVare = andre.minB;
        andre.minB = minB;
        minB = taVare;
    }

    public void skriv() {
        System.out.println(navn + " eier " + minB.regNr);
    }
}

// Ole eier EL6665
// Per eier DL23145
// Anne eier EK34561
// Linda eier EB65432
// Trine eier EB65432
