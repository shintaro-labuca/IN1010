import java.io.FileNotFoundException;

public class Lesetråd implements Runnable {
    private String filnavn;
    private Monitor monitor;

    public Lesetråd(String filnavn, Monitor monitor) {
        this.filnavn = filnavn;
        this.monitor = monitor;
    }


    public void run() {
        try {
            Frekvenstabell f = Monitor.les(filnavn);
            monitor.settInn(f);
        } catch (FileNotFoundException e) {
            System.out.println("Filen finnes ikke:" + filnavn);
        }
    }
}
