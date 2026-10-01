public class Pilot implements Runnable {
    Rullebane rullebane;
    Fly fly;

    public Pilot(Rullebane rullebane, Fly fly) {
        this.rullebane = rullebane;
        this.fly = fly;
    }

    public void run() {
        rullebane.hentStartTillatelse(fly);
    }
}
