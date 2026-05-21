import java.util.*;

public class Samling<E> implements Iterable<E> {
    private Node start;

    public Samling (int n) {
        Node siste = null;

        for (int i = 0; i < n; i++) {
            Node ny = new Node();

            if (start == null) {
                start = ny;
                siste = ny;
            } else {
                siste.neste = ny;
                siste = ny;
            }
        }
    }

    private class Node {
        Node neste;
        E data;
    }

    public void settInn (E ny) {
        Node current = start;
        while (current != null){
            if (current.data == null) {
                current.data = ny;
                return;
            } else {
                current = current.neste;
            }
        }
    }

    public void fjern (E ref) {
        // Skal ikke skrives, anta at den er implementert
    }

    private class SamlingIterator implements Iterator<E> {
        Node current;

        public SamlingIterator() {
            current = start;
        }

        public boolean hasNext() {
            while (current != null && current.data == null) {
                current = current.neste;
            }
            return current != null;
        }

        public E next() {
            E data = current.data;
            current = current.neste;
            return data;
        }
    }

    public Iterator<E> iterator() {
        return new SamlingIterator();
    }

    public int antall() {
        return antall(start);
    }

    private int antall(Node current) {
        if (current == null) {
            return 0;
        }
        
        if (current != null) {
            if (current.data != null) {
                return 1 + antall(current.neste);
            }
        }
        return antall(current.neste);
    }
}
