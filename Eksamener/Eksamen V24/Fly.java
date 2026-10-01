abstract class Fly implements Motordrevet {
    String id;
    int antMotor;
    int MTOW;
    int trekkraft;
    Fly neste;

    public Fly(int MTOW, int antMotor, int trekkraft, String id) {
        this.MTOW = MTOW;
        this.antMotor = antMotor;
        this.trekkraft = trekkraft;
        this.id = id;
    }

    public String hentId() {
        return id;
    }

    public int hentMotorAntall() {
        return antMotor;
    }

    public int hentMTOW() {
        return MTOW;
    }

    public int trekkraft() {
        return trekkraft;
    }

}
