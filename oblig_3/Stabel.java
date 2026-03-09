class Stabel <E> extends Lenkeliste<E> {
    
    @Override
    public void leggTil(E x) {
        Node nyttElement = new Node(x);

        if (hode == null) {
            hode = nyttElement;
            hale = nyttElement;
        }

        else {
            nyttElement.neste = hode;
            hode = nyttElement;
        }
    }
}
