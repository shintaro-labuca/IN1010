import java.util.Iterator;
import java.util.NoSuchElementException;

public class EnkelArrayListe implements Iterable<String> {
    private String[] arr;
    private int maksStørrelse;
    private int tattPlasser = 0;

    public EnkelArrayListe(int maksStørrelse) {
        this.maksStørrelse = maksStørrelse;
        this.arr = new String[maksStørrelse];
    }

    public void leggTil(String streng) {
        if (tattPlasser >= maksStørrelse) {
            throw new IllegalStateException("Ikke plass til flere.");
        }

        arr[tattPlasser] = streng;
        tattPlasser++;
    }

    public Iterator<String> iterator() {
        return new Listeiterator();
    }

    private class Listeiterator implements Iterator<String> {
        private int pos = 0;

        public boolean hasNext() {
            if (pos < tattPlasser) {
                return true;
            }
            return false;
        }

        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return arr[pos++];
        }
    }
}
