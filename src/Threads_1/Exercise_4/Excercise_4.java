package Threads_1.Exercise_4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Jonathan Henriksen
 */
public class Excercise_4 {
    private static final int NUMBER_OF_TURNSTILES = 40;
    
    private static Turnstile[] turnstiles = new Turnstile[NUMBER_OF_TURNSTILES];

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        for (int i = 0; i < NUMBER_OF_TURNSTILES; i++) {
            turnstiles[i] = new Turnstile(counter);
        }
        
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < NUMBER_OF_TURNSTILES; i++) {
            es.execute(turnstiles[i]);
        }
        es.shutdown();
        es.awaitTermination(10, TimeUnit.SECONDS);
        System.out.print("Finished with ");
        System.out.println(counter.getValue());
    }
}
