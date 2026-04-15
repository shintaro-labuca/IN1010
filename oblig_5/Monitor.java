import java.io.FileNotFoundException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.ArrayList;

public class Monitor {
    private Subsekvensregister register;
    private Lock lås = new ReentrantLock(true);
    private Condition nokTabeller = lås.newCondition();


    public Monitor() {
        register = new Subsekvensregister();
    }

    public void settInn(Frekvenstabell f) {
        lås.lock();
        try {
            register.settInn(f);
        } finally {
            lås.unlock();
            nokTabeller.signalAll();
        }
    }

    public Frekvenstabell taUt() {
        lås.lock();
        Frekvenstabell tabell = null;
        try {
           tabell = register.taUt();
        } finally {
            lås.unlock();
        }
        return tabell;
    }


    public int antall() {
        lås.lock();
        int antall = 0;
        try {
            antall = register.antall();
        } finally {
            lås.unlock();
        }
        return antall;
    }

    public static Frekvenstabell les(String filnavn) throws FileNotFoundException {
        Frekvenstabell tabell = Subsekvensregister.les(filnavn);
        return tabell;
    }

    public ArrayList<Frekvenstabell> taUtTo() {
        ArrayList<Frekvenstabell> toTabeller = new ArrayList<>();
        lås.lock();
        try {
            while (register.antall() < 2) {
                try {
                    nokTabeller.await();
                } catch (InterruptedException e) {
                    System.out.println("Feil.");
                    System.exit(1);
                } 
            }
            Frekvenstabell f1 = register.taUt();
            Frekvenstabell f2 = register.taUt();
            toTabeller.add(f2);
            toTabeller.add(f1);
        } finally {
            lås.unlock();
        }
        return toTabeller;
    }
}