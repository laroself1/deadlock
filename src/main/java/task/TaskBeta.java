package task;

import resource.BlueResource;
import resource.RedResource;

public class TaskBeta implements Runnable {
    private final BlueResource blueResource;
    private final RedResource redResource;

    public TaskBeta(BlueResource blueResource, RedResource redResource) {
        this.blueResource = blueResource;
        this.redResource = redResource;
    }

    @Override
    public void run() {
        System.out.println("Beta starts to enter red");
        synchronized (redResource) {
            System.out.println("Beta enters red");
            System.out.println("Beta starts to enter blue");
            synchronized (blueResource) {
                System.out.println("Beta enters blue");
            }
        }
    }
}
