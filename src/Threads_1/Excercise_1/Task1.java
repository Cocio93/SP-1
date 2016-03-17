package Threads_1.Excercise_1;

/**
 *
 * @author Jonathan Henriksen
 */
public class Task1 implements Runnable {
    private long sum = 0;
    private boolean keepRunning = true;

    public void stopThread() {
        keepRunning = false;
    }

    @Override
    public void run() {
        sum = 0;
        for (int i = 0; i < 1000000000; i++) {
            sum += i;
        }
        System.out.println("Task1: " + sum);
    }
}
