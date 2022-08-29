package alert;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class DeadlockAlertScheduler {
    private final Timer timer = new Timer("Deadlock alert Timer");

    public void scheduleOn(Date alertTime) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Deadlock probably occurred. Tasks had to be finished till now");
            }
        }, alertTime);
    }
}
