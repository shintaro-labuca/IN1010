import java.util.concurrent.locks.*;
import java.util.ArrayList;

public class Rullebane {
    ReentrantLock lås = new ReentrantLock();
    Condition avventStartTillatelse = lås.newCondition();
    ArrayList<Fly> venterPåÅFly = new ArrayList<>();
    Condition avventFly = lås.newCondition();

    public Rullebane() {
;
    }

    public void sjekkAvganger() {
        lås.lock();
        try {
            if (venterPåÅFly.isEmpty()) {
                return;
            }
            avventStartTillatelse.signal();
            venterPåÅFly.remove(0);
        } finally {
            lås.unlock();
        }
    }

    public void hentStartTillatelse(Fly fly) {
        lås.lock();
        try {
                venterPåÅFly.add(fly);
                avventFly.signalAll();
                avventStartTillatelse.await();
            } catch (InterruptedException e) {
                return;
            } finally {
            lås.unlock();
            }
    }

    public void sjekkAvganger5d() {
        lås.lock();
        try {
            while (venterPåÅFly.isEmpty()) {
                avventFly.await();
            }
        } catch (InterruptedException e){
            return;
        } finally {
            lås.unlock();
        }
    }


}
