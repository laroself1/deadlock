import alert.DeadlockAlertScheduler;
import resource.BlueResource;
import resource.RedResource;
import task.TaskAlpha;
import task.TaskBeta;

import java.time.Duration;
import java.util.Date;

class DeadlockDemo {
    private static final DeadlockAlertScheduler DEADLOCK_ALERT_SCHEDULER = new DeadlockAlertScheduler();

    private static final BlueResource BLUE_RESOURCE = new BlueResource();
    private static final RedResource RED_RESOURCE = new RedResource();

    public static void main(String[] args) {
        TaskAlpha taskAlpha = new TaskAlpha(BLUE_RESOURCE, RED_RESOURCE);
        TaskBeta taskBeta = new TaskBeta(BLUE_RESOURCE, RED_RESOURCE);

        DEADLOCK_ALERT_SCHEDULER.scheduleOn(new Date(getDeadlockAlertTime()));

        new Thread(taskAlpha).start();
        new Thread(taskBeta).start();
    }

    private static long getDeadlockAlertTime() {
        return System.currentTimeMillis() + Duration.ofSeconds(7).toMillis();
    }
}