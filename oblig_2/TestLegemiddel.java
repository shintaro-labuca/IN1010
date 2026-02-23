public class TestLegemiddel {
    public static void main(String[] args) {
       Legemiddel narkLegemiddel = new Narkotisk("Cosylan", 23, 2.2, 4);
       Legemiddel vaneLegemiddel = new Vanedannede("Otrivin", 57, 2.3, 3);
       Legemiddel vanligLegemiddel = new Vanlig("Paracet", 29, 0);
       Legemiddel vanligLegemiddel2 = new Vanlig("test", 23, 0);
        
       // Tester ulike ID-er
       System.out.println(testLegemiddelId(vanligLegemiddel, 2)); 
       System.out.println(testLegemiddelId(narkLegemiddel, 0));
       System.out.println(testLegemiddelId(vanligLegemiddel2, 3));

       // Tester ID ved bytte av peker til referanse 
       narkLegemiddel = vaneLegemiddel; 
       System.out.println(testLegemiddelId(narkLegemiddel, 1));

       int pris = vaneLegemiddel.hentPris();
       System.out.println(pris);

       System.out.println(vaneLegemiddel);
       System.out.println(vanligLegemiddel);
    }

    private static boolean testLegemiddelId(Legemiddel legemiddel, int forventetLegemiddelId) {
        return legemiddel.id == forventetLegemiddelId;
    }


}
