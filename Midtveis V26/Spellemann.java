class Spellemann {
    public static void main(String[] args) {

    }
}
interface KanEies {void skriv();}
class Verdi implements KanEies {
    String navn;
    Verdi(String n) {navn = n;}
    public void skriv() {System.out.println(navn);}
}
class Ku extends Verdi {Ku(String n) {super(n);}}
class Fele extends Verdi {Fele(String n) {super(n);}}
class Mann {
    KanEies min;
    Mann (KanEies start) {min = start;}
    public void skriv() {min.skriv();}
    public void byttebort(Mann andre) {
        KanEies temp = min;
        andre.min = temp;
        min = andre.min;
    }
}