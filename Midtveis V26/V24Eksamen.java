import java.util.Scanner;
public class V24Eksamen {
   
}

// Oppgave 1
class Pakke {
    int vekt;
    Pakke (int v) {vekt = v;}
}

class LagPakke {
    public static void main(String[] args) {
        Pakke min, din;
        min = new Pakke(5);
        din = min;
        int vekten = din.vekt;
        System.out.println(vekten);
    }
}
// Oppgave 1

// Oppgave 3
class MinstAv5 {
    public static void main(String[] args) {
        Scanner tastatur = new Scanner(System.in);
        int min;
        for (int i = 1; i<=5; i++) {
            int v = tastatur.nextInt();
            if (i == 1 ||v < min) {
                min = v;
            }
        }
        System.out.println(min);
    }
}
// Oppgave 3

// Oppgave 8
class Liste<T> {
    class Node {
        Node neste;
        T data;

        void skrivRekursivt () {
            if (start != null) {
                System.out.println(neste);
            }
            System.out.println(data.toString());
        }
    }
    Node start = null;

    void skrivBaklengs () {
        if (this != null) {
            start.skrivRekursivt();
        }
    }
}

// Oppgave 8