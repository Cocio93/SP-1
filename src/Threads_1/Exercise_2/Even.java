package Threads_1.Exercise_2;

/**
 *
 * @author Jonathan Henriksen
 */
public class Even {

    private int n = 0;

    public synchronized int next() {
        n++;
        n++;
        return n;
    }
}

