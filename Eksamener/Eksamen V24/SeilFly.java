public class SeilFly extends Fly {
    int synkehastighet;
    
    public SeilFly(int MTOW, int antMotor, int trekkraft, String id, int synkehastighet) {
        super(MTOW, antMotor, trekkraft, id);
        this.synkehastighet = synkehastighet;
    }
}
