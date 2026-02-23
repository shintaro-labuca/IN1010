public class TestResepter {
    public static void main(String[] args) {
       Legemiddel narkLegemiddel = new Narkotisk("Cosylan", 23, 2.2, 4);
       Legemiddel vaneLegemiddel = new Vanedannede("Otrivin", 57, 2.3, 3);
       Legemiddel vanligLegemiddel = new Vanlig("Paracet", 29, 0);

       Lege lege = new Lege("navn");

       HvitResept hvitResept = new HvitResept(vanligLegemiddel, lege, 0, 4);
       BlåResept blåResept = new BlåResept(vaneLegemiddel, lege, 1, 5);
       MilitærResept militærResept = new MilitærResept(narkLegemiddel, lege, 2);
       PResept pResept = new PResept(vanligLegemiddel, lege, 3, 2);

       // Tester ulike egenskaper til reseptene
       System.out.println(militærResept.hentReit());
       militærResept.bruk();
       System.out.println(militærResept.hentReit());

       // Tester pris
       System.out.println(blåResept.hentLegemiddel().hentPris());
       System.out.println(blåResept.prisÅBetale());
       
       System.out.println(pResept.hentLegemiddel().hentPris());
       System.out.println(pResept.prisÅBetale());


       // Tester ID
       System.out.println(hvitResept.id);
       System.out.println(blåResept.id);
       System.out.println(pResept.id);
       System.out.println(militærResept.id);

       // Tester utskrift
       System.out.println(blåResept);
       System.out.println(pResept);
    }
}
