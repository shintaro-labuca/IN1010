public class LasteFly extends MotorFly {
    int maksLast;
    
    public LasteFly(int MTOW, int antMotor, int trekkraft, String id, int maksLast) {
        super(MTOW, antMotor, trekkraft, id);
        this.maksLast = maksLast;
    }
}
