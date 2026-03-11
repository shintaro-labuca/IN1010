class Prioritetskø <E extends Comparable<E>> extends Lenkeliste<E> {

    @Override
    public void leggTil(E x) {
        Node nyttElement = new Node(x);
        Node peker = hode;

        if (hode == null) {
            hode = nyttElement;
            hale = nyttElement;

        } else if (nyttElement.data.compareTo(hode.data) < 0) {
            nyttElement.neste = hode;
            hode = nyttElement;

        } else if (nyttElement.data.compareTo(hale.data) > 0) {
            hale.neste = nyttElement;
            hale = nyttElement;

        } else {
            while (nyttElement.data.compareTo(peker.neste.data) > 0) {
                peker = peker.neste;
            }
            nyttElement.neste = peker.neste;
            peker.neste = nyttElement;
        }
    }
}
