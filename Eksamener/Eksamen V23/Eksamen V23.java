interface Motordrevet {
    boolean fossilt();
    int trekkraft();
}

abstract class Skinnegående {
    String id;
    int sporvidde;
    Skinnegående neste;
    Skinnegående forrige;

    public Skinnegående(String id, int sporvidde) {
        this.id = id;
        this.sporvidde = sporvidde;
    }

    public String hentId() {
        return id;
    }

    public int hentSporvidde() {
        return sporvidde;
    }

    public void sjekkSporviddeR() throws FeilSporvidde {
        if (neste == null) {
            return;
        }

        if (sporvidde != neste.sporvidde) {
            throw new FeilSporvidde("Feil sporvidde.")
        }
        neste.sjekkSporviddeR();
    }
}

class Lokomotiv extends Skinnegående implements Motordrevet {
    boolean erFossilt;
    int trekkraft;

    public Lokomotiv(String id, int sporvidde, boolean erFossilt, int trekkraft) {
        super(id, sporvidde);
        this.erFossilt = erFossilt;
        this.trekkraft = trekkraft;
    }

    public boolean fossilt() {
        return erFossilt;
    }

    public int trekkraft() {
        return trekkraft;
    }
}

abstract class Vogn extends Skinnegående {
    int vognLengde;

    public Vogn(String id, int sporvidde, int vognLengde) {
        super(id, sporvidde);
        this.vognLengde = vognLengde;
    }
}

class Godsvogn extends Vogn {
    final double maksLastevekt;

    public Godsvogn(String id, int sporvidde, int vognLengde, double maksLastevekt) {
        super(id, sporvidde, vognLengde);
        this.maksLastevekt = maksLastevekt;
    }
}

class Passasjervogn extends Vogn {
    final int maksPassasjerer;

    public Passasjervogn(String id, int sporvidde, int vognLengde, int maksPassasjerer) {
        super(id, sporvidde, vognLengde);
        this.maksPassasjerer = maksPassasjerer;
    }
}









class Tog implements Iterable<Skinnegående> {
    Skinnegående første, siste;

    public Tog() {

    }

    public void leggTil(Skinnegående ny) {
        if (første == null && siste == null) {
            første = ny;
            siste = ny;
        } else {
            siste.neste = ny;
            ny.forrige = siste;
            siste = siste.neste;
        }
    }

    public Skinnegående taUt(Skinnegående skalFjernes) {
        Skinnegående peker = første;
        Skinnegående fjernet = null;

        if (første == skalFjernes) {
            fjernet = første;
            fjernet.neste = null;
            fjernet.forrige = null;
            if (første == siste) {
                siste = null;
            }
            første = første.neste;
            return fjernet;
        }

        if (siste == skalFjernes) {
            fjernet = siste;
            fjernet.forrige = null;
            siste = siste.forrige;
            return fjernet;
        }

        while (peker != skalFjernes) {
            peker = peker.neste;
            if (peker == skalFjernes) {
                fjernet = peker;
                peker.forrige.neste = peker.neste;
                peker.neste.forrige = peker.forrige;
                fjernet.neste = null;
                fjernet.forrige = null;
            }
        }

        return fjernet;
    }

    private Skinnegående finn(String id) {
        Skinnegående peker = første;
        
        while (peker != null) {
            if (peker.hentId().equals(id)) {
                return peker;
            }
            peker = peker.neste;
        }
        return null;
    }

    public Skinnegående finnOgTaUt(String id) {
        Skinnegående fjerne = this.finn(id);

        if (fjerne == null) {return null;}

        return taUt(fjerne);
    }

    public void leggTilForan(Skinnegående erIListen, Skinnegående ny) {
        ny.neste = erIListen;
        ny.forrige = erIListen.forrige;

        if (erIListen == første) {
            første = ny;
        } else {
            erIListen.forrige.neste = ny;
        }
    }

    @Override
    public SkinnegåendeIterator iterator() {
        return new SkinnegåendeIterator();
    }

    class SkinnegåendeIterator implements Iterator<Skinnegående> {
        Skinnegående current;

        public SkinnegåendeIterator() {
            current = første;
        }

        public boolean hasNext() {
            return current != null;
        }

        public Skinnegående next() {
            Skinnegående retur = current;
            current = current.neste;
            return retur;
        }
    }

    public Passasjervogn[] hentPassasjervogner() {

        int antPassasjerVogn = 0;
        for (Vogn vogn : this) {
            if (vogn instanceof Passasjervogn) {
                antPassasjerVogn++;
            }
        }

        Passasjervogn[] res = new Passasjervogn[antPassasjerVogn];

        int i = 0;
        for (Vogn vogn : this) {
            if (vogn instanceof Passasjervogn) {
                res[i] = (Passasjervogn) vogn;
                i++;
            }
        }
        return res;
    }

    public void sjekkSporvidde() throws FeilSporvidde {
        if (første == null) {
            return;
        }

        for (t : this) {
            if (første.hentSporvidde() != t.hentSporvidde()) {
                throw new FeilSporvidde("Feil sporvidde.")
            }
        }
    }

    public void leggTilSikker(Skinnegående ny) throws FeilSporvidde {
        if (første != null) {
            sjekkSporvidde();
            if (ny.hentSporvidde != første.hentSporvidde()) {
            throw new FeilSporvidde("Feil sporvidde.")
            }
        } 
        this.leggTil(ny);
    }
}

class FeilSporvidde extends Exception {
        public FeilSporvidde(String melding) {
            super(melding);
        }
    }



class Monitor {
    ReentrantLock lås = new ReentrantLock();
    Condition vent = lås.newCondition();
    ArrayList<Skinnegående> skinnegåendeMatch = new ArrayList<>();
    int antLeterTråd;

    public Monitor(int antLeterTråd) {
        this.antLeterTråd = antLeterTråd;
    }

    public void leggTil(Skinnegående match) {
        lås.lock().
        try {
            skinnegåendeMatch.add(s);
        } finally {
            lås.unlock();
        }
    }

    public void ferdigLeting() {
        vent.signalAll()
    }

    public String hentNeste() {
        lås.lock()
        try {
            while (skinnegåendeMatch.isEmpty()) {
                vent.await()
            }
            Skinnegående s = skinnegåendeMatch.remove(0);
            return s.hentId();
        } catch (InterruptedException e){
            return null;
        } finally {
            lås.unlock();
        }
    }
}

class Leter implements Runnable { // produsent
    Monitor monitor;
    Tog tog;
    String idBegynnelse;

    public Leter(Monitor monitor, Tog tog, String idBegynnelse) {
        this.monitor = monitor;
        this.tog = tog;
        this.idBegynnelse = idBegynnelse;
    }

    public void run() {
        for (Skinnegående s : tog) {
            if (s.hentId().startsWith(idBegynnelse)) {
                monitor.leggTil(s);
            }
        }
        monitor.ferdigLeting();
    }

}

class Resultat implements Runnable { // consumer
    Monitor monitor;

    public Resultat(Monitor monitor) {
        this.monitor = monitor;
    }

    public void run() {
        while (monitor.hentNeste() != null) {
            System.out.println(monitor.hentNeste());
        }
    }
}
























