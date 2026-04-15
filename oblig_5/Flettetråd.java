import java.util.ArrayList;

public class Flettetråd implements Runnable {
    private Monitor monitor;

    public Flettetråd(Monitor monitor) {
        this.monitor = monitor;
    }

    public void run() {
        while (monitor.antall() > 1) {
            ArrayList<Frekvenstabell> toTabeller = monitor.taUtTo();
            Frekvenstabell flettet = Frekvenstabell.flett(toTabeller.get(0), toTabeller.get(1));
            monitor.settInn(flettet);
        }
    }
}
