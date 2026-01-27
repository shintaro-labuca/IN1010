public class BilBruk3 {
    public static void main(String[] args) {

        Bil3 nybil = new Bil3(2132, "Shintaro");
        Person eier = new Person(nybil);

        eier.utskrift();
    }
}