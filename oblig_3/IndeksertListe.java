class IndeksertListe <E> extends Lenkeliste<E> {

    public void leggTil (int pos, E x) {

        Node nyttElement = new Node(x);

        if (pos < 0 || pos > this.størrelse()) {
            throw new UgyldigListeindeks(pos);
        } else if (pos == 0) {
            nyttElement.neste = hode;
            hode = nyttElement;
            if (hale == null) {
                hale = hode;
            }
        } else if (pos == størrelse()) {
            hale.neste = nyttElement;
            hale = nyttElement;
        } else {
            Node peker = hode;
            for (int i = 0; i < pos - 1; i++) {
                peker = peker.neste;
            }
            nyttElement.neste = peker.neste;
            peker.neste = nyttElement;
        }
    }

    public void sett (int pos, E x) {
        if (pos < 0 || pos >= størrelse()) {
            throw new UgyldigListeindeks(pos);
        }

        Node peker = hode;
        for (int i = 0; i < pos; i++) {
            peker = peker.neste;
        }
        peker.data = x;
    }

    public E hent (int pos) {
        if (pos < 0 || pos >= størrelse()) {
            throw new UgyldigListeindeks(pos);
        }
        Node peker = hode;
        for (int i = 0; i < pos; i++) {
            peker = peker.neste;
        }
	    return peker.data;
    }

    public E fjern (int pos) {
        if (pos < 0 || pos >= størrelse()) {
            throw new UgyldigListeindeks(pos);
        }

        if (pos == 0) {
            E data = hode.data;
            hode = hode.neste;
            if (hode == null) {
                hale = null;
            }
	        return data;

        } else if (pos == størrelse() - 1) {
            Node peker = hode;
            for (int i = 0; i < pos - 1; i++) {
                peker = peker.neste;
            }
            E data = peker.neste.data;
            peker.neste = null;
            hale = peker;
            return data;
        } else {
            Node peker = hode;
            for (int i = 0; i < pos - 1; i++) {
                    peker = peker.neste;
                }
            E data = peker.neste.data;
            peker.neste = peker.neste.neste;
            return data;
        }
    }
}
