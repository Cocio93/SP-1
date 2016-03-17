/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads_1.Excercise_4;

/**
 *
 * @author Jonathan Henriksen
 */
public class Turnstile implements Runnable {

    private final Counter counter;
    private int count;
    final int COUNT_MAX = 1000;

    Turnstile(Counter counter) {
        this.counter = counter;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void run() {
        for (int i = 0; i < COUNT_MAX; i++) {
            counter.incr();
            count++;
        }
    }

}
