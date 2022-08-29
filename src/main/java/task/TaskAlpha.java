package task;

import resource.BlueResource;
import resource.RedResource;

public class TaskAlpha implements Runnable {
    private final BlueResource blueResource;
    private final RedResource redResource;

    public TaskAlpha(BlueResource blueResource, RedResource redResource) {
        this.blueResource = blueResource;
        this.redResource = redResource;
    }

    @Override
    public void run() {
        System.out.println("Alpha tries to enter blue");
        synchronized (blueResource) {
            System.out.println("Alpha enters blue");
            executeComplicatedLogic();
            System.out.println("Alpha starts to enter red");
            synchronized (redResource) {
                System.out.println("Alpha enters red");
            }
        }
    }

    private void executeComplicatedLogic() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
