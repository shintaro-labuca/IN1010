public class Flygeleder implements Runnable {
    Rullebane rullebane;
    
    public Flygeleder(Rullebane rullebane) {
        this.rullebane = rullebane;
    }

    @Override
    public void run() {
        while (true) {
            rullebane.sjekkAvganger();
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
