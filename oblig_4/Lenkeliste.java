import java.util.Iterator;

abstract class Lenkeliste <E> implements Liste<E> {
    protected Node hode;
    protected Node hale;

    protected class Node {
	    E data;
        Node neste;

        public Node(E data) {
            this.data = data;
        }
    }

    private class Lenkelisteiterator implements Iterator<E> {
        private Node peker = hode;

        public boolean hasNext() {
            return peker != null;
        }

        public E next() {
            E data = peker.data;
            peker = peker.neste;
            return data;
        }
    }

    public Iterator<E> iterator() {
        return new Lenkelisteiterator();
    }

    @Override
    public String toString () {
        String info = "";
        for (E element : this) {
            info += element;
        }
        return info;
    }

    @Override
    public int størrelse () {
       Node peker = hode; 
       int teller = 0;
       while (peker != null) {
            peker = peker.neste;
            teller++;
       }
	    return teller;
    }

    @Override
    public void leggTil (E x) {
        Node nyttElement = new Node(x);

        if (hode == null) {
            hode = nyttElement;
            hale = nyttElement;
        }

        else {
            hale.neste = nyttElement;
            hale = nyttElement;
        }
    }

    @Override
    public E hent () {
        if (hode == null) {
            throw new UgyldigListeindeks(-1);
        }
	    return hode.data;
    }

    @Override
    public E fjern () {
        if (hode == null) {
            throw new UgyldigListeindeks(-1);
        }

        E data = hode.data;
        hode = hode.neste;
        if (hode == null) {
            hale = null;
        }
	    return data;  // ...
    }
}
