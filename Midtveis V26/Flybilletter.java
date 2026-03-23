class Flybilletter {
public static void main(String[] args) {
        Business bil1B = new Business(1000);
        Premium bil1P = new Premium(500);
        Premium bil2P = new Premium(200,30);
        Økonomi bil1Ø = new Økonomi(100);
        Økonomi bil2Ø = new Økonomi(100,10);

        System.out.println("Pris 1: " + bil1B.pris());
        System.out.println("Pris 2: " + bil1P.pris());
        System.out.println("Pris 3: " + bil2P.pris());
        System.out.println("Pris 4: " + bil1Ø.pris());
        System.out.println("Pris 5: " + bil2Ø.pris());
        System.out.println("Lengde 1: " + bil1B.centimeter());
        System.out.println("Lengde 2: " + bil1P.centimeter());
        System.out.println("Lengde 3: " + bil1Ø.centimeter());
    }
}
interface MerBenplass {int centimeter();}

abstract class FlyBillett implements MerBenplass {
    protected int basispris;
    protected int cm = 0;
    FlyBillett(int p, int c) {basispris = p; cm = c;}
    public int pris() {return basispris+centimeter()*100;}
}
class Økonomi extends FlyBillett {
    Økonomi(int pris, int c) {super(pris,c);}
    Økonomi(int pris) {super(pris, 0);}
    @Override public int centimeter() {return cm;}
}
class Premium extends Økonomi {
    Premium(int pris) {super(pris,20);}
    Premium(int pris, int c) {super(pris,c);}
}
class Business extends Premium {
    Business(int pris) {super(pris,10);}
    @Override public int pris(){return super.pris()*4;}
}