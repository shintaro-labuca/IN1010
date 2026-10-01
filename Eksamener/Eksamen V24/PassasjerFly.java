public class PassasjerFly extends MotorFly {
    int maksPassasjerer;

    public PassasjerFly(int MTOW, int antMotor, int trekkraft, String id, int maksPassasjerer) {
        super(MTOW, antMotor, trekkraft, id);
        this.maksPassasjerer = maksPassasjerer;
    }
}
